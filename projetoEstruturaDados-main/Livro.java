public class Livro { // Classe que representa um livro
    private int codigo; // Código identificador único do livro
    private String titulo; // Título do livro
    private String autor; // Nome do autor do livro

    public Livro(int codigo, String titulo, String autor) { // Construtor da classe
        this.codigo = codigo; // Inicializa o código com o valor recebido
        this.titulo = titulo; // Inicializa o título com o valor recebido
        this.autor = autor; // Inicializa o autor com o valor recebido
    }

    public int getCodigo() { // Método para obter o código do livro
        return codigo; // Retorna o código
    }

    public String getTitulo() { // Método para obter o título do livro
        return titulo; // Retorna o título
    }

    public String getAutor() { // Método para obter o autor do livro
        return autor; // Retorna o autor
    }

    @Override
    public String toString() { // Sobrescreve o método toString para exibir informações do livro
        return "Livro [código=" + codigo + ", título=" + titulo + ", autor=" + autor + "]"; // Retorna uma string formatada com os dados do livro
    }
}
