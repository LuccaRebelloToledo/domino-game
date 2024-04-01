package br.edu.univas.ed.domino.models;

import br.edu.univas.ed.domino.dtos.BiggestPieceDto;

public class Player {
    private List hand;

    public Player(List hand) {
        this.setHand(hand);
    }

    public List getHand() {
        return this.hand;
    }

    public void setHand(List hand) {
        this.hand = hand;
    }

    public void printHand() {
        Node current = this.getHand().getFirst();
        int position = 0;

        while (current != null) {
            Piece piece = current.getPiece();

            if (piece != null) {
                System.out.println((position + 1) + " - " + piece);
            }

            position++;
            current = current.getNext();
        }

        System.out.println();
    }

    public BiggestPieceDto biggestPiece() {
        if (this.getHand().isEmpty()) return null;

        BiggestPieceDto biggestPieceDto = null;

        Piece biggestPiece = null;
        int position = 0;
        int biggestPosition = 0;

        Node current = this.getHand().getFirst();

        while (current != null) {
            Piece currentPiece = current.getPiece();

            if (currentPiece != null && currentPiece.getLeft().equals(currentPiece.getRight())) {
                Piece previousBiggestPiece = biggestPiece;
                biggestPiece = getBiggerPiece(biggestPiece, currentPiece);

                if (biggestPiece != previousBiggestPiece) {
                    biggestPosition = position;
                }
            }

            position++;
            current = current.getNext();
        }

        if (biggestPiece != null) {
            biggestPieceDto = new BiggestPieceDto(biggestPiece, biggestPosition);
        }

        return biggestPieceDto;
    }

    private Piece getBiggerPiece(Piece pieceOne, Piece pieceTwo) {
        if (pieceOne == null || pieceTwo.getLeft() > pieceOne.getLeft()) {
            return pieceTwo;
        }

        return pieceOne;
    }
}
