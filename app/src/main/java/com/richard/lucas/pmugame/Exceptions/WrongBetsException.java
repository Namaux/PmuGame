package com.richard.lucas.pmugame.Exceptions;

import com.richard.lucas.pmugame.Model.Player;

public class WrongBetsException extends Exception {
    private Player[] players;

    public WrongBetsException(Player[] players) {
        this.players = players;
        System.out.println(getText());
    }

    public Player[] getPlayers() {
        return players;
    }

    public String getText() {
        String text = "Les joueurs suivants n'ont pas des mises valides : \n";

        for(Player player : players) {
            text += player.getName() + "\n";
        }

        return text;
    }
}
