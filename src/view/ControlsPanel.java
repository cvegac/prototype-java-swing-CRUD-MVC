/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ChangeEvent;
import controller.ClickEvent;
import controller.InitialData;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.UsuarioModel;
import model.BicicletaModel;
import model.VentaModel;

/**
 *
 * @author casierrav
 */
public class ControlsPanel extends JPanel {

    
 
    private JLabel                       lblUsuarios;
    private JComboBox<UsuarioModel>      cbxListaUsuarios;
    private JLabel                       lblBicicletas;
    private JComboBox<BicicletaModel>    cbxListaBicicletas;
    private JLabel                       lblMarco;
    private JTextField                   txtMarco;
    private JButton                      btnSearch;
    private JButton                      btnAddVenta;
    private JButton                      btnUpdateVenta;
    private JButton                      btnDeleteVenta;
    private JTable                       tblResults;
    
    /**
     * Constructor of the ControlsPanel class.
     * @param resultsPanel
     */
    public ControlsPanel(ResultsPanel resultsPanel){
        this.tblResults = resultsPanel.getTblResults();
        initComponents();
    }
    
    
    /**
     * 
     */
    private void initComponents(){
        setLayout(new GridLayout(2,1));
        InitialData initialData = new InitialData();
        
        // Complete Ventas info
        this.setTblResults(initialData.getVentas());
        
        // Museum selection
        this.lblUsuarios = new JLabel("Usuarios");
        add(this.getLblUsuarios());
        
        this.cbxListaUsuarios = new JComboBox();
        this.getCbxListaUsuarios().setModel(new DefaultComboBoxModel<>(initialData.getUsuarios().toArray(new UsuarioModel[initialData.getUsuarios().size()])));
        this.getCbxListaUsuarios().setSelectedIndex(0);
        add(this.getCbxListaUsuarios());
        
        ChangeEvent changeEvent = new ChangeEvent(this);
        this.getCbxListaUsuarios().addActionListener(changeEvent);
        
        
        // Bicicletas selection
        this.lblBicicletas = new JLabel("Bicicletas ");
        add(this.getLblBicicletas());
        
        this.cbxListaBicicletas = new JComboBox();
        this.setCbxListaBicicletas(initialData.getBicicletas());
        add(this.getCbxListaBicicletas());
        
        
        // Name marco
        this.lblMarco = new JLabel("Ref. marco");
        add(this.getLblMarco());
        
        this.txtMarco = new JTextField();
        add(this.getTxtMarco());
        
        
        // Search button
        this.btnSearch = new JButton("Buscar");
        add(this.getBtnSearch());
        
        ClickEvent clickEvent = new ClickEvent(this);
        this.getBtnSearch().addActionListener(clickEvent);
        
        // Insert  button
        this.btnAddVenta = new JButton("Agregar Nueva Venta");
        add(this.getBtnAddVenta());
        this.getBtnAddVenta().addActionListener(clickEvent);
        
        // Name marco
        this.lblMarco = new JLabel("");
        add(this.getLblMarco());
        // Insert  button
        this.btnUpdateVenta = new JButton("Actualizar Venta");
        add(this.getBtnUpdateVenta());
        this.getBtnUpdateVenta().addActionListener(clickEvent);
        
        // Name marco
        this.lblMarco = new JLabel("");
        add(this.getLblMarco());
        // Insert  button
        this.btnDeleteVenta = new JButton("Eliminar Venta");
        add(this.getBtnDeleteVenta());
        this.getBtnDeleteVenta().addActionListener(clickEvent);
    }

    
    /**
     * @param presentations
     */
    public void setCbxListaBicicletas(ArrayList<BicicletaModel> bicicletas) {
        this.cbxListaBicicletas.setModel(new DefaultComboBoxModel<>(bicicletas.toArray(new BicicletaModel[bicicletas.size()])));
        this.getCbxListaBicicletas().setSelectedIndex(0);
    }

    /**
     * @param artPieces
     */
    public void setTblResults(ArrayList<VentaModel> venta) {
        String[] headers = {"ID", "Nombre Usr", "Apellido Usr", "Ref. Marco", "Fecha"};
        this.getTblResults().removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers); 
        this.getTblResults().setModel(tableModel);
        for(int i=0; i<venta.size(); i++){
            tableModel.addRow(venta.get(i).toArray() );
        }
    }

    /**
     * @return the lblUsuarios
     */
    public JLabel getLblUsuarios() {
        return lblUsuarios;
    }

    /**
     * @return the cbxListaUsuarios
     */
    public JComboBox<UsuarioModel> getCbxListaUsuarios() {
        return cbxListaUsuarios;
    }

    /**
     * @return the lblBicicletas
     */
    public JLabel getLblBicicletas() {
        return lblBicicletas;
    }

    /**
     * @return the cbxListaBicicletas
     */
    public JComboBox<BicicletaModel> getCbxListaBicicletas() {
        return cbxListaBicicletas;
    }

    /**
     * @return the lblMarco
     */
    public JLabel getLblMarco() {
        return lblMarco;
    }

    /**
     * @return the txtMarco
     */
    public JTextField getTxtMarco() {
        return txtMarco;
    }

    /**
     * @return the btnSearch
     */
    public JButton getBtnSearch() {
        return btnSearch;
    }

    /**
     * @return the btnAddVenta
     */
    public JButton getBtnAddVenta() {
        return btnAddVenta;
    }

    /**
     * @return the btnUpdateVenta
     */
    public JButton getBtnUpdateVenta() {
        return btnUpdateVenta;
    }

    /**
     * @return the btnDeleteVenta
     */
    public JButton getBtnDeleteVenta() {
        return btnDeleteVenta;
    }
    
    /**
     * @return the tblResults
     */
    public JTable getTblResults() {
        return tblResults;
    }

    
   
}