import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Bot extends  TelegramLongPollingBot
{

    public void onUpdateReceived(Update update) {
        //System.out.println(update.getMessage().getText());
        //System.out.println(update.getMessage().getFrom().getFirstName());
        String command = update.getMessage().getText();
        Menu m = new Menu();
        if (command.equals("/menu")) {
            execute(m);
            m.run();
        }


    }


    public String getBotUsername() {

        return "WealthManagerBot";
    }

    public String getBotToken() {

        return "1001978429:AAHB97aihuye-wDwX09_yW_77jJ6kMPtmfY";
    }
}
