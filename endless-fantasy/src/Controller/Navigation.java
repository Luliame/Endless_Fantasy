package Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Navigation {

    private Stage stage;
    private Map<String,Scene> scenes = new HashMap<>();

    public Navigation(Stage stage) {
        this.stage = stage;
    }

    public void navigateTo(String fxml ) throws IOException {
        Scene scene = scenes.get(fxml);
        if(scene == null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();
            scene = new Scene(root, 800, 500, Color.WHITE);
            scene.getStylesheets().add(getClass().getResource("/Css/style.css").toExternalForm());
            scenes.put(fxml,scene);
        }
        stage.setScene(scene);
    }

}
