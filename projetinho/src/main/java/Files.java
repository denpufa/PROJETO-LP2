/**
 * @brief  Imported libraries.
 * */
import org.json.simple.JSONObject;

/**
 * @brief  Files interface is responsible for structure the Jsons class.
 */
public interface Files {
    default void add() {}
    void write();
    void charge();
    void initialCharge(JSONObject json);

}
