package com.programacao.logica.java.lote_1_1;

import com.programacao.logica.java.utilitarios.CaixaDeDialogoPersonalizada;
import com.programacao.logica.java.utilitarios.Exercicio;
import com.programacao.logica.java.utilitarios.FormataTexto;
import com.programacao.logica.java.utilitarios.MensagemPersonalizada;

public class Exercicio1 implements Exercicio {
    @Override
    public void executarExercicio() {
        visualizarEnunciado();
        solicitarDadosUsuario();
        visualizarResposta();
    }

    @Override
    public void visualizarEnunciado() {
        MensagemPersonalizada.mensagemInformacao(
                "Coletar o valor do lado de um quadrado,\n"
                        .concat("calcular sua área e apresentar o resultado.\n\n")
                        .concat("Fórmula: lado²."),
                "Enunciado"
        );
    }

    @Override
    public void visualizarResposta() {
        MensagemPersonalizada.mensagemInformacao(
                "A área do quadrado é: "
                .concat(FormataTexto
                        .valorComCasasDecimais("2", calcularAreaQuadrado())
                ),
                "Exercício 1");
    }

    @Override
    public void solicitarDadosUsuario() {
        this.ladoQuadrado = CaixaDeDialogoPersonalizada
                .caixaDouble("Lado do quadrado");
    }

    private double ladoQuadrado = 0;

    private double calcularAreaQuadrado() {
        return Math.pow(this.ladoQuadrado, 2);
    }
}