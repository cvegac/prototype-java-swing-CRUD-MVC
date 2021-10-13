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
public class BicicletaModel {
    private int bic_id;
    private String bic_marco;

    /**
     * Crear el modelo de bicicleta
     * @param bic_id
     * @param bic_marco 
     */
    public BicicletaModel(int bic_id, String bic_marco) {
        this.bic_id = bic_id;
        this.bic_marco = bic_marco;
    }

    /**
     * @return the bic_id
     */
    public int getBic_id() {
        return bic_id;
    }

    /**
     * @return the bic_marco
     */
    public String getBic_marco() {
        return bic_marco;
    }

    @Override
    public String toString() {
        return bic_marco; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
