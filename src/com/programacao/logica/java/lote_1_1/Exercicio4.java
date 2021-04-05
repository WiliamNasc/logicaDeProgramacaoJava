package com.programacao.logica.java.lote_1_1;

import com.programacao.logica.java.utilitarios.CaixaDeDialogoPersonalizada;
import com.programacao.logica.java.utilitarios.Exercicio;
import com.programacao.logica.java.utilitarios.FormataTexto;
import com.programacao.logica.java.utilitarios.MensagemPersonalizada;

public class Exercicio4 implements Exercicio {
    @Override
    public void executarExercicio() {
        visualizarEnunciado();
        solicitarDadosUsuario();
        visualizarResposta();
    }

    @Override
    public void visualizarEnunciado() {
        MensagemPersonalizada.mensagemInformacao(
                "Receba a temperatura em graus Celsius. Calcule e mostre a sua \n"
                .concat("temperatura convertida em fahrenheit.\n\n")
                .concat("Fórmula: (celsius x 1,8) + 32"),
                "Enunciado");
    }

    @Override
    public void visualizarResposta() {
        MensagemPersonalizada.mensagemInformacao(
                "A temperatura em Fahrenheit é: "
                 .concat(FormataTexto
                            .valorComCasasDecimais(
                                "2",
                                converterTemperaturaCelsiusParaFahrenheit(
                                    this.temperaturaCelsius
                                )
                            )
                 ),
                "Exercício 4"
        );
    }

    @Override
    public void solicitarDadosUsuario() {
        this.temperaturaCelsius =  CaixaDeDialogoPersonalizada
                .caixaDouble("Temperatura em celsius");
    }

    private double temperaturaCelsius = 0;

    private double converterTemperaturaCelsiusParaFahrenheit(double temperatura){
        return (temperatura * 1.8) + 32;
    }
}
