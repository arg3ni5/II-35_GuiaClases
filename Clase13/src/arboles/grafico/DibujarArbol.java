/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author fbarg
 */
package arboles.grafico;

import arboles.ArbolBinario;
import arboles.Nodo;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class DibujarArbol extends JPanel {

    private ArbolBinario<?> arbol; // El árbol binario a dibujar
    private Queue<Nodo<?>> nodosPorAgregar; // Cola de nodos a agregar

    public DibujarArbol(ArbolBinario<?> arbol) {
        this.arbol = arbol;
        setBackground(Color.WHITE); // Fondo blanco
        setPreferredSize(new Dimension(600, 400)); // Tamaño preferido del panel
        nodosPorAgregar = new LinkedList<>(arbol.obtenerNodos()); // Cargar nodos existentes en la cola
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (!nodosPorAgregar.isEmpty()) {
            Nodo<?> nodoActual = nodosPorAgregar.poll(); // Obtiene el siguiente nodo a dibujar
            dibujarArbol(g2d, nodoActual, getWidth() / 2, 40, 100);
        }
    }

    private void dibujarArbol(Graphics2D g2d, Nodo<?> nodo, int x, int y, int distancia) {
        if (nodo != null) {
            // Dibuja el nodo
            g2d.setColor(Color.LIGHT_GRAY);
            g2d.fillOval(x - 15, y - 15, 30, 30); // Dibuja el óvalo del nodo
            g2d.setColor(Color.BLACK);
            g2d.drawString(nodo.getDato().toString(), x - 10, y + 5); // Dibuja el texto del nodo

            // Dibuja las líneas hacia los hijos
            if (nodo.getIzquierda() != null) {
                g2d.drawLine(x, y + 5, x - distancia, y + 50); // Línea hacia el hijo izquierdo
                dibujarArbol(g2d, nodo.getIzquierda(), x - distancia, y + 50, distancia / 2); // Llama recursivamente para el hijo izquierdo
            }
            if (nodo.getDerecha() != null) {
                g2d.drawLine(x, y + 5, x + distancia, y + 50); // Línea hacia el hijo derecho
                dibujarArbol(g2d, nodo.getDerecha(), x + distancia, y + 50, distancia / 2); // Llama recursivamente para el hijo derecho
            }
        }
    }
}
