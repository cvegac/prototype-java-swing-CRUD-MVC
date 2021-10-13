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
import model.UsuarioModel;
import model.VentaModel;
import utils.ConnectionDB;

/**
 *
 * @author cvega
 */
public class UsuarioDAO {
    
    private Connection conn = null;
    
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        ArrayList<UsuarioModel> usuarios = new ArrayList<UsuarioModel>();
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "SELECT usr_id, usr_nombre, usr_apellido FROM usuario";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            
            while (result.next()) {
                UsuarioModel usuario = new UsuarioModel(result.getInt(1), 
                                    result.getString(2), result.getString(3));
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return usuarios;
    }
    
    public UsuarioModel obtenerUsuario(int usr_id){
        return null;
    }
    
    
}
