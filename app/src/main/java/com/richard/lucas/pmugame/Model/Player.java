package com.richard.lucas.pmugame.Model;

import java.util.UUID;

public class Player {
    private String name;
    private Bet bet = null;
    private String uid;

    public Player(String name) {
        this.name = name;
        this.uid = UUID.randomUUID().toString();
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }

    public String getUid() {
        return uid;
    }

    public Bet getBet() {
        return bet;
    }

    public String getName() {
        return name;
    }

}
