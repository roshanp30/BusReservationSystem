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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import bus.com.utility.LogUtility;
import se.mbaeumer.fxmessagebox.MessageBox;
import se.mbaeumer.fxmessagebox.MessageBoxResult;
import se.mbaeumer.fxmessagebox.MessageBoxType;

/**
 * FXML Controller class
 *
 * @author roshan
 */
public class LoginController implements Initializable {

    @FXML
    private TextField txtUsername;
    @FXML
    private Button buttonNext;
    @FXML
    private Button buttonNewUser;
    @FXML
    private Button buttonAdminlogin;
    @FXML
    private AnchorPane mainWindow;

    private static final Logger logger = LogUtility.getLogger(LoginController.class);
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    static String usr;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleButtonNextAction(ActionEvent event) {
        if (txtUsername.getText().equals("")) {
            MessageBox mb = new MessageBox("Please Enter Username", MessageBoxType.OK_ONLY);
            mb.showAndWait();
            if (mb.getMessageBoxResult() == MessageBoxResult.OK) {
                System.out.println("OK");
            }
        } else {
            con = SqlConnect.ConnectDB();
            String q = "Select * from customer where username=?";
            try {

                ps = con.prepareStatement(q);
                usr=txtUsername.getText();
                ps.setString(1,usr);
                rs = ps.executeQuery();
                if (rs.next()) {
                    Parent root = FXMLLoader.load(getClass().getResource("/bus/com/login/LoginPassword.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                    stage.setResizable(false);
                    mainWindow.getScene().getWindow().hide();
                } else {
                    MessageBox mb = new MessageBox("Please Enter Correct Username", MessageBoxType.OK_ONLY);
                    mb.showAndWait();
                    if (mb.getMessageBoxResult() == MessageBoxResult.OK) {
                        System.out.println("OK");
                    }
                }

            } catch (Exception e) {
                //System.out.println("Exception is "+e);
                logger.error(e);
            }
        }
    }

    @FXML
    private void handleButtonNewuserAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/bus/com/signup/SignUp.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);
            mainWindow.getScene().getWindow().hide();
        } catch (Exception e) {
            logger.error(e);
        }
    }

    @FXML
    private void handleButtonAdminloginAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/bus/com/login/LoginAdminUsername.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);
            mainWindow.getScene().getWindow().hide();
        } catch (Exception e) {
            //System.out.println("Exception is "+e);
            logger.error(e);
        }
    }

}
