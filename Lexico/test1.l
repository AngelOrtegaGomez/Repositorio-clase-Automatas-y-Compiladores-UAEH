%option noyywrap
%{
	#include<stdio.h> 

%}

%%

[0-9]+                  { printf("TOKEN_NUMERO=%s\n", yytext); }
.+                      { printf("Token de numero entero no detectado: %s\n", yytext); }

%%

int main()
{
	yylex();
	return 0;
}