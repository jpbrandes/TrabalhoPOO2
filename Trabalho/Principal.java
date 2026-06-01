public class Principal {
    public static void main(String[] args) {

        Livro[] livros = new Livro[2];
        livros[0] = new LivroDeBiblioteca("Dom Casmurro", "Machado de Assis", 1899);
        livros[1] = new LivroDeLivraria("O Senhor dos Anéis", "J.R.R. Tolkien", 1954, 89.90);

        LivroDeBiblioteca livroBiblioteca = (LivroDeBiblioteca) livros[0];
        LivroDeLivraria livroLivraria = (LivroDeLivraria) livros[1];

        System.out.println("--- Tipo dos livros ---");
        livroBiblioteca.informar();
        livroLivraria.informar();
        System.out.println();

        System.out.println("--- Livro de Livraria ---");

        try {
            livroLivraria.avaliar();
        } catch (MinhaExcecao e) {
            System.out.println("Erro na avaliação: " + e.getMessage());
        }

        System.out.println("Preço do livro: R$ " + String.format("%.2f", livroLivraria.getPreco()));
        System.out.println();

        System.out.println("--- Livro de Biblioteca ---");

        try {
            livroBiblioteca.avaliar();
        } catch (MinhaExcecao e) {
            System.out.println("Erro na avaliação: " + e.getMessage());
        }

        try {
            livroBiblioteca.devolverItem();
        } catch (MinhaExcecao e) {
            System.out.println("Erro ao devolver: " + e.getMessage());
        }
        System.out.println();

        System.out.println("===== Informações dos Livros =====");
        System.out.println(livros[0].toString());
        System.out.println();
        System.out.println(livros[1].toString());
    }
}
