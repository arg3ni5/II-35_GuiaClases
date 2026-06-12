/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.cr.universidadcentral.grafos;

/**
 *
 * @author fbarg
 */
public class GrafoMatriz {

    int numVerts;
    static int MaxVerts = 20;
    Vertice[] verts;
    int[][] matAd;

    public GrafoMatriz() {
        this(MaxVerts);
    }

    public GrafoMatriz(int mx) {
        matAd = new int[mx][mx];
        verts = new Vertice[mx];
        for (int i = 0; i < mx; i++) {
            for (int j = 0; j < mx; j++) {
                matAd[i][j] = 0;
            }
        }
        numVerts = 0;
    }
    
    public void nuevoVertice(String nom){
        boolean esta;
    }

}
