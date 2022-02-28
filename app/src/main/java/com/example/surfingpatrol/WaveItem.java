package com.example.surfingpatrol;

import android.view.View;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class WaveItem {
    private String date;
    private ArrayList<SingleWaveItem> wave_items;

    public WaveItem(String date, ArrayList<SingleWaveItem> wave_items) {
        this.date = date;
        this.wave_items = wave_items;
    }
    public String get_date() {
        return date;
    }
    public ArrayList<SingleWaveItem> get_wave_items() { return wave_items; }
    public TableRow generate_wave_item(View v) {
        TableRow table_row = new TableRow(v.getContext());
        TextView txt = new TextView(v.getContext());
        txt.setTextColor(255);
        txt.setText("hello");
        table_row.addView(txt);
        return table_row;
    }

}
