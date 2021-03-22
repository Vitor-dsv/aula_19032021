package sample;

import java.util.Objects;

public class ListaComEncadeamento {
    private NoLista first;
    private NoLista last;
    private Integer counter;

    ListaComEncadeamento() {
        this.first = null;
        this.last = null;
        this.counter = 0;
    }

    public void add(Integer item) {
        NoLista newNo = new NoLista(item, null);

        if (counter.equals(0)) {
            first = new NoLista(null, newNo);
        } else {
            boolean isLooping = true;
            NoLista noLista = this.first.getNext();

            do {
                if (Objects.isNull(noLista.getNext())) {
                    isLooping = false;

                    noLista.setNext(newNo);
                }

                noLista = noLista.getNext();
            } while (isLooping);
        }

        last = new NoLista(newNo.getInfo(), null);
        counter++;
    }

    public void add(int index, Integer item) throws Exception {
        indiceMaiorOuMenorTamanhoLista(index);

        if (this.counter.equals(0)) {
            NoLista newNo = new NoLista(item, null);
            this.first = new NoLista(null, newNo);
            this.last = new NoLista(item, null);
        } else {
            NoLista noListaLooping = this.first.getNext();
            NoLista noListaLoopingAnterior = this.first;
            boolean isLooping = true;
            int indexLooping = 0;

            do {
                if (indexLooping == index) {
                    isLooping = false;

                    NoLista newNo = new NoLista(item, noListaLooping);
                    noListaLoopingAnterior.setNext(newNo);
                } else {
                    noListaLoopingAnterior = noListaLooping;
                    noListaLooping = noListaLooping.getNext();
                    indexLooping++;
                }
            } while (isLooping);
        }

        counter++;
    }

    private void clear() {
        this.first = null;
        this.last = null;
        this.counter = 0;
    }

    private int size() {
        return this.counter;
    }

    private boolean isEmpty() {
        return this.counter.equals(0);
    }

    public Integer remove(int index) throws Exception {
        indiceMaiorOuMenorTamanhoLista(index);

        Integer oldValue = -1;

        NoLista noListaLooping = this.first.getNext();
        NoLista noListaLoopingAnterior = this.first;
        boolean isLooping = true;
        int indexLooping = 0;

        do {
            if (indexLooping == index) {
                oldValue = noListaLooping.getInfo();

                NoLista noReplace = noListaLooping.getNext();
                if (Objects.isNull(noReplace)) {
                    noListaLoopingAnterior.setNext(null);
                    this.last = noListaLoopingAnterior;
                } else {
                    noListaLoopingAnterior.setNext(noReplace);
                }

                isLooping = false;
            } else {
                noListaLoopingAnterior = noListaLooping;
                noListaLooping = noListaLooping.getNext();
                indexLooping++;
            }
        } while (isLooping);

        counter--;
        return oldValue;
    }

    public boolean removeFirst(Integer item) throws Exception {
        boolean retorno = false;
        NoLista noListaLooping = this.first.getNext();
        boolean isLooping = true;
        int indexLooping = 0;

        do {
            if (Objects.isNull(noListaLooping)) {
                isLooping = false;
            } else {
                if (noListaLooping.getInfo().equals(item)) {
                    this.remove(indexLooping);
                    isLooping = false;
                    retorno = true;
                } else {
                    noListaLooping = noListaLooping.getNext();
                    indexLooping++;
                }
            }
        } while (isLooping);

        return retorno;
    }

    public Integer get(int index) throws Exception {
        indiceMaiorOuMenorTamanhoLista(index);
        Integer item = -1;

        NoLista noListaLooping = this.first.getNext();
        boolean isLooping = true;
        int indexLooping = 0;

        do {
            if (index == indexLooping) {
                item = noListaLooping.getInfo();
                isLooping = false;
            } else {
                noListaLooping = noListaLooping.getNext();
                indexLooping++;
            }
        } while (isLooping);

        return item;
    }

    public Integer set(int index, Integer item) throws Exception {
        indiceMaiorOuMenorTamanhoLista(index);

        Integer retorno = -1;
        NoLista noListaLooping = this.first.getNext();
        NoLista noListaLoopingAnterior = this.first;
        boolean isLooping = true;
        int indexLooping = 0;

        do {
            if (index == indexLooping) {
                retorno = noListaLooping.getInfo();
                NoLista newNo = new NoLista(item, noListaLooping.getNext());
                noListaLoopingAnterior.setNext(newNo);
                isLooping = false;
            } else {
                noListaLoopingAnterior = noListaLooping;
                noListaLooping = noListaLooping.getNext();
                indexLooping++;
            }
        } while (isLooping);

        return retorno;
    }

    public boolean contains(Integer item) {
        boolean retorno = false;
        if (Objects.nonNull(this.first)) {
            NoLista noListaLooping = this.first.getNext();
            boolean isLooping = true;
            int indexLooping = 0;

            do {
                if (Objects.isNull(noListaLooping)) {
                    isLooping = false;
                } else {
                    if (noListaLooping.getInfo().equals(item)) {
                        isLooping = false;
                        retorno = true;
                    } else {
                        noListaLooping = noListaLooping.getNext();
                        indexLooping++;
                    }
                }
            } while (isLooping);
        }

        return retorno;
    }

    public int indexOf(Integer item) {
        int indice = -1;

        if (Objects.nonNull(this.first)) {
            NoLista noListaLooping = this.first.getNext();
            boolean isLooping = true;
            int indexLooping = 0;

            do {
                if (Objects.isNull(noListaLooping)) {
                    isLooping = false;
                } else {
                    if (noListaLooping.getInfo().equals(item)) {
                        indice = indexLooping;
                        isLooping = false;
                    } else {
                        noListaLooping = noListaLooping.getNext();
                        indexLooping++;
                    }
                }
            } while (isLooping);
        }

        return indice;
    }

    public int lastIndexOf(Integer item) {
        int indice = -1;

        if (Objects.nonNull(this.first)) {
            NoLista noListaLooping = this.first.getNext();
            boolean isLooping = true;
            int indexLooping = 0;

            do {
                if (Objects.isNull(noListaLooping)) {
                    isLooping = false;
                } else {
                    if (noListaLooping.getInfo().equals(item)) {
                        indice = indexLooping;
                    } else {
                        noListaLooping = noListaLooping.getNext();
                        indexLooping++;
                    }
                }
            } while (isLooping);
        }

        return indice;
    }

    public Integer[] toArray() {
        Integer[] array = new Integer[counter];

        if (Objects.nonNull(this.first)) {
            NoLista noListaLooping = this.first.getNext();
            boolean isLooping = true;
            int indexLoaping = 0;

            do {
                if (Objects.isNull(noListaLooping)) {
                    isLooping = false;
                } else {
                    array[indexLoaping] = noListaLooping.getInfo();
                    noListaLooping = noListaLooping.getNext();
                    indexLoaping++;
                }
            } while (isLooping);
        }

        return array;
    }

    private void indiceMaiorOuMenorTamanhoLista(int index) throws Exception {
        if (index >= counter) {
            throw new Exception("O index é maior do que o número de itens adicionados no array.");
        } else if (index < 0) {
            throw new Exception("O index é menor do que o número de itens adicionados no array.");
        }
    }
}
