package projetinho.telegram.com.company;

public class Bem {

    //classe para representar cada bem material!
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
        Bem() {}



    }
}
