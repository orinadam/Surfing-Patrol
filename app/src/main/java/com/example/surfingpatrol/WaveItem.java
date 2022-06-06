package com.example.surfingpatrol;

import android.view.View;
import android.widget.TableRow;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

/**
   * A class represents WaveItem on the list
*/
public class WaveItem implements Serializable {
    public String date;
    public ArrayList<SingleWaveItem> waveItems;

    public WaveItem(String date, ArrayList<SingleWaveItem> wave_items) {
        this.date = date;
        this.waveItems = wave_items;
    }

    public WaveItem(){};

}
