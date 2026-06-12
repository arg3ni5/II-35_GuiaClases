/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase12;

/**
 *
 * @author fbarg
 */
// Se utiliza AWT/Swing para facilitar la demostración visual.

import javax.swing.*;
import java.awt.*;

/**
 * Clase principal que configura la ventana y llama a la función recursiva.
 * El Triángulo de Sierpinski se construye a partir de un triángulo inicial
 * dividiéndolo recursivamente en cuatro triángulos más pequeños.
 */
public class SierpinskiApp extends JPanel {

    // Nivel máximo de recursión para controlar la complejidad del dibujo.
    private static final int MAX_LEVEL = 7;

    public SierpinskiApp() {
        // Establecer el color de fondo para el lienzo de dibujo.
        setBackground(Color.WHITE);
    }

    /**
     * Punto de entrada principal para configurar la ventana de la aplicación.
     */
    public static void main(String[] args) {
        // Crear el marco (ventana) de la aplicación.
        JFrame frame = new JFrame("Ejercicio de Recursividad: Triángulo de Sierpinski");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800); // Tamaño fijo para la ventana.
        frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla.

        // Añadir la instancia del panel de dibujo al marco.
        SierpinskiApp panel = new SierpinskiApp();
        frame.add(panel);

        // Hacer visible la ventana.
        frame.setVisible(true);
    }

    /**
     * Este método se llama automáticamente para dibujar el contenido del panel.
     * Aquí definimos el triángulo equilátero inicial y comenzamos la recursión.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Mejorar la calidad del dibujo (opcional, para líneas más suaves).
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // --- 1. Definir los vértices del triángulo equilátero inicial ---
        // Se define un tamaño basado en el tamaño del panel para que sea responsivo.
        int width = getWidth();
        int height = getHeight();

        // Puntos iniciales del triángulo (casi centrados en el panel).
        // Vértice superior (A)
        Point p1 = new Point(width / 2, 50);
        // Vértice inferior izquierdo (B)
        Point p2 = new Point(50, height - 50);
        // Vértice inferior derecho (C)
        Point p3 = new Point(width - 50, height - 50);

        // --- 2. Iniciar la función recursiva ---
        g2d.setColor(Color.red); // Color para las líneas del fractal.
        drawTriangle(g2d, MAX_LEVEL, p1, p2, p3);
    }

    /**
     * FUNCIÓN RECURSIVA CENTRAL
     * Dibuja el Triángulo de Sierpinski en base a los 3 vértices dados.
     *
     * @param g     Contexto gráfico para dibujar.
     * @param level Nivel actual de recursión.
     * @param pA    Vértice superior.
     * @param pB    Vértice inferior izquierdo.
     * @param pC    Vértice inferior derecho.
     */
    private void drawTriangle(Graphics2D g, int level, Point pA, Point pB, Point pC) {

        // ===================================
        // === CASO BASE (CONDICIÓN DE PARADA) ===
        // ===================================
        if (level == 0) {
            // Si el nivel es 0, simplemente dibuje el triángulo actual.
            // Esto evita la recursión infinita.
            Polygon triangle = new Polygon();
            triangle.addPoint(pA.x, pA.y);
            triangle.addPoint(pB.x, pB.y);
            triangle.addPoint(pC.x, pC.y);

            g.draw(triangle);
            return; // Detiene la ejecución y devuelve el control a la llamada anterior.
        }

        // =================================
        // === CASO RECURSIVO (LLAMADA A SÍ MISMA) ===
        // =================================

        // 1. Calcular los puntos medios de los lados del triángulo actual.
        // Punto D: medio entre A y B
        Point pD = midpoint(pA, pB);
        // Punto E: medio entre B y C
        Point pE = midpoint(pB, pC);
        // Punto F: medio entre A y C
        Point pF = midpoint(pA, pC);

        // 2. Decrementar el nivel para avanzar hacia el Caso Base.
        int nextLevel = level - 1;

        // 3. Realizar TRES llamadas recursivas, creando tres triángulos nuevos:
        // El espacio central (triángulo D-E-F) se deja vacío.

        // Triángulo Superior (A, D, F)
        drawTriangle(g, nextLevel, pA, pD, pF);

        // Triángulo Inferior Izquierdo (D, B, E)
        drawTriangle(g, nextLevel, pD, pB, pE);

        // Triángulo Inferior Derecho (F, E, C)
        drawTriangle(g, nextLevel, pF, pE, pC);
    }

    /**
     * Función auxiliar para calcular el punto medio entre dos puntos (coordenadas).
     */
    private Point midpoint(Point p1, Point p2) {
        int x = (p1.x + p2.x) / 2;
        int y = (p1.y + p2.y) / 2;
        return new Point(x, y);
    }
}