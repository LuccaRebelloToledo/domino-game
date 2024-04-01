package br.edu.univas.ed.domino.models;

public class Game {
    private Player[] players;
    private Table table;

    public Player[] getPlayers() {
        return this.players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Table getTable() {
        return this.table;
    }

    public void setTable(Table table) {
        this.table = table;
    }
}
