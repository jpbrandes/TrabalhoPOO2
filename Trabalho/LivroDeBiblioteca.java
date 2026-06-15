package Trabalho;

import javax.swing.JOptionPane;

public class LivroDeBiblioteca extends Livro implements ItemDeBiblioteca {
    private boolean emprestado;

    public LivroDeBiblioteca(String nome, String autor, int anoEdicao) {
        super(nome, autor, anoEdicao);
        this.emprestado = false;
    }

    @Override
    public void emprestarItem() throws MinhaExcecao {
        if (this.emprestado) {
            throw new MinhaExcecao("Erro: O livro '" + getNome() + "' já está emprestado!");
        }
        this.emprestado = true;
        JOptionPane.showMessageDialog(null, "Livro '" + getNome() + "' emprestado com sucesso.");
    }

    @Override
    public void devolverItem() throws MinhaExcecao {
        if (!this.emprestado) {
            throw new MinhaExcecao("Erro: O livro '" + getNome() + "' não está emprestado para ser devolvido!");
        }
        this.emprestado = false;
        JOptionPane.showMessageDialog(null, "Livro '" + getNome() + "' devolvido com sucesso.");
    }

    @Override
    public boolean verificarSeEmprestado() {
        return this.emprestado;
    }

    @Override
    public void informar() {
        System.out.println("Este livro pertence à Biblioteca.");
    }

    @Override
    public String toString() {
        return super.toString() + "\nStatus: " + (emprestado ? "Emprestado" : "Disponível");
    }
}