package ArvoresNaoBinarias;

public class Arvore<T> {
    private NoArvore<T> raiz;

    public Arvore() {
        this.raiz = null;
    }

    public void setRaiz(NoArvore<T> raiz) {
        this.raiz = raiz;
    }

    public NoArvore<T> getRaiz() {
        return this.raiz;
    }

    private String obterRepresentacaoTextual(NoArvore<T> no) {
        if (no == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(no.getInfo().toString()).append(" ");
        NoArvore<T> filho = no.getPrimeiro();
        while (filho != null) {
            sb.append(obterRepresentacaoTextual(filho));
            filho = filho.getProximo();
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return obterRepresentacaoTextual(raiz).trim();
    }

    private boolean pertence(NoArvore<T> no, T info) {
        if (no == null) {
            return false;
        }
        if (no.getInfo().equals(info)) {
            return true;
        }
        NoArvore<T> filho = no.getPrimeiro();
        while (filho != null) {
            if (pertence(filho, info)) {
                return true;
            }
            filho = filho.getProximo();
        }
        return false;
    }

    public boolean pertence(T info) {
        return pertence(raiz, info);
    }

    private int contarNos(NoArvore<T> no) {
        if (no == null) {
            return 0;
        }
        int count = 1;
        NoArvore<T> filho = no.getPrimeiro();
        while (filho != null) {
            count += contarNos(filho);
            filho = filho.getProximo();
        }
        return count;
    }

    public int contarNos() {
        return contarNos(raiz);
    }
}

