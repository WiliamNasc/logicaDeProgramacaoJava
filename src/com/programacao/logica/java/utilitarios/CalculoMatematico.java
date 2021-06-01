package com.programacao.logica.java.utilitarios;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.hypot;

public class CalculoMatematico {
    public static double simplificarPorcentagem(double porcentagem) {
        return porcentagem / 100;
    }

    public static double equacao2grauCalcularDelta(double b, double a, double c) {
        return Math.pow(b, 2) - (4 * a * c);
    }

    public static double equacao2grauCalcularX1(double b, double delta, double a) {
        return (-(b) + Math.sqrt(delta)) / (2 * a);
    }

    public static double equacao2grauCalcularX2(double b, double delta, double a) {
        return (-(b) - Math.sqrt(delta)) / (2 * a);
    }

    /**
     * Salva os valores reais de X em um mapa. Para pegar os valores, é bem simples...
     * double x1 = CalculoMatematico.equacao2grauCalcularX(b, delta, a).get("x1")
     * double x2 = CalculoMatematico.equacao2grauCalcularX(b, delta, a).get("x2")
     *
     * @param b     valor de b
     * @param delta valor do delta
     * @param a     valor de a
     * @return mapa com os valores de X
     */
    public static Map<String, Double> equacao2grauCalcularX(double b, double delta, double a) {
        Map<String, Double> valoresReaisDeX = new HashMap<>();

        valoresReaisDeX.put("x1", equacao2grauCalcularX1(b, delta, a));
        valoresReaisDeX.put("x2", equacao2grauCalcularX2(b, delta, a));

        return valoresReaisDeX;
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

    public static double calcular3anguloDeUmTrianguloReduzida(double angulo1, double angulo2) {
        return 180 - (angulo1 + angulo2);
    }

    public static double calcularHipotenusa(double a, double b) {
        double hipotenusa = 0;

        a = Math.pow(a, 2);
        b = Math.pow(b, 2);

        hipotenusa = a + b;
        hipotenusa = Math.sqrt(hipotenusa);

        return hipotenusa;
    }

    public static double calcularHipotenusaReduzida(double a, double b) {
        return hypot(a, b);
    }

}
