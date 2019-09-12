import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class login {
    connections cn = new connections();

public int login(String username, String password){
    int r = 0;
    try {
        Class.forName(cn.driver);
        Connection con = DriverManager.getConnection(cn.local,cn.ps,cn.sr);
        PreparedStatement pst = con.prepareStatement("select * from bsit23 where username=? and password=nd5(?)");
        pst.setString(1, username);
        pst.setString(2, password);
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            r=1;
        }else{
            r=0;
        }
        
        
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
    }return r;
}
}