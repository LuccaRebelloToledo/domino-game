package br.edu.univas.ed.domino.models;

public class List {
    private Node first;
    private Node last;

    public Node getFirst() {
        return this.first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public Node getLast() {
        return this.last;
    }

    public void setLast(Node last) {
        this.last = last;
    }
}
