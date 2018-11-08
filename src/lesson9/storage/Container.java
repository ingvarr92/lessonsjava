package lesson9.storage;

class Container <T> { // можное использовать любой тип данных
    T element;

    Container next;

    public Container(T element) {
        this.element = element;
    }
}
