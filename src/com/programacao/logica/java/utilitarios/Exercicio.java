package com.programacao.logica.java.utilitarios;

public interface Exercicio {
    default void executarExercicio(){
        visualizarEnunciado();
        solicitarDadosUsuario();
        visualizarResposta();
    }
    void visualizarEnunciado();
    void visualizarResposta();
    void solicitarDadosUsuario();
}
