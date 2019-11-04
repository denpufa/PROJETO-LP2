package projetinho.telegram.com.company;
public class Check throws ExceptionHave
{
    public static void checkName(ArrayList a,String s) 
    {
        for(int i=0;i<a.size();i++)
        {
            if(s.equals(a.get(i).getName()))
            {
              throw  new ExceptionHave();
              break;
             }
         }
     }
     
     public static void checkCode(ArrayList a,String s)
     {
       int help = s.parseInt(s);
       for(int i = 0;i<a.size();i++)
       {
            if(help == a.get(i).getCode())
            {
                throw new ExceptionHave();
                break;
             }
        }
      }
      
      public static void checkIfNameOn(Arraylist a,String s)
      {
            for(int i = 0;i<a.size();i++)
            {
               if(s.equals(a.get(i).getName())
               {
                    return;
               }
             throw new ExceptionHave();
             break;
        }
        
  }
