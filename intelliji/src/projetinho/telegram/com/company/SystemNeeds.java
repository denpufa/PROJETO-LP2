package projetinho.telegram.com.company;
/**
 * @brief  SystemNeeds Interface is responsible for ...
 */
public interface SystemNeeds {
    void registerLocation();
    void registerCategory();
    void registerPatrimony();
    void listLocation();
    void listCategory();
    void listPatrimonyByCategory();
    void listPatrimonyByLocation();
    void searchPatrimonyByCode();// obs: devera mostrar a loc caso encontrado!!
    void searchPatrimonyByName();
    void searchPatrimonyByDescription();
    void movePatrimony(); // obs:  entre as localizacoes !!
    void generateReport();
}
