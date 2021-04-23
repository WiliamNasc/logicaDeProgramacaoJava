package com.programacao.logica.java.lote_1_1;

import com.programacao.logica.java.utilitarios.CaixaDeDialogoPersonalizada;
import com.programacao.logica.java.utilitarios.Exercicio;
import com.programacao.logica.java.utilitarios.FormataTexto;
import com.programacao.logica.java.utilitarios.MensagemPersonalizada;

public class Exercicio19 implements Exercicio {
    @Override
    public void visualizarEnunciado() {
        MensagemPersonalizada.mensagemInformacao(
                "Receba 2 valores reais. Calcule e mostre o maior deles.",
                "Enunciado"
        );
    }

    @Override
    public void visualizarResposta() {
        MensagemPersonalizada.mensagemInformacao(
                "O maior valor é o "
                .concat(
                        FormataTexto.valorComCasasDecimais(
                                "2",
                                maiorValor(this.primeiroValor, this.segundoValor)
                        )
                ),
                "Exercício 19"
        );
    }

    @Override
    public void solicitarDadosUsuario() {
        this.primeiroValor = CaixaDeDialogoPersonalizada.caixaDouble("Primeiro valor");
        this.segundoValor = CaixaDeDialogoPersonalizada.caixaDouble("Segundo valor");
    }

    private double primeiroValor = 0, segundoValor = 0;

    private double maiorValor(double primeiroValor, double segundoValor){
        if (primeiroValor > segundoValor)
            return primeiroValor;
        else
            return segundoValor;
    }
}