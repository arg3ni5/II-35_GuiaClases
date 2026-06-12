package clase8;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author fbarg
 * @param <T>
 */
public class Nodo<T>{
    T dato; // Valor del Nodo
    Nodo siguiente; // Referencia al siguiente nodo

    public Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    @Override
    public String toString() {
        return "Nodo{" + "dato=" + dato + ", siguiente=" + siguiente + '}';
    }    
    
}
