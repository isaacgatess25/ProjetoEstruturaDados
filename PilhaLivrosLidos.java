public class PilhaLivrosLidos { // Classe que implementa uma pilha para gerenciar livros lidos
    private static final int CAPACIDADE = 20; // Constante que define o tamanho máximo da pilha
    private Livro[] pilha; // Array para armazenar os livros na pilha
    private int topo; // Variável para controlar a posição do topo da pilha
    
    public PilhaLivrosLidos() { // Construtor da pilha
        pilha = new Livro[CAPACIDADE]; // Inicializa o array com a capacidade definida
        topo = -1; // Inicializa o topo com -1 (pilha vazia)
    }
    
    public boolean push(Livro livro) { // Método para adicionar um livro no topo da pilha
        if (topo >= CAPACIDADE - 1) { // Verifica se a pilha está cheia
            return false; // Retorna falso indicando que não foi possível adicionar
        }
        
        topo++; // Incrementa o índice do topo
        pilha[topo] = livro; // Armazena o livro na posição do topo
        return true; // Retorna verdadeiro indicando sucesso
    }
    
    public Livro pop() { // Método para remover e retornar o livro do topo da pilha
        if (topo < 0) { // Verifica se a pilha está vazia
            return null; // Retorna nulo indicando que não há livros na pilha
        }
        
        Livro livro = pilha[topo]; // Obtém o livro do topo
        topo--; // Decrementa o índice do topo
        return livro; // Retorna o livro removido
    }
    
    public Livro peek() { // Método para consultar (sem remover) o livro do topo da pilha
        if (topo < 0) { // Verifica se a pilha está vazia
            return null; // Retorna nulo indicando que não há livros na pilha
        }
        return pilha[topo]; // Retorna o livro no topo sem removê-lo
    }
    
    public boolean estaVazia() { // Método para verificar se a pilha está vazia
        return topo < 0; // Retorna verdadeiro se o topo for menor que 0
    }
    
    public void listarLivrosLidos() { // Método para listar todos os livros lidos (do mais recente ao mais antigo)
        if (topo < 0) { // Verifica se a pilha está vazia
            System.out.println("Não há livros lidos registrados."); // Mensagem indicando pilha vazia
            return; // Retorna sem fazer mais nada
        }
        
        System.out.println("\n=== Livros Lidos (do mais recente ao mais antigo) ==="); // Cabeçalho da listagem
        for (int i = topo; i >= 0; i--) { // Percorre do topo até a base da pilha
            System.out.println(pilha[i]); // Imprime as informações de cada livro
        }
        System.out.println("==================================================="); // Rodapé da listagem
    }
}
