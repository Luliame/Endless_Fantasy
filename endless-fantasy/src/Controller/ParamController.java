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

public class ParamController {
    @FXML
    private Button btnReturn;

    @FXML
    private void sendToAcceuil(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/Accueil.fxml"));
        Parent root = loader.load();
        Stage window = (Stage) btnReturn.getScene().getWindow();
        Scene scene = new Scene(root, 800, 500, Color.WHITE);
        scene.getStylesheets().add(getClass().getResource("Css/style.css").toExternalForm());
        window.setScene(scene);
    }
}
