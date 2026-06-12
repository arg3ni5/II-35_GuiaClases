/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab03;

/**
 *
 * @author fbarg
 */
public class Garaje {

    private int espacios;
    private Carro[] carros;
    private int contador = 0;

    public Garaje(int espacios) {
        this.espacios = espacios;
        this.carros = new Carro[espacios];
    }

    public void aparcar(Carro carro) {
        if (contador < espacios) {
            this.carros[contador++] = carro;
            //index = index + 1;
            //index++;
        } else {
            System.err.println("Garaje Lleno");
        }
    }

    public void listarCarros() {
        for (int i = 0; i < contador; i++) {
            System.out.println(i + "." + carros[i]);
        }
    }

    public static void main(String[] args) {
        Carro c1 = new Carro(2001, "Toyota", "Corolla");
        Carro c2 = new Carro(2003, "Hyundai", "Accent");
        Carro c3 = new Carro(2025, "Kia", "Rio");
        Carro c4 = new Carro(2022, "Honda", "Civic");

        Garaje g = new Garaje(3);
        g.aparcar(c1);
        g.aparcar(c2);
        g.aparcar(c3);
        g.aparcar(c4);

        g.listarCarros();
    }
}
