%option noyywrap

%{
    #include <stdio.h>
    #include "y.tab.h"
%}

DIGITO      [0-9]
LETRA       [a-zA-Z]
ID          [a-zA-Z_][a-zA-Z0-9_]*

INTEGERLIT  0|[1-9][0-9_]*
FLOATLIT    [0-9][0-9_]*\.[0-9][0-9_]*([eE][+-]?[0-9]+)?

HEXADECIMALLIT   0[xX][0-9a-fA-F][0-9a-fA-F_]*
BINARYLIT        0[bB][01][01_]*
OCTALLIT         0[0-7]+

STRINGLIT   \"([^\"\\]|\\.)*\"
CHARLIT     \'([^\'\\]|\\.)\'

SIMPLEOP     [+\-*/%<>!&\|^~?]

LINECOMMENT   "//".*
BLOCKCOMMENT  "/*"([^*]|\*+[^*/])*\*+\/

RELOP   "=="|"!="|"<="|">="|"<"|">"

%%


"if"        { return IF; }
"then"      { return THEN; }
"else"      { return ELSE; }

"for"       { return FOR; }
"while"     { return WHILE; }

"switch"    { return SWITCH; }
"case"      { return CASE; }
"default"   { return DEFAULT; }
"break"     { return BREAK; }

"int"       { return INT; }
"float"     { return FLOAT; }
"char"      { return CHAR; }

"printf"    { return PRINTF; }


"System"    { return SYSTEM; }
"out"       { return OUT; }
"println"   { return PRINTLN; }



{INTEGERLIT}     { return NUM; }
{FLOATLIT}       { return NUM; }
{HEXADECIMALLIT} { return NUM; }
{BINARYLIT}      { return NUM; }
{OCTALLIT}       { return NUM; }

{STRINGLIT}      { return STRING; }
{CHARLIT}        { return CHARLIT; }


{RELOP}          { return RELOP; }
{SIMPLEOP}       { return yytext[0]; }

"("     { return '('; }
")"     { return ')'; }
"{"     { return '{'; }
"}"     { return '}'; }
";"     { return ';'; }
","     { return ','; }
":"     { return ':'; }
"."     { return '.'; }
"="     { return '='; }

{ID}             { return ID; }

{LINECOMMENT}    { }
{BLOCKCOMMENT}   { }

[ \t\n]+         { }

. {
    printf("Error léxico: %s\n", yytext);
}

%%