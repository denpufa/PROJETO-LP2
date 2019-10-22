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
   //objeto para leitura de dados
   Scanner Entrada = new Scanner(System.in);
   
   //campos
   private ArrayList<Localizacao> locs;
   private ArrayList<CategoriadeBem> catego;
   private ArrayList<Bem> bems;
   
   //méétodos para as obrigações do sistema
   public void cadastrarLocalizacao()
  {
    Localizacao obj = new Localizacao();
    Systeam.out.prinln("digite o nome da localizacao: \n");
    String aux = Entrada.next();
    obj.setNome(aux); 
    Systeam.out.println("digite uma breve descrição para a localização: \n");
    aux = Entrada.next();
    obj.setDescricao(aux);
    locs.add(obj);
    return;

  }

  public void cadastrarCategoria()
  {
    CategoriadeBem ca = new CategoriadeBem();
    Systeam.out.println("digite o nome da Categoria: \n");
    String aux;
    aux = Entrada.next();
    ca.setNome(aux);
    System.out.println("Digite uma breve descricao da categoria: \n");
    aux = Entrada.next();
    ca.setDescricao(aux);
    System.out.println("digite um codigo para a categoria: \n");
    int auxtwo;
    auxtwo = Entrada.nextInt();
    ca.setCodigo(auxtwo);
    catego.add(ca);
    return;

  }

  //Falta terminar!!
  public void cadastrarbem()
  {
    Bem b = new Bem();
    System.out.println("digite um nome para o seu bem: \n");
    String aux;
    aux = Entrada.next();
    b.setNome(aux);
    
    System.out.println("digite uma breve descricao para o seu bem: \n");
    aux = next();
    b.setDescricao(aux);
    
    System.out.println("digite um código para o seu bem: \n");
    int auxtwo;
    auxtwo = Entrada.nextInt();
    b.setCodigo(auxtwo);
    
    System.out.println("digite  o nome de uma  categoria para seu bem: ");
    aux = Entrada.next();
    for(int i = 0;i<catego.size();i++)
    {
        if(catego.get(i).getNome() == aux)
        {
          b.setCategoria(catego.get(i));
          break;
        }
    }
    
    System.out.println("Digite  um nome de uma localizacão para o seu bem: \n");
    aux = Entrada.next();
    for(int i = 0;i<locs.size();i++)
    {
      if(locs.get(i).getNome() == aux)
      {
        b.setLocalizacao(locs.get(i));
        break;
      }
    }
    
    bems.add(b);
    return;
    
    


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
  private int codigo;
  private Localizacao loc;
  private Categoria ca;
  
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
  private int codigo;
  private Localizacao loc;
  private Categoria ca;
  
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
  public int setCategoria(Categoria ca)
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
