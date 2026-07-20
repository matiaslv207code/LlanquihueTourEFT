package app;

import cl.duoc.llanquihuetour.interfaces.Registrable;
import model.*;
import utils.LectorArchivo;
import cl.duoc.llanquihuetour.exception.RutInvalidoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // lista polimorfica para guardar entidades registrables
        List<Registrable> inventarioEntidades = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // 1. carga automatica de clientes desde el archivo txt (exigido por rubrica)
        System.out.println("Cargando datos desde clientes.txt...");
        List<Cliente> clientesCargados = LectorArchivo.cargarClientes("cliente.txt");
        if (clientesCargados != null) {
            inventarioEntidades.addAll(clientesCargados);
        }

        // 2. precarga automatica de guias directo en el codigo para complementar la lista
        try {
            Rut rutG1 = new Rut(22222222, '2');
            Direccion dirG1 = new Direccion("Los Alerces", 89, "Llanquihue");
            Guia guia1 = new Guia("Carlos Perez", rutG1, dirG1, "Alemán/Inglés", 45000);

            Rut rutG2 = new Rut(44444444, '4');
            Direccion dirG2 = new Direccion("Costanera", 55, "Puerto Varas");
            Guia guia2 = new Guia("Maria Jose", rutG2, dirG2, "Español/Portugués", 50000);

            inventarioEntidades.add(guia1);
            inventarioEntidades.add(guia2);

            System.out.println("--- Base de datos inicializada con éxito (Archivo + Código) ---\n");

        } catch (RutInvalidoException e) {
            System.out.println("Error en carga de guías: " + e.getMessage());
        }

        // despliega el menu de opciones iterativo
        int opcion = 0;
        do {
            System.out.println("=====================================");
            System.out.println("   SISTEMA DE GESTIÓN LLANQUIHUE TOUR");
            System.out.println("=====================================");
            System.out.println("1. Mostrar todos los registros");
            System.out.println("2. Filtrar solo Clientes");
            System.out.println("3. Filtrar solo Guías");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcion = 0;
            }

            switch (opcion) {
                case 1:
                    System.out.println("\n--- LISTADO GENERAL DE ENTIDADES ---");
                    for (Registrable r : inventarioEntidades) {
                        r.mostrarDatos();
                        System.out.println("-------------------------------------");
                    }
                    break;
                case 2:
                    System.out.println("\n--- LISTADO DE CLIENTES (Uso de instanceof) ---");
                    for (Registrable r : inventarioEntidades) {
                        if (r instanceof Cliente) {
                            r.mostrarDatos();
                            System.out.println("-------------------------------------");
                        }
                    }
                    break;
                case 3:
                    System.out.println("\n--- LISTADO DE GUÍAS (Uso de instanceof) ---");
                    for (Registrable r : inventarioEntidades) {
                        if (r instanceof Guia) {
                            r.mostrarDatos();
                            System.out.println("-------------------------------------");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Saliendo del sistema de Llanquihue Tour. ¡Que tengas un excelente día!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}