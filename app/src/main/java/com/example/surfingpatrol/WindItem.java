package com.example.surfingpatrol;

import android.view.View;
import android.widget.TableRow;
import android.widget.TextView;

public class WindItem {

    private String date;
    private SingleWindItem[] wind_items;

    public WindItem(String date, SingleWindItem[] wind_items) {
        this.date = date;
        this.wind_items = wind_items;
    }
    public String get_date() {
        return date;
    }
    public SingleWindItem[] get_wind_items() { return wind_items; }
    public TableRow generate_wave_item(View v) {
        TableRow table_row = new TableRow(v.getContext());
        TextView txt = new TextView(v.getContext());
        txt.setTextColor(255);
        txt.setText("hello");
        table_row.addView(txt);
        return table_row;
    }
}
