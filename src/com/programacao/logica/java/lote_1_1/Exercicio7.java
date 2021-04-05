package com.programacao.logica.java.lote_1_1;

import com.programacao.logica.java.utilitarios.FormataTexto;
import com.programacao.logica.java.utilitarios.CaixaDeDialogoPersonalizada;
import com.programacao.logica.java.utilitarios.Exercicio;
import com.programacao.logica.java.utilitarios.MensagemPersonalizada;

public class Exercicio7 implements Exercicio {
    @Override
    public void executarExercicio() {
        visualizarEnunciado();
        solicitarDadosUsuario();
        visualizarResposta();
    }

    @Override
    public void visualizarEnunciado() {
        MensagemPersonalizada.mensagemInformacao(
                "Receba os valores do comprimento,\n"
                .concat("largura e altura de um paralelepípedo. \n")
                .concat("Calcule e mostre seu volume.\n")
                .concat("\n\n")
                .concat("Fórmula: comprimento x largura x altura."),
                "Enunciado"
        );
    }

    @Override
    public void visualizarResposta() {
        MensagemPersonalizada.mensagemInformacao(
                "O volume é igual a: "
                .concat(FormataTexto
                        .valorComCasasDecimais("2",calcularVolumeParalelepipedo(
                        this.comprimento, this.largura, this.altura)
                        )
                ),
                "Exercício 7"
        );
    }

    @Override
    public void solicitarDadosUsuario() {
        this.comprimento = CaixaDeDialogoPersonalizada.caixaDouble("Comprimento");
        this.largura = CaixaDeDialogoPersonalizada.caixaDouble("Largura");
        this.altura = CaixaDeDialogoPersonalizada.caixaDouble("Altura");
    }

    private double comprimento = 0,
                   largura = 0,
                   altura = 0;

    private double calcularVolumeParalelepipedo(double comprimento,
                                                double largura,
                                                double altura){
        return comprimento * largura * altura;
    }

}