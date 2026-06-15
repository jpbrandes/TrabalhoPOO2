package Trabalho;

public class LivroDeLivraria extends Livro {
    private double preco;

    public LivroDeLivraria(String nome, String autor, int anoEdicao, double preco) {
        super(nome, autor, anoEdicao);
        this.preco = preco;
    }

    @Override
    public void informar() {
        System.out.println("Este livro pertence à Livraria (Para Venda).");
    }

    // Getters e Setters
    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    @Override
    public String toString() {
        return super.toString() + String.format("\nPreço: R$ %.2f", preco);
    }
}