/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arboles.grafico;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author fbarg
 */
public class FrameArbol {

    JFrame frame;
    String title;

    public FrameArbol(JPanel panel) {
        this.frame = new JFrame("Visualización del Árbol Binario");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        // Obtener la resolución de la pantalla
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int width = pantalla.width;
        int height = pantalla.height;

        // Establecer tamaño del JFrame (opcional)
        frame.setSize(width / 2, height / 2);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
