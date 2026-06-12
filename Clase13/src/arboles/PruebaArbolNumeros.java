/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arboles;

import arboles.grafico.FrameArbol;
import arboles.grafico.PanelArbolAnimate;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author fbarg
 */
public class PruebaArbolNumeros {

    public static void main(String[] args) {
        ArbolBinario<Integer> arbol = new ArbolBinario<>(); // Crear un nuevo árbol binario de enteros

        // Insertar nodos en el árbol
        arbol.insertar(5);
        arbol.insertar(3);
        arbol.insertar(7);
        arbol.insertar(2);
        arbol.insertar(4);
        arbol.insertar(6);
        arbol.insertar(8);
        arbol.insertar(1);

        System.out.println("inorden");
        arbol.inOrden(arbol.getRaiz());

        // Usar FrameArbol
        PanelArbolAnimate panel = new PanelArbolAnimate(arbol);
        new FrameArbol(panel);

    }
}
