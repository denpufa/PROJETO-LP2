


import java.io.*;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Filer {

    public ArrayList<Model> listModels = new ArrayList<Model>();
    public JSONArray list = new JSONArray();

    public void add(Model model){
        JSONObject objectJson = new JSONObject();

        objectJson.put("bCode",model.getbCode());
        objectJson.put("bDescription",model.getbDesc());
        objectJson.put("bName",model.getbName());
        objectJson.put("lName",model.getlName());
        objectJson.put("lDescription",model.getlDesc());
        objectJson.put("cCode",model.getcCode());
        objectJson.put("cName",model.getcName());
        objectJson.put("cDescription",model.getcDesc());

        list.add(objectJson);

        white();

    }
    public  void white(){


        FileWriter writeFile = null;


        System.out.println(list.toJSONString());

        try{
            writeFile = new FileWriter("bd.json");
            writeFile.write(list.toJSONString());
            writeFile.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }

    public void charge(){
        JSONParser parser = new JSONParser();

        try(FileReader reader =  new FileReader("bd.json")){
            Object obj = parser.parse(reader);
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

    public void initialCharge(JSONObject json){


        Location location = new Location((String) json.get("lName"),(String) json.get("lDescription"));
        PatrimonyCategory patrimonyCategory = new PatrimonyCategory();
        patrimonyCategory.setCode((String) json.get("cCode"));
        patrimonyCategory.setName((String) json.get("cName"));
        patrimonyCategory.setDescription((String) json.get("cDescription"));
        Patrimony patrimony = new Patrimony();
        patrimony.setCode((String) json.get("bCode"));
        patrimony.setName((String) json.get("bName"));
        patrimony.setDescription((String) json.get("bDescription"));
        patrimony.setLocation(location);
        patrimony.setCategory(patrimonyCategory);

        Model m = new Model(patrimony,location,patrimonyCategory);
        listModels.add(m);

    }



}



