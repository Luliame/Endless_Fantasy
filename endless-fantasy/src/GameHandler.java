import movement.Map;
import movement.Room;
import characters.Monster;
import characters.Player;
import characters.Character;
import usables.UsableState;
import usables.gear.Gear;

import java.util.ArrayList;
import java.util.Scanner;

public class GameHandler {

    Map map;
    Player player;
    Room currRoom;
    Monster currMonster;

    public Boolean fight(Character player, Character foe){
        //Character winner = player;
        int agilityP;
        int agilityF;
        while (player.getHp()>0 && foe.getHp()>0){
            agilityP = player.getAgility();
            agilityF = foe.getAgility();
            if (agilityF > agilityP){
                foe.attack(player);
                System.out.println("hp player: " + player.getHp());
                if (player.getHp() <= 0 || foe.getHp() <= 0){
                    //return true;
                    break;
                }

                if (player.attack(foe))
                    break;
                else
                    System.out.println("hp foe: " + foe.getHp());

            } else {
                if (player.attack(foe))
                    break;
                else
                    System.out.println("hp foe: " + foe.getHp());

                if (foe.getHp() <= 0 || player.getHp() <= 0) {
                    //return false;
                    break;
                }

                foe.attack(player);
                System.out.println("hp player: " + player.getHp());
            }
        }
        System.out.println("fin du combat");
        if (player.getHp() <= 0){
            //winner = foe;
            return true;
        }
        return false;
    }
    /*public Character fight(ArrayList<Character> fighters){
        ArrayList<Player> p = new ArrayList<>();
        for (int i = 0; i <= fighters.size(); i++){
            if (fighters.get(i) instanceof Player)
                p.add((Player) fighters.remove(i));
        }
        while (p.size() > 0 && fighters.size() > 0){

        }
        return null;
    }*/

    public Player play(Player player){
        Map map = new Map();//passer en arg Room[] des pièces à replacer ?
        Scanner s = new Scanner(System.in);

        System.out.println(player.toString());

        while (player.getHp() > 0){
            Room currRoom = map.getCurrentRoom();
            Monster currFoe = currRoom.getFoe();
            UsableState currLoot = currRoom.getLoot();

            System.out.println(currRoom.toString());
            if (currFoe != null){
                System.out.println(currFoe.toString());
                if (this.fight(player, currFoe))//combat(s) => switch action aussi ?
                    break;
                currRoom.setFoe(null);
            }
            System.out.println("\nPossibilitées: (i) inventaire - (p) prendre - directions (haut)(bas)(gauche)(droite) :");
            String action = s.next().toLowerCase();
            switch (action){
                case "haut", "bas", "gauche", "droite":
                    map.move(action);
                    player.increaseRoom();
                    break;
                case "inventaire", "i":
                    System.out.println(player.getInventory().toString());
                    player.inventoryManagement();
                    break;
                case "prendre", "p":
                    if (currLoot != null) {
                        if (currLoot instanceof Gear) {
                            player.take(currLoot);
                            player.equip((Gear) currLoot);
                            player.dispStats();
                            //p.unequip((Gear) currLoot);
                            //p.dispStats();
                        } else
                            player.take(currLoot);
                        currRoom.setLoot(null);
                    }
                    else
                        System.out.println("il n'y a rien à prendre ici\n");
                    break;
                    //drop, equip, unequip...
                default:
                    System.out.println("action impossible");
                    break;
            }
        }
        System.out.println("Game over!");
        return player;
    }

    //non final
    public Player run(){
        //création de joueur
        Player p = new Player();

        //map
        Map m = new Map();
        Scanner s = new Scanner(System.in);

        p.dispStats();
        while (p.getHp() >= 0){
            Room currRoom = m.getCurrentRoom();
            System.out.println(currRoom.toString());
            Monster currMob = currRoom.getFoe();
            UsableState currLoot = currRoom.getLoot();
            if (currMob != null) {
                currMob.dispMonster();
                /*while (p.getHp()>0&&currMob.getHp()>0){
                    p.speak("J'attaque "+currMob.getName());
                    if (!p.attack(currMob)){
                        currMob.speak("grblgrglb");
                        currMob.attack(p);
                    }
                }
                if (currMob.getHp()<=0){
                    m.removeMob();
                } else if (p.getHp()<=0){
                    break;
                }*/
            }
            if (currLoot != null){
                p.take(currLoot);
                if (currLoot instanceof Gear){
                    p.equip((Gear) currLoot);
                    p.dispStats();
                    //p.unequip((Gear) currLoot);
                    //p.dispStats();
                }
            }
            String destination = s.nextLine();
            m.move(destination);
            p.increaseRoom();
        }
        System.out.println("game over");
        return p;
    }
    //
}
