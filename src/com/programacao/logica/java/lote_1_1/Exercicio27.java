package com.programacao.logica.java.lote_1_1;

import com.programacao.logica.java.utilitarios.CaixaDeDialogoPersonalizada;
import com.programacao.logica.java.utilitarios.Exercicio;
import com.programacao.logica.java.utilitarios.FormataTexto;
import com.programacao.logica.java.utilitarios.MensagemPersonalizada;

public class Exercicio27 implements Exercicio {
    @Override
    public void visualizarEnunciado() {
        MensagemPersonalizada.mensagemInformacao(
                "Receba o número de voltas, a extensão do circuito (em metros),"
                .concat("\n")
                .concat("e o tempo de duração (minutos).")
                .concat(" Calcule e mostre a velocidade média em km/h.")
                .concat("\n\n")
                .concat("Fórmula:")
                .concat("\n")
                .concat("Velocidade = distância / tempo"),
                "Enunciado"
        );
    }

    @Override
    public void visualizarResposta() {
        MensagemPersonalizada.mensagemInformacao(
                "Velocidade média: "
                .concat(
                        FormataTexto.valorComCasasDecimais(
                                "2",
                                calcularVelocidadeMedia(
                                        this.numeroDeVoltas,
                                        this.extensaoCircuitoEmMetros,
                                        this.tempoDuracaoEmMinutos
                                )
                        )
                )
                .concat(" KM/H"),
                "Exercício 27"
        );
    }

    @Override
    public void solicitarDadosUsuario() {
        this.numeroDeVoltas = CaixaDeDialogoPersonalizada.caixaInteger("Número de voltas");
        this.extensaoCircuitoEmMetros = CaixaDeDialogoPersonalizada
                .caixaDouble("Extensão do circuito (em metros)");
        this.tempoDuracaoEmMinutos = CaixaDeDialogoPersonalizada
                .caixaInteger("Tempo de duração (em minutos)");
    }

    private int numeroDeVoltas = 0, tempoDuracaoEmMinutos = 0;
    private double extensaoCircuitoEmMetros = 0;

    private double converteTempoDuracaoEmMinutosParaHoras(int tempoDuracaoEmMinutos){
        return tempoDuracaoEmMinutos / 60;
    }

    private double calcularVelocidadeMedia(int numeroDeVoltas, double extensaoCircuitoEmMetros,
                                           int tempoDuracaoEmMinutos){
        return (numeroDeVoltas * extensaoCircuitoEmMetros)
                / converteTempoDuracaoEmMinutosParaHoras(tempoDuracaoEmMinutos);
    }
}