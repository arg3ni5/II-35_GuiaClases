/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arboles;

import arboles.grafico.PanelArbol;
import arboles.grafico.PanelArbolAnimate;
import javax.swing.JFrame;

/**
 *
 * @author fbarg
 */
public class PruebaArbolNombres {

    public static void main(String[] args) {
        ArbolBinario<String> arbol = new ArbolBinario<>(); // Crear un nuevo árbol binario para nombres

        // Insertar nombres en el árbol
        arbol.insertar("Charlie");
        arbol.insertar("Diana");
        arbol.insertar("Bob");
        arbol.insertar("Eve");
        arbol.insertar("Alice");

        // Mostrar el recorrido en orden
        System.out.println("Recorrido en orden:");
        arbol.inOrden(arbol.getRaiz()); // Llamar al método de recorrido en orden

        JFrame frame = new JFrame("Árbol Binario");
        PanelArbolAnimate panel = new PanelArbolAnimate(arbol);

        frame.add(panel);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

//        JFrame frame2 = new JFrame("Visualización del Árbol Binario");
//
//        // Usar PanelArbolInteger en lugar de PanelArbol
//        PanelArbol panel2 = new PanelArbol(arbol);
//        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame2.add(panel2);
//
//        frame2.setSize(600, 600);
//        frame2.setVisible(true);
    }

}
