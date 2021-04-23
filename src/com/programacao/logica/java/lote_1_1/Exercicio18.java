package com.programacao.logica.java.lote_1_1;

import com.programacao.logica.java.utilitarios.CaixaDeDialogoPersonalizada;
import com.programacao.logica.java.utilitarios.Exercicio;
import com.programacao.logica.java.utilitarios.MensagemPersonalizada;

public class Exercicio18 implements Exercicio {
    @Override
    public void visualizarEnunciado() {
        MensagemPersonalizada.mensagemInformacao(
                "Receba 2 valores inteiros."
                .concat("Calcule e mostre o resultado da diferença do maior pelo menos valor."),
                "Enunciado"
        );
    }

    @Override
    public void visualizarResposta() {
        MensagemPersonalizada.mensagemInformacao(
                "A diferença, do maior valor, referente ao segundo é: "
                + calcularDiferencaEntreMaiorEMenorValor(this.primeiroValor, this.segundoValor),
                "Exercício 18"
        );
    }

    @Override
    public void solicitarDadosUsuario() {
        this.primeiroValor = CaixaDeDialogoPersonalizada.caixaInteger("Primeiro valor");
        this.segundoValor = CaixaDeDialogoPersonalizada.caixaInteger("Segundo valor");
    }

    private int primeiroValor = 0, segundoValor = 0;

    private int maiorValor(int primeiroValor, int segundoValor){
        if (primeiroValor > segundoValor)
            return primeiroValor;
        else
            return segundoValor;
    }
    private int menorValor(int primeiroValor, int segundoValor){
        if (primeiroValor < segundoValor)
            return primeiroValor;
        else
            return segundoValor;
    }

    private int calcularDiferencaEntreMaiorEMenorValor(int primeiroValor, int segundoValor){
        return maiorValor(primeiroValor, segundoValor) - menorValor(primeiroValor, segundoValor);
    }
}
