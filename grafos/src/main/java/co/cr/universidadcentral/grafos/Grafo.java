/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.cr.universidadcentral.grafos;

/**
 *
 * @author fbarg
 */
import java.util.*;

import java.util.*;

/**
 * Clase que representa un grafo dirigido utilizando una lista de adyacencia.
 */
public class Grafo {

    // Mapa que almacena la lista de adyacencia del grafo
    private Map<Integer, List<Integer>> adjList;

    /**
     * Constructor que inicializa un nuevo grafo vacío.
     */
    public Grafo() {
        adjList = new HashMap<>();
    }

    /**
     * Agrega un vértice al grafo.
     *
     * @param v el identificador del vértice a agregar.
     */
    public void agregarVertice(int v) {
        adjList.putIfAbsent(v, new ArrayList<>());
    }

    /**
     * Agrega un arco dirigido entre dos vértices en el grafo.
     *
     * @param origen el vértice de origen del arco.
     * @param destino el vértice de destino del arco.
     */
    public void agregarArco(int origen, int destino) {
        // Asegurarse de que ambos vértices existan en el grafo
        agregarVertice(origen);
        agregarVertice(destino);
        adjList.get(origen).add(destino);
    }

    /**
     * Obtiene la lista de vértices adyacentes a un vértice dado.
     *
     * @param v el vértice del cual se desean obtener los adyacentes.
     * @return una lista de enteros que representan los vértices adyacentes.
     */
    public List<Integer> obtenerAdyacentes(int v) {
        return adjList.getOrDefault(v, new ArrayList<>());
    }

    /**
     * Obtiene todos los vértices del grafo.
     *
     * @return un conjunto de enteros que representan los vértices del grafo.
     */
    public Set<Integer> obtenerVertices() {
        return adjList.keySet();
    }

    /**
     * Realiza una búsqueda en profundidad (DFS) desde un vértice inicial.
     *
     * @param inicio el vértice desde el cual comenzar la búsqueda.
     */
    public void dfs(int inicio) {
        Set<Integer> visitados = new HashSet<>();
        System.out.print("DFS desde " + inicio + ": ");
        dfsRecursivo(inicio, visitados);
        System.out.println();
    }

    /**
     * Método recursivo auxiliar para realizar DFS.
     *
     * @param v el vértice actual en la búsqueda.
     * @param visitados conjunto de vértices ya visitados.
     */
    private void dfsRecursivo(int v, Set<Integer> visitados) {
        visitados.add(v);
        System.out.print(v + " ");
        for (int vecino : obtenerAdyacentes(v)) {
            if (!visitados.contains(vecino)) {
                dfsRecursivo(vecino, visitados);
            }
        }
    }

    /**
     * Realiza una búsqueda en amplitud (BFS) desde un vértice inicial.
     *
     * @param inicio el vértice desde el cual comenzar la búsqueda.
     */
    public void bfs(int inicio) {
        Set<Integer> visitados = new HashSet<>();
        Queue<Integer> cola = new LinkedList<>();
        cola.add(inicio);
        visitados.add(inicio);

        System.out.print("BFS desde " + inicio + ": ");

        while (!cola.isEmpty()) {
            int v = cola.poll();
            System.out.print(v + " ");
            for (int vecino : obtenerAdyacentes(v)) {
                if (!visitados.contains(vecino)) {
                    visitados.add(vecino);
                    cola.add(vecino);
                }
            }
        }
        System.out.println();
    }
}
