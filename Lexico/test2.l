%option noyywrap
%{
	#include<stdio.h> 

%}

%%

[0-9]+"."[0-9]+         { printf("TOKEN_DECIMAL=%s\n", yytext); }
.+                      { printf("Token de numero decimal no detectado: %s\n", yytext); }

%%

int main()
{
	yylex();
	return 0;
}