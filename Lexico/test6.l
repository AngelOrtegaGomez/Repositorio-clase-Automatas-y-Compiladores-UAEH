%option noyywrap
%{
	#include<stdio.h> 

%}

%%

[a-z]{2}[0-9]{6}+@uaeh\.edu\.mx           { printf("TOKEN_CORREO=%s\n", yytext); }
.+                              { printf("Token de correo institucional no detectado: %s\n", yytext); }

%%

int main()
{
	yylex();
	return 0;
}