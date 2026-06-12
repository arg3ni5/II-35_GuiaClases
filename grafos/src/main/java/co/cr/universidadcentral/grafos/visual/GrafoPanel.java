/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.cr.universidadcentral.grafos.visual;

/**
 *
 * @author fbarg
 */
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import co.cr.universidadcentral.grafos.Grafo;

public class GrafoPanel extends JPanel {

    private Grafo grafo;

    public GrafoPanel(Grafo grafo) {
        this.grafo = grafo;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        dibujarGrafo(g);
    }

    private void dibujarGrafo(Graphics g) {
        Random rand = new Random();
        int width = getWidth();
        int height = getHeight();

        // Crear posiciones aleatorias para los nodos
        Map<Integer, Point> posiciones = new HashMap<>();

        for (Integer vertice : grafo.obtenerVertices()) {
            int x = rand.nextInt(width - 50) + 25; // Asegurarse de que no se salga del panel
            int y = rand.nextInt(height - 50) + 25;
            posiciones.put(vertice, new Point(x, y));
            g.fillOval(x - 15, y - 15, 30, 30); // Dibujar el nodo
            g.drawString(vertice.toString(), x - 5, y + 5); // Dibujar el nombre del nodo
        }

        // Dibujar arcos
        for (Integer vertice : grafo.obtenerVertices()) {
            List<Integer> adyacentes = grafo.obtenerAdyacentes(vertice);
            Point puntoOrigen = posiciones.get(vertice);

            for (Integer adyacente : adyacentes) {
                Point puntoDestino = posiciones.get(adyacente);
                g.drawLine(puntoOrigen.x, puntoOrigen.y, puntoDestino.x, puntoDestino.y); // Dibujar arco
            }
        }
    }
}
