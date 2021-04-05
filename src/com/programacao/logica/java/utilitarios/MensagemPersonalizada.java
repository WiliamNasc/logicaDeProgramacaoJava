package com.programacao.logica.java.utilitarios;

import javax.swing.*;

public class MensagemPersonalizada {
    public static void mensagemInformacao (String mensagem, String titulo){
        JOptionPane.showMessageDialog(null,
                mensagem,
                titulo,
                JOptionPane.INFORMATION_MESSAGE);
    }
    public static void mensagemAtencao (String mensagem, String titulo){
        JOptionPane.showMessageDialog(null,
                mensagem,
                titulo,
                JOptionPane.WARNING_MESSAGE);
    }
    public static void mensagemErro (String mensagem, String titulo){
        JOptionPane.showMessageDialog(null,
                mensagem,
                titulo,
                JOptionPane.ERROR_MESSAGE);
    }
}
