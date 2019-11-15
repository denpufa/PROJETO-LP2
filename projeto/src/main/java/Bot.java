import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;


public class Bot extends  TelegramLongPollingBot
{
    Estoque estoque = new Estoque();
    public void onUpdateReceived(Update update) {
        //System.out.println(update.getMessage().getText());
        //System.out.println(update.getMessage().getFrom().getFirstName());
        String command = update.getMessage().getText();
        SendMessage message = new SendMessage();

        if (command.equals("/myname"))
        {
            message.setChatId(update.getMessage().getChatId());
        System.out.println(update.getMessage().getFrom().getFirstName());

        message.setText("OLÁ SEJA BEM VINDO AO MENU ");
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        message.setText("1-cadastrar localização");
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        message.setText("2-cadastrar bem");
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        message.setText("3-cadastrar Categoria de bem");
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        message.setText("4-Listar localizações");
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        message.setText("5-Listar Categorias");
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        message.setText("6-Listar bem por uma localização");
         try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        message.setText("7-Buscar Bem por código");
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        message.setText("8-Buscar bem por nome");
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        message.setText("9-Buscar bem por descrição");
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        message.setText("10-Movimentar bem entre localizações");
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        message.setText("11-Gerar relatório");
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
     
        
        
        
        
        
        
        
        
        
        
        
        
        
        String name = update.getMessage().getText();
        message = new SendMessage();
        message.setChatId(update.getMessage().getChatId());

        if (command.equals("1")) {

                boolean aux = true;
                while(aux) 
                {
                    message.setText("digite um nome para a sua localização: ");
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    try {
                        Check.checkIfNameOnL(estoque.locs, name);
                        aux = false;
                    } catch (ExceptionHave exceptionHave) {
                            message.setText("esse nome de localização ja existe");
                            try {
                                execute(message);
                                } catch (TelegramApiException e) {
                                    e.printStackTrace();
                                 }   
                    }
                }

                    String desc = update.getMessage().getText();
                    message = new SendMessage();
                    message.setChatId(update.getMessage().getChatId());
               
                    message.setText("digite uma descrição para sua localização: ");
                    
                     Loocation l = new Location(name,desc);
                     estoque.locs.add(l);
                    
            }else if(command.equals("2"))
            {
                   message.setText("digite um nome para o seu bem");
                   try {
                        execute(message);
                   } catch (TelegramApiException e) {
                        e.printStackTrace();
                     } 
                  String code = update.getMessage().getText();
                  message = new SendMessage();
                  message.setChatId(update.getMessage().getchatId());
                  boolean aux = true;
                  while(aux)
                  {
                      message.setText("digite um código para o seu bem");
                      try {
                            execute(message);
                       } catch (TelegramApiException e) {
                            e.printStackTrace();
                         }
                      
                        
                  
                     
                  
                  
                   
                    





        }

            if (command.equals("/mylastname")) {

            System.out.println(update.getMessage().getFrom().getLastName());
            message.setText(update.getMessage().getFrom().getLastName());
        }

        if (command.equals("/myfullname")) {
            System.out.println(update.getMessage().getFrom().getFirstName() + " " + update.getMessage().getFrom().getLastName());
            message.setText(update.getMessage().getFrom().getFirstName() + " " + update.getMessage().getFrom().getLastName());
        }


    }


        public String getBotUsername() {

        return "WealthManagerBot";
    }

    public String getBotToken() {

        return "1001978429:AAHB97aihuye-wDwX09_yW_77jJ6kMPtmfY";
    }
}
