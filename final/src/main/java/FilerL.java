/**
 * @brief  Imported libraries.
 * */
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;

/**
 * @brief  FilerL class is responsible for structure the Json Location.
 */
public class FilerL implements Files{

    /**
     * @brief FilerL class attributes.
     */
    Estoque estoque = Estoque.getInstance();
    public JSONArray listL = new JSONArray();

    /**
     * @brief  Method chargeList is responsible for go through the ArrayLits of the Location class and call the method add.
     * @param //ArrayList<Location>.
     */
    public void chargeList(ArrayList<Location> location){
        for (int i = 0; i < location.size(); i++){
            add(location.get(i));
        }
    }

    /**
     * @brief  Method add is responsible for insert the Object ModelP in JSONArray list and call the method write.
     * @param //Object of the Location class.
     */
    public void add(Location location){
        JSONObject objectJsonL = new JSONObject();

        objectJsonL.put("LocationName",location.getName());
        objectJsonL.put("LocationDescription",location.getDescription());

        listL.add(objectJsonL);


        write();
    }

    /**
     * @brief  Method write is responsible for write the JSONArray listL in file bdLocation.json.
     */
    public  void write(){

        FileWriter writeFileL = null;

        System.out.println(listL.toJSONString());

        try{
            writeFileL = new FileWriter("C:\\Users\\andre\\Music\\PROJETO-LP2\\final\\src\\main\\bdLocation.json");
            writeFileL.write(listL.toJSONString());
            writeFileL.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }

    /**
     * @brief  Method charge is responsible for read objects from Json file and call the method initialCharge.
     */
    public void charge(){
        JSONParser parserL = new JSONParser();

        try(FileReader reader =  new FileReader("C:\\Users\\andre\\Music\\PROJETO-LP2\\final\\src\\main\\bdLocation.json")){
            Object obj = parserL.parse(reader);
            JSONArray list2 = (JSONArray) obj;
            list2.forEach(jsons -> initialCharge((JSONObject) jsons));

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }




    }

    /**
     * @brief  Method initialCharge is responsible for insert json objects in the Patrimony list used by the system.
     * @param //JSONObject,
     */
    public void initialCharge(JSONObject json){

        Location location = new Location((String) json.get("LocationName"),(String) json.get("LocationDescription"));
        estoque.locs.add(location);

    }
}
