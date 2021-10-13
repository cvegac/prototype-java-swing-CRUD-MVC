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
public class MtbModel {
    private int mtb_id;
    private String mtb_descripcion;
    private int mtb_anio;
    private int mtb_creador;

    public MtbModel(int mtb_id, String mtb_descripcion, int mtb_anio, int mtb_creador) {
        this.mtb_id = mtb_id;
        this.mtb_descripcion = mtb_descripcion;
        this.mtb_anio = mtb_anio;
        this.mtb_creador = mtb_creador;
    }

    public int getMtb_id() {
        return mtb_id;
    }

    public String getMtb_descripcion() {
        return mtb_descripcion;
    }

    public int getMtb_anio() {
        return mtb_anio;
    }

    public int getMtb_creador() {
        return mtb_creador;
    }
    
    
}
