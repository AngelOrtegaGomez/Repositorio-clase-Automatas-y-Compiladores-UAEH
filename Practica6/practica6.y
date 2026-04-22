%{
#include <stdio.h>
#include <stdlib.h>

int yylex();
int yyerror(const char *s);
%}

%union {
    int intval;
    float floatval;
    char *stringval;
}

%token <intval> NUM
%token <floatval> DECIMAL
%token <stringval> ID
%token NUMBER PLUS MINUS MULT DIV EOL
%token PAR_IZQ PAR_DER
%start statements

%left PLUS MINUS
%left MULT DIV

//NO se usan en operaciones aritmeticas
%token MAYOR_IGUAL MENOR_IGUAL IGUAL DIFERENTE MAYOR MENOR

%%

statements 
    : statement statements
    | statement
    ;

statement 
    : expression EOL { printf("Expresion valida\n"); }
    | error EOL { printf("Expresion invalida\n"); yyerrok; }
    ;

expression 
    : NUM
    | DECIMAL
    | ID
    | expression PLUS expression
    | expression MINUS expression
    | expression MULT expression
    | expression DIV expression
    | PAR_IZQ expression PAR_DER
    ;

%%

extern FILE *yyin;

int main(){
    printf("Practica 6: Analisis sintactico expresiones aritmeticas\n\n");

    printf("=== ARCHIVO CORRECTAS ===\n");
    yyin = fopen("D:\\Flex Windows\\EditPlusPortable\\ExpA_Correctas.txt", "r");

    if(yyin == NULL){
        printf("No se pudo abrir correctas.txt\n");
	system("pause");
        return 1;
    }

    yyparse();
    fclose(yyin);

    printf("\n=== ARCHIVO INCORRECTAS ===\n");
    yyin = fopen("D:\\Flex Windows\\EditPlusPortable\\ExpA_Incorrectas.txt", "r");

    if(yyin == NULL){
        printf("No se pudo abrir incorrectas.txt\n");
	system("pause");
        return 1;
    }

    yyparse();
    fclose(yyin);

    system("pause");
    return 0;
}

int yyerror(const char *s){
    return 0;
}