package characters;

import stats.*;

import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

public enum RaceEnum {
    GOBLIN("Goblin",
            new Stat[]{
                    new Strength(10),
                    new Spirit(10),
                    new Agility(40),
                    new Defense(20),
                    new HealPoint(40)
            }),
    KOBOLD("Kobold",
            new Stat[]{
                    new Strength(10),
                    new Spirit(40),
                    new Agility(15),
                    new Defense(20),
                    new HealPoint(30)
            }, new Spirit(40)),
    ORK("Ork",
            new Stat[]{
                    new Strength(50),
                    new Spirit(5),
                    new Agility(15),
                    new Defense(40),
                    new HealPoint(100)
            }),
    CHICKEN("Chicken",
                    new Stat[]{
        new Strength(100),
                new Spirit(0),
                new Agility(1),
                new Defense(1),
                new HealPoint(1)
    });

    final String name;
    final Stat[] stats;
    Stat primaryStat;

    private static final List<RaceEnum> listRace = List.of(values());
    private static final int sizeListRace = listRace.size();
    private static final Random x = new Random();

    RaceEnum(String name, Stat[] stats){
        Locale locale = new Locale("fr");
        ResourceBundle bundle = ResourceBundle.getBundle("values.raceName", locale);
        this.name = name;
        this.stats = stats;
    }
    RaceEnum(String name, Stat[] stats, Stat primaryStat){
        this(name, stats);
        this.primaryStat = primaryStat;
    }

    public static RaceEnum randomRace(){
        return listRace.get(x.nextInt(sizeListRace));
    }

    public String getName() {
        return name;
    }
}