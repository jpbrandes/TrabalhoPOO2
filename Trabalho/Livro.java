package Trabalho;

import javax.swing.JOptionPane;

public abstract class Livro {
    private static final int NOTA_MINIMA = 0;
    private static final int NOTA_MAXIMA = 10;

    private String nome;
    private String autor;
    private int anoEdicao;
    private int avaliacao;

    public Livro(String nome, String autor, int anoEdicao) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do livro não pode ser vazio.");
        }
        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("O autor do livro não pode ser vazio.");
        }
        this.nome = nome;
        this.autor = autor;
        this.anoEdicao = anoEdicao;
        this.avaliacao = NOTA_MINIMA; 
    }

    public void avaliar() throws MinhaExcecao {
        String input = JOptionPane.showInputDialog(null, 
                "Digite a avaliação para o livro '" + this.nome + "' (" + NOTA_MINIMA + " a " + NOTA_MAXIMA + "):", 
                "Avaliação do Livro", JOptionPane.QUESTION_MESSAGE);
        
        if (input == null) {
            throw new MinhaExcecao("Avaliação cancelada pelo usuário.");
        }

        try {
            int nota = Integer.parseInt(input.trim());
            this.setAvaliacao(nota);
            JOptionPane.showMessageDialog(null, "Avaliação registrada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            throw new MinhaExcecao("Entrada inválida! Você deve digitar um número inteiro válido.");
        }
    }

    public abstract void informar();

    public String getNome() { 
        return nome; 
    }
    
    public void setNome(String nome) { 
        this.nome = nome; 
    }

    public String getAutor() { 
        return autor; 
    }
    
    public void setAutor(String autor) { 
        this.autor = autor; 
    }

    public int getAnoEdicao() { 
        return anoEdicao; 
    }
    
    public void setAnoEdicao(int anoEdicao) { 
        this.anoEdicao = anoEdicao; 
    }

    public int getAvaliacao() { 
        return avaliacao; 
    }
    
    public void setAvaliacao(int avaliacao) throws MinhaExcecao {
        if (avaliacao < NOTA_MINIMA || avaliacao > NOTA_MAXIMA) {
            throw new MinhaExcecao("Nota inválida! A avaliação deve ser um número inteiro entre " + NOTA_MINIMA + " e " + NOTA_MAXIMA + ".");
        }
        this.avaliacao = avaliacao; 
    }

    @Override
    public String toString() {
        return "Nome: " + nome + 
               "\nAutor: " + autor + 
               "\nAno de Edição: " + anoEdicao + 
               "\nAvaliação: " + avaliacao + "/10";
    }
}