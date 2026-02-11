package detectordeletrascongf;

import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class DetectorDeLetrasConGF {

    public static void main(String[] args) {

        String palabra;
        int op = 0;

        //Palabras reservadas del caso 4
        String[] reservadas = {
            "abstract", "assert", "boolean", "break", "byte", "case", "catch",
            "char", "class", "const", "continue", "default", "do", "double", "else",
            "enum", "extends", "final", "finally", "float", "for", "goto", "if",
            "implements", "import", "instanceof", "int", "interface", "long",
            "native", "new", "package", "private", "protected", "public", "return",
            "short", "static", "strictfp", "super", "switch", "synchronized",
            "this", "throw", "throws", "transient", "try", "void", "volatile", "while"
        };

        //Do referenciando a la opción de salir
        do {

            //Do referenciando a la entrada de opción
            do {
                try {
                    op = 0;
                    op = Integer.parseInt(JOptionPane.showInputDialog(null, "---Menu de detector de palabras---"
                            + "\n\n1) Detectar números enteros"
                            + "\n2) Detectar minúsculas"
                            + "\n3) Detectar mayúsculas"
                            + "\n4) Detectar identificadores"
                            + "\n5) Detectar símbolos"
                            + "\n6) Salir" + "\n ", "Menú", -1));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "La opción debe ser un carácter numérico.", "Error de entrada", 2);
                }
                //repetir hasta que sea correcto    
            } while (op == 0);

            switch (op) {

                //Detectar números enteros
                case 1:

                    palabra = JOptionPane.showInputDialog(null, "Ingresa un numero entero: ", "Entrada", 2);

                    if (palabra.matches("[0-9]+")) {
                        JOptionPane.showMessageDialog(null, "La palabra está formada solo por números.", "Resultado", 1);
                    } else {
                        JOptionPane.showMessageDialog(null, "La palabra NO está formada solo por números.", "Resultado", 0);
                    }

                    break;

                //Detectar palabras minúsculas
                case 2:

                    palabra = JOptionPane.showInputDialog(null, "Ingresa una palabra: ", "Entrada", 2);

                    if (palabra.matches("[a-z]+")) {
                        JOptionPane.showMessageDialog(null, "La palabra está formada solo por letras minúsculas.", "Resultado", 1);
                    } else {
                        JOptionPane.showMessageDialog(null, "La palabra NO está formada solo por letras minúsculas.", "Resultado", 0);
                    }

                    break;

                //Detectar palabras mayúsculas
                case 3:

                    palabra = JOptionPane.showInputDialog(null, "Ingresa una palabra: ", "Entrada", 2);

                    if (palabra.matches("[A-Z]+")) {
                        JOptionPane.showMessageDialog(null, "La palabra está formada solo por letras mayúscuas.", "Resultado", 1);
                    } else {
                        JOptionPane.showMessageDialog(null, "La palabra NO está formada solo por letras mayúscuas.", "Resultado", 0);
                    }
                    break;

                //Detectar palabras validas como identificadores
                case 4:

                    palabra = JOptionPane.showInputDialog(null, "Ingresa una palabra: ", "Entrada", 2);
                    boolean soloIdentificador = true;

                    for (String r : reservadas) {
                        if (palabra.equals(r)) {
                            soloIdentificador = false;
                            break;
                        }
                    }

                    if (palabra.matches("[a-zA-Z_$][a-zA-Z0-9_$]*") && soloIdentificador) {
                        JOptionPane.showMessageDialog(null, "La palabra SI es valida como un nombre de identificador.", "Resultado", 1);
                    } else {
                        JOptionPane.showMessageDialog(null, "La palabra NO es valida como un nombre de identificador.", "Resultado", 0);
                    }
                    break;

                //Detectar símbolos
                case 5:

                    palabra = JOptionPane.showInputDialog(null, "Ingresa una palabra: ", "Entrada", 2);
                    

                    if (palabra.matches("[+\\-*/\\%<>=!&|^~(){}\\[\\];,.:?_#@]+")) {
                        JOptionPane.showMessageDialog(null, "La palabra está formada solo por símbolos.", "Resultado", 1);
                    } else {
                        JOptionPane.showMessageDialog(null, "La palabra NO está formada solo por símbolos.", "Resultado", 0);
                    }
                    break;

                //Salida del programa con copyright
                case 6:
                    JOptionPane.showMessageDialog(null, "Programa elaborado por Ángel Ortega Gómez - 6°3.", "Salida", -1);
                    break;

                //Default en caso de un número fuera del menu
                default:
                    JOptionPane.showMessageDialog(null, "Opción fuera del rango del menu", "Entrada erronea", 0);
            }

        } while (op != 6);

    }

}
