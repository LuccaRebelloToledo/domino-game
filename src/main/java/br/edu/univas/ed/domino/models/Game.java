package br.edu.univas.ed.domino.models;

import br.edu.univas.ed.domino.dtos.BiggestPieceDto;
import br.edu.univas.ed.domino.views.Output;

public class Game {
    private Player human;
    private Player computer;
    private Table table;
    private Output output;
    public static final String LEFT = "E";
    public static final String RIGHT = "D";

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

        if (biggestHumanDto == null && biggestComputerDto == null) {
            this.initialize();
            return null;
        } else {
            return this.getStartingPlayer(biggestHumanDto, biggestComputerDto);
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

    private Player getStartingPlayer(BiggestPieceDto biggestHumanDto, BiggestPieceDto biggestComputerDto) {
        Player startingPlayer = null;

        Player playerWithBiggestPiece;

        if (biggestHumanDto == null) {
            playerWithBiggestPiece = this.getComputer();
        } else if (biggestComputerDto == null) {
            playerWithBiggestPiece = this.getHuman();
        } else {
            playerWithBiggestPiece = this.compareBiggestPlayerPieces(biggestHumanDto.piece(), biggestComputerDto.piece());
        }

        if (playerWithBiggestPiece == this.getHuman() && biggestHumanDto != null) {
            this.getHuman().getHand().remove(biggestHumanDto.position());

            this.placeInitialPiece(biggestHumanDto.piece());

            this.getOutput().showHumanStartedTheGame();

            startingPlayer = this.getComputer();
        } else if (playerWithBiggestPiece == this.getComputer() && biggestComputerDto != null) {
            this.getComputer().getHand().remove(biggestComputerDto.position());

            this.placeInitialPiece(biggestComputerDto.piece());

            this.getOutput().showComputerStartedTheGame();

            startingPlayer = this.getHuman();
        }

        return startingPlayer;
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

    public boolean hasValidMove(Player player) {
        Piece lastPieceLeft = this.getTable().getLeft().getLast().getPiece();
        Piece lastPieceRight = this.getTable().getRight().getLast().getPiece();

        for (int i = 0; i < player.getHand().getSize(); i++) {
            Piece piece = player.getHand().getPiece(i);

            boolean isPiecePlayable = this.canPieceBePlayed(piece, lastPieceLeft, lastPieceRight);

            if (isPiecePlayable) {
                return true;
            }

        }

        return false;
    }

    public boolean neitherPlayerHasValidMove() {
        return this.stockIsEmpty() && !this.hasValidMove(this.getHuman()) && !this.hasValidMove(this.getComputer());
    }

    private boolean canPieceBePlayed(Piece currentPiece, Piece lastPieceOnLeft, Piece lastPieceOnRight) {
        boolean matchesRightEndOfLeftPiece = currentPiece.getLeft().equals(lastPieceOnLeft.getRight()) || currentPiece.getRight().equals(lastPieceOnLeft.getRight());

        boolean matchesRightEndOfRightPiece = currentPiece.getLeft().equals(lastPieceOnRight.getRight()) || currentPiece.getRight().equals(lastPieceOnRight.getRight());

        return matchesRightEndOfLeftPiece || matchesRightEndOfRightPiece;
    }

    public boolean stockIsEmpty() {
        return this.getTable().getStock().isEmpty();
    }

    public boolean canPlayerBuyAPiece(Player player) {
        return !this.stockIsEmpty() && !this.hasValidMove(player);
    }

    public void buyPiece(Player player) {
        if (this.stockIsEmpty()) {
            return;
        }

        List stock = this.getTable().getStock();

        int randomIndex = (int) (Math.random() * stock.getSize());
        player.getHand().add(stock.getPiece(randomIndex));
        stock.remove(randomIndex);
    }

    public void computerSelectAndPlayPiece(Game game, Player computer) {
        Piece lastPieceLeft = game.getTable().getLeft().getLast().getPiece();
        Piece lastPieceRight = game.getTable().getRight().getLast().getPiece();

        for (int i = 0; i < computer.getHand().getSize(); i++) {
            Piece piece = computer.getHand().getPiece(i);

            boolean isPiecePlayable = game.canPieceBePlayed(piece, lastPieceLeft, lastPieceRight);

            if (isPiecePlayable) {
                boolean playedPiece = game.playPiece(computer, i, Game.LEFT);

                if (!playedPiece) {
                    game.playPiece(computer, i, Game.RIGHT);
                }

                return;
            }
        }
    }

    public boolean canPlayerSkipTurn(Player player) {
        boolean hasValidMove = this.hasValidMove(player);
        boolean stockIsEmpty = this.stockIsEmpty();

        return !hasValidMove && stockIsEmpty;
    }

    private int calculatePlayerScore(Player player) {
        int score = 0;

        for (int i = 0; i < player.getHand().getSize(); i++) {
            Piece piece = player.getHand().getPiece(i);
            score += piece.getLeft() + piece.getRight();
        }

        return score;
    }

    public void getWinner() {
        if (neitherPlayerHasValidMove()) {
            this.getOutput().showNeitherPlayerHasValidMove();

            int humanScore = this.calculatePlayerScore(this.getHuman());
            int computerScore = this.calculatePlayerScore(this.getComputer());

            this.getOutput().showPlayersScore(humanScore, computerScore);

            if (humanScore < computerScore) {
                this.getOutput().showHumanWinner();
            } else if (humanScore > computerScore) {
                this.getOutput().showComputerWinner();
            } else {
                this.getOutput().showDrawMatch();
            }
        } else {
            if (this.getHuman().getHand().isEmpty()) {
                this.getOutput().showHumanWinner();
            } else {
                this.getOutput().showComputerWinner();
            }
        }
    }
}
