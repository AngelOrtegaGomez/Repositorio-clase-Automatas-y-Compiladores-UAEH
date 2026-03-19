package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Sistema simple para gestionar tareas desde consola
 */
public class GestorTareas {

    static class Tarea {
        private String nombre;
        private boolean completada;
        private int prioridad;

        public Tarea(String nombre, int prioridad) {
            this.nombre = nombre;
            this.prioridad = prioridad;
            this.completada = false;
        }

        public void completar() {
            completada = true;
        }

        public String getNombre() {
            return nombre;
        }

        public boolean isCompletada() {
            return completada;
        }

        public int getPrioridad() {
            return prioridad;
        }

        @Override
        public String toString() {
            return (completada ? "[✔] " : "[ ] ") + nombre + " (Prioridad: " + prioridad + ")";
        }
    }

    ¡¡¡

    private static List<Tarea> tareas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    agregarTarea(scanner);
                    break;
                case 2:
                    listarTareas();
                    break;
                case 3:
                    completarTarea(scanner);
                    break;
                case 4:
                    eliminarTarea(scanner);
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n--- GESTOR DE TAREAS ---");
        System.out.println("1. Agregar tarea");
        System.out.println("2. Listar tareas");
        System.out.println("3. Completar tarea");
        System.out.println("4. Eliminar tarea");
        System.out.println("5. Salir");
    }

    private static void agregarTarea(Scanner scanner) {
        System.out.print("Nombre de la tarea: ");
        String nombre = scanner.nextLine();

        System.out.print("Prioridad (1-5): ");
        int prioridad = scanner.nextInt();
        scanner.nextLine();

        Tarea nueva = new Tarea(nombre, prioridad);
        tareas.add(nueva);

        System.out.println("Tarea agregada correctamente");
    }

    private static void listarTareas() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas registradas");
            return;
        }

        System.out.println("\nLista de tareas:");
        for (int i = 0; i < tareas.size(); i++) {
            System.out.println((i + 1) + ". " + tareas.get(i));
        }
    }

    private static void completarTarea(Scanner scanner) {
        listarTareas();
        if (tareas.isEmpty()) return;

        System.out.print("Número de tarea a completar: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index >= 0 && index < tareas.size()) {
            tareas.get(index).completar();
            System.out.println("Tarea completada");
        } else {
            System.out.println("Índice inválido");
        }
    }

    private static void eliminarTarea(Scanner scanner) {
        listarTareas();
        if (tareas.isEmpty()) return;

        System.out.print("Número de tarea a eliminar: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index >= 0 && index < tareas.size()) {
            tareas.remove(index);
            System.out.println("Tarea eliminada");
        } else {
            System.out.println("Índice inválido");
        }
    }

    ###

    /*
    TODO 
    Creación de main
    */
}