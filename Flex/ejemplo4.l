%option noyywrap
%{
	#include<stdio.h> 

%}

%%

[a-zA-Z]([a-zA-Z0-9])*    { printf("TOKEN_ID=%s\n", yytext); }
[0-9]+                  { printf("TOKEN_NUMERO=%s\n", yytext); }

%%

int main()
{
	yylex();
	return 0;
}
