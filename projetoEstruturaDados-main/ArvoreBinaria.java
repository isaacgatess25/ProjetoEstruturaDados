public class ArvoreBinaria { // Classe que implementa a estrutura de dados árvore binária de busca
    private class No { // Classe interna que representa cada nó da árvore
        Livro livro; // Armazena o objeto livro neste nó
        No esquerda; // Referência para o nó filho à esquerda (códigos menores)
        No direita; // Referência para o nó filho à direita (códigos maiores)
        
        public No(Livro livro) { // Construtor do nó
            this.livro = livro; // Atribui o livro ao nó
            esquerda = null; // Inicializa o filho esquerdo como nulo
            direita = null; // Inicializa o filho direito como nulo
        }
    }
    
    private No raiz; // Referência para o nó raiz da árvore
    
    public ArvoreBinaria() { // Construtor da árvore
        raiz = null; // Inicializa a árvore vazia (sem raiz)
    }
    
    public void inserir(Livro livro) { // Método público para inserir um livro na árvore
        raiz = inserirNo(raiz, livro); // Chama o método recursivo passando a raiz atual
    }
    
    private No inserirNo(No no, Livro livro) { // Método privado recursivo para inserção
        // Se o nó atual for nulo, cria um novo nó com o livro
        if (no == null) { // Se chegou a um ponto de inserção (folha)
            return new No(livro); // Cria e retorna um novo nó com o livro
        }
        
        // Se o código do livro for menor, insere à esquerda
        if (livro.getCodigo() < no.livro.getCodigo()) { // Compara o código do livro com o código do nó atual
            no.esquerda = inserirNo(no.esquerda, livro); // Continua a busca pelo ponto de inserção no lado esquerdo
        } 
        // Se o código for maior, insere à direita
        else if (livro.getCodigo() > no.livro.getCodigo()) { // Caso o código seja maior
            no.direita = inserirNo(no.direita, livro); // Continua a busca pelo ponto de inserção no lado direito
        }
        // Se o código já existir, não faz nada (não permite duplicados)
        
        return no; // Retorna o nó atual (possivelmente modificado)
    }
    
    public Livro buscar(int codigo) { // Método público para buscar um livro pelo código
        return buscarNo(raiz, codigo); // Chama o método recursivo passando a raiz
    }
    
    private Livro buscarNo(No no, int codigo) { // Método privado recursivo para busca
        // Se chegou ao fim da árvore ou encontrou o código
        if (no == null) { // Se o nó atual é nulo, o livro não foi encontrado
            return null; // Retorna nulo indicando que o livro não existe na árvore
        }
        
        if (codigo == no.livro.getCodigo()) { // Se encontrou o livro com o código procurado
            return no.livro; // Retorna o livro encontrado
        }
        
        // Decide se continua a busca à esquerda ou à direita
        if (codigo < no.livro.getCodigo()) { // Se o código buscado é menor que o do nó atual
            return buscarNo(no.esquerda, codigo); // Continua a busca no lado esquerdo
        } else { // Se o código buscado é maior que o do nó atual
            return buscarNo(no.direita, codigo); // Continua a busca no lado direito
        }
    }
    
    public void exibirEmOrdem() { // Método público para exibir os livros em ordem crescente de código
        System.out.println("\n=== Livros em Ordem por Código ==="); // Imprime o cabeçalho da listagem
        exibirEmOrdemNo(raiz); // Chama o método recursivo passando a raiz
        System.out.println("================================"); // Imprime o rodapé da listagem
    }
    
    private void exibirEmOrdemNo(No no) { // Método privado recursivo para percorrer a árvore em ordem
        if (no != null) { // Se o nó não for nulo (existe)
            // Visita o filho à esquerda
            exibirEmOrdemNo(no.esquerda); // Processa primeiro o lado esquerdo (valores menores)
            // Visita o próprio nó
            System.out.println(no.livro); // Imprime o livro do nó atual
            // Visita o filho à direita
            exibirEmOrdemNo(no.direita); // Por último, processa o lado direito (valores maiores)
        }
    }
}
