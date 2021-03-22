package sample;

public class NoLista {
    private Integer info;
    private NoLista prox;

    public NoLista() {
        new NoLista(null, null);
    }

    public NoLista(Integer info, NoLista prox) {
        this.info = info;
        this.prox = prox;
    }

    public Integer getInfo() {
        return info;
    }

    public void setInfo(Integer info) {
        this.info = info;
    }

    public NoLista getNext() {
        return prox;
    }

    public void setNext(NoLista prox) {
        this.prox = prox;
    }
}
