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
        String name = update.getMessage().getText();
        message = new SendMessage();
        message.setChatId(update.getMessage().getChatId());

        if (command.equals("1")) {

                boolean aux = true;
                Patrimony c = new Patrimony();
                while(aux) {
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
                    }
                }

                    String desc = update.getMessage().getText();
                    message = new SendMessage();
                    message.setChatId(update.getMessage().getChatId());






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
