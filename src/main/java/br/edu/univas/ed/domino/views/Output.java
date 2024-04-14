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

    public void showException(String message) {
        this.println("Ocorreu um erro: " + message);
        this.println("");
    }

    public void showWelcomeMessage() {
        this.println("Bem vindo ao jogo de Dominó!");
        this.println("");
    }

    public void showMenuOptions() {
        this.println("1. Começar um novo jogo!");
        this.println("2. Sair!");
        this.showChooseOption();
    }

    public void showChooseOption() {
        this.print("Escolha uma opção: ");
    }

    public void showBye() {
        this.println("Até mais! :)");
    }

    public void showInvalidOption() {
        this.println("Opção inválida. Por favor, tente novamente.");
        this.println("");
    }

    public void showNoValidPiece() {
        this.println("Você jogou uma peça inválida. Por favor, tente novamente.");
    }

    public void showNoValidMoves() {
        this.println("Você não possuí jogadas válidas. Por favor, compre ou passe a vez.");
        this.println("");
    }

    public void showStartingGame() {
        this.println("Começando um novo jogo...");
        this.println("");
    }

    public void showHumanStartedTheGame() {
        this.println("Você jogou a primeira peça!");
        this.println("");
    }

    public void showComputerStartedTheGame() {
        this.println("Seu oponente jogou a primeira peça!");
        this.println("");
    }

    public void showComputerThinking() {
        this.println("Seu oponente está pensando...");
    }

    public void showComputerPlayed() {
        this.println("Seu oponente realizou uma jogada!");
        this.println("");
    }

    public void showComputerSkipped() {
        this.println("Seu oponente passou a vez!");
        this.println("");
    }

    public void showComputerBought() {
        this.println("Seu oponente comprou uma peça!");
    }

    public void showTable(Table table) {
        this.println("Mesa");

        this.print("Esquerda: ");
        table.getLeft().print();

        this.print("Direita: ");
        table.getRight().print();

        this.println("");
    }

    public void showHumanTurn() {
        this.println("Sua vez de jogar!");
        this.println("");
        this.println("Suas peças: ");
    }

    public void showComputerTurn() {
        this.println("É a vez do seu oponente jogar!");
        this.println("");
    }

    public void showPlayerHand(Player player) {
        player.printHand();
    }

    public void showOptionsHumanPlayer() {
        this.println("1. Realizar uma jogada!");
        this.println("2. Comprar do monte!");
        this.println("3. Passar a vez!");
        this.showChooseOption();
    }

    public void showChoosePiece() {
        this.print("Escolha sua peça e digite o número de sua posição: ");
    }

    public void showChooseSide() {
        this.print("Escolha um lado para jogar (L para esquerda ou R para direita): ");
    }

    public void showPlayerCanPlay() {
        this.println("Você não pode passar a vez. Ainda há peças no monte ou você pode realizar uma jogada!");
        this.println("");
    }

    public void showPlayerCannotBuyPiece() {
        this.println("Você não pode comprar do monte. Não há mais peças no monte ou você pode realizar uma jogada!");
        this.println("");
    }

    public void showTheWinner(Game game) {
        this.println(game.getWinner() + " venceu o jogo de Dominó!");
        this.println("");
    }
}
