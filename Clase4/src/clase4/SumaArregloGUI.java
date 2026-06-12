/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase4;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author fbarg
 */
public class SumaArregloGUI {

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));

        int size = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño del arreglo"));
        int[] arreglo = new int[size];
        int suma = 0;
        
        for (int i = 0; i < size; i++) {
            arreglo[i] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el elemento " + (i + 1)));
            suma += arreglo[i];
        }
        JOptionPane.showMessageDialog(null, "La suma de los elementos es: " + suma);
    }
}
