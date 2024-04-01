package br.edu.univas.ed.domino.models;

public class Table {
    private List left;
    private List right;
    private List stock;

    public Table(List left, List right, List stock) {
        this.setLeft(left);
        this.setRight(right);
        this.setStock(stock);
    }

    public List getLeft() {
        return this.left;
    }

    public void setLeft(List left) {
        this.left = left;
    }

    public List getRight() {
        return this.right;
    }

    public void setRight(List right) {
        this.right = right;
    }

    public List getStock() {
        return this.stock;
    }

    public void setStock(List stock) {
        this.stock = stock;
    }

    public void addPieceToLeft(Piece piece) {
        this.getLeft().add(piece);
    }

    public void addPieceToRight(Piece piece) {
        this.getRight().add(piece);
    }
}
