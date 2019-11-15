
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;

/**
 * @brief  SystemNeeds Interface is responsible for ...
 */
public interface SystemNeeds {
    void registerLocation(SendMessage m,Update u);
    void registerCategory(SendMessage m,Update u);
    void registerPatrimony(SendMessage m,Update u);
    void listLocation(SendMessage m,Update u);
    void listCategory(SendMessage m,Update u);
    void listPatrimonyByCategory(SendMessage m,Update u);
    void listPatrimonyByLocation(SendMessage m,Update u);
    void searchPatrimonyByCode(SendMessage m,Update u);// obs: devera mostrar a loc caso encontrado!!
    void searchPatrimonyByName(SendMessage m,Update u);
    void searchPatrimonyByDescription(SendMessage m,Update u);
    void movePatrimony(SendMessage m,Update u); // obs:  entre as localizacoes !!
    void generateReport(SendMessage m,Update u);
}
