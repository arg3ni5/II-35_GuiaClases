package arboles.grafico;

import arboles.ArbolBinario;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author fbarg
 */
public class PanelArbolInteger extends PanelArbol<Integer> {
    private JTextField inputField; // Campo de entrada para el valor del nodo
    private JButton addButton; // Botón para agregar nodos

    public PanelArbolInteger(ArbolBinario<Integer> arbol) {
        super(arbol); // Llama al constructor de PanelArbol

        // Configuración del panel
        setLayout(new BorderLayout());

        // Crear el campo de entrada y el botón
        inputField = new JTextField(10);
        addButton = new JButton("Agregar Nodo");

        // Agregar acción al botón
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Integer valor = Integer.parseInt(inputField.getText());
                    insertar(valor); // Agregar el nuevo nodo al árbol
                    inputField.setText(""); // Limpiar campo de entrada
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(PanelArbolInteger.this, "Por favor ingrese un número válido.");
                }
            }
        });

        // Panel de control para el campo de texto y el botón
        JPanel controlPanel = new JPanel();
        controlPanel.add(inputField);
        controlPanel.add(addButton);

        // Agregar el panel de control al panel principal
        add(controlPanel, BorderLayout.SOUTH);
    }
}


