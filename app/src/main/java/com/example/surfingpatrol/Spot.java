package com.example.surfingpatrol;

public class Spot {
    private String name;
    private String wave;
    private String wind_knots;
    private int direction;

    public Spot(String name, String wave, String wind_knots, int direction){
        this.wave = wave;
        this.name = name;
        this.wind_knots = wind_knots;
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }

    public String getName() {
        return name;
    }

    public String getWave() {
        return wave;
    }

    public String getWind_knots() {
        return wind_knots;
    }
}
