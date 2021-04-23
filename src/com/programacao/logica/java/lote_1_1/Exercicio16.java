package com.programacao.logica.java.lote_1_1;

import com.programacao.logica.java.utilitarios.*;

public class Exercicio16 implements Exercicio {
    @Override
    public void executarExercicio() {
        visualizarEnunciado();
        solicitarDadosUsuario();
        visualizarResposta();
    }

    @Override
    public void visualizarEnunciado() {
        MensagemPersonalizada.mensagemInformacao(
                "Receba a quantidade de horas trabalhadas, o valor por hora, o percentual "
                .concat("de desconto e o número de descendentes")
                .concat("\n")
                .concat("Calcule o salário que serão as horas trabalhadas x o valor por hora. ")
                .concat("\n")
                .concat("Calcule o salário líquido (= Salário Bruto – desconto). ")
                .concat("\n")
                .concat("A cada dependente será acrescido R$ 100 no Salário Líquido. Exiba o salário a receber."),
                "Enunciado"
        );
    }

    @Override
    public void visualizarResposta() {
        MensagemPersonalizada.mensagemInformacao(
                "Salário: "
                .concat(
                        FormataTexto.valorComCasasDecimais(
                                "2",
                                this.salarioBruto =
                                        calcularSalario(this.horasTrabalhadas, this.valorPorHora)
                        )
                )
                .concat("\n")
                .concat("Salário Líquido: ")
                .concat(
                        FormataTexto.valorComCasasDecimais(
                                "2",
                                calcularSalarioLiquido(
                                        this.salarioBruto,
                                        this.percentualDesconto,
                                        this.numeroDescendentes
                                )
                        )
                ),
                ""
        );
    }

    @Override
    public void solicitarDadosUsuario() {
        this.horasTrabalhadas = CaixaDeDialogoPersonalizada.caixaDouble("Horas trabalhadas");
        this.valorPorHora = CaixaDeDialogoPersonalizada.caixaDouble("Valor por hora");
        this.percentualDesconto = CaixaDeDialogoPersonalizada.caixaDouble("Percentual de desconto");
        this.numeroDescendentes = CaixaDeDialogoPersonalizada.caixaDouble("Número de descendentes");
    }

    private double horasTrabalhadas = 00.00, valorPorHora = 0,
            percentualDesconto = 0, numeroDescendentes = 0,
            salarioBruto = 0;

    private double calcularSalario(double horasTrabalhadas, double valorPorHora){
        return horasTrabalhadas * valorPorHora;
    }

    private double calcularSalarioLiquido(double salarioBruto,
                                          double percentualDesconto,
                                          double numeroDescendentes){
        double salarioLiquido = 0;

        salarioLiquido = retornarSalarioLiquido(salarioBruto, percentualDesconto);
        salarioLiquido = retornarSalarioLiquidoComDescendentes(salarioLiquido, numeroDescendentes);

        return salarioLiquido;
    }

    private double retornarSalarioLiquido(double salarioBruto, double percentualDesconto){
        double salarioLiquido = 0;

        salarioLiquido = salarioBruto - (salarioBruto
                * CalculoMatematico.simplificarPorcentagem(percentualDesconto)
        );

        return salarioLiquido;
    }

    private double retornarSalarioLiquidoComDescendentes(double salarioLiquido, double numeroDescendentes){
        for (int i = 0; i < numeroDescendentes; i++){
            salarioLiquido = salarioLiquido - 100;
        }

        return salarioLiquido;
    }
}
