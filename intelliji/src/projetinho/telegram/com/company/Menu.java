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
    public static HttpResponse sendMessage(Integer chatId, String text) throws UnirestException
    {
        return Unirest.post("https://api.telegram.org/" + "bot" + "1001978429:AAHB97aihuye-wDwX09_yW_77jJ6kMPtmfY" + "/sendMessage")
                .field("chat_id", chatId)
                .field("text", text)
                .asJson();
    }
    public static HttpResponse getUpdates(Integer offset) throws UnirestException
    {
        return Unirest.post( "https://api.telegram.org/" + "bot" + "1001978429:AAHB97aihuye-wDwX09_yW_77jJ6kMPtmfY" + "/getUpdates")
                .field("offset", offset)
                .asJson();
    }
    public static void  run() throws UnirestException
    {
        int last_update_id = 0; // controle das mensagens processadas
        HttpResponse response;
        while (true) {
            response = getUpdates(last_update_id++);
            if (response.getStatus() == 200) {
                JSONArray responses = response.getBody().get();
                if (responses.isNull(0)) {
                    continue;
                } else {
                    last_update_id = responses
                            .getJSONObject(responses.length() - 1)
                            .getInt("update_id") + 1;
                }
                JSONObject message = responses.getJSONObject(0).getJSONObject("message");
                int chat_id = message.getJSONObject("chat").getInt("id");
                sendMessage(chat_id, "OLÁ ESCOLHA UMA DAS OPÇÕES ABAIXO: \n");
                sendMessage(chat_id, "DIGITE /1 PARA CADASTRAR LOCALIZAÇÃO \n");

                sendMessage(chat_id, "DIGITE /2 PARA CADASTRAR CATEGORIA DE BEM \n");
                sendMessage(chat_id, "DIGITE /3 PARA BEM\n");
                sendMessage(chat_id, "DIGITE /4 PARA LISTAR LOCALIZAÇÃO \n");
                sendMessage(chat_id, "DIGITE /5 PARA LISTAR CATEGORIAS\n");
                sendMessage(chat_id, "DIGITE /6 PARA LISTAR BEM POR LOCALIZAÇÃO ESPECIFÍCA\n");
                sendMessage(chat_id, "DIGITE /7 PARA BUSCAR BEM POR CÓDIGO\n");
                sendMessage(chat_id, "digite /8 PARA BUSCAR BEM POR DESCRIÇÃO\n");
                sendMessage(chat_id, "DIGITE /9 PARA MOVER BEM DE UMA LOCALIZAÇÃO PARA OUTRA\n");
                sendMessage(chat_id, "DIGITE /10 PARA GERAR RELATORIO \n");
                sendMessage(chat_id, "DIGITE /11 PARA CARREGAR ARQUIVO PARA O BANCO DE DADOS\n");


            }
        }
    }


    @Override
    public void registerLocation() {

    }

    @Override
    public void registerCategory() {


    }

    @Override
    public void registerPatrimony() {

    }

    @Override
    public void listLocation()
    {

    }

    @Override
    public void listCategory()
        {
);
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