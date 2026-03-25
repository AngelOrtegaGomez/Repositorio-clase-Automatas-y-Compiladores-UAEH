#include <iostream>
using namespace std;

// Comentario de una línea

/* Comentario
de bloque */

int main() {
// Variables
int a = 10;
float b = 3.14;
double c = 2.5e3;
char letra = 'A';
string texto = "Hola mundo";


// Números en diferentes bases
int hex = 0x1A;
int bin = 0b1010;
int oct = 077;

// Operadores
a++;
b += 2.0;
if (a > 5 && b <= 10) {
    cout << "Condición verdadera" << endl;
} else {
    cout << "Condición falsa" << endl;
}

// Separadores y más operadores
for (int i = 0; i < 5; i++) {
    cout << i << endl;
}

// Pruebas de errores
string error1 = "cadena sin cerrar;
char error2 = 'X;
int raro = @123;

return 0;

\\\

}