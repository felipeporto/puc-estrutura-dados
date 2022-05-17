public class Lista {

    private No primeiro = null;

    public No getPrimeiro() {
        return primeiro;
    }

    /**
     * Valida se a lista está vazia
     */
    public boolean vazia() {
        return this.primeiro == null;
    }

    /**
     * Imprime no console todos os elementos da lista
     */
    public void mostrar() {
        for(No no = this.primeiro; no != null; no = no.getProximo()) {
            System.out.println(no.getInfo());
        }
    }

    /**
     * Insere um elemento no início da lista
     * @param info Informação a ser inserida na lista
     */
    public void inserePrimeiro(int info) {
        No novo = new No();
        novo.setInfo(info);
        novo.setProximo(this.primeiro);
        this.primeiro = novo;
    }

    /**
     * Insere um novo nó após o elemento informado.
     * Caso não encontre o elemento, insere no final da lista
     * @param no Nó em qual a nova informação será inserida após
     * @param info Nova informação a ser inserida
     */
    public void insereDepois(No no, int info) {
        for(No busca = this.primeiro; busca != null; busca = busca.getProximo()) {
            if (busca.getInfo() == no.getInfo()) {
                No novo = new No();
                novo.setInfo(info);
                novo.setProximo(busca.getProximo());
                busca.setProximo(novo);
                return;
            }
        }

        this.insereUltimo(info);
    }

    /**
     * Insere um novo elemento no final da lista.
     * Se a lista estiver vazia ele será o primeiro elemento.
     * @param info Informação a ser inserida
     */
    public void insereUltimo(int info) {
        if (this.vazia()) {
            this.inserePrimeiro(info);
            return;
        }

        No novo = new No();
        novo.setInfo(info);

        No busca = this.primeiro;
        while (busca.getProximo() != null)
            busca = busca.getProximo();

        busca.setProximo(novo);
    }

    /**
     * Remove e retorna o primeiro elemento da lista.
     * Caso a lista esteja vazia, retorna null
     * @return Elemento removido.
     */
    public No removePrimeiro() {
        if (this.vazia()) {
            return null;
        }

        No temp = this.primeiro;
        this.primeiro = this.primeiro.getProximo();
        return temp;
    }

    /**
     * Remove e retorna o último elemento da lista.
     * Caso a lista esteja vazia, retorna null
     * @return Elemento removido.
     */
    public No removeUltimo() {
        if (this.vazia()) {
            return null;
        }

        // Só tem um elemento na lista
        if (this.primeiro.getProximo() == null) {
            return this.removePrimeiro();
        }


        No busca = this.primeiro; // busca.getProximo() != null &&
        while (busca.getProximo().getProximo() != null)
            busca = busca.getProximo();

        No temp = busca.getProximo();
        busca.setProximo(null);
        return temp;
    }

    /**
     * Remove o nó passado como parametro
     * @param no Elemento a ser removido
     * @return Elemento removido.
     */
    public No remove(No no) {
        for(No busca = this.primeiro; busca != null; busca = busca.getProximo()) {
            if (busca.getProximo() != null && busca.getProximo().getInfo() == no.getInfo()) {
                No temp = busca.getProximo();
                busca.setProximo(temp.getProximo());
                return temp;
            }
        }

        return null;
    }
}
