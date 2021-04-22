package com.programacao.logica.java.lote_1_1;

import com.programacao.logica.java.utilitarios.*;

public class Exercicio11 implements Exercicio {
    @Override
    public void executarExercicio() {
        visualizarEnunciado();
        solicitarDadosUsuario();
        visualizarResposta();
    }

    @Override
    public void visualizarEnunciado() {
        MensagemPersonalizada.mensagemInformacao(
                "Receba o raio de uma circuferência"
                .concat("\n")
                .concat("Calcule e mostre o comprimento da circunferência.")
                .concat("\n\n")
                .concat("Fórmula: C = 2 x PI x raio."),
                "Enunciado"
        );
    }

    @Override
    public void visualizarResposta() {
        MensagemPersonalizada.mensagemInformacao(
                "O comprimento da circunferência é: "
                .concat(
                        FormataTexto.valorComCasasDecimais("2",
                                CalculoMatematico
                                        .calcularComprimentoCircuferencia(this.raio)        )

                ),
                "Exercício 11"
        );
    }

    @Override
    public void solicitarDadosUsuario() {
        this.raio = CaixaDeDialogoPersonalizada.caixaDouble("Insira o valor do raio");
    }

    private double raio = 0;
}