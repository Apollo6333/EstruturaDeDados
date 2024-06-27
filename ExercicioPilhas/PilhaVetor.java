package ExercicioPilhas;

public class PilhaVetor<T> implements Pilha<T> {
    private T[] info;
    private int limite;
    private int tamanho;

    public PilhaVetor(int limite) {
        this.limite = limite;
        this.tamanho = 0;
        this.info = (T[]) new Object[limite];
    }

    @Override
    public void push(T info) throws PilhaCheiaException {
        if (tamanho == limite) {
            throw new PilhaCheiaException("A pilha está cheia.");
        }
        this.info[tamanho++] = info;
    }

    @Override
    public T pop() throws PilhaVaziaException {
        if (estaVazia()) {
            throw new PilhaVaziaException("A pilha está vazia.");
        }
        T valor = info[--tamanho];
        info[tamanho] = null; // Limpa a referência
        return valor;
    }

    @Override
    public T peek() throws PilhaVaziaException {
        if (estaVazia()) {
            throw new PilhaVaziaException("A pilha está vazia.");
        }
        return info[tamanho - 1];
    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public void liberar() {
        for (int i = 0; i < tamanho; i++) {
            info[i] = null;
        }
        tamanho = 0;
    }

    @Override
    public String toString() {
        if (estaVazia()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = tamanho - 1; i >= 0; i--) {
            sb.append(info[i]);
            if (i > 0) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public void concatenar(PilhaVetor<T> p) throws PilhaCheiaException {
        if (this.limite - this.tamanho < p.tamanho) {
            throw new PilhaCheiaException("Não há espaço suficiente na pilha para concatenar.");
        }
        for (int i = 0; i < p.tamanho; i++) {
            this.push(p.info[i]);
        }
    }
}
