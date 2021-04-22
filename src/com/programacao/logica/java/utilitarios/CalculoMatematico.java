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

    public static double calcularComprimentoCircuferencia(double raio) {
        return 2 * 3.14 * raio;
    }

    public static double converterGramaParaKg(double grama) {
        return grama / 1000;
    }

    public static double calcular3anguloDeUmTriangulo(double angulo1, double angulo2) {
        final double totalAngulo = 180;
        double angulo3 = 0;

        angulo3 = totalAngulo - (angulo1 + angulo2);

        return angulo3;
    }
}
