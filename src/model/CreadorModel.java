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
public class CreadorModel {
    private int cre_id;
    private String cre_nombre;
    private String cre_apellido;
    private String cre_nacionalidad;
    
    //campos de los join que se vayan a usar

    /**
     * Constructor para manejo interno de la tabla
     * @param cre_id
     * @param cre_nombre
     * @param cre_apellido
     * @param cre_nacionalidad 
     */
    public CreadorModel(int cre_id, String cre_nombre, String cre_apellido, String cre_nacionalidad) {
        this.cre_id = cre_id;
        this.cre_nombre = cre_nombre;
        this.cre_apellido = cre_apellido;
        this.cre_nacionalidad = cre_nacionalidad;
    }
    
    /*Poliformismo del constructor para posibles campos que en
      entraran con el join (proyeccion)*/

    /**
     * @return the cre_id
     */
    public int getCre_id() {
        return cre_id;
    }

    /**
     * @return the cre_nombre
     */
    public String getCre_nombre() {
        return cre_nombre;
    }

    /**
     * @return the cre_apellido
     */
    public String getCre_apellido() {
        return cre_apellido;
    }

    /**
     * @return the cre_nacionalidad
     */
    public String getCre_nacionalidad() {
        return cre_nacionalidad;
    }

    @Override
    public String toString() {
        return this.cre_nombre+" "+this.cre_apellido;
    }
}
