/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase2;

/**
 *
 * @author fbarg
 */
public class EjemploValidaciones {

    public static void main(String args[]) {
        int mes = 0;
        String[] meses = {
            "Mes desconocido",
            "Enero",
            "Febrero",
            "Marzo",
            "Abril",
            "Mayo",
            "Junio",
            "Julio",
            "Agosto",
            "Septiembre",
            "Octubre",
            "Noviembre",
            "Diciembre"
        };

        String estacion;

        if (mes == 12 || mes == 1 || mes == 2) {
            estacion = "el Invierno";
        } else if (mes == 3 || mes == 4 || mes == 5) {
            estacion = "la primavera";
        } else if (mes == 6 || mes == 7 || mes == 8) {
            estacion = "el verano";
        } else if (mes >= 9 && mes <= 11) {
            estacion = "el Otoño";
        } else {
            estacion = "Mes desconocido";
        }

        //System.out.println(meses[3]+" esta en " + estacion + ".");

        for (int i = 1; i < meses.length; i++) {
            System.out.println(meses[i]+" esta en " + estacion + ".");
        }
    }
}
