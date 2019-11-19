/**
 * @brief  Imported libraries.
 * */
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;


/**
 * @brief  Bot class is responsible for interact with telegram chat.
 */
public class Bot extends  TelegramLongPollingBot implements SystemNeeds {


    /**
     * @brief initializing objects to be used by inventory and the overall system.
     **/
    Estoque estoque = Estoque.getInstance();
    PatrimonyCategory pc = new PatrimonyCategory();
    Location l = new Location();
    Patrimony p = new Patrimony();
    FilerC filerc = new FilerC();
    FilerL filerl = new FilerL();
    FilerP filerp = new FilerP();

    /**
     * @brief Variables to control the state machine.
     **/
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

    /**
     * @brief Auxiliary variables in location movement.
     **/
    String help;
    Location lo;
    boolean ent = true;


    /**
     * @brief Method that sends messages to the user.
     **/
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

    /**
     * @brief Method that receives data from telegram every moment.
     **/
    public void onUpdateReceived(Update update) {

        /**
         * @brief First control option it shows the menu to the user and waits for a command.
         **/
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
                            "/report - Gera um relatório geral! \n" +
                            "/chargepatrimonies - Recupera bens anterioes\n");
                    opSystem();
                }


            }
        }

        /**
         * @brief Second control option if an operation is started it direct input to continue it if it does not expect a command on the switch.
         **/
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
                             imprimir(update);
                    }
                }

            }
        }
    }

    /**
     * @brief Method imprimir is responsible for generate report and insert the all the objects in Jsons files.
     **/
    public void imprimir(Update update){
        Message mes = update.getMessage();
        for(Location l:estoque.locs){
            for(Patrimony p :estoque.patri){
                if(p.getLocation().getName().equals(l.getName())){
                    sendMsg(mes,p.getName() + " Código: " + p.getCode());
                }
            }
        }
        for(PatrimonyCategory pc: estoque.patriC){
            for(Patrimony p :estoque.patri){
                if (p.getCategory().getName().equals(pc.getName())) {
                    sendMsg(mes,p.getName() + " Código: " + p.getCode());
                }
            }
        }

        for(Patrimony p: estoque.patri) {
            sendMsg(mes, p.getName());
        }

        filerc.chargeList(estoque.patriC);
        filerl.chargeList(estoque.locs);
        filerp.chargeList(estoque.patri);

    }

    /**
     * @brief Method moverL is responsible for moving the location of a patrimony.
     **/
    public void moverL(Update update){
        Message mes = update.getMessage();
        if(mes != null &&  mes.hasText()){
            if(intm == 0){
                sendMsg(mes,"Digte o código do bem: ");
                String r = mes.getText();
                intm++;
            }else if(intm == 1){
                sendMsg(mes,"Digite qualquer tecla");
                String r = mes.getText();
                intm++;
                help = r;
            }else if(intm == 2){
                sendMsg(mes,"Digite o nome da nova localização: ");
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
                    sendMsg(mes,"Localização não encontrada!");
                    intm++;

                }
                sendMsg(mes,"Digite /commmands para outra operação");
                opSystem();
                intm = 0;

            }else {
                sendMsg(mes,"Digite /commmands para outra operação");
                opSystem();
                intm = 0;

            }
        }
    }

    /**
     * @brief Method procurarbyD is responsible for search the patrimony by Description.
     **/
    public void procurabyD(Update update){
        Message mes = update.getMessage();
        if(mes != null &&  mes.hasText()){
            if(intprod == 0){
                sendMsg(mes,"Digite a descrição do bem: ");
                String r = mes.getText();
                intprod++;
            }else if(intprod == 1){
                sendMsg(mes,"Digite qualquer tecla");
                String r = mes.getText();
                for(Patrimony p: estoque.patri){
                    if(p.getDescription().equals(r)){
                        sendMsg(mes,"Bem encontrado " + " Localização: " + p.getLocation().getName());
                        auxthree  = false;
                        opSystem();
                        intprod = 0;

                    }
                }
                intprod++;
            }else if(auxthree){
                sendMsg(mes,"Bem não encontrado!");
                sendMsg(mes,"Digite /commands para outra operação");
                opSystem();
                intprod = 0;

            }

        }
    }

    /**
     * @brief Method procurarbyN is responsible for search the patrimony by Name.
     **/
    public void procuraByN(Update update){
        Message mes = update.getMessage();
        if(mes != null && mes.hasText()){
            if(intpron == 0){
                sendMsg(mes,"Digite nome do bem: ");
                String r = mes.getText();
                intpron++;
            }else if(intpron == 1){
                sendMsg(mes,"Digite qualquer tecla");
                String r = mes.getText();
                for(Patrimony p: estoque.patri){
                    if(p.getName().equals(r)){
                        sendMsg(mes, "Bem encontrado sua localização : " + p.getLocation().getName());
                        sendMsg(mes, "Digite /commands para outra operação");
                        opSystem();
                        intpro = 0;
                        auxtwo = false;
                    }

                }
                intpron++;



            }else if(auxtwo){
                sendMsg(mes,"Bem não encontrado !");
                sendMsg(mes,"Digite /commands para outra operação");
                opSystem();
                intpron = 0;

            }
        }
    }

    /**
     * @brief Method procurarbyN is responsible for search the patrimony by Name.
     **/
    public void procuraByC(Update update) {
        Message mes = update.getMessage();
        if (mes != null && mes.hasText()) {
            if (intpro == 0) {
                sendMsg(mes, "Digite o código do bem: ");
                String r = mes.getText();
                intpro++;

            } else if (intpro == 1) {
                sendMsg(mes,"Digite qualquer tecla");
                String r = mes.getText();
                for (Patrimony p : estoque.patri) {
                    if (p.getCode().equals(r)) {
                        sendMsg(mes, "Bem encontrado, sua localização : " + p.getLocation().getName());
                        sendMsg(mes, "Digite /commands para outra operação");
                        opSystem();
                        intpro= 0;
                        aux = false;


                    }
                }
                intpro++;

            } else if (aux) {

                sendMsg(mes, "Bem não encontrado !");
                sendMsg(mes, "Digite /commands para outra operação");
                opSystem();
                intpro = 0;

            }
        }
    }

    /**
     * @brief Method listarLocbyP is responsible for list patrimonis by location.
     **/
    public void listarLocbyP(Update update) {
        Message mes = update.getMessage();
        if (mes != null && mes.hasText()) {
            if (intlocb == 0) {
                sendMsg(mes, "Digite o nome de uma localização: ");
                String r = mes.getText();
                intlocb++;

            } else if (intlocb == 1) {
                String r = mes.getText();
                try{
                    Check.existeL(estoque.locs,r);

                    intlocb = 0;
                } catch (ExceptionHave exceptionHave) {
                    exceptionHave.printStackTrace();
                    sendMsg(mes,"Localização não encontrada");
                    sendMsg(mes, "Agora digite /commands para nova operação");
                    opSystem();
                    intlocb = 0;
                }
                for (Patrimony p : estoque.patri) {
                    if (p.getLocation().getName().equals(r))
                        sendMsg(mes, " Nome : " + p.getName() + " Código: " + p.getCode());
                }
                sendMsg(mes, "Agora digite /commands para nova operação");
                opSystem();
                intlocb = 0;


            }
        }
    }


    /**
     * @brief Method listarCat is responsible for list categories.
     **/
    public void listarCat(Update update){
        Message mes = update.getMessage();
        for(PatrimonyCategory pa: estoque.patriC){
            sendMsg(mes,"Nome: " + pa.getName() + " Código: " + pa.getCode() +" Descrição: " + pa.getDescription());
        }
        sendMsg(mes,"Agora digite /commands para nova operação");
        opSystem();
    }

    /**
     * @brief Method listarCat is responsible for list locations.
     **/
    public void listarLoc(Update update){
        Message mes = update.getMessage();
        for (Location  l: estoque.locs) {

            sendMsg(mes,"Nome: " + l.getName() + " Descrição: "  + l.getDescription());
        }
        sendMsg(mes, "Agora digite /commands para nova operação");

        opSystem();
            }

    /**
     * @brief Method cadastrarCate is responsible for register categories.
     **/
    public void cadastrarCate(Update update) {
        Message m = update.getMessage();
        if (m != null && m.hasText()) {
            if(intca == 0){
                sendMsg(m, "Digite um nome para sua categoria de bem: ");
                String r = m.getText();
                pc.setName(r);
                intca++;



            }else if (intca == 1) {
                sendMsg(m, "Digite qualquer tecla");
                String r = m.getText();
                pc.setName(r);
                intca++;


            } else if (intca == 2) {
                sendMsg(m, "Digte um código para a sua categoria de  bem: ");
                String r = m.getText();
                intca++;

            } else if (intca == 3) {
                sendMsg(m,"Digite qualquer tecla");
                String r = m.getText();
                try {
                    Check.checkCodeC(estoque.patriC,r);
                    pc.setCode(r);

                } catch (ExceptionHave exceptionHave) {
                    exceptionHave.printStackTrace();
                    sendMsg(m," Esse código ja existe, não digite qualquer tecla!");
                    sendMsg(m,"A gora redigite /commands para outra operação");
                    opSystem();
                    intca = 0;

                }
                intca++;

            } else if (intca == 4) {
                sendMsg(m, " Agora digite uma descrição para sua categoria: ");
                String r = m.getText();
                intca++;
            }else if(intca == 5){
                sendMsg(m," Digite qualquer tecla");
                String r = m.getText();
                pc.setDescription(r);
                intca++;
            }else if(intca == 6){
                sendMsg(m,"Agora redigite /commands para outra operação");
                estoque.patriC.add(pc);
                intca = 0;
                pc = new PatrimonyCategory();
                opSystem();
            }



        }

    }

    /**
     * @brief Method cadastrarPati is responsible for register patrimonies.
     **/
    public void cadastrarPatri(Update update ){
        Message m = update.getMessage();
        if (m != null && m.hasText()) {
                if(intpa == 0){
                    sendMsg(m,"Digite um nome para o seu bem: ");
                    String r = m.getText();
                    intpa++;

                }else if(intpa == 1){
                    sendMsg(m,"Digite qualquer tecla");
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
                    sendMsg(m, "Digite qualquer tecla");
                    String r = m.getText();
                    p.setDescription(r);
                    intpa++;
                }else if(intpa == 4) {
                    sendMsg(m, "Agora digite uma localização para o seu bem: ");
                    String r = m.getText();
                    intpa++;
                }else if(intpa == 5) {
                    sendMsg(m, "Digite qualquer tecla");
                    String r = m.getText();
                    try{
                        Check.existeL(estoque.locs,r);
                        for (int i = 0; i < estoque.locs.size(); i++) {
                            if (estoque.locs.get(i).getName().equals(r)) {
                                p.setLocation(estoque.locs.get(i));
                            }
                        }

                    } catch (ExceptionHave exceptionHave) {
                        exceptionHave.printStackTrace();
                        sendMsg(m,"Essa localização não existe,não digite qualquer tecla!");
                        sendMsg(m,"Digite /commands para outra operação");
                        opSystem();
                        intpa = 0;
                    }
                    intpa++;

                }else if(intpa == 6) {
                    sendMsg(m, "Agora digite uma categoria para o  seu  bem: ");
                    String r = m.getText();
                    intpa++;
                }
                else if(intpa == 7) {
                    sendMsg(m,"Digite qualquer tecla");
                    String r = m.getText();
                    try{
                        Check.existeC(estoque.patriC,r);
                        for (int i = 0; i < estoque.patriC.size(); i++) {
                            if (estoque.patriC.get(i).equals(r)) ;
                            p.setCategory(estoque.patriC.get(i));
                        }

                    } catch (ExceptionHave exceptionHave) {
                        exceptionHave.printStackTrace();
                        sendMsg(m,"Essa categoria não existe,não digite s!");
                        sendMsg(m,"Digite /commands para outra operação");
                        opSystem();
                        intpa = 0;
                    }
                    intpa++;

                }else if(intpa == 8) {
                    sendMsg(m, "Digite um código para o seu bem: ");
                    String r = m.getText();
                    p.setCode(r);
                    intpa++;
                }else if(intpa == 9) {
                    sendMsg(m, "Digite qualquer tecla");
                    String r = m.getText();
                    try{
                        Check.checkCodeP(estoque.patri,r);
                        p.setCode(r);

                    } catch (ExceptionHave exceptionHave) {
                        exceptionHave.printStackTrace();
                        sendMsg(m,"Esse código ja existe,não digite s!");
                        sendMsg(m,"Digite /commands para outra operação");
                        opSystem();
                        intpa = 0;
                    }
                    intpa++;

                }else if(intpa == 10){
                    sendMsg(m,"Agora digite /commands para outra operação");
                    opSystem();
                    intpa = 0;
                    estoque.patri.add(p);
                    p = new Patrimony();
                }
        }
    }

    /**
     * @brief Method cadastrarPati is responsible for register locations.
     **/
     public void cadastrarLoc(Update update) {

        Message m = update.getMessage();
        if (m != null && m.hasText()) {
            if (loc == 0) {
                sendMsg(m,"Digite  o nome para sua localização:");
                String opa = m.getText();

                loc++;
                }else if(loc ==1){
                sendMsg(m, "Digite qualquer tecla");
                String r = m.getText();
                try{
                   Check.checkNameL(estoque.locs,r);
                    l.setName(r);


                } catch (ExceptionHave exceptionHave) {
                    exceptionHave.printStackTrace();
                    sendMsg(m,"Essa localização ja existe,não digite qualquer tecla!");
                    sendMsg(m,"Digite /commands para outra operação");
                    opSystem();
                    loc = 0;
                }
                loc++;
            } else if (loc == 2) {
                sendMsg(m, "Digite uma descrição para  o sua localização:  ");
                String a = m.getText();

                loc++;
            } else if (loc == 3) {
                sendMsg(m, "Digite qualquer tecla");
                String r = m.getText();
                l.setDescription(r);
                loc++;
            }else if(loc == 4){

                sendMsg(m, "Agora redigite o comando /commands para outra operação");
                opSystem();
                loc = 0;
                estoque.locs.add(l);
                l = new Location();
            }
        }
    }

    /**
     * @brief Method opSystem is responsible implement control counter.
     **/
    private void opSystem() {
       control++;

    }



    public String getBotUsername() {

        return "WealthManagerBot";
    }

    public String getBotToken() {

        return "1001978429:AAHB97aihuye-wDwX09_yW_77jJ6kMPtmfY";
    }


    /**
     * @brief Method chargePatrimonies is responsible for charge all the patrimonies of the Json files.
     **/
    public void chargePatrimonies(){
        filerc.charge();
        filerl.charge();
        filerp.charge();
    }

}
