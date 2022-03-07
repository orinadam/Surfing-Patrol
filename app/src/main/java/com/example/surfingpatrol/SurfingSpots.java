package com.example.surfingpatrol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
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

public class SurfingSpots extends AppCompatActivity {

    FirebaseDatabase rootNode;
    DatabaseReference reference;
    Spot spot;
    ArrayList<Spot> spots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surfing_spots);
        ListView spots_list = (ListView)findViewById(R.id.spots_list);
/*        ArrayList<WaveItem> waves = new ArrayList<>();
        waves.add(new WaveItem("Thursday 16/09/2021", new ArrayList<>(Arrays.asList(new SingleWaveItem( "6:00", "1-1.2m", "7-8s", "High"), new SingleWaveItem("12:00", "1.4-1.8m", "7-14s","High waves"),new SingleWaveItem( "18:00", "1-1.3m", "7-8s", "High waves")))));
        waves.add(new WaveItem("Thursday 16/09/2021", new ArrayList<>(Arrays.asList(new SingleWaveItem( "6:00", "1-1.2m", "7-8s", "High"), new SingleWaveItem("12:00", "1.4-1.8m", "7-14s","High waves"),new SingleWaveItem( "18:00", "1-1.3m", "7-8s", "High waves")))));
        ArrayList<WindItem> winds = new ArrayList<>();
        winds.add(new WindItem("Thursday 16/09/2021", new ArrayList<>(Arrays.asList(new SingleWindItem( "6:00", "12 knots", "30", "High"), new SingleWindItem("12:00", "1.4-1.8m", "80","High Winds"),new SingleWindItem( "18:00", "1-1.3m", "140", "High Winds")))));
        winds.add(new WindItem("Thursday 16/09/2021", new ArrayList<>(Arrays.asList(new SingleWindItem( "6:00", "12 knots", "30", "High"), new SingleWindItem("12:00", "1.4-1.8m", "80","High Winds"),new SingleWindItem( "18:00", "1-1.3m", "140", "High Winds")))));*/

        spots = new ArrayList<>();

        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("locations");
        //reference.child("Tel Aviv- Hilton").setValue(spot);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot value: snapshot.getChildren()) {
                    spot = value.getValue(Spot.class);
                    spots.add(spot);

                }
                SpotsListAdapter customAdapter = new SpotsListAdapter(SurfingSpots.this, spots);
                spots_list.setAdapter(customAdapter);

            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });




    }
}