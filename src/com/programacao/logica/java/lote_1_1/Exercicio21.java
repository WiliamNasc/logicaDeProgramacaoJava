package com.programacao.logica.java.lote_1_1;

import com.programacao.logica.java.utilitarios.CaixaDeDialogoPersonalizada;
import com.programacao.logica.java.utilitarios.Exercicio;
import com.programacao.logica.java.utilitarios.FormataTexto;
import com.programacao.logica.java.utilitarios.MensagemPersonalizada;

public class Exercicio21 implements Exercicio {

    @Override
    public void visualizarEnunciado() {
        MensagemPersonalizada.mensagemInformacao(
                "Receba 4 notas bimestrais de um aluno."
                .concat("\n")
                .concat("Calcule e mostre a média aritmética.")
                .concat("\n")
                .concat("Mostre a mensagem de acordo com a média:")
                .concat("\n\n")
                .concat("a. Se a média for >= 6,0 exibir “APROVADO”;")
                .concat("\n")
                .concat("b. Se a média for >= 3,0 ou < 6,0 exibir “EXAME”;")
                .concat("\n")
                .concat("c. Se a média for < 3,0 exibir “RETIDO”.\n"),
                "Enunciado"
        );
    }

    @Override
    public void visualizarResposta() {
        MensagemPersonalizada.mensagemInformacao(
                "Informações de aluno:"
                .concat("\n")
                .concat("Média: ")
                .concat(FormataTexto.valorComCasasDecimais(
                        "2",
                        this.mediaAluno = calcularMediaNotas(this.nota1, this.nota2,
                                                            this.nota3, this.nota4)
                ))
                .concat("\n")
                .concat("Estado: ")
                .concat(retornarEstadoAluno(this.mediaAluno)),
                "Exercício 21"
        );
    }

    @Override
    public void solicitarDadosUsuario() {
        this.nota1 = CaixaDeDialogoPersonalizada.caixaDouble("Nota 1");
        this.nota2 = CaixaDeDialogoPersonalizada.caixaDouble("Nota 2");
        this.nota3 = CaixaDeDialogoPersonalizada.caixaDouble("Nota 3");
        this.nota4 = CaixaDeDialogoPersonalizada.caixaDouble("Nota 4");
    }

    private double nota1 = 0, nota2 = 0,
            nota3 = 0, nota4 = 0, mediaAluno = 0;

    private double calcularMediaNotas(double nota1, double nota2,
                                 double nota3, double nota4){
        return (nota1 + nota2 + nota3 + nota4) / 4;
    }

    private String retornarEstadoAluno(double media) {
        String estado = "";
        if (media >= 6.0)
            estado = "Aprovado";
        if (media >= 3 && media < 6)
            estado = "Exame";
        if (media < 3)
            estado = "Retido";
        return estado;
    }
}