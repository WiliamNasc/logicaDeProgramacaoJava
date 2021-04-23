package com.programacao.logica.java.lote_1_1;

import com.programacao.logica.java.utilitarios.*;

public class Exercicio15 implements Exercicio {
    @Override
    public void visualizarEnunciado() {
        MensagemPersonalizada.mensagemInformacao(
                "Receba os valores de 2 catetos de um triângulo retângulo."
                .concat("\n")
                .concat("Calcule e mostre a hipotenusa.")
                .concat("\n\n")
                .concat("Fórmula:")
                .concat("\n")
                .concat("A² + B² = C²"
                .concat("\n")
                .concat("raiz quadrada de C² = hipotenusa")),
                "Enunciado"
        );
    }

    @Override
    public void visualizarResposta() {
        MensagemPersonalizada.mensagemInformacao(
                "Hipotenusa: "
                .concat(FormataTexto
                        .valorComCasasDecimais("2",
                        CalculoMatematico.calcularHipotenusa(this.a, this.b))
                ) ,
                "Exercício 15"
        );
    }

    @Override
    public void solicitarDadosUsuario() {
        this.a = CaixaDeDialogoPersonalizada.caixaDouble("A");
        this.b = CaixaDeDialogoPersonalizada.caixaDouble("B");
    }

    private double a = 0, b = 0;
}
