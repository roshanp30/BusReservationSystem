/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.com.login;

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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import se.mbaeumer.fxmessagebox.MessageBox;
import se.mbaeumer.fxmessagebox.MessageBoxResult;
import se.mbaeumer.fxmessagebox.MessageBoxType;
/**
 * FXML Controller class
 *
 * @author roshan
 */
public class LoginPasswordController implements Initializable {

    @FXML
    private Button buttonNext;
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private ImageView mainWindow;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    
    @FXML
    private void handleButtonNextActon(ActionEvent event) {
        con = SqlConnect.ConnectDB();
        String q = "Select * from customer where password=? and username=?";
        try {
            ps = con.prepareStatement(q);
            ps.setString(1, txtPassword.getText());
            ps.setString(2, LoginController.usr);
            //System.out.println(LoginController.usr);
            rs = ps.executeQuery();
            if (rs.next()) {
                Parent root = FXMLLoader.load(getClass().getResource("/bus/com/booking/BusBooking.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
                stage.setResizable(false);
                mainWindow.getScene().getWindow().hide();
            } else {
                MessageBox mb = new MessageBox("Please Enter Correct Password", MessageBoxType.OK_ONLY);
                mb.showAndWait();
                if (mb.getMessageBoxResult() == MessageBoxResult.OK) {
                    System.out.println("OK");
                }
            }

        } catch (Exception e) {
            //System.out.println("Exception is "+e);
        }
    }

}
