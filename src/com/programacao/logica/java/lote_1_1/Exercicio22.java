package com.programacao.logica.java.lote_1_1;

import com.programacao.logica.java.utilitarios.CaixaDeDialogoPersonalizada;
import com.programacao.logica.java.utilitarios.Exercicio;
import com.programacao.logica.java.utilitarios.MensagemPersonalizada;

public class Exercicio22 implements Exercicio {
    @Override
    public void visualizarEnunciado() {
        MensagemPersonalizada.mensagemInformacao(
                "Receba 2 valores inteiros e diferentes."
                 .concat("\n")
                .concat("Mostre seus valores em ordem crescente."),
                "Enunciado"
        );
    }

    @Override
    public void visualizarResposta() {
        MensagemPersonalizada.mensagemInformacao(
                "Valores em ordem crescente:"
                .concat("\n")
                .concat(textoComValoresEmOrdemCrescente(this.primeiroValor,
                        this.segundoValor)
                ),
                "Exercício 22"
        );
    }

    @Override
    public void solicitarDadosUsuario() {
        this.primeiroValor = CaixaDeDialogoPersonalizada.caixaInteger("Primeiro valor");
        this.segundoValor = CaixaDeDialogoPersonalizada.caixaInteger("Segundo valor");
        validarValores();
    }

    private int primeiroValor = 0, segundoValor = 0;

    private String textoComValoresEmOrdemCrescente(int primeiroValor, int segundoValor){
        String texto = "";
        if (primeiroValor > segundoValor)
            texto = segundoValor + " - " + primeiroValor;
        else
            texto = primeiroValor + " - " + segundoValor;
        return texto;
    }

    private void validarValores() {
        while (this.primeiroValor == this.segundoValor) {
            this.primeiroValor = CaixaDeDialogoPersonalizada
                    .caixaInteger("Por favor, insira um valor diferentes, \n" +
                            "para o Primeiro valor");
        }
    }
}