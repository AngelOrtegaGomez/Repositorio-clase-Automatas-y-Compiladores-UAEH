# Analizador Léxico para C++ usando Flex

## Introducción

En esta práctica se desarrolló un analizador léxico para el lenguaje de programación C++ utilizando la herramienta Flex. Un analizador léxico es la primera fase de un compilador, y su función principal es leer el código fuente y convertirlo en una secuencia de tokens que representan los elementos básicos del lenguaje.

El programa implementado es capaz de leer un archivo de entrada con código en C++ y generar un archivo de salida donde se identifican y clasifican los diferentes tipos de tokens encontrados.

---

## Objetivo

Desarrollar un analizador léxico que permita identificar los principales componentes del lenguaje C++, tales como palabras reservadas, identificadores, números, operadores, separadores y comentarios.

---

## Descripción del problema

Se requiere construir un analizador léxico que procese un archivo de código fuente en C++ (por ejemplo, `codigo.cpp`) y genere un archivo de salida (`MyScanner.txt`) donde se muestre cada token identificado junto con su tipo y número de línea.

El analizador debe reconocer los siguientes elementos:

- Palabras reservadas
- Identificadores
- Números enteros
- Números flotantes
- Números hexadecimales, binarios y octales
- Cadenas de caracteres
- Caracteres individuales
- Operadores
- Separadores
- Comentarios de una línea
- Comentarios de bloque

---

## Herramientas utilizadas

- Flex (Fast Lexical Analyzer Generator)
- Lenguaje C y C++

---

## Estructura del analizador léxico

El archivo de Flex se divide en tres secciones principales:

### 1. Sección de definiciones

En esta parte se declaran las librerías, variables globales y expresiones regulares que describen los diferentes tipos de tokens.

Se definen patrones para:

- Espacios en blanco
- Literales de cadena y carácter
- Números en diferentes formatos
- Comentarios
- Operadores y separadores
- Palabras reservadas e identificadores

```bnf
%{
#include <stdio.h>
#include <stdlib.h>

FILE *output;
int line = 1;
%}

%option noyywrap

/* DEFINICIONES */
WHITESPACE     [ \t\r\n]+

STRINGLIT      \"([^\"\\]|\\.)*\"
CHARLIT        \'([^\'\\]|\\.)\'

FLOATLIT ([0-9]+\.[0-9]+([eE][+-]?[0-9]+)?)|([0-9]+[eE][+-]?[0-9]+)
HEXLIT         0[xX][0-9a-fA-F]+
BINARYLIT      0[bB][01]+
OCTALLIT       0[0-7]+
INTEGERLIT     [0-9]+

LINECOMMENT    "//".*
BLOCKCOMMENT   "/*"(.|\n)*"*/"

OPERATOR       "=="|"!="|"<="|">="|"&&"|"||"|"<<"|">>"|"++"|"--"|"+="|"-="|"*="|"/="|"%="|"->"|"::"|[+\-*/%<>=!&|^~?:]

SEPARATOR      [(){}\[\];,.:]

KEYWORD        "int"|"float"|"double"|"char"|"if"|"else"|"while"|"for"|"return"|"class"|"public"|"private"|"static"|"void"|"new"|"true"|"false"|"nullptr"|"using"|"namespace"

ID             [a-zA-Z_][a-zA-Z0-9_]*
```

---

### 2. Reglas léxicas

En esta sección se especifica qué acción se debe realizar cuando se reconoce un patrón.

Cada vez que se detecta un token, se imprime en el archivo de salida con el formato:

<p style="text-align:center;">[Línea] TIPO: valor</p>

También se lleva un control del número de línea, incrementándolo cada vez que se encuentra un salto de línea.

```bnf
%%

{WHITESPACE} {
    int i;
    for (i = 0; yytext[i]; i++)
        if (yytext[i] == '\n') line++;
}

"#".* {
    fprintf(output, "[L%d] PREPROCESSOR: %s\n", line, yytext);
}

{LINECOMMENT} {
    fprintf(output, "[L%d] LINE_COMMENT: %s\n", line, yytext);
}

{BLOCKCOMMENT} {
    int i;
    for (i = 0; yytext[i]; i++)
        if (yytext[i] == '\n') line++;

    fprintf(output, "[L%d] BLOCK_COMMENT: %s\n", line, yytext);
}

{STRINGLIT} {
    int i;
    for (i = 0; yytext[i]; i++)
        if (yytext[i] == '\n') line++;

    fprintf(output, "[L%d] STRING: %s\n", line, yytext);
}

{CHARLIT} {
    fprintf(output, "[L%d] CHAR: %s\n", line, yytext);
}

{FLOATLIT} {
    fprintf(output, "[L%d] FLOAT: %s\n", line, yytext);
}

{HEXLIT} {
    fprintf(output, "[L%d] HEX: %s\n", line, yytext);
}

{BINARYLIT} {
    fprintf(output, "[L%d] BINARY: %s\n", line, yytext);
}

{OCTALLIT} {
    fprintf(output, "[L%d] OCTAL: %s\n", line, yytext);
}

{INTEGERLIT} {
    fprintf(output, "[L%d] INTEGER: %s\n", line, yytext);
}

{KEYWORD} {
    fprintf(output, "[L%d] KEYWORD: %s\n", line, yytext);
}

{ID} {
    fprintf(output, "[L%d] IDENTIFIER: %s\n", line, yytext);
}

{OPERATOR} {
    fprintf(output, "[L%d] OPERATOR: %s\n", line, yytext);
}

{SEPARATOR} {
    fprintf(output, "[L%d] SEPARATOR: %s\n", line, yytext);
}

. {
    fprintf(output, "[L%d] ERROR: %s\n", line, yytext);
}

%%
```

---

### 3. Función principal

La función `main` se encarga de:

- Abrir el archivo de entrada (`codigo.cpp`)
- Crear el archivo de salida (`MyScanner.txt`)
- Ejecutar el analizador léxico con `yylex()`
- Cerrar los archivos

```bnf
int main() {

    FILE *input = fopen("D:\\Flex Windows\\EditPlusPortable\\codigo.cpp", "r");

    if (!input) {
        printf("No se pudo abrir el archivo\n");
        return 1;
    }

    output = fopen("D:\\Flex Windows\\EditPlusPortable\\MyScanner.txt", "w");

    yyin = input;
    yylex();

    fclose(input);
    fclose(output);

    return 0;
}
```

---

## Funcionamiento del programa

El programa toma como entrada un archivo de código en C++ y lo analiza carácter por carácter. A medida que reconoce patrones definidos, clasifica cada elemento como un token específico.

Por ejemplo:

- `int` → palabra reservada
- `x` → identificador
- `10` → número entero
- `"Hola"` → cadena
- `// comentario` → comentario de línea

El resultado se guarda en un archivo de texto donde se puede observar claramente cada token detectado.

<p align="center">
  <img width="1905" height="915" alt="image" src="https://github.com/user-attachments/assets/3bc49e2c-f7c0-44a0-b487-829cb763f408" />
  <br />
  <em>Imagen 1: Archivo de entrada codigo.cpp</em>
</p>

<p align="center">
  <img width="1394" height="651" alt="image" src="https://github.com/user-attachments/assets/8d095ea6-eb6c-4473-a005-7ecdb7149f27" />
  <br />
  <em>Imagen 2: Archivo de salida MyScanner.txt</em>
</p>


---

## Resultados

El analizador funcionó correctamente, identificando todos los tipos de tokens solicitados. Se logró distinguir entre diferentes tipos de números, reconocer comentarios y clasificar adecuadamente operadores y separadores.

Además, el sistema muestra el número de línea en el que se encuentra cada token, lo cual es útil para análisis posteriores o detección de errores.

### Entrada

```bnf
#include <iostream>
using namespace std;

// Comentario de una línea

/* Comentario
de bloque */

int main() {
// Variables
int a = 10;
float b = 3.14;
double c = 2.5e3;
char letra = 'A';
string texto = "Hola mundo";


// Números en diferentes bases
int hex = 0x1A;
int bin = 0b1010;
int oct = 077;

// Operadores
a++;
b += 2.0;
if (a > 5 && b <= 10) {
    cout << "Condición verdadera" << endl;
} else {
    cout << "Condición falsa" << endl;
}

// Separadores y más operadores
for (int i = 0; i < 5; i++) {
    cout << i << endl;
}

// Pruebas de errores
string error1 = "cadena sin cerrar;
char error2 = 'X;
int raro = @123;

return 0;

\\\

}
```

### Salida

```bnf
[L1] PREPROCESSOR: #include <iostream>
[L2] KEYWORD: using
[L2] KEYWORD: namespace
[L2] IDENTIFIER: std
[L2] SEPARATOR: ;
[L4] LINE_COMMENT: // Comentario de una línea
[L7] BLOCK_COMMENT: /* Comentario
de bloque */
[L9] KEYWORD: int
[L9] IDENTIFIER: main
[L9] SEPARATOR: (
[L9] SEPARATOR: )
[L9] SEPARATOR: {
[L10] LINE_COMMENT: // Variables
[L11] KEYWORD: int
[L11] IDENTIFIER: a
[L11] OPERATOR: =
[L11] INTEGER: 10
[L11] SEPARATOR: ;
[L12] KEYWORD: float
[L12] IDENTIFIER: b
[L12] OPERATOR: =
[L12] FLOAT: 3.14
[L12] SEPARATOR: ;
[L13] KEYWORD: double
[L13] IDENTIFIER: c
[L13] OPERATOR: =
[L13] FLOAT: 2.5e3
[L13] SEPARATOR: ;
[L14] KEYWORD: char
[L14] IDENTIFIER: letra
[L14] OPERATOR: =
[L14] CHAR: 'A'
[L14] SEPARATOR: ;
[L15] IDENTIFIER: string
[L15] IDENTIFIER: texto
[L15] OPERATOR: =
[L15] STRING: "Hola mundo"
[L15] SEPARATOR: ;
[L18] LINE_COMMENT: // Números en diferentes bases
[L19] KEYWORD: int
[L19] IDENTIFIER: hex
[L19] OPERATOR: =
[L19] HEX: 0x1A
[L19] SEPARATOR: ;
[L20] KEYWORD: int
[L20] IDENTIFIER: bin
[L20] OPERATOR: =
[L20] BINARY: 0b1010
[L20] SEPARATOR: ;
[L21] KEYWORD: int
[L21] IDENTIFIER: oct
[L21] OPERATOR: =
[L21] OCTAL: 077
[L21] SEPARATOR: ;
[L23] LINE_COMMENT: // Operadores
[L24] IDENTIFIER: a
[L24] OPERATOR: ++
[L24] SEPARATOR: ;
[L25] IDENTIFIER: b
[L25] OPERATOR: +=
[L25] FLOAT: 2.0
[L25] SEPARATOR: ;
[L26] KEYWORD: if
[L26] SEPARATOR: (
[L26] IDENTIFIER: a
[L26] OPERATOR: >
[L26] INTEGER: 5
[L26] OPERATOR: &&
[L26] IDENTIFIER: b
[L26] OPERATOR: <=
[L26] INTEGER: 10
[L26] SEPARATOR: )
[L26] SEPARATOR: {
[L27] IDENTIFIER: cout
[L27] OPERATOR: <<
[L27] STRING: "Condición verdadera"
[L27] OPERATOR: <<
[L27] IDENTIFIER: endl
[L27] SEPARATOR: ;
[L28] SEPARATOR: }
[L28] KEYWORD: else
[L28] SEPARATOR: {
[L29] IDENTIFIER: cout
[L29] OPERATOR: <<
[L29] STRING: "Condición falsa"
[L29] OPERATOR: <<
[L29] IDENTIFIER: endl
[L29] SEPARATOR: ;
[L30] SEPARATOR: }
[L32] LINE_COMMENT: // Separadores y más operadores
[L33] KEYWORD: for
[L33] SEPARATOR: (
[L33] KEYWORD: int
[L33] IDENTIFIER: i
[L33] OPERATOR: =
[L33] INTEGER: 0
[L33] SEPARATOR: ;
[L33] IDENTIFIER: i
[L33] OPERATOR: <
[L33] INTEGER: 5
[L33] SEPARATOR: ;
[L33] IDENTIFIER: i
[L33] OPERATOR: ++
[L33] SEPARATOR: )
[L33] SEPARATOR: {
[L34] IDENTIFIER: cout
[L34] OPERATOR: <<
[L34] IDENTIFIER: i
[L34] OPERATOR: <<
[L34] IDENTIFIER: endl
[L34] SEPARATOR: ;
[L35] SEPARATOR: }
[L37] LINE_COMMENT: // Pruebas de errores
[L38] IDENTIFIER: string
[L38] IDENTIFIER: error1
[L38] OPERATOR: =
[L38] ERROR: "
[L38] IDENTIFIER: cadena
[L38] IDENTIFIER: sin
[L38] IDENTIFIER: cerrar
[L38] SEPARATOR: ;
[L39] KEYWORD: char
[L39] IDENTIFIER: error2
[L39] OPERATOR: =
[L39] ERROR: '
[L39] IDENTIFIER: X
[L39] SEPARATOR: ;
[L40] KEYWORD: int
[L40] IDENTIFIER: raro
[L40] OPERATOR: =
[L40] ERROR: @
[L40] INTEGER: 123
[L40] SEPARATOR: ;
[L42] KEYWORD: return
[L42] INTEGER: 0
[L42] SEPARATOR: ;
[L44] ERROR: \
[L44] ERROR: \
[L44] ERROR: \
[L46] SEPARATOR: }
```

---

## Conclusiones

Esta práctica permitió comprender mejor el funcionamiento interno de un compilador, específicamente en su fase de análisis léxico. El uso de Flex facilita la construcción de analizadores al permitir definir patrones mediante expresiones regulares.

También se observó la importancia del orden de las reglas, ya que algunos patrones pueden coincidir entre sí, como es el caso de palabras reservadas e identificadores.

Finalmente, el desarrollo de este programa refuerza el entendimiento de cómo los lenguajes de programación son procesados internamente antes de su ejecución.

---
