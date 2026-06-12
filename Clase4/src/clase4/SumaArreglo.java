/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase4;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fbarg
 */
public class SumaArreglo {

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el tamaño del arreglo");

        int size = scanner.nextInt();
        int[] arreglo = new int[size];
        int suma = 0;
        
        for (int i = 0; i < size; i++) {
            System.out.println("Ingrese el elemento " + (i + 1));
            arreglo[i] = scanner.nextInt();
            suma += arreglo[i];
        }

        System.out.println("La suma de los elementos es: " + suma);
    }
}
