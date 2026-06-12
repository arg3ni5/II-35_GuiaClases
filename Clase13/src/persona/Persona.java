/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persona;

/**
 *
 * @author fbarg
 */
public class Persona implements Comparable<Persona> {

    private String nombre;
    private String apellido;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public Persona(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Método para comparar personas por nombre
    @Override
    public int compareTo(Persona otra) {
        return Integer.compare(this.edad, otra.edad); // Comparar por edad por defecto
        //return this.getApellido().compareTo(otra.getApellido()); // Comparar por nombre
    }

    @Override
    public String toString() {
        if (getApellido() == null) {
            return nombre + " (" + edad + ")";
        }
        return getNombre() + " " + getApellido() + ", Edad: " + getEdad();
    }

}
