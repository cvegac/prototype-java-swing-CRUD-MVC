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
import model.BicicletaModel;
import utils.ConnectionDB;

/**
 *
 * @author cvega
 */
public class BicicletaDAO {
    private Connection conn = null;
    
    public ArrayList<BicicletaModel> obtenerBicicletas(){
        ArrayList<BicicletaModel> bicicletas = new ArrayList<BicicletaModel>();
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "SELECT bic_id, bic_marco FROM bicicleta";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            
            while (result.next()) {
                BicicletaModel bicicleta = new BicicletaModel(result.getInt(1), 
                                    result.getString(2));
                bicicletas.add(bicicleta);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return bicicletas;
    }
    
    public ArrayList<BicicletaModel> obtenerBicicletasByUsr(int usr_id){
        ArrayList<BicicletaModel> bicicletas = new ArrayList<BicicletaModel>();
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "select distinct bic_id, bic_marco "
                    + "from venta "
                    + "join bicicleta on (ven_bic_id=bic_id) "
                    + "join usuario on (ven_usr_id=usr_id) "
                    + "where usr_id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, usr_id);
            ResultSet result = statement.executeQuery();
            
            while (result.next()) {
                BicicletaModel bicicleta = new BicicletaModel(result.getInt(1), 
                                    result.getString(2));
                bicicletas.add(bicicleta);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return bicicletas;
    }
}
