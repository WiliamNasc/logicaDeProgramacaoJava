package com.programacao.logica.java.lote_1_1;

import com.programacao.logica.java.utilitarios.CaixaDeDialogoPersonalizada;
import com.programacao.logica.java.utilitarios.Exercicio;
import com.programacao.logica.java.utilitarios.FormataTexto;
import com.programacao.logica.java.utilitarios.MensagemPersonalizada;

public class Exercicio17 implements Exercicio {
    @Override
    public void visualizarEnunciado() {
        MensagemPersonalizada.mensagemInformacao(
                "Calcule a quantidade de litros gastos em uma viagem, "
                .concat("\n")
                .concat("sabendo que o automóvel faz 12 km/l.")
                .concat("\n")
                .concat("Receber o tempo de percurso e a velocidade média.")
                .concat("\n\n")
                .concat("Fórmulas: ")
                .concat("\n")
                .concat("distancia = velocidade x tempo")
                .concat("\n")
                .concat("litros gastos = distancia / 12")
                .concat("\n\n")
                .concat("Obs.: 1 hora = 1, e 30 minutos = 0.5"),
                "Enunciado"
        );
    }

    @Override
    public void visualizarResposta() {
        MensagemPersonalizada.mensagemInformacao(
                "Serão gastos "
                .concat(
                        FormataTexto.valorComCasasDecimais(
                                "2",
                                calcularQtdeLitrosGastos(this.velocidadeMedia, this.tempoPercurso)
                        )
                )
                .concat(" litros, para realizar a viagem."),
                "Exercício 17"
        );
    }

    @Override
    public void solicitarDadosUsuario() {
        this.tempoPercurso = CaixaDeDialogoPersonalizada.caixaDouble("Tempo percurso");
        this.velocidadeMedia = CaixaDeDialogoPersonalizada.caixaDouble("Velocidade média");
    }

    private double tempoPercurso = 0, velocidadeMedia = 0;

    private double calcularDistanciaPercorridaKm(double velocidade, double tempo){
        return velocidade * tempo;
    }

    private double calcularQtdeLitrosGastos(double velocidade, double tempo){
        double distanciaPercurso = calcularDistanciaPercorridaKm(velocidade, tempo);
        return distanciaPercurso / 12;
    }
}