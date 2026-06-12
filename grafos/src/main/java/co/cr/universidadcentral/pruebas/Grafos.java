/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package co.cr.universidadcentral.pruebas;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

/**
 *
 * @author fbarg
 */
public class Grafos {

    public static void main(String[] args) {
        // Establecer la propiedad del sistema para usar Swing
        System.setProperty("org.graphstream.ui", "swing");

        // Crear un nuevo grafo
        Graph grafo = new SingleGraph("MiGrafo");


        // Agregar vértices
        for (int i = 1; i <= 6; i++) {
            String nodeName = String.valueOf(i);
            grafo.addNode(nodeName);
            grafo.getNode(nodeName).setAttribute("ui.label", nodeName); // Establecer el nombre del nodo
        }

        // Agregar arcos
        grafo.addEdge("AB", "1", "2").setAttribute("ui.label", "AB");
        grafo.addEdge("AC", "1", "3").setAttribute("ui.label", "AC");
        //grafo.addEdge("AD", "1", "4").setAttribute("ui.label", "AD");
        grafo.addEdge("BD", "2", "4").setAttribute("ui.label", "BD");
        grafo.addEdge("BF", "2", "6").setAttribute("ui.label", "BF");
        grafo.addEdge("CE", "3", "5").setAttribute("ui.label", "CE");
        grafo.addEdge("DF", "4", "6").setAttribute("ui.label", "30");
        //grafo.addEdge("EF", "5", "6").setAttribute("ui.label", "DF");
        //grafo.addEdge("DC", "4", "3").setAttribute("ui.label", "DC");
        
        

        // Configurar el estilo del grafo
        grafo.setAttribute("ui.stylesheet", "node { fill-color: gray; size: 20px; } edge { fill-color: gray; }");

        grafo.setAttribute("ui.quality");
        grafo.setAttribute("ui.antialias");
        // Mostrar el grafo
        grafo.display();

        // Ejecutar DFS y BFS (si es necesario)
        // Puedes implementar métodos de búsqueda aquí si lo deseas.
    }

}
