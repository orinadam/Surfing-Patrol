package com.example.surfingpatrol;

import java.util.ArrayList;

public class Spot {
    private String name;
    private String wave;
    private String wind_knots;
    private int direction;
    private int temperature;
    private ArrayList<WaveItem> waves;
    private ArrayList<WindItem> winds;

    public Spot(String name, String wave, String wind_knots, int direction, int temperature, ArrayList<WaveItem> waves, ArrayList<WindItem> winds){
        this.wave = wave;
        this.name = name;
        this.wind_knots = wind_knots;
        this.direction = direction;
        this.temperature = temperature;
        this.waves = waves;
        this.winds = winds;
    }

    public Spot(){};

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

    public  ArrayList<WaveItem> getWaves() { return waves; }

    public  ArrayList<WindItem> getWinds() { return winds; }
}
