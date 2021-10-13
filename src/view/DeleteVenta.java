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
public class DeleteVenta extends JFrame implements ActionListener {
    private JLabel                      lblVentas;
    private JComboBox<VentaModel>       cbxListaVentas;
    private JButton                     btnDeleteVenta;
    private JButton                     btnCerrar;
    
    public DeleteVenta(){
        initComponents();
    }
    
    public void initComponents(){
        setTitle("Eliminar Venta");
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
        this.cbxListaVentas.setSelectedIndex(0);
        add(this.cbxListaVentas);
        
        this.lblVentas = new JLabel("");
        add(this.lblVentas);
        
        this.btnDeleteVenta = new JButton("Eliminar");
        add(this.btnDeleteVenta);
        this.btnDeleteVenta.addActionListener(this);
        
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
        if(actionEvent.getSource() == this.btnDeleteVenta) { 
            int    ven_id = ((VentaModel)this.cbxListaVentas.getSelectedItem()).getVen_id();
    
            VentaModel venta = new VentaModel(ven_id, 0, 0, "");
            
            VentaDAO ventaDAO = new VentaDAO();
            ventaDAO.eliminarVenta(venta.getVen_id());
        }else if (actionEvent.getSource() == this.btnCerrar) {
            setVisible(false);
        }
    }
}
