%option noyywrap
%{
	#include<stdio.h> 

%}

%%

[a-zA-Z][a-zA-Z0-9_]*           { printf("TOKEN_IDENTIFICADOR=%s\n", yytext); }
.+                              { printf("Token de identificador no detectado: %s\n", yytext); }

%%

int main()
{
	yylex();
	return 0;
}