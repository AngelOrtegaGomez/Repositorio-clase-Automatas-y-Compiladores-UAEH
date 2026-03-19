package analisislex;

import java.util.regex.*;
import java.util.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

/**
 *
 * @author angel
 */
public class JavaLexer {

    // Tipos de token
    enum TokenType {
        JAVADOC, BLOCKCOMMENT, LINECOMMENT, STRINGLIT, CHARLIT, FLOATLIT, HEXADECIMALLIT, BINARYLIT, OCTALLIT, INTEGERLIT, KEYWORD,
        ANNOTATION, IDENTIFIER, OPERATOR, SEPARATOR, WHITESPACE, UNKNOWN
    }

    // Record para representar un Token (Java 16+)
    record Token(TokenType type, String lexeme, int line, int column) {

        public String toString() {
            return String.format("[L%-3d, C%-3d] %-14s --> \"%s\"", line, column, type, lexeme);
        }
    }

    public static class LexicalError extends RuntimeException {

        private final int line, column;
        private final char illegal;

        public LexicalError(char c, int line, int col) {
            super(String.format(
                    "Error léxico [línea %d, col %d]: carácter ilegal '%c' (U+%04X)",
                    line, col, c, (int) c
            ));
            this.line = line;
            this.column = col;
            this.illegal = c;
        }
    }

    // Patrón de keywords (todas las palabras reservadas de Java)
    static final String KW_PATTERN
            = "\\b(abstract|assert|boolean|break|byte|case|catch|char|"
            + "class|const|continue|default|do|double|else|enum|extends|"
            + "final|finally|float|for|if|implements|import|instanceof|"
            + "int|interface|long|new|package|private|protected|public|"
            + "return|short|static|super|switch|synchronized|this|throw|"
            + "throws|try|void|volatile|while|true|false|null)\\b";

    static final String OP_PATTERN = "==|!=|<=|>=|&&|\\|\\||<<|>>>|>>"
            + "|\\+\\+|--|\\+=|-=|\\*=|/=|%=|&=|\\|=|\\^=|<<=|>>=|"
            + "[+\\-*/%<>=!&|^~?:]";

    // Patrón MASTER con grupos nombrados
    static final Pattern MASTER = Pattern.compile(
            "(?<JAVADOC>/\\*\\*[\\s\\S]*?\\*/)|"
            + "(?<BLOCKCOMMENT>/\\*[\\s\\S]*?\\*/)|"
            + "(?<LINECOMMENT>//[^\\n]*)|"
            + "(?<STRINGLIT>\"([^\"\\\\]|\\\\.)*\")|"
            + "(?<CHARLIT>'([^'\\\\]|\\\\.)')|"
            + "(?<FLOATLIT>[0-9][0-9_]*\\.[0-9][0-9_]*([eE][+-]?[0-9]+)?[fFdD]?)|"
            + "(?<HEXADECIMALLIT>0[xX][0-9a-fA-F][0-9a-fA-F_]*[lL]?)|"
            + "(?<BINARYLIT>0[bB][01][01_]*[lL]?)|"
            + "(?<OCTALLIT>0[0-7]+[lL]?)|"
            + "(?<INTEGERLIT>0|[1-9][0-9_]*[lL]?)|"
            + "(?<KEYWORD>" + KW_PATTERN + ")|"
            + "(?<ANNOTATION>@[a-zA-Z_][a-zA-Z0-9_]*)|"
            + "(?<IDENTIFIER>" + "[a-zA-Z_$][a-zA-Z0-9_$]*" + ")|"
            + "(?<OPERATOR>" + OP_PATTERN + ")|"
            + "(?<SEPARATOR>" + "[(){}\\[\\];,.]" + ")|"
            + "(?<WHITESPACE>" + "[ \\t\\r\\n]+" + ")", Pattern.MULTILINE
    );

    // Método de Tokenización
    public static List<Token> tokenize(String source) {
        List<Token> tokens = new ArrayList<>();
        List<LexicalError> errors = new ArrayList<>();
        Matcher m = MASTER.matcher(source);
        int line = 1, column = 1, pos = 0;

        while (m.find()) {

            int start = m.start();

            // calcular columna basada en última nueva línea
            int lastNewLine = source.lastIndexOf('\n', start - 1);
            if (lastNewLine == -1) {
                column = start + 1;
            } else {
                column = start - lastNewLine;
            }
            // Detectar caracteres no reconocidos
            // En el tokenizador — estrategia PANIC RECOVERY:
            // Si queda texto sin consumir, avanzar 1 char, registrar el error y continuar.
            if (m.start() > pos) {
                String illegal = source.substring(pos, m.start());
                int col = pos - source.lastIndexOf('\n', pos);
                System.err.printf("Error léxico [L%d, C%d]: '%s'%n", line, col, illegal);
                errors.add(new LexicalError(illegal.charAt(0), line, col));
            }
            if (m.group("WHITESPACE") != null) {
                // Contar saltos de línea en el whitespace
                line += m.group("WHITESPACE").chars().filter(c -> c == '\n').count();
            } else if (m.group("JAVADOC") != null) {
                line += m.group().chars().filter(c -> c == '\n').count();
            } else if (m.group("BLOCKCOMMENT") != null) {
                line += m.group().chars().filter(c -> c == '\n').count();
            } else if (m.group("LINECOMMENT") != null) {
            } else if (m.group("STRINGLIT") != null) {
                tokens.add(new Token(TokenType.STRINGLIT, m.group(), line, column));
            } else if (m.group("CHARLIT") != null) {
                tokens.add(new Token(TokenType.CHARLIT, m.group(), line, column));
            } else if (m.group("FLOATLIT") != null) {
                tokens.add(new Token(TokenType.FLOATLIT, m.group(), line, column));
            } else if (m.group("HEXADECIMALLIT") != null) {
                tokens.add(new Token(TokenType.HEXADECIMALLIT, m.group(), line, column));
            } else if (m.group("BINARYLIT") != null) {
                tokens.add(new Token(TokenType.BINARYLIT, m.group(), line, column));
            } else if (m.group("OCTALLIT") != null) {
                tokens.add(new Token(TokenType.OCTALLIT, m.group(), line, column));
            } else if (m.group("INTEGERLIT") != null) {
                tokens.add(new Token(TokenType.INTEGERLIT, m.group(), line, column));
            } else if (m.group("KEYWORD") != null) {
                tokens.add(new Token(TokenType.KEYWORD, m.group(), line, column));
            } else if (m.group("ANNOTATION") != null) {
                tokens.add(new Token(TokenType.ANNOTATION, m.group(), line, column));
            } else if (m.group("IDENTIFIER") != null) {
                tokens.add(new Token(TokenType.IDENTIFIER, m.group(), line, column));
            } else if (m.group("OPERATOR") != null) {
                tokens.add(new Token(TokenType.OPERATOR, m.group(), line, column));
            } else if (m.group("SEPARATOR") != null) {
                tokens.add(new Token(TokenType.SEPARATOR, m.group(), line, column));
            }
            pos = m.end();
        }
        return tokens;
    }

    public static void main(String[] args) {
        try {
            // Ruta del archivo .java
            Path path = Path.of("Ejemplo.java");

            // Leer todo el archivo como String
            String source = Files.readString(path);

            // Tokenizar
            //tokenize(source).forEach(System.out::println);
            List<Token> tokens = tokenize(source);

            // Convertir todos los tokens a texto
            List<String> lineas = tokens.stream()
                    .map(Token::toString)
                    .toList();

            // Escribir en archivo
            Path salida = Path.of("salida.txt");
            Files.write(salida, lineas);

            System.out.println("Tokens guardados en salida.txt");

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
