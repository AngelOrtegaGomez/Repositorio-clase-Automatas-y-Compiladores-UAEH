%option noyywrap
%{
	#include<stdio.h> 

%}

%%


[a-zA-Z]([a-zA-Z0-9])*    { fprintf(yyout, "TOKEN_ID=%s\n", yytext); }
[0-9]+                  { fprintf(yyout, "TOKEN_NUMERO=%s\n", yytext); }

%%

int main()
{
yyin = fopen("D:\\Flex Windows\\EditPlusPortable\\archivoEntrada.txt","r");
yyout = fopen("D:\\Flex Windows\\EditPlusPortable\\archivoSalida.txt","w");

yylex();

fclose(yyin);
fclose(yyout);

return 0;
}