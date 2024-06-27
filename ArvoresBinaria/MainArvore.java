package ArvoresBinaria;

public class MainArvore {
    public static void main(String[] args) {
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();

        NoArvoreBinaria<Integer> n1 = new NoArvoreBinaria<>(1);
        NoArvoreBinaria<Integer> n2 = new NoArvoreBinaria<>(2);
        NoArvoreBinaria<Integer> n3 = new NoArvoreBinaria<>(3);
        NoArvoreBinaria<Integer> n4 = new NoArvoreBinaria<>(4);
        NoArvoreBinaria<Integer> n5 = new NoArvoreBinaria<>(5);

        n1.setEsquerda(n2);
        n1.setDireita(n3);
        n2.setEsquerda(n4);
        n2.setDireita(n5);

        arvore.setRaiz(n1);

        System.out.println("Árvore está vazia? " + arvore.estaVazia());
        System.out.println("Conteúdo da árvore (pré-ordem): " + arvore.toString());
        System.out.println("Número de nós: " + arvore.contarNos());
        System.out.println("Pertence o valor 3? " + arvore.pertence(3));
        System.out.println("Pertence o valor 6? " + arvore.pertence(6));
    }
}

