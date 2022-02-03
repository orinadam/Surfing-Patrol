package com.example.surfingpatrol;

public class SingleWindItem {
    private String hour;
    private String strength;
    private String direction;
    private String description;
    public SingleWindItem(String hour, String strength, String direction, String description) {
        this.hour =hour;
        this.strength = strength;
        this.direction = direction;
        this.description = description;
    }
    public String get_hour(){ return hour; }
    public String get_strength(){ return strength; }
    public String get_direction(){ return direction; }
    public String get_description(){ return description; }
}
