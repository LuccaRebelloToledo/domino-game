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
        this.println("2. Regras!");
        this.println("3. Sair!");
        this.showChooseOption();
    }

    public void showChooseOption() {
        this.print("Escolha uma opção: ");
    }

    public void showBye() {
        this.println("Até mais! :)");
    }

    public void showRules(){
        this.println("");
        this.println("Regras do jogo de Dominó:");
        this.println("1. O jogo de Dominó é jogado por dois jogadores, você e o computador.");
        this.println("2. O jogo começa com 7 peças para cada jogador.");
        this.println("3. O jogador que possuir a maior peça dupla, ou seja, peças com lados iguais, começa o jogo.");
        this.println("4. Cada jogador deve tentar encaixar uma de suas peças em uma das extremidades da mesa, desde que o número nas extremidades corresponda ao de sua peça.");
        this.println("5. Caso não possua uma peça válida, o jogador deve comprar uma peça do monte ou passar a vez. O jogador só pode passar a vez se não possuir peças válidas e não houver peças no monte.");
        this.println("6. O jogo termina quando um dos jogadores encaixar todas as suas peças ou quando nenhum dos jogadores possuir jogadas válidas.");
        this.println("7. O vencedor é o jogador que encaixar todas as suas peças ou que possuir a menor quantidade de pontos nas peças restantes.");
        this.println("");
        this.println("Tenha um ótimo jogo, esperamos que você se divirta! :)");
        this.println("");
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

    public void showNeitherPlayerHasValidMove() {
        this.println("Nenhum dos jogadores possui jogadas válidas. Para determinar o vencedor será realizada a contagem dos valores das peças de cada jogador!");
        this.println("");
    }

    public void showPlayersScore(int humanScore, int computerScore) {
        this.println("Pontuação:");
        this.println("Você: " + humanScore);
        this.println("Seu oponente: " + computerScore);
        this.println("");
    }

    public void showHumanWinner() {
        this.println("Você venceu o jogo de Dominó!");
        this.println("");
    }

    public void showComputerWinner() {
        this.println("Seu oponente venceu o jogo de Dominó!");
        this.println("");
    }

    public void showDrawMatch() {
        this.println("Ocorreu um empate no jogo de Dominó!");
        this.println("");
    }
}
