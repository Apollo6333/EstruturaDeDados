package ListaEncadeada;

public class NoList<T> {
    private T info;
    private NoList<T> proximo;

    public NoList(T info) {
        this.info = info;    
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }
    
    public NoList<T> getProximo() {
        return proximo;
    }

    public void setProximo(NoList<T> proximo) {
        this.proximo = proximo;
    }
}
