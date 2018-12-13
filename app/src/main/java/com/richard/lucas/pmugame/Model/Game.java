package com.richard.lucas.pmugame.Model;

import com.richard.lucas.pmugame.Exceptions.NotEnoughPlayerException;
import com.richard.lucas.pmugame.Exceptions.WrongBetsException;
import com.richard.lucas.pmugame.Listeners.GameListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Game {
    private List<Player> players;
    private List<Card> cards;
    private Map<Card, Integer> aces;
    private Card drawedCard;
    private int winners;
    private boolean isPlaying;
    private int currentRank;
    private boolean flipLC = false;
    private boolean flipRC = false;
    private List<GameListener> listeners;

    public Game(List<Player> players) {
        this.players = players;
        listeners = new ArrayList<>();
        initialize();
    }

    public boolean getIsPlaying() {
        return isPlaying;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Card getDrawedCard() {
        return drawedCard;
    }

    public boolean isLeftTurn() {
        return flipLC;
    }

    public boolean isRightTurn() {
        return flipRC;
    }

    public void addListener(GameListener listener) {
        listeners.add(listener);
    }

    public void removeListener(GameListener listener) {
        listeners.remove(listener);
    }

    public void start() throws NotEnoughPlayerException, WrongBetsException {
        if (players.size() > 2) {
            throw new NotEnoughPlayerException();
        }

        Player[] errorsPlayer = getErrorPlayersBets();

        if (errorsPlayer.length > 0) {
            throw new WrongBetsException(errorsPlayer);
        }

        isPlaying = true;
        nextStep();
    }

    public void nextStep() {
        if (isPlaying) {
            if (flipLC) {
                flipLeftCard();
            }
            else if (flipRC) {
                flipRightCard();
            }
            else {
                normalTurn(true);
            }

            if (winners > 2) {
                handleEndGame();
            }
        }
    }

    public Player[] getPlayersWithColor(CardColor color) {
        List<Player> colorPlayers = new ArrayList<>();
        for(Player player : players) {
            if (player.getBet().getColor() == color) {
                colorPlayers.add(player);
            }
        }

        return colorPlayers.toArray(new Player[0]);
    }

    public Integer getRankFromColor(CardColor color) {
        return aces.get(color);
    }

    private void normalTurn(boolean inc) {
        drawCard();
        int countRanks = 0;

        for(Map.Entry<Card, Integer> map : aces.entrySet()) {
            CardColor color = map.getKey().getColor();
            Integer value = map.getValue();

            if (color == drawedCard.getColor()) {
                if (inc) {
                    value++;
                }
                else {
                    value--;
                }

                map.setValue(value);

                if (value > 5) {
                    handleColorWin(color);
                }
            }

            if (value >= currentRank) {
                countRanks++;
            }
        }

        if (countRanks == 4) {
            flipLC = true;
        }
    }

    private void flipLeftCard() {
        normalTurn(true);

        flipLC = false;
        flipRC = true;
    }

    private void flipRightCard() {
        normalTurn(false);
        flipRC = false;
    }

    private void handleColorWin(CardColor color) {
        winners++;
        removeColorFromCards(color);

        for(GameListener listener : listeners) {
            listener.onColorWin(color);
        }
    }

    private void handleEndGame() {
        isPlaying = false;
        for(GameListener listener : listeners) {
            listener.onGameEnded();
        }
    }

    private void drawCard() {
        drawedCard = cards.get(new Random().nextInt(cards.size()));
    }

    private void initialize() {
        winners = 0;
        currentRank = 1;
        drawedCard = null;
        isPlaying = false;
        cards = new ArrayList<>();
        aces = new HashMap<Card, Integer>();

        String[] cardValues = {"2","3","4","5","6","7","8","9","10","J","Q","K"};
        for(int color = 0; color < CardColor.values().length; color++) {
            for(int indexValue = 0; indexValue < cardValues.length; indexValue++) {
                cards.add(new Card(CardColor.values()[color], cardValues[indexValue]));
            }
        }

        for(int color = 0; color < CardColor.values().length; color++) {
            aces.put(new Card(CardColor.values()[color], "Ace"), 0);
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

    private void removeColorFromCards(CardColor color) {
        Iterator<Card> i = cards.iterator();

        while(i.hasNext()) {
            Card c = i.next();
            if (c.getColor() == color) {
                i.remove();
            }
        }
    }

}
