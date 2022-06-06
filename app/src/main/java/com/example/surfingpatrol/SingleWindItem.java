package com.example.surfingpatrol;

import java.io.Serializable;
/**
  *  Class which represents a single wind Item for every hour
 */
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

}
