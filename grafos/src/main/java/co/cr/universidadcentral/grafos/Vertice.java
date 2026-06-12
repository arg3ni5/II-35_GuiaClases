/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.cr.universidadcentral.grafos;

/**
 *
 * @author fbarg
 */
public class Vertice {

    private String nombre;
    private int numVertice;

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
     * @return the numVertice
     */
    public int getNumVertice() {
        return numVertice;
    }

    /**
     * @param numVertice the numVertice to set
     */
    public void setNumVertice(int numVertice) {
        this.numVertice = numVertice;
    }

    public Vertice(String nombre) {
        this.nombre = nombre;
        this.numVertice = -1;
    }

    public boolean equals(Vertice n) {
        return nombre.equals(n.nombre);
    }

    @Override
    public String toString() {
        return nombre + " (" + numVertice + ')';
    }

}
