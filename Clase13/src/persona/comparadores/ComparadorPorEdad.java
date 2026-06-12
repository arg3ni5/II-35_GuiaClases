/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persona.comparadores;

import persona.Persona;
import java.util.Comparator;

/**
 *
 * @author fbarg
 */
public class ComparadorPorEdad implements Comparator<Persona> {
    @Override
    public int compare(Persona p1, Persona p2) {
        return Integer.compare(p1.getEdad(), p2.getEdad()); // Comparar por edad
    }
}
