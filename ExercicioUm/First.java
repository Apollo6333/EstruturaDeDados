package ExercicioUm;

public class First {
    private int[] lista;
    private int tamanho;

    public void listaEstatica() {
        lista = new int[10];
        tamanho = 0;
    }

    private void redimensionar() {
        int[] listaRepo = new int[lista.length + 10];
        for (int i = 0; i < lista.length; i++) {
            listaRepo[i] = lista[i];
        }
        lista = listaRepo;
        System.out.println("10 espaços adicionados a sua lista.");
    }

    public void inserir() {
        
    }
}