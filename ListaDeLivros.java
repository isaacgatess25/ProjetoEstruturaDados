public class ListaDeLivros { // Classe que implementa uma lista para gerenciar os livros
    private static final int CAPACIDADE_MAXIMA = 20; // Constante que define o tamanho máximo da lista
    private Livro[] livros; // Array para armazenar os livros
    private int quantidadeLivros; // Variável para controlar a quantidade atual de livros

    public ListaDeLivros() { // Construtor da lista
        this.livros = new Livro[CAPACIDADE_MAXIMA]; // Inicializa o array com a capacidade definida
        this.quantidadeLivros = 0; // Inicializa a quantidade de livros com 0
    }

    public boolean adicionarLivro(Livro livro) { // Método para adicionar um livro à lista
        if (quantidadeLivros >= CAPACIDADE_MAXIMA) { // Verifica se a lista está cheia
            return false; // Retorna falso indicando que não foi possível adicionar
        }
        
        // Verifica se o código já existe
        for (int i = 0; i < quantidadeLivros; i++) { // Percorre os livros existentes
            if (livros[i].getCodigo() == livro.getCodigo()) { // Compara o código do livro novo com os existentes
                return false; // Retorna falso se encontrar código duplicado
            }
        }
        
        livros[quantidadeLivros] = livro; // Adiciona o livro na próxima posição disponível
        quantidadeLivros++; // Incrementa a quantidade de livros
        return true; // Retorna verdadeiro indicando sucesso
    }
    
    public Livro buscarPorCodigo(int codigo) { // Método para buscar um livro pelo código
        for (int i = 0; i < quantidadeLivros; i++) { // Percorre todos os livros
            if (livros[i].getCodigo() == codigo) { // Verifica se o código corresponde
                return livros[i]; // Retorna o livro encontrado
            }
        }
        return null; // Retorna nulo se o livro não for encontrado
    }
    
    public void ordenarPorTitulo() { // Método para ordenar os livros por título usando Bubble Sort
        // Implementação do Bubble Sort
        for (int i = 0; i < quantidadeLivros - 1; i++) { // Loop externo para controlar as passagens
            for (int j = 0; j < quantidadeLivros - i - 1; j++) { // Loop interno para comparação e troca
                if (livros[j].getTitulo().compareToIgnoreCase(livros[j + 1].getTitulo()) > 0) { // Compara os títulos ignorando maiúsculas/minúsculas
                    // Troca de posições
                    Livro temp = livros[j]; // Armazena temporariamente o livro atual
                    livros[j] = livros[j + 1]; // Move o próximo livro para a posição atual
                    livros[j + 1] = temp; // Coloca o livro temporário na próxima posição
                }
            }
        }
    }
    
    public void listarLivros() { // Método para listar todos os livros cadastrados
        if (quantidadeLivros == 0) { // Verifica se não há livros
            System.out.println("Não há livros cadastrados."); // Mensagem indicando lista vazia
            return; // Retorna sem fazer mais nada
        }
        
        System.out.println("\n=== Lista de Livros ==="); // Cabeçalho da listagem
        for (int i = 0; i < quantidadeLivros; i++) { // Percorre todos os livros
            System.out.println(livros[i]); // Imprime as informações de cada livro
        }
        System.out.println("======================"); // Rodapé da listagem
    }

    public int getQuantidadeLivros() { // Método para obter a quantidade atual de livros
        return quantidadeLivros; // Retorna a quantidade de livros
    }
    
    public Livro getLivro(int indice) { // Método para obter um livro pelo seu índice na lista
        if (indice >= 0 && indice < quantidadeLivros) { // Verifica se o índice é válido
            return livros[indice]; // Retorna o livro no índice especificado
        }
        return null; // Retorna nulo se o índice for inválido
    }
}
