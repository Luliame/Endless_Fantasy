package stats;

public abstract class Stat {
    int value;

    public Stat(){
        this.value = 0;
    }

    public Stat(int value){
        this();
        if (value >= 0)
            this.value = value;
    }

    public void setValue(int value) {
        int v = 0;
        if (value >= 0)
            v = value;
        this.value = v;
    }

    public int getValue() {
        return value;
    }
}
