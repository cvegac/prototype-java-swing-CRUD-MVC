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
public class VentaModel {
    private int ven_id;
    private int ven_usr_id;
    private int ven_bic_id;
    private String ven_fecha;
    
    private String usr_name;
    private String usr_apellido;
    
    private String bic_marco;

    /**
     * Constructor con solo las variables propias
     * @param ven_id
     * @param ven_usr_id
     * @param ven_bic_id
     * @param ven_fecha 
     */
    public VentaModel(int ven_id, int ven_usr_id, int ven_bic_id, String ven_fecha) {
        this.ven_id = ven_id;
        this.ven_usr_id = ven_usr_id;
        this.ven_bic_id = ven_bic_id;
        this.ven_fecha = ven_fecha;
    }

    /**
     * Constructor con los datos a mostrar y/o modificar
     * @param ven_id
     * @param ven_usr_id
     * @param ven_bic_id
     * @param ven_fecha
     * @param usr_name
     * @param usr_apellido
     * @param bic_marco 
     */
    public VentaModel(int ven_id, int ven_usr_id, int ven_bic_id, String ven_fecha, String usr_name, String usr_apellido, String bic_marco) {
        this.ven_id = ven_id;
        this.ven_usr_id = ven_usr_id;
        this.ven_bic_id = ven_bic_id;
        this.ven_fecha = ven_fecha;
        this.usr_name = usr_name;
        this.usr_apellido = usr_apellido;
        this.bic_marco = bic_marco;
    }

    /**
     * @return the ven_id
     */
    public int getVen_id() {
        return ven_id;
    }

    /**
     * @return the ven_usr_id
     */
    public int getVen_usr_id() {
        return ven_usr_id;
    }

    /**
     * @param ven_usr_id the ven_usr_id to set
     */
    public void setVen_usr_id(int ven_usr_id) {
        this.ven_usr_id = ven_usr_id;
    }

    /**
     * @return the ven_bic_id
     */
    public int getVen_bic_id() {
        return ven_bic_id;
    }

    /**
     * @param ven_bic_id the ven_bic_id to set
     */
    public void setVen_bic_id(int ven_bic_id) {
        this.ven_bic_id = ven_bic_id;
    }

    /**
     * @return the ven_fecha
     */
    public String getVen_fecha() {
        return ven_fecha;
    }

    /**
     * @return the usr_name
     */
    public String getUsr_name() {
        return usr_name;
    }

    /**
     * @return the usr_apellido
     */
    public String getUsr_apellido() {
        return usr_apellido;
    }

    /**
     * @return the bic_marco
     */
    public String getBic_marco() {
        return bic_marco;
    }
    
    public Object[] toArray(){
        Object[] data = {ven_id, usr_name, usr_apellido, bic_marco, ven_fecha};
        return data;
    }

    @Override
    public String toString() {
        return "ID:" + ven_id + "       Nombre: " + usr_name + " " + usr_apellido + "       Ref:" + bic_marco;
    }
    
    
}
