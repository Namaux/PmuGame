package com.richard.lucas.pmugame.Adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.richard.lucas.pmugame.Model.Player;

import java.util.List;

public class ListViewPlayerAdpater extends ArrayAdapter<Player> {

    Activity activity;

    public ListViewPlayerAdpater(Activity context, int resource, List<Player> objects) {
        super(context, resource, objects);
        this.activity = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Player currentPlayer = getItem(position);

        return null;
    }
}
