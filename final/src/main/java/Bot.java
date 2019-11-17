import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.ArrayList;


public class Bot extends  TelegramLongPollingBot {

    //inicializando objetos a serem utilizados pelo estoque e pelo  o sistema em geral.

    Estoque estoque = Estoque.getInstance();
    PatrimonyCategory pc = new PatrimonyCategory();
    Location l = new Location();
    Patrimony p = new Patrimony();

    //variaveis para controlar a máquina de estado!!
    int loc = 0;
    int control = 1;
    int intpa = 0;
    int intca = 0;
    int intlocb = 0;
    int intpro = 0;
    int intpron = 0;
    int intprod = 0;
    int intm= 0;
    boolean  aux = true;
    boolean auxtwo = true;
    boolean auxthree = true;

    //variaves auxilar na movimentacao de localização
    String help;
    Location lo;
    boolean ent = true;






    //método que envia mesangens ao usuario!!
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
    //funcao que recebe dados do telegram a cada momento!!
    public void onUpdateReceived(Update update) {
        //primeira opção de controle ela é mostra o menu para o usuario e espera um comando!!
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
        //seguda opção de controle caso uma operação seja inicida ela entrada direto para continua-la ,caso não espera um comando no switch!!
        if (control == 2 || control % 2 == 0) {
            if(intm != 0){
                moverL(update);
            }
            if(intprod != 0){
                procurabyD(update);
            }
            if(intpron != 0){
                procuraByN(update);
            }
            if(intpro != 0 ){
                procuraByC(update);
            }
            if(intlocb != 0){
                listarLocbyP(update);
            }
            if (intca != 0) {
                cadastrarCate(update);
            }else if (loc != 0) {
                cadastrarLoc(update);
            }else if (intpa != 0) {
                cadastrarPatri(update);
            }else
            {
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
                        case "/listcategory":
                            listarCat(update);
                            break;
                        case "/listbylocation":
                            listarLocbyP(update);
                            break;
                        case "/searchcode":
                            procuraByC(update);
                            break;
                        case "/searchname":
                            procuraByN(update);
                            break;
                        case "/searchdesc":
                            procurabyD(update);
                            break;
                        case "/movelocation":
                            moverL(update);
                            break;
                        case "/report":
                             arquivos(update);
                    }
                }

            }
        }


    }
    private void arquivos(Update update){
        
    }
    private void moverL(Update update){
        Message mes = update.getMessage();
        if(mes != null &&  mes.hasText()){
            if(intm == 0){
                sendMsg(mes,"digte o código do bem: ");
                String r = mes.getText();
                intm++;
            }else if(intm == 1){
                sendMsg(mes,"digite s");
                String r = mes.getText();
                intm++;
                help = r;
            }else if(intm == 2){
                sendMsg(mes,"digite o nome da nova localização: ");
                String r = mes.getText();
                intm++;

            }else if(intm == 3){
                String r = mes.getText();
                for(Location y:estoque.locs){
                    if(y.getName().equals(help)){
                        lo = y;
                    }
                }
                if(lo!=null){
                    for(Patrimony p: estoque.patri){
                        if(p.getCode().equals(r)){
                            p.setLocation(lo);
                            ent = false;
                        }
                    }
                    intm++;
                    if(ent){
                        sendMsg(mes,"Bem não encontrado!");

                    }
                }else{
                    sendMsg(mes,"localização não encontrada!");
                    intm++;

                }
                sendMsg(mes,"digite /commmands para outra operação");
                opSystem();
                intm = 0;

            }else {
                sendMsg(mes,"digite /commmands para outra operação");
                opSystem();
                intm = 0;

            }
        }




    }
    private void procurabyD(Update update){
        Message mes = update.getMessage();
        if(mes != null &&  mes.hasText()){
            if(intprod == 0){
                sendMsg(mes,"digite a descrição do bem: ");
                String r = mes.getText();
                intprod++;
            }else if(intprod == 1){
                sendMsg(mes,"digite s");
                String r = mes.getText();
                for(Patrimony p: estoque.patri){
                    if(p.getDescription().equals(r)){
                        sendMsg(mes,"bem encotrado " + " Localização: " + p.getLocation().getName());
                        auxthree  = false;
                        opSystem();
                        intprod = 0;

                    }
                }
                intprod++;
            }else if(auxthree){
                sendMsg(mes,"bem não encontrado!");
                sendMsg(mes,"digite /commands para outra operação");
                opSystem();
                intprod = 0;

            }

        }
    }
    private void procuraByN(Update update){
        Message mes = update.getMessage();
        if(mes != null && mes.hasText()){
            if(intpron == 0){
                sendMsg(mes,"digite nome do bem: ");
                String r = mes.getText();
                intpron++;
            }else if(intpron == 1){
                sendMsg(mes,"digite s");
                String r = mes.getText();
                for(Patrimony p: estoque.patri){
                    if(p.getName().equals(r)){
                        sendMsg(mes, "Bem encontrado sua localização : " + p.getLocation().getName());
                        sendMsg(mes, "digite /commands para outra operação");
                        opSystem();
                        intpro = 0;
                        auxtwo = false;
                    }

                }
                intpron++;



            }else if(auxtwo){
                sendMsg(mes,"bem não encontrado !");
                sendMsg(mes,"digite /commands para outra operação");
                opSystem();
                intpron = 0;

            }
        }
    }
    private void procuraByC(Update update) {
        Message mes = update.getMessage();
        if (mes != null && mes.hasText()) {
            if (intpro == 0) {
                sendMsg(mes, "digite o código do bem: ");
                String r = mes.getText();
                intpro++;

            } else if (intpro == 1) {
                sendMsg(mes,"digite s");
                String r = mes.getText();
                for (Patrimony p : estoque.patri) {
                    if (p.getCode().equals(r)) {
                        sendMsg(mes, "Bem encontrado sua localização : " + p.getLocation().getName());
                        sendMsg(mes, "digite /commands para outra operação");
                        opSystem();
                        intpro= 0;
                        aux = false;


                    }
                }
                intpro++;

            } else if (aux) {

                sendMsg(mes, "Bem não encontrado !");
                sendMsg(mes, "digite /commands para outra operação");
                opSystem();
                intpro = 0;

            }
        }
    }

    private void listarLocbyP(Update update) {
        Message mes = update.getMessage();
        if (mes != null && mes.hasText()) {
            if (intlocb == 0) {
                sendMsg(mes, "digite o nome de uma localização: ");
                String r = mes.getText();
                intlocb++;
            } else if (intlocb == 1) {
                String r = mes.getText();
                for (Patrimony p : estoque.patri) {
                    if (p.getLocation().getName().equals(r))
                        sendMsg(mes, " nome : " + p.getName() + " código: " + p.getCode());
                }
                sendMsg(mes, "Agora digite /commands para nova operação");
                opSystem();
                intlocb = 0;
            }
        }
        }








    private void listarCat(Update update){
        Message mes = update.getMessage();
        for(PatrimonyCategory pa: estoque.patriC){
            sendMsg(mes,"nome: " + pa.getName() + " código: " + pa.getCode() +" descrição: " + pa.getDescription());
        }
        sendMsg(mes,"Agora digite /commands para nova operação");
        opSystem();
    }
    private void listarLoc(Update update){
        Message mes = update.getMessage();
        for (Location  l: estoque.locs) {

            sendMsg(mes,"nome: " + l.getName() + " descrição: "  + l.getDescription());
        }
        sendMsg(mes, "Agora digite /commands para nova operação");

        opSystem();
            }



    private void cadastrarCate(Update update) {
        Message m = update.getMessage();
        if (m != null && m.hasText()) {
            if(intca == 0){
                sendMsg(m, "digite um nome para sua categoria de bem: ");
                String r = m.getText();
                pc.setName(r);
                intca++;



            }else if (intca == 1) {
                sendMsg(m, "digite s ");
                String r = m.getText();
                pc.setName(r);
                intca++;


            } else if (intca == 2) {
                sendMsg(m, "digte um código para o seu bem: ");
                String r = m.getText();
                intca++;

            } else if (intca == 3) {
                sendMsg(m,"digite s");
                String r = m.getText();
                pc.setCode(r);
                intca++;
            } else if (intca == 4) {
                sendMsg(m, "agora digite uma descrição para sua categoria: ");
                String r = m.getText();
                intca++;
            }else if(intca == 5){
                sendMsg(m,"digite s");
                String r = m.getText();
                pc.setDescription(r);
                intca++;
            }else if(intca == 6){
                sendMsg(m,"agora redigite /commands para outra operação");
                estoque.patriC.add(pc);
                intca = 0;
                pc = new PatrimonyCategory();
                opSystem();
            }



        }

    }


    private void cadastrarPatri(Update update ){
        Message m = update.getMessage();
        if (m != null && m.hasText()) {
                if(intpa == 0){
                    sendMsg(m,"digite um nome para o seu bem: ");
                    String r = m.getText();
                    intpa++;

                }else if(intpa == 1){
                    sendMsg(m,"digite s ");
                    String r = m.getText();
                    p.setName(r);
                    intpa++;

                }else if(intpa == 2){
                    sendMsg(m,"Digite uma descrição para o seu bem: ");
                    String r = m.getText();
                    for(int i = 0;i<estoque.locs.size();i++){
                        if(estoque.locs.get(i).getName().equals(r)){
                            p.setLocation(estoque.locs.get(i));
                        }
                    }
                    intpa++;

                }else if(intpa == 3) {
                    sendMsg(m, "digite s");
                    String r = m.getText();
                    p.setDescription(r);
                    intpa++;
                }else if(intpa == 4) {
                    sendMsg(m, "agora digite uma localização para o seu bem: ");
                    String r = m.getText();
                    intpa++;
                }else if(intpa == 5) {
                    sendMsg(m, "digite s");
                    String r = m.getText();
                    for (int i = 0; i < estoque.locs.size(); i++) {
                        if (estoque.locs.get(i).getName().equals(r)) {
                            p.setLocation(estoque.locs.get(i));
                        }
                    }
                    intpa++;
                }else if(intpa == 6) {
                    sendMsg(m, "agora digite uma categoria para o  seu  bem: ");
                    String r = m.getText();
                    intpa++;
                }
                else if(intpa == 7) {
                    sendMsg(m,"digite s");
                    String r = m.getText();
                    for (int i = 0; i < estoque.patriC.size(); i++) {
                        if (estoque.patriC.get(i).equals(r)) ;
                        p.setCategory(estoque.patriC.get(i));
                    }
                    intpa++;
                }else if(intpa == 8) {
                    sendMsg(m, "digite um código para o seu bem: ");
                    String r = m.getText();
                    p.setCode(r);
                    intpa++;
                }else if(intpa == 9) {
                    sendMsg(m, "digite s");
                    String r = m.getText();
                    p.setCode(r);
                    intpa++;
                }else if(intpa == 10){
                    sendMsg(m,"agora digite /commands para outra operação");
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
            if (loc == 0) {
                sendMsg(m,"digite  o nome para sua localização:");
                String opa = m.getText();

                loc++;
                }else if(loc ==1){
                sendMsg(m, "digite s");
                String r = m.getText();
                l.setName(r);
                loc++;
            } else if (loc == 2) {
                sendMsg(m, "digite uma descrição para  o sua localização:  ");
                String a = m.getText();

                loc++;
            } else if (loc == 3) {
                sendMsg(m, "digite s");
                String r = m.getText();
                l.setDescription(r);
                loc++;
            }else if(loc == 4){

                sendMsg(m, "agora redigite o comando /commands para outra operação");
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
