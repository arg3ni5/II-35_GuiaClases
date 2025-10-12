/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase2;

/**
 *
 * @author fbarg
 */
public class Ejemplo2 {

    public static void main(String args[]) {
        int[] diasDelMes;
        diasDelMes = new int[12];

        diasDelMes[0] = 31;
        diasDelMes[1] = 29;
        diasDelMes[2] = 31;
        diasDelMes[3] = 30;
        diasDelMes[4] = 31;
        diasDelMes[5] = 30;
        diasDelMes[6] = 31;
        diasDelMes[7] = 31;
        diasDelMes[8] = 30;
        diasDelMes[9] = 31;
        diasDelMes[10] = 30;
        diasDelMes[11] = 31;

        String[] meses = {
            "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };

        System.out.println("Enero tiene " + diasDelMes[0] + " dias.");
        System.out.println("Febrero tiene " + diasDelMes[1] + " dias.");

    }
}
