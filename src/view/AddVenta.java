/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import access.VentaDAO;
import controller.ClickEvent;
import controller.InitialData;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.VentaModel;
import model.UsuarioModel;
import model.BicicletaModel;

/**
 *
 * @author casierrav
 */
public class AddVenta extends JFrame implements ActionListener {
    private JLabel                      lblUsuarios;
    private JComboBox<UsuarioModel>     cbxListaUsuarios;
    private JLabel                      lblBicicletas;
    private JComboBox<BicicletaModel>   cbxListaBicicletas;
    private JButton                     btnInsertVenta;
    private JButton                     btnCerrar;
    
    public AddVenta(){
        initComponents();
    }
    
    public void initComponents(){
        setTitle("Agregar Venta");
        setLayout(new GridLayout(8,2));
        
        setSize(500, 500);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize  = getSize();
        setLocation((screenSize.width  - frameSize.width)  / 2, 
                    (screenSize.height - frameSize.height) / 2);
        
        InitialData initialData = new InitialData();
        
        this.lblUsuarios = new JLabel("Seleccione usuario:");
        add(this.lblUsuarios);
        this.cbxListaUsuarios = new JComboBox();
        this.cbxListaUsuarios.setModel(new DefaultComboBoxModel<>(initialData.getUsuarios().toArray(new UsuarioModel[initialData.getUsuarios().size()])));
        this.cbxListaUsuarios.setSelectedIndex(0);
        add(this.cbxListaUsuarios);
        
        this.lblBicicletas = new JLabel("Seleccione bicicleta:");
        add(this.lblBicicletas);
        this.cbxListaBicicletas = new JComboBox();
        this.cbxListaBicicletas.setModel(new DefaultComboBoxModel<>(initialData.getBicicletas().toArray(new BicicletaModel[initialData.getBicicletas().size()])));
        this.cbxListaBicicletas.setSelectedIndex(0);
        add(this.cbxListaBicicletas);
        
        this.lblBicicletas = new JLabel("                                                                                   ");
        add(this.lblBicicletas);
        
        this.btnInsertVenta = new JButton("Agregar");
        add(this.btnInsertVenta);
        this.btnInsertVenta.addActionListener(this);
        
        this.lblBicicletas = new JLabel(" ");
        add(this.lblBicicletas);
        
        this.btnCerrar = new JButton("Cerrar");
        add(this.btnCerrar);
        this.btnCerrar.addActionListener(this);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == this.btnInsertVenta) { 
            int    ven_usr_id = ((UsuarioModel)this.cbxListaUsuarios.getSelectedItem()).getUsr_id();
            int    ven_bic_id = ((BicicletaModel)this.cbxListaBicicletas.getSelectedItem()).getBic_id();
    
            VentaModel venta = new VentaModel(0, ven_usr_id, ven_bic_id, "");
            
            VentaDAO ventaDAO = new VentaDAO();
            ventaDAO.agregarVenta(venta);
        }else if (actionEvent.getSource() == this.btnCerrar) {
            setVisible(false);
        }
    }
}
