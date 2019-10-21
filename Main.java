import java.util.ArrayList;
import java.util.Scanner;

//clsse usada como molde para todas as classes do sistema.Cuidado ao mexer!
public  abstract class   Nome
{
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

//classe que estara a disposição do usuario
public class Menu implements SistemaNeeds
{


}


//metodos das funcionalidades do bot!!
public interface SistemaNeeds
{
  void cadastrarLocalizacao();
  void cadastrarCategoria();
  void cadastrarbem();
  void listarLocalizacao();
  void listarCategoria();
  void listarBemPorLocalizacao();
  void buscarBemPorCodigo();// obs: devera mostrar a loc caso encontrado!!
  void buscarBemPorNome();
  void buscarBemPorDescricao();
  void MovimentarBem(); // obs:  entre as localizacoes !!
  void gerarRelatorio();


}

//classe que cadastra uma localização possivel para os bem's!
public class Localizacao extends Nome
{
  //construtor(es)
  Localizacao(String n,String d)
  {
      nome = n;
      descricao = d;
  }
  Localizacao(){}
}

//classe que separa os Bem's por categorias!
public class CategoriadeBem extends Nome
{
  //campos
  private int codigo;

  //set's e get's
  public int setCodigo(int c)
  {
    codigo = c;

  }
   public int getCodigo()
  {
    return codigo;
  }

  //construtor(es)
  CategoriadeBem(String n,String d,int c)
  {
    nome = n;
    descricao = d;
    codigo = c;
  }
  
  CategoriadeBem(){}




}

public class Bem extends Nome
{
  //campos
  int codigo;
  Localizacao loc;
  Categoria ca;
  
  //set's e get's
   public int setCodigo(int c)
  {
    codigo = c;

  }
   public int getCodigo()
  {
    return codigo;
  }

  //construtor(es)
  CategoriadeBem(String n,String d,int c)
  {
    nome = n;
    descricao = d;
    codigo = c;
  }
  
  CategoriadeBem(){}




}

public class Bem extends Nome
{
  //campos
  int codigo;
  Localizacao loc;
  Categoria ca;
  
  //set's e get's
  public void setCodigo(int c)
  {
    codigo = c;

  }
   public int getCodigo()
  {
    return codigo;
  }
  public void setLocalizacao(Localizacao l)
  {
    loc = l;

  }
   public Localizacao getLocalizacao()
  {
    return loc;
  }
  public int setCategoria(int ca)
  {
    this.ca = ca;

  }
   public Categoria getCategoria()
  {
    return ca;
  }
  
  
  
  //construtores
  
  
  

}

class Main {
 
 public static void main(String[]args)
 {
     
    Scanner ler = new Scanner(System.in);
 }        

}
