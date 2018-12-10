package com.richard.lucas.pmugame.Model;

public class Bet {
    private CardColor color = null;
    private int shots = -1;

    public Bet(CardColor color, int shots) {
        this.color = color;
        this.shots = shots;
    }

    public CardColor getColor() {
        return color;
    }

    public int getShots() {
        return shots;
    }
}
