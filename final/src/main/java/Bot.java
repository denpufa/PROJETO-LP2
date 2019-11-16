import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.ArrayList;


public class Bot extends  TelegramLongPollingBot {



    public void sendMsg(Message message, String text){
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

        Message message = update.getMessage();

        if (message != null && message.hasText()){
            switch (message.getText()){
                case "/commands":
                    sendMsg(message, "/location - Cadastra localização! \n" +
                            "\n"+
                            "/patrimony - Cadastra um bem! \n" +
                            "\n"+
                            "/category - Cadastra categoria de bem! \n" +
                            "\n"+
                            "/listlocation - Lista as localizações! \n" +
                            "\n"+
                            "/listcategory - Lista as categorias! \n" +
                            "\n"+
                            "/listbylocation - Lista os bens por uma localização! \n" +
                            "\n"+
                            "/searchcode - Busca um bem pelo código! \n" +
                            "\n"+
                            "/searchname - Busca um bem pelo nome! \n" +
                            "\n"+
                            "/searchdesc - Busca um bem pela descrição! \n" +
                            "\n"+
                            "/movelocation - Movimenta um bem entre as localizações! \n" +
                            "\n"+
                            "/report - Gera um relatório geral! \n");
                    break;
                case "/cl":
                    opSystem(update,message);
                    break;

            }
        }

    }

    private void opSystem(Update update, Message message) {
        sendMsg(message,"Digite o nome da localização:");
        Message ok = update.getMessage();
        String name = ok.getText();
        sendMsg(ok,name);
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
