package Trabalho;

public class LivroDeLivraria extends Livro {
    private double preco;

    public LivroDeLivraria(String nome, String autor, int anoEdicao, double preco) {
        super(nome, autor, anoEdicao);
        if (preco < 0) {
            throw new IllegalArgumentException("O preço do livro não pode ser negativo.");
        }
        this.preco = preco;
    }

    @Override
    public void informar() {
        System.out.println("Este livro pertence à Livraria (Para Venda).");
    }

    public double getPreco() { 
        return preco; 
    }
    
    public void setPreco(double preco) { 
        if (preco < 0) {
            throw new IllegalArgumentException("O preço do livro não pode ser negativo.");
        }
        this.preco = preco; 
    }

    @Override
    public String toString() {
        return super.toString() + String.format("\nPreço: R$ %.2f", preco);
    }
}