package utils;

import cl.duoc.llanquihuetour.exception.RutInvalidoException;
import model.Cliente;
import model.Direccion;
import model.Rut;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LectorArchivo {

    // lee un archivo de texto y devuelve una lista de objetos cliente
    public static List<Cliente> cargarClientes(String rutaArchivo) {
        List<Cliente> clientes = new ArrayList<>();
        // abre el archivo de forma segura controlando el cierre de recursos
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            // recorre el archivo de texto linea por linea hasta el final
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                // procesa la linea solo si contiene las ocho columnas requeridas
                if (datos.length == 8) {
                    try {
                        int rutNum = Integer.parseInt(datos[0]);
                        char dv = datos[1].charAt(0);
                        String nombre = datos[2];
                        String calle = datos[3];
                        int numeroDir = Integer.parseInt(datos[4]);
                        String comuna = datos[5];
                        String email = datos[6];
                        String nivel = datos[7];

                        // construye los objetos necesarios para armar el cliente
                        Rut rut = new Rut(rutNum, dv);
                        Direccion dir = new Direccion(calle, numeroDir, comuna);
                        Cliente cliente = new Cliente(nombre, rut, dir, email, nivel);
                        clientes.add(cliente);
                    } catch (RutInvalidoException | NumberFormatException e) {
                        // atrapa errores de formato numerico o ruts invalidos por linea
                        System.out.println("Error procesando línea [" + linea + "]: " + e.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            // captura fallos de lectura o archivos no encontrados
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return clientes;
    }
}