package projetinho.telegram.com.company;

import java.util.ArrayList;
import org.telegram.telegrambots.exceptions.TelegramApiException;


public class Menu implements SystemNeeds
{
    /**
     * @brief Patrimony class attributes.
     */
    private ArrayList<Location> locs;
    private ArrayList<PatrimonyCategory> category;
    private ArrayList<Patrimony> patrimonies;

    /**
     * @brief Mandatory methods of SystemNeeds
     */


    
   
    public  void  run() 
    {
        
        bool permanecer = true;
        while(permanecer)
        {
            //inicializando objetos da api do telegram.
            Update u = new Update();
            SendMessage m = new SendMessage();

            m.setText("seja bem vindo ao gerenciador escolha uma opção   pelo número,tenha um bom dia "  +
                            "1-registrar localização" + 
                            "2-registrar categoria de bem"  +
                            "3-registrar bem (patrimônio)" +
                            "4-Listar localizações" +
                            "5-Listar categorias"  +
                            "6-Listar bem por categoria" +
                            "7-Listar bem por localização" +
                            "8-Procurar patrimonio por código"  +
                            "9-Procurar patrimonio por nome" +
                            "10-Procurar patrimonio por descrição" +
                            "11-Mover patrimonio entre as localizações" +
                            "12-Gerar relátorio" +
                            "0-sair do menu");
            m.setChatId(u.getMessage.getChatId());
            try
                {execute(m);}
            catch(TelegramApiException e)
                { e.printStackTrace; }

             String opcao = u.getMessage().getText();
             //o break no switch é por uma questão de previnir.
             switch(opcao)
             {
                 case "0":
                          permanecer = false;
                          break;
                 case "1": 
                          this.registerLocation(m,u);
                          break;
                 case "2":
                         this.registerCategory();
                         break;
                 case "3":
                         this.registerPatrimony();
                         break;
                 case "4":
                          this.listLocation();
                          break;
                 case "5":
                         this.listCategory();
                         break;
                 case "6":
                         this.listPatrimonyByCategory();
                         break;
                 case "7":
                         this.listPatrimonyByLocation();
                         break;
                 case "8":
                         this.searchPatrimonyByCode();
                         break;
                 case "9":
                         this.searchPatrimonyByName();
                         break;
                 case "10":
                         this.searchPatrimonyByDescription();
                         break;
                 case "11":
                         this.movePatrimony();
                         break;
                 case "12":
                         this.generateReport();
                         break;
                 default:
                        m.setText("Voçê não digitou uma opção valída,tente novamente");
                        m.setChatId(u.getMessage.getChatId());
                        try
                           {execute(m);}
                        catch(TelegramApiException e)
                            { e.printStackTrace; }
                        break;
                        
               }
           }
      }
         
                 
                   
        
        
            


            
   


    @Override
    public void registerLocation(SendMessage m,Update u)
    {
          Localizacao l = new Localizacao();
          bool aux = true;
          m.setChatId(u.getMessage.getChatId());
          while(aux)
          {
              m.setText("digite um nome para a localização a ser criada:");
              try
                 {execute(m);}
              catch(TelegramApiException e)
                 { e.printStackTrace; }
               try
                  {
                      String n = u.getMessage().getText();
                       Check.checkName(locs,n);
                       aux = false;
                       l.setName(n);
                       
                       
                  }
               catch(Exception e)
                  { 
                      m.setText("esse nome já foi cadastrado tente outro por favor");
                        try
                           {execute(m);}
                        catch(TelegramApiException e)
                            { e.printStackTrace; } 
                   }
           }
           aux = true;
           while(aux)
           {
                m.setText("digite uma descrição para a localização a ser criada:");
                try
                    {execute(m);}
                catch(TelegramApiException e)
                    { e.printStackTrace; }
                String d = u.getMessage().getText();
                l.setDescription(d);
                aux = false;
                locs.add(l);
                m.setText("Localização ,criada com sucesso");
                try
                    {execute(m);}
                catch(TelegramApiException e)
                    { e.printStackTrace; }
                
            }
           
     }

    @Override
    public void registerCategory(SendMessage m,Update u) {


    }

    @Override
    public void registerPatrimony(SendMessage m,Update u) 
    {

    }

    @Override
    public void listLocation(SendMessage m,Update u)
    {

    }

    @Override
    public void listCategory(SendMessage m,Update u)
        {
);
    }

    @Override
    public void listPatrimonyByLocation(SendMessage m,Update u) 
    {

    }
    @override
    public void listPatrimonyByCategory(SendMessage m,Update u)
    {
    }

    @Override
    public void searchPatrimonyByCode(SendMessage m,Update u) 
    {

    }

    @Override
    public void searchPatrimonyByName(SendMessage m,Update u) 
    {

    }

    @Override
    public void searchPatrimonyByDescription(SendMessage m,Update u) 
    {

    }

    @Override
    public void movePatrimony(SendMessage m,Update u) 
    {

    }

    @Override
    public void generateReport(SendMessage m,Update u) 
    {

    }
}


}
