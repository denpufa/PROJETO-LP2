import java.util.ArrayList;

public class Check
{
    public static void checkName(ArrayList a,String s) throws ExceptionHave
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
     
     public static void checkCode(ArrayList a,String s) throws ExceptionHave
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
      
      public static <T> checkIfNameOn(Arraylist<T> a,String s) throws ExceptionHave
      {
            for(int i = 0;i<a.size();i++)
            {
               if(s.equals(a.get(i).getName())
               {
                    return a.get(i);
               }
             throw new ExceptionHave();
             break;
        }
        
  }
