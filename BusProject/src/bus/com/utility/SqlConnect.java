/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.com.utility;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author roshan
 */
public class SqlConnect {
        Connection con=null;
        String url = "jdbc:mysql://localhost:3306/";
        String dbname = "demo";
        String driver = "com.mysql.jdbc.Driver";
        String username = "roshan";
        String password = "1234567";
    public static Connection ConnectDB()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            //System.out.println("Driver Registered Sucessfully");
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bus","root","30041997");
        //JOptionPane.showMessageDialog(null,"Connected To Database");
        return con;
        }
        catch(Exception e)
        {
          //  JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
