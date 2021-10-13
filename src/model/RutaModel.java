/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author cvega
 */
public class RutaModel {
    private int rut_id;
    private int rut_velocidades;
    private int rut_peso;

    public RutaModel(int rut_id, int rut_velocidades, int rut_peso) {
        this.rut_id = rut_id;
        this.rut_velocidades = rut_velocidades;
        this.rut_peso = rut_peso;
    }

    public int getRut_id() {
        return rut_id;
    }

    public int getRut_velocidades() {
        return rut_velocidades;
    }

    public int getRut_peso() {
        return rut_peso;
    }
    
    
}
