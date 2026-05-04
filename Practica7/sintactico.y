%{
#include <stdio.h>
#include <stdlib.h>

extern FILE *yyin;
extern FILE *yyout;

int yylex();
void yyerror(const char *s);
%}

%token IF THEN ELSE FOR WHILE SWITCH CASE DEFAULT BREAK
%token INT FLOAT CHAR
%token PRINTF SYSTEM OUT PRINTLN
%token ID NUM STRING CHARLIT
%token RELOP
%nonassoc THEN
%nonassoc ELSE

%%

programa:
    lista_sentencias
    ;

lista_sentencias:
    lista_sentencias sentencia
    | sentencia
    ;

sentencia:
      declaracion
    | asignacion
    | if_stmt
    | while_stmt
    | for_stmt
    | switch_stmt
    | print_stmt
    ;

declaracion:
    tipo ID ';'
    ;

tipo:
      INT
    | FLOAT
    | CHAR
    ;

asignacion:
    ID '=' NUM ';'
    ;

if_stmt:
    IF '(' condicion ')' THEN bloque
    | IF '(' condicion ')' THEN bloque ELSE bloque
    ;

while_stmt:
    WHILE '(' condicion ')' bloque
    ;

for_stmt:
    FOR '(' asignacion condicion ';' asignacion ')' bloque
    ;

switch_stmt:
    SWITCH '(' ID ')' '{' lista_casos '}'
    ;

lista_casos:
    lista_casos caso
    | caso
    ;

caso:
      CASE NUM ':' lista_sentencias BREAK ';'
    | DEFAULT ':' lista_sentencias
    ;

print_stmt:
      PRINTF '(' STRING ')' ';'
    | SYSTEM '.' OUT '.' PRINTLN '(' STRING ')' ';'
    ;

condicion:
    ID RELOP ID
    ;

bloque:
    '{' lista_sentencias '}'
    | sentencia
    ;

%%

void yyerror(const char *s) {
    if (yyout) {
        fprintf(yyout, "Error sintáctico: %s\n", s);
    }
}


int main(int argc, char *argv[]) {

    FILE *archivo1, *archivo2;

    //Borrar resultado previo
    yyout = fopen("D:\\Flex Windows\\EditPlusPortable\\Practica7\\resultado.txt", "w");
    if (!yyout) {
        perror("Error al abrir archivo de salida");
        return 1;
    }

    //Correcto
    archivo1 = fopen("D:\\Flex Windows\\EditPlusPortable\\Practica7\\sintactico_correcto.txt", "r");
    if (!archivo1) {
        perror("Error al abrir archivo correcto");
        return 1;
    }

    yyin = archivo1;

    fprintf(yyout, "Analizando archivo CORRECTO:\n");

    if (yyparse() == 0) {
        printf("Archivo correcto: OK\n");
        fprintf(yyout, "Análisis sintáctico correcto.\n\n");
    } else {
        printf("Archivo correcto: ERROR\n");
        fprintf(yyout, "Análisis sintáctico con errores.\n\n");
    }

    fclose(archivo1);

   
    yyrestart(NULL);

    //Archivo incorrecto
    archivo2 = fopen("D:\\Flex Windows\\EditPlusPortable\\Practica7\\sintactico_incorrecto.txt", "r");
    if (!archivo2) {
        perror("Error al abrir archivo incorrecto");
        return 1;
    }

    yyin = archivo2;

    fprintf(yyout, "Analizando archivo INCORRECTO:\n");

    if (yyparse() == 0) {
        printf("Archivo incorrecto: OK\n");
        fprintf(yyout, "Análisis sintáctico correcto.\n");
    } else {
        printf("Archivo incorrecto: ERROR\n");
        fprintf(yyout, "Análisis sintáctico con errores.\n");
    }

    fclose(archivo2);
    fclose(yyout);

    return 0;
}