package com.example.surfingpatrol;

public class Item {
    private String date;
    private String hour_six_am;
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

    public Item (String hour, String height, String description, String period, String date){
        this.date = date;
        this.hour_six_am = hour;
        this.description_six_am = description;
        this.height_six_am = height;
        this.period_six_am = period;
    }
    public String getHour(){ return hour_six_am; }
    public String getDate() {
        return date;
    }
    public String getDescription() {
        return description_six_am;
    }
    public String getHeight() { return height_six_am; }
    public String getPeriod() {
        return period_six_am;
    }
}
