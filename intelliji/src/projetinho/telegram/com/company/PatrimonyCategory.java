package projetinho.telegram.com.company;

public class PatrimonyCategory extends Name {


    private int code;


    public PatrimonyCategory(int code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
