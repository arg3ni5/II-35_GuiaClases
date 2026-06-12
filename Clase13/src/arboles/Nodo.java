/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arboles;

/**
 *
 * @author fbarg
 */
public class Nodo<T extends Comparable<T>> {

    private T dato;          // Valor del nodo
    private Nodo<T> izquierda;  // Referencia al hijo izquierdo
    private Nodo<T> derecha;    // Referencia al hijo derecho

    public Nodo(T dato) {
        this.dato = dato;
        this.izquierda = null;
        this.derecha = null;
    }

    /**
     * @return the dato
     */
    public T getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(T dato) {
        this.dato = dato;
    }

    /**
     * @return the izquierda
     */
    public Nodo<T> getIzquierda() {
        return izquierda;
    }

    /**
     * @param izquierda the izquierda to set
     */
    public void setIzquierda(Nodo<T> izquierda) {
        this.izquierda = izquierda;
    }

    /**
     * @return the derecha
     */
    public Nodo<T> getDerecha() {
        return derecha;
    }

    /**
     * @param derecha the derecha to set
     */
    public void setDerecha(Nodo<T> derecha) {
        this.derecha = derecha;
    }  

    public int compareTo(Nodo<T> otro) {
        return this.dato.compareTo(otro.dato);
    }

    public boolean esHoja() {
        return getIzquierda() == null && getDerecha() == null;
    }

    @Override
    public String toString() {
        return "Nodo{" + "dato=" + dato + '}';
    }

}
