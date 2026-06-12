/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.cr.universidadcentral.grafos.visual;

/**
 *
 * @author fbarg
 */
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.SingleGraph;

public class GrafoVisual {
    public static void main(String[] args) {
        // Crear un nuevo grafo
        Graph grafo = new SingleGraph("MiGrafo");

        // Agregar vértices
        grafo.addNode("A");
        grafo.addNode("B");
        grafo.addNode("C");
        grafo.addNode("D");

        // Agregar arcos
        grafo.addEdge("AB", "A", "B");
        grafo.addEdge("AC", "A", "C");
        grafo.addEdge("BD", "B", "D");
        grafo.addEdge("CD", "C", "D");

        // Configurar el estilo del grafo
        grafo.setAttribute("ui.stylesheet", "node { fill-color: blue; size: 20px; } edge { fill-color: gray; }");

        // Mostrar el grafo
        grafo.display();
    }
}

