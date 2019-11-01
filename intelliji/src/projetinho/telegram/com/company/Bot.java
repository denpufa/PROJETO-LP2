 import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public class Bot extends TelegramLongPollingBot

{

        public void onUpdateReceived(Update update)
        {
            //System.out.println(update.getMessage().getText());
            //System.out.println(update.getMessage().getFrom().getFirstName());
            String command=update.getMessage().getText();
            
            if(command.equals("/menu")
            {
               Menu m = new Menu();
               Menu.run;
            }

        }

        

        public String getBotUsername()
        {

           return "WealthManagerBot";
        }

        public String getBotToken()
        {

           return "1001978429:AAHB97aihuye-wDwX09_yW_77jJ6kMPtmfY";
        }
