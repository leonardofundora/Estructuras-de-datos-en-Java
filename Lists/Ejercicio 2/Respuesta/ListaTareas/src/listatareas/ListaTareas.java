package listatareas;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ListaTareas {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<String> listaDeTareas = new LinkedList<>();

        while (true) {
            System.out.println("1-Anadir, 2-Eliminar, 3-Listar, 4-Mover, 0-Salir");
            int accion = in.nextInt();
            in.nextLine();  // Consumir el salto de línea

            switch (accion) {
                case 1:
                    System.out.println("Introduzca la tarea");
                    String tarea = in.nextLine();
                    listaDeTareas.add(tarea);
                    break;
                case 2:
                    System.out.println("Introduzca la tarea a eliminar");
                    String tareaEliminar = in.nextLine();
                    listaDeTareas.remove(tareaEliminar);
                    break;
                case 3:
                    System.out.println("Lista de Tareas:");
                    for (int i = 0; i < listaDeTareas.size(); i++) {
                        System.out.println((i + 1) + ". " + listaDeTareas.get(i));
                    }
                    break;
                case 4:
                    System.out.println("Introduzca el índice de la tarea a mover");
                    int indiceMover = in.nextInt() - 1;
                    System.out.println("Introduzca el nuevo índice");
                    int nuevoIndice = in.nextInt() - 1;
                    in.nextLine();  // Consumir el salto de línea

                    if (indiceMover >= 0 && indiceMover < listaDeTareas.size() && nuevoIndice >= 0 && nuevoIndice < listaDeTareas.size()) {
                        String tareaMover = listaDeTareas.remove(indiceMover);
                        listaDeTareas.add(nuevoIndice, tareaMover);
                    } else {
                        System.out.println("Índices inválidos");
                    }
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    in.close();
                    return;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }
}
