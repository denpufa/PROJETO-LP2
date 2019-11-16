import java.util.ArrayList;

public class Estoque
{
 public ArrayList<Location> locs;

    public void add(String name, String desc){
        Location loc = new Location(name,desc);
        locs.add(loc);
    }
}