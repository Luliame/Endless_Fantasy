package characters;

import stats.*;
import usables.UsableState;
import usables.gear.Gear;
import usables.gear.GearTypeEnum;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;

public class Character {
    protected String name ;

    protected StatHandler statsBase;
    protected StatHandler stats;

    protected Inventory inventory;

    public Character(){
        this.inventory = new Inventory();
        this.statsBase = new StatHandler();
        this.stats = statsBase;
    }

    public Character(Stat[] stats){
        this();
        this.statsBase = new StatHandler(stats);
        this.stats = statsBase;
    }
    public Character(String name){
        this();
        this.name = name;
    }
    /*public Character(String name, Stat[] stats){
        this(stats);
        this.name = name;
    }*/

    public void take(UsableState object){
        inventory.addToInventory(object);
        System.out.println(inventory.toString());
    }

    public UsableState dropObject(UsableState object){
        return inventory.dropObject(object);
    }

    public UsableState dropObject(int index){
        UsableState object = null;
        try {
            object = this.inventory.getListObject().get(index);
        } catch (Exception e){
            System.out.println("Impossible de lacher cet objet !");
        }
        if (object != null)
            return this.dropObject(object);
        return null;
    }

    public void equip(Gear object){
        GearTypeEnum type = object.getType();
        if (this.inventory.getEquipped().containsKey(type)){
            this.unequip(type);
        }
        this.stats.addStat(this.inventory.equip(object));
        System.out.println(inventory.toString());
    }

    public void equip(int index){
        UsableState object = null;
        try {
            object = this.inventory.getListObject().get(index);
        } catch (Exception e){
            System.out.println("impossible d'équiper cet objet");
        }
        if (object instanceof Gear)
            this.equip((Gear) object);
    }

    public void unequip(GearTypeEnum object){
        this.stats.subtractStat(this.inventory.unequip(object));//
        System.out.println(inventory.toString());
    }

    public void unequip(int index){
        GearTypeEnum object = null;
        HashMap<GearTypeEnum, Gear> equipped = this.inventory.getEquipped();
        try {
            object = (GearTypeEnum) equipped.keySet().toArray()[index];
            System.out.println("### type de l'objet à déséquiper :" + object);
        } catch (Exception e){
            System.out.println("oppération impossible");
        }
        if (object != null)
            unequip(object);
    }

    public void unequip(Gear object){
        this.unequip(object.getType());
    }

    public void unequipAll(){
        HashMap<GearTypeEnum, Gear> equipped = inventory.getEquipped();
        GearTypeEnum[] equippedList = (GearTypeEnum[]) equipped.keySet().toArray();
        for (int i = 0; i <= equippedList.length; i++){
            unequip(equippedList[i]);
        }
    }

    public ArrayList<UsableState> dropAll(){
        ArrayList<UsableState> dropped = new ArrayList<>();
        this.unequipAll();
        for (int i = 0; i <= inventory.getSizeList(); i++){
            dropped.add(inventory.dropObject(i));
        }
        return dropped;
    }

    public void speak(String message){
        System.out.println(this.name+": "+message);
    }

    public boolean attack(Character foe){
        System.out.println("attaque");
        Stat primaryStat;
        int damages;
        primaryStat = this.stats.getPrimaryStat();//get primary stat
        if (primaryStat instanceof Spirit){
            System.out.println("spirit");
            damages = this.getSpirit() - foe.getSpirit();
        } else {
            System.out.println("strength");
            damages = this.getStrength() - foe.getDefense();
        }
        System.out.println(damages);
        foe.stats.subtractStat(new HealPoint(damages));
        return false;
        //TODO version archaique, peut-être améliorer par la suite
    }

    public int getStrength() {
        //return strength;
        return stats.getStrength();
    }
    public int getAgility() {
        //return agility;
        return stats.getAgility();
    }
    public int getDefense() {
        //return defense;
        return stats.getDefense();
    }
    public int getHp() {
        //return hp;
        return stats.getHp();
    }
    public int getSpirit() {
        //return spirit;
        return stats.getSpirit();
    }
    public String getName() {
        return name;
    }
    public Inventory getInventory() {
        return inventory;
    }
    public  StatHandler getStats(){
        return stats;
    }
}
