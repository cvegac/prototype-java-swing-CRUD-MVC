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
public class UpdateVenta extends JFrame implements ActionListener {
    private JLabel                      lblVentas;
    private JComboBox<VentaModel>       cbxListaVentas;
    private JLabel                      lblUsuarios;
    private JComboBox<UsuarioModel>     cbxListaUsuarios;
    private JLabel                      lblBicicletas;
    private JComboBox<BicicletaModel>   cbxListaBicicletas;
    private JButton                     btnUpdateVenta;
    private JButton                     btnCerrar;
    
    public UpdateVenta(){
        initComponents();
    }
    
    public void initComponents(){
        setTitle("Actulalizar Venta");
        setLayout(new GridLayout(8,2));
        
        setSize(500, 500);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize  = getSize();
        setLocation((screenSize.width  - frameSize.width)  / 2, 
                    (screenSize.height - frameSize.height) / 2);
        
        InitialData initialData = new InitialData();
        
        this.lblVentas = new JLabel("Seleccione el Id de la venta:");
        add(this.lblVentas);
        
        this.cbxListaVentas = new JComboBox();
        this.cbxListaVentas.setModel(new DefaultComboBoxModel<>(initialData.getVentas().toArray(new VentaModel[initialData.getVentas().size()])));
        add(this.cbxListaVentas);
        
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
        
        this.lblVentas = new JLabel("");
        add(this.lblVentas);
        
        this.btnUpdateVenta = new JButton("Actualizar");
        add(this.btnUpdateVenta);
        this.btnUpdateVenta.addActionListener(this);
        
        this.lblVentas = new JLabel("");
        add(this.lblVentas);
        
        this.btnCerrar = new JButton("Cerrar");
        add(this.btnCerrar);
        this.btnCerrar.addActionListener(this);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == this.btnUpdateVenta) { 
            int    ven_id = ((VentaModel)this.cbxListaVentas.getSelectedItem()).getVen_id();
            int    ven_usr_id = ((UsuarioModel)this.cbxListaUsuarios.getSelectedItem()).getUsr_id();
            int    ven_bic_id = ((BicicletaModel)this.cbxListaBicicletas.getSelectedItem()).getBic_id();
    
            VentaModel venta = new VentaModel(ven_id, ven_usr_id, ven_bic_id, "");
            
            VentaDAO ventaDAO = new VentaDAO();
            ventaDAO.acualizarVenta(venta);
        }else if (actionEvent.getSource() == this.btnCerrar) {
            setVisible(false);
        }
    }
}
