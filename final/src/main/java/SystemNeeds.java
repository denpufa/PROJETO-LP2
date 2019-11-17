
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;

/**
 * @brief  SystemNeeds Interface is responsible for ...
 */
public interface SystemNeeds {
    void moverL(Update u);
    void procurabyD(Update u);
    void procuraByN(Update u);
    void procuraByC(Update u);
    void listarLocbyP(Update u);
    void listarCat(Update u);
    void listarLoc(Update u);
    void cadastrarCate(Update u);// obs: devera mostrar a loc caso encontrado!!
    void cadastrarPatri(Update u);
    void cadastrarLoc(Update u);

}
