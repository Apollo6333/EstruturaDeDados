package ListaDuplaEncadeada;

public class ListaDupla<T> {
    
    private NoListaDupla<T> primeiro;
    private NoListaDupla<T> ultimo;

    public ListaDupla() {
            primeiro = null;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
    }

    public NoListaDupla<T> getPrimeiro() {
        return primeiro;
    }

    public void inserir (T valor) {
        NoListaDupla<T> novo = new NoListaDupla<>(valor);
        novo.setInfo(valor);
        novo.setProximo(primeiro);
        novo.setAnterior(null);
    }

    public NoListaDupla<T> buscar(T valor) {
        NoListaDupla<T> atual = primeiro;
        while (atual != null) {
            if (atual.getInfo().equals(valor)) {
                return atual;  // Retorna o nó se o conteúdo for igual ao info
            }
            atual = atual.getProximo();
        }
        return null;  // Retorna null se o nó não for encontrado
    }

    public void retirar(T valor) {
        if (primeiro == null) {
            return;  // Não faz nada se a lista estiver vazia
        }

        if (primeiro.getInfo().equals(valor)) {
            primeiro = primeiro.getProximo();  // Remove o primeiro nó se o conteúdo for igual ao info
            return;
        }

        NoListaDupla<T> atual = primeiro;
        while (atual.getProximo() != null) {
            if (atual.getProximo().getInfo().equals(valor)) {
                atual.setProximo(atual.getProximo().getProximo());  // Remove o nó encontrado
                return;
            }
            atual = atual.getProximo();
        }
    }

    public void exibirOrdemInversa() {
        NoListaDupla<T> atual = ultimo;
        while (atual != null) {
            System.out.println(atual.getInfo());
            atual = atual.getAnterior();
        }
    }

    public void liberar() {
        NoListaDupla<T> atual = primeiro;
        while (atual != null) {
            NoListaDupla<T> proximo = atual.getProximo();
            atual.setProximo(null);
            atual.setAnterior(null);
            atual = proximo;
        }
        primeiro = null;
        ultimo = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        NoListaDupla<T> atual = primeiro;
        while (atual != null) {
            sb.append(atual.getInfo());
            if (atual.getProximo() != null) {
                sb.append(", ");  // Adiciona vírgula entre os nós
            }
            atual = atual.getProximo();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ListaDupla<Integer> lista = new ListaDupla<>();

        System.out.println("Inserindo elementos na lista:");
        lista.inserir(1);
        lista.inserir(2);
        lista.inserir(3);
        lista.inserir(4);

        System.out.println("Conteúdo da lista:");
        System.out.println(lista.toString());

        System.out.println("Exibindo elementos em ordem inversa:");
        lista.exibirOrdemInversa();

        System.out.println("Buscando o elemento 3:");
        NoListaDupla<Integer> buscado = lista.buscar(3);
        if (buscado != null) {
            System.out.println("Elemento 3 encontrado: " + buscado.getInfo());
        } else {
            System.out.println("Elemento 3 não encontrado");
        }

        System.out.println("Retirando o elemento 3:");
        lista.retirar(3);
        System.out.println("Conteúdo da lista após retirar o elemento 3:");
        System.out.println(lista);

        System.out.println("Liberando a lista:");
        lista.liberar();
        System.out.println("Conteúdo da lista após liberação:");
        System.out.println(lista);
    }
}
