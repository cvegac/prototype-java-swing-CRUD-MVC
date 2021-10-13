/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.VentaModel;
import utils.ConnectionDB;

/**
 *
 * @author cvega
 */
public class VentaDAO {
    
    private Connection conn = null;
    
    public ArrayList<VentaModel> obtenerTodasVentas(){
        ArrayList<VentaModel> ventas = new ArrayList<VentaModel>();
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "select ven_id, ven_usr_id, ven_bic_id, ven_fecha, "
                              + "usr_nombre, usr_apellido, bic_marco "
                    + "from venta "
                    + "join bicicleta on (ven_bic_id=bic_id) "
                    + "join usuario on (ven_usr_id=usr_id) "
                    + "order by ven_fecha desc";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            
            while (result.next()) {
                VentaModel venta = new VentaModel(result.getInt(1), 
                        result.getInt(2), result.getInt(3), result.getString(4), 
                        result.getString(5), result.getString(6), result.getString(7));
                ventas.add(venta);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return ventas;
    }
    
    public ArrayList<VentaModel> obtenerVentasFiltradas(String bic_marco, int bic_id, int usr_id){
        ArrayList<VentaModel> ventas = new ArrayList<VentaModel>();
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "select ven_id, ven_usr_id, ven_bic_id, ven_fecha, "
                              + "usr_nombre, usr_apellido, bic_marco "
                    + "from venta "
                    + "join bicicleta on (ven_bic_id=bic_id) "
                    + "join usuario on (ven_usr_id=usr_id) "
                    + "where bic_marco like ?";
            if (bic_id != -1) {
                sql += "and bic_id= ? ";
            }
            if (usr_id != -1){
                sql += "and usr_id= ? ";
            }
            sql += " order by ven_fecha desc";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "%"+bic_marco+"%");
            if (bic_id != -1) {
                statement.setInt(2, bic_id);
                if (usr_id != -1){
                    statement.setInt(3, usr_id);
                }
            }
            else if (usr_id != -1){
                statement.setInt(2, usr_id);
            }
            System.out.println(statement.toString());
            ResultSet result = statement.executeQuery();
            
            while (result.next()) {
                VentaModel venta = new VentaModel(result.getInt(1), 
                        result.getInt(2), result.getInt(3), result.getString(4), 
                        result.getString(5), result.getString(6), result.getString(7));
                ventas.add(venta);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return ventas;
    }
    
    public void agregarVenta(VentaModel venta){
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            
            String sql = "INSERT INTO venta (ven_usr_id, ven_bic_id) values (?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, venta.getVen_usr_id());
            statement.setInt(2, venta.getVen_bic_id());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted>0) {
                JOptionPane.showMessageDialog(null, "Venta ingresada");
            }else{
                JOptionPane.showMessageDialog(null, "Venta no ingresada");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
    
    public void acualizarVenta(VentaModel venta){
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "update venta set ven_usr_id = ?, ven_bic_id = ? where ven_id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, venta.getVen_usr_id());
            statement.setInt(2, venta.getVen_bic_id());
            statement.setInt(3, venta.getVen_id());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted>0) {
                JOptionPane.showMessageDialog(null, "Venta actualizada");
            }else{
                JOptionPane.showMessageDialog(null, "Venta no actualizada");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
    
    public void eliminarVenta(int ven_id){
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "delete from venta where ven_id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, ven_id);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted>0) {
                JOptionPane.showMessageDialog(null, "Venta eliminada");
            }else{
                JOptionPane.showMessageDialog(null, "Venta no eliminada");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }

    
    
}
