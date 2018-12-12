package com.richard.lucas.pmugame.Listeners;

import com.richard.lucas.pmugame.Model.CardColor;

public interface GameListener {
    void onGameEnded();
    void onColorWin(CardColor color);
}
