package com.programacao.logica.java.lote_1_1;

import com.programacao.logica.java.utilitarios.*;

public class Exercicio29 implements Exercicio {
    @Override
    public void visualizarEnunciado() {
        MensagemPersonalizada.mensagemInformacao(
                "Receba o tipo de investimento (1 = poupança e 2 = renda fixa)"
                .concat("\n")
                .concat("e o valor do investimento.")
                .concat("\n")
                .concat("Calcule e mostre o valor corrigido em 30 dias")
                .concat("\n")
                .concat("sabendo que a poupança = 3% e a renda fixa = 5%.")
                .concat("\n")
                .concat("Demais tipos não serão considerados."),
                "Enunciado"
        );
    }

    @Override
    public void visualizarResposta() {
        MensagemPersonalizada.mensagemInformacao(
                "Valor corrigido, após 30 dias: "
                .concat("R$ ")
                .concat(FormataTexto.valorComCasasDecimais(
                        "2",
                        retornarValorCorrigido(
                                this.tipoInvestimento,
                                this.valorInvestimento
                        )
                )),
                "Exercício 29"
        );
    }

    @Override
    public void solicitarDadosUsuario() {
        this.tipoInvestimento = CaixaDeDialogoPersonalizada.caixaInteger("Tipo de investimento");
        this.valorInvestimento = CaixaDeDialogoPersonalizada.caixaDouble("Valor do investimento");
    }

    private int tipoInvestimento = 0;
    private double valorInvestimento = 0;

    private double calcularRendimentoPoupanca(double valorInvestimento){
        return valorInvestimento + (valorInvestimento * CalculoMatematico.simplificarPorcentagem(
                3
        ));
    }

    private double calcularRendimentoRendaFixa(double valorInvestimento){
        return valorInvestimento + (valorInvestimento * CalculoMatematico.simplificarPorcentagem(
                5
        ));
    }

    private double retornarValorCorrigido(double tipoInvestimento, double valorInvestimento){
        if (tipoInvestimento == 1)
            return calcularRendimentoPoupanca(valorInvestimento);
        else if (tipoInvestimento == 2)
            return calcularRendimentoRendaFixa(valorInvestimento);
        else
            return valorInvestimento;
    }
}