/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab03;

/**
 *
 * @author fbarg
 */
public class Vehiculo {
    private String marca;
    private String modelo;
    private int ruedas;

    public int getRuedas() {
        return ruedas;
    }

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }   
    
    public Vehiculo(int ruedas) {
        this.ruedas = ruedas;
    }

    public Vehiculo(String marca, String modelo, int ruedas) {
        this.marca = marca;
        this.modelo = modelo;
        this.ruedas = ruedas;
    }
}
