/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import access.VentaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.VentaModel;
import model.UsuarioModel;
import model.BicicletaModel;
import view.AddVenta;
import view.DeleteVenta;
import view.UpdateVenta;
import view.ControlsPanel;

/**
 *
 * @author casierrav
 */
public class ClickEvent implements ActionListener {

    private ControlsPanel controlsPanel;
    
    /**
     * Constructor of the class
     * @param controlsPanel 
     */
    public ClickEvent(ControlsPanel controlsPanel){
        this.controlsPanel = controlsPanel;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == this.controlsPanel.getBtnSearch()) {
            int usr_id        = ((UsuarioModel)this.controlsPanel.getCbxListaUsuarios().getSelectedItem()).getUsr_id();
            int bic_id        = ((BicicletaModel)this.controlsPanel.getCbxListaBicicletas().getSelectedItem()).getBic_id();
            String bic_marco  = (String)this.controlsPanel.getTxtMarco().getText();
            
            
            
            //System.out.println(idMuseum + " " + idPresentation + " " + datePresentation + " " + artPieceName);
            VentaDAO ventaDAO = new VentaDAO();
            ArrayList<VentaModel> ventas = ventaDAO.obtenerVentasFiltradas(bic_marco, bic_id, usr_id);
            
            this.controlsPanel.setTblResults(ventas);
        }
        else if(actionEvent.getSource() == this.controlsPanel.getBtnAddVenta()) {
            AddVenta addVentaView = new AddVenta();
            addVentaView.setVisible(true);
        }
        else if(actionEvent.getSource() == this.controlsPanel.getBtnUpdateVenta()) {
            UpdateVenta updateVentaView = new UpdateVenta();
            updateVentaView.setVisible(true);
        }  
        else if(actionEvent.getSource() == this.controlsPanel.getBtnDeleteVenta()) {
            DeleteVenta deleteVentaView = new DeleteVenta();
            deleteVentaView.setVisible(true);
        }     
    }
}