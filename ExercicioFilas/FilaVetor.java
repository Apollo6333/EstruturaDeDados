package ExercicioFilas;

import java.util.Arrays;

public class FilaVetor<T> implements Fila<T> {
    private T[] info;
    private int limite;
    private int tamanho;
    private int inicio;

    public FilaVetor(int limite) {
        this.limite = limite;
        this.tamanho = 0;
        this.inicio = 0;
        this.info = (T[]) new Object[limite];
    }

    @Override
    public void inserir(T valor) throws FilaCheiaException {
        if (tamanho == limite) {
            throw new FilaCheiaException("A fila está cheia.");
        }
        int fim = (inicio + tamanho) % limite;
        info[fim] = valor;
        tamanho++;
    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public T peek() throws FilaVaziaException {
        if (estaVazia()) {
            throw new FilaVaziaException("A fila está vazia.");
        }
        return info[inicio];
    }

    @Override
    public T retirar() throws FilaVaziaException {
        if (estaVazia()) {
            throw new FilaVaziaException("A fila está vazia.");
        }
        T valor = info[inicio];
        info[inicio] = null; // Limpa a referência
        inicio = (inicio + 1) % limite;
        tamanho--;
        return valor;
    }

    @Override
    public void liberar() {
        for (int i = 0; i < tamanho; i++) {
            info[(inicio + i) % limite] = null;
        }
        tamanho = 0;
        inicio = 0;
    }

    public FilaVetor<T> criarFilaConcatenada(FilaVetor<T> f2) throws FilaCheiaException {
        if (this.limite + f2.limite < this.tamanho + f2.tamanho) {
            throw new FilaCheiaException("Não há espaço suficiente para concatenar as filas.");
        }

        FilaVetor<T> novaFila = new FilaVetor<>(this.tamanho + f2.tamanho);

        for (int i = 0; i < this.tamanho; i++) {
            novaFila.inserir(this.info[(this.inicio + i) % this.limite]);
        }

        for (int i = 0; i < f2.tamanho; i++) {
            novaFila.inserir(f2.info[(f2.inicio + i) % f2.limite]);
        }

        return novaFila;
    }

    @Override
    public String toString() {
        if (estaVazia()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tamanho; i++) {
            sb.append(info[(inicio + i) % limite]);
            if (i < tamanho - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public int getLimite() {
        return this.limite;
    }
}
