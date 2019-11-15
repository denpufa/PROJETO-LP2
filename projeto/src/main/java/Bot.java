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
        Check check = new Check();

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
                        check.checkIfNameOnL(estoque.locs, name);
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
                      message.setText("digite um código para o seu bem");
                      try {
                            execute(message);
                       } catch (TelegramApiException e) {
                            e.printStackTrace();
                         }
                      try
                      {
                            check.checkCodeP(estoque.patri,code);
                            aux = false;
                       }
                       catch(ExceptionHave k)
                       {
                            message.setText("esse codigo ja existe");
                            try {
                                execute(message);
                            } catch (TelegramApiException b) {
                                b.printStackTrace();
                            }
                            return;
                       }
                    
                    aux = true;
                    String descri = update.getMessage().getText();
                    message = new SendMessage();
                    message.setChatId(update.getMessage().getChatId());
                    message.setText("digite uma descrição para o seu bem: ");
                    try {
                          execute(message);
                     } catch (TelegramApiException b) {
                                b.printStackTrace();
                            }
                    String locali = update.getMessage().getText();
                    message = new SendMessage();
                    message.setChatId(update.getMessage().getChatId());
                    message.setText("digite o nome de um localização para o seu bem:");
                    int indiceloca;
                    for(int i = 0;i<locs.size();i++)
                    {
                        if(locs.get(i).getName().equals(locali))
                        {
                            aux = false;
                            indiceloca = i;
                        }
                    }
                    if(aux)
                    {
                        message.setText("essa localização não existe");
                        try {
                          execute(message);
                        } catch (TelegramApiException b) {
                                b.printStackTrace();
                         }
                         return;
                     }
                    aux = true;
                    int indicecate;
                    String catego  = update.getMessage().getText();
                    message = new SendMessage();
                    message.setChatId(update.getMessage().getChatId());
                    message.setText("digite o nome de uma categoria para o seu bem:");
                    for(int i = 0;i<cate.size();i++)
                    {
                        if(cate.get(i).getName().equals(catego))
                        {
                            aux = false;
                            indicecate = i;
                         }
                     }
                     if(aux)
                     {
                        message.setText("essa categoria não existe");
                        try {
                          execute(message);
                        } catch (TelegramApiException b) {
                                b.printStackTrace();
                        return;
                      }
                      
                      Patrimony p = new Patrimony(name,code,descri,locs.get(indiceloca),cate.get(indicecate));
                      patri.add(p);
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
