package ArvoresNaoBinarias;

public class MainNArvore {
    public static void main(String[] args) {
        Arvore<Integer> arvore = new Arvore<>();

        NoArvore<Integer> n1 = new NoArvore<>(1);
        NoArvore<Integer> n2 = new NoArvore<>(2);
        NoArvore<Integer> n3 = new NoArvore<>(3);
        NoArvore<Integer> n4 = new NoArvore<>(4);
        NoArvore<Integer> n5 = new NoArvore<>(5);

        n1.inserirFilho(n2);
        n1.inserirFilho(n3);
        n2.inserirFilho(n4);
        n2.inserirFilho(n5);

        arvore.setRaiz(n1);

        System.out.println("Árvore está vazia? " + arvore.getRaiz() == null);
        System.out.println("Conteúdo da árvore: " + arvore.toString());
        System.out.println("Número de nós: " + arvore.contarNos());
        System.out.println("Pertence o valor 3? " + arvore.pertence(3));
        System.out.println("Pertence o valor 6? " + arvore.pertence(6));
    }
}

