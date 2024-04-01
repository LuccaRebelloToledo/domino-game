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
                    this.output().startingGame();

                    GameDto gameDto = this.startGame();

                    Game game = gameDto.game();
                    Player currentPlayer = gameDto.currentPlayer();

                    this.match(game, currentPlayer);

                    break;
                case "2":
                    this.output().bye();
                    looping = false;
                    break;
                default:
                    this.output().invalidOption();
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
            this.output().printTable(game.getTable());

            if (currentPlayer == game.getHuman()) {
                this.output().showHumanTurn();

                this.output().showPlayerHand(currentPlayer);
                this.output().optionsHumanPlayer();
                String option = this.input().readString();

                switch (option) {
                    case "1":
                        this.humanChoosePiece(game, currentPlayer);
                        break;
                    case "2":
                        break;
                    case "3":
                        break;
                    default:
                        this.output().invalidOption();
                        break;
                }

            } else {
                this.output().showComputerTurn();

                this.computerPlay();
            }

            currentPlayer = currentPlayer == game.getHuman() ? game.getComputer() : game.getHuman();
        } while (!game.isGameOver());
    }

    private void humanChoosePiece(Game game, Player human) {
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

            if(!isValid) {
                this.output().invalidOption();
                continue;
            }

            looping = false;

        } while(looping);
    }

    private int getPosition(Player human) {
        this.output().choosePiece();
        String positionStr = this.input().readString();

        try {
            int position = Integer.parseInt(positionStr) - 1;
            if (position < 0 || position >= human.getHand().getSize()) {
                this.output().invalidOption();
                return -1;
            }
            return position;
        } catch (NumberFormatException e) {
            this.output().invalidOption();
            return -1;
        }
    }

    private String getSide() {
        this.output().chooseSide();
        String side = this.input().readString();

        if (!side.equalsIgnoreCase("L") && !side.equalsIgnoreCase("R")) {
            this.output().invalidOption();
            return null;
        }
        return side;
    }

    private void computerPlay() {
        this.output().computerThinking();

        try {
            Thread.sleep(3000);
            this.output().computerPlayed();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
