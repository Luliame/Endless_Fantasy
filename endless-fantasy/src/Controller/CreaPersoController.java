package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class CreaPersoController {
    @FXML
    private Navigation navigation;

    public CreaPersoController(Navigation navigation) {
        this.navigation = navigation;
    }

    @FXML
    private void sendToAcceuil(ActionEvent event) throws IOException {
        navigation.navigateTo("/fxml/Accueil.fxml");
    }

    public void sendToGame(ActionEvent actionEvent) throws IOException{
        navigation.navigateTo("/fxml/GameWindowsController");
    }
}
