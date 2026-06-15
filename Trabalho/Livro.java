package Trabalho;

import javax.swing.JOptionPane;

public abstract class Livro {
    private String nome;
    private String autor;
    private int anoEdicao;
    private int avaliacao;

    public Livro(String nome, String autor, int anoEdicao) {
        this.nome = nome;
        this.autor = autor;
        this.anoEdicao = anoEdicao;
        this.avaliacao = 0; // Inicializa com 0
    }

    public void avaliar() throws MinhaExcecao {
        String input = JOptionPane.showInputDialog(null, 
                "Digite a avaliação para o livro '" + this.nome + "' (entre 0 e 10):", 
                "Avaliação", JOptionPane.QUESTION_MESSAGE);
        
        if (input == null) {
            throw new MinhaExcecao("Avaliação cancelada pelo usuário.");
        }

        try {
            int nota = Integer.parseInt(input);
            if (nota < 0 || nota > 10) {
                throw new MinhaExcecao("Nota inválida! A avaliação deve ser um número inteiro entre 0 e 10.");
            }
            this.avaliacao = nota;
            JOptionPane.showMessageDialog(null, "Avaliação registrada com sucesso!");
        } catch (NumberFormatException e) {
            throw new MinhaExcecao("Entrada inválida! Você deve digitar um número inteiro.");
        }
    }

    public abstract void informar();

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public int getAnoEdicao() { return anoEdicao; }
    public void setAnoEdicao(int anoEdicao) { this.anoEdicao = anoEdicao; }

    public int getAvaliacao() { return avaliacao; }
    public void setAvaliacao(int avaliacao) { this.avaliacao = avaliacao; }

    @Override
    public String toString() {
        return "Nome: " + nome + "\nAutor: " + autor + "\nAno: " + anoEdicao + "\nAvaliação: " + avaliacao;
    }
}