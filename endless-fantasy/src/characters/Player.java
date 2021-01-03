package characters;

import stats.*;

import java.util.Random;
import java.util.Scanner;

public class Player extends Character {
    private String classP;
    //private int sanity;
    private int roomThrough;

    public Player(){
        this.creatPlayer();
    }

    @Override
    public boolean attack(Character foe) {
        boolean flee = false;
        boolean onFight = true;
        Scanner s = new Scanner(System.in);
        while (onFight){
            System.out.println("Possibilités: (a) Action - (o) Objet - (c) Check - (f) Fuite");
            String action = s.nextLine();
            switch (action) {
                case "a":
                    super.attack(foe);//?
                    onFight = false;
                    break;
                case "o":
                    System.out.println(this.inventory.toString());//fonction gestion inventaire / objets etc.
                    this.inventoryManagement();
                    onFight = false;
                    //onFight = this.inventoryManagement(); pour savoir si une action a été faite ?
                    break;
                case "c":
                    System.out.println(foe.getStats().toString());
                    break;
                case "f":
                    Random x = new Random();
                    int p = x.nextInt(100);
                    if (p <= this.getAgility()) {
                        System.out.println("fuite réussite (" + p + ") !");
                        flee = true;
                    } else {
                        System.out.println("fuite échouée ("+p+") !");
                        //foe.attack(this);
                    }
                    onFight = false;
                    //TODO à voir ?
                    break;
                default:
                    System.out.println("action impossible");
                    break;
            }
        }
        return flee;
    }

    public void inventoryManagement(){
        boolean intoInventory = true;
        int index;
        Scanner s = new Scanner(System.in);
        while (intoInventory){
            System.out.println(this.toString());
            System.out.println(this.inventory.toString());
            System.out.println("Possibilités: (e) Equiper - (d) Déséquiper - (l) Lacher - (f) Fermer");

            String action = s.nextLine();
            switch (action){
                case "e":
                    System.out.println("indiqué l'index de l'objet à équiper: ");
                    index = s.nextInt();
                    this.equip(index);
                    break;
                case "d":
                    System.out.println("indiqué l'index de l'objet à déséquiper: ");
                    index = s.nextInt();
                    this.unequip(index);
                    break;
                case "l":
                    System.out.println("indiqué l'index de l'objet (non équipé) à lacher: ");
                    index = s.nextInt();
                    this.dropObject(index);
                    break;
                case "f":
                    intoInventory = false;
                    break;
                default:
                    break;
            }
        }
    }

    public void increaseRoom(){
        this.roomThrough += 1;
    }



    public String getClassP() {
        return classP;
    }

    public int getSanity() {
        return stats.getSanity();
    }

    public int getRoomThrough() {
        return roomThrough;
    }




    public void creatPlayer(){
        Scanner s = new Scanner(System.in);
        System.out.println("choissisez un nom pour votre joueur :");
        String name = s.next();
        this.name = name;
        System.out.println("choissisez une classe pour votre joueur : 1) Mage  " +
                            "2)Guerrier  3)Paladin  4) Assassin");
        int classSelected = s.nextInt();
        switch (classSelected){
            case 1 :
                this.classP = "Mage";
                break;
            case 2:
                this.classP = "Guerrier";
                break;
            case 3:
                this.classP = "Paladin";
                break;
            case 4:
                this.classP = "Assassin";
                break;
        }
        SetStats(s);
    }

    public void SetStats(Scanner s){
        int remainingPt = 40;
        int selectedPt = 0;
        int str=0, spi=0, agi=0, def=0, san=0, heal=0;
        Stat primaryStat = new Strength(str);
        //TODO remplacer par un enum de classe avec stat de base renseignées ?
       switch (classP){
           case "Mage" :
               str = 30;
               spi = 70;
               agi = 30;
               def = 30;
               heal = 10;
               primaryStat = new Spirit(spi);
               break;
           case "Guerrier":
               str = 70;
               spi = 30;
               agi = 30;
               def = 30;
               heal = 12;
               primaryStat = new Strength(str);
               break;
           case "Paladin":
               str = 30;
               spi = 30;
               agi = 30;
               def = 70;
               heal = 15;
               primaryStat = new Strength(str);
               break;
           case "Assassin":
               str = 30;
               spi = 30;
               agi = 70;
               def = 30;
               heal = 10;
               primaryStat = new Strength(str);
               break;
       }
        san = 100;

        statsBase.setStats(new Stat[]{
                new Strength(str),
                new Spirit(spi),
                new Agility(agi),
                new Defense(def),
                new Sanity(san),
                new HealPoint(heal)
        });
        statsBase.setPrimaryStat(primaryStat);
        stats = statsBase;

        System.out.println( "vos stats : FOR:"+ getStrength() +" MEN: "+ getSpirit() +" AGI: "+ getAgility() +" DEF:"+ getDefense());
        System.out.println("Vous avez 40 points en reserve. " +
                "Voulez vous les utiliser ? (Ils seront perdus pour toujours si vous le faites pas)");
        System.out.println("O/N:");
        String check = s.next();
        check = check.toUpperCase();
        if (check.equals("O")) {
            remainingPt = addStrength(remainingPt,selectedPt,s);
            if(remainingPt > 0 ) {
                remainingPt = addSpirit(remainingPt, selectedPt, s);
                if(remainingPt >0 ) {
                    remainingPt = addAgility(remainingPt, selectedPt, s);
                    if(remainingPt > 0 ) {
                        remainingPt = addDefense(remainingPt, selectedPt, s);
                    }
                }
            }
        }
        stats = statsBase;
    }

    public int addStrength(int remainingPt, int selectedPt, Scanner s){
        System.out.println("voulez vous mettre des points en force? (O/N)");;
        if(s.next().toUpperCase().equals("O")) {
            System.out.println("Combien de points voulez vous mettre en force ? (points restants =" + remainingPt);
            selectedPt = s.nextInt();
            while (!addCheck(selectedPt, remainingPt)) {
                System.out.println("vous avez mis plus de points que vous possédez !! veuillez refaire avec un nombre correct");
                System.out.println("Combien de points voulez vous mettre en force ? (points restants =" + remainingPt);
                selectedPt = s.nextInt();
            }
            remainingPt -= selectedPt;
            statsBase.addStat(new Strength(selectedPt));
        }
        return remainingPt;
    }

    public int addSpirit(int remainingPt, int selectedPt, Scanner s){
        System.out.println("voulez vous mettre des points en mental? (O/N)");;
        if(s.next().toUpperCase().equals("O")) {
            System.out.println("Combien de points voulez vous mettre en mental ? (points restants =" + remainingPt);
            selectedPt = s.nextInt();
            while (!addCheck(selectedPt, remainingPt)) {
                System.out.println("vous avez mis plus de points que vous possédez !! veuillez refaire avec un nombre correct");
                System.out.println("Combien de points voulez vous mettre en mental ? (points restants =" + remainingPt);
                selectedPt = s.nextInt();
            }
            remainingPt -= selectedPt;
            statsBase.addStat(new Spirit(selectedPt));
        }
        return remainingPt;
    }

    public int addAgility(int remainingPt, int selectedPt, Scanner s){
        System.out.println("voulez vous mettre des points en agilité? (O/N)");;
        if(s.next().toUpperCase().equals("O")) {
            System.out.println("Combien de points voulez vous mettre en agilité ? (points restants =" + remainingPt);
            selectedPt = s.nextInt();
            while (!addCheck(selectedPt, remainingPt)) {
                System.out.println("vous avez mis plus de points que vous possédez !! veuillez refaire avec un nombre correct");
                System.out.println("Combien de points voulez vous mettre en agilité ? (points restants =" + remainingPt);
                selectedPt = s.nextInt();
            }
            remainingPt -= selectedPt;
            statsBase.addStat(new Agility(selectedPt));
        }
        return remainingPt;
    }

    public int addDefense(int remainingPt, int selectedPt, Scanner s){
        System.out.println("voulez vous mettre des points en constitution? (O/N)");;
        if(s.next().toUpperCase().equals("O")) {
            System.out.println("Combien de points voulez vous mettre en constitution ? (points restants =" + remainingPt);
            selectedPt = s.nextInt();
            while (!addCheck(selectedPt, remainingPt)) {
                System.out.println("vous avez mis plus de points que vous possédez !! veuillez refaire avec un nombre correct");
                System.out.println("Combien de points voulez vous mettre en constitution ? (points restants =" + remainingPt);
                selectedPt = s.nextInt();
            }
            remainingPt -= selectedPt;
            statsBase.addStat(new Defense(selectedPt));
        }
        return remainingPt;
    }

    public boolean addCheck(int selectedPt , int remainingPt){
        return selectedPt <= remainingPt;
    }

    @Override
    public String toString() {
        return name+", "+ classP +' '+ getRoomThrough() + ":\n" +
                "Mes stats sont : \n" +
                "Pv: "+ getHp() +"\n"+
                "FOR:"+ getStrength() +
                "\nMEN:"+ getSpirit() +
                "\nAGI:"+ getAgility() +
                "\nDEF:"+ getDefense();
    }

    public void dispStats(){
        System.out.println("je suis "+name+" , "+ classP +".");
        System.out.println("Mes stats sont : \n" +
                            "Pv: "+ getHp() +"\n"+
                            "FOR:"+ getStrength() +
                            "\nMEN:"+ getSpirit() +
                            "\nAGI:"+ getAgility() +
                            "\nDEF:"+ getDefense());
    }
}
