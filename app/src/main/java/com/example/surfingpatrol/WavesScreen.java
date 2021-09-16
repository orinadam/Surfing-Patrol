package com.example.surfingpatrol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.Arrays;


public class WavesScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waves_screen);
        ListView yourListView = (ListView) findViewById(R.id.itemListView);
        //Item[] items = {new Item("6:00", "6:00", "ddd"), new Item("9:00", "rrrr", "ffff"), new Item("8", "hey", "ddd")};
// get data from the table by the ListAdapter
       // ListAdapter customAdapter = new ListAdapter(this, R.layout.wave_item_list_row, Arrays.asList(items.clone()));

        //yourListView .setAdapter(customAdapter);

    }
}