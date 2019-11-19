
/**
 * @brief  ModelP class is responsible for structure the patrimony Json.
 */
public class ModelP{

    /**
     * @brief ModelP class attributes.
     */
    private String bName;
    private String bDesc;
    private String bCode;
    private String lName;
    private String lDesc;
    private String cCode;
    private String cName;
    private String cDesc;

    /**
     * @brief  Standardized Constructor.
     * @param  //Patrimony, Location, PatrimonyCategory.
     */
    public ModelP(Patrimony patrimony) {
        this.bName = patrimony.getName();
        this.bDesc = patrimony.getDescription();
        this.bCode = patrimony.getCode();
        this.lName = patrimony.getLocation().getName();
        this.lDesc = patrimony.getLocation().getDescription();
        this.cCode = patrimony.getCategory().getCode();
        this.cName = patrimony.getCategory().getName();
        this.cDesc = patrimony.getCategory().getDescription();
    }

    /**
     * @brief Setters.
     */
    public void setbName(String bName) {
        this.bName = bName;
    }
    public void setbDesc(String bDesc) {
        this.bDesc = bDesc;
    }
    public void setbCode(String bCode) {
        this.bCode = bCode;
    }
    public void setlName(String lName) {
        this.lName = lName;
    }
    public void setlDesc(String lDesc) {
        this.lDesc = lDesc;
    }
    public void setcCode(String cCode) {
        this.cCode = cCode;
    }
    public void setcName(String cName) {
        this.cName = cName;
    }
    public void setcDesc(String cDesc) {
        this.cDesc = cDesc;
    }

    /**
     * @brief Getters.
     */
    public String getbCode() {
        return bCode;
    }
    public String getbName() { return bName;}
    public String getbDesc() { return bDesc;}
    public String getlName() {
        return lName;
    }
    public String getlDesc() {
        return lDesc;
    }
    public String getcCode() {
        return cCode;
    }
    public String getcName() {
        return cName;
    }
    public String getcDesc() {
        return cDesc;
    }

    /**
     * @brief Method print.
     */
    public void print(){
        System.out.println(getbCode()+"/"+ getbDesc()+"/"+getbName()+"/"+getlName()+"/"+getlDesc()+"/"+getcName()+"/"+getcDesc()+"/"+getcCode());
    }




}
