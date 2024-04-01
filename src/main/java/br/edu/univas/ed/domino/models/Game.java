package br.edu.univas.ed.domino.models;

public class Game {
    private Player human;
    private Player computer;
    private Table table;

    public Game(Player human, Player computer, Table table) {
        this.setHuman(human);
        this.setComputer(computer);
        this.setTable(table);
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
}
