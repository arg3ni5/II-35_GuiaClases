package persona;

import arboles.*;
import arboles.grafico.FrameArbol;
import arboles.grafico.PanelArbolAnimate;
import arboles.grafico.PanelArbolPersona;
import javax.swing.JFrame;

/**
 *
 * @author fbarg
 */
public class ArbolPersonas {

    public static void main(String[] args) {
        ArbolBinario<Persona> arbol = new ArbolBinario<Persona>(); // Crear un nuevo árbol binario

        // Insertar personas en el árbol
        
        
        //Actividad 02 agregar aleatoriamente 6
//        arbol.insertar(new Persona("Fabian", 30));
//        arbol.insertar(new Persona("Alice", "Smith", 31));
//        arbol.insertar(new Persona("Bob", "Johnson", 25));
//        arbol.insertar(new Persona("Charlie", "Brown", 35));
//        arbol.insertar(new Persona("Diana", "White", 28));
        
        arbol.inOrden(arbol.getRaiz());
        
        System.out.println(arbol.getRaiz());

//Actividad 03 agregar nodos balanceado
//        arbol.insertar(new Persona("Alice", "Smith", 30));
//        arbol.insertar(new Persona("Bob", "Johnson", 25));
//        arbol.insertar(new Persona("Charlie", "Brown", 35));
//        arbol.insertar(new Persona("Diana", "White", 28));

        PanelArbolPersona panel = new PanelArbolPersona(arbol);
        new FrameArbol(panel);
    }
}
