# Errores y BNF en Compiladores

---

## Errores

En el contexto de los compiladores, el manejo de errores constituye una de las funciones más relevantes dentro del proceso de traducción de un lenguaje de programación. Un compilador no solo tiene la tarea de transformar el código fuente en un lenguaje objetivo, sino también la de identificar, reportar y, en ciertos casos, recuperarse de los errores presentes en el programa. Esta capacidad resulta esencial, ya que durante el desarrollo es común que los programas contengan múltiples fallos.

Los errores pueden clasificarse de acuerdo con la fase del compilador en la que se detectan. En primer lugar, se encuentran los errores léxicos, los cuales ocurren durante el análisis léxico. Estos se presentan cuando una secuencia de caracteres no puede ser reconocida como un token válido del lenguaje. Un ejemplo de ello es el uso de símbolos no permitidos o identificadores mal formados. Debido a que el análisis léxico se basa en patrones definidos, usualmente mediante expresiones regulares, este tipo de errores suele ser sencillo de detectar.

Posteriormente, durante el análisis sintáctico, se identifican los errores sintácticos. Estos ocurren cuando la secuencia de tokens no cumple con las reglas de la gramática del lenguaje. Por ejemplo, la omisión de un delimitador como un punto y coma o una estructura mal formada puede generar este tipo de error. El analizador sintáctico, apoyado en gramáticas formales, verifica la estructura del programa y señala inconsistencias en su organización.

En etapas más avanzadas aparecen los errores semánticos, los cuales están relacionados con el significado del programa. Estos incluyen problemas como el uso de variables no declaradas, incompatibilidad de tipos o la aplicación incorrecta de operadores. Su detección requiere información adicional, como tablas de símbolos, y un análisis más profundo del contexto del programa.

<img width="1257" height="581" alt="image" src="https://github.com/user-attachments/assets/51070153-ddea-4497-a0f3-53b0cdd697b8" />

Además, existen errores en tiempo de ejecución, que ocurren cuando el programa ya se encuentra en ejecución, como divisiones entre cero o accesos inválidos a memoria. También se consideran los errores lógicos, en los cuales el programa se ejecuta correctamente desde el punto de vista técnico, pero produce resultados incorrectos debido a fallas en el diseño del algoritmo.

Un aspecto fundamental en el diseño de compiladores es la recuperación de errores. No es conveniente que el compilador se detenga al detectar el primer error, ya que esto limita la retroalimentación al programador. Por ello, se emplean estrategias como la recuperación por pánico, que consiste en descartar parte de la entrada hasta encontrar un punto de sincronización que permita continuar el análisis.

<!-- IMAGEN SUGERIDA AQUÍ --> <!-- Puedes poner un ejemplo de código con errores y cómo el compilador los marca -->

En general, el manejo de errores impacta directamente en la calidad de un compilador. Un buen sistema no solo detecta errores, sino que proporciona mensajes claros y útiles que facilitan su corrección, mejorando así la experiencia del desarrollador.

---

## BNF (Backus-Naur Form)

La Forma de Backus-Naur (BNF) es una notación formal utilizada para describir la sintaxis de los lenguajes de programación. Esta herramienta es fundamental en el área de compiladores, ya que permite definir de manera precisa las reglas que determinan cómo deben estructurarse las expresiones válidas dentro de un lenguaje.

BNF se basa en el concepto de gramáticas libres de contexto, las cuales permiten representar estructuras jerárquicas de forma clara. Una gramática en BNF está compuesta por símbolos terminales, símbolos no terminales y reglas de producción. Los símbolos terminales corresponden a los elementos básicos del lenguaje, como palabras clave o símbolos, mientras que los no terminales representan estructuras que pueden descomponerse en otras más simples.

Las reglas de producción son el núcleo de BNF. Estas indican cómo un símbolo no terminal puede expandirse en una combinación de símbolos terminales y no terminales. Generalmente se utiliza el símbolo “::=” para expresar esta relación. Por ejemplo, una regla puede definir que una expresión está formada por la suma de dos términos, lo cual describe una estructura común en muchos lenguajes de programación.

```bnf
<expresion> ::= <termino> "+" <termino>
<termino> ::= <factor> | <factor> "*" <factor>
<factor> ::= "a" | "b" | "c"
```

| Símbolo | Nombre                     | Significado |
|--------|--------------------------|-------------|
| `::=`  | Definición               | Indica que un símbolo se define como una expresión. Se interpreta como "se define como". |
| `|`    | Alternativa              | Permite definir varias opciones posibles dentro de una producción. Equivale a "o". |
| `< >`  | No terminal              | Encierra símbolos no terminales, es decir, estructuras que pueden expandirse. |
| (texto literal) | Terminal       | Representa los símbolos reales del lenguaje (palabras clave, operadores, etc.). |
| `" "` o `' '` | Terminal explícito | Indica un símbolo terminal escrito literalmente. |
| (espacio) | Concatenación        | Indica secuencia de elementos (orden en el que aparecen). |

Una de las principales ventajas de BNF es su precisión. Al emplear una notación formal, se evita la ambigüedad en la definición de la sintaxis. Esto resulta crucial en la construcción de compiladores, ya que permite desarrollar analizadores sintácticos de forma sistemática y confiable.

Con el paso del tiempo, han surgido extensiones como EBNF (Extended Backus-Naur Form), que añaden mayor flexibilidad a la notación original. Estas extensiones permiten representar repeticiones, opciones y agrupaciones de manera más compacta, facilitando la lectura y mantenimiento de las gramáticas.

Además de su uso en compiladores, BNF se emplea en la definición de protocolos, lenguajes de marcado y formatos de datos. Su utilidad radica en su capacidad para describir formalmente la estructura de cadenas válidas dentro de un lenguaje determinado.

Desde una perspectiva práctica, BNF sirve como base para la construcción de analizadores sintácticos. Herramientas automatizadas utilizan gramáticas definidas en esta notación para generar código capaz de analizar programas, lo que simplifica considerablemente el desarrollo de compiladores.

En conclusión, BNF es un elemento esencial en la teoría de compiladores, ya que proporciona una forma clara, estructurada y formal de describir la sintaxis de los lenguajes de programación, facilitando tanto su diseño como su implementación.

## Referencias

* Aho, A. V., Sethi, R., & Ullman, J. D. (2007). Compilers: Principles, techniques, and tools (2nd ed.). Addison-Wesley.

* Alfonseca Moreno, M., M., de la Cruz Echeandía, M., Ortega de la Puente, A., & Pulido Cañabate, E. (2007). Compiladores e intérpretes: teoría y práctica. Pearson Educación / Prentice Hall.

* Lemone, K. A. (1998). Fundamentos de compiladores: Cómo traducir al lenguaje de computadora. Compañía Editorial Continental.

## Evidencias fotográficas en biblioteca

### Personales
<img width="1200" height="1600" alt="image" src="https://github.com/user-attachments/assets/8d890ac5-9c8b-4c10-8a59-a7cb74108271" />
<img width="1200" height="1600" alt="image" src="https://github.com/user-attachments/assets/6410d051-8e03-4ce5-b669-40fb6a5bb0d2" />
<img width="1200" height="1600" alt="image" src="https://github.com/user-attachments/assets/e65d047e-50de-44e1-8f4c-10a17e6f469a" />

### Referencias utilizadas
<img width="1200" height="1600" alt="image" src="https://github.com/user-attachments/assets/800c33d0-27bc-400c-b80b-d3881ebfdcc5" />
<img width="1201" height="1600" alt="image" src="https://github.com/user-attachments/assets/b1052df3-40c1-41d7-8d56-951701dc8e0d" />
<img width="1201" height="1600" alt="image" src="https://github.com/user-attachments/assets/c7dd06ba-4f2e-4b1a-a24f-551c41631582" />

### Información
<img width="1200" height="1600" alt="image" src="https://github.com/user-attachments/assets/202d1845-bc09-4a5c-8df7-e4fe1ec1a146" />
<img width="1200" height="1600" alt="image" src="https://github.com/user-attachments/assets/a6d066ad-cded-4dbe-af73-18246fdd84b5" />


