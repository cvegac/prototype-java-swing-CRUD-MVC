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
public class UsuarioModel {

    
    private int usr_id;
    private String usr_nombre;
    private String usr_apellido;

    /**
     * Constructor con solo lo necesario
     * @param usr_id
     * @param usr_username
     * @param usr_nombre 
     */
    public UsuarioModel(int usr_id, String usr_nombre, String usr_apellido) {
        this.usr_id = usr_id;
        this.usr_nombre = usr_nombre;
        this.usr_apellido = usr_apellido;
    }
    
    /**
     * @return the usr_id
     */
    public int getUsr_id() {
        return usr_id;
    }

    /**
     * @return the usr_nombre
     */
    public String getUsr_nombre() {
        return usr_nombre;
    }

    /**
     * @return the usr_apellido
     */
    public String getUsr_apellido() {
        return usr_apellido;
    }
    
    @Override
    public String toString() {
        return getUsr_nombre() + " " + getUsr_apellido();
    }
    
    
}

