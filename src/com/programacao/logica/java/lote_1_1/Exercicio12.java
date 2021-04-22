package com.programacao.logica.java.lote_1_1;

import com.programacao.logica.java.utilitarios.CaixaDeDialogoPersonalizada;
import com.programacao.logica.java.utilitarios.Exercicio;
import com.programacao.logica.java.utilitarios.MensagemPersonalizada;

public class Exercicio12 implements Exercicio {
    @Override
    public void executarExercicio() {
        visualizarEnunciado();
        solicitarDadosUsuario();
        visualizarResposta();
    }

    @Override
    public void visualizarEnunciado() {
        MensagemPersonalizada.mensagemInformacao(
                "Receba o ano de nascimento e o ano atual."
                .concat("\n")
                .concat(" Calcule e mostre a sua idade, e quantos anos terá daqui a 17 anos."),
                "Enunciado"
        );
    }

    @Override
    public void visualizarResposta() {
        MensagemPersonalizada.mensagemInformacao(
                "A sua idade é:" + this.idade
                + "\n"
                + "Daqui à 17 anos, você terá: " + retornarIdadeDaqui17Anos(this.idade),
                "Exercício 12"
        );
    }

    @Override
    public void solicitarDadosUsuario() {
        this.idade = CaixaDeDialogoPersonalizada.caixaInteger("Insira a sua idade");
    }

    private int idade = 0;

    private int retornarIdadeDaqui17Anos (int idade) {
        if (idadeValida(idade))
            return idade + 17;
        else
            return 0;
    }

    private boolean idadeValida(int idade) {
        if (idade > 0)
            return true;
        else
            return false;
    }
}
