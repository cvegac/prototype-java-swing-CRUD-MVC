/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import access.UsuarioDAO;
import model.UsuarioModel;
import access.BicicletaDAO;
import model.BicicletaModel;
import view.ControlsPanel;

/**
 *
 * @author casierrav
 */
public class ChangeEvent implements ActionListener {

    private ControlsPanel controlsPanel;
    
    
    public ChangeEvent(ControlsPanel controlsPanel){
        this.controlsPanel = controlsPanel;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == this.controlsPanel.getCbxListaUsuarios()) {
            BicicletaDAO bicicletaDAO = new BicicletaDAO();
            ArrayList<BicicletaModel> bicicletas = null;
            int usr_id = ((UsuarioModel)this.controlsPanel.getCbxListaUsuarios().getSelectedItem()).getUsr_id();
            if(usr_id == -1) {
                bicicletas = bicicletaDAO.obtenerBicicletas();
                bicicletas.add(0, new BicicletaModel(-1, "Todas las bicicletas"));
            }
            else {
                bicicletas = bicicletaDAO.obtenerBicicletas();
                bicicletas.add(0, new BicicletaModel(-1, "Todas las bicicletas"));
                bicicletas = bicicletaDAO.obtenerBicicletasByUsr(usr_id);
                bicicletas.add(0, new BicicletaModel(-1, "Todas las presentaciones"));
            }
            this.controlsPanel.setCbxListaBicicletas(bicicletas);
        }
    }
    
}
