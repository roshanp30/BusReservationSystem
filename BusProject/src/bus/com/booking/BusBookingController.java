/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.com.booking;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author roshan
 */
public class BusBookingController implements Initializable {

    @FXML
    private AnchorPane mainWindow;
    @FXML
    private ComboBox<String> menuDestinationCity;
    @FXML
    private DatePicker dateSelect;
    @FXML
    private ComboBox<String> ComboCity;
    @FXML
    private ComboBox<Integer> comboNoOFSeats;
    @FXML
    private Button buttonBook;

    /**
     * Initializes the controller class.
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ComboCity.getItems().addAll("Pune","Jalgaon","Mumbai");
        menuDestinationCity.getItems().addAll("Pune","Jalgaon","Mumbai");
        comboNoOFSeats.getItems().addAll(1,2,3,4);
    }    

    @FXML
    private void handleButtonBookAction(ActionEvent event) {
    }
    
}
