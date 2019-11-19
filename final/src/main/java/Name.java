/**
 * @brief  Locations class is responsible for create scope for other classes.
 */
public abstract class Name {

    /**
     * @brief Name class attributes.
     */
    protected  String name;
    protected String description;

    /**
     * @brief Setters.
     */
    public void setName(String name)
    {
        this.name = name;
    }
    public void setDescription(String description){ this.description = description; }

    /**
     * @brief Setters.
     */
    public String getName(){ return this.name; }
    public String getDescription()
    {
        return this.description;
    }
}
