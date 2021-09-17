package com.example.surfingpatrol;

public class SingleWaveItem {
    private String hour;
    private String height;
    private String period;
    private String description;
    public SingleWaveItem(String hour, String height, String period, String description) {
        this.hour =hour;
        this.height = height;
        this.period = period;
        this.description = description;
    }
    public String get_hour(){ return hour; }
    public String get_height(){ return height; }
    public String get_period(){ return period; }
    public String get_description(){ return description; }
}
