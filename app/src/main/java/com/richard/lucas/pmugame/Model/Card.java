package com.richard.lucas.pmugame.Model;

public class Card {
    private CardColor color;
    private String value;

    public Card(CardColor color, String value) {
        this.color = color;
        this.value = value;
    }

    public CardColor getColor() {
        return color;
    }

    public String getValue() {
        return value;
    }
}
