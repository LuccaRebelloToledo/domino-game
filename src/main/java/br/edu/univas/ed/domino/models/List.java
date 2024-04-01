package br.edu.univas.ed.domino.models;

public class List {
    private Node first;
    private Node last;

    public List() {}

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

    public boolean isEmpty() {
        return this.getFirst() == null;
    }

    public boolean isIndexOutOfBounds(Integer index) {
        return this.isEmpty() || index < 0 || index >= this.getSize();
    }

    public Integer getSize() {
        if (this.isEmpty()) return 0;

        Node current = this.getFirst();
        Integer size = 0;

        while (current != null) {
            size++;

            current = current.getNext();
        }

        return size;
    }

    public Piece getPiece(Integer index) {
        if (this.isIndexOutOfBounds(index)) return null;

        Node current = this.getFirst();

        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current.getPiece();
    }

    public void add(Piece piece) {
        Node node = new Node(piece);

        if (this.isEmpty()) {
            this.setFirst(node);
        } else {
            this.getLast().setNext(node);
            node.setPrevious(this.getLast());
        }

        this.setLast(node);
    }

    public boolean remove(Integer index) {
        if (this.isIndexOutOfBounds(index)) return false;

        Node current = this.getFirst();
        Integer size = this.getSize();

        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        if (size == 1) {
            this.first = null;
            this.last = null;
        } else if (size == 2 && index == 0) {
            this.setFirst(this.getLast());
            this.getFirst().setPrevious(null);
        } else {
            removeNode(current);
        }

        return true;
    }

    private void removeNode(Node node) {
        Node previousNode = node.getPrevious();
        Node nextNode = node.getNext();

        if (previousNode != null) {
            previousNode.setNext(nextNode);
        } else {
            this.setFirst(nextNode);
            this.getFirst().setPrevious(null);
        }

        if (nextNode != null) {
            nextNode.setPrevious(previousNode);
        } else {
            this.setLast(previousNode);
            this.getLast().setNext(null);
        }
    }

    public void print() {
        if(this.isEmpty()) return;

        Node current = this.getFirst();
        StringBuilder stringBuilder = new StringBuilder();

        while (current != null) {
            stringBuilder.append(current.getPiece().toString()).append(" - ");

            current = current.getNext();
        }

        // Remove the last " - " from the string
        if (stringBuilder.length() > 0) {
            stringBuilder.setLength(stringBuilder.length() - 3); // 3 is the length of " - "
        }

        System.out.println(stringBuilder);
    }
}
