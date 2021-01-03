package characters;

import stats.*;
import usables.UsableState;

import java.util.ArrayList;

public class Monster extends Character {
    private final RaceEnum race;

    public Monster(){
        race = RaceEnum.randomRace();
        name = race.getName();
        stats = new StatHandler(race.stats);
        if (race.primaryStat != null)
            stats.setPrimaryStat(race.primaryStat);
        statsBase = stats;
    }
    public Monster(String name){
        this();
        this.name = name;
    }
    public Monster(RaceEnum race){
        this.race = race;
        name = race.getName();
        stats = new StatHandler(race.stats);
        if (race.primaryStat != null)
            stats.setPrimaryStat(race.primaryStat);
        statsBase = stats;
    }

    public ArrayList<UsableState> die(){
        return this.dropAll();
        //TODO booleen alive => false ?
    }

    @Override
    public String toString() {
        return "Monstres:\nrace="+ getRace() +
                " force="+ getStrength() +
                " mental="+ getSpirit() +
                " agilité="+ getAgility() +
                " defense="+ getDefense() +
                " pv="+ getHp();
    }

    public void dispMonster(){
        System.out.println("Monstres:\nrace="+ getRace() +
                " force="+ getStrength() +
                " mental="+ getSpirit() +
                " agilité="+ getAgility() +
                " defense="+ getDefense() +
                " pv="+ getHp());
    }

    public String getRace() {
        return race.toString();
    }
}
