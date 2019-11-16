import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.ArrayList;


public class Bot extends  TelegramLongPollingBot {

    ArrayList<Patrimony> patri = new ArrayList<>();
    ArrayList<PatrimonyCategory> patriC = new ArrayList<>();
    ArrayList<Location> locs = new ArrayList<>();
    Estoque estoque = new Estoque(locs, patriC, patri);
    PatrimonyCategory pc = new PatrimonyCategory();
    Location l = new Location();
    Patrimony p = new Patrimony();
    int loc = 0;
    int control = 1;
    int intpa = 0;
    int intca = 0;


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
        if (control == 1 || control % 2 != 0 ) {
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

        if (control == 2 || control % 2 == 0) {
            if (intca != 0) {
                cadastrarCate(update);
            }
            if (loc != 0) {
                cadastrarLoc(update);
            }
            if (intpa != 0) {
                cadastrarPatri(update);
            }
            Message message = update.getMessage();
            if (message != null && message.hasText()) {
                switch (message.getText()) {
                    case "/location":
                        cadastrarLoc(update);
                        break;
                    case "/patrimony":
                        cadastrarPatri(update);
                        break;
                    case "/category":
                        cadastrarCate(update);
                        break;
                    case "/listlocation":
                        listarLoc(update);
                        break;

                }

            }
        }


    }
    private void listarLoc(Update update){
        Message m = new Message();
        
        for(int i = 1;i<estoque.locs.size();i++) {
            String s = estoque.locs.get(i).getName();
            String d = estoque.locs.get(i).getDescription();
            sendMsg(m, s + "  \n"
                    + d
            );
            sendMsg(m,"Agora digite /commadans para nva operação");

            opSystem();
        }
    }

    private void cadastrarCate(Update update) {
        Message m = update.getMessage();
        if (m != null && m.hasText()) {
            if (intca == 0) {
                sendMsg(m, "digite um nome para sua categoria de bem: ");
                String r = m.getText();
                pc.setName(r);
                intca++;

            } else if (intca == 1) {
                sendMsg(m, "digite uma descrição para sua categoria de bem: ");
                String r = m.getText();
                pc.setDescription(r);
                intca++;
            } else if (intca == 2) {
                sendMsg(m, "digte um código para o seu bem: ");
                String r = m.getText();
                pc.setCode(r);
                intca++;
            } else if (intca == 3) {
                sendMsg(m, "categoria de bem cadastrada com sucesso,digite,para outra operação digite /command");
                opSystem();
                estoque.patriC.add(pc);
                intca = 0;
                pc = new PatrimonyCategory();
            }


        }

    }


    private void cadastrarPatri(Update update ){
        Message m = update.getMessage();
        if (m != null && m.hasText()) {
                if(intpa == 0){
                    sendMsg(m,"digite um nome para o seu bem: ");
                    String r = m.getText();
                    p.setName(r);
                    intpa++;
                }else if(intpa == 1){
                    sendMsg(m,"digite uma descrição para o seu bem: ");
                    String r = m.getText();
                    p.setDescription(r);
                    intpa++;
                }else if(intpa == 2){
                    sendMsg(m,"Digite uma localizão para o seu bem: ");
                    String r = m.getText();
                    for(int i = 0;i<estoque.locs.size();i++){
                        if(estoque.locs.get(i).getName().equals(r)){
                            p.setLocation(estoque.locs.get(i));
                        }
                    }
                    intpa++;
                }else if(intpa == 3){
                    sendMsg(m,"digite uma categoria para o seu bem: ");
                    String r = m.getText();
                    for(int i = 0;i<estoque.patriC.size();i++){
                        if(estoque.patriC.get(i).equals(r));
                            p.setCategory(estoque.patriC.get(i));
                    }
                    intpa++;

                }else if(intpa == 4){
                    sendMsg(m,"digite um código para o seu bem: ");
                    String r = m.getText();
                    p.setCode(r);
                    intpa++;
                }else if(intpa == 5){
                    sendMsg(m,"cadastrado bem com sucesso,digite /commands para outra operação");
                    opSystem();
                    intpa = 0;
                    estoque.patri.add(p);
                    p = new Patrimony();
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
                l = new Location();



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
