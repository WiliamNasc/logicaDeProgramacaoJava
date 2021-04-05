package com.programacao.logica.java.lote_1_1;

import com.programacao.logica.java.utilitarios.CaixaDeDialogoPersonalizada;
import com.programacao.logica.java.utilitarios.Exercicio;
import com.programacao.logica.java.utilitarios.FormataTexto;
import com.programacao.logica.java.utilitarios.MensagemPersonalizada;

public class Exercicio3 implements Exercicio {
    @Override
    public void executarExercicio() {
        visualizarEnunciado();
        solicitarDadosUsuario();
        visualizarResposta();
    }

    @Override
    public void visualizarEnunciado() {
        MensagemPersonalizada.mensagemInformacao(
                "Receba a base e a altura de um triângulo.\n"
                        .concat("Calcule e mostre a sua área.\n\n")
                        .concat("Fórmula: base x altura / 2."),
                "Enunciado"
        );
    }

    @Override
    public void visualizarResposta() {
        MensagemPersonalizada.mensagemInformacao(
                "A área do triângulo é: "
                .concat(
                    FormataTexto.valorComCasasDecimais(
                        "2",
                         calcularAreaTriangulo(this.base,
                                               this.altura)
                         )
                ),
                "Exercício 3"
        );
    }

    @Override
    public void solicitarDadosUsuario() {
        this.base = CaixaDeDialogoPersonalizada.caixaDouble("Base");
        this.altura = CaixaDeDialogoPersonalizada.caixaDouble("Altura");
    }

    private double base = 0, altura = 0;

    private double calcularAreaTriangulo(double base, double altura){
        return (base * altura) / 2;
    }
}
