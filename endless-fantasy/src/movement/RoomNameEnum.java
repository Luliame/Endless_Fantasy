package movement;


import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

public enum RoomNameEnum {
    CORRIDOR("Corridor"),
    DINING_ROOM("DiningRoom"),
    KITCHEN("Kitchen"),
    LIBRARY("Library"),
    OFFICE("Office"),
    BED_ROOM("BedRoom"),
    LIVING_ROOM("LivingRoom"),
    ARSENAL("Arsenal"),
    GUARD_ROOM("GuardRoom");

    private final String name;

    private static final List<RoomNameEnum> listName = List.of(values());
    private static final int sizeListName = listName.size();
    private static final Random x = new Random();

    RoomNameEnum(String name){
        Locale locale = new Locale("fr");
        ResourceBundle bundle = ResourceBundle.getBundle("values.roomName", locale);
        this.name = bundle.getString(name);
    }

    public static String randomName(){
        return listName.get(x.nextInt(sizeListName)).name;
    }
}
