package Trabalho;

import javax.swing.JOptionPane;

public class Principal {
    public static void main(String[] args) {
        Livro[] catalogo = new Livro[2];

        catalogo[0] = new LivroDeBiblioteca("O Senhor dos Anéis", "J.R.R. Tolkien", 1954);
        catalogo[1] = new LivroDeLivraria("Pai Rico, Pai Pobre", "Robert Kiyosaki", 1997, 59.90);

        try {
            catalogo[1].avaliar();
            
            if (catalogo[1] instanceof LivroDeLivraria) {
                LivroDeLivraria livroLivraria = (LivroDeLivraria) catalogo[1];
                JOptionPane.showMessageDialog(null, 
                        String.format("Preço do livro de livraria obtido: R$ %.2f", livroLivraria.getPreco()),
                        "Preço do Item", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (MinhaExcecao e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de Exceção", JOptionPane.ERROR_MESSAGE);
        }

        try {
            catalogo[0].avaliar();

            if (catalogo[0] instanceof LivroDeBiblioteca) {
                LivroDeBiblioteca livroBiblioteca = (LivroDeBiblioteca) catalogo[0];
                livroBiblioteca.devolverItem();
            }
        } catch (MinhaExcecao e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de Exceção", JOptionPane.ERROR_MESSAGE);
        }

        StringBuilder relatorioFinal = new StringBuilder("--- RELATÓRIO FINAL DO CATÁLOGO ---\n\n");
        for (Livro livro : catalogo) {
            relatorioFinal.append(livro.toString()).append(System.lineSeparator());
            relatorioFinal.append("-----------------------------------").append(System.lineSeparator());
            livro.informar();
        }

        JOptionPane.showMessageDialog(null, relatorioFinal.toString(), "Catálogo Final", JOptionPane.INFORMATION_MESSAGE);
    }
}