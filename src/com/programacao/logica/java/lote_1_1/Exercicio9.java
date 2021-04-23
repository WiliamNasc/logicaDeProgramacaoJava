package com.programacao.logica.java.lote_1_1;

import com.programacao.logica.java.utilitarios.FormataTexto;
import com.programacao.logica.java.utilitarios.CaixaDeDialogoPersonalizada;
import com.programacao.logica.java.utilitarios.Exercicio;
import com.programacao.logica.java.utilitarios.MensagemPersonalizada;

public class Exercicio9 implements Exercicio {
    @Override
    public void visualizarEnunciado() {
        MensagemPersonalizada.mensagemInformacao(
                "Receba os 2 números inteiros.\n"
                .concat("Calcule e mostre a soma dos quadrados.")
                .concat("\n\n")
                .concat("Fórmula: a² + b²."),
                "Enunciado"
        );
    }

    @Override
    public void visualizarResposta() {
        MensagemPersonalizada
            .mensagemInformacao(
                "A soma dos quadrados é: "
                .concat(FormataTexto
                        .valorComCasasDecimais("2",
                                                calcularSomaQuadrados(this.valor1,
                                                                      this.valor2)
                        )
                )    ,
                "Exercício 9"
            );
    }

    @Override
    public void solicitarDadosUsuario() {
        this.valor1 = CaixaDeDialogoPersonalizada.caixaInteger("Valor1");
        this.valor2 = CaixaDeDialogoPersonalizada.caixaInteger("Valor2");
    }

    private int valor1 = 0, valor2 = 0;

    private double calcularSomaQuadrados(int valor1, int valor2){
        return Math.pow(valor1, 2) + Math.pow(valor2, 2);
    }
}