package stats;

import java.util.Arrays;

public class StatHandler {
    private Stat[] stats;//utile ?
    private int strength;
    private int spirit;
    private int agility;
    private int defense;
    private int sanity;
    private int hp;
    private Stat primaryStat;
    //private Stat primaryStat;

    public StatHandler(){
        this.stats = new Stat[]{};
        this.strength = 0;
        this.spirit = 0;
        this.agility = 0;
        this.defense = 0;
        this.sanity = 100;
        this.hp = 1;
        this.primaryStat = new Strength(this.strength);
        //this.primaryStat = new Strength(this.getStrength());
    }

    public StatHandler(Stat[] stats){
        this.stats = stats;
        for (Stat stat : stats) {
            if (stat instanceof Strength)
                this.strength = stat.getValue();
            if (stat instanceof Spirit)
                this.spirit = stat.getValue();
            if (stat instanceof Agility)
                this.agility = stat.getValue();
            if (stat instanceof Defense)
                this.defense = stat.getValue();
            if (stat instanceof Sanity)
                this.sanity = stat.getValue();
            if (stat instanceof HealPoint)
                this.hp = stat.getValue();
        }
        this.primaryStat = new Strength(this.strength);
    }

    public void refreshPrimary(){
        if (this.primaryStat instanceof Strength){
            this.primaryStat = new Strength(this.strength);
        }
        if (this.primaryStat instanceof Spirit){
            this.primaryStat = new Spirit(this.spirit);
        }
        if (this.primaryStat instanceof Agility){
            this.primaryStat = new Agility(this.agility);
        }
        if (this.primaryStat instanceof Defense){
            this.primaryStat = new Defense(this.defense);
        }
        if (this.primaryStat instanceof Sanity){
            this.primaryStat = new Sanity(this.sanity);
        }
        if (this.primaryStat instanceof HealPoint){
            this.primaryStat = new HealPoint(this.hp);
        }
    }

    public void addStat(Stat[] stats){
        for (Stat stat : stats) {
            if (stat instanceof Strength) {
                this.strength += stat.getValue();
            }
            if (stat instanceof Spirit) {
                this.spirit += stat.getValue();
            }
            if (stat instanceof Agility) {
                this.agility += stat.getValue();
            }
            if (stat instanceof Defense) {
                this.defense += stat.getValue();
            }
            if (stat instanceof Sanity) {
                this.sanity += stat.getValue();
            }
            if (stat instanceof HealPoint) {
                this.hp += stat.getValue();
            }
        }
        this.refreshPrimary();
    }

    public void addStat(Stat stat){
        this.addStat(new Stat[]{stat});
    }
    public void subtractStat(Stat[] stats){
        for (Stat stat : stats) {
            if (stat instanceof Strength) {
                this.strength -= stat.getValue();
            }
            if (stat instanceof Spirit) {
                this.spirit -= stat.getValue();
            }
            if (stat instanceof Agility) {
                this.agility -= stat.getValue();
            }
            if (stat instanceof Defense) {
                this.defense -= stat.getValue();
            }
            if (stat instanceof Sanity) {
                this.sanity -= stat.getValue();
            }
            if (stat instanceof HealPoint) {
                this.hp -= stat.getValue();
            }
        }
        this.refreshPrimary();
    }

    public void subtractStat(Stat stat){
        this.subtractStat(new Stat[]{stat});
    }

    public void setStats(Stat[] stats){
        this.stats = stats;
        for (Stat stat : stats) {
            if (stat instanceof Strength) {
                this.strength = stat.getValue();
            }
            if (stat instanceof Spirit) {
                this.spirit = stat.getValue();
            }
            if (stat instanceof Agility) {
                this.agility = stat.getValue();
            }
            if (stat instanceof Defense) {
                this.defense = stat.getValue();
            }
            if (stat instanceof Sanity) {
                this.sanity = stat.getValue();
            }
            if (stat instanceof HealPoint) {
                this.hp = stat.getValue();
            }
        }
        this.refreshPrimary();
    }

    @Override
    public String toString() {
        return "StatHandler{" +
                "stats=" + Arrays.toString(stats) +
                ", strength=" + strength +
                ", spirit=" + spirit +
                ", agility=" + agility +
                ", defense=" + defense +
                ", sanity=" + sanity +
                ", hp=" + hp +
                ", primaryStat=" + primaryStat +
                '}';
    }

    public void setPrimaryStat(Stat primaryStat) {
        this.primaryStat = primaryStat;
    }

    public Stat[] getStat(){
        return stats;
    }
    public Stat getPrimaryStat() {
        return primaryStat;
    }
    public int getStrength(){
        return this.strength;
    }
    public int getSpirit(){
        return this.spirit;
    }
    public int getAgility(){
        return this.agility;
    }
    public int getDefense(){
        return this.defense;
    }
    public int getSanity(){
        return this.sanity;
    }
    public int getHp(){
        return this.hp;
    }
}
