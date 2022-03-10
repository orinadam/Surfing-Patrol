package com.example.surfingpatrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TemperatureScreen extends AppCompatActivity {
    Button windBtn;
    Button waveBtn;


    TextView airColor;
    TextView waterColor;

    Spot spot;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_screen);

        spot = (Spot)getIntent().getExtras().get("spot");
        user = (User)getIntent().getExtras().get("user");

        windBtn = (Button)findViewById(R.id.wind_btn_temp);
        waveBtn = (Button)findViewById(R.id.wave_btn_temp);

        airColor = (TextView)findViewById(R.id.air_temp);
        waterColor = (TextView)findViewById(R.id.water_temp);

        waterColor.setText(String.valueOf(spot.waterTemperature));
        airColor.setText(String.valueOf(spot.temperature));

        // Matching color by temperature
        if(spot.temperature < 20)
            airColor.setBackground(getApplicationContext().getResources().getDrawable(R.drawable.green_circle));
        else if(spot.temperature < 28)
            airColor.setBackground(getApplicationContext().getResources().getDrawable(R.drawable.orange_circle));
        else
            airColor.setBackground(getApplicationContext().getResources().getDrawable(R.drawable.red_circle));

        if(spot.waterTemperature < 20)
            waterColor.setBackground(getApplicationContext().getResources().getDrawable(R.drawable.green_circle));
        else if(spot.waterTemperature < 28)
            waterColor.setBackground(getApplicationContext().getResources().getDrawable(R.drawable.orange_circle));
        else
            waterColor.setBackground(getApplicationContext().getResources().getDrawable(R.drawable.red_circle));


        spot = (Spot)getIntent().getExtras().get("spot");
        user = (User)getIntent().getExtras().get("user");

        windBtn.setOnClickListener(new View.OnClickListener() { //Intent to waveScreen
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WindScreen.class);
                intent.putExtra("spot", spot);
                intent.putExtra("user", user);
                startActivity(intent);
            }
        });

        waveBtn.setOnClickListener(new View.OnClickListener() { //Intent to temperatureScreen
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WavesScreen.class);
                intent.putExtra("spot", spot);
                intent.putExtra("user", user);
                startActivity(intent);
            }
        });

    }
}