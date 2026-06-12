/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.cr.universidadcentral.pruebas;

import co.cr.universidadcentral.grafos.Grafo;

/**
 *
 * @author fbarg
 */
public class Main {

    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        // Agregar vértices
        for (int i = 1; i <= 6; i++) {
            grafo.agregarVertice(i);
        }

        // Agregar arcos
        grafo.agregarArco(1, 2);
        grafo.agregarArco(1, 3);
        grafo.agregarArco(2, 4);
        grafo.agregarArco(2, 6);
        grafo.agregarArco(3, 5);
        grafo.agregarArco(4, 6);

        int v = 4;
        for (int ady : grafo.obtenerAdyacentes(v)) {
            System.out.println(v + "-" + ady);
        }

//    [1]  2,3
//    [2]  4,6
//    [3]  5 
//    [4] 6
        // Ejecutar DFS y BFS
        grafo.dfs(1); // Iniciar DFS desde el vértice 1
        grafo.bfs(1); // Iniciar BFS desde el vértice 1
    }
}
