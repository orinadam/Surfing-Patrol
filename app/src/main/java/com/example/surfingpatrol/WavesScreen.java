package com.example.surfingpatrol;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Arrays;


public class WavesScreen extends AppCompatActivity {

    Button windBtn;
    Button temperatureBtn;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waves_screen);
        windBtn = (Button)findViewById(R.id.wind_btn_wave);
        temperatureBtn = (Button)findViewById(R.id.temperature_btn_wave);
        ListView yourListView = (ListView) findViewById(R.id.itemWaveListView);
        WaveItem[] items = {new WaveItem("Thursday 16/09/2021", new SingleWaveItem[]{ new SingleWaveItem( "6:00", "1-1.2m", "7-8s", "High"), new SingleWaveItem("12:00", "1.4-1.8m", "7-14s","High waves"),new SingleWaveItem( "18:00", "1-1.3m", "7-8s", "High waves")}), new WaveItem("Friday 17/09/2021", new SingleWaveItem[]{ new SingleWaveItem( "6:00", "0.6-1m", "5-6s", "Head"), new SingleWaveItem("12:00", "1.4-1.8m", "7-14s","High waves"),new SingleWaveItem( "18:00", "1-1.3m", "7-8s", "High waves")}), new WaveItem("Thursday 16/09/2021", new SingleWaveItem[]{ new SingleWaveItem( "6:00", "1-1.2m", "7-8s", "High"), new SingleWaveItem("12:00", "1.4-1.8m", "7-14s","High waves"),new SingleWaveItem( "18:00", "1-1.3m", "7-8s", "High waves")}), new WaveItem("Thursday 16/09/2021", new SingleWaveItem[]{ new SingleWaveItem( "6:00", "1-1.2m", "7-8s", "High"), new SingleWaveItem("12:00", "1.4-1.8m", "7-14s","High waves"),new SingleWaveItem( "18:00", "1-1.3m", "7-8s", "High waves")}), new WaveItem("Thursday 16/09/2021", new SingleWaveItem[]{ new SingleWaveItem( "6:00", "1-1.2m", "7-8s", "High"), new SingleWaveItem("12:00", "1.4-1.8m", "7-14s","High waves"),new SingleWaveItem( "18:00", "1-1.3m", "7-8s", "High waves")})};
// get data from the table by the ListAdapter
       ListAdapter customAdapter = new ListAdapter(this, R.layout.wave_item_list_row, Arrays.asList(items.clone()));
        yourListView.setAdapter(customAdapter);
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("locations");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot value: snapshot.getChildren()) {
                    value.getValue();

                }
                Toast toast=Toast.makeText(getApplicationContext(),"Hello " + snapshot.getValue(),Toast.LENGTH_SHORT);
                toast.setMargin(50,50);
                toast.show();

            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });

        windBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WindScreen.class);
                startActivity(intent);
            }
        });

        temperatureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TemperatureScreen.class);
                startActivity(intent);
            }
        });

    }
}