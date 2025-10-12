/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase2;

/**
 *
 * @author fbarg
 */
import java.util.Scanner;

public class EjemploWhileConEtiqueta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero;

        // Etiqueta para el bucle exterior
        outerLoop: 
        while (true) {
            System.out.println("Ingrese un número positivo (número negativo para salir):");
            numero = scanner.nextInt();

            // Verificar si el número es negativo
            if (numero < 0) {
                System.out.println("Número negativo ingresado. Saliendo del programa.");
                break; // Salir del bucle exterior
            }

            // Bucle anidado
            while (true) {
                System.out.println("Número ingresado: " + numero);
                System.out.println("¿Desea ingresar otro número? (s/n):");
                String respuesta = scanner.next();

                if (respuesta.equalsIgnoreCase("n")) {
                    System.out.println("Saliendo del programa.");
                    break outerLoop; // Salir del bucle exterior usando la etiqueta
                } else if (respuesta.equalsIgnoreCase("s")) {
                    break; // Volver a solicitar un número
                } else {
                    System.out.println("Respuesta no válida. Intente nuevamente.");
                }
            }
        }

        System.out.println("Fin del programa.");
        scanner.close();
    }
}