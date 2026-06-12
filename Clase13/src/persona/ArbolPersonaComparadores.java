/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persona;

import arboles.ArbolBinario;
import persona.comparadores.ComparadorPorApellido;
import persona.comparadores.ComparadorPorNombre;

/**
 *
 * @author fbarg
 */
public class ArbolPersonaComparadores {

    public static void main(String[] args) {
        ArbolBinario<Persona> arbolPorEdad = new ArbolBinario<>();

        Persona p0 = new Persona("Daniel", "Brown", 10);
        Persona p1 = new Persona("Alice", "Smith", 30);
        Persona p2 = new Persona("Bob", "Johnson", 25);
        Persona p3 = new Persona("Charlie", "Mayor", 35);

        // Insertar usando el mÈtodo por defecto (por edad)
        arbolPorEdad.insertar(p1);
        arbolPorEdad.insertar(p2);
        arbolPorEdad.insertar(p0);
        arbolPorEdad.insertar(p3);

        System.out.println("\n¡rbol ordenado por edad:");
        arbolPorEdad.inOrden(arbolPorEdad.getRaiz());

        ArbolBinario<Persona> arbolPorNombre = new ArbolBinario<>();

        // Insertar usando un comparador por nombre
        arbolPorNombre.insertar(p0, new ComparadorPorNombre());
        arbolPorNombre.insertar(p1, new ComparadorPorNombre());
        arbolPorNombre.insertar(p2, new ComparadorPorNombre());
        arbolPorNombre.insertar(p3, new ComparadorPorNombre());

        System.out.println("\n¡rbol ordenado por nombre:");
        arbolPorNombre.inOrden(arbolPorNombre.getRaiz());
        
        
        ArbolBinario<Persona> arbolPorApe = new ArbolBinario<>();

        // Insertar usando un comparador por nombre
        arbolPorApe.insertar(p0, new ComparadorPorApellido());
        arbolPorApe.insertar(p1, new ComparadorPorApellido());
        arbolPorApe.insertar(p2, new ComparadorPorApellido());
        arbolPorApe.insertar(p3, new ComparadorPorApellido());

        System.out.println("\n¡rbol ordenado por apellido:");
        arbolPorNombre.inOrden(arbolPorApe.getRaiz());
        
        
    }

}
