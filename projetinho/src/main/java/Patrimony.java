/**
 * @brief  Patrimony class is responsible for represent every Patrimony...
 */
public class Patrimony extends Name{

    /**
     * @brief Patrimony class attributes.
     */
    private String code;
    private Location loc;
    private PatrimonyCategory ca;


//    Patrimony(String code,  String name, String description, Location loc, PatrimonyCategory ca){
//        this.code = code;
//        this.name = name;
//        this.description = description;
//        this.loc = loc;
//        this.ca = ca;
//    }

    /**
     * @brief Setters.
     */
    public void setCode(String code){ this.code = code;}

    public void setLocation(Location loc){ this.loc = loc; }

    public void setCategory(PatrimonyCategory ca){ this.ca = ca; }

    /**
     * @brief Setters.
     */
    public String getCode(){ return this.code; }

    public Location getLocation(){ return this.loc; }

    public PatrimonyCategory getCategory(){ return this.ca; }
}