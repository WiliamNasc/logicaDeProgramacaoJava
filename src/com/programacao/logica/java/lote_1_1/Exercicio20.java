package com.programacao.logica.java.lote_1_1;

import com.programacao.logica.java.utilitarios.*;

public class Exercicio20 implements Exercicio {
    @Override
    public void visualizarEnunciado() {
        MensagemPersonalizada.mensagemInformacao(
                "Receba 3 coeficientes A, B, e C de uma equação do 2º grau da fórmula AX²+BX+C=0."
                .concat("\n")
                .concat("Verifique e mostre a existência de raízes reais e se caso exista, calcule e mostre."),
                "Enunciado"
        );
    }

    @Override
    public void visualizarResposta() {
        MensagemPersonalizada.mensagemInformacao(
                mostrarTextoResultadoEquacao(this.a, this.b, this.c),
                "Exercício 20"
        );
    }

    @Override
    public void solicitarDadosUsuario() {
        this.a = CaixaDeDialogoPersonalizada.caixaDouble("A");
        this.b = CaixaDeDialogoPersonalizada.caixaDouble("B");
        this.c = CaixaDeDialogoPersonalizada.caixaDouble("C");
    }

    private double a = 0, b, c = 0;

    private String mostrarTextoResultadoEquacao(double a, double b, double c){
        String textoResposta = "";

        if (existeRaizesReais(a,b,c)){
            textoResposta =
                    "Resultado: "
                    .concat("\n")
                    .concat("X1: ")
                    .concat(FormataTexto.valorComCasasDecimais(
                            "2",
                            retornarValorDeX1()
                    ))
                    .concat("\n")
                    .concat("X2: ")
                    .concat(
                            FormataTexto.valorComCasasDecimais(
                                    "2",
                                    retornarValorDeX2()
                            )
                    );
        }
        return textoResposta;
    }

    private boolean existeRaizesReais(double a, double b, double c){
        if (retornarValorDeDelta() >= 0)
            return true;
        else
            return false;
    }

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