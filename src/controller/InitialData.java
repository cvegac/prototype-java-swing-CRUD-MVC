/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import access.*;
import model.*;
import java.util.ArrayList;


/**
 *
 * @author casierrav
 */
public class InitialData {
    private ArrayList<BicicletaModel>   bicicletas       = null;
    private ArrayList<UsuarioModel>     usuarios         = null;
    private ArrayList<VentaModel>       ventas           = null;
    
    /**
     * Zero-parameters constructor
     */
    public InitialData(){
        BicicletaDAO bicicletaDAO = new BicicletaDAO();
        this.bicicletas = bicicletaDAO.obtenerBicicletas();
        this.bicicletas.add(0, new BicicletaModel(-1, "Todas las bicicletas"));
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        this.usuarios = usuarioDAO.obtenerUsuarios();
        this.usuarios.add(0, new UsuarioModel(-1, "Todos los","usuarios"));
        
        VentaDAO ventaDAO = new VentaDAO();
        this.ventas = ventaDAO.obtenerTodasVentas();
    }

    /**
     * @return the bicicletas
     */
    public ArrayList<BicicletaModel> getBicicletas() {
        return bicicletas;
    }

    /**
     * @return the usuarios
     */
    public ArrayList<UsuarioModel> getUsuarios() {
        return usuarios;
    }

    
    /**
     * @return the ventas
     */
    public ArrayList<VentaModel> getVentas() {
        return ventas;
    }

    
}