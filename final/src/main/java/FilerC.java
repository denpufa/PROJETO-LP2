/**
 * @brief  Imported libraries.
 * */
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @brief  FilerC class is responsible for structure the Json Location.
 */
public class FilerC implements Files{

    /**
     * @brief FilerC class attributes.
     */
    public Estoque estoque = Estoque.getInstance();
    public JSONArray listC = new JSONArray();

    /**
     * @brief  Method chargeList is responsible for go through the ArrayLits of the Location class and call the method add.
     * @param //ArrayList<PatrimonyCategory>.
     */
    public void chargeList(ArrayList<PatrimonyCategory> patrimonyCategory){
        for (int i = 0; i< patrimonyCategory.size(); i++){
            add(patrimonyCategory.get(i));
        }
    }

    /**
     * @brief  Method add is responsible for insert the Object ModelP in JSONArray list and call the method write.
     * @param //Object of the PatrimonyCategory class.
     */
    public void add(PatrimonyCategory model){

        JSONObject objectJsonC = new JSONObject();

        objectJsonC.put("CategoryCode",model.getCode());
        objectJsonC.put("CategoryName",model.getName());
        objectJsonC.put("CategoryDescription",model.getDescription());

        listC.add(objectJsonC);

        write();

    }

    /**
     * @brief  Method write is responsible for write the JSONArray listL in file bdPatrimony.json.
     */
    public  void write(){

        FileWriter writeFileC = null;

        System.out.println(listC.toJSONString());

        try{
            writeFileC = new FileWriter("bdCategory.json");
            writeFileC.write(listC.toJSONString());
            writeFileC.close();
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

        try(FileReader reader =  new FileReader("bdCategory.json")){
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
     * @brief  Method initialCharge is responsible for insert json objects in the Location list used by the system.
     * @param //JSONObject,
     */
    public void initialCharge(JSONObject json){

        PatrimonyCategory patrimonyCategory = new PatrimonyCategory();
        patrimonyCategory.setCode((String) json.get("CategoryCode"));
        patrimonyCategory.setName((String) json.get("CategoryName"));
        patrimonyCategory.setDescription((String) json.get("CategoryDescription"));

        estoque.patriC.add(patrimonyCategory);

    }
}
