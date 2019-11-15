import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;


public class Bot extends  TelegramLongPollingBot {
    Estoque estoque = new Estoque();

    public void onUpdateReceived(Update update) {
        //System.out.println(update.getMessage().getText());
        //System.out.println(update.getMessage().getFrom().getFirstName());
        String command = update.getMessage().getText();
        SendMessage message = new SendMessage();

        if (command.equals("/menu")) {
            message.setText("OLÁ SEJA BEM VINDO AO MENU \n" +
                    "Digite /cadastrarLoc para cadastrar localização! \n" +
                    "\n"+
                    "Digite /cadastrarBem para cadastrar um bem! \n" +
                    "\n"+
                    "Digite /cadastrarCategoria para cadastrar categoria de bem! \n" +
                    "\n"+
                    "Digite /listarLoc para listar localizações! \n" +
                    "\n"+
                    "Digite /listarCategoria para listar categorias! \n" +
                    "\n"+
                    "Digite /listarBemPorLoc para listar os bens por uma localização! \n" +
                    "\n"+
                    "Digite /buscarBemPorCodigo para buscar um bem pelo código! \n" +
                    "\n"+
                    "Digite /buscarBemPorNome para buscar um bem pelo nome! \n" +
                    "\n"+
                    "Digite /buscarBemPorDesc para buscar um bem pela descrição! \n" +
                    "\n"+
                    "Digite /movimentarBemLoc para movimentar um bem entre as localizações! \n" +
                    "\n"+
                    "Digite /gerarRelatorio para gerar um relatório geral! \n"
            );

        }

        if (command.equals("/cadastarLocalition")) {
            String name = update.getMessage().getText();

            boolean aux = true;
            while (aux) {
                message.setText("Digite um nome para a sua localização: ");
               try {
                    Check.checkIfNameOnL(estoque.locs, name);
                    aux = false;
                } catch (ExceptionHave exceptionHave) {
                    message.setText("Esse nome de localização ja existe");
               }
            }

            String desc = update.getMessage().getText();

            message.setText("Digite uma descrição para sua localização: ");

            Location l = new Location(name, desc);
            estoque.locs.add(l);

        }

        message.setChatId(update.getMessage().getChatId());

        try
        {
            execute(message);
        } catch(
                TelegramApiException e)

        {
            e.printStackTrace();
        }
    }








        public String getBotUsername() {

        return "WealthManagerBot";
    }

    public String getBotToken() {

        return "1001978429:AAHB97aihuye-wDwX09_yW_77jJ6kMPtmfY";
    }
}
