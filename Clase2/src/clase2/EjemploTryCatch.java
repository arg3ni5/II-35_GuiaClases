/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase2;

import javax.swing.JOptionPane;

/**
 *
 * @author fbarg
 */
public class EjemploTryCatch {

    public static void main(String[] args) {
        try {
            double a = Double.parseDouble(JOptionPane.showInputDialog("Numero 1"));
            double b = Double.parseDouble(JOptionPane.showInputDialog("Numero 2"));
            double d = 2.5;

            double resultado = a + b;

            System.out.println(resultado);
            JOptionPane.showMessageDialog(null, "El Resultado es " + resultado);

        } catch (Exception e) {
            String errMsg = "Mensaje de error:" + e;
            System.err.println(errMsg);
            JOptionPane.showMessageDialog(null, errMsg);
        }
    }
}
