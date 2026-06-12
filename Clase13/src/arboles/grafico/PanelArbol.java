package arboles.grafico;

import arboles.ArbolBinario;
import arboles.Nodo;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class PanelArbol<T extends Comparable<T>> extends JPanel {

    protected ArbolBinario<T> arbol;

    public PanelArbol(ArbolBinario<T> arbol) {
        this.arbol = arbol;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (arbol.getRaiz() != null) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            setBackground(Color.WHITE); // Fondo blanco
            g2d.setColor(Color.BLACK); // Color del texto
            g2d.setFont(new Font("Arial", Font.BOLD, 12)); // Fuente del texto
            dibujarArbol(g2d, arbol.getRaiz(), getWidth() / 2, 100, 80); // Ajusta el offset inicial
        }
    }

    private void dibujarArbol(Graphics2D g2d, Nodo<T> nodo, int x, int y, int distancia) {
        if (nodo != null) {
            dibujarOvalo(g2d, nodo.getDato().toString(), x, y);

            if (nodo.getIzquierda() != null) {
                dibujarLinea(g2d, x, y + 15, x - distancia, y + 50);
                dibujarArbol(g2d, nodo.getIzquierda(), x - distancia, y + 50, (int) Math.round(distancia / 1.5));
            }
            if (nodo.getDerecha() != null) {
                dibujarLinea(g2d, x, y + 15, x + distancia, y + 50);
                dibujarArbol(g2d, nodo.getDerecha(), x + distancia, y + 50, (int) Math.round(distancia / 1.5));
            }
        }
    }

    private void dibujarNodos(Graphics2D g2d, Nodo<?> nodo, int x, int y, int offset) {
        if (nodo == null) {
            return;
        }

        // Dibuja las conexiones con los hijos
        if (nodo.getIzquierda() != null) {
            dibujarNodoIzquierda(g2d, nodo, x, y, offset);
        }
        if (nodo.getDerecha() != null) {
            dibujarNodoDerecha(g2d, nodo, x, y, offset);
        }

        // Dibuja el nodo después de las líneas
        dibujarOvalo(g2d, nodo.getDato().toString(), x, y);
    }

    private void dibujarNodoIzquierda(Graphics2D g2d, Nodo<?> nodo, int x, int y, int offset) {
        // Calcula la posición del hijo izquierdo
        int childX = x - offset;
        int childY = y + 50; // Ajusta la altura según sea necesario
        dibujarLinea(g2d, x, y + 20, childX + 20, childY); // Línea hacia el hijo izquierdo
        dibujarNodos(g2d, nodo.getIzquierda(), childX, childY, Math.max((int) (offset / 1.5), 30)); // Conversión a int
    }

    private void dibujarNodoDerecha(Graphics2D g2d, Nodo<?> nodo, int x, int y, int offset) {
        // Calcula la posición del hijo derecho
        int childX = x + offset;
        int childY = y + 50; // Ajusta la altura según sea necesario
        dibujarLinea(g2d, x, y + 20, childX - 20, childY); // Línea hacia el hijo derecho
        dibujarNodos(g2d, nodo.getDerecha(), childX, childY, Math.max((int) (offset / 1.5), 30)); // Conversión a int
    }

    protected void dibujarOvalo(Graphics2D g2d, String texto, int x, int y) {
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fillOval(x - 15, y - 15, 30, 30); // Dibuja un círculo alrededor del nodo
        g2d.setColor(Color.BLACK);
        g2d.drawString(texto, x - 10, y + 5); // Ajusta la posición del texto
    }

    protected void dibujarLinea(Graphics2D g2d, int x1, int y1, int x2, int y2) {
        g2d.setColor(Color.BLACK);
        g2d.drawLine(x1, y1, x2, y2); // Dibuja una línea entre dos puntos
    }

    public void insertar(T dato) {
        arbol.insertar(dato); // Llama al método de inserción del árbol
        repaint(); // Redibuja el panel para mostrar el nuevo estado del árbol
    }
}
