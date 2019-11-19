/**
 * @brief  Imported libraries.
 * */
import java.util.ArrayList;

/**
 * @brief  Check class is responsible for check certain conditions.
 */
public class Check
{
    /**
     * @brief  Method checkNameL is responsible for check if location name exists.
     * */
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

    /**
     * @brief  Method existeL is responsible for check if this location name already exists.
     * */
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

    /**
     * @brief  Method existeL is responsible for check if this Category name already exists.
     * */
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


    /**
     * @brief  Method existeL is responsible for check if this patrimony code already exists.
     * */
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

    /**
     * @brief  Method existeL is responsible for check if this category code already exists.
     * */
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
