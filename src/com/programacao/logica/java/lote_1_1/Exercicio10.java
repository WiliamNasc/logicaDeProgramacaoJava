package com.programacao.logica.java.lote_1_1;

import com.programacao.logica.java.utilitarios.CaixaDeDialogoPersonalizada;
import com.programacao.logica.java.utilitarios.Exercicio;
import com.programacao.logica.java.utilitarios.FormataTexto;
import com.programacao.logica.java.utilitarios.MensagemPersonalizada;

public class Exercicio10 implements Exercicio {
    @Override
    public void visualizarEnunciado() {
        MensagemPersonalizada.mensagemInformacao(
                "Receba 2 números reais."
                .concat("\n")
                .concat("Calcule e mostre a diferença desses valores."),
                "Enunciado"
        );
    }

    @Override
    public void visualizarResposta() {
        validarValores(this.valor1, this.valor2);
        MensagemPersonalizada
            .mensagemInformacao(
                    "A diferença é: "
                    .concat(FormataTexto
                            .valorComCasasDecimais("2",
                                                    calcularDiferenca(this.valor1,
                                                                      this.valor2))
                    ),
                    "Exercício 10"
            );
    }

    @Override
    public void solicitarDadosUsuario() {
        this.valor1 = CaixaDeDialogoPersonalizada.caixaDouble("Valor 1");
        this.valor2 = CaixaDeDialogoPersonalizada.caixaDouble("Valor 2");
    }

    private double valor1 = 0, valor2 = 0;

    private double calcularDiferenca(double valor1, double valor2){
        return valor1 - valor2;
    }

    private boolean eMaior(double valor1, double valor2){
        return valor1 > valor2;
    }

    private void validarValores(double valor1, double valor2){
        if (!eMaior(valor1, valor2)){
            this.valor1 = valor2;
            this.valor2 = valor1;
        }
    }
}