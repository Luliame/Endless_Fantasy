import characters.Player;

import java.util.ArrayList;

public class Graveyard {
    private ArrayList<Player> corpse = new ArrayList<Player>();

    public void addCorpse(Player p){
        corpse.add(p);
    }

    public void dispGraveyard(){
        //String out = "";
        for (int i=0; i<corpse.size(); i++){
            //out = out+corpse.get(0).name+"\n"+corpse.get(0).dispStats(); //attention dispStats() fonction d'aff
            System.out.println(corpse.get(i).getName()+": "+corpse.get(i).getRoomThrough()+"\n");
            corpse.get(i).dispStats();//getstats /!\
        }
    }
}