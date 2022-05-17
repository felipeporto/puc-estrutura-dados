public class EstruturaDados {
    public static void main(String[] args) {
        testeRemover();
        separador();
        testeAdicionar();
        separador();
        testeVazia();
    }

    private static void separador() {
        System.out.print("\n\n---\n\n");
    }

    private static void testeRemover() {
        System.out.println("Testando métodos para Remover itens.");

        Lista lista = new Lista();
        lista.insereUltimo(10);
        lista.insereUltimo(20);
        lista.insereUltimo(30);
        lista.insereUltimo(40);
        lista.insereUltimo(50);

        System.out.println("Cria uma nova lista e insere alguns valores.");
        lista.mostrar();

        System.out.println("\nRemove o primeiro elemento.");
        No primeiro = lista.removePrimeiro();
        lista.mostrar();
        System.out.printf("Informação do primeiro elemento (que foi removido): %d.\n", primeiro.getInfo());

        System.out.println("\nRemove o último elemento.");
        No ultimo = lista.removeUltimo();
        lista.mostrar();
        System.out.printf("Informação do último elemento (que foi removido): %d.\n", ultimo.getInfo());

        System.out.println("\nRemove o segundo elemento da lista.");
        No removido = lista.remove(lista.getPrimeiro().getProximo());
        lista.mostrar();
        System.out.printf("Informação do elemento removido: %d.", removido.getInfo());
    }

    private static void testeAdicionar() {
        System.out.println("Testando métodos para Adicionar itens.");

        System.out.println("Cria uma nova lista e insere alguns valores.");
        Lista lista = new Lista();
        lista.mostrar();
        lista.inserePrimeiro(20);
        lista.inserePrimeiro(10); // como o número 10 é inserido na primeira posicão, ele será o primeiro item da lista
        lista.mostrar();

        System.out.println("\nAdiciona mais valores na lista.");
        lista.insereUltimo(30);
        lista.insereUltimo(40);

        // insere após o segundo elemento da lista (será o terceiro elemento)
        lista.insereDepois(lista.getPrimeiro().getProximo(), 25);

        lista.mostrar();
    }

    private static void testeVazia() {
        System.out.println("Testando método: Vazia");

        System.out.println("Inicia uma nova lista sem dados.");
        Lista lista = new Lista();

        System.out.printf("A lista está vazia? %s\n", lista.vazia() ? "Sim" : "Não");

        System.out.println("\nAdiciona um elemento na lista.");
        lista.inserePrimeiro(1);

        System.out.printf("A lista está vazia? %s\n", lista.vazia() ? "Sim" : "Não");
    }
}
