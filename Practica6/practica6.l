%{
#include "y.tab.h"
#include <stdio.h>
#include <stdlib.h>
%}

%%

[0-9]+\.[0-9]+      { yylval.floatval = atof(yytext); return DECIMAL; }
[0-9]+              { yylval.intval = atoi(yytext); return NUM; }

"+"                 { return PLUS; }
"-"                 { return MINUS; }
"*"                 { return MULT; }
"/"                 { return DIV; }

">="                { return MAYOR_IGUAL; }
"<="                { return MENOR_IGUAL; }
"=="                { return IGUAL; }
"!="                { return DIFERENTE; }
">"                 { return MAYOR; }
"<"                 { return MENOR; }

"("                 { return PAR_IZQ; }
")"                 { return PAR_DER; }

[a-zA-Z_][a-zA-Z0-9_]* { return ID; }

\n                  { return EOL; }
[ \t\r]+            ;
.                   { printf("Error lexico: %s\n", yytext); }

%%

int yywrap(void) { return 1; }