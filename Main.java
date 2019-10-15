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

}

class Main {
 
 public static void main(String[]args)
 {
     
    Scanner ler = new Scanner(System.in);
 }        

}
