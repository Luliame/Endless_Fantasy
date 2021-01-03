import Controller.AcceuilController;
import Controller.Navigation;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application{


    public static void main(String[] args) {
        /*GearEnum g1 = GearEnum.ADVENTURER_SWORD;
        GearEnum g2 = GearEnum.MASTER_SWORD;
        GearEnum g3 = GearEnum.CHAIN_MAIL_ARMOR;
        GearEnum g4 = GearEnum.WAND_2;
        System.out.println(g1.toString());
        System.out.println(g2.toString());
        System.out.println(g3.toString());
        System.out.println(g4.toString());*/
        new Test();
        //launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Accueil.fxml"));
        AcceuilController controller= new AcceuilController(new Navigation(primaryStage));
        loader.setController(controller);
        Scene scene = new Scene(loader.load(), 800, 500, Color.WHITE);
        scene.getStylesheets().add(getClass().getResource("/Css/style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Endless Fantasy");
        primaryStage.show();
    }
}
