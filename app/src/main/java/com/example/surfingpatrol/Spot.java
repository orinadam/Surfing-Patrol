package com.example.surfingpatrol;

public class Spot {
    private String name;
    private String wave;
    private String wind_knots;
    private int direction;
    private int temperature;

    public Spot(String name, String wave, String wind_knots, int direction, int temperature){
        this.wave = wave;
        this.name = name;
        this.wind_knots = wind_knots;
        this.direction = direction;
        this.temperature = temperature;
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

    public int getTemperature() { return temperature; }
}
