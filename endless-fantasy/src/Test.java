import characters.Player;

import java.util.Scanner;

public class Test {
    public Test(){
        Graveyard gy = new Graveyard();
        whileBreack:
            while (true){
                System.out.println("Affihcer le cimetière(1), continuer(2) ou quitter(3):");
                Scanner s = new Scanner(System.in);
                int next = s.nextInt();
                switch (next){
                    case 1:
                        gy.dispGraveyard();
                        break;
                    case 2:
                        GameHandler g = new GameHandler();
                        //Player p = g.run();
                        Player p = g.play(new Player());
                        gy.addCorpse(p);
                        break;
                    default:
                        break whileBreack;
                }
            }


        /*//Test création de joueur
        persos.Player j = new persos.Player();
        j.dispStats();

        //Test map
        movement.Map m = new movement.Map();
        Scanner s = new Scanner(System.in);
        while (j.hp >= 0){
            movement.Room currRoom = m.getCurrentRoom();
            System.out.println(currRoom.toString());
            persos.Monster currMob = currRoom.getMob();
            if (currMob != null) {
                currMob.dispMonster();
                while (j.hp>0&&currMob.hp>0){
                    j.speak("J'attaque "+currMob.name);
                    if (!j.attack(currMob)){
                        currMob.speak("grblgrglb");
                        currMob.attack(j);
                    }
                }
                if (currMob.hp<=0){
                    m.removeMob();
                } else if (j.hp<=0){
                    break;
                }
            }
            String destination = s.nextLine();
            boolean test = m.move(destination);
            if (test){
                System.out.println("déplacement");
            } else {
                System.out.println("déplacement impossible");
            }
        }
        System.out.println("game over");*/

        //Test combat
        /*boolean mort = false;
        persos.Monster m1 = new persos.Monster();
        persos.Monster m2 = new persos.Monster();
        m1.name = "Gobelin1";
        m1.dispMonster();
        while (!mort) {
            m1.speak("J'attaque "+m2.name);
            mort = m1.attaquer(m2);
            System.out.println(m2.hp);
        }*/

    }
}
