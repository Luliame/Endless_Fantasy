package movement;

import characters.Monster;
import usables.gear.Gear;
import usables.UsableState;

import java.util.HashMap;
import java.util.Random;

public class Room {
    private String name;
    private final HashMap<DirectionEnum, Room> directionMap;
    private Coordinate coordinate;
    private Monster foe;
    //private Character pnj;
    private UsableState loot;
    private Random x = new Random();
    int monsterProb = 5;
    int lootProb = 5;

    public Room(){
        this.name = RoomNameEnum.randomName();
        this.directionMap = new HashMap<>();
        if (x.nextInt(monsterProb) == 1){
            this.foe = new Monster();
        }
        if (x.nextInt(lootProb) == 1){
            this.loot = new Gear();
        }
    }
    public Room(Coordinate coordinate){
        this();
        this.coordinate = coordinate;
    }
    public Room(String name){
        this();
        this.name = name;
        this.foe = null;
    }

    public void addPath(DirectionEnum direction, Room destination){
        this.directionMap.put(direction, destination);
        destination.directionMap.put(direction.getOppositeEnum(), this);
    }

    protected void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
    public void setFoe(Monster foe) {
        this.foe = foe;
    }
    public void setLoot(UsableState loot) {
        this.loot = loot;
    }
    /*public void setPnj(Character pnj) {
        this.pnj = pnj;
    }*/

    public Coordinate getCoordinate() { return coordinate; }
    public Monster getFoe() {
        return foe;
    }
    public Room getDestination(String dest) {
        return this.directionMap.get(DirectionEnum.search(dest));
    }
    public UsableState getLoot() {
        return loot;
    }

    @Override
    public String toString() {
        String n = null;
        if (this.loot != null){
            n = loot.getName();
        }
        return "Salle{" +
                "coordonées=" + coordinate.toString() +
                "name='" + name + '\'' +
                ", direction=" + directionMap.keySet() +
                ", mob=" + foe +
                ", loot=" + n +
                '}';
    }
}
