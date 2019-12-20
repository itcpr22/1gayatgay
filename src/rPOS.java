
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class rPOS {
    connections con = new connections();
    
    void getProduct(String BC, JTable table){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection(con.url,con.username,con.password);
        
            String sql = "SELECT * FROM tblproducts WHERE id = ?;";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            
            pstmt.setString(1, BC);
            
            
            ResultSet rs = pstmt.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            if(rs.next()){
                
                model.addRow(new Object[]{rs.getString("id"),1 ,rs.getString("P_Name"),rs.getString("Qty"), rs.getString("price")});
            }else{
                JOptionPane.showMessageDialog(table, "No Product on database");
            }     
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(cPOS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(cPOS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }   
    
}
