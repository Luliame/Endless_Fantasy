package usables.gear;

import stats.*;

import java.util.List;
import java.util.Random;

public enum GearEnum {
    WOOD_SWORD("WoodSword",
            GearTypeEnum.WEAPON,
            new Stat[]{
                new Strength(10)
            }),
    ADVENTURER_SWORD("AdventurerSword",
            GearTypeEnum.WEAPON,
            new Stat[]{
                new Strength(15),
                new Agility(5)
            }),
    MASTER_SWORD("MasterSword",
            GearTypeEnum.WEAPON,
            new Stat[]{
                new Strength(30),
                new Agility(10)
            }),
    DAGGER1("Dagger1",
            GearTypeEnum.WEAPON,
            new Stat[]{
                new Strength(5),
                new Agility(10)
            }),
    WAND_1("Wand1",
            GearTypeEnum.WEAPON,
            new Stat[]{
                new Spirit(5)
            }),
    WAND_2("Wand2",
            GearTypeEnum.WEAPON,
            new Stat[]{
                new Spirit(15),
                new Agility(5)
            }),
    WOOD_SHIELD("WoodShield",
            GearTypeEnum.SHIELD,
            new Stat[]{
                new Defense(5),
                new Agility(-2)
            }),
    IRON_SHIELD("IronShield",
            GearTypeEnum.SHIELD,
            new Stat[]{
                new Defense(20)
            }),
    LEATHER_ARMOR("LeatherArmor",
            GearTypeEnum.ARMOR,
            new Stat[]{
                new Defense(5)
            }),
    CHAIN_MAIL_ARMOR("ChainMail",
            GearTypeEnum.ARMOR,
            new Stat[]{
                new Defense(20)
            }),
    PLATE_ARMOR("PlateArmor",
            GearTypeEnum.ARMOR,
            new Stat[]{
                new Defense(50),
                new Agility(-15)
            });

    String name;
    Stat[] stats;
    GearTypeEnum type;

    private static final List<GearEnum> listGear = List.of(values());
    private static final int sizeListGear = listGear.size();
    private static final Random x = new Random();

    //GearEnum(){}
    GearEnum(String name, GearTypeEnum type, Stat[] stats) {
        this.name = name;
        this.stats = stats;
        this.type = type;
    }

    public static GearEnum randomGear(){
        return listGear.get(x.nextInt(sizeListGear));
    }
}
