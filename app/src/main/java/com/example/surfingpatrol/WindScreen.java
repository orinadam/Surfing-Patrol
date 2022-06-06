package com.example.surfingpatrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.Arrays;

/**
 * Wind screen which shows the wind forecast
 * Shows the winds list view
 */

public class WindScreen extends AppCompatActivity {
    Button waveBtn;
    Button temperatureBtn;

    ImageButton goBackWind;

    Spot spot;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wind_screen);
        waveBtn = (Button) findViewById(R.id.wave_btn_wind);
        temperatureBtn = (Button) findViewById(R.id.temperature_btn_wind);
        ListView windList = (ListView) findViewById(R.id.itemWindListView);
        goBackWind        = (ImageButton)findViewById(R.id.wind_go_back);

        spot = (Spot)getIntent().getExtras().get("spot");
        user = (User)getIntent().getExtras().get("user");
        //WindItem[] items = {new WindItem("Thursday 16/09/2021", new SingleWindItem[]{ new SingleWindItem( "6:00", "12 knots", "30", "High"), new SingleWindItem("12:00", "1.4-1.8m", "80","High Winds"),new SingleWindItem( "18:00", "1-1.3m", "140", "High Winds")}), new WindItem("Friday 17/09/2021", new SingleWindItem[]{ new SingleWindItem( "6:00", "0.6-1m", "170", "Head"), new SingleWindItem("12:00", "1.4-1.8m", "230","High Winds"),new SingleWindItem( "18:00", "1-1.3m", "220", "High Winds")}), new WindItem("Thursday 16/09/2021", new SingleWindItem[]{ new SingleWindItem( "6:00", "1-1.2m", "300", "High"), new SingleWindItem("12:00", "1.4-1.8m", "230","High Winds"),new SingleWindItem( "18:00", "1-1.3m", "100", "High Winds")}), new WindItem("Thursday 16/09/2021", new SingleWindItem[]{ new SingleWindItem( "6:00", "1-1.2m", "50", "High"), new SingleWindItem("12:00", "1.4-1.8m", "40","High Winds"),new SingleWindItem( "18:00", "1-1.3m", "60", "High Winds")}), new WindItem("Thursday 16/09/2021", new SingleWindItem[]{ new SingleWindItem( "6:00", "1-1.2m", "180", "High"), new SingleWindItem("12:00", "1.4-1.8m", "190","High Winds"),new SingleWindItem( "18:00", "1-1.3m", "170", "High Winds")})};
        // get data from the table by the ListAdapter
        WindListAdapter windAdapter = new WindListAdapter(this, R.layout.wave_item_list_row, spot.winds);
        windList.setAdapter(windAdapter);

        waveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WavesScreen.class);
                intent.putExtra("spot", spot);
                intent.putExtra("user", user);
                finish();
                startActivity(intent);
            }
        });

        temperatureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TemperatureScreen.class);
                intent.putExtra("spot", spot);
                intent.putExtra("user", user);
                finish();
                startActivity(intent);
            }
        });

        goBackWind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}