package br.edu.univas.ed.domino.views;

import br.edu.univas.ed.domino.dtos.GameDto;

import br.edu.univas.ed.domino.models.Game;
import br.edu.univas.ed.domino.models.List;
import br.edu.univas.ed.domino.models.Player;
import br.edu.univas.ed.domino.models.Table;

public record Menu(Input input, Output output) {

    public void start() {
        this.output().showWelcomeMessage();

        boolean looping = true;
        do {
            showMenu();
            String option = this.input().readString();

            switch (option) {
                case "1":
                    this.output().showStartingGame();

                    GameDto gameDto = this.startGame();

                    Game game = gameDto.game();
                    Player currentPlayer = gameDto.currentPlayer();

                    this.match(game, currentPlayer);

                    break;
                case "2":
                    this.output().showRules();
                    break;
                case "3":
                    this.output().showBye();
                    looping = false;
                    break;
                default:
                    this.output().showInvalidOption();
                    break;
            }

        } while (looping);
    }

    private void showMenu() {
        this.output().showMenuOptions();
    }

    private GameDto startGame() {
        List playerHand = new List();
        List computerHand = new List();

        Player human = new Player(playerHand);
        Player computer = new Player(computerHand);

        List left = new List();
        List right = new List();
        List stock = new List();

        Table table = new Table(left, right, stock);

        Game game = new Game(human, computer, table, this.output());

        Player currentPlayer = game.initialize();

        return new GameDto(game, currentPlayer);
    }

    private void match(Game game, Player currentPlayer) {
        do {
            this.output().showTable(game.getTable());

            if (currentPlayer == game.getHuman()) {
                this.output().showHumanTurn();

                this.output().showPlayerHand(currentPlayer);

                boolean looping = true;

                do {
                    this.output().showOptionsHumanPlayer();
                    String option = this.input().readString();

                    switch (option) {
                        case "1":
                            boolean humanPlayed = this.humanChoosePiece(game, currentPlayer);

                            if (humanPlayed) {
                                looping = false;
                            }

                            break;
                        case "2":
                            boolean isPlayerToBuyPiece = game.canPlayerBuyAPiece(currentPlayer);

                            if (isPlayerToBuyPiece) {
                                game.buyPiece(currentPlayer);

                                this.output().showTable(game.getTable());

                                this.output().showPlayerHand(currentPlayer);
                            } else {
                                this.output().showPlayerCannotBuyPiece();
                            }

                            break;
                        case "3":
                            boolean isPlayerEligibleToSkipTurn = game.canPlayerSkipTurn(currentPlayer);

                            if (isPlayerEligibleToSkipTurn) {
                                looping = false;
                            } else {
                                this.output().showPlayerCanPlay();
                            }

                            break;
                        default:
                            this.output().showInvalidOption();
                            break;
                    }
                } while (looping);

            } else {
                this.output().showComputerTurn();

                this.computerPlay(game, currentPlayer);
            }

            currentPlayer = currentPlayer == game.getHuman() ? game.getComputer() : game.getHuman();
        } while (!game.isGameOver() && !game.neitherPlayerHasValidMove());

        this.output().showTable(game.getTable());

        game.getWinner();
    }

    private boolean humanChoosePiece(Game game, Player human) {
        boolean hasValidMove = game.hasValidMove(human);

        if (!hasValidMove) {
            this.output().showNoValidMoves();
            return false;
        }

        boolean looping = true;

        do {
            int position = getPosition(human);

            if (position == -1) {
                continue;
            }

            String side = getSide();

            if (side == null) {
                continue;
            }

            boolean isValid = game.playPiece(human, position, side);

            if (!isValid) {
                this.output().showNoValidPiece();
                continue;
            }

            looping = false;

        } while (looping);

        return true;
    }

    private int getPosition(Player human) {
        this.output().showChoosePiece();
        String positionStr = this.input().readString();

        try {
            int position = Integer.parseInt(positionStr) - 1;
            if (position < 0 || position >= human.getHand().getSize()) {
                this.output().showInvalidOption();
                return -1;
            }
            return position;
        } catch (NumberFormatException e) {
            this.output().showInvalidOption();
            return -1;
        }
    }

    private String getSide() {
        this.output().showChooseSide();
        String side = this.input().readString();

        if (!side.equalsIgnoreCase(Game.LEFT) && !side.equalsIgnoreCase(Game.RIGHT)) {
            this.output().showInvalidOption();
            return null;
        }

        return side;
    }

    private void computerPlay(Game game, Player currentPlayer) {
        this.output().showComputerThinking();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            this.output().showException(e.getMessage());
        }

        boolean looping = true;

        do {
            boolean computerHasAnyValidMove = game.hasValidMove(currentPlayer);

            if (computerHasAnyValidMove) {
                game.computerSelectAndPlayPiece(game, currentPlayer);

                this.output().showComputerPlayed();
                looping = false;
            } else {
                boolean computerCanBuyPiece = game.canPlayerBuyAPiece(currentPlayer);

                if (computerCanBuyPiece) {
                    game.buyPiece(currentPlayer);
                    this.output().showComputerBought();
                } else {
                    this.output().showComputerSkipped();
                    looping = false;
                }
            }
        } while (looping);
    }
}
