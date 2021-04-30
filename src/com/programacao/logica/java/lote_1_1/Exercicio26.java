package com.programacao.logica.java.lote_1_1;

import com.programacao.logica.java.utilitarios.CaixaDeDialogoPersonalizada;
import com.programacao.logica.java.utilitarios.Exercicio;
import com.programacao.logica.java.utilitarios.MensagemPersonalizada;

public class Exercicio26 implements Exercicio {
    @Override
    public void visualizarEnunciado() {
        MensagemPersonalizada.mensagemInformacao(
                "Receba 2 números inteiros."
                .concat("\n")
                .concat("Verifique e mostre se o maior número é múltiplo do menor."),
                "Enunciado"
        );
    }

    @Override
    public void visualizarResposta() {
        MensagemPersonalizada.mensagemInformacao(
                textoResultado(this.primeiroNumero, this.segundoNumero),
                "Exercício 26"
        );
    }

    @Override
    public void solicitarDadosUsuario() {
        this.primeiroNumero = CaixaDeDialogoPersonalizada.caixaInteger("Primeiro número");
        this.segundoNumero = CaixaDeDialogoPersonalizada.caixaInteger("Segundo número");
    }

    private int primeiroNumero = 0, segundoNumero = 0;

    private boolean eMaiorNumero(int primeiroNumero, int segundoNumero){
        if (primeiroNumero > segundoNumero)
            return true;
        else
            return false;
    }

    private boolean eMultiplo(int primeiroNumero, int segundoNumero) {
        if (primeiroNumero % segundoNumero == 0)
            return true;
        else
            return false;
    }

    private String textoResultado(int primeiroNumero, int segundoNumero){
        String texto = "";

        if (eMaiorNumero(primeiroNumero, segundoNumero)
                && eMultiplo(primeiroNumero, segundoNumero))
            return primeiroNumero + " é múltiplo de " + segundoNumero;
        else if (eMaiorNumero(segundoNumero, primeiroNumero)
                && eMultiplo(segundoNumero, primeiroNumero))
            return segundoNumero + " é múltiplo de " + primeiroNumero;
        else
            return "O maior número, não é múltiplo do menor";
    }
}