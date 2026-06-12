/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arboles.grafico;

import arboles.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author fbarg
 */
public class PanelArbolDinamico<T extends Comparable<T>> extends JPanel {
    private ArbolBinario<T> arbol;
    private String nuevoDato; // Almacena el nuevo dato a agregar
    private boolean animando = false; // Indica si hay una animación en curso
    private int animX, animY; // Coordenadas para la animación

    public PanelArbolDinamico(ArbolBinario<T> arbol) {
        this.arbol = arbol;
        setLayout(new BorderLayout());

        // Campo de texto para ingresar el dato
        JTextField inputField = new JTextField();
        inputField.setPreferredSize(new Dimension(200, 30)); // Tamaño preferido
        JButton addButton = new JButton("Agregar Nodo");

        // Acción para agregar el nodo
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                if (!input.isEmpty() && !animando) { // Solo agrega si no hay animación
                    nuevoDato = input; // Guarda el nuevo dato
                    inputField.setText(""); // Limpia el campo de texto
                    iniciarAnimacion(); // Inicia la animación
                }
            }
        });

        JPanel controlPanel = new JPanel();
        controlPanel.add(inputField);
        controlPanel.add(addButton);

        add(controlPanel, BorderLayout.NORTH); // Agrega el panel de control al norte
    }

    private void iniciarAnimacion() {
        animando = true; // Indica que estamos en una animación

        Timer timer = new Timer(50, new ActionListener() { // Timer para la animación
            int step = 0; // Contador para los pasos de la animación

            @Override
            public void actionPerformed(ActionEvent e) {
                if (step < 20) { // Número de pasos de la animación
                    step++;
                    animX = getWidth() / 2; // Posición inicial X del nuevo nodo
                    animY = 80 + step * 2; // Posición Y del nuevo nodo (aumenta con cada paso)
                    repaint(); // Redibuja el panel
                } else {
                    ((Timer)e.getSource()).stop(); // Detiene el timer
                    arbol.insertar((T) nuevoDato); // Inserta el nuevo nodo en el árbol
                    nuevoDato = null; // Limpia la variable del nuevo dato
                    animando = false; // Finaliza la animación
                    repaint(); // Redibuja el panel final
                }
            }
        });
        
        timer.start(); // Inicia la animación
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        setBackground(Color.WHITE); // Fondo blanco
        g2d.setColor(Color.BLACK); // Color del texto
        g2d.setFont(new Font("Arial", Font.BOLD, 12)); // Fuente del texto
        
        dibujarArbol(g2d, arbol.getRaiz(), getWidth() / 2, 80, 100);

        if (animando && nuevoDato != null) { // Si estamos en una animación
            g2d.setColor(Color.LIGHT_GRAY);
            g2d.fillOval(animX - 15, animY - 15, 30, 30); // Dibuja un círculo alrededor del nodo en movimiento
            g2d.setColor(Color.BLACK);
            g2d.drawString(nuevoDato, animX - 10, animY + 5); // Ajusta la posición del texto en movimiento
        }
    }

    private void dibujarArbol(Graphics2D g2d, Nodo<T> nodo, int x, int y, int distancia) {
        if (nodo != null) {
            g2d.setColor(Color.LIGHT_GRAY);
            g2d.fillOval(x - 15, y - 15, 30, 30); // Dibuja un círculo alrededor del nodo
            g2d.setColor(Color.BLACK);
            g2d.drawString(nodo.getDato().toString(), x - 10, y + 5); // Ajusta la posición del texto

            if (nodo.getIzquierda() != null) {
                g2d.drawLine(x, y + 5, x - distancia, y + 50);
                dibujarArbol(g2d, nodo.getIzquierda(), x - distancia, y + 50, (int) Math.round(distancia / 1.5)); 
            }
            if (nodo.getDerecha() != null) {
                g2d.drawLine(x, y + 5, x + distancia, y + 50);
                dibujarArbol(g2d, nodo.getDerecha(), x + distancia, y + 50, (int) Math.round(distancia / 1.5)); 
            }
        }
    }
}