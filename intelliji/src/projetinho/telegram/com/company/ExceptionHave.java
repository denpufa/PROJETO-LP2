
package projetinho.telegram.com.company;
import java.io.*;

public class ExceptionHave extends Exception
{
    public String getMessage()
    {
        return "esse nome já existe na lista de nomes cadastrados para este tipo";
     }
 }
