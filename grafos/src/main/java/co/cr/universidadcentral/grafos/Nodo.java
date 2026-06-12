/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.cr.universidadcentral.grafos;

/**
 *
 * @author fbarg
 */
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un nodo en un grafo.
 */
class Nodo {

    private int valor; // Valor o identificador del nodo
    private List<Nodo> adyacentes; // Lista de nodos adyacentes

    /**
     * Constructor para crear un nodo con un valor específico.
     *
     * @param valor el valor del nodo.
     */
    public Nodo(int valor) {
        this.valor = valor;
        this.adyacentes = new ArrayList<>();
    }

    /**
     * Obtiene el valor del nodo.
     *
     * @return el valor del nodo.
     */
    public int getValor() {
        return valor;
    }

    /**
     * Agrega un nodo adyacente a este nodo.
     *
     * @param nodo el nodo adyacente a agregar.
     */
    public void agregarAdyacente(Nodo nodo) {
        adyacentes.add(nodo);
    }

    /**
     * Obtiene la lista de nodos adyacentes.
     *
     * @return la lista de nodos adyacentes.
     */
    public List<Nodo> getAdyacentes() {
        return adyacentes;
    }
}
