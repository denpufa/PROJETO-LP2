package projetinho.telegram.com.company;

public interface SistemaNeeds {
    void cadastrarLocalizacao();
    void cadastrarCategoria();
    void cadastrarbem();
    void listarLocalizacao();
    void listarCategoria();
    void listarBemPorLocalizacao();
    void buscarBemPorCodigo();// obs: devera mostrar a loc caso encontrado!!
    void buscarBemPorNome();
    void buscarBemPorDescricao();
    void movimentarBem(); // obs:  entre as localizacoes !!
    void gerarRelatorio();
}
