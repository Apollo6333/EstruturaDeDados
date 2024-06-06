package ListaDuplaEncadeada;

public class ListaDupla<T> {
    
    private NoListaDupla<T> primeiro;

    public ListaDupla() {
            primeiro = null;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
    }

    public NoListaDupla<T> getPrimeiro() {
        return primeiro;
    }

    public void inserir (T info) {
        NoListaDupla<T> novo = new NoListaDupla<>();
        novo.setInfo(info);
        novo.setProximo(primeiro);
        novo.setAnterior(null);
    }
}
