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

    public static void checkNameC(ArrayList<PatrimonyCategory> a,String s) throws ExceptionHave
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
     
     public static void checkCodeP(ArrayList<Patrimony> a,int s) throws ExceptionHave
     {

       for(int i = 0;i<a.size();i++)
       {
            if(s == a.get(i).getCode())
            {
                throw new ExceptionHave();
                //break;
             }
        }
     }


    public static void checkCodeC(ArrayList<PatrimonyCategory> a,String s) throws ExceptionHave
    {
        int help = parseInt(s);

        for(int i = 0;i<a.size();i++)
        {
            if(help == a.get(i).getCode())
            {
                throw new ExceptionHave();
                //break;
            }
        }
    }
    public static void checkIfNameOnP(ArrayList<Patrimony> a, String s) throws ExceptionHave
    {
        for(int i = 0;i<a.size();i++)
        {
            if(s.equals(a.get(i).getName()))
            {
                //return a.get(i);
            }
            throw new ExceptionHave();
            //break;

        }

    }

    public static void checkIfNameOnPC(ArrayList<PatrimonyCategory> a,String s) throws ExceptionHave
    {
        for(int i = 0;i<a.size();i++)
        {
            if(s.equals(a.get(i).getName()))
            {
                //return a.get(i);
            }
            throw new ExceptionHave();
            //break;
        }
    }

    public static boolean checkIfNameOnL(ArrayList<Location> a, String s)
    {
        for(int i = 0; i< a.size();i++)
        {
            if(s.equals(a.get(i).getName()))
            {
                return true;
            }

        }
        return false;
    }
}
