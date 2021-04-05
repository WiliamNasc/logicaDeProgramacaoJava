package com.programacao.logica.java.lote_1_1;

import com.programacao.logica.java.utilitarios.*;

import java.util.Locale;

public class Exercicio5 implements Exercicio {
    @Override
    public void executarExercicio() {
        visualizarEnunciado();
        solicitarDadosUsuario();
        visualizarResposta();
    }

    @Override
    public void visualizarEnunciado() {
        MensagemPersonalizada.mensagemInformacao(
                "Receba os coeficientes A, B e C de uma equação do 2º grau \n"
                        .concat("(AX²+ BX + C = 0)."
                        .concat("\n")
                        .concat("Calcule e mostre as raízes reais (considerar que a \n"))
                        .concat("equação possue2 raízes).")
                        .concat("\n\n")
                        .concat("Fórmulas:")
                        .concat("\n")
                        .concat("Delta: b² - 4ac.")
                        .concat("\n")
                        .concat("X1: (-(b) + raiz quadrada de delta) / 2a.")
                        .concat("\n")
                        .concat("X2: (-(b) - raiz quadrada de delta) / 2a."),
                "Enunciado"
        );
    }

    @Override
    public void visualizarResposta() {
        MensagemPersonalizada.mensagemInformacao(
                "Resultado:"
                 .concat("\n")
                 .concat("x1: ").toUpperCase(Locale.ROOT)
                 .concat(FormataTexto.valorComCasasDecimais("2", retornarValorDeX1()))
                 .concat("\n")
                 .concat("x2: ").toUpperCase(Locale.ROOT)
                 .concat(FormataTexto.valorComCasasDecimais("2", retornarValorDeX2())),
                "Exercício 5"
        );
    }

    @Override
    public void solicitarDadosUsuario() {
        this.a = CaixaDeDialogoPersonalizada.caixaDouble("a");
        this.b = CaixaDeDialogoPersonalizada.caixaDouble("b");
        this.c = CaixaDeDialogoPersonalizada.caixaDouble("c");
    }

    private double a = 0, b = 0 ,c = 0;

    private double retornarValorDeDelta(){
        return CalculoMatematico.equacao2grauCalcularDelta(this.b, this.a, this.c);
    }

    private double retornarValorDeX1(){
        return CalculoMatematico.equacao2grauCalcularX1(this.b, retornarValorDeDelta(), this.a);
    }

    private double retornarValorDeX2(){
        return CalculoMatematico.equacao2grauCalcularX2(this.b, retornarValorDeDelta(), this.a);
    }
}