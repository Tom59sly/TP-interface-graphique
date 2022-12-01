package fr.dampierre;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    private Button buttonColor;

    @FXML
    private Button secondaryButton;

    @FXML
    private Label vue2_coucou;


    @FXML
    void switchColor(ActionEvent event) {
        vue2_coucou.setText("COUCOU !");
        secondaryButton.disableProperty();
    }
}