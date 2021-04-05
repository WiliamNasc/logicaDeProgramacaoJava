package com.programacao.logica.java.utilitarios;

public class FormataTexto {
    public static String valorComCasasDecimais(String casasDecimais, double valor) {
        return String.format("%.".concat(casasDecimais).concat("f"), valor);
    }
}
