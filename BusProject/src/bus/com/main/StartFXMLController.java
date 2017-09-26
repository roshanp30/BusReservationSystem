/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.com.main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author roshan
 */
public class StartFXMLController implements Initializable {

    private Label label;
    @FXML
    private Button buttonstart;
    @FXML
    private AnchorPane mainWindow;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handlebuttonstartaction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/bus/com/login/Login.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);
            mainWindow.getScene().getWindow().hide();
        } catch (Exception e) {
            //System.out.println("Exception is "+e);
        }
    }

}
