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
  }
