package com.example.surfingpatrol;

import android.view.View;
import android.widget.TableRow;
import android.widget.TextView;

public class WaveItem {
    private String date;
    private SingleWaveItem[] wave_items;
/*    private String hour_six_am;
    private String height_six_am;
    private String period_six_am;
    private String description_six_am;

    private String hour_twelve_pm;
    private String height_twelve_pm;
    private String period_twelve_pm;
    private String description_twelve_pm;

    private String hour_six_pm;
    private String height_six_pm;
    private String period_six_pm;
    private String description_six_pm;

    public WaveItem ( String date, String hour_six_am, String height_six_am, String description_six_am, String period_six_am,
                      String hour_twelve_pm, String height_twelve_pm, String description_twelve_pm, String period_twelve_pm,
                      String hour_six_pm, String height_six_pm, String description_six_pm, String period_six_pm){

        this.date = date;

        this.hour_six_am = hour_six_am;
        this.description_six_am = description_six_am ;
        this.height_six_am = height_six_am;
        this.period_six_am = period_six_am;

        this.hour_twelve_pm = hour_twelve_pm;
        this.description_twelve_pm = description_twelve_pm ;
        this.height_twelve_pm = height_twelve_pm;
        this.period_twelve_pm = period_twelve_pm;

        this.hour_six_pm = hour_six_pm;
        this.description_six_pm = description_six_pm ;
        this.height_six_pm = height_six_pm;
        this.period_six_pm = period_six_pm;

    }*/
    public WaveItem(String date, SingleWaveItem[] wave_items) {
        this.date = date;
        this.wave_items = wave_items;
    }
    public String get_date() {
        return date;
    }
    public SingleWaveItem[] get_wave_items() { return wave_items; }
    public TableRow generate_wave_item(View v) {
        TableRow table_row = new TableRow(v.getContext());
        TextView txt = new TextView(v.getContext());
        txt.setTextColor(255);
        txt.setText("hello");
        table_row.addView(txt);
        return table_row;
    }

/*    public String get_six_am_hour(){ return hour_six_am; }
    public String get_six_am_description() { return description_six_am; }
    public String get_six_am_height() { return height_six_am; }
    public String get_six_am_period() { return period_six_am; }

    public String get_twelve_pm_hour(){ return hour_twelve_pm; }
    public String get_twelve_pm_description() { return description_twelve_pm; }
    public String get_twelve_pm_height() { return height_twelve_pm; }
    public String get_twelve_pm_period() { return period_twelve_pm; }

    public String get_six_pm_hour(){ return hour_six_pm; }
    public String get_six_pm_description() { return description_six_pm; }
    public String get_six_pm_height() { return height_six_pm; }
    public String get_six_pm_period() { return period_six_pm; }*/


}
