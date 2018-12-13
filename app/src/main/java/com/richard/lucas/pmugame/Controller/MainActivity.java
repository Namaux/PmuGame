package com.richard.lucas.pmugame.Controller;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.richard.lucas.pmugame.Model.DisplayCard;
import com.richard.lucas.pmugame.Model.SharedPref;
import com.richard.lucas.pmugame.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageButton mPlayButton;
    public static Context contextOfApplication;

    private int i = -1;

    List<View> mDiamondCard = new ArrayList<View>();
    List<View> mHeartCard = new ArrayList<View>();
    List<View> mClubCard = new ArrayList<View>();
    List<View> mSpadeCard = new ArrayList<View>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contextOfApplication = getApplicationContext();

        SharedPref.init(getApplicationContext());


        mPlayButton = (ImageButton) findViewById(R.id.playButton);

        View mDiamond0 = findViewById(R.id.cardDiamond);
        View mDiamond1 = findViewById(R.id.cardDiamond1);
        View mDiamond2 = findViewById(R.id.cardDiamond2);
        View mDiamond3 = findViewById(R.id.cardDiamond3);
        View mDiamond4 = findViewById(R.id.cardDiamond4);
        View mDiamond5 = findViewById(R.id.cardDiamond5);

        View mHeart0 = findViewById(R.id.cardHeart);
        View mHeart1 = findViewById(R.id.cardHeart1);
        View mHeart2 = findViewById(R.id.cardHeart2);
        View mHeart3 = findViewById(R.id.cardHeart3);
        View mHeart4 = findViewById(R.id.cardHeart4);
        View mHeart5 = findViewById(R.id.cardHeart5);

        View mClub0 = findViewById(R.id.cardClub);
        View mClub1 = findViewById(R.id.cardClub1);
        View mClub2 = findViewById(R.id.cardClub2);
        View mClub3 = findViewById(R.id.cardClub3);
        View mClub4 = findViewById(R.id.cardClub4);
        View mClub5 = findViewById(R.id.cardClub5);

        View mSpade0 = findViewById(R.id.cardSpade);
        View mSpade1 = findViewById(R.id.cardSpade1);
        View mSpade2 = findViewById(R.id.cardSpade2);
        View mSpade3 = findViewById(R.id.cardSpade3);
        View mSpade4 = findViewById(R.id.cardSpade4);
        View mSpade5 = findViewById(R.id.cardSpade5);

        mDiamondCard.add(mDiamond0);
        mDiamondCard.add(mDiamond1);
        mDiamondCard.add(mDiamond2);
        mDiamondCard.add(mDiamond3);
        mDiamondCard.add(mDiamond4);
        mDiamondCard.add(mDiamond5);

        mHeartCard.add(mHeart0);
        mHeartCard.add(mHeart1);
        mHeartCard.add(mHeart2);
        mHeartCard.add(mHeart3);
        mHeartCard.add(mHeart4);
        mHeartCard.add(mHeart5);

        mClubCard.add(mClub0);
        mClubCard.add(mClub1);
        mClubCard.add(mClub2);
        mClubCard.add(mClub3);
        mClubCard.add(mClub4);
        mClubCard.add(mClub5);

        mSpadeCard.add(mSpade0);
        mSpadeCard.add(mSpade1);
        mSpadeCard.add(mSpade2);
        mSpadeCard.add(mSpade3);
        mSpadeCard.add(mSpade4);
        mSpadeCard.add(mSpade5);

        SharedPref.write(SharedPref.DiamondCount, 0);
        SharedPref.write(SharedPref.HeartCount, 0);
        SharedPref.write(SharedPref.ClubCount, 0);
        SharedPref.write(SharedPref.SpadeCount, 0);



        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                i++;

                if (i > 3){i = 0;}

                switch (i) {
                    case 0:
                        SharedPref.write(SharedPref.DiamondCount, DisplayCard.moveDiamondCard(mDiamondCard, SharedPref.read(SharedPref.DiamondCount, 0)));
                        break;
                    case 1:
                        SharedPref.write(SharedPref.HeartCount, DisplayCard.moveDiamondCard(mHeartCard, SharedPref.read(SharedPref.HeartCount, 0)));
                        break;
                    case 2:
                        SharedPref.write(SharedPref.ClubCount, DisplayCard.moveDiamondCard(mClubCard, SharedPref.read(SharedPref.ClubCount, 0)));
                        break;
                    case 3:
                        SharedPref.write(SharedPref.SpadeCount, DisplayCard.moveDiamondCard(mSpadeCard, SharedPref.read(SharedPref.SpadeCount, 0)));

                }
            }
        });
    }

        public static Context getContextOfApplication(){
        return contextOfApplication;
    }
}
