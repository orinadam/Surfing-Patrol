package com.example.surfingpatrol;

import java.io.Serializable;
/*
    Class which represents a single wave Item for everyday
 */
public class SingleWaveItem implements Serializable {
    public String hour;
    public String height;
    public String period;
    public String description;
    public SingleWaveItem(String hour, String height, String period, String description) {
        this.hour =hour;
        this.height = height;
        this.period = period;
        this.description = description;
    }
/*    public String getHour(){ return hour; }
    public String getHeight(){ return height; }
    public String getPeriod(){ return period; }
    public String getDescription(){ return description; }*/
}
