import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.ArrayList;


public class Bot extends  TelegramLongPollingBot {

     ArrayList<Location> locs = new ArrayList<>();
     Estoque estoque = new Estoque(locs);

    Location l = new Location();
    int loc = 0;
    int control = 0;



    public void sendMsg(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(text);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    public void onUpdateReceived(Update update) {
        if (control == 0  ||    control % 2 == 0) {
            Message message = update.getMessage();
            if (message != null && message.hasText()) {
                if (message.getText().equals("/commands")) {
                    sendMsg(message, "/location - Cadastra localização! \n" +
                            "\n" +
                            "/patrimony - Cadastra um bem! \n" +
                            "\n" +
                            "/category - Cadastra categoria de bem! \n" +
                            "\n" +
                            "/listlocation - Lista as localizações! \n" +
                            "\n" +
                            "/listcategory - Lista as categorias! \n" +
                            "\n" +
                            "/listbylocation - Lista os bens por uma localização! \n" +
                            "\n" +
                            "/searchcode - Busca um bem pelo código! \n" +
                            "\n" +
                            "/searchname - Busca um bem pelo nome! \n" +
                            "\n" +
                            "/searchdesc - Busca um bem pela descrição! \n" +
                            "\n" +
                            "/movelocation - Movimenta um bem entre as localizações! \n" +
                            "\n" +
                            "/report - Gera um relatório geral! \n");
                    opSystem();
                }


            }
        }

        if (control == 1 || control % 2 != 0) {
            if (loc != 0) {
                cadastrarLoc(update);
            }
            Message message = update.getMessage();
            if (message != null && message.hasText()) {
                switch (message.getText()) {
                    case "/location":
                        cadastrarLoc(update);

                }

            }
        }


    }

    private void cadastrarLoc(Update update) {

        Message m = update.getMessage();
        if (m != null && m.hasText()) {
            if(loc == 0) {
                sendMsg(m, "digite um  nome para a localização: ");
                String r = m.getText();
                l.setName(r);
                loc++;
            }else if(loc == 1) {
                sendMsg(m, "digite uma descrição para a sua localização: ");
                String a = m.getText();
                l.setDescription(a);
                loc++;
            }else if(loc == 2)
            {
                sendMsg(m, "adicionado localização com sucesso ,depois redigite o comando /comands");
                opSystem();
                loc = 0;
                estoque.locs.add(l);



            }

        }

    }





    private void opSystem() {
        control++;





//        boolean aux = true;
//        while (aux){
//            boolean check = checkIfNameOnL(locs, name);
//            if (check == false){
//                aux = false;
//                sendMsg(message,name);
//            }
//            else{
//                sendMsg(message,"Esse nome de localização ja existe");
//            }
//        }

    }

    public String getBotUsername() {

        return "WealthManagerBot";
    }

    public String getBotToken() {

        return "1001978429:AAHB97aihuye-wDwX09_yW_77jJ6kMPtmfY";
    }
}
