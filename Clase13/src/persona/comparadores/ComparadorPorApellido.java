/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persona.comparadores;

import java.util.Comparator;
import persona.Persona;

/**
 *
 * @author fbarg
 */
public class ComparadorPorApellido implements Comparator<Persona>{
    @Override
    public int compare(Persona p1, Persona p2) {
        return p1.getApellido().compareTo(p2.getApellido()); // Comparar por nombre
    }
}
