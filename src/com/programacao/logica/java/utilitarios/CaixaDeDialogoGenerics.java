package com.programacao.logica.java.utilitarios;

import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showInputDialog;

/**
 * Nessa classe eu usei os generics, um pouco de reflection e também um padrão de projetos chamado singleton
 * - Generics para que o código possa ser usado em qualquer classe
 * - Reflections para para saber qual é a classe que você quer e retornar ela em vez de um Object
 * - Singleton é para reaproveitar uma única instância, foi o mais próximo de um static que eu consegui lembrar (Sorry)
 */
public class CaixaDeDialogoGenerics {

    /**
     * Aqui é o que representa a instância da clase
     */
    private static CaixaDeDialogoGenerics instance;

    /**
     * Construtor privado para que apenas a própia classe tenha controle de suas proprias instânicas
     */
    private CaixaDeDialogoGenerics() {
    }

    /**
     * É aqui que o show acontece!
     * Para chamar ela é bem fácil, só fazer isso:
     *      CaixaDeDialogoGenerics.getInstance().converterValorDaCaixaDialogo("69", Integer.class);
     *
     * @param mensagem  texto que está no JOptionPane
     * @param classType tipo que você quer (int ou double)
     * @param <T>       Tipo da classe que vai vir
     * @return valor em INT ou DOUBLE
     */
    public <T extends Number> T converterValorDaCaixaDialogo(String mensagem, Class<T> classType) {
        try {
            if (verificaTipoDaMensagem(classType, Integer.class.getSimpleName())) {
                return castMensagem(mensagem, classType);
            }
            if (verificaTipoDaMensagem(classType, Double.class.getSimpleName())) {
                return castMensagem(mensagem, classType);
            }
        } catch (NumberFormatException numberFormatException) {
            MensagemPersonalizada.mensagemErro(
                    "Por favor, insira somente números (inteiros, ou decimais).",
                    "Erro"
            );
        }
        return null;
    }

    /**
     * Aqui só converte o generics para a classe desejada
     *
     * @param mensagem  texto que está no JOptionPane
     * @param classType tipo que você quer (int ou double)
     * @param <T>       Tipo da classe que vai vir
     * @return valor em INT ou DOUBLE
     */
    private <T extends Number> T castMensagem(String mensagem, Class<T> classType) {
        return classType.cast(parseInt(showInputDialog(mensagem)));
    }

    /**
     * Aqui só verifica o nome da classe
     *
     * @param classType  Tipo Passado por parâmetro
     * @param simpleName nome da classe que tá no converterValorDaCaixaDialogo()
     * @param <T>        Tipo da classe
     * @return true se for a classe informada, caso contrario, false
     */
    private <T extends Number> boolean verificaTipoDaMensagem(Class<T> classType, String simpleName) {
        return classType.getSimpleName().equals(simpleName);
    }

    /**
     * Controla a instância da classe.
     *
     * @return instância da classe
     */
    public static CaixaDeDialogoGenerics getInstance() {
        return instance == null
                ? new CaixaDeDialogoGenerics()
                : instance;
    }

}
