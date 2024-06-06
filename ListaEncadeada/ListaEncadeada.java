package ListaEncadeada;

public class ListaEncadeada<T> {
    private NoList<T> primeiro;

    public ListaEncadeada() {
        this.primeiro = null;  // Inicializa a lista como vazia
    }

    public NoList<T> getPrimeiro() {
        return primeiro;  // Retorna o primeiro nó da lista
    }

    public void inserir(T info) {
        NoList<T> novoNo = new NoList<>(info);
        novoNo.setProximo(primeiro);
        primeiro = novoNo;  // Insere o novo nó no início da lista
    }

    public boolean estaVazia() {
        return primeiro == null;  // Retorna true se a lista estiver vazia
    }

    public NoList<T> buscar(T info) {
        NoList<T> atual = primeiro;
        while (atual != null) {
            if (atual.getInfo().equals(info)) {
                return atual;  // Retorna o nó se o conteúdo for igual ao info
            }
            atual = atual.getProximo();
        }
        return null;  // Retorna null se o nó não for encontrado
    }

    public void retirar(T info) {
        if (estaVazia()) {
            return;  // Não faz nada se a lista estiver vazia
        }

        if (primeiro.getInfo().equals(info)) {
            primeiro = primeiro.getProximo();  // Remove o primeiro nó se o conteúdo for igual ao info
            return;
        }

        NoList<T> atual = primeiro;
        while (atual.getProximo() != null) {
            if (atual.getProximo().getInfo().equals(info)) {
                atual.setProximo(atual.getProximo().getProximo());  // Remove o nó encontrado
                return;
            }
            atual = atual.getProximo();
        }
    }

    public int obterComprimento() {
        int comprimento = 0;
        NoList<T> atual = primeiro;
        while (atual != null) {
            comprimento++;  // Conta o número de nós na lista
            atual = atual.getProximo();
        }
        return comprimento;
    }

    public NoList<T> obterNo(int posicao) {
        if (posicao < 0 || posicao >= obterComprimento()) {
            throw new IndexOutOfBoundsException("Posição inválida: " + posicao);
        }

        NoList<T> atual = primeiro;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }
        return atual;  // Retorna o nó na posição especificada
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        NoList<T> atual = primeiro;
        while (atual != null) {
            sb.append(atual.getInfo());
            if (atual.getProximo() != null) {
                sb.append(", ");  // Adiciona vírgula entre os nós
            }
            atual = atual.getProximo();
        }
        return sb.toString();
    }
}
