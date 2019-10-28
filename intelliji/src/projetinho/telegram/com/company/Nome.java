package projetinho.telegram.com.company;

public abstract class Nome {

    //campos
    protected  String nome;
    protected String descricao;


    //set's e get's
    public void setNome(String n)
    {
        nome = n;
    }
    public void setDescricao(String d)
    {
        descricao = d;
    }
    public String getNome()
    {
        return nome;
    }
    public String getDescricao()
    {
        return descricao;
    }
}
