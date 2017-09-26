/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.com.signup;

import bus.com.utility.SqlConnect;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author roshan
 */

public class SignUpController implements Initializable {

    @FXML
    private PasswordField txtPassword;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtMobno;
    @FXML
    private TextField txtAddress;
    @FXML
    private PasswordField txtCPassword;
    @FXML
    private Button buttonSubmit;
    @FXML
    private TextField txtAge;
Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    @FXML
    private TextField txtuidai;
    @FXML
    private TextField txtDob;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButtonSubmitAction(ActionEvent event) {
        con=SqlConnect.ConnectDB();
        boolean valid=true;
        String q = "insert into customer(username,password,name,dob,address,mobile_number,uidai_no,gender,age) values(?,?,?,?,?,?,?,?,?)  ";
        if(txtName.getText().equals(""))
        {
            System.out.println("Enter Valid name");
            valid=false;
        }
  
       Validateinput VI=new Validateinput();
       if(VI.validate(txtPassword.toString())!=true)
       {
           System.out.println("Enter Valid Password "+txtPassword.getText().toString());
           valid=false;
       }
        try {
            
            ps = con.prepareStatement(q);
            ps.setString(1,txtName.getText());
            ps.setString(2,txtPassword.getText());
            ps.setString(3,txtName.getText());
            ps.setString(4,txtDob.getText());
            ps.setString(5,txtAddress.getText());
            ps.setString(6,txtMobno.getText());
            ps.setString(7,txtuidai.getText());
            ps.setString(8,"M");
           ps.setString(9,txtAge.getText());
           int rowsInserted = ps.executeUpdate();
           if(rowsInserted>0)
           {
            System.out.println("User inserted");
            Parent root = FXMLLoader.load(getClass().getResource("/bus/com/login/Login.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);
         //   mainWindow.getScene().getWindow().hide()
          
           }
           else
           {
               System.out.println("User not inserted");
           }
            
        } catch (Exception e) {
            System.out.println("Exception is "+e);
        }
 
    }   
   
}
