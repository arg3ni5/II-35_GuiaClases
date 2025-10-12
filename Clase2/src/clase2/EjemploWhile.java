/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase2;

import java.util.Scanner;

public class EjemploWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero = -1;

        // Ciclo while que se ejecuta mientras el número sea positivo
        while (numero > 0) {
            System.out.println("Número ingresado: " + numero);
            System.out.println("Ingrese otro número positivo (0 o negativo para salir):");
            numero = scanner.nextInt();
        }

        System.out.println("Fin del programa. Se ingresó un número no positivo.");
        scanner.close();
    }
}