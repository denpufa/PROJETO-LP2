

public class Model {
    private String bName;
    private String bDesc;
    private String bCode;
    private String lName;
    private String lDesc;
    private String cCode;
    private String cName;
    private String cDesc;

    public Model(Patrimony patrimony, Location location, PatrimonyCategory category) {
        this.bName = patrimony.getName();
        this.bDesc = patrimony.getDescription();
        this.bCode = patrimony.getCode();
        this.lName = location.getName();
        this.lDesc = location.getDescription();
        this.cCode = category.getCode();
        this.cName = category.getName();
        this.cDesc = category.getDescription();
    }


    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getbDesc() {
        return bDesc;
    }

    public void setbDesc(String bDesc) {
        this.bDesc = bDesc;
    }

    public String getbCode() {
        return bCode;
    }

    public void setbCode(String bCode) {
        this.bCode = bCode;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getlDesc() {
        return lDesc;
    }

    public void setlDesc(String lDesc) {
        this.lDesc = lDesc;
    }

    public String getcCode() {
        return cCode;
    }

    public void setcCode(String cCode) {
        this.cCode = cCode;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcDesc() {
        return cDesc;
    }

    public void setcDesc(String cDesc) {
        this.cDesc = cDesc;
    }

    public void print(){
        System.out.println(getbCode()+"/"+ getbDesc()+"/"+getbName()+"/"+getlName()+"/"+getlDesc()+"/"+getcName()+"/"+getcDesc()+"/"+getcCode());
    }




}
