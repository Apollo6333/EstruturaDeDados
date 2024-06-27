package ArvoresBinaria;

public class ArvoreBinaria<T> {
    private NoArvoreBinaria<T> raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void setRaiz(NoArvoreBinaria<T> raiz) {
        this.raiz = raiz;
    }

    public boolean estaVazia() {
        return this.raiz == null;
    }

    private boolean pertence(NoArvoreBinaria<T> no, T info) {
        if (no == null) {
            return false;
        }
        if (no.getInfo().equals(info)) {
            return true;
        }
        return pertence(no.getEsquerda(), info) || pertence(no.getDireita(), info);
    }

    public boolean pertence(T info) {
        return pertence(raiz, info);
    }

    private String arvorePre(NoArvoreBinaria<T> no) {
        if (no == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(no.getInfo().toString()).append(" ");
        sb.append(arvorePre(no.getEsquerda()));
        sb.append(arvorePre(no.getDireita()));
        return sb.toString();
    }

    @Override
    public String toString() {
        return arvorePre(raiz).trim();
    }

    private int contarNos(NoArvoreBinaria<T> no) {
        if (no == null) {
            return 0;
        }
        return 1 + contarNos(no.getEsquerda()) + contarNos(no.getDireita());
    }

    public int contarNos() {
        return contarNos(raiz);
    }

    public int contarFolhas(NoArvoreBinaria<T> sa) {
        // Esse método faz a contagem contando ambos, ele checa quantas folhas cada lado possui, por 
        // percorrer a árvore e retornar valores positivos sempre que acha uma folha.
        if (sa == null) {
            return 0;
        } 
        // O primeiro if checa se a árvore é vazia, já que em caso positivo, o resultado será 0, 
        // visto que não existem nós, portanto, não existem folhas.
        else if (sa.getEsquerda() == null && sa.getDireita() == null) {
            return 1;
        }
        // Para o segundo if, verifica se o nó atual é uma folha, checando se existem valores, na árvore, abaixo
        // dele, se faz isso por meio de comparar as variáveis "direita" e "esquera" com null,
        // e no caso positivo de ambos valores forem null, retorna o valor 1
        else {
            int folhasEsquerda = contarFolhas(sa.getEsquerda());
            int folhasDireita = contarFolhas(sa.getDireita());
            return folhasEsquerda + folhasDireita;
        }
        // Caso o nó atual não seja nulo e nem uma folha, chama recursivamente a função
        // para contar, percorrendo a árvore, e somando todas as folhas na subárvore do
        // lado esquerda e na subárvore do lado direito, o resultado sendo a soma do valor de ambos os lados.
    }
}
