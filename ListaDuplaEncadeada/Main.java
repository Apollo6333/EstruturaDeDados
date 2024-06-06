package ListaDuplaEncadeada;

public class Main {
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
