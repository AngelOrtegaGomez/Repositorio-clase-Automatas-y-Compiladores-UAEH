# PRACTICA 2 - Reconocimiento de palabras con Autómatas Finitos Deterministas 
## AUTOR : Ángel Ortega Gómez 6°3

**Ejercicio 1:** *Obtenga un Autómata Finito Determinista (AFD) dado el lenguaje definido en el alfabeto 𝛴= {0,1}, que acepte el conjunto de palabras del lenguaje 𝐿={0𝑥	|	𝑥∈{0,1}∗	}*

*AFD=(Σ,Q,δ,q0,F)*

Donde:

Σ = {0,1}  
Q = {start, s1, s2}  
q₀ = start  
F = {s1}  

Función de transición δ:

δ(start,0) = s1  
δ(start,1) = s2  
δ(s1,0) = s1  
δ(s1,1) = s1  
δ(s2,0) = s2  
δ(s2,1) = s2  

*Tabla de trasnsición de estados*
| Estado  | 0  | 1  |
| ------- | -- | -- |
| → start | s1 | s2 |
| * s1    | s1 | s1 |
| s2      | s2 | s2 |

<p align="center">
  <img width="439" height="345" alt="image" src="https://github.com/user-attachments/assets/c4b12fa2-1348-4a3d-a16a-7a90d94b81c5" />
  <br />
  <em>Imagen 1.1: Diagrama de transición de estados del ejercicio 1</em>
</p>

<p align="center">
  <img width="264" height="247" alt="image" src="https://github.com/user-attachments/assets/12df15f2-da65-49aa-8a37-e2f8d9d28a14" />
  <br />
  <em>Imagen 1.2: Resultados de simulación del ejercicio 1</em>
</p>

**Ejercicio 2:** *Obtenga un Autómata Finito Determinista (AFD) dado el lenguaje definido en el alfabeto 𝛴= {0,1}, que acepte el conjunto de palabras del lenguaje 𝐿={𝑥1	|	𝑥∈{0,1}+}*

*AFD=(Σ,Q,δ,q0,F)*

Donde:

Σ = {0,1}  
Q = {start, s0, s1, s2}  
q₀ = start  
F = {s2}  

Función de transición δ:

δ(start,0) = s0  
δ(start,1) = s0  
δ(s0,0) = s1  
δ(s0,1) = s2  
δ(s1,0) = s1  
δ(s1,1) = s2  
δ(s2,0) = s1  
δ(s2,1) = s2  

*Tabla de trasnsición de estados*
| Estado  | 0  | 1  |
| ------- | -- | -- |
| → start | s0 | s0 |
| s0      | s1 | s2 |
| s1      | s1 | s2 |
| * s2    | s1 | s2 |

<p align="center">
  <img width="787" height="410" alt="image" src="https://github.com/user-attachments/assets/84eed799-abd0-46de-9e30-9810c6c0828c" />
  <br />
  <em>Imagen 2.1: Diagrama de transición de estados del ejercicio 2</em>
</p>

<p align="center">
  <img width="287" height="244" alt="image" src="https://github.com/user-attachments/assets/0d5c2a24-62a2-4b4c-b723-6f0a0e598339" />
  <br />
  <em>Imagen 2.2: Resultados de simulación del ejercicio 2</em>
</p>

**Ejercicio 3:** *Obtenga un Autómata Finito Determinista (AFD) dado el lenguaje definido en el alfabeto 𝛴= {0,1}, que acepte el conjunto de palabras del lenguaje 𝐿={𝑥01𝑦	|	𝑥,𝑦∈{0,1}∗	}*

*AFD=(Σ,Q,δ,q0,F)*

Donde:

Σ = {0,1}  
Q = {start, s0, s1}  
q₀ = start  
F = {s1} 

Función de transición δ:

δ(start,0) = s0  
δ(start,1) = start  
δ(s0,0) = s0  
δ(s0,1) = s1  
δ(s1,0) = s1  
δ(s1,1) = s1  

*Tabla de trasnsición de estados*
| Estado  | 0  | 1     |
| ------- | -- | ----- |
| → start | s0 | start |
| s0      | s0 | s1    |
| * s1    | s1 | s1    |

<p align="center">
  <img width="729" height="267" alt="image" src="https://github.com/user-attachments/assets/252f76e9-208e-4f86-b700-b4e340c52d80" />
  <br />
  <em>Imagen 3.1: Diagrama de transición de estados del ejercicio 3</em>
</p>

<p align="center">
  <img width="287" height="244" alt="image" src="https://github.com/user-attachments/assets/0d5c2a24-62a2-4b4c-b723-6f0a0e598339" />
  <br />
  <em>Imagen 3.2: Resultados de simulación del ejercicio 3</em>
</p>

**Ejercicio 4:** *Obtenga un Autómata Finito Determinista (AFD) dado el lenguaje definido en el alfabeto 𝛴= {0,1}, que acepte el conjunto de palabras del lenguaje 𝐿={𝑥110𝑦	|	𝑥,𝑦∈{0,1}∗	}*

*AFD=(Σ,Q,δ,q0,F)*

Donde:

Σ = {0,1}  
Q = {start, s0, s1, s2}  
q₀ = start  
F = {s2} 

Función de transición δ:

δ(start,0) = start  
δ(start,1) = s0  
δ(s0,0) = start  
δ(s0,1) = s1  
δ(s1,0) = s2  
δ(s1,1) = s1  
δ(s2,0) = s2  
δ(s2,1) = s2  

*Tabla de trasnsición de estados*
| Estado  | 0     | 1  |
| ------- | ----- | -- |
| → start | start | s0 |
| s0      | start | s1 |
| s1      | s2    | s1 |
| *s2      | s2    | s2 |


<p align="center">
  <img width="660" height="325" alt="image" src="https://github.com/user-attachments/assets/510534bb-0a72-4861-a873-1b7b1118aa7d" />
  <br />
  <em>Imagen 4.1: Diagrama de transición de estados del ejercicio 4</em>
</p>

<p align="center">
  <img width="289" height="244" alt="image" src="https://github.com/user-attachments/assets/cf8b0595-61e7-4fbc-b7cb-5659cad70214" />
  <br />
  <em>Imagen 4.2: Resultados de simulación del ejercicio 4</em>
</p>


**Ejercicio 5:** *Obtenga un Autómata Finito Determinista (AFD) dado el lenguaje definido en el alfabeto 𝛴= {𝑎,𝑏,𝑐}, que acepte el conjunto de palabras del lenguaje 𝐿={𝑎𝑐𝑥𝑎𝑏	|	𝑥∈{𝑎,𝑏,𝑐}∗	}*

*AFD=(Σ,Q,δ,q0,F)*

Donde:

Σ = {a,b,c}  
Q = {start, s0, s1, s2, s3, s4}  
q₀ = start  
F = {s3}

Función de transición δ:

δ(start,a) = s0  
δ(start,b) = s4  
δ(start,c) = s4  
δ(s0,a) = s4  
δ(s0,b) = s4  
δ(s0,c) = s1  
δ(s1,a) = s2  
δ(s1,b) = s1  
δ(s1,c) = s1  
δ(s2,a) = s2  
δ(s2,b) = s3  
δ(s2,c) = s1  
δ(s3,a) = s2  
δ(s3,b) = s1  
δ(s3,c) = s1  
δ(s4,a) = s4  
δ(s4,b) = s4  
δ(s4,c) = s4  

*Tabla de trasnsición de estados*
| Estado  | a     | b     | c  |
| ------- | ----- | ----- | -- |
| → start | s0    | s4    | s4 |
| s0      | s4    | z4    | s1 |
| s1      | s2    | s1    | s1 |
| s2      | s2    | s3    | s1 |
| * s3    | s2    | s1    | s1 |
| s4      | s4    | s4    | s4 |

<p align="center">
  <img width="803" height="454" alt="image" src="https://github.com/user-attachments/assets/4fa8f92f-ec21-4e9f-954d-9925f87b20a0" />
  <br />
  <em>Imagen 5.1: Diagrama de transición de estados del ejercicio 5</em>
</p>

<p align="center">
  <img width="304" height="257" alt="image" src="https://github.com/user-attachments/assets/90ee6f54-9e08-4ee4-84cf-cac860dbd0cf" />
  <br />
  <em>Imagen 5.2: Resultados de simulación del ejercicio 5</em>
</p>

**Ejercicio 6:** *Obtenga un Autómata Finito Determinista (AFD) dado el lenguaje definido en el alfabeto 𝛴= {𝑎,𝑏,𝑐}, que acepte el conjunto de palabras del lenguaje 𝐿={𝑎𝑐𝑥𝑧	|	𝑥∈{𝑎.𝑏,𝑐}∗	𝑦	𝑧≠𝑎𝑏	}*

*AFD=(Σ,Q,δ,q0,F)*

Donde:

Σ = {a,b,c}  
Q = {start, s0, s1, s2, s3, s4}  
q₀ = start  
F = {s1, s2}

Función de transición δ:

δ(start,a) = s0  
δ(start,b) = s4  
δ(start,c) = s4   
δ(s0,a) = s4  
δ(s0,b) = s4  
δ(s0,c) = s1  
δ(s1,a) = s2  
δ(s1,b) = s1  
δ(s1,c) = s1  
δ(s2,a) = s2  
δ(s2,b) = s3  
δ(s2,c) = s1  
δ(s3,a) = s2  
δ(s3,b) = s1  
δ(s3,c) = s1  
δ(s4,a) = s4  
δ(s4,b) = s4  
δ(s4,c) = s4  

*Tabla de trasnsición de estados*
| Estado  | a  | b  | c  |
| ------- | -- | -- | -- |
| → start | s0 | s4 | s4 |
| s0      | s4 | s4 | s1 |
| * s1    | s2 | s1 | s1 |
| * s2    | s2 | s3 | s1 |
| s3      | s2 | s1 | s1 |
| s4      | s4 | s4 | s4 |


<p align="center">
  <img width="758" height="393" alt="image" src="https://github.com/user-attachments/assets/ee6aa3e5-d1ea-406b-bf35-33637483dbf7" />
  <br />
  <em>Imagen 6.1: Diagrama de transición de estados del ejercicio 6</em>
</p>

<p align="center">
  <img width="286" height="256" alt="image" src="https://github.com/user-attachments/assets/991438a2-d5ef-4a46-82b6-cb5c5f2b572a" />
  <br />
  <em>Imagen 6.2: Resultados de simulación del ejercicio 6</em>
</p>

**Ejercicio 7:** *Obtenga un Autómata Finito Determinista (AFD) dado el lenguaje definido en el alfabeto 𝛴= {𝑎,𝑏,𝑐,𝑑}, que acepte el conjunto de palabras del lenguaje 𝐿={𝑎𝑐𝑏𝑥𝑧	|	𝑥∈{𝑎,𝑏,𝑐,𝑑}∗	𝑦	𝑧	≠𝑏𝑑}*

*AFD=(Σ,Q,δ,q0,F)*

Donde:

Σ = {a,b,c,d}  
Q = {start, s0, s1, s2, s3, s4, s5}  
q₀ = start  
F = {s2, s3}

Función de transición δ:

δ(start,a) = s0  
δ(start,b) = s5  
δ(start,c) = s5  
δ(start,d) = s5  
δ(s0,a) = s5  
δ(s0,b) = s5  
δ(s0,c) = s1  
δ(s0,d) = s5  
δ(s1,a) = s5  
δ(s1,b) = s2  
δ(s1,c) = s5  
δ(s1,d) = s5  
δ(s2,a) = s3  
δ(s2,b) = s2  
δ(s2,c) = s3  
δ(s2,d) = s4  
δ(s3,a) = s3  
δ(s3,b) = s2  
δ(s3,c) = s3  
δ(s3,d) = s3  
δ(s4,a) = s3  
δ(s4,b) = s2  
δ(s4,c) = s3  
δ(s4,d) = s3  
δ(s5,a) = s5  
δ(s5,b) = s5  
δ(s5,c) = s5  
δ(s5,d) = s5  

*Tabla de trasnsición de estados*
| Estado  | a  | b  | c  | d  |
| ------- | -- | -- | -- | -- |
| → start | s0 | s5 | s5 | s5 |
| s0      | s5 | s5 | s1 | s5 |
| s1      | s5 | s2 | s5 | s5 |
| * s2    | s3 | s2 | s3 | s4 |
| * s3    | s3 | s2 | s3 | s3 |
| s4      | s3 | s2 | s3 | s3 |
| s5      | s5 | s5 | s5 | s5 |


<p align="center">
  <img width="991" height="481" alt="image" src="https://github.com/user-attachments/assets/ffd7a70a-3683-4b0e-a3d8-61d54152c614" />
  <br />
  <em>Imagen 7.1: Diagrama de transición de estados del ejercicio 7</em>
</p>

<p align="center">
  <img width="303" height="246" alt="image" src="https://github.com/user-attachments/assets/6c43f0cb-7cb3-4962-bce5-dcf7e5aba05f" />
  <br />
  <em>Imagen 7.2: Resultados de simulación del ejercicio 7</em>
</p>

**Ejercicio 8:** *Obtenga un Autómata Finito Determinista (AFD) dado el lenguaje definido en el alfabeto 𝛴= {𝑎,𝑏,𝑐,𝑑}, que acepte el conjunto de palabras 𝐿={𝑐𝑎𝑏𝑎𝑥𝑧	|	𝑥∈{𝑎,𝑏,𝑐,𝑑}∗	𝑦	𝑧	≠𝑎𝑏}*

*AFD=(Σ,Q,δ,q0,F)*

Donde:

Σ = {a,b,c,d}  
Q = {start, s0, s1, s2, s3, s4, s5, s6}  
q₀ = start  
F = {s3, s4}

Función de transición δ:

δ(start,a) = s6  
δ(start,b) = s6  
δ(start,c) = s0  
δ(start,d) = s6  
δ(s0,a) = s1  
δ(s0,b) = s6  
δ(s0,c) = s6  
δ(s0,d) = s6  
δ(s1,a) = s6  
δ(s1,b) = s2  
δ(s1,c) = s6  
δ(s1,d) = s6  
δ(s2,a) = s3  
δ(s2,b) = s6  
δ(s2,c) = s6  
δ(s2,d) = s6  
δ(s3,a) = s3  
δ(s3,b) = s5  
δ(s3,c) = s4  
δ(s3,d) = s4  
δ(s4,a) = s3  
δ(s4,b) = s4  
δ(s4,c) = s4  
δ(s4,d) = s4  
δ(s5,a) = s3  
δ(s5,b) = s4  
δ(s5,c) = s4  
δ(s5,d) = s4  
δ(s6,a) = s6  
δ(s6,b) = s6  
δ(s6,c) = s6  
δ(s6,d) = s6  

*Tabla de trasnsición de estados*
| Estado  | a  | b  | c  | d  |
| ------- | -- | -- | -- | -- |
| → start | s6 | s6 | s0 | s6 |
| s0      | s1 | s6 | s6 | s6 |
| s1      | s6 | s2 | s6 | s6 |
| s2      | s3 | s6 | s6 | s6 |
| * s3    | s3 | s5 | s4 | s4 |
| * s4    | s3 | s4 | s4 | s4 |
| s5      | s3 | s4 | s4 | s4 |
| s6      | s6 | s6 | s6 | s6 |


<p align="center">
  <img width="1152" height="423" alt="image" src="https://github.com/user-attachments/assets/bb236b9e-b6e3-49ee-a6be-c45684c47c84" />
  <br />
  <em>Imagen 8.1: Diagrama de transición de estados del ejercicio 8</em>
</p>

<p align="center">
  <img width="296" height="259" alt="image" src="https://github.com/user-attachments/assets/5ec63b98-cddf-47c6-a6bd-03fc73c4c586" />
  <br />
  <em>Imagen 8.2: Resultados de simulación del ejercicio 8</em>
</p>

**Ejercicio 9:** *Obtenga un Autómata Finito Determinista (AFD) dado el lenguaje definido en el alfabeto 𝛴= {𝑎,𝑏,𝑐}, que acepte el lenguaje 𝐿={𝑎 𝑐𝑏 |	𝑛>0	𝑦	𝑚	>0	}*

*AFD=(Σ,Q,δ,q0,F)*

Donde:

Σ = {a,b,c}  
Q = {start, s0, s1, s2, s3}  
q₀ = start  
F = {s2} 

Función de transición δ:

δ(start,a) = s0  
δ(start,b) = s3  
δ(start,c) = s3  
δ(s0,a) = s0  
δ(s0,b) = s3  
δ(s0,c) = s1  
δ(s1,a) = s3  
δ(s1,b) = s2  
δ(s1,c) = s3  
δ(s2,a) = s3  
δ(s2,b) = s2  
δ(s2,c) = s3  
δ(s3,a) = s3  
δ(s3,b) = s3  
δ(s3,c) = s3  

*Tabla de trasnsición de estados*
| Estado  | a  | b  | c  |
| ------- | -- | -- | -- |
| → start | s0 | s3 | s3 |
| s0      | s0 | s3 | s1 |
| s1      | s3 | s2 | s3 |
| * s2    | s3 | s2 | s3 |
| s3      | s3 | s3 | s3 |

<p align="center">
  <img width="911" height="360" alt="image" src="https://github.com/user-attachments/assets/093bd53a-2e4c-4852-af7d-617c5ccbe58e" />
  <br />
  <em>Imagen 9.1: Diagrama de transición de estados del ejercicio 9</em>
</p>

<p align="center">
  <img width="312" height="248" alt="image" src="https://github.com/user-attachments/assets/72b96edb-a6bd-4802-b0d1-479bdcc474c3" />
  <br />
  <em>Imagen 9.2: Resultados de simulación del ejercicio 9</em>
</p>

**Ejercicio 10:** *Obtenga un Autómata Finito Determinista (AFD) dado el lenguaje definido en el alfabeto 𝛴= {𝑎,𝑏,𝑐}, que acepte el lenguaje 𝐿={𝑥𝑐 |	𝑥∈{𝑎,𝑏}∗	𝑦	𝑙𝑎	𝑐𝑎𝑛𝑡𝑖𝑑𝑎𝑑	𝑑𝑒	𝑏𝑠	𝑒𝑠	𝑝𝑎𝑟	𝑦	𝑚	≥0	}*

*AFD=(Σ,Q,δ,q0,F)*

Donde:

Σ = {a,b,c}  
Q = {start, s0, s1, s2, s3, s4, s5}  
q₀ = start  
F = {s0, s4} 

Función de transición δ:

δ(start,a) = s0  
δ(start,b) = s1 
δ(start,c) = s2  
δ(s0,a) = s0  
δ(s0,b) = s1  
δ(s0,c) = s2  
δ(s1,a) = s1  
δ(s1,b) = s0  
δ(s1,c) = s5  
δ(s2,a) = s5  
δ(s2,b) = s5  
δ(s2,c) = s3  
δ(s3,a) = s5  
δ(s3,b) = s5  
δ(s3,c) = s4  
δ(s4,a) = s5  
δ(s4,b) = s5  
δ(s4,c) = s2  
δ(s5,a) = s5  
δ(s5,b) = s5  
δ(s5,c) = s5  

*Tabla de trasnsición de estados*
| Estado  | a  | b  | c  |
| ------- | -- | -- | -- |
| → start | s0 | s1 | s2 |
| * s0    | s0 | s1 | s2 |
| s1      | s1 | s0 | s5 |
| s2      | s5 | s5 | s3 |
| s3      | s5 | s5 | s4 |
| * s4    | s5 | s5 | s2 |
| s5      | s5 | s5 | s5 |


<p align="center">
  <img width="1117" height="514" alt="image" src="https://github.com/user-attachments/assets/ccb90496-350a-43e2-9622-c1fec82307a4" />
  <br />
  <em>Imagen 10.1: Diagrama de transición de estados del ejercicio 10</em>
</p>

<p align="center">
  <img width="316" height="247" alt="image" src="https://github.com/user-attachments/assets/28752a11-2338-49fb-8e55-fef7b0c6a23a" />
  <br />
  <em>Imagen 10.2: Resultados de simulación del ejercicio 10</em>
</p>
