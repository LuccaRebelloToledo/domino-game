package br.edu.univas.ed.domino.models;

import br.edu.univas.ed.domino.dtos.BiggestPieceDto;
import br.edu.univas.ed.domino.views.Output;

public class Player {
    private List hand;
    private Output output;

    public Player(List hand) {
        this.setHand(hand);
        this.setOutput(new Output());
    }

    public List getHand() {
        return this.hand;
    }

    public void setHand(List hand) {
        this.hand = hand;
    }

    public Output getOutput() {
        return this.output;
    }

    public void setOutput(Output output) {
        this.output = output;
    }

    public void printHand() {
        Node current = this.getHand().getFirst();
        int position = 0;

        while (current != null) {
            Piece piece = current.getPiece();

            if (piece != null) {
                this.getOutput().showPositionAndPiece(position + 1, piece.toString());
            }

            position++;
            current = current.getNext();
        }

        this.getOutput().showNewLine();
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
