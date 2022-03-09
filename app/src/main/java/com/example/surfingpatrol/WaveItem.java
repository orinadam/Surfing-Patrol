package com.example.surfingpatrol;

import android.view.View;
import android.widget.TableRow;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class WaveItem implements Serializable {
    public String date;
    public ArrayList<SingleWaveItem> waveItems;

    public WaveItem(String date, ArrayList<SingleWaveItem> wave_items) {
        this.date = date;
        this.waveItems = wave_items;
    }

    public WaveItem(){};
    /*public String getDate() {
        return date;
    }
    public ArrayList<SingleWaveItem> getWaveItems() { return waveItems; }
    public TableRow generate_wave_item(View v) {
        TableRow table_row = new TableRow(v.getContext());
        TextView txt = new TextView(v.getContext());
        txt.setTextColor(255);
        txt.setText("hello");
        table_row.addView(txt);
        return table_row;
    }*/

}
