import java.util.Scanner;

public abstract class Livro {
    private String nome;
    private String autor;
    private int anoEdicao;
    private int avaliacao;

    public Livro(String nome, String autor, int anoEdicao) {
        this.nome = nome;
        this.autor = autor;
        this.anoEdicao = anoEdicao;
        this.avaliacao = 0;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public int getAnoEdicao() { return anoEdicao; }
    public void setAnoEdicao(int anoEdicao) { this.anoEdicao = anoEdicao; }

    public int getAvaliacao() { return avaliacao; }
    public void setAvaliacao(int avaliacao) { this.avaliacao = avaliacao; }

    public void avaliar() throws MinhaExcecao {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a avaliação do livro \"" + nome + "\" (0 a 10): ");
        int nota = scanner.nextInt();
        if (nota < 0 || nota > 10) {
            throw new MinhaExcecao("Avaliação inválida: " + nota + ". A nota deve estar entre 0 e 10.");
        }
        this.avaliacao = nota;
        System.out.println("Avaliação registrada com sucesso: " + nota);
    }

    public abstract void informar();

    @Override
    public String toString() {
        return "Nome: " + nome +
               "\nAutor: " + autor +
               "\nAno da Edição: " + anoEdicao +
               "\nAvaliação: " + avaliacao + "/10";
    }
}
