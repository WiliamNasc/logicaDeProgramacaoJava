package com.programacao.logica.java.lote_1_1;

import com.programacao.logica.java.utilitarios.CaixaDeDialogoPersonalizada;
import com.programacao.logica.java.utilitarios.Exercicio;
import com.programacao.logica.java.utilitarios.FormataTexto;
import com.programacao.logica.java.utilitarios.MensagemPersonalizada;

public class Exercicio25 implements Exercicio {
    @Override
    public void visualizarEnunciado() {
        MensagemPersonalizada.mensagemInformacao(
                "Receba a hora de início e de final de um jogo (HH,MM)"
                .concat("\n")
                .concat("sabendo que o tempo máximo é de 24 horas,")
                .concat("\n")
                .concat("e pode começar num dia e terminar noutro."),
                "Enunciado"
        );
    }

    @Override
    public void visualizarResposta() {
        MensagemPersonalizada.mensagemInformacao(
                "Duração partida: "
                .concat(
                        FormataTexto.valorComCasasDecimais(
                                "2",
                                calcularDuracaoPartida(this.horaInicio, this.horaTermino)
                        )
                )
                .concat(" (HH,MM)."),
                "Exercício 25"
        );
    }

    @Override
    public void solicitarDadosUsuario() {
        this.horaInicio = CaixaDeDialogoPersonalizada.caixaDouble("Horário de início");
        this.horaTermino = CaixaDeDialogoPersonalizada.caixaDouble("Horário de término");
        validarEntradas();
    }

    private double horaInicio = 00.00, horaTermino = 00.00;
    private final int limiteHoras = 24, limiteMinutos = 60;
    private final double limiteHorasMinutos = 24.60;

    private double calcularDuracaoPartida(double horaInicio, double horaTermino){
        double tempoDuracaoPartida = retornarDuracaoJogo(this.limiteHorasMinutos,
                                                    horaInicio,
                                                    horaTermino);

        tempoDuracaoPartida = validarLimiteHorasJogo(tempoDuracaoPartida);
        tempoDuracaoPartida = validarLimiteMinutosJogo(tempoDuracaoPartida);
        tempoDuracaoPartida = validarLimiteJogo12Horas(tempoDuracaoPartida, horaInicio, horaTermino);

        return tempoDuracaoPartida;
    }

    private int retornarHorasJogadas(double tempoDuracaoPartida){
        return (int) tempoDuracaoPartida;
    }

    private int retornarMinutosJogados(double tempoDuracaoPartida){
        return ((int) Math.ceil(tempoDuracaoPartida * 100) % 100);
    }

    private double retornarDuracaoJogo(double limiteHorasMinutos,
                                       double horaInicio,
                                       double horaTermino){
        return (limiteHorasMinutos - horaInicio) + horaTermino - 1;
    }

    private double validarLimiteHorasJogo(double tempoDuracaoPartida){
        if (retornarHorasJogadas(tempoDuracaoPartida) > this.limiteHoras)
            tempoDuracaoPartida -= 12;
        return tempoDuracaoPartida;
    }

    private double validarLimiteMinutosJogo(double tempoDuracaoPartida) {
        if (retornarMinutosJogados(tempoDuracaoPartida) >= this.limiteMinutos){
            tempoDuracaoPartida += 1;
            tempoDuracaoPartida -= 0.60;
        }
        return tempoDuracaoPartida;
    }

    private double validarLimiteJogo12Horas(double tempoDuracaoPartida,
                                            double horaInicio,
                                            double horaTermino) {

        if (horaInicio < horaTermino && (horaTermino - horaInicio) == 12)
            tempoDuracaoPartida = 12;

        return tempoDuracaoPartida;
    }

    private void validarEntradas(){
        int controlador = 0;

        while (controlador != 1) {
            if (retornarHorasJogadas(this.horaInicio) >= this.limiteHoras
               || retornarMinutosJogados(this.horaInicio) >= this.limiteMinutos)
                this.horaInicio = CaixaDeDialogoPersonalizada
                        .caixaDouble("Por favor, insira um horário de início válido");
            else if (retornarHorasJogadas(this.horaTermino) >= this.limiteHoras
                    || retornarMinutosJogados(this.horaTermino) >= this.limiteMinutos)
                this.horaTermino = CaixaDeDialogoPersonalizada
                        .caixaDouble("Por favor, insira um horário de término válido");
            else
                controlador = 1;
        }
    }
}