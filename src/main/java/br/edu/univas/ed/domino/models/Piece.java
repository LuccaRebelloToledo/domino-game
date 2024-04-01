package br.edu.univas.ed.domino.models;

public class Piece {
    private Integer left;
    private Integer right;

    public Piece(Integer left, Integer right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "[" + this.getLeft().toString() + "|" + this.getRight().toString() + "]";
    }

    public Integer getLeft() {
        return this.left;
    }

    public void setLeft(Integer left) {
        this.left = left;
    }

    public Integer getRight() {
        return this.right;
    }

    public void setRight(Integer right) {
        this.right = right;
    }
}
