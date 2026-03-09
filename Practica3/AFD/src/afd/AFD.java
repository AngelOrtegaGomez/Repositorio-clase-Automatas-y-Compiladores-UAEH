package afd;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author angel
 */
public class AFD {

    public static void main(String[] args) {

        try {

            Scanner sc = new Scanner(new File("afd.txt"));

            //Comprobar si hay digitos en el archivo
            if (!sc.hasNextInt()) {
                System.out.println("Formato invalido");
                return;
            }

            int N = sc.nextInt(); //Estados posibles
            int S = sc.nextInt(); //Tamaño del alfabeto
            int D = sc.nextInt(); //Cantidad de funciones de trasnisicion
            int q0 = sc.nextInt(); //estado Incial
            int T = sc.nextInt(); //Estados de aceptacion
            int C = sc.nextInt(); //Cantidad de cadenas a comprobar

            //Verificar problemas posibles de tamaños
            if (N < 1 || C > 100
                    || D < 1 || D > 100
                    || q0 < 1 || q0 > N
                    || T < 0 || T > N) {

                System.out.println("Parametros fuera de los rangos permitidos");
                return;
            }

            //LEER ALFABETO Y GUARDARLO EN ARRAY
            char[] alfabeto = new char[S];

            for (int i = 0; i < S; i++) {
                if (!sc.hasNext()) {
                    System.out.println("Faltan simbolos del alfabeto");
                    return;
                }
                alfabeto[i] = sc.next().charAt(0);
            }

            //LEER ESTADOS DE ACEPTACION
            boolean[] aceptacion = new boolean[N + 1]; //<-- Basado en el tamaño de esatdos general mas uno para aprovechar los numeros de arrays

            for (int i = 0; i < T; i++) {
                int estado = sc.nextInt();

                if (estado < 1 || estado > N) {
                    System.out.println("Estado(s) de aceptación no valido(s)");
                    return;
                }

                aceptacion[estado] = true;
            }

            //LEER FUNCIONES DE TRANSICIÖN
            int[][] transiciones = new int[N + 1][S];

            for (int i = 0; i < D; i++) {

                int I = sc.nextInt();
                char X = sc.next().charAt(0);
                int J = sc.nextInt();

                if (I < 1 || I > N || J < 1 || J > N) {
                    System.out.println("Funciones de transición invalidas");
                    return;
                }

                int indice = -1;

                for (int j = 0; j < S; j++) {
                    if (alfabeto[j] == X) {
                        indice = j;
                        break;
                    }
                }

                if (indice == -1) {
                    System.out.println("No se encontró un símbolo de las funciones dentro del alfabeto");
                    return;
                }

                transiciones[I][indice] = J;
            }

            //LEER CADENAS A COMPROBAR
            String[] cadenas = new String[C];

            for (int i = 0; i < C; i++) {

                if (!sc.hasNext()) {
                    System.out.println("Faltan cadenas de caractéres para comprobar");
                    return;
                }
                cadenas[i] = sc.next();
            }

            //EVALUAR CADENAS
            for (int i = 0; i < C; i++) {

                String cadena = cadenas[i];
                int estadoActual = q0;

                for (int j = 0; j < cadena.length(); j++) {

                    char simbolo = cadena.charAt(j);

                    int indice = -1;

                    for (int k = 0; k < S; k++) {
                        if (alfabeto[k] == simbolo) {
                            indice = k;
                            break;
                        }
                    }

                    if (indice == -1) {
                        System.out.println(cadena + " RECHAZADA");
                        estadoActual = -1;
                        break;
                    }

                    estadoActual = transiciones[estadoActual][indice];
                }

                if (aceptacion[estadoActual]) {
                    System.out.println(cadena + " - ACEPTADA");
                } else {
                    System.out.println(cadena + " - RECHAZADA");
                }

            }

        } catch (Exception e) {
            System.out.println("Error al leer el archivo");
        }

    }

}
