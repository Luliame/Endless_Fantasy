package characters;

import stats.Stat;
import usables.gear.Gear;
import usables.gear.GearTypeEnum;
import usables.UsableState;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {
    private final ArrayList<UsableState> listObject;
    private final HashMap<GearTypeEnum, Gear> equipped;

    public Inventory(){
        listObject = new ArrayList<>();
        equipped = new HashMap<>();
    }

    public void addToInventory(UsableState object){
        listObject.add(object);
    }

    public UsableState dropObject(UsableState object){
        UsableState o = null;
        if (object instanceof Gear){
            if (equipped.containsValue(object)){
                unequip(((Gear) object).getType());
            }
        }
        if (listObject.contains(object)){
            o = listObject.get(listObject.indexOf(object));
            listObject.remove(object);
        }
        return o;
    }

    public UsableState dropObject(int index){
        return this.dropObject(listObject.get(index));
    }

    public Stat[] equip(Gear object){
        Gear o =  (Gear)listObject.get(listObject.indexOf(object));
        listObject.remove(object);
        equipped.put(o.getType(), o);
        return o.getStatsList();
    }

    public Stat[] unequip(GearTypeEnum objectType){
        Gear o = equipped.remove(objectType);
        addToInventory(o);
        return o.getStatsList();
    }

    public HashMap<GearTypeEnum, Gear> getEquipped() {
        return equipped;
    }

    public ArrayList<UsableState> getListObject() {
        return listObject;
    }

    //vraiment utiles? ! => penser à delete
    public Gear getEquippedByType(GearTypeEnum objectType){
        return equipped.get(objectType);
    }
    public int getSizeList(){
        return listObject.size();
    }
    public int getSizeAll(){
        int i=0;
        i = i + listObject.size();
        i = i + equipped.size();
        return i;
    }

    @Override
    public String toString() {
        String list="";
        int i = 0;
        for (UsableState value: listObject){
            i++;
            list = list +i+" "+ value.getName();
        }
        return "Inventory{" +
                "listObject=" + list +
                ", equipped=" + equipped +
                '}';
    }
}
