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
}
