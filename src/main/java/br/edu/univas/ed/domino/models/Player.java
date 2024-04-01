package br.edu.univas.ed.domino.models;

import br.edu.univas.ed.domino.enums.PlayerType;

public class Player {
    private PlayerType type;
    private List hand;

    public Player(PlayerType type, List hand) {
        this.setType(type);
        this.setHand(hand);
    }

    public PlayerType getType() {
        return this.type;
    }

    public void setType(PlayerType type) {
        this.type = type;
    }

    public List getHand() {
        return this.hand;
    }

    public void setHand(List hand) {
        this.hand = hand;
    }
}
