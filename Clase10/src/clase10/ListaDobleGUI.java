package clase10;

import javax.swing.*;
import java.awt.*;

public class ListaDobleGUI extends JFrame {

    private ListaDoble<Character> lista = new ListaDoble<>();
    private Nodo<Character> cursor = null;

    private JTextField txtLetter;
    private JLabel lblListView;
    private JLabel lblStatus;

    public ListaDobleGUI() {
        super("Doubly Linked List - Scrabble Style");

        // --- Top panel: input and add buttons ---
        JPanel topPanel = new JPanel(new FlowLayout());
        txtLetter = new JTextField(2);
        JButton btnAddHead = new JButton("Add at Head");
        JButton btnAddTail = new JButton("Add at Tail");

        // Actions for add buttons
        btnAddHead.addActionListener(e -> addLetterAtHead());
        btnAddTail.addActionListener(e -> addLetterAtTail());

        topPanel.add(new JLabel("Letter:"));
        topPanel.add(txtLetter);
        topPanel.add(btnAddHead);
        topPanel.add(btnAddTail);

        // --- Center: list view ---
        lblListView = new JLabel("List is empty", SwingConstants.CENTER);
        lblListView.setFont(new Font("Consolas", Font.PLAIN, 18));

        // --- Bottom panel: cursor + palindrome ---
        JPanel bottomPanel = new JPanel(new FlowLayout());

        JButton btnGoHead = new JButton("Go to Head");
        JButton btnGoTail = new JButton("Go to Tail");
        JButton btnPrev = new JButton("<- Previous");
        JButton btnNext = new JButton("Next ->");
        JButton btnDeleteCursor = new JButton("Delete cursor");
        JButton btnCheckPalindrome = new JButton("Check palindrome");

        // Cursor actions
        btnGoHead.addActionListener(e -> {
            cursor = lista.getCabeza();
            updateView();
        });

        btnGoTail.addActionListener(e -> {
            cursor = lista.getCola();
            updateView();
        });

        btnPrev.addActionListener(e -> {
            if (cursor != null && cursor.anterior != null) {
                cursor = cursor.anterior;
                updateView();
            }
        });

        btnNext.addActionListener(e -> {
            if (cursor != null && cursor.siguiente != null) {
                cursor = cursor.siguiente;
                updateView();
            }
        });

        btnDeleteCursor.addActionListener(e -> deleteAtCursor());
        btnCheckPalindrome.addActionListener(e -> checkPalindrome());

        bottomPanel.add(btnGoHead);
        bottomPanel.add(btnPrev);
        bottomPanel.add(btnNext);
        bottomPanel.add(btnGoTail);
        bottomPanel.add(btnDeleteCursor);
        bottomPanel.add(btnCheckPalindrome);

        // Status label
        lblStatus = new JLabel("Ready.", SwingConstants.CENTER);
        
        bottomPanel.add(lblStatus, BorderLayout.NORTH);
        // --- Frame layout ---
        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(lblListView, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.PAGE_END);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 450);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Add letter at head
    private void addLetterAtHead() {
        Character c = readLetter();
        if (c == null) return;

        lista.agregarEnCabeza(c);
        cursor = lista.getCabeza(); // move cursor to new head
        updateView();
    }

    // Add letter at tail
    private void addLetterAtTail() {
        Character c = readLetter();
        if (c == null) return;

        lista.agregarEnCola(c);
        cursor = lista.getCola(); // move cursor to new tail
        updateView();
    }

    // Read one character from text field
    private Character readLetter() {
        String text = txtLetter.getText().trim().toUpperCase();
        if (text.isEmpty()) {
            lblStatus.setText("Please type one letter.");
            return null;
        }
        char c = text.charAt(0);
        txtLetter.setText("");
        return c;
    }

    // Delete node where cursor is
    private void deleteAtCursor() {
        if (cursor == null) {
            lblStatus.setText("Cursor is null. Nothing to delete.");
            return;
        }
        Character value = cursor.dato;
        boolean deleted = lista.eliminar(value);
        if (deleted) {
            lblStatus.setText("Deleted node with value: " + value);
            cursor = lista.getCabeza(); // reset cursor
        } else {
            lblStatus.setText("Value not found to delete.");
        }
        updateView();
    }

    // Check palindrome using unirDatosCabeza and unirDatosCola
    private void checkPalindrome() {
        String fromHead = lista.unirDatosCabeza();
        String fromTail = lista.unirDatosCola();
        boolean isPalindrome = fromHead.equals(fromTail);

        String message = "From head: " + fromHead +
                         "\nFrom tail: " + fromTail +
                         "\n\nPalindrome? " + isPalindrome;

        JOptionPane.showMessageDialog(this, message, "Palindrome check",
                JOptionPane.INFORMATION_MESSAGE);
        lblStatus.setText("Palindrome check done.");
    }

    // Update visual representation of list
    private void updateView() {
        Nodo<Character> actual = lista.getCabeza();
        if (actual == null) {
            lblListView.setText("List is empty");
            return;
        }

        StringBuilder sb = new StringBuilder();
        // Visual representation: [A] <-> [B] ...
        while (actual != null) {
            if (actual == cursor) {
                sb.append("{").append(actual.dato).append("}"); // highlight cursor
            } else {
                sb.append("[").append(actual.dato).append("]");
            }
            if (actual.siguiente != null) {
                sb.append(" <-> ");
            }
            actual = actual.siguiente;
        }
        lblListView.setText(sb.toString());
    }

    // Main to test GUI
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ListaDobleGUI::new);
    }
}
