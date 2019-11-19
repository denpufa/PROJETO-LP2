/**
 * @brief  Imported libraries.
 * */
import java.io.*;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @brief  FilerP class is responsible for structure the Json Patrimony.
 */
public class FilerP implements Files{

    /**
     * @brief FilerP class attributes.
     */
    Estoque estoque = Estoque.getInstance();
    public JSONArray list = new JSONArray();

    /**
     * @brief  Method chargeList is responsible for go through the ArrayLits of the Patrimony class and call the method add.
     * @param //ArrayList<Patrimony>.
     */
    public void chargeList(ArrayList<Patrimony> patrimony ){
        for (int i = 0; i< patrimony.size(); i++){
            add(patrimony.get(i));
        }
    }

    /**
     * @brief  Method add is responsible for insert the Object ModelP in JSONArray list and call the method write.
     * @param //Object of the Patrimony class.
     */
    public void add(Patrimony patrimony){

        ModelP model = new ModelP(patrimony);

        JSONObject objectJsonP = new JSONObject();

        objectJsonP.put("PatrimonyCode",model.getbCode());
        objectJsonP.put("PatrimonyDescription",model.getbDesc());
        objectJsonP.put("PatrimonyName",model.getbName());
        objectJsonP.put("LocationName",model.getlName());
        objectJsonP.put("LocationDescription",model.getlDesc());
        objectJsonP.put("CategoryCode",model.getcCode());
        objectJsonP.put("CategoryName",model.getcName());
        objectJsonP.put("CategoryDescription",model.getcDesc());

        list.add(objectJsonP);

        write();

    }

    /**
     * @brief  Method write is responsible for write the JSONArray list in file bdPatrimony.json.
     */
    public  void write(){
        FileWriter writeFile = null;

        System.out.println(list.toJSONString());

        try{
            writeFile = new FileWriter("bdPatrimony.json");
            writeFile.write(list.toJSONString());
            writeFile.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }

    /**
     * @brief  Method charge is responsible for read objects from Json file and call the method initialCharge.
     */
    public void charge(){

        JSONParser parserP = new JSONParser();

        try(FileReader reader =  new FileReader("bdPatrimony.json")){
            Object obj = parserP.parse(reader);
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
     * @param
     */
    public void initialCharge(JSONObject json){

        Location location = new Location((String) json.get("LocationName"),(String) json.get("LocationDescription"));
        PatrimonyCategory patrimonyCategory = new PatrimonyCategory();
        patrimonyCategory.setCode((String) json.get("CategoryCode"));
        patrimonyCategory.setName((String) json.get("CategoryName"));
        patrimonyCategory.setDescription((String) json.get("CategoryDescription"));
        Patrimony patrimony = new Patrimony();
        patrimony.setCode((String) json.get("PatrimonyCode"));
        patrimony.setName((String) json.get("PatrimonyName"));
        patrimony.setDescription((String) json.get("PatrimonyDescription"));
        patrimony.setLocation(location);
        patrimony.setCategory(patrimonyCategory);

        estoque.patri.add(patrimony);

    }



}



