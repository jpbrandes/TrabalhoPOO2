public class LivroDeBiblioteca extends Livro implements ItemDeBiblioteca {
    private boolean emprestado;
    private String nomeEmprestado;

    public LivroDeBiblioteca(String nome, String autor, int anoEdicao) {
        super(nome, autor, anoEdicao);
        this.emprestado = false;
        this.nomeEmprestado = null;
    }

    public String getNomeEmprestado() { return nomeEmprestado; }
    public void setNomeEmprestado(String nomeEmprestado) { this.nomeEmprestado = nomeEmprestado; }

    @Override
    public void emprestarItem() throws MinhaExcecao {
        if (emprestado) {
            throw new MinhaExcecao("O livro \"" + getNome() + "\" já está emprestado para " + nomeEmprestado + ".");
        }
        this.emprestado = true;
        System.out.println("Livro \"" + getNome() + "\" emprestado com sucesso.");
    }

    @Override
    public void devolverItem() throws MinhaExcecao {
        if (!emprestado) {
            throw new MinhaExcecao("O livro \"" + getNome() + "\" não está emprestado e não pode ser devolvido.");
        }
        this.emprestado = false;
        this.nomeEmprestado = null;
        System.out.println("Livro \"" + getNome() + "\" devolvido com sucesso.");
    }

    @Override
    public boolean estaEmprestado() {
        return emprestado;
    }

    @Override
    public void informar() {
        System.out.println("Este é um livro de BIBLIOTECA.");
    }

    @Override
    public String toString() {
        return "=== Livro de Biblioteca ===" +
               "\n" + super.toString() +
               "\nStatus: " + (emprestado ? "Emprestado para " + nomeEmprestado : "Disponível");
    }
}
