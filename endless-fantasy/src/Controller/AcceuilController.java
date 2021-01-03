package Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class AcceuilController {

    private Navigation navigation;

    public AcceuilController(Navigation navigation) {
        this.navigation = navigation;
    }

    @FXML
    private void sendToCreaPerso(ActionEvent event) throws IOException {
        navigation.navigateTo("/fxml/CreationPersonnage.fxml");
    }


    @FXML
    private void sendToParam(ActionEvent event) throws IOException {
        navigation.navigateTo("/fxml/Param.fxml");
    }

}
