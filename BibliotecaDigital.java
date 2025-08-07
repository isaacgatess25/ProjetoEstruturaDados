import java.util.Scanner; // Importa a classe Scanner para leitura de entrada do usuário

public class BibliotecaDigital { // Classe principal que gerencia o sistema da biblioteca
    private static ListaDeLivros listaDeLivros = new ListaDeLivros(); // Cria a lista para gerenciar livros
    private static PilhaLivrosLidos pilhaLivrosLidos = new PilhaLivrosLidos(); // Cria a pilha para livros lidos
    private static FilaEmprestimos filaEmprestimos = new FilaEmprestimos(); // Cria a fila para empréstimos
    private static ArvoreBinaria arvoreBinaria = new ArvoreBinaria(); // Cria a árvore binária para busca
    private static Scanner scanner = new Scanner(System.in); // Inicializa o Scanner para leitura de entrada

    public static void main(String[] args) { // Método principal que inicia o programa
        int opcao; // Variável para armazenar a opção escolhida pelo usuário

        do { // Loop principal do programa
            exibirMenu(); // Exibe o menu de opções
            opcao = lerOpcao(); // Lê a opção escolhida pelo usuário

            executarOpcao(opcao); // Executa a operação correspondente à opção escolhida

        } while (opcao != 0); // Continua executando até o usuário escolher sair (opção 0)

        scanner.close(); // Fecha o Scanner ao finalizar o programa
        System.out.println("Programa finalizado. Até mais!"); // Mensagem de despedida
    }
    
    private static void exibirMenu() { // Método para exibir o menu de opções
        System.out.println("\n===== BIBLIOTECA DIGITAL ====="); // Cabeçalho do menu
        System.out.println("1. Cadastrar novo livro"); // Opção para cadastrar livro
        System.out.println("2. Listar todos os livros"); // Opção para listar livros
        System.out.println("3. Ordenar livros por título"); // Opção para ordenar livros
        System.out.println("4. Buscar livro por código"); // Opção para buscar livro
        System.out.println("5. Registrar livro como lido"); // Opção para registrar livro lido
        System.out.println("6. Exibir pilha de livros lidos"); // Opção para ver livros lidos
        System.out.println("7. Adicionar livro à fila de empréstimos"); // Opção para adicionar à fila de empréstimos
        System.out.println("8. Realizar empréstimo (próximo da fila)"); // Opção para realizar empréstimo
        System.out.println("9. Exibir fila de empréstimos"); // Opção para ver fila de empréstimos
        System.out.println("10. Exibir livros em ordem crescente por código (árvore)"); // Opção para ver árvore ordenada
        System.out.println("0. Sair"); // Opção para sair do programa
        System.out.print("Escolha uma opção: "); // Solicita a entrada do usuário
    }
    
    private static int lerOpcao() { // Método para ler e validar a opção do usuário
        int opcao = -1; // Inicializa com valor inválido
        try { // Tenta converter a entrada para um número
            opcao = Integer.parseInt(scanner.nextLine()); // Lê a linha e converte para inteiro
        } catch (NumberFormatException e) { // Captura erro se a entrada não for um número
            // Em caso de erro, retorna -1
        }
        return opcao; // Retorna a opção lida ou -1 se for inválida
    }
    
    private static void executarOpcao(int opcao) { // Método para executar a opção escolhida
        switch (opcao) { // Estrutura switch para tratar cada opção
            case 1: // Caso seja a opção 1
                cadastrarLivro(); // Chama o método para cadastrar livro
                break; // Encerra o switch
            case 2: // Caso seja a opção 2
                listaDeLivros.listarLivros(); // Lista todos os livros
                break; // Encerra o switch
            case 3: // Caso seja a opção 3
                listaDeLivros.ordenarPorTitulo(); // Ordena os livros por título
                System.out.println("Livros ordenados por título!"); // Mensagem de confirmação
                listaDeLivros.listarLivros(); // Exibe a lista ordenada
                break; // Encerra o switch
            case 4: // Caso seja a opção 4
                buscarLivroPorCodigo(); // Chama o método para buscar livro
                break; // Encerra o switch
            case 5: // Caso seja a opção 5
                registrarLivroLido(); // Chama o método para registrar livro como lido
                break; // Encerra o switch
            case 6: // Caso seja a opção 6
                pilhaLivrosLidos.listarLivrosLidos(); // Lista os livros lidos
                break; // Encerra o switch
            case 7: // Caso seja a opção 7
                adicionarLivroAFila(); // Chama o método para adicionar livro à fila
                break; // Encerra o switch
            case 8: // Caso seja a opção 8
                realizarEmprestimo(); // Chama o método para realizar empréstimo
                break; // Encerra o switch
            case 9: // Caso seja a opção 9
                filaEmprestimos.listarEmprestimos(); // Lista a fila de empréstimos
                break; // Encerra o switch
            case 10: // Caso seja a opção 10
                arvoreBinaria.exibirEmOrdem(); // Exibe os livros em ordem crescente por código
                break; // Encerra o switch
            case 0: // Caso seja a opção 0
                // Sair do programa (nada a fazer aqui, o loop principal vai terminar)
                break; // Encerra o switch
            default: // Caso seja qualquer outra opção
                System.out.println("Opção inválida! Tente novamente."); // Mensagem de erro
        }
    }
    
    private static void cadastrarLivro() { // Método para cadastrar um novo livro
        try { // Bloco try para tratar possíveis erros
            System.out.print("Digite o código do livro: "); // Solicita o código
            int codigo = Integer.parseInt(scanner.nextLine()); // Lê e converte para inteiro
            
            System.out.print("Digite o título do livro: "); // Solicita o título
            String titulo = scanner.nextLine(); // Lê o título
            
            System.out.print("Digite o autor do livro: "); // Solicita o autor
            String autor = scanner.nextLine(); // Lê o autor
            
            Livro livro = new Livro(codigo, titulo, autor); // Cria um novo objeto Livro
            
            if (listaDeLivros.adicionarLivro(livro)) { // Tenta adicionar o livro à lista
                System.out.println("Livro cadastrado com sucesso!"); // Mensagem de sucesso
                arvoreBinaria.inserir(livro); // Adiciona na árvore também
            } else { // Se não conseguir adicionar
                System.out.println("Não foi possível cadastrar o livro. Lista cheia ou código duplicado."); // Mensagem de erro
            }
        } catch (NumberFormatException e) { // Captura erro se o código não for um número válido
            System.out.println("Erro: O código deve ser um número!"); // Mensagem de erro
        }
    }
    
    private static void buscarLivroPorCodigo() { // Método para buscar livro por código
        try { // Bloco try para tratar possíveis erros
            System.out.print("Digite o código do livro: "); // Solicita o código
            int codigo = Integer.parseInt(scanner.nextLine()); // Lê e converte para inteiro
            
            System.out.println("\nBuscando na lista:"); // Informa que está buscando na lista
            long inicioLista = System.nanoTime(); // Marca o tempo inicial da busca na lista
            Livro livroLista = listaDeLivros.buscarPorCodigo(codigo); // Busca o livro na lista
            long fimLista = System.nanoTime(); // Marca o tempo final da busca na lista
            
            System.out.println("\nBuscando na árvore:"); // Informa que está buscando na árvore
            long inicioArvore = System.nanoTime(); // Marca o tempo inicial da busca na árvore
            Livro livroArvore = arvoreBinaria.buscar(codigo); // Busca o livro na árvore
            long fimArvore = System.nanoTime(); // Marca o tempo final da busca na árvore
            
            if (livroLista != null) { // Se o livro foi encontrado
                System.out.println("Livro encontrado: " + livroLista); // Mostra o livro encontrado
                System.out.println("Tempo de busca na lista: " + (fimLista - inicioLista) + " ns"); // Mostra o tempo da busca na lista
                System.out.println("Tempo de busca na árvore: " + (fimArvore - inicioArvore) + " ns"); // Mostra o tempo da busca na árvore
            } else { // Se o livro não foi encontrado
                System.out.println("Livro não encontrado!"); // Mensagem de livro não encontrado
            }
        } catch (NumberFormatException e) { // Captura erro se o código não for um número válido
            System.out.println("Erro: O código deve ser um número!"); // Mensagem de erro
        }
    }
    
    private static void registrarLivroLido() { // Método para registrar um livro como lido
        try { // Bloco try para tratar possíveis erros
            System.out.print("Digite o código do livro lido: "); // Solicita o código
            int codigo = Integer.parseInt(scanner.nextLine()); // Lê e converte para inteiro
            
            Livro livro = listaDeLivros.buscarPorCodigo(codigo); // Busca o livro pelo código
            
            if (livro != null) { // Se o livro foi encontrado
                if (pilhaLivrosLidos.push(livro)) { // Tenta adicionar o livro à pilha de lidos
                    System.out.println("Livro '" + livro.getTitulo() + "' registrado como lido!"); // Mensagem de sucesso
                } else { // Se a pilha estiver cheia
                    System.out.println("Não foi possível registrar: pilha de livros lidos está cheia."); // Mensagem de erro
                }
            } else { // Se o livro não foi encontrado
                System.out.println("Livro não encontrado!"); // Mensagem de livro não encontrado
            }
        } catch (NumberFormatException e) { // Captura erro se o código não for um número válido
            System.out.println("Erro: O código deve ser um número!"); // Mensagem de erro
        }
    }
    
    private static void adicionarLivroAFila() { // Método para adicionar livro à fila de empréstimos
        try { // Bloco try para tratar possíveis erros
            System.out.print("Digite o código do livro para empréstimo: "); // Solicita o código
            int codigo = Integer.parseInt(scanner.nextLine()); // Lê e converte para inteiro
            
            Livro livro = listaDeLivros.buscarPorCodigo(codigo); // Busca o livro pelo código
            
            if (livro != null) { // Se o livro foi encontrado
                if (filaEmprestimos.enfileirar(livro)) { // Tenta adicionar o livro à fila de empréstimos
                    System.out.println("Livro '" + livro.getTitulo() + "' adicionado à fila de empréstimos!"); // Mensagem de sucesso
                } else { // Se a fila estiver cheia
                    System.out.println("Não foi possível adicionar: fila de empréstimos está cheia."); // Mensagem de erro
                }
            } else { // Se o livro não foi encontrado
                System.out.println("Livro não encontrado!"); // Mensagem de livro não encontrado
            }
        } catch (NumberFormatException e) { // Captura erro se o código não for um número válido
            System.out.println("Erro: O código deve ser um número!"); // Mensagem de erro
        }
    }
    
    private static void realizarEmprestimo() { // Método para realizar o empréstimo do próximo livro na fila
        Livro livro = filaEmprestimos.desenfileirar(); // Remove o próximo livro da fila
        
        if (livro != null) { // Se havia um livro na fila
            System.out.println("Empréstimo realizado: " + livro); // Mensagem de sucesso com detalhes do livro
        } else { // Se a fila estiver vazia
            System.out.println("Não há livros na fila de empréstimos."); // Mensagem informando que não há livros
        }
    }
}
