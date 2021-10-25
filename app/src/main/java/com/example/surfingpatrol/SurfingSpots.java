package com.example.surfingpatrol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class SurfingSpots extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surfing_spots);
        ImageView imgg = (ImageView)findViewById(R.id.imgg);
        imgg.setRotation(30);
        imgg.setImageResource(R.drawable.arrow);
    }
}