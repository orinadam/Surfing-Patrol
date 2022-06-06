package com.example.surfingpatrol;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
  *  A class represents WaveScreen which shows list of waves on forecast
*/
public class WavesScreen extends AppCompatActivity {

    Button windBtn;
    ImageButton goBackWave;
    Button temperatureBtn;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    Spot spot;
    User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waves_screen);

        windBtn                 = (Button)findViewById(R.id.wind_btn_wave);
        temperatureBtn          = (Button)findViewById(R.id.temperature_btn_wave);
        goBackWave              = (ImageButton) findViewById(R.id.wave_go_back);
        ListView wavesListView  = (ListView) findViewById(R.id.itemWaveListView);

        spot = (Spot)getIntent().getExtras().get("spot");
        user = (User)getIntent().getExtras().get("user");
        //WaveItem[] items = {new WaveItem("Thursday 16/09/2021", new SingleWaveItem[]{ new SingleWaveItem( "6:00", "1-1.2m", "7-8s", "High"), new SingleWaveItem("12:00", "1.4-1.8m", "7-14s","High waves"),new SingleWaveItem( "18:00", "1-1.3m", "7-8s", "High waves")}), new WaveItem("Friday 17/09/2021", new SingleWaveItem[]{ new SingleWaveItem( "6:00", "0.6-1m", "5-6s", "Head"), new SingleWaveItem("12:00", "1.4-1.8m", "7-14s","High waves"),new SingleWaveItem( "18:00", "1-1.3m", "7-8s", "High waves")}), new WaveItem("Thursday 16/09/2021", new SingleWaveItem[]{ new SingleWaveItem( "6:00", "1-1.2m", "7-8s", "High"), new SingleWaveItem("12:00", "1.4-1.8m", "7-14s","High waves"),new SingleWaveItem( "18:00", "1-1.3m", "7-8s", "High waves")}), new WaveItem("Thursday 16/09/2021", new SingleWaveItem[]{ new SingleWaveItem( "6:00", "1-1.2m", "7-8s", "High"), new SingleWaveItem("12:00", "1.4-1.8m", "7-14s","High waves"),new SingleWaveItem( "18:00", "1-1.3m", "7-8s", "High waves")}), new WaveItem("Thursday 16/09/2021", new SingleWaveItem[]{ new SingleWaveItem( "6:00", "1-1.2m", "7-8s", "High"), new SingleWaveItem("12:00", "1.4-1.8m", "7-14s","High waves"),new SingleWaveItem( "18:00", "1-1.3m", "7-8s", "High waves")})};
// get data from the table by the ListAdapter
      // ListAdapter customAdapter = new ListAdapter(this, R.layout.wave_item_list_row, Arrays.asList(items.clone()));
        //yourListView.setAdapter(customAdapter);

        List<WaveItem> waves = spot.waves;
        ListAdapter wavesAdapter = new ListAdapter(this, R.layout.wave_item_list_row, waves);
        wavesListView.setAdapter(wavesAdapter);

        windBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WindScreen.class);
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

        goBackWave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}