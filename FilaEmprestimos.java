public class FilaEmprestimos { // Classe que implementa uma fila circular para gerenciar empréstimos
    private static final int CAPACIDADE = 20; // Constante que define o tamanho máximo da fila
    private Livro[] fila; // Array para armazenar os livros na fila
    private int inicio, fim, tamanho; // Variáveis para controlar a posição inicial, final e tamanho atual da fila
    
    public FilaEmprestimos() { // Construtor da fila
        fila = new Livro[CAPACIDADE]; // Inicializa o array com a capacidade definida
        inicio = 0; // Inicializa o índice de início com 0
        fim = -1; // Inicializa o índice de fim com -1 (fila vazia)
        tamanho = 0; // Inicializa o tamanho com 0 (fila vazia)
    }
    
    public boolean enfileirar(Livro livro) { // Método para adicionar um livro ao final da fila
        if (tamanho >= CAPACIDADE) { // Verifica se a fila está cheia
            return false; // Retorna falso indicando que não foi possível enfileirar
        }
        
        fim = (fim + 1) % CAPACIDADE; // Avança o índice de fim ciclicamente (fila circular)
        fila[fim] = livro; // Armazena o livro na posição de fim
        tamanho++; // Incrementa o tamanho da fila
        return true; // Retorna verdadeiro indicando sucesso
    }
    
    public Livro desenfileirar() { // Método para remover e retornar o livro do início da fila
        if (tamanho <= 0) { // Verifica se a fila está vazia
            return null; // Retorna nulo indicando que não há livros na fila
        }
        
        Livro livro = fila[inicio]; // Obtém o livro do início da fila
        inicio = (inicio + 1) % CAPACIDADE; // Avança o índice de início ciclicamente (fila circular)
        tamanho--; // Decrementa o tamanho da fila
        return livro; // Retorna o livro removido
    }
    
    public Livro consultarProximo() { // Método para consultar (sem remover) o próximo livro da fila
        if (tamanho <= 0) { // Verifica se a fila está vazia
            return null; // Retorna nulo indicando que não há livros na fila
        }
        return fila[inicio]; // Retorna o livro no início da fila sem removê-lo
    }
    
    public boolean estaVazia() { // Método para verificar se a fila está vazia
        return tamanho == 0; // Retorna verdadeiro se o tamanho for 0
    }
    
    public void listarEmprestimos() { // Método para listar todos os livros na fila de empréstimos
        if (tamanho == 0) { // Verifica se a fila está vazia
            System.out.println("Não há empréstimos pendentes."); // Mensagem indicando fila vazia
            return; // Retorna sem fazer mais nada
        }
        
        System.out.println("\n=== Fila de Empréstimos ==="); // Cabeçalho da listagem
        int pos = inicio; // Começa da posição inicial da fila
        for (int i = 0; i < tamanho; i++) { // Percorre todos os elementos da fila
            System.out.println((i + 1) + ". " + fila[pos]); // Imprime o número de ordem e o livro
            pos = (pos + 1) % CAPACIDADE; // Avança para a próxima posição ciclicamente
        }
        System.out.println("========================="); // Rodapé da listagem
    }
}
