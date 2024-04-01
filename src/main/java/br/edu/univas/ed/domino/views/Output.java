package br.edu.univas.ed.domino.views;

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
        this.chooseOption();
    }

    public void chooseOption() {
        this.print("Choose an option: ");
    }

    public void bye() {
        this.println("Goodbye! :)");
    }

    public void invalidOption() {
        this.println("Invalid option. Please, try again.");
        this.println("");
    }

    public void startingGame() {
        this.println("Starting a new game...");
        this.println("");
    }

    public void humanStartedTheGame() {
        this.println("You started the game!");
        this.println("");
    }

    public void computerStartedTheGame() {
        this.println("The computer started the game!");
        this.println("");
    }

    public void computerThinking() {
        this.println("The computer is thinking...");
    }

    public void computerPlayed() {
        this.println("The computer played!");
        this.println("");
    }

    public void printTable(Table table) {
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

    public void optionsHumanPlayer() {
        this.println("1. Play a piece");
        this.println("2. Buy a piece");
        this.println("3. Pass");
        this.chooseOption();
    }

    public void choosePiece() {
        this.print("Choose a piece (your number of the position): ");
    }

    public void chooseSide() {
        this.print("Choose a side (L or R): ");
    }
}
