package usables.gear;

import stats.*;
import usables.UsableState;

public class Gear implements UsableState {
    private String name;
    private GearTypeEnum type;
    private StatHandler stats;
    /*private Stat[] stats;
    private int strength;
    private int spirit;
    private int agility;
    private int defense;
    private int hp;*/

    //private GearTypeEnum type;
    //private Stat[] stats;//stat 1 by 1
    //TODO

    public Gear(){//TODO gear() => random directement dedans
        GearEnum gear = GearEnum.randomGear();
        this.name = gear.name;
        this.type = gear.type;
        this.stats = new StatHandler(gear.stats);
        /*this.stats = gear.stats;
        for (Stat stat : stats) {
            if (stat instanceof Strength)
                this.strength = stat.getValue();
            if (stat instanceof Spirit)
                this.spirit = stat.getValue();
            if (stat instanceof Agility)
                this.agility = stat.getValue();
            if (stat instanceof Defense)
                this.defense = stat.getValue();
            if (stat instanceof HealPoint)
                this.hp = stat.getValue();
        }*/
    }

    @Override
    public String getName() {
        return name;
    }
    public GearTypeEnum getType() {
        return type;
    }
    public Stat[] getStatsList() {
        return stats.getStat();
    }
    public StatHandler getStats() {
        return stats;
    }

    //TODO virer tout ça et tout passer par Stat[] ou StatHandler direct ?
    /*public int getStrength() {
        return stats.getStrength();
    }
    public int getSpirit() {
        return stats.getSpirit();
    }
    public int getAgility() {
        return stats.getAgility();
    }
    public int getDefense() {
        return stats.getDefense();
    }
    public int getHp() {
        return stats.getHp();
    }*/
}
