package com.programacao.logica.java.lote_1_1;

import java.util.Iterator;

import com.programacao.logica.java.utilitarios.CaixaDeDialogoPersonalizada;
import com.programacao.logica.java.utilitarios.Exercicio;
import com.programacao.logica.java.utilitarios.MensagemPersonalizada;

public class Exercicio30 implements Exercicio {

	@Override
	public void visualizarEnunciado() {

		MensagemPersonalizada.mensagemInformacao(
				"Receba a data de nascimento e atual em ano, mês e dia.".concat("\n")
						.concat("Calcule e mostre a idade em anos, meses e dias, considerando os anos bissextos."),
				"Enunciado");

	}

	@Override
	public void visualizarResposta() {

		totalDias(anoNascimento, anoAtual, diaNascimento, diaAtual, mesNascimento, mesAtual);

	}

	@Override
	public void solicitarDadosUsuario() {

		this.diaNascimento = CaixaDeDialogoPersonalizada.caixaInteger("Dia nascimento");
		this.mesNascimento = CaixaDeDialogoPersonalizada.caixaInteger("Mês nascimento");
		this.anoNascimento = CaixaDeDialogoPersonalizada.caixaInteger("Ano nascimento");
		this.diaAtual = CaixaDeDialogoPersonalizada.caixaInteger("Dia atual");
		this.mesAtual = CaixaDeDialogoPersonalizada.caixaInteger("Mês atual");
		this.anoAtual = CaixaDeDialogoPersonalizada.caixaInteger("Ano atual");

	}

	private int anoNascimento;
	private int anoAtual;
	private int mesNascimento;
	private int mesAtual;
	private int diaNascimento;
	private int diaAtual;
	private int[] meses = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };

	private boolean eAnoBissexto(int ano) {

		if ((ano % 4 == 0 && ano % 100 != 0) || ano % 400 == 0)

			return true;

		return false;

	}

	private void totalDias(int anoNascimento, int anoAtual, int diaNascimento, int diaAtual, int mesNascimento,
			int mesAtual) {

		int qtdAnosNaoBissextos = 0, qtdAnosBissextos = 0;
		int diasVividosAnoNascimento = 0, diasVividosAnoAtual = 0, diferencaDiasFimMes = 0;
		int totalDias = 0;

		// determina a quantidade de anos bissextos e não bissextos
		for (int i = anoNascimento + 1; i < anoAtual; i++) {

			System.out.println(i + " - ano bissexto - " + eAnoBissexto(i));

			if (eAnoBissexto(i))
				qtdAnosNaoBissextos++;
			else
				qtdAnosBissextos++;

		}

		// determina os dias vividos no primeiro ano de vida
		for (int i = mesNascimento; i <= meses.length; i++) {

			if (i == 2)
				if (eAnoBissexto(anoNascimento))
					diasVividosAnoNascimento += 29;
				else
					diasVividosAnoNascimento += 28;
			else if (i % 2 != 0 || i == 8)
				diasVividosAnoNascimento += 31;
			else
				diasVividosAnoNascimento += 30;

		}

		diasVividosAnoNascimento -= diaNascimento;

		// determina os dias vividos no ano vigente
		for (int i = 1; i <= mesAtual; i++) {

			if (i == 2) {
				if (eAnoBissexto(anoAtual)) {
					diasVividosAnoAtual += 29;
					diferencaDiasFimMes = 29;
				} else {
					diasVividosAnoAtual += 28;
					diferencaDiasFimMes = 28;
				}
			} else if (i % 2 != 0 || i == 8) {
				diasVividosAnoAtual += 31;
				diferencaDiasFimMes = 31;
			} else {
				diasVividosAnoAtual += 30;
				diferencaDiasFimMes = 30;
			}
			if (i == mesAtual) {
				diferencaDiasFimMes -= diaAtual;
			}
		}

		diasVividosAnoAtual = (diasVividosAnoAtual - diferencaDiasFimMes) - 1;

		totalDias = (365 * qtdAnosBissextos) + (366 * qtdAnosNaoBissextos) + diasVividosAnoNascimento
				+ diasVividosAnoAtual + 1;

		System.out.println(totalDias);

	}

}