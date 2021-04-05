package com.programacao.logica.java.utilitarios;

public interface MenuLote {
    void avaliarOpcao(int opcao, Exercicio[] lista);
    void executarMenu();
    String montarMenu();
    default String adicionarConteudo(String tipo, String... conteudo){
        return
                "<".concat(tipo).concat(">")
                        .concat(devolverEstrutura(conteudo))
                        .concat("</").concat(tipo).concat(">");
    }
    default String adicionarConteudoPorQtde(String tipo, int qtdeConteudo , String... itens){
        String estrutura = "";
        for (int i = 0; i < qtdeConteudo; i++){
            estrutura += adicionarConteudo(tipo, itens[i]);
        }
        return estrutura;
    }
    default String adicionarConteudoPorQtde(String tipo, int qtdeConteudo , String itens){
        String estrutura = "";
        for (int i = 0; i < qtdeConteudo; i++){
            estrutura += adicionarConteudo(tipo, itens);
        }
        return estrutura;
    }
    default String adicionarEstilo(String... conteudo){
        return adicionarConteudo(
                "style",
                devolverEstrutura(conteudo)
        );
    }
    default String definirCabecalho(String... conteudo){
        return adicionarConteudo(
                "head",
                devolverEstrutura(conteudo)
        );
    }
    default String definirCorpo(String... conteudo){
        return adicionarConteudo(
                "body",
                devolverEstrutura(conteudo)
        );
    }
    default String definirEstruturaPrincipal(String... conteudo){
        return adicionarConteudo(
                "html",
                devolverEstrutura(conteudo));
    }
    default String devolverEstrutura(String... conteudo){
        int i = 0;
        String estrutura = "";
        while(i < conteudo.length){
            estrutura += conteudo[i];
            i++;
        }
        return estrutura;
    }
    default String[] retornaritensPorLimite(String[] lista, int inicio, int fim){
        avaliarLimiteFornecido(inicio,fim);
        String[] listaLimitada = new String[fim - inicio];
        int aux = 0;
        for (int i = inicio; i < fim; i++){
            listaLimitada[aux] = lista[i];
            aux++;
        }
        return listaLimitada;
    }
    private void avaliarLimiteFornecido(int inicio, int fim) throws NegativeArraySizeException{
        if (inicio > fim){
            System.out.println("Erro, valores de limite (inicio, e fim) inconsistentes.");
        }
    }
}
