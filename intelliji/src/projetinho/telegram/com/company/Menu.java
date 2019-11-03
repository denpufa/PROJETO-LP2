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

   
    public  void  run() 
    {
        
        bool permanecer = true;
         //inicializando objetos da api do telegram.
         Update u = new Update();
         SendMessage m = new SendMessage();
        while(permanecer)
        {
            

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
         
                 
        /**
     * @brief Mandatory methods of SystemNeeds
     */             
        
        
            


            
   


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
                try
                {
                    locs.add(l);
                    m.setText("Localização ,criada com sucesso");
                    aux = false;
                    try
                        {execute(m);}
                    catch(TelegramApiException e)
                        { e.printStackTrace; }
                
                 }
                 catch(Exeception e)
                 {
                    m.setText("ops,aconteceu um erro!");
                    try
                        {execute(m);}
                    catch(TelegramApiException e)
                        { e.printStackTrace; }
                 }
            }
           
     }

    @Override
    public void registerCategory(SendMessage m,Update u) 
    {
            Category c = new Category();
            bool aux = true;
             m.setChatId(u.getMessage().getChatId());
             while(aux)
             {
                m.setText("digite um código  para a sua categoria de bem:");
                try
                   {execute(m);}
                catch(TelegramApiException e)
                    { e.printStackTrace; }
                String r = u.getMessage().getText();
                try 
                { int co = Integer.parseInt(r);}
                catch (NumberFormatException e)
                {
                    m.setText("código com formato invalído!");
                    continue;
                }
                try
                    {
                    Check.checkCode(category,co);
                    aux = false;
                    c.setCode(co);
                    }
                catch(Exception e)
                    {
                        m.setText("código ja existe!");
                        try
                            {execute(m);}
                        catch(TelegramApiException e)
                            {e.printStackTrace;}
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
                    { e.printStackTrace; }
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
                   { e.printStackTrace; }
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
                        { e.printStackTrace; }
                    
                }
                catch(Exception e)
                {
                    m.setText("ops aconteceu um erro imprevisto,desculpe!");
                    aux = false;
                }
              }
 }
    
    @Override
    public void registerPatrimony(SendMessage m,Update u) 
    {
            Patrimony p = new Patrimony();
            bool aux = true;
             m.setChatId(u.getMessage().getChatId());
             while(aux)
             {
                m.setText("digite um código  para o seu de bem:");
                try
                   {execute(m);}
                catch(TelegramApiException e)
                    { e.printStackTrace; }
                String r = u.getMessage().getText();
                try 
                { int co = Integer.parseInt(r);}
                catch (NumberFormatException e)
                {
                    m.setText("código com formato invalído!");
                    continue;
                }
                try
                    {
                    Check.checkCode(patrimonies,co);
                    aux = false;
                    p.setCode(co);
                    }
                catch(Exception e)
                    {
                        m.setText("código ja existe!");
                        try
                            {execute(m);}
                        catch(TelegramApiException e)
                            {e.printStackTrace;}
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
                    { e.printStackTrace; }
                 String r = u.getMessage().getText();
                 c.setName(r);
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
                   { e.printStackTrace; }
                 String r = u.getMessage().getText();
                 c.setDescription(r);
                }
                aux = true;
                while(aux)
                {
                     m.setText("escolha uma localização para o seu bem pelo número: ");
                     try
                        {execute(m);}
                     catch(TelegramApiException e)
                         { e.printStackTrace; }
                      this.listLocation(m,u);
                     String r = u.getMessage().getText();
                     try 
                        { int co = Integer.parseInt(r);}
                     catch (NumberFormatException e)
                        {
                             m.setText("ops,número em formato errado");
                             continue;
                        }
                     
                    
                    
                    
                    
               
             
           

    }

    @Override
    public void listLocation(SendMessage m,Update u)
    {

    }

    @Override
    public void listCategory(SendMessage m,Update u)
        {

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
