package com.programacao.logica.java.utilitarios;

// Só importe o que realmente vc vai usar
import javax.swing.JOptionPane;

public class CaixaDeDialogoPersonalizada {

    // Só p/ impossibitar a instanciação da classe
    private CaixaDeDialogoPersonalizada() {}

    public static int caixaInteger (String mensagem){
        int caixaDialogo = 0;
        try{
        caixaDialogo = Integer
                .parseInt(
                        JOptionPane.showInputDialog(mensagem)
                );
        }catch (NumberFormatException numberFormatException){
            MensagemPersonalizada.mensagemErro(
                    "Por favor, insira somente números inteiros.",
                    "Erro"
            );
        }
        return caixaDialogo;
    }
    public static double caixaDouble (String mensagem){
        double caixaDialogo = 0;
        try{
            caixaDialogo = Double
                    .parseDouble(
                            JOptionPane.showInputDialog(mensagem)
                    );
        }catch (NumberFormatException numberFormatException){
            MensagemPersonalizada.mensagemErro(
                    "Por favor, insira somente números (inteiros, ou decimais).",
                    "Erro"
            );
        }
        return caixaDialogo;
    }
}
