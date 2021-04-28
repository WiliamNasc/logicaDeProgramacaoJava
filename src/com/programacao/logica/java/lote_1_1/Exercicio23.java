package com.programacao.logica.java.lote_1_1;

import com.programacao.logica.java.utilitarios.CaixaDeDialogoPersonalizada;
import com.programacao.logica.java.utilitarios.Exercicio;
import com.programacao.logica.java.utilitarios.MensagemPersonalizada;

public class Exercicio23 implements Exercicio {
    @Override
    public void visualizarEnunciado() {
        MensagemPersonalizada.mensagemInformacao(
                "Receba 3 valores obrigatoriamente em ordem crescente,"
                .concat("\n")
                .concat("e um 4º valor nãonecessariamente em ordem.")
                .concat("\n")
                .concat("Mostre os 4 números em ordem crescente."),
                "Enunciado"
        );
    }

    @Override
    public void visualizarResposta() {
        MensagemPersonalizada.mensagemInformacao(
                "Valores em ordem crescente: "
                .concat("\n")
                .concat(textoValoresOrdemCrescente(
                        this.primeiroValor,
                        this.segundoValor,
                        this.terceiroValor,
                        this.quartoValor
                )),
                "Exercício 23"
        );
    }

    @Override
    public void solicitarDadosUsuario() {
        this.primeiroValor = CaixaDeDialogoPersonalizada.caixaDouble("Primeiro valor");
        this.segundoValor = CaixaDeDialogoPersonalizada.caixaDouble("Segundo valor");
        this.terceiroValor = CaixaDeDialogoPersonalizada.caixaDouble("Terceiro valor");
        this.quartoValor = CaixaDeDialogoPersonalizada.caixaDouble("Quarto valor");
        validarValores();
    }

    private double primeiroValor = 0, segundoValor = 0,
                    terceiroValor = 0, quartoValor = 0;

    private void validarValores(){
        int controlador = 0;
        while (controlador != 1) {
            if (!eMaiorValor(this.segundoValor, this.primeiroValor))
                this.segundoValor = CaixaDeDialogoPersonalizada.caixaDouble(
                        "Por favor, insira o segundo valor, respeitando a ordem crescente"
                );
            else if (!eMaiorValor(this.terceiroValor, this.segundoValor))
                this.terceiroValor = CaixaDeDialogoPersonalizada.caixaDouble(
                        "Por favor, insira o terceiro valor, respeitando a ordem crescente"
                );
            else
                controlador = 1;
        }
    }

    private boolean eMaiorValor(double primeiroValor, double segundoValor) {
        if (primeiroValor > segundoValor)
            return true;
        else
            return false;
    }

    private String textoValoresOrdemCrescente(double primeiroValor, double segundoValor,
                                              double terceiroValor, double quartoValor) {
        String texto = "";
        if (!eMaiorValor(quartoValor, terceiroValor))
            texto = primeiroValor + " , " + segundoValor + " , "
                    + quartoValor + " , " + terceiroValor;
        else if (!eMaiorValor(quartoValor, segundoValor))
            texto = primeiroValor + " , " + quartoValor + " , "
                    + segundoValor + " , " + terceiroValor;
        if (!eMaiorValor(quartoValor, primeiroValor))
            texto = quartoValor + " , " + primeiroValor + " , "
                    + segundoValor + " , " + terceiroValor;
        return texto;
    }
}