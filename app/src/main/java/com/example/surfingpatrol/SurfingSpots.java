package com.example.surfingpatrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;

public class SurfingSpots extends AppCompatActivity {

    FirebaseDatabase rootNode;
    DatabaseReference reference;
    Spot spot;
    ArrayList<Spot> spots;
    ListView spots_list;
    User user;
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surfing_spots);
        spots_list = (ListView)findViewById(R.id.spots_list);
        user = (User)getIntent().getExtras().get("user");
        ArrayList<WaveItem> waves = new ArrayList<>();
        waves.add(new WaveItem("Thursday 10/03/2022", new ArrayList<>(Arrays.asList(new SingleWaveItem( "6:00", "1-1.2m", "7-8s", "High"), new SingleWaveItem("12:00", "1.4-1.8m", "7-14s","High waves"),new SingleWaveItem( "18:00", "1-1.3m", "7-8s", "High waves")))));
        waves.add(new WaveItem("Friday 11/03/2022", new ArrayList<>(Arrays.asList(new SingleWaveItem( "6:00", "1.1-1.4m", "7-8s", "High"), new SingleWaveItem("12:00", "1.4-1.8m", "7-14s","High waves"),new SingleWaveItem( "18:00", "1-1.3m", "7-8s", "High waves")))));
        waves.add(new WaveItem("Saturday 12/03/2022", new ArrayList<>(Arrays.asList(new SingleWaveItem( "6:00", "0.7-0.9m", "7-8s", "Normal"), new SingleWaveItem("12:00", "1.4-1.8m", "7-14s","High waves"),new SingleWaveItem( "18:00", "1-1.3m", "7-8s", "High waves")))));
        waves.add(new WaveItem("Sunday 13/03/2022", new ArrayList<>(Arrays.asList(new SingleWaveItem( "6:00", "1-1.2m", "7-8s", "High"), new SingleWaveItem("12:00", "1.4-1.8m", "7-14s","High waves"),new SingleWaveItem( "18:00", "1-1.3m", "7-8s", "High waves")))));
        waves.add(new WaveItem("Monday 14/03/2022", new ArrayList<>(Arrays.asList(new SingleWaveItem( "6:00", "1-1.2m", "7-8s", "High"), new SingleWaveItem("12:00", "1.4-1.8m", "7-14s","High waves"),new SingleWaveItem( "18:00", "1-1.3m", "7-8s", "High waves")))));

        ArrayList<WindItem> winds = new ArrayList<>();
        winds.add(new WindItem("Thursday 10/03/2022", new ArrayList<>(Arrays.asList(new SingleWindItem( "6:00", "12 knots", "30", "High"), new SingleWindItem("12:00", "1.4-1.8m", "80","High Winds"),new SingleWindItem( "18:00", "1-1.3m", "140", "High Winds")))));
        winds.add(new WindItem("Friday 11/03/2022", new ArrayList<>(Arrays.asList(new SingleWindItem( "6:00", "12 knots", "30", "High"), new SingleWindItem("12:00", "1.4-1.8m", "80","High Winds"),new SingleWindItem( "18:00", "1-1.3m", "140", "High Winds")))));
        winds.add(new WindItem("Saturday 12/03/2022", new ArrayList<>(Arrays.asList(new SingleWindItem( "6:00", "12 knots", "30", "High"), new SingleWindItem("12:00", "1.4-1.8m", "80","High Winds"),new SingleWindItem( "18:00", "1-1.3m", "140", "High Winds")))));
        winds.add(new WindItem("Sunday 13/03/2022", new ArrayList<>(Arrays.asList(new SingleWindItem( "6:00", "12 knots", "30", "High"), new SingleWindItem("12:00", "1.4-1.8m", "80","High Winds"),new SingleWindItem( "18:00", "1-1.3m", "140", "High Winds")))));
        winds.add(new WindItem("Monday 14/03/2022", new ArrayList<>(Arrays.asList(new SingleWindItem( "6:00", "12 knots", "30", "High"), new SingleWindItem("12:00", "1.4-1.8m", "80","High Winds"),new SingleWindItem( "18:00", "1-1.3m", "140", "High Winds")))));

        spot = new Spot("Sokolov", "1.5m", "4knots", 220, 18, 16, waves, winds);
        spots = new ArrayList<>();

        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("locations");
        reference.child("Sokolov").setValue(spot);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot value: snapshot.getChildren()) {
                    //spot = new Spot(value.child("name").toString(), value.child("wave").toString(), value.child("windKnots").toString(), valueOf(value.child("direction").toString()), valueOf(value.child("temperature").toString()), );

                    ArrayList<WaveItem> waves_list = new ArrayList<>();
                    ArrayList<SingleWaveItem> single_waves = new ArrayList<>();

                    for(DataSnapshot wave_val: value.child("waves").getChildren()){
                        date = wave_val.child("date").getValue(String.class);
                        for(DataSnapshot single_wave_val: wave_val.child("waveItems").getChildren()){
                            single_waves.add(new SingleWaveItem(single_wave_val.child("hour").getValue().toString(), single_wave_val.child("height").getValue().toString(), single_wave_val.child("period").getValue().toString(), single_wave_val.child("description").getValue().toString()));
                        }
                        waves_list.add(new WaveItem(date, single_waves));

                    }

                    ArrayList<WindItem> winds_list = new ArrayList<>();
                    ArrayList<SingleWindItem> single_winds = new ArrayList<>();

                    for(DataSnapshot wind_val: value.child("winds").getChildren()){
                        date = wind_val.child("date").getValue(String.class);
                        for(DataSnapshot single_wind_val: wind_val.child("windItems").getChildren()){
                            single_winds.add(new SingleWindItem(single_wind_val.child("hour").getValue().toString(), single_wind_val.child("strength").getValue().toString(), single_wind_val.child("direction").getValue().toString(), single_wind_val.child("description").getValue().toString()));
                        }
                        winds_list.add(new WindItem(date, single_winds));

                    }
                    spot = new Spot(value.child("name").getValue().toString(), value.child("wave").getValue().toString(), value.child("windKnots").getValue().toString(), value.child("direction").getValue(Integer.class), value.child("temperature").getValue(Integer.class), value.child("waterTemperature").getValue(Integer.class), waves_list, winds_list);

                    spots.add(spot); //adding a spot to the list

                }
                SpotsListAdapter customAdapter = new SpotsListAdapter(SurfingSpots.this, spots);
                spots_list.setAdapter(customAdapter); // setting the list to spots

            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });

        spots_list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Spot spot = spots.get(i);
                Intent intent = new Intent(getApplicationContext(), WavesScreen.class);
                intent.putExtra("spot", spot);
                intent.putExtra("user", user);
                startActivity(intent);

            }

        });


    }
}