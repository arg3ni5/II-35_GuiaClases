package arboles;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Clase que representa un árbol binario.
 *
 * @param <T> El tipo de dato que almacenará el árbol, debe ser comparable.
 */
public class ArbolBinario<T extends Comparable<T>> {

    private Nodo<T> raiz; // Raíz del árbol binario

    /**
     * Constructor que inicializa un árbol binario vacío.
     */
    public ArbolBinario() {
        raiz = null;
    }

    /**
     * Inserta un nuevo dato en el árbol.
     *
     * @param dato El dato a insertar en el árbol. No puede ser nulo.
     * @throws IllegalArgumentException si el dato es nulo.
     */
    public void insertar(T dato) {
        if (dato == null) {
            throw new IllegalArgumentException("El dato no puede ser nulo");
        }
        raiz = insertarRec(raiz, dato);
    }

    /**
     * Método recursivo para insertar un nuevo dato en el árbol.
     *
     * @param raiz El nodo actual donde se está intentando insertar el dato.
     * @param dato El dato a insertar.
     * @return El nodo raíz actualizado del subárbol.
     */
    private Nodo<T> insertarRec(Nodo<T> raiz, T dato) {
        if (raiz == null) {
            return new Nodo<>(dato); // Si el árbol está vacío, se crea un nuevo nodo
        }
        if (dato.compareTo(raiz.getDato()) < 0) { // Si el dato es menor que el nodo actual
            System.out.println("izquierda:" + dato);
            raiz.setIzquierda(insertarRec(raiz.getIzquierda(), dato)); // Insertar en el subárbol izquierdo
        } else if (dato.compareTo(raiz.getDato()) > 0) { // Si el dato es mayor que el nodo actual
            System.out.println("derecha:" + dato);
            raiz.setDerecha(insertarRec(raiz.getDerecha(), dato)); // Insertar en el subárbol derecho
        }
//        System.out.println("Ninguno: " + dato);
        System.out.println("raiz" + dato);
        return raiz; // Retornar el nodo raíz
    }

    /**
     * Inserta un nuevo dato en el árbol utilizando un comparador personalizado.
     *
     * @param dato El dato a insertar. No puede ser nulo.
     * @param comparador Un comparador que define la relación entre los
     * elementos.
     * @throws IllegalArgumentException si el dato o comparador son nulos.
     */
    public void insertar(T dato, Comparator<T> comparador) {
        if (dato == null || comparador == null) {
            throw new IllegalArgumentException("El dato o comparador no pueden ser nulos");
        }
        raiz = insertarRec(raiz, dato, comparador);
    }

    /**
     * Método recursivo para insertar un nuevo dato en el árbol utilizando un
     * comparador.
     *
     * @param nodo El nodo actual donde se está intentando insertar el dato.
     * @param dato El dato a insertar.
     * @param comparador Un comparador que define la relación entre los
     * elementos.
     * @return El nodo raíz actualizado del subárbol.
     */
    private Nodo<T> insertarRec(Nodo<T> nodo, T dato, Comparator<T> comparador) {
        if (nodo == null) {
            return new Nodo<>(dato); // Crear un nuevo nodo si se llega a una posición vacía
        }

        if (comparador.compare(dato, nodo.getDato()) < 0) {
            nodo.setIzquierda(insertarRec(nodo.getIzquierda(), dato, comparador)); // Insertar en la izquierda
        } else if (comparador.compare(dato, nodo.getDato()) > 0) {
            nodo.setDerecha(insertarRec(nodo.getDerecha(), dato, comparador)); // Insertar en la derecha
        }

        return nodo; // Retornar el nodo raíz actualizado
    }

    /**
     * Obtiene la raíz del árbol.
     *
     * @return El nodo raíz del árbol binario.
     */
    public Nodo<T> getRaiz() {
        return raiz;
    }

    /**
     * Realiza un recorrido en orden del árbol e imprime los datos de los nodos.
     *
     * @param nodo El nodo actual desde donde se inicia el recorrido.
     */
    public void inOrden(Nodo<T> nodo) {
        if (nodo != null) {
            inOrden(nodo.getIzquierda()); // Recorrer el subárbol izquierdo
            System.out.println(nodo.getDato()); // Imprimir el dato del nodo actual
            inOrden(nodo.getDerecha()); // Recorrer el subárbol derecho
        }
    }

    /**
     * Realiza un recorrido preorden del árbol e imprime los datos de los nodos.
     *
     * @param nodo El nodo actual desde donde se inicia el recorrido.
     */
    public void preOrden(Nodo<T> nodo) {
        if (nodo != null) {
            System.out.println(nodo.getDato()); // Imprimir el dato del nodo actual
            preOrden(nodo.getIzquierda()); // Recorrer el subárbol izquierdo
            preOrden(nodo.getDerecha()); // Recorrer el subárbol derecho
        }
    }

    /**
     * Realiza un recorrido postorden del árbol e imprime los datos de los
     * nodos.
     *
     * @param nodo El nodo actual desde donde se inicia el recorrido.
     */
    public void postOrden(Nodo<T> nodo) {
        if (nodo != null) {
            postOrden(nodo.getIzquierda()); // Recorrer el subárbol izquierdo
            postOrden(nodo.getDerecha()); // Recorrer el subárbol derecho
            System.out.println(nodo.getDato()); // Imprimir el dato del nodo actual
        }
    }

    /**
     * Obtiene todos los nodos del árbol en un recorrido por niveles
     * (nivel-order).
     *
     * @return Una cola con todos los nodos del árbol en orden de nivel.
     */
    public Queue<Nodo<T>> obtenerNodos() {
        Queue<Nodo<T>> nodos = new LinkedList<>();
        if (raiz != null) {
            Queue<Nodo<T>> queue = new LinkedList<>();
            queue.add(raiz); // Agregar la raíz a la cola inicial

            while (!queue.isEmpty()) {
                Nodo<T> current = queue.poll(); // Obtener y eliminar el primer elemento de la cola
                nodos.add(current); // Agregarlo a la lista de nodos

                // Agregar hijos a la cola para su posterior procesamiento
                if (current.getIzquierda() != null) {
                    queue.add(current.getIzquierda());
                }
                if (current.getDerecha() != null) {
                    queue.add(current.getDerecha());
                }
            }
        }
        return nodos; // Retornar todos los nodos recolectados
    }

    /**
     * Obtiene todos los nodos del árbol en orden in-order y los devuelve como
     * un arreglo.
     *
     * @return Un arreglo con todos los nodos en orden in-order.
     */
    public Nodo<T>[] obtenerNodosEnOrden() {
        List<Nodo<T>> nodos = new ArrayList<>();
        llenarNodosEnOrden(raiz, nodos); // Llenar la lista con nodos en orden in-order
        return nodos.toArray(new Nodo[0]); // Convertir la lista a un arreglo y retornarlo
    }

    /**
     * Método auxiliar recursivo para llenar una lista con nodos en orden
     * in-order.
     *
     * @param nodo El nodo actual desde donde se inicia la recolección de nodos.
     * @param nodos La lista donde se almacenarán los nodos recolectados.
     */
    private void llenarNodosEnOrden(Nodo<T> nodo, List<Nodo<T>> nodos) {
        if (nodo == null) {
            return; // Si no hay más nodos, salir del método
        }

        llenarNodosEnOrden(nodo.getIzquierda(), nodos); // Recorrer izquierda y recolectar nodos
        nodos.add(nodo); // Agregar el nodo actual a la lista
        llenarNodosEnOrden(nodo.getDerecha(), nodos); // Recorrer derecha y recolectar nodos
    }

    /**
     * Cuenta y devuelve el número total de nodos en el árbol.
     *
     * @return El número total de nodos en el árbol binario.
     */
    public int contarNodos() {
        return contarNodosRec(raiz); // Iniciar conteo desde la raíz
    }

    /**
     * Método auxiliar recursivo para contar los nodos en un subárbol dado.
     *
     * @param nodo El nodo actual desde donde se inicia el conteo de nodos.
     * @return El número total de nodos en este subárbol específico.
     */
    private int contarNodosRec(Nodo<T> nodo) {
        if (nodo == null) {
            return 0; // Si no hay más nodos, retornar 0
        }

        return 1 + contarNodosRec(nodo.getIzquierda()) + contarNodosRec(nodo.getDerecha());
        // Contar este nodo + contar izquierda + contar derecha
    }

    /**
     * Calcula y devuelve la altura del árbol binario.
     *
     * @return La altura del árbol. La altura de un árbol vacío es -1.
     */
    public int altura() {
        return alturaRec(raiz); // Iniciar cálculo desde la raíz
    }

    /**
     * Método auxiliar recursivo para calcular la altura de un subárbol dado.
     *
     * @param nodo El nodo actual desde donde se inicia el cálculo de altura.
     * @return La altura del subárbol. La altura de un árbol vacío es -1.
     */
    private int alturaRec(Nodo<T> nodo) {
        if (nodo == null) {
            return -1; // Altura de un árbol vacío es -1 
        }

        return 1 + Math.max(alturaRec(nodo.getIzquierda()), alturaRec(nodo.getDerecha()));
        // Altura es 1 + máxima altura entre izquierda y derecha
    }

    public boolean buscar(T dato) {
        return buscarRec(raiz, dato);
    }

    private boolean buscarRec(Nodo<T> nodo, T dato) {
        if (nodo == null) {
            return false; // El nodo no existe, el dato no está en el árbol
        }
        if (dato.compareTo(nodo.getDato()) == 0) {
            return true; // Dato encontrado
        } else if (dato.compareTo(nodo.getDato()) < 0) {
            return buscarRec(nodo.getIzquierda(), dato); // Buscar en el subárbol izquierdo
        } else {
            return buscarRec(nodo.getDerecha(), dato); // Buscar en el subárbol derecho
        }
    }

    public void eliminar(T dato) {
        raiz = eliminarRec(raiz, dato);
    }

    private Nodo<T> eliminarRec(Nodo<T> nodo, T dato) {
        if (nodo == null) {
            return null; // El dato no está en el árbol
        }

        if (dato.compareTo(nodo.getDato()) < 0) {
            nodo.setIzquierda(eliminarRec(nodo.getIzquierda(), dato)); // Buscar en el subárbol izquierdo
        } else if (dato.compareTo(nodo.getDato()) > 0) {
            nodo.setDerecha(eliminarRec(nodo.getDerecha(), dato)); // Buscar en el subárbol derecho
        } else {
            // Nodo encontrado
            if (nodo.getIzquierda() == null && nodo.getDerecha() == null) {
                return null; // Nodo hoja
            } else if (nodo.getIzquierda() == null) {
                return nodo.getDerecha(); // Un solo hijo derecho
            } else if (nodo.getDerecha() == null) {
                return nodo.getIzquierda(); // Un solo hijo izquierdo
            } else {
                // Nodo con dos hijos: encontrar el mínimo en el subárbol derecho
                Nodo<T> minNodo = encontrarMinimo(nodo.getDerecha());
                nodo.setDato(minNodo.getDato()); // Reemplazar con el mínimo encontrado
                nodo.setDerecha(eliminarRec(nodo.getDerecha(), minNodo.getDato())); // Eliminar el mínimo encontrado
            }
        }
        return nodo; // Retornar el nodo actualizado
    }

    private Nodo<T> encontrarMinimo(Nodo<T> nodo) {
        while (nodo.getIzquierda() != null) {
            nodo = nodo.getIzquierda(); // Ir al hijo izquierdo más profundo
        }
        return nodo;
    }

}
