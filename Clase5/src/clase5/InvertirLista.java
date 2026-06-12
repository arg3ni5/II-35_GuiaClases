/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase5;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author fbarg
 */
public class InvertirLista {

    public static List<String> invertirLista(List<String> lista) {
        Stack<String> pila = new Stack<>();
        

        // Apilar todos los elementos de la lista
        for (String elemento : lista) {
            pila.push(elemento);
        }

        // Crear una nueva lista para almacenar los elementos invertidos
        List<String> listaInvertida = new java.util.ArrayList<>();

        // Desapilar los elementos y agregarlos a la nueva lista
        while (!pila.isEmpty()) {
            listaInvertida.add(pila.pop());
        }

        return listaInvertida;
    }

    public static void main(String[] args) {
        List<String> listaOriginal = Arrays.asList("Uno", "Dos", "Tres", "Cuatro", "Cinco");
        
        
        System.out.println("Lista Original: " + listaOriginal);

        List<String> listaInvertida = invertirLista(listaOriginal);

        System.out.println("Lista Invertida: " + listaInvertida);
    }
   /* listaInvertida =>      Cinco, Cuatro, Tres, Dos, Uno */       
}
