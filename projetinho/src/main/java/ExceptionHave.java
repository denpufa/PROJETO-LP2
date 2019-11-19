/**
 * @brief  ExceptionHave class is responsible the exceptions.
 */
public class ExceptionHave extends Exception
{
    public String getMessage(   )
    {
        return "Esse nome já existe na lista de nomes cadastrados para este tipo";
    }
}
