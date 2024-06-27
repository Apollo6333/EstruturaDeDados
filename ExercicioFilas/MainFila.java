package ExercicioFilas;

import java.util.Scanner;

public class MainFila {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o limite da fila: ");
        int limite = scanner.nextInt();
        FilaVetor<Integer> fila = new FilaVetor<>(limite);

        int opcao;
        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Inserir");
            System.out.println("2 - Retirar");
            System.out.println("3 - Ver início");
            System.out.println("4 - Verificar se está vazia");
            System.out.println("5 - Liberar fila");
            System.out.println("6 - Exibir fila");
            System.out.println("7 - Concatenar com outra fila");
            System.out.println("8 - Reduzir a lista");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Informe o valor para inserir: ");
                    int valor = scanner.nextInt();
                    try {
                        fila.inserir(valor);
                        System.out.println("Valor inserido com sucesso.");
                    } catch (FilaCheiaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        int retirado = fila.retirar();
                        System.out.println("Valor retirado: " + retirado);
                    } catch (FilaVaziaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        int inicio = fila.peek();
                        System.out.println("Início da fila: " + inicio);
                    } catch (FilaVaziaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    if (fila.estaVazia()) {
                        System.out.println("A fila está vazia.");
                    } else {
                        System.out.println("A fila não está vazia.");
                    }
                    break;
                case 5:
                    fila.liberar();
                    System.out.println("Fila liberada.");
                    break;
                case 6:
                    System.out.println("Conteúdo da fila: " + fila.toString());
                    break;
                case 7:
                    System.out.print("Informe o limite da nova fila para concatenar: ");
                    int limiteConcatenar = scanner.nextInt();
                    FilaVetor<Integer> novaFila = new FilaVetor<>(limiteConcatenar);
                    System.out.println("Informe os valores para a nova fila (até " + limiteConcatenar + " valores): ");
                    for (int i = 0; i < limiteConcatenar; i++) {
                        System.out.print("Valor " + (i + 1) + ": ");
                        int novoValor = scanner.nextInt();
                        try {
                            novaFila.inserir(novoValor);
                        } catch (FilaCheiaException e) {
                            System.out.println(e.getMessage());
                            break;
                        }
                    }
                    try {
                        FilaVetor<Integer> filaConcatenada = fila.criarFilaConcatenada(novaFila);
                        System.out.println("Fila concatenada: " + filaConcatenada.toString());
                    } catch (FilaCheiaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                    System.out.println("Reduzindo tamanho da lista");
                    fila.encolher();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
}
