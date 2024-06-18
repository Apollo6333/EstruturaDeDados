package ExercicioPilhas;

public class PilhaVetor<T> implements Pilha<T> {
    
    private T[] info;
    private int limite;
    private int tamanho;

    public PilhaVetor(int limite) {
        info = (T[]) new Object[limite];

    }

    @Override
    public void push(T info) {
        if (tamanho == limite) {
            throw new PilhaCheiaException();
        }
        this.info[tamanho] = info;
        tamanho++;
    }

    @Override
    public T peek() {
        if (estaVazia()) {
            throw new PilhaVaziaException();
        }
        return info[tamanho - 1];
    }

    @Override
    public T pop() {
        T valor = peek();
        info[tamanho - 1] = null;
        tamanho--;

        return valor;
    }

    @Override
    public boolean estaVazia() {
        return (tamanho == 0);
    }

    @Override
    public void liberar() {

        //1 implementação
        info = (T[]) new Object[limite];
        tamanho = 0;

        //2 implementação
        while (estaVazia()) {
            pop();
        }
    }

    @Override
    public String toString() {
        String resultado = "";

        for (int i = tamanho - 1; i >= 0; i--) {
            resultado += info[i].toString();
            if (i > 0) {
                resultado = resultado + ",";
            }
        }

        return resultado;
    }

    @Override
    public void concatenar(PilhaVetor<T> p2) {
        for (int i = tamanho - 1; i >= 0; i--) {
        this.push(p2.info[i]);
        }
    }
}
