package com.richard.lucas.pmugame.Controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.richard.lucas.pmugame.R;

public class AddPlayersActivity extends AppCompatActivity {
    private ListView lvPlayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_players);

        lvPlayers = (ListView)findViewById(R.id.lvPlayers);

    }
}
