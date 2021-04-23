package com.programacao.logica.java.lote_1_1;

import com.programacao.logica.java.utilitarios.*;

public class Exercicio14 implements Exercicio {
    @Override
    public void visualizarEnunciado() {
        MensagemPersonalizada.mensagemInformacao(
                "Receba 2 ângulos de um triângulo."
                .concat("\n")
                .concat("Calcule e mostre o valor do 3º ângulo.")
                .concat("\n\n")
                .concat("Fórmula: ângulo3 = 180 - (ângulo1 - ângulo2)."),
                "Enunciado"
        );
    }

    @Override
    public void visualizarResposta() {
        MensagemPersonalizada.mensagemInformacao(
                "O terceiro ângulo é: "
                .concat(FormataTexto
                        .valorComCasasDecimais("2",CalculoMatematico
                                                               .calcular3anguloDeUmTriangulo(
                                                                       this.angulo1, this.angulo2)
                        )
                ),
                "Exercício 14"
        );
    }

    @Override
    public void solicitarDadosUsuario() {
        this.angulo1 = CaixaDeDialogoPersonalizada.caixaDouble("Ângulo 1");
        this.angulo2 = CaixaDeDialogoPersonalizada.caixaDouble("Ângulo 2");
    }

    private double angulo1 = 0, angulo2 = 0;
}
