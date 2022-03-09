package com.example.surfingpatrol;

import android.view.View;
import android.widget.TableRow;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class WindItem implements Serializable {

    public String date;
    public ArrayList<SingleWindItem> windItems;

    public WindItem(){};
    public WindItem(String date, ArrayList<SingleWindItem> wind_items) {
        this.date = date;
        this.windItems = wind_items;
    }
/*    public String getDate() {
        return date;
    }
    public void setDate(String date) {this.date = date;}
    public ArrayList<SingleWindItem> getWindItems() { return windItems; }
    public TableRow generate_wave_item(View v) {
        TableRow table_row = new TableRow(v.getContext());
        TextView txt = new TextView(v.getContext());
        txt.setTextColor(255);
        txt.setText("hello");
        table_row.addView(txt);
        return table_row;
    }*/
}
