package movement;

public enum DirectionEnum {
    HAUT("haut","bas","y",1),
    BAS("bas","haut","y",-1),
    GAUCHE("gauche","droite","x",-1),
    DROITE("droite","gauche","x",1);

    private final String val;
    private final String opposite;
    private final String axe;
    private final int coordinate;

    DirectionEnum(String val, String opposite, String axe, int coordinate){
        this.val = val;
        this.opposite = opposite;
        this.axe = axe;
        this.coordinate = coordinate;
    }

    public DirectionEnum getOppositeEnum() {
        return search(opposite);
    }
    public String getAxe() { return axe; }

    public int getCoordinateX() {
        if (this.axe.equals("x"))
            return coordinate;
        return 0;
    }

    public int getCoordinateY() {
        if (this.axe.equals("y"))
            return coordinate;
        return 0;
    }

    public static DirectionEnum search(String val){
        for(DirectionEnum v : values()){
            if( v.val.equals(val)){
                return v;
            }
        }
        return null;
    }
}
