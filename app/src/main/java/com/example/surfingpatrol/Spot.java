package com.example.surfingpatrol;

import java.io.Serializable;
import java.util.ArrayList;
/*
    Class which represents a surfing spots
 */
public class Spot implements Serializable {
    public String name;
    public String wave;
    public String windKnots;
    public int direction;
    public int temperature;
    public int waterTemperature;
    public ArrayList<WaveItem> waves;
    public ArrayList<WindItem> winds;

    public Spot(String name, String wave, String wind_knots, int direction, int temperature, int waterTemperature, ArrayList<WaveItem> waves, ArrayList<WindItem> winds){
        this.wave = wave;
        this.name = name;
        this.waterTemperature = waterTemperature;
        this.windKnots = wind_knots;
        this.direction = direction;
        this.temperature = temperature;
        this.waves = waves;
        this.winds = winds;
    }

    public Spot(){};

/*    public int getDirection() {
        return direction;
    }

    public String getName() {
        return name;
    }

    public String getWave() {
        return wave;
    }

    public String getWindKnots() {
        return windKnots;
    }

    public int getTemperature() { return temperature; }

    public  ArrayList<WaveItem> getWaves() { return waves; }

    public  ArrayList<WindItem> getWinds() { return winds; }*/
}
