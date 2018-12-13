package com.richard.lucas.pmugame.Model;

import android.view.View;

import com.richard.lucas.pmugame.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucas on 13/12/2018.
 */
public class DisplayCard {

    private DisplayCard(){

    }

    public static int  moveDiamondCard(List<View> mCard, int count) {

        switch (count) {
            case 0:
                mCard.get(0).setBackgroundColor(0xffffffff);
                mCard.get(1).setBackgroundResource(R.drawable.diamond_ace);
                count++;
                break;
            case 1:
                mCard.get(1).setBackgroundResource(R.drawable.empty_card);
                mCard.get(2).setBackgroundResource(R.drawable.diamond_ace);
                count++;
                break;
            case 2:
                mCard.get(2).setBackgroundResource(R.drawable.empty_card);
                mCard.get(3).setBackgroundResource(R.drawable.diamond_ace);
                count++;
                break;
            case 3:
                mCard.get(3).setBackgroundResource(R.drawable.empty_card);
                mCard.get(4).setBackgroundResource(R.drawable.diamond_ace);
                count++;
                break;
            case 4:
                mCard.get(4).setBackgroundResource(R.drawable.empty_card);
                mCard.get(5).setBackgroundResource(R.drawable.diamond_ace);
                count++;
                break;
            case 5:
                mCard.get(5).setBackgroundResource(R.drawable.winner);
                count = 0;
                break;
        }
        return count;
    }
}


