package br.edu.univas.ed.domino.models;

public class Game {
    private List players;
    private Table table;

    public Game(List players, Table table) {
        this.players = players;
        this.table = table;
    }

    public List getPlayers() {
        return this.players;
    }

    public void setPlayers(List players) {
        this.players = players;
    }

    public Table getTable() {
        return this.table;
    }

    public void setTable(Table table) {
        this.table = table;
    }
}
