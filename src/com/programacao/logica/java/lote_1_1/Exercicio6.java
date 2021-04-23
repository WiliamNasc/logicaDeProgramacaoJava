package com.programacao.logica.java.lote_1_1;

import com.programacao.logica.java.utilitarios.CaixaDeDialogoPersonalizada;
import com.programacao.logica.java.utilitarios.Exercicio;
import com.programacao.logica.java.utilitarios.FormataTexto;
import com.programacao.logica.java.utilitarios.MensagemPersonalizada;

import java.util.Locale;

public class Exercicio6 implements Exercicio {
    @Override
    public void visualizarEnunciado() {
        MensagemPersonalizada.mensagemInformacao(
                "Receba os valores em x e y. Efetua a troca de seus valores e mostre seus \n"
                .concat("conteúdos.")
                .concat("\n\n")
                .concat("Fórmula: x = y e y = x."),
                "Enunciado"
        );
    }

    @Override
    public void visualizarResposta() {
        trocarValores(this.x, this.y);
        MensagemPersonalizada.mensagemInformacao(
                "x: ".toUpperCase(Locale.ROOT)
                .concat(FormataTexto.valorComCasasDecimais("2",this.x))
                .concat("\n")
                .concat("Y: ").toUpperCase(Locale.ROOT)
                .concat(FormataTexto.valorComCasasDecimais("2",this.y)),
                "Exercício 6"
        );
    }

    @Override
    public void solicitarDadosUsuario() {
        this.x = CaixaDeDialogoPersonalizada.caixaDouble("X");
        this.y = CaixaDeDialogoPersonalizada.caixaDouble("Y");
    }

    private double x = 0, y = 0;

    private void trocarValores(double x, double y) {
        this.x = y;
        this.y = x;
    }
}