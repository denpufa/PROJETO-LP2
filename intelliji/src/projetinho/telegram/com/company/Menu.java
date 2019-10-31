package projetinho.telegram.com.company;

import java.util.ArrayList;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;

public class Menu implements SystemNeeds
{
    /**
     * @brief Patrimony class attributes.
     */
    private ArrayList<Location> locs;
    private ArrayList<PatrimonyCategory> category;
    private ArrayList<Patrimony> patrimonies;

    /**
     * @brief Mandatory methods of SystemNeeds
     */


//Metodos relacionados ao bot!!
    public HttpResponse sendMessage(Integer chatId, String text) throws UnirestException
    {
        return Unirest.post("https://api.telegram.org/" + "bot" + "1001978429:AAHB97aihuye-wDwX09_yW_77jJ6kMPtmfY" + "/sendMessage")
                .field("chat_id", chatId)
                .field("text", text)
                .asJson();
    }
    public HttpResponse getUpdates(Integer offset) throws UnirestException
    {
        return Unirest.post( "https://api.telegram.org/" + "bot" + "1001978429:AAHB97aihuye-wDwX09_yW_77jJ6kMPtmfY" + "/getUpdates")
                .field("offset", offset)
                .asJson();
    }
    public void run() throws UnirestException {
        int last_update_id = 0; // controle das mensagens processadas
        HttpResponse response;
        while (true) {
            response = getUpdates(last_update_id++);
            if (response.getStatus() == 200) {
                JSONArray responses = response.getBody().getObject().getJSONArray("result");
                if (responses.isNull(0)) {
                    continue;
                } else {
                    last_update_id = responses
                            .getJSONObject(responses.length() - 1)
                            .getInt("update_id") + 1;
                }
                JSONObject message = responses.getJSONObject(i)
                        .getJSONObject("message");
                int chat_id = message
                        .getJSONObject("chat")
                        .getInt("id");
                sendMessage(chat_id, "OLÁ ESCOLHA UMA DAS OPÇÕES ABAIXO: ");
                sendMessage()

                for (int i = 0; i < responses.length(); i++) {
                    JSONObject message = responses
                            .getJSONObject(i)
                            .getJSONObject("message");
                    int chat_id = message
                            .getJSONObject("chat")
                            .getInt("id");
                    String usuario = message
                            .getJSONObject("chat")
                            .getString("username");
                    String texto = message
                            .getString("text");

                    sendMessage(chat_id, textoInvertido);


    @Override
    public void registerLocation() {
        Location obj = new Location();
        System.out.println("digite o nome da localizacao: \n");
        String aux = Entrada.next();
        obj.setName(aux);
        System.out.println("digite uma breve descrição para a localização: \n");
        aux = Entrada.next();
        obj.setDescription(aux);
        locs.add(obj);
        return;
    }

    @Override
    public void registerCategory() {

        int code;
        String name;
        String description;

        System.out.println("digite o nome da Categoria: \n");
        name = Entrada.next();

        System.out.println("Digite uma breve descricao da categoria: \n");
        description = Entrada.next();

        System.out.println("digite um codigo para a categoria: \n");
        code = Entrada.nextInt();

        PatrimonyCategory ca = new PatrimonyCategory(code, name, description);

        category.add(ca);

        return;
    }

    @Override
    public void registerPatrimony() {

        int code;
        String name;
        String description;
        String category;
        String location;

        System.out.println("digite um nome para o seu bem: \n");
        name = Entrada.next();

        System.out.println("digite uma breve descricao para o seu bem: \n");
        description = Entrada.next();


        System.out.println("digite um código para o seu bem: \n");
        code = Entrada.nextInt();

        System.out.println("digite  o nome de uma  categoria para seu bem: ");
        category = Entrada.next();



//        for(int i = 0;i< category.size();i++)
//        {
//            if(category.get(i).getNome() == category)
//            {
//                b.setCategoria(catego.get(i));
//                break;
//            }
//        }

        System.out.println("Digite  um nome de uma localizacão para o seu bem: \n");
         location = Entrada.next();

//        for(int i = 0;i<locs.size();i++)
//        {
//            if(locs.get(i).getNome() == aux)
//            {
//                b.setLocalizacao(locs.get(i));
//                break;
//            }
//        }

        Patrimony b = new Patrimony(code, );
        patrimonies.add(b);
        return;
    }

    @Override
    public void listLocation()
    {
        for(int i = 0;i<locs.size();i++)
        {
            System.out.println("-----localizações listadas abaixo-----\n");
            System.out.println(i + locs.get(i).getName() + "\n");
        }
        System.out.println("P");
    }

    @Override
    public void listCategory() {

    }

    @Override
    public void listPatrimonyByLocation() {

    }

    @Override
    public void searchPatrimonyByCode() {

    }

    @Override
    public void searchPatrimonyByName() {

    }

    @Override
    public void searchPatrimonyByDescription() {

    }

    @Override
    public void movePatrimony() {

    }

    @Override
    public void generateReport() {

    }
}


}