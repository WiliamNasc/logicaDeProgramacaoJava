package com.programacao.logica.java.lote_1_1;

import com.programacao.logica.java.utilitarios.*;

public class Exercicio8 implements Exercicio {
    @Override
    public void visualizarEnunciado() {
        MensagemPersonalizada.mensagemInformacao(
                "Receba o valor de um depósito em poupança.\n"
                        .concat("Calcule e mostre o valor,após 1 mês de aplicação, \n")
                        .concat(" sabendo que rende 1,3% a. m.")
                        .concat("\n\n")
                        .concat("Fórmula: depósito + (depósito * 0,13) x meses aplicados."),
                "Enunciado"

        );
    }

    @Override
    public void visualizarResposta() {
        MensagemPersonalizada
                .mensagemInformacao(
                    "O rendimento foi de: "
                    .concat(FormataTexto
                            .valorComCasasDecimais("2",
                                                    calcularRendimentoPoupanca(
                                                    this.deposito, this.mesesReajuste)
                            )
                    ),
                     "Exercício 8"
                )
        ;
    }

    @Override
    public void solicitarDadosUsuario() {
        this.deposito = CaixaDeDialogoPersonalizada
                .caixaDouble("Depósito");
        this.mesesReajuste = CaixaDeDialogoPersonalizada
                .caixaInteger("Meses a serem aplicados");
    }

    private double deposito = 0;
    private int mesesReajuste = 0;

    private double calcularRendimentoPoupanca (double deposito, int mesesAplicados) {
        return deposito + (deposito * CalculoMatematico
                            .simplificarPorcentagem(1.3)) * mesesAplicados;
    }
}