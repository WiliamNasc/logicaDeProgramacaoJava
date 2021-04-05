package com.programacao.logica.java.utilitarios;

public class CalculoMatematico {
    public static double simplificarPorcentagem(double porcentagem) {
        return porcentagem / 100;
    }

    public static double equacao2grauCalcularDelta(double b, double a, double c){
        return Math.pow(b, 2) - (4 * a * c);
    }

    public static double equacao2grauCalcularX1(double b, double delta, double a){
        return (-(b) + Math.sqrt(delta)) / (2 * a);
    }

    public static double equacao2grauCalcularX2(double b, double delta, double a){
        return (-(b) - Math.sqrt(delta)) / (2 * a);
    }
}
