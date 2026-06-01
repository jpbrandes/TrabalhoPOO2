public class LivroDeLivraria extends Livro {
    private double preco;

    public LivroDeLivraria(String nome, String autor, int anoEdicao, double preco) {
        super(nome, autor, anoEdicao);
        this.preco = preco;
    }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    @Override
    public void informar() {
        System.out.println("Este é um livro de LIVRARIA.");
    }

    @Override
    public String toString() {
        return "=== Livro de Livraria ===" +
               "\n" + super.toString() +
               "\nPreço: R$ " + String.format("%.2f", preco);
    }
}
