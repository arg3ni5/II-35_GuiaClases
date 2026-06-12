/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase12;

/**
 *
 * @author fbarg
 */
public class InvertirString {

    public static String invertir(String str, int index) {
        String letra = String.valueOf(str.charAt(index));
        
        System.out.println(index + ":" + letra);

        if (index == 0) { // Caso base o condicion de salida(parada)
            return letra;
        } else {
            return letra + invertir(str, index - 1); // Llamada recursiva
        }
    }
    
    //o + d + n + u +M
    //str.charAt(4) + invertir(str, 3) + invertir(str, 2) + invertir(str, 1) + invertir(str, 0)
    public static void main(String[] args) {
        //0 1 2 3 4
        String palabra = "Mundo";
        //System.out.println("length: " + (palabra.length() - 1));
        System.out.println("Palabra invertida: " + invertir(palabra, palabra.length() - 1));
    }
}
