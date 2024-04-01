package br.edu.univas.ed.domino.models;

public class Player {
    private List hand;

    public Player(List hand) {
        this.setHand(hand);
    }

    public List getHand() {
        return this.hand;
    }

    public void setHand(List hand) {
        this.hand = hand;
    }
}
