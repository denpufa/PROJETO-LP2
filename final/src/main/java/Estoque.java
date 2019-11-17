import java.util.ArrayList;

public class Estoque
{
 public ArrayList<Location> locs;
 public ArrayList<PatrimonyCategory> patriC;
 public ArrayList<Patrimony> patri;
 private static Estoque e;


 private Estoque(){
     locs = new ArrayList<>();
     patriC = new ArrayList<>();
     patri = new ArrayList<>();

 }
 public static Estoque getInstance(){
     if(e == null){
         e = new Estoque();
     }
     return e;
 }


}