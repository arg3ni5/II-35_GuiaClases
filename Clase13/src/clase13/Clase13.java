/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase13;

import arboles.ArbolBinario;
import arboles.grafico.PanelArbolAnimate;
import javax.swing.JFrame;

/**
 *
 * @author fbarg
 */
public class Clase13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArbolBinario<Integer> arbol = new ArbolBinario<>();
        
        
        // Ejemplo de agregar nodos
        arbol.insertar(50);
        arbol.insertar(40);
        arbol.insertar(60);
        arbol.insertar(65);
        arbol.insertar(70);
        arbol.insertar(30);
        arbol.insertar(45);
        arbol.insertar(58);
        arbol.insertar(30);
        
        JFrame frame = new JFrame("Visualización del Árbol Binario");
        PanelArbolAnimate<Integer> panel = new PanelArbolAnimate<>(arbol);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        
        frame.setSize(400, 400);
        frame.setVisible(true);
    }

}
