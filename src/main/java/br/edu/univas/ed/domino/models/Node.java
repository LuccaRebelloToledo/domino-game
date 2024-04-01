package br.edu.univas.ed.domino.models;

public class Node {

    private Node previous;
    private Piece piece;
    private Node next;

    public Node getPrevious() {
        return this.previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Piece getPiece() {
        return this.piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
