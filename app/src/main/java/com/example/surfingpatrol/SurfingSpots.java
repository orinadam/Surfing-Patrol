package com.example.surfingpatrol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.Arrays;

public class SurfingSpots extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surfing_spots);
        ListView spots_list = (ListView)findViewById(R.id.spots_list);
        Spot[] spots = {new Spot("Tel Aviv- Hilton", "1.2m", "12knots", 28, 24)};
        SpotsListAdapter customAdapter = new SpotsListAdapter(this, Arrays.asList(spots.clone()));
        spots_list.setAdapter(customAdapter);
    }
}