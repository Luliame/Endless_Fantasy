package movement;

import characters.Monster;
import characters.RaceEnum;
import usables.gear.Gear;

import java.util.HashMap;

public class Map {
    private final HashMap<Coordinate, Room> roomCollection;
    private Room currentRoom;

    public Map(){
        this.roomCollection = new HashMap<>();

        Room s1 = new Room("Hall");
        Room s2 = new Room();
        Room s3 = new Room();
        Room s4 = new Room();
        Room s5 = new Room();
        Room s6 = new Room();

        s1.setCoordinate(new Coordinate(0,0));

        //test
        s2.setCoordinate(new Coordinate(0,1));
        s3.setCoordinate(new Coordinate(0,-1));
        s4.setCoordinate(new Coordinate(-1,0));
        s5.setCoordinate(new Coordinate(1,0));
        s6.setCoordinate(new Coordinate(0,2));

        s1.addPath(DirectionEnum.HAUT,s2);
        s1.addPath(DirectionEnum.BAS,s3);
        s1.addPath(DirectionEnum.GAUCHE,s4);
        s1.addPath(DirectionEnum.DROITE,s5);
        s2.addPath(DirectionEnum.HAUT,s6);

        roomCollection.put(s1.getCoordinate(), s1);
        roomCollection.put(s2.getCoordinate(), s2);
        roomCollection.put(s3.getCoordinate(), s3);
        roomCollection.put(s4.getCoordinate(), s4);
        roomCollection.put(s5.getCoordinate(), s5);
        roomCollection.put(s6.getCoordinate(), s6);

        s6.setFoe(new Monster(RaceEnum.CHICKEN));
        s2.setLoot(new Gear());
        //fin test

        this.currentRoom = s1;
    }

    public void move(String destination){
        Room roomDest;
        DirectionEnum dir = DirectionEnum.search(destination);
        int x = currentRoom.getCoordinate().getX() + dir.getCoordinateX();
        int y = currentRoom.getCoordinate().getY() + dir.getCoordinateY();
        Coordinate coordinateDest = new Coordinate(x,y);
        if (!roomCollection.containsKey(coordinateDest)){
            currentRoom.addPath(dir, new Room(coordinateDest));
            roomDest = currentRoom.getDestination(destination);
            roomCollection.put(roomDest.getCoordinate(),roomDest);
        } else {
            currentRoom.addPath(dir, roomCollection.get(coordinateDest));
            roomDest = currentRoom.getDestination(destination);
        }
        this.currentRoom = roomDest;
    }

    public void removeMob(){
        this.currentRoom.setFoe(null);
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
}
