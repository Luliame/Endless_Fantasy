package usables.consumables;

import java.util.Locale;
import java.util.ResourceBundle;

public class PlasticDuck implements ConsumableStrategies {

    Locale locale = new Locale("fr");
    ResourceBundle bundle = ResourceBundle.getBundle("values.usableName", locale);

    int lostLevel = 2;
    String name = "Duck";

    public void PlasticDuck(){
    //TODO: fait perdre deux niveaux à ceux qui le ramassent
    }

    @Override
    public void use() {
    //TODO
    }

    @Override
    public boolean shouldDelete(int maxUsage) {
        //TODO
        return false;
    }

    @Override
    public String getName() {
        return name;
    }
}
