package com.programacao.logica.java.lote_1_1;

import com.programacao.logica.java.utilitarios.*;

public class Exercicio28 implements Exercicio {
    @Override
    public void visualizarEnunciado() {
        MensagemPersonalizada.mensagemInformacao(
                "Receba o preço atual e a média mensal de um produto."
                .concat("\n")
                .concat("Calcule e mostre o novo preço sabendo que:")
                .concat("\n")
                .concat("Venda Mensal        Preço Atual      Preço Novo")
                .concat("\n")
                .concat("< 500                        < 30                    +10%")
                .concat("\n")
                .concat(">= 500 e < 1000     >= 30 e < 80     +15%")
                .concat("\n")
                .concat(">= 1000                    >= 80                 -5%")
                .concat("\n")
                .concat("Obs.: para outras condições, preço novo será igual ao preço atual."),
                "Enunciado"
        );
    }

    @Override
    public void visualizarResposta() {
        MensagemPersonalizada.mensagemInformacao(
                "Preço novo: "
                .concat("R$ ")
                .concat(
                        FormataTexto.valorComCasasDecimais(
                                "2",
                                retornarPrecoNovo(this.mediaMensalProduto,
                                                  this.precoAtual)
                        )
                ),
                "Exercício 28"
        );
    }

    @Override
    public void solicitarDadosUsuario() {
        this.precoAtual = CaixaDeDialogoPersonalizada.caixaDouble("Preço atual");
        this.mediaMensalProduto = CaixaDeDialogoPersonalizada.caixaDouble("Média mensal");
    }

    private double precoAtual = 0, mediaMensalProduto = 0;

    private double determinarReajustePrecoNovo(double mediaMensalProduto,
                                               double precoAtual){
        if (mediaMensalProduto < 500 && precoAtual < 30)
            return CalculoMatematico.simplificarPorcentagem(10);
        else if ((mediaMensalProduto >= 500 && mediaMensalProduto < 1000)
        && (precoAtual >= 30 && precoAtual < 80))
            return CalculoMatematico.simplificarPorcentagem(15);
        else if (mediaMensalProduto >= 1000 && precoAtual >= 80)
            return CalculoMatematico.simplificarPorcentagem(-5);
        else
            return precoAtual;
    }

    private double retornarPrecoNovo(double mediaMensalProduto,
                                     double precoAtual){
        return  precoAtual +
                (precoAtual * determinarReajustePrecoNovo(mediaMensalProduto,
                        precoAtual)
                );
    }
}