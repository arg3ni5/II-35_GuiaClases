/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase12;

/**
 *
 * @author fbarg
 */
public class ContarOcurrencias {
    //***********************
    //RECURSIVIDAD
    //***********************

    public static int contarOcurrencias(int[] array, int objetivo, int indice) {
        System.out.println("indice" + indice);
        if (indice >= array.length) { // Caso base o validación de salida
            return 0;
        } else if (array[indice] == objetivo) {
            return 1 + contarOcurrencias(array, objetivo, indice + 1); // Llamada recursiva si hay coincidencia
        } else {
            return contarOcurrencias(array, objetivo, indice + 1); // Llamada recursiva si no hay coincidencia
        }
    }

    // 1 + 1 + 1 + 0
    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 1, 4, 1};
        int objetivo = 2;
        System.out.println("El número " + objetivo + " aparece " + contarOcurrencias(numeros, objetivo, 0) + " veces.");
    }
    

    /*
    contarOcurrencias -> numeros -> 2 -> 0
    
    contarOcurrencias(array, 2, 0) + 
    contarOcurrencias(array, 2, 1) + (1)
    contarOcurrencias(array, 2, 2) + 
    contarOcurrencias(array, 2, 3) + (1)
    contarOcurrencias(array, 2, 4) +
    contarOcurrencias(array, 2, 5) + (1)
    contarOcurrencias(array, 2, 6) + 
     */
}
