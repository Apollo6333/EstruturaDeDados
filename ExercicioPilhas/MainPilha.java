package ExercicioPilhas;

import java.util.Scanner;

public class MainPilha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o limite da pilha: ");
        int limite = scanner.nextInt();
        PilhaVetor<Integer> pilha = new PilhaVetor<>(limite);

        int opcao;
        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Empilhar");
            System.out.println("2 - Desempilhar");
            System.out.println("3 - Ver topo");
            System.out.println("4 - Verificar se está vazia");
            System.out.println("5 - Liberar pilha");
            System.out.println("6 - Exibir pilha");
            System.out.println("7 - Concatenar com outra pilha");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Informe o valor para empilhar: ");
                    int valor = scanner.nextInt();
                    try {
                        pilha.push(valor);
                        System.out.println("Valor empilhado com sucesso.");
                    } catch (PilhaCheiaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        int desempilhado = pilha.pop();
                        System.out.println("Valor desempilhado: " + desempilhado);
                    } catch (PilhaVaziaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        int topo = pilha.peek();
                        System.out.println("Topo da pilha: " + topo);
                    } catch (PilhaVaziaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    if (pilha.estaVazia()) {
                        System.out.println("A pilha está vazia.");
                    } else {
                        System.out.println("A pilha não está vazia.");
                    }
                    break;
                case 5:
                    pilha.liberar();
                    System.out.println("Pilha liberada.");
                    break;
                case 6:
                    System.out.println("Conteúdo da pilha: " + pilha.toString());
                    break;
                case 7:
                    System.out.print("Informe o limite da nova pilha para concatenar: ");
                    int limiteConcatenar = scanner.nextInt();
                    PilhaVetor<Integer> novaPilha = new PilhaVetor<>(limiteConcatenar);
                    System.out.println("Informe os valores para a nova pilha (até " + limiteConcatenar + " valores): ");
                    for (int i = 0; i < limiteConcatenar; i++) {
                        System.out.print("Valor " + (i + 1) + ": ");
                        int novoValor = scanner.nextInt();
                        try {
                            novaPilha.push(novoValor);
                        } catch (PilhaCheiaException e) {
                            System.out.println(e.getMessage());
                            break;
                        }
                    }
                    try {
                        pilha.concatenar(novaPilha);
                        System.out.println("Pilhas concatenadas com sucesso.");
                    } catch (PilhaCheiaException e) {
                        System.out.println(e.getMessage());
                    }
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