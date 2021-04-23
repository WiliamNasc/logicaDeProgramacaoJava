package com.programacao.logica.java.lote_1_1;

import com.programacao.logica.java.utilitarios.CaixaDeDialogoPersonalizada;
import com.programacao.logica.java.utilitarios.CalculoMatematico;
import com.programacao.logica.java.utilitarios.Exercicio;
import com.programacao.logica.java.utilitarios.MensagemPersonalizada;

public class Exercicio13 implements Exercicio {
    @Override
    public void visualizarEnunciado() {
        MensagemPersonalizada.mensagemInformacao(
                "Receba a quantidade de alimento em quilos."
                .concat("\n")
                .concat("Calcule e mostre quantos dias durará esse alimento,")
                .concat("\n")
                .concat("sabendo que a pessoa consome 50g ao dia."),
                "Enunciado"
        );
    }

    @Override
    public void visualizarResposta() {
        MensagemPersonalizada.mensagemInformacao(
                "O alimento durará: "
                + calcularQtdeDiasDeDuracaoAlimento(this.qtdeAlimentosEmKg,
                        this.consumoPessoaGramaPorDia)
                +" dias.",
                "Exercício 13"
        );
    }

    @Override
    public void solicitarDadosUsuario() {
        this.qtdeAlimentosEmKg = CaixaDeDialogoPersonalizada
                .caixaDouble("Quantidade de alimentos, em Kg");
    }

    private double qtdeAlimentosEmKg = 0;
    private final double consumoPessoaGramaPorDia = 50;

    private int calcularQtdeDiasDeDuracaoAlimento(double qtdeAlimentosEmKg, double consumoPessoaGramaPorDia){
        int dias = 0;
        double consumoPessoaGramaPorDiaConvertido = CalculoMatematico
                .converterGramaParaKg(consumoPessoaGramaPorDia);

        for (int i = 1; qtdeAlimentosEmKg > 0; i++) {
            dias = i;
            qtdeAlimentosEmKg = qtdeAlimentosEmKg - consumoPessoaGramaPorDiaConvertido;
        }

        return dias;
    }

}