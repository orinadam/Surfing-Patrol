package com.example.surfingpatrol;

import android.view.View;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class WindItem {

    private String date;
    private ArrayList<SingleWindItem> wind_items;

    public WindItem(){};
    public WindItem(String date, ArrayList<SingleWindItem> wind_items) {
        this.date = date;
        this.wind_items = wind_items;
    }
    public String get_date() {
        return date;
    }
    public ArrayList<SingleWindItem> get_wind_items() { return wind_items; }
    public TableRow generate_wave_item(View v) {
        TableRow table_row = new TableRow(v.getContext());
        TextView txt = new TextView(v.getContext());
        txt.setTextColor(255);
        txt.setText("hello");
        table_row.addView(txt);
        return table_row;
    }
}
