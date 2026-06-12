package arboles.grafico;

import arboles.ArbolBinario;
import arboles.Nodo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.util.Queue;

public class PanelArbolAnimado<T extends Comparable<T>> extends PanelArbol<T> {

    private Nodo<T> nodoAnimado; // Nodo que se está animando
    private int animacionX, animacionY; // Posición del nodo animado
    private Queue<Nodo<T>> nodosEnOrden; // Cola de nodos para la reproducción
    private boolean animando = false; // Indica si hay una animación en curso
    private Timer timer; // Temporizador para la animación

    public PanelArbolAnimado() {
        super(new ArbolBinario<>()); // Inicializa con un árbol vacío
        inicializarPanelMensajes(); // Inicializa el panel de mensajes
    }

    public PanelArbolAnimado(ArbolBinario<T> arbol) {
        super(new ArbolBinario<>()); // Inicializa con un árbol vacío
        this.nodosEnOrden = arbol.obtenerNodos();

        setLayout(new BorderLayout()); // Usar BorderLayout para organizar componentes

        JButton reproducirButton = new JButton("Reproducir");
        reproducirButton.addActionListener(e -> iniciarReproduccion()); // Inicia la reproducción al hacer clic en el botón

        JPanel buttonPanel = new JPanel(); // Crear un panel para los botones
        buttonPanel.add(reproducirButton); // Agregar el botón de reproducir

        this.add(buttonPanel, BorderLayout.SOUTH); // Agrega el panel de botones al fondo del panel principal

        inicializarPanelMensajes(); // Inicializa el panel de mensajes
    }

    private JTextArea textArea; // Área de texto para mostrar mensajes
    private PrintStream printStream; // Stream para redirigir la salida

    private void inicializarPanelMensajes() {
        textArea = new JTextArea(10, 30);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Redirigir la salida estándar a textArea
        printStream = new PrintStream(new CustomOutputStream(textArea));
        System.setOut(printStream);
        System.setErr(printStream); // Redirigir también la salida de error

        //this.add(scrollPane, BorderLayout.EAST); // Agregar el panel al centro
    }

    // Clase interna para redirigir la salida a JTextArea
    private static class CustomOutputStream extends java.io.OutputStream {

        private JTextArea textArea;

        public CustomOutputStream(JTextArea textArea) {
            this.textArea = textArea;
        }

        @Override
        public void write(int b) {
            // Agregar el carácter al JTextArea
            SwingUtilities.invokeLater(() -> textArea.append(String.valueOf((char) b)));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        setBackground(Color.WHITE); // Establece el fondo en blanco

        if (nodosEnOrden != null) {
            for (Nodo<T> nodo : nodosEnOrden) {
                int[] pos = calcularPosicion(nodo);
                dibujarOvalo(g2d, nodo, pos[0], pos[1]);
            }
        }

        if (nodoAnimado != null) {
            dibujarOvalo(g2d, nodoAnimado, animacionX, animacionY);
        }
    }

    public void insertar(T dato) {
        super.insertar(dato); // Llama al método de inserción del árbol
    }

    private void iniciarReproduccion() {
        System.out.println("nodosEnOrden.isEmpty " + nodosEnOrden.isEmpty());

        if (!nodosEnOrden.isEmpty()) {
            reproducir();
        } else {
            ArbolBinario<T> ab = this.arbol;
            this.arbol = new ArbolBinario<>(); // Inicializa con un árbol vacío
            this.nodosEnOrden = ab.obtenerNodos();
            reproducir();
        }
    }

    private void reproducir() {
        nodoAnimado = null;
        repaint();

        System.out.println("Iniciando reproducción...");
        animando = true;

        timer = new Timer(1000, e -> realizarAnimacion());
        timer.start();
    }

    private void realizarAnimacion() {
        if (!nodosEnOrden.isEmpty()) {
            nodoAnimado = nodosEnOrden.poll();
            arbol.insertar(nodoAnimado.getDato());

            System.out.println("Mostrando nodo: " + nodoAnimado.getDato());

            int[] posFinal = calcularPosicion(nodoAnimado);

            animacionX = getWidth() / 2;
            animacionY = 30;

            repaint();

            iniciarAnimacion(nodoAnimado, posFinal);

        } else {
            animando = false;
            timer.stop();
            System.out.println("Reproducción finalizada.");
        }
    }

    private void iniciarAnimacion(Nodo<T> nuevoNodo, int[] posFinal) {
        this.nodoAnimado = nuevoNodo;

        this.animacionX = getWidth() / 2;
        this.animacionY = 30;

        Timer animationTimer = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int targetY = posFinal[1];

                if (animacionY < targetY) {
                    animacionY += 5;
                    repaint();
                } else {
                    ((Timer) e.getSource()).stop();
                    nodoAnimado = null;

                    if (!nodosEnOrden.isEmpty()) {
                        realizarAnimacion();
                    }
                }
            }
        });

        animationTimer.start();
    }

    private int[] calcularPosicion(Nodo<T> nodo) {
        int depth = obtenerProfundidad(nodo);
        int position = obtenerPosicion(nodo);

        int x = getWidth() / 2 + (position - (1 << depth - 1)) * 40;

        int y;

        if (depth == 0) {
            y = 70;
        } else {
            y = depth * 50 + 30;
        }

        return new int[]{x, y};
    }

    private int obtenerProfundidad(Nodo<T> nodo) {
        return obtenerProfundidadRecursivo(arbol.getRaiz(), nodo, 0);
    }

    private int obtenerProfundidadRecursivo(Nodo<T> currentNode, Nodo<T> targetNode, int depth) {
        if (currentNode == null) {
            return -1;
        }

        if (currentNode == targetNode) {
            return depth;
        }

        int leftDepth = obtenerProfundidadRecursivo(currentNode.getIzquierda(), targetNode, depth + 1);

        if (leftDepth != -1) {
            return leftDepth;
        }

        return obtenerProfundidadRecursivo(currentNode.getDerecha(), targetNode, depth + 1);
    }

    private int obtenerPosicion(Nodo<T> nodo) {
        return obtenerPosicionRecursivo(arbol.getRaiz(), nodo, 0);
    }

    private int obtenerPosicionRecursivo(Nodo<T> currentNode, Nodo<T> targetNode, int position) {
        if (currentNode == null) {
            return -1;
        }

        if (currentNode == targetNode) {
            return position;
        }

        int leftPosition = obtenerPosicionRecursivo(currentNode.getIzquierda(), targetNode, position * 2);

        if (leftPosition != -1) {
            return leftPosition;
        }

        return obtenerPosicionRecursivo(currentNode.getDerecha(), targetNode, position * 2 + 1);
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
}
