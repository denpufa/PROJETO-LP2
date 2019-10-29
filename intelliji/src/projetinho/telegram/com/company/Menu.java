package projetinho.telegram.com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu implements SystemNeeds
{
    /**
     * @brief Patrimony class attributes.
     */
    Scanner Entrada = new Scanner(System.in);
    private ArrayList<Location> locs;
    private ArrayList<PatrimonyCategory> category;
    private ArrayList<Patrimony> patrimonies;

    /**
     * @brief Mandatory methods of SystemNeeds
     */



    //Falta terminar!!
    public void cadastrarbem()
    {

    }

    public void listarLocalizacao()
    {
        System.out.println("Localizações abaixo:\n ")
        for(int i = 0;i<locs.size();i++)
        {
            System.out.println(locs.get(i).getNome() + "\n");
        }
    }


    public void listarCategoria()
    {
        System.out.println("Categorias de bem abaixo:\n ");
        for(int i = 0;i<catego.size();i++)
        {
            System.out.println(catego.get(i).getNome() + "\n");
        }
    }

    public void listarBemPorLocalizacao()
    {
        String aux;
        System.out.println("Escolha uma localização abaixo para listar o bem's nela contido:\n ");
        this.listarLocalizacao();
        System.out.println("Digite o nome de uma: ");
        aux = Entrada.next();
        for(int i = 0;i<bems.size();i++)
        {
            if(bems.get(i).getLocalizacao() == aux)
                System.out.println(bems.get(i).getLocalizacao() + "\n");
        }
    }

    public void buscarBemPorCodigo()
    {
        int aux;
        System.out.println("Digite um código: ");
        aux = Entrada.nextInt();
        for(int i = 0;i<bems.size();i++)
        {
            if(bems.get(i).getCodigo() == aux)
                System.out.println("Bem encontrado! " +"Sua localização: " +  bems.get(i).getLocalizacao() + "\n");
            return;
        }
        System.out.prinln("Bem não encontrado!");

    }

    public void buscarBemPorNome()
    {
        String aux;
        System.out.println("Digite um nome: ");
        aux = Entrada.next();
        for(int i = 0;i<bems.size();i++)
        {
            if(bems.get(i).getNome() == aux)
                System.out.println("Bem encontrado! " +"Sua localização: " +  bems.get(i).getLocalizacao() + "\n");
            return;
        }
        System.out.prinln("Bem não encontrado!");

    }

    public void buscarBemPorDescricao()
    {
        String aux;
        System.out.println("Digite uma descrição: ");
        aux = Entrada.next();
        for(int i = 0;i<bems.size();i++)
        {
            if(bems.get(i).getDescricao() == aux)
                System.out.println("Bem encontrado! " +"Sua localização: " +  bems.get(i).getLocalizacao() + "\n");
            return;
        }
        System.out.prinln("Bem não encontrado!");

    }

    //para fazer!!
    public void movimentarBem()
    {

    }
    //para fazer!!
    public void gerarRelatorio()
    {
    }


    @Override
    public void registerLocation() {
        Location obj = new Location();
        System.out.prinln("digite o nome da localizacao: \n");
        String aux = Entrada.next();
        obj.setName(aux);
        System.out.println("digite uma breve descrição para a localização: \n");
        aux = Entrada.next();
        obj.setDescription(aux);
        locs.add(obj);
        return;
    }

    @Override
    public void registerCategory() {

        int code;
        String name;
        String description;

        Systeam.out.println("digite o nome da Categoria: \n");
        name = Entrada.next();

        System.out.println("Digite uma breve descricao da categoria: \n");
        description = Entrada.next();

        System.out.println("digite um codigo para a categoria: \n");
        code = Entrada.nextInt();

        PatrimonyCategory ca = new PatrimonyCategory(code, name, description);

        category.add(ca);

        return;
    }

    @Override
    public void registerPatrimony() {

        int code;
        String name;
        String description;
        String category;
        String location;

        System.out.println("digite um nome para o seu bem: \n");
        name = Entrada.next();

        System.out.println("digite uma breve descricao para o seu bem: \n");
        description = Entrada.next();


        System.out.println("digite um código para o seu bem: \n");
        code = Entrada.nextInt();

        System.out.println("digite  o nome de uma  categoria para seu bem: ");
        category = Entrada.next();



//        for(int i = 0;i< category.size();i++)
//        {
//            if(category.get(i).getNome() == category)
//            {
//                b.setCategoria(catego.get(i));
//                break;
//            }
//        }

        System.out.println("Digite  um nome de uma localizacão para o seu bem: \n");
         location = Entrada.next();

//        for(int i = 0;i<locs.size();i++)
//        {
//            if(locs.get(i).getNome() == aux)
//            {
//                b.setLocalizacao(locs.get(i));
//                break;
//            }
//        }

        Patrimony b = new Patrimony(code, );
        patrimonies.add(b);
        return;
    }

    @Override
    public void listLocation() {

    }

    @Override
    public void listCategory() {

    }

    @Override
    public void listPatrimonyByLocation() {

    }

    @Override
    public void searchPatrimonyByCode() {

    }

    @Override
    public void searchPatrimonyByName() {

    }

    @Override
    public void searchPatrimonyByDescription() {

    }

    @Override
    public void movePatrimony() {

    }

    @Override
    public void generateReport() {

    }
}


}