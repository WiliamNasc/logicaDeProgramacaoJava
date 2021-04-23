package com.programacao.logica.java.lote_1_1;

import com.programacao.logica.java.utilitarios.*;

public class Exercicio2 implements Exercicio {
    @Override
    public void visualizarEnunciado() {
        MensagemPersonalizada.mensagemInformacao(
                "Receba o salário de um funcionário,\n"
                        .concat("e mostre o novo salário com reajuste de 15%.\n\n")
                        .concat("Fórmula: salário = salário + (salário * 0,15)."),
                "Enunciado"
        );
    }

    @Override
    public void visualizarResposta() {
        MensagemPersonalizada.mensagemInformacao(
                "O salário com reajuste é: "
                 .concat(
                    FormataTexto.valorComCasasDecimais(
                    "2",
                     calcularSalarioComReajuste(
                             this.salario,
                             this.porcentagemReajuste
                     )
                 )
                 ), "Exercício 2");
    }

    @Override
    public void solicitarDadosUsuario() {
        this.salario = CaixaDeDialogoPersonalizada
                .caixaDouble("Salário");
        this.porcentagemReajuste = CaixaDeDialogoPersonalizada
                .caixaDouble("Porcentagem de reajuste");
    }

    private double salario = 0, porcentagemReajuste = 0;

    private double calcularSalarioComReajuste(double salario, double porcentagemReajuste){
        return salario + (salario * CalculoMatematico
                            .simplificarPorcentagem(porcentagemReajuste));
    }
}
