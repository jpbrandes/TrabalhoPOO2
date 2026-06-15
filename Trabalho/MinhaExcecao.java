package Trabalho;

public class MinhaExcecao extends Exception {
    private static final long serialVersionUID = 1L;

    public MinhaExcecao(String mensagem) {
        super(mensagem);
    }
}