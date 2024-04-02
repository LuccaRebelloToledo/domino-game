package br.edu.univas.ed.domino.views;

import br.edu.univas.ed.domino.models.Game;
import br.edu.univas.ed.domino.models.Player;
import br.edu.univas.ed.domino.models.Table;

public class Output {
    public Output() {
    }

    private void print(String message) {
        System.out.print(message);
    }

    private void println(String message) {
        System.out.println(message);
    }

    public void showWelcomeMessage() {
        this.println("Welcome to Domino Game!");
        this.println("");
    }

    public void showMenuOptions() {
        this.println("1. Start a new game!");
        this.println("2. Exit!");
        this.showChooseOption();
    }

    public void showChooseOption() {
        this.print("Choose an option: ");
    }

    public void showBye() {
        this.println("Goodbye! :)");
    }

    public void showInvalidOption() {
        this.println("Invalid option. Please, try again.");
        this.println("");
    }

    public void showNoValidPiece() {
        this.println("You played an invalid piece. Please try again.");
    }

    public void showNoValidMoves() {
        this.println("There are no valid moves. Please Buy or Pass.");
        this.println("");
    }

    public void showStartingGame() {
        this.println("Starting a new game...");
        this.println("");
    }

    public void showHumanStartedTheGame() {
        this.println("You started the game!");
        this.println("");
    }

    public void showComputerStartedTheGame() {
        this.println("The computer started the game!");
        this.println("");
    }

    public void showComputerThinking() {
        this.println("The computer is thinking...");
    }

    public void showComputerPlayed() {
        this.println("The computer played!");
        this.println("");
    }

    public void showComputerSkipped() {
        this.println("The computer skipped the turn!");
        this.println("");
    }

    public void showTable(Table table) {
        this.println("Table");

        this.print("Left: ");
        table.getLeft().print();

        this.print("Right: ");
        table.getRight().print();

        this.println("");
    }

    public void showHumanTurn() {
        this.println("It's your turn!");
        this.println("");
        this.println("Your hand: ");
    }

    public void showComputerTurn() {
        this.println("It's the computer's turn!");
        this.println("");
    }

    public void showPlayerHand(Player player) {
        player.printHand();
    }

    public void showOptionsHumanPlayer() {
        this.println("1. Play a piece");
        this.println("2. Buy a piece");
        this.println("3. Pass");
        this.showChooseOption();
    }

    public void showChoosePiece() {
        this.print("Choose a piece (your number of the position): ");
    }

    public void showChooseSide() {
        this.print("Choose a side (L or R): ");
    }

    public void showPlayerCanPlay() {
        this.println("You cannot skip your turn. There are still pieces in the stock or you can play a piece.");
        this.println("");
    }

    public void showPlayerCannotBuyPiece() {
        this.println("You cannot buy a piece. There are no pieces in the stock or you can play a piece.");
        this.println("");
    }

    public void showTheWinner (Game game) {
        this.println(game.getWinner() + " win the game!");
        this.println("");
    }
}
