/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author fbarg
 */
public class Clase3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Inicializar lista
        ArrayList<String> listaNombre = new ArrayList<>();

        //Agregar a la lista
        listaNombre.add("Alejandro Fernandez");
        listaNombre.add("Carlos Muñoz");
        listaNombre.add("Aaron Solis");
        listaNombre.add("Kiara Solano");
        listaNombre.add("Kiara Solano");

        // Tamaño de la lista
        System.out.printf("Size: %d", listaNombre.size());
        System.out.println();

        System.out.println(listaNombre);

        // Desordenar lista
        Collections.shuffle(listaNombre);

        //Obtener frecuncia de elemento de la lista
        System.out.printf("frequency Kiara Solano: %s \n",
                Collections.frequency(listaNombre, "Kiara Solano"));

        //Agregar a una posicion especifica
        listaNombre.add(0, "Jorge Gonzalez");

        System.out.printf("binarySearch Alejandro Fernandez: %s \n",
                Collections.binarySearch(listaNombre, "Alejandro Fernandez"));

        System.out.println("--------------------");
        System.out.println(listaNombre);

        // Eliminar de la lista
        System.out.println("--------------------");
        listaNombre.remove("Kiara Solano");
        System.out.println(listaNombre);

        // ordenar lista
        System.out.println("*********************");
        Collections.sort(listaNombre);
        System.out.println(listaNombre);

        int i = 1;
        for (String nombre : listaNombre) {
            System.out.println((i++) + ":" + nombre);
        }

        //Recoger la lista con iterator
        System.out.println("Usando un iterador:");
        Iterator<String> ite = listaNombre.iterator();

        int j = 0;
        while (ite.hasNext()) {
            System.out.println((j++) + ":" + ite.next());
        }

        // Reversa
        System.out.println("--------------------");
        System.out.println(listaNombre);
        System.out.println("--------------------");
        System.out.println("Reversa:");
        Collections.reverse(listaNombre);
        System.out.println(listaNombre);

    }

}
