/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase4;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author fbarg
 */
public class SumaArregloValidado {

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
       
        int size = 0;

        System.out.println("Ingrese el tamaño del arreglo");

        while (true) {
            try {
                size = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño del arreglo"));
                if (size > 0) {
                    break;
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Error: Debe ingresar un numero mayor que 0", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Error: Debe ingresar un numero entero. Intente de nuevo", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        int[] arreglo = new int[size];
        int suma = 0;

        for (int i = 0; i < size; i++) {
            while (true) {
                try {
                    arreglo[i] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el elemento " + (i + 1)));
                    suma += arreglo[i];
                    break;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,
                        "Error: Debe ingresar un numero entero. Intente de nuevo", "Error",
                        JOptionPane.ERROR_MESSAGE);
                } catch (java.lang.ArrayIndexOutOfBoundsException e) {
                    JOptionPane.showMessageDialog(null,
                        "Error: Se excedio el tamaño del arreglo", "Error",
                        JOptionPane.ERROR_MESSAGE);
                }

            }
        }
        JOptionPane.showMessageDialog(null, "La suma de los elementos " + Arrays.toString(arreglo) + " es: " + suma);

    }
}
