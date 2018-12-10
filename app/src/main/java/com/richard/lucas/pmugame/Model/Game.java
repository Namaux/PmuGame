package com.richard.lucas.pmugame.Model;

import com.richard.lucas.pmugame.Exceptions.NotEnoughPlayerException;
import com.richard.lucas.pmugame.Exceptions.WrongBetsException;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Player> players;
    private List<Card> cards;

    public Game(List<Player> players) {
        this.players = players;
        initialize();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void start() throws NotEnoughPlayerException, WrongBetsException {
        if (players.size() > 2) {
            throw new NotEnoughPlayerException();
        }

        Player[] errorsPlayer = getErrorPlayersBets();

        if (errorsPlayer.length > 0) {
            throw new WrongBetsException(errorsPlayer);
        }


    }

    private void initialize() {
        String[] cardValues = {"2","3","4","5","6","7","8","9","10","J","Q","K","Ace"};
        cards = new ArrayList<>();

        for(int color = 0; color < CardColor.values().length; color++) {
            for(int indexValue = 0; indexValue < 13; indexValue++) {
                cards.add(new Card(CardColor.values()[color], cardValues[indexValue]));
            }
        }
    }

    private Player[] getErrorPlayersBets() {
        List<Player> errorPlayers = new ArrayList<>();
        for(Player player : players) {
            if (player.getBet() != null && player.getBet().getColor() != null && player.getBet().getShots() > 0 ) {
                errorPlayers.add(player);
            }
        }

        return errorPlayers.toArray(new Player[0]);
    }
}
