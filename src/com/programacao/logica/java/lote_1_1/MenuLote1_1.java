package com.programacao.logica.java.lote_1_1;

import com.programacao.logica.java.utilitarios.CaixaDeDialogoPersonalizada;
import com.programacao.logica.java.utilitarios.Exercicio;
import com.programacao.logica.java.utilitarios.MensagemPersonalizada;
import com.programacao.logica.java.utilitarios.MenuLote;

public class MenuLote1_1 implements MenuLote {
    @Override
    public void avaliarOpcao(int opcao, Exercicio[] lista) {
        if (opcao > 0 && opcao <= lista.length){
            lista[opcao - 1].executarExercicio();
        } else if (opcao == 99) {
            MensagemPersonalizada.mensagemInformacao(
                    "Saindo ...",
                    "Fim da sessão"
            );
        } else {
            MensagemPersonalizada.mensagemAtencao(
                    "Por favor, insira uma opção válida.",
                    "Atenção"
            );
        }
    }

    @Override
    public void executarMenu(){
        int opcaoSelecionada = 0;
        do {
            try{
            opcaoSelecionada = CaixaDeDialogoPersonalizada
                    .caixaInteger(montarMenu());
            avaliarOpcao(opcaoSelecionada, this.listaInstanciaExercicios);
            }catch (NumberFormatException numberFormatException) {
                MensagemPersonalizada.mensagemErro(
                        "Por favor, insira somente números.",
                        "Erro"
                );
            }catch (NullPointerException nullPointerException) {
                MensagemPersonalizada.mensagemAtencao(
                        "Voltando para a página anterior...",
                        "Atenção"
                );
            }
        } while (opcaoSelecionada != 99);
    }

    @Override
    public String montarMenu() {
        return definirEstruturaPrincipal(
            definirCabecalho(
                   adicionarEstilo(
                           "table {width: 500px; background-color: white;}",
                           "td {text-align: left;}",
                           "th {background-color: #D3D3D3}",
                           "table, th, td {border: 1px solid red; border-collapse: collapse;}"
                   )
            ),
            definirCorpo(
                    adicionarConteudo("h1", "Bem vindo ao lote 1.1 !"),
                    adicionarConteudo("dl",
                        adicionarConteudo("dt",
                                adicionarConteudo("h3", "Obs.:")
                        ),
                        adicionarConteudo("dd",
                                          "- Para executar uma atividade, digite o seu número;"),
                        adicionarConteudo("dd",
                                          "- Para sair, digite 99.")
                    ),
                    adicionarConteudo("table",
                        adicionarConteudoPorQtde("tr", 1,
                                adicionarConteudoPorQtde("th", 5, "")
                        ),
                        adicionarConteudoPorQtde("tr", 3,
                                adicionarConteudoPorQtde("td", 5,
                                        retornaritensPorLimite(this.listaEnunciadoExercicios, 0,5)
                                ),
                                adicionarConteudoPorQtde("td", 5,
                                        retornaritensPorLimite(this.listaEnunciadoExercicios, 5, 10)
                                ),
                                adicionarConteudoPorQtde("td", 4,
                                        retornaritensPorLimite(this.listaEnunciadoExercicios, 10, 14)
                                )
                        )
                    )
            )
        );
    }

    private String listaEnunciadoExercicios[] = {
            "1 - Área do quadrado",
            "2 - Novo salário, com reajuste",
            "3 - Área do triângulo",
            "4 - Celsius -> Fahrenheit",
            "5 - Equação de 2º grau (sem validação)",
            "6 - Troca de valores",
            "7 - Volume paralelepípedo",
            "8 - Rendimento poupança",
            "9 - Soma dos quadrados",
            "10 - Diferença entre dois números reais",
            "11 - Comprimento da circunferência",
            "12 - Idade atual, e daqui à 17 anos",
            "13 - Quantidade de dias, de duração de alimentos",
            "14 - Terceiro ângulo, de um triângulo"
    };

    private Exercicio listaInstanciaExercicios[] = {
            new Exercicio1(),
            new Exercicio2(),
            new Exercicio3(),
            new Exercicio4(),
            new Exercicio5(),
            new Exercicio6(),
            new Exercicio7(),
            new Exercicio8(),
            new Exercicio9(),
            new Exercicio10(),
            new Exercicio11(),
            new Exercicio12(),
            new Exercicio13(),
            new Exercicio14()
    };
}