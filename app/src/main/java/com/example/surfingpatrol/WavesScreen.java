package com.example.surfingpatrol;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.Arrays;


public class WavesScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waves_screen);
        ListView yourListView = (ListView) findViewById(R.id.itemListView);
        WaveItem[] items = {new WaveItem("Thursday 16/09/2021", new SingleWaveItem[]{ new SingleWaveItem( "6:00", "1-1.2m", "7-8s", "High"), new SingleWaveItem("12:00", "1.4-1.8m", "7-14s","High waves"),new SingleWaveItem( "18:00", "1-1.3m", "7-8s", "High waves")}), new WaveItem("Friday 17/09/2021", new SingleWaveItem[]{ new SingleWaveItem( "6:00", "0.6-1m", "5-6s", "Head"), new SingleWaveItem("12:00", "1.4-1.8m", "7-14s","High waves"),new SingleWaveItem( "18:00", "1-1.3m", "7-8s", "High waves")}), new WaveItem("Thursday 16/09/2021", new SingleWaveItem[]{ new SingleWaveItem( "6:00", "1-1.2m", "7-8s", "High"), new SingleWaveItem("12:00", "1.4-1.8m", "7-14s","High waves"),new SingleWaveItem( "18:00", "1-1.3m", "7-8s", "High waves")}), new WaveItem("Thursday 16/09/2021", new SingleWaveItem[]{ new SingleWaveItem( "6:00", "1-1.2m", "7-8s", "High"), new SingleWaveItem("12:00", "1.4-1.8m", "7-14s","High waves"),new SingleWaveItem( "18:00", "1-1.3m", "7-8s", "High waves")}), new WaveItem("Thursday 16/09/2021", new SingleWaveItem[]{ new SingleWaveItem( "6:00", "1-1.2m", "7-8s", "High"), new SingleWaveItem("12:00", "1.4-1.8m", "7-14s","High waves"),new SingleWaveItem( "18:00", "1-1.3m", "7-8s", "High waves")})};
// get data from the table by the ListAdapter
       ListAdapter customAdapter = new ListAdapter(this, R.layout.wave_item_list_row, Arrays.asList(items.clone()));
        yourListView.setAdapter(customAdapter);

    }
}