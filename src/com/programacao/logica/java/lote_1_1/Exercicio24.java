package com.programacao.logica.java.lote_1_1;

import com.programacao.logica.java.utilitarios.CaixaDeDialogoPersonalizada;
import com.programacao.logica.java.utilitarios.Exercicio;
import com.programacao.logica.java.utilitarios.MensagemPersonalizada;

public class Exercicio24 implements Exercicio {
    @Override
    public void visualizarEnunciado() {
        MensagemPersonalizada.mensagemInformacao(
                "Receba um valor inteiro."
                .concat("\n")
                .concat("Verifique e mostre se é divisível por 2 e 3."),
                "Enunciado"
        );
    }

    @Override
    public void visualizarResposta() {
        MensagemPersonalizada.mensagemInformacao(
                textoResultadoValor(this.valor),
                "Exercício 24"
        );
    }

    @Override
    public void solicitarDadosUsuario() {
        this.valor = CaixaDeDialogoPersonalizada.caixaInteger("Valor");
    }

    private int valor = 0;

    private boolean valorEDivisivelPor2E3(int valor){
        if (valor % 2 == 0 && valor % 3 == 0)
            return true;
        else
            return false;
    }

    private String textoResultadoValor(int valor) {
        String texto = "";

        if (valorEDivisivelPor2E3(valor))
            texto = "O valor " + valor + ", é divisível por 2 e 3.";
        else
            texto = "O valor " + valor + ", não é divisível por 2 e 3.";

        return texto;
    }
}