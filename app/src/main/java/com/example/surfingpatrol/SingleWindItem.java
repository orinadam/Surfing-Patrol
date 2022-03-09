package com.example.surfingpatrol;

import java.io.Serializable;

public class SingleWindItem implements Serializable {
    public String hour;
    public String strength;
    public String direction;
    public String description;
    public SingleWindItem(String hour, String strength, String direction, String description) {
        this.hour =hour;
        this.strength = strength;
        this.direction = direction;
        this.description = description;
    }
/*    public String getHour(){ return hour; }
    public String getStrength(){ return strength; }
    public String getDirection(){ return direction; }
    public String getDescription(){ return description; }*/
}
