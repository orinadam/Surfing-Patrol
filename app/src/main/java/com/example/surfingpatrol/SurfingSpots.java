package com.example.surfingpatrol;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
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

/**
 * Spots screen
 * Home screen wich includes list of all spots and some other things
 */

public class SurfingSpots extends AppCompatActivity {

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    ImageButton logout_btn, view_posts_btn;
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
        logout_btn = (ImageButton) findViewById(R.id.spots_logout);
        view_posts_btn = (ImageButton) findViewById(R.id.view_posts);

        user = (User)getIntent().getExtras().get("user");

        spots = new ArrayList<>();

        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("locations");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) { //Getting spots from firebase
                for (DataSnapshot value: snapshot.getChildren()) {

                    ArrayList<WaveItem> waves_list = new ArrayList<>();
                    ArrayList<SingleWaveItem> single_waves = new ArrayList<>();

                    for(DataSnapshot wave_val: value.child("waves").getChildren()){
                        date = wave_val.child("date").getValue(String.class);
                        for(DataSnapshot single_wave_val: wave_val.child("waveItems").getChildren()){
                            single_waves.add(new SingleWaveItem(single_wave_val.child("hour").getValue().toString(), single_wave_val.child("height").getValue().toString(), single_wave_val.child("period").getValue().toString(), single_wave_val.child("description").getValue().toString()));
                        }
                        waves_list.add(new WaveItem(date, single_waves));
                        single_waves = new ArrayList<>();

                    }

                    ArrayList<WindItem> winds_list = new ArrayList<>();
                    ArrayList<SingleWindItem> single_winds = new ArrayList<>();

                    for(DataSnapshot wind_val: value.child("winds").getChildren()){
                        date = wind_val.child("date").getValue(String.class);

                        for(DataSnapshot single_wind_val: wind_val.child("windItems").getChildren()){
                            single_winds.add(new SingleWindItem(single_wind_val.child("hour").getValue().toString(), single_wind_val.child("strength").getValue().toString(), single_wind_val.child("direction").getValue().toString(), single_wind_val.child("description").getValue().toString()));
                        }

                        winds_list.add(new WindItem(date, single_winds));
                        single_winds = new ArrayList<>();

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

        spots_list.setOnItemClickListener(new AdapterView.OnItemClickListener(){ // Intenting to WavesScreen and passing user and spot
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Spot spot = spots.get(i);
                Intent intent = new Intent(getApplicationContext(), WavesScreen.class);
                intent.putExtra("spot", spot);
                intent.putExtra("user", user);
                startActivity(intent);

            }

        });

        logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showDialog();



            }
        });

        view_posts_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Gallery.class);
                intent.putExtra("user", user);
                startActivity(intent);

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.view_posts:
                Intent intent = new Intent(getApplicationContext(), Gallery.class);
                intent.putExtra("user", user);
                startActivity(intent);
                break;
            case R.id.logout_item:
                showDialog();
                break;
            case R.id.exit_item:
                finishAffinity();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    void showDialog()
    {
        final Dialog dialog = new Dialog(SurfingSpots.this);
        //We have added a title in the custom layout. So let's disable the default title.
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //The user will be able to cancel the dialog bu clicking anywhere outside the dialog.
        dialog.setCancelable(true);
        //Mention the name of the layout of your custom dialog.
        dialog.setContentView(R.layout.exit_dialog);

        Button dialog_logout_btn = dialog.findViewById(R.id.exit_btn);
        Button dialog_stay = dialog.findViewById(R.id.stay_btn);

        dialog_logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss(); // Logout
                finish();
            }
        });
        dialog_stay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss(); // Stay

            }
        });
        dialog.show();
    }

}