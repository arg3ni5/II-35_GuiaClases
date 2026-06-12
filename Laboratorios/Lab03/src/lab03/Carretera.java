/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author fbarg
 */
public class Carretera {

    private final String nombre;
    private final ArrayList<Carro> carros;

    public Carretera(String nombre) {
        this.nombre = nombre;
        this.carros = new ArrayList<>();
    }

    public void agregarCarro(Carro carro) {
        this.carros.add(carro);
        verificarEstado();
    }

    public void agregarCarros(ArrayList<Carro> carros) {
        Iterator<Carro> iterador = carros.iterator();
        while (iterador.hasNext()) {
            agregarCarro(iterador.next());
        }
        verificarEstado();
    }

    public void listarCarros() {
        System.out.println("Carretera: " + this.nombre);
        Iterator<Carro> ite = carros.iterator();
        while (ite.hasNext()) {
            Carro next = ite.next();
            System.out.println(next);
            /* es igual que poner next.toString()*/
            //System.out.println(next.toString());
        }
    }

    public String obtenerEstadoTrafico(int cantidad) {
        if (cantidad <= 3) {
            return "tiene un flujo ligero";
        }
        if (cantidad <= 5) {
            return "tiene un flujo moderado";
        }
        if (cantidad <= 8) {
            return "está comenzando a congestionarse";
        }
        if (cantidad <= 11) {
            return "se está generando un embotellamiento en la carretera.";
        }
        return "La carretera está colapsada, hay mucho embotellamiento";
    }

    public void verificarEstado() {
        int cantidad = this.carros.size();
        String estado = obtenerEstadoTrafico(cantidad);
        System.out.printf("La carretera %s %s%n", nombre, estado);
    }

    public static void main(String[] args) {
        Carretera carretera = new Carretera("General Cañas");
        Carro c1 = new Carro(2001, "Toyota", "Corolla");
        Carro c2 = new Carro(2003, "Hyundai", "Accent");
        Carro c3 = new Carro(2025, "Kia", "Rio");
        Carro c4 = new Carro(2022, "Honda", "Civic");

        carretera.agregarCarros(new ArrayList<>(List.of(c1, c2, c3)));

//        carretera.agregarCarro(c1);
//        carretera.agregarCarro(c2);
//        carretera.agregarCarro(c3);
        carretera.listarCarros();
    }

    //Realizar metodo
    private void removerCarrosAntiguos() {
    }

    //Realizar metodo
    private int cantidadCarros() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
