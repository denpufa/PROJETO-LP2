/**
 * @brief  Imported libraries.
 * */
import java.util.ArrayList;

/**
 * @brief  Estoque class is responsible for store all system objects.
 */
public class Estoque
{
    /**
     * @brief Estoque class attributes.
     * */
    public ArrayList<Location> locs;
    public ArrayList<PatrimonyCategory> patriC;
    public ArrayList<Patrimony> patri;
    private static Estoque e;

    /**
     * @brief  Method Estoque is responsible for ...
     */
    private Estoque(){
        locs = new ArrayList<>();
        patriC = new ArrayList<>();
        patri = new ArrayList<>();

    }

    /**
     * @brief  Method getInstance is responsible for let the Estoque class be instantiated only once.
     */
    public static Estoque getInstance(){
        if(e == null){
            e = new Estoque();
        }
        return e;
    }

}