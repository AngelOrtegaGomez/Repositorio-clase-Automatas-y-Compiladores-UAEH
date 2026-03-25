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