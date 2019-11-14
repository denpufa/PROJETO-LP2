
import java.util.ArrayList;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

import static java.lang.Integer.parseInt;

public class Menu extends TelegramLongPollingBot implements SystemNeeds
{
    /**
     * @brief Patrimony class attributes.
     */
    private ArrayList<Location> locs;
    private ArrayList<PatrimonyCategory> category;
    private ArrayList<Patrimony> patrimonies;


    public  void  run()
    {

        boolean permanecer = true;
        //inicializando objetos da api do telegram.
        Update u = new Update();
        SendMessage m = new SendMessage();
        while(permanecer)
        {


            m.setText("Seja bem vindo ao gerenciador escolha uma opção pelo número, tenha um bom dia "  +
                    "1-Registrar Localização" +
                    "2-Registrar Categoria de bem"  +
                    "3-Registrar Bem (Patrimônio)" +
                    "4-Listar Localizações" +
                    "5-Listar Categorias"  +
                    "6-Listar Bem por Categoria" +
                    "7-Listar Bem por Localização" +
                    "8-Procurar Patrimônio por Código"  +
                    "9-Procurar Patrimônio por nome" +
                    "10-Procurar Patrimônio por descrição" +
                    "11-Mover Patrimônio entre as localizações" +
                    "12-Gerar Relátorio" +
                    "0-Sair do menu");

            m.setChatId(u.getMessage().getChatId());
            try {
                execute(m);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            String opcao = u.getMessage().getText();
            int op = parseInt(opcao);
            //o break no switch é por uma questão de previnir.
            switch(op)
            {
                case 0:
                    permanecer = false;
                    break;
                case 1:
                    this.registerLocation(m,u);
                    break;
                case 2:
                    this.registerCategory(m,u);
                    break;
                case 3:
                    this.registerPatrimony(m,u);
                    break;
                case 4:
                    this.listLocation(m,u);
                    break;
                case 5:
                    this.listCategory(m,u);
                    break;
                case 6:
                    this.listPatrimonyByCategory(m,u);
                    break;
                case 7:
                    this.listPatrimonyByLocation(m,u);
                    break;
                case 8:
                    this.searchPatrimonyByCode(m,u);
                    break;
                case 9:
                    this.searchPatrimonyByName(m,u);
                    break;
                case 10:
                    this.searchPatrimonyByDescription(m,u);
                    break;
                case 11:
                    this.movePatrimony(m,u);
                    break;
                case 12:
                    this.generateReport(m,u);
                    break;
                default:
                    m.setText("Voçê não digitou uma opção valída, tente novamente");
                    m.setChatId(u.getMessage().getChatId());
                    try
                    {
                        execute(m);
                    }
                    catch(TelegramApiException e)
                    { e.printStackTrace(); }
                    break;

            }
        }
    }

    /**
     * @brief Mandatory methods of SystemNeeds
     */


    public void registerLocation(SendMessage m,Update u)
    {
        Location l = new Location();
        boolean aux = true;
        m.setChatId(u.getMessage().getChatId());
        while(aux)
        {
            m.setText("Digite um nome para a localização a ser criada:");
            try
            {execute(m);
            }
            catch(TelegramApiException e)
            {
                e.printStackTrace();
            }
            try
            {
                String n = u.getMessage().getText();
                Check.checkNameL(locs,n);
                aux = false;
                l.setName(n);


            }
            catch(Exception e)
            {
                m.setText("Esse nome já foi cadastrado tente outro por favor");
                try
                {
                    execute(m);
                }
                catch(TelegramApiException j)
                {j.printStackTrace(); }
            }
        }
        aux = true;
        while(aux)
        {
            m.setText("Digite uma descrição para a localização a ser criada:");
            try
            {
                execute(m);
            }
            catch(TelegramApiException e)
            { e.printStackTrace(); }
            String d = u.getMessage().getText();
            l.setDescription(d);
            try
            {
                locs.add(l);
                m.setText("Localização , criada com sucesso");
                aux = false;
                try
                {execute(m);}
                catch(TelegramApiException e)
                { e.printStackTrace(); }

            }
            catch(Exception e)
            {
                m.setText("ops, aconteceu um erro!");
                try
                {execute(m);}
                catch(TelegramApiException j)
                { j.printStackTrace(); }
            }
        }

    }


    public void registerCategory(SendMessage m,Update u)
    {
        PatrimonyCategory c = new PatrimonyCategory();
        boolean aux = true;
        m.setChatId(u.getMessage().getChatId());
        while(aux)
        {
            m.setText("digite um código  para a sua categoria de bem:");
            try
            {
                execute(m);
            }
            catch(TelegramApiException e)
            { e.printStackTrace(); }
            String r = u.getMessage().getText();
            int co;
            try
            {  co = parseInt(r);}
            catch (NumberFormatException e)
            {
                m.setText("código com formato invalído!");
                continue;
            }
            try
            {
                String ca = Integer.toString(co);
                Check.checkCodeC(category,ca);
                aux = false;
                c.setCode(co);
            }
            catch(Exception e)
            {
                m.setText("código ja existe!");
                try
                {execute(m);}
                catch(TelegramApiException l)
                {l.printStackTrace();}
            }
        }
        aux = true;
        while(aux)
        {
            m.setText("digite um nome para sua categoria: ");
            try
            {
                execute(m);
                aux = false;
            }
            catch(TelegramApiException e)
            { e.printStackTrace(); }
            String r = u.getMessage().getText();
            c.setName(r);
        }
        aux = true;
        while(aux)
        {
            m.setText("digite uma descrição para o sua categoria de bem: ");
            try
            {
                execute(m);
                aux = false;
            }
            catch(TelegramApiException e)
            { e.printStackTrace(); }
            String r = u.getMessage().getText();
            c.setDescription(r);
        }
        try
        {
            category.add(c);
            m.setText("categoria adiconada com sucesso");
            try
            {execute(m);}
            catch(TelegramApiException e)
            { e.printStackTrace(); }

        }
        catch(Exception e)
        {
            m.setText("ops aconteceu um erro imprevisto,desculpe!");
            aux = false;
        }
    }



    public void registerPatrimony(SendMessage m,Update u)
    {
        Patrimony p = new Patrimony();
        boolean aux = true;
        m.setChatId(u.getMessage().getChatId());
        while(aux)
        {
            m.setText("digite um código  para o seu de bem:");
            try
            {execute(m);}
            catch(TelegramApiException e)
            { e.printStackTrace(); }
            String r = u.getMessage().getText();
            int co;
            try
            {  co = parseInt(r);}
            catch (NumberFormatException e)
            {
                m.setText("código com formato invalído!");
                continue;
            }
            try
            {
                Check.checkCodeP(patrimonies,co);
                aux = false;
                p.setCode(co);
            }
            catch(Exception e)
            {
                m.setText("código ja existe!");
                try
                {execute(m);}
                catch(TelegramApiException j)
                {j.printStackTrace();}
            }
        }
        aux = true;
        while(aux)
        {
            m.setText("digite um nome para seu bem: ");
            try
            {
                execute(m);
                aux = false;
            }
            catch(TelegramApiException e)
            { e.printStackTrace(); }
            String r = u.getMessage().getText();
            p.setName(r);
        }
        aux = true;
        while(aux)
        {
            m.setText("digite uma descrição para o seu  bem: ");
            try
            {
                execute(m);
                aux = false;
            }
            catch(TelegramApiException e)
            { e.printStackTrace(); }
            String r = u.getMessage().getText();
            p.setDescription(r);
        }
        aux = true;
        while(aux)
        {
            m.setText("escolha uma localização para o seu bem pelo nome: ");
            try
            {execute(m);}
            catch(TelegramApiException e)
            { e.printStackTrace(); }
            this.listLocation(m,u);
            String r = u.getMessage().getText();
            try
            {
                p.setLocation(Check.checkIfNameOnL(locs,r));
                aux = false;

            }
            catch(Exception e)
            {
                m.setText("esse nome não tá na lista mostrada");
                try
                {execute(m);}
                catch(TelegramApiException j)
                { j.printStackTrace(); }
            }
        }
        aux = true;
        while(aux)
        {
            m.setText("escolha uma categoria para o seu bem pelo nome: ");
            try
            {execute(m);}
            catch(TelegramApiException e)
            { e.printStackTrace(); }
            this.listCategory(m,u);
            String r = u.getMessage().getText();
            try
            {
                p.setCategory(Check.checkIfNameOnPC(category,r));
                aux = false;
            }
            catch(Exception e)
            {
                m.setText("esse nome não tá na lista mostrada");
                try
                {execute(m);}
                catch(TelegramApiException j)
                { j.printStackTrace(); }
            }
        }
        try
        {
            patrimonies.add(p);
            m.setText("bem adiconado com sucesso");
            try
            {execute(m);}
            catch(TelegramApiException e)
            { e.printStackTrace(); }

        }
        catch(Exception e)
        {
            m.setText("ops aconteceu um erro imprevisto,desculpe!");
        }
    }

    public void listLocation(SendMessage m,Update u)
    {
        m.setChatId(u.getMessage().getChatId());
        for(int i=0;i<locs.size();i++)
        {
            m.setText(locs.get(i).getName());
            try
            {execute(m);}
            catch(TelegramApiException e)
            { e.printStackTrace(); }
        }
    }


    public void listCategory(SendMessage m,Update u)
    {
        m.setChatId(u.getMessage().getChatId());
        for(int i=0;i<category.size();i++)
        {
            m.setText(category.get(i).getName());
            try
            {execute(m);}
            catch(TelegramApiException e)
            { e.printStackTrace(); }
        }

    }


    public void listPatrimonyByLocation(SendMessage m,Update u)
    {

        m.setChatId(u.getMessage().getChatId());
        boolean aux = true;
        while(aux)
        {
            m.setText("escolha uma localização para ser listada: ");
            try
            {execute(m);}
            catch(TelegramApiException e)
            { e.printStackTrace(); }
            this.listLocation(m,u);
            String r = u.getMessage().getText();
            try
            {
                Check.checkIfNameOnL(locs,r);
            }
            catch(Exception e)
            {
                m.setText("esse nome não tá na lista mostrada");
                try
                {execute(m);}
                catch(TelegramApiException j)
                { j.printStackTrace(); }
                aux = false;
                continue;
            }
            for(int i = 0;i<patrimonies.size();i++)
            {
                if(patrimonies.get(i).getLocation().getName().equals(r))
                {
                    m.setText(patrimonies.get(i).getName());
                    try
                    {execute(m);}
                    catch(TelegramApiException e)
                    { e.printStackTrace(); }
                }
            }

        }
    }

    public void listPatrimonyByCategory(SendMessage m,Update u)
    {
        m.setChatId(u.getMessage().getChatId());
        boolean aux = true;
        while(aux)
        {
            m.setText("escolha uma categoria para ser listada: ");
            try
            {execute(m);}
            catch(TelegramApiException e)
            { e.printStackTrace(); }
            this.listLocation(m,u);
            String r = u.getMessage().getText();
            try
            {
                Check.checkIfNameOnL(locs,r);
            }
            catch(Exception e)
            {
                m.setText("esse nome não tá na lista mostrada");
                try
                {execute(m);}
                catch(TelegramApiException j)
                { j.printStackTrace(); }
                aux = false;
                continue;
            }
            for(int i = 0;i<patrimonies.size();i++)
            {
                if(patrimonies.get(i).getCategory().getName().equals(r))
                {
                    m.setText(patrimonies.get(i).getName());
                    try
                    {execute(m);}
                    catch(TelegramApiException e)
                    { e.printStackTrace(); }
                }
            }

        }

    }


    public void searchPatrimonyByCode(SendMessage m,Update u)
    {
        boolean aux = true;
        while(aux)
        {
            m.setChatId(u.getMessage().getChatId());
            m.setText("digite um codigo para busca:");
            String r = u.getMessage().getText();
            int co;
            try
            {
                co = parseInt(r);
                aux = false;
            }
            catch (NumberFormatException e)
            {
                m.setText("código com formato invalído!");
                continue;
            }
            for(int i = 0;i<patrimonies.size();i++)
            {
                if(patrimonies.get(i).getCode() == co)
                {
                    m.setText(patrimonies.get(i).getName());
                    try
                    {execute(m);}
                    catch(TelegramApiException e)
                    { e.printStackTrace(); }
                }
            }
        }

    }


    public void searchPatrimonyByName(SendMessage m,Update u)
    {
        m.setChatId(u.getMessage().getChatId());
        boolean aux = true;
        while(aux)
        {
            m.setText("digite   o nome do bem :  ");
            int y = 0;
            try
            {execute(m);}
            catch(TelegramApiException e)
            { e.printStackTrace(); }
            String r = u.getMessage().getText();
            for(int i = 0;i<patrimonies.size();i++)
            {
                if(patrimonies.get(i).getName().equals(r))
                {
                    int y=1;
                    m.setText("bem achado" + "localização: " + patrimonies.get(i).getLocation().getName());
                    try
                    {execute(m);}
                    catch(TelegramApiException e)
                    { e.printStackTrace(); }

                }
            }
            if(y == 0)
            {
                m.setText("bem não encontrado digite 1 para tentar outro ,2 para sair");
                r = u.getMessage().getText();
                if(r.equals("2"))
                    aux = false;
            }

        }



    }


    public void searchPatrimonyByDescription(SendMessage m,Update u)
    {
        int y = 0 ;
        m.setChatId(u.getMessage().getChatId());
        boolean aux = true;
        while(aux)
        {
            m.setText("digite a descrição do bem: ");
            String r = u.getMessage().getText();
            for(int i = 0;i<patrimonies.size();i++)
            {
                if(patrimonies.get(i).getDescription().equals(r))
                {
                    y = 1;
                    m.setText("bem encontrado" + "localização" + patrimonies.get(i).getLocation().getName());
                    try
                    {execute(m);}
                    catch(TelegramApiException e)
                    { e.printStackTrace(); }
                }
            }
            if (y == 0)
            {
                m.setText("bem nao encontrado para tentar novamente digite 1 para sair digite 0");
                try
                {execute(m);}
                catch(TelegramApiException e)
                { e.printStackTrace(); }
                r = u.getMessage().getText();
                if(r.equals(0))
                    aux = false;
            }
        }

    }


    public void movePatrimony(SendMessage m,Update u)
    {
        int indiceofname;
        int indiceofloc;
        bolean aux = true;
        while(true)
        {
            
            m.setText("escolha  patrimonio a ser movido pelo nome,digite o nome logo a apos a listagem")
            try
              {execute(m);}
            catch(TelegramApiException e)
              { e.printStackTrace(); }
              for(int i = 0;i<patrimonies.size();i++)
              {
                    m.setText(patrimonies.get(i).getName());
                    try
                        {execute(m);}
                    catch(TelegramApiException e)
                        {e.printStackTrace();}

              }
              String r = u.getMessage().getText();
              for(int i = 0;i<patrimonies.size();i++)
              {
                    if(patrimonies.get(i).getName().equals(r))
                    {
                            indiceofname = i;
                            aux = false;
                     }
                            
                                          
                
                        
              }
              if(aux)
                continue;
              
              
              
                    
         
          m.sexText("agora escolha uma nova localização para o seu bem digitando  o nome no final da lista");
          listCategory(m,u);
          String t = u.getMessage().getText();
          for(int i = 0;i<locs.size();i++)
           {
                if(locs.get(i).getName().equals(t))
                 {    
                     indiceofloc = i;
                      aux = false;
                 }
            }
            if(aux)
                continue;
            
              
            
            
          
         
          
        


    }


    public void generateReport(SendMessage m,Update u)
    {

    }

    public void onUpdateReceived(Update update) {

    }

    public String getBotUsername() {
        return null;
    }

    public String getBotToken() {
        return null;
    }
}



