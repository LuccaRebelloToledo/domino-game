package br.edu.univas.ed.domino.models;

import br.edu.univas.ed.domino.dtos.BiggestPieceDto;
import br.edu.univas.ed.domino.views.Output;

public class Game {
    private Player human;
    private Player computer;
    private Table table;
    private Output output;
    public final String LEFT = "L";
    public final String RIGHT = "R";

    public Game(Player human, Player computer, Table table, Output output) {
        this.setHuman(human);
        this.setComputer(computer);
        this.setTable(table);
        this.setOutput(output);
    }

    public Player getHuman() {
        return this.human;
    }

    public void setHuman(Player human) {
        this.human = human;
    }

    public Player getComputer() {
        return this.computer;
    }

    public void setComputer(Player computer) {
        this.computer = computer;
    }

    public Table getTable() {
        return this.table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public Output getOutput() {
        return output;
    }

    public void setOutput(Output output) {
        this.output = output;
    }

    public boolean isGameOver() {
        // The game is over when one player has played all their pieces
        return this.getHuman().getHand().isEmpty() || this.getComputer().getHand().isEmpty();
    }

    public Player initialize() {
        // Generate all pieces
        List allPieces = this.generatePieces();

        // Distribute them between the players
        // Human player
        this.distributePieces(this.getHuman(), allPieces);

        // Computer player
        this.distributePieces(this.getComputer(), allPieces);

        // Stock
        this.populateGameStockWithRemainingPieces(allPieces);

        // Biggest Piece
        BiggestPieceDto biggestHumanDto = this.getHuman().biggestPiece();
        BiggestPieceDto biggestComputerDto = this.getComputer().biggestPiece();

        if (biggestHumanDto == null || biggestComputerDto == null) {
            this.initialize();
            return null;
        } else {
            return getCurrentPlayer(biggestHumanDto, biggestComputerDto);
        }
    }

    private List generatePieces() {
        // Create all domino pieces
        List allPieces = new List();

        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                Piece piece = new Piece(i, j);
                allPieces.add(piece);
            }
        }

        // Shuffle the pieces
        allPieces.shuffle();

        return allPieces;
    }

    private void distributePieces(Player player, List allPieces) {
        for (int i = 0; i < 7; i++) {
            int randomIndex = (int) (Math.random() * allPieces.getSize());
            player.getHand().add(allPieces.getPiece(randomIndex));
            allPieces.remove(randomIndex);
        }
    }

    private void populateGameStockWithRemainingPieces(List allPieces) {
        int remainingPiecesSize = allPieces.getSize() - 1;

        for (int i = remainingPiecesSize; i >= 0; i--) {
            this.getTable().getStock().add(allPieces.getPiece(i));
            allPieces.remove(i);
        }
    }

    private Player compareBiggestPlayerPieces(Piece pieceHuman, Piece pieceComputer) {
        if (pieceHuman.getLeft() > pieceComputer.getLeft()) {
            return this.getHuman();
        }

        return this.getComputer();
    }

    private Player getCurrentPlayer(BiggestPieceDto biggestHumanDto, BiggestPieceDto biggestComputerDto) {
        Player currentPlayer = this.compareBiggestPlayerPieces(biggestHumanDto.piece(), biggestComputerDto.piece());

        if (currentPlayer == this.getHuman()) {
            this.getHuman().getHand().remove(biggestHumanDto.position());

            this.placeInitialPiece(biggestHumanDto.piece());

            this.getOutput().humanStartedTheGame();

            currentPlayer = this.getComputer();
        } else {
            this.getComputer().getHand().remove(biggestComputerDto.position());

            this.placeInitialPiece(biggestComputerDto.piece());

            this.getOutput().computerStartedTheGame();

            currentPlayer = this.getHuman();
        }

        return currentPlayer;
    }

    private void placeInitialPiece(Piece piece) {
        this.getTable().addPieceToLeft(piece);
        this.getTable().addPieceToRight(piece);
    }

    public boolean playPiece(Player player, int position, String side) {
        Piece piece = player.getHand().getPiece(position);
        Piece lastPiece = null;

        if (LEFT.equalsIgnoreCase(side)) {
            lastPiece = this.getTable().getLeft().getLast().getPiece();
        } else if (RIGHT.equalsIgnoreCase(side)) {
            lastPiece = this.getTable().getRight().getLast().getPiece();
        }

        if (lastPiece != null && (piece.getRight().equals(lastPiece.getRight()) || piece.getLeft().equals(lastPiece.getRight()))) {
            if (piece.getRight().equals(lastPiece.getRight())) {
                piece.flip();
            }

            if (LEFT.equalsIgnoreCase(side)) {
                this.getTable().addPieceToLeft(piece);
            } else {
                this.getTable().addPieceToRight(piece);
            }

            player.getHand().remove(position);
            return true;
        }

        return false;
    }

    public void buyPiece(Player player) {
        List stock = this.getTable().getStock();

        int randomIndex = (int) (Math.random() * stock.getSize());
        player.getHand().add(stock.getPiece(randomIndex));
        stock.remove(randomIndex);
    }
}
