/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persona;

/**
 *
 * @author fbarg
 */
public class Empleado extends Persona {

    private Persona persona;
    private int idEmpleado;

    /**
     * @return the persona
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * @param persona the persona to set
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * @return the idEmpleado
     */
    public int getIdEmpleado() {
        return idEmpleado;
    }

    /**
     * @param idEmpleado the idEmpleado to set
     */
    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Empleado(Persona persona, int idEmpleado) {
        this.persona = persona;
        this.idEmpleado = idEmpleado;
    }

    public Empleado(int idEmpleado, String nombre, String apellido, int edad) {        
        super(nombre, apellido, edad);
        this.persona = new Persona(nombre, apellido, edad);
        this.idEmpleado = idEmpleado;
    }

    public Empleado(Persona persona, int idEmpleado, String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
        this.persona = persona;
        this.idEmpleado = idEmpleado;
    }

    public static void main(String[] args) {
        Persona p = new Persona("YARITZA", "ACUÑA", 24);
        Empleado e100 = new Empleado(p, 100);
        Empleado e101 = new Empleado(101, "ALEJANDRO", "FERNANDEZ", 20);
        System.out.println(e100);
        System.out.println(e101);
    }

    @Override
    public String toString() {
        return "Empleado{" + "persona=" + persona + ", idEmpleado=" + idEmpleado + '}';
    }
}
