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

public class GrafoConGraphics extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibujar nodos
        int radius = 20;
        int x1 = 100, y1 = 100; // Nodo 1
        int x2 = 200, y2 = 100; // Nodo 2
        int x3 = 150, y3 = 200; // Nodo 3
        int x4 = 250, y4 = 200; // Nodo 4

        // Dibujar círculos (nodos)
        g.setColor(Color.BLUE);
        g.fillOval(x1 - radius, y1 - radius, radius * 2, radius * 2);
        g.fillOval(x2 - radius, y2 - radius, radius * 2, radius * 2);
        g.fillOval(x3 - radius, y3 - radius, radius * 2, radius * 2);
        g.fillOval(x4 - radius, y4 - radius, radius * 2, radius * 2);

        // Dibujar etiquetas (nombres de los nodos)
        g.setColor(Color.WHITE);
        g.drawString("1", x1 - 5, y1 + 5);
        g.drawString("2", x2 - 5, y2 + 5);
        g.drawString("3", x3 - 5, y3 + 5);
        g.drawString("4", x4 - 5, y4 + 5);

        // Dibujar arcos (conexiones entre nodos)
        g.setColor(Color.GRAY);
        g.drawLine(x1, y1, x2, y2); // Arco entre nodo 1 y nodo 2
        g.drawLine(x1, y1, x3, y3); // Arco entre nodo 1 y nodo 3
        g.drawLine(x2, y2, x4, y4); // Arco entre nodo 2 y nodo 4
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Grafo con Graphics");
        GrafoConGraphics panel = new GrafoConGraphics();
        
        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

