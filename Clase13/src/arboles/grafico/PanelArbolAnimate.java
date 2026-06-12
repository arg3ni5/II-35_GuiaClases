package arboles.grafico;

import arboles.ArbolBinario;
import arboles.Nodo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Queue;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class PanelArbolAnimate<T extends Comparable<T>> extends JPanel {

    private ArbolBinario<T> arbol; // Árbol para almacenar objetos Persona
    private Queue<Nodo<T>> nodosEnOrden; // Cola de personas a agregar
    private boolean animando = false; // Indica si hay una animación en curso
    private Timer timer; // Temporizador para la animación

    public PanelArbolAnimate() {
        this(new ArbolBinario<>()); // Inicializa con un árbol vacío
    }

    public PanelArbolAnimate(ArbolBinario<T> arbol) {
        this.arbol = new ArbolBinario<>();
        this.nodosEnOrden = arbol.obtenerNodos();
        setLayout(new BorderLayout());
        //crearPanelDeControl();

        if (!nodosEnOrden.isEmpty()) {
            iniciarAnimacion();
        }
    }

    private void crearPanelDeControl() {
        JTextField nameField = crearCampoTexto("Nombre:");

        JButton addButton = new JButton("Reproducir");
        //addButton.addActionListener(e -> agregarPersona(nameField, ageField));

        JPanel controlPanel = new JPanel();
        controlPanel.add(new JLabel("Nombre:"));
        controlPanel.add(nameField);
        controlPanel.add(addButton);

        add(controlPanel, BorderLayout.NORTH); // Agrega el panel de control al norte
    }

    private JTextField crearCampoTexto(String label) {
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(100, 30)); // Tamaño preferido
        return textField;
    }

    private void iniciarAnimacion() {
        if (!nodosEnOrden.isEmpty()) {
            animando = true; // Indica que estamos en una animación

            timer = new Timer(1000, e -> realizarAnimacion()); // Temporizador para agregar nodos cada segundo
            timer.start();
        }
    }

    private void realizarAnimacion() {
        if (!nodosEnOrden.isEmpty()) {
            Nodo<T> nodo = nodosEnOrden.poll(); // Obtiene la siguiente persona de la cola
            arbol.insertar(nodo.getDato()); // Inserta el nuevo nodo en el árbol

            repaint(); // Redibuja el panel para mostrar el nuevo estado del árbol
        } else {
            animando = false; // Finaliza la animación cuando ya no hay más personas
            timer.stop(); // Detiene el timer si no hay más personas
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        setBackground(Color.WHITE);
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 12));

        if (arbol != null && arbol.getRaiz() != null) {
            dibujarArbol(g2d, arbol.getRaiz(), getWidth() / 2, 80, 100);
        }
    }

    private void dibujarArbol(Graphics2D g2d, Nodo<T> nodo, int x, int y, int distancia) {
        if (nodo != null) {
            dibujarOvalo(g2d, nodo, x, y);

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

    private void dibujarOvalo(Graphics g2d, Nodo nodo, int x, int y) {
        String dato = nodo.getDato().toString();
        if (nodo.esHoja()) {
            g2d.setColor(Color.GREEN);
        } else {
            g2d.setColor(Color.LIGHT_GRAY);
        }

        g2d.fillOval(x - 15, y - 15, 30, 30);
        g2d.setColor(Color.BLACK);
        g2d.drawString(dato, x - 10, y + 5);
    }

    private void dibujarLinea(Graphics g2d, int x1, int y1, int x2, int y2) {
        g2d.setColor(Color.BLACK);
        g2d.drawLine(x1, y1 + 5, x2, y2 - 15);
    }
}
