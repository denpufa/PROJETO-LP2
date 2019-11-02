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
         m.setChatId(u.getMessage.getChatId());
         m.setText("digite um nome para a localização a ser criada:");
          try
             {execute(m);}
          catch(TelegramApiException e)
             { e.printStackTrace; }
           try
              {String n = u.getMessage().getText();}
           catch(Exception e)
              {
              
           
     
        
            
        
    }

    @Override
    public void registerCategory() {


    }

    @Override
    public void registerPatrimony() {

    }

    @Override
    public void listLocation()
    {

    }

    @Override
    public void listCategory()
        {
);
    }

    @Override
    public void listPatrimonyByLocation() {

    }
    @override
    public void listPatrimonyByCategory()
    {
    }

    @Override
    public void searchPatrimonyByCode() {

    }

    @Override
    public void searchPatrimonyByName() {

    }

    @Override
    public void searchPatrimonyByDescription() {

    }

    @Override
    public void movePatrimony() {

    }

    @Override
    public void generateReport() {

    }
}


}
