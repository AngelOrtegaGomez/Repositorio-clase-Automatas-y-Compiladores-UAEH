%option noyywrap
%{
	#include<stdio.h> 

%}

%%

[A-Z][AEIOU][A-Z]{2}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[12][0-9]|3[01])|(04|06|09|11)(0[1-9]|[12][0-9]|30)|(02)(0[1-9]|1[0-9]|2[0-8]))[A-Z0-9]{3}        { printf("TOKEN_RFC=%s\n", yytext); }
.+                              { printf("Token de RFC no detectado: %s\n", yytext); }

%%

int main()
{
	yylex();
	return 0;
}