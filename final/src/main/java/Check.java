import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class Check
{
    public static void checkNameL(ArrayList<Location> a,String s) throws ExceptionHave
    {
        for(int i=0;i<a.size();i++)
        {
            if(s.equals(a.get(i).getName()))
            {
              throw  new ExceptionHave();
              //break;
             }
         }
     }
     public static void existeL(ArrayList<Location> l,String n) throws ExceptionHave
     {
         for(int i=0;i<l.size();i++)
         {
             if(n.equals(l.get(i).getName()))
             {
                 return;
                 //break;
             }
         }
         throw  new ExceptionHave();

     }
     public static void existeC(ArrayList<PatrimonyCategory> pc,String a) throws ExceptionHave{
         for(int i = 0;i<pc.size();i++)
         {
             if(a.equals(pc.get(i).getName()))
             {
                 return;
                 //break;
             }
         }
         throw new ExceptionHave();
     }


     
     public static void checkCodeP(ArrayList<Patrimony> a,String s) throws ExceptionHave
     {

       for(int i = 0;i<a.size();i++)
       {
            if(s.equals(a.get(i).getCode()))
            {
                throw new ExceptionHave();
                //break;
             }
        }
     }


    public static void checkCodeC(ArrayList<PatrimonyCategory> a,String s) throws ExceptionHave
    {


        for(int i = 0;i<a.size();i++)
        {
            if(s.equals(a.get(i).getCode()))
            {
                throw new ExceptionHave();
                //break;
            }
        }
    }





}
