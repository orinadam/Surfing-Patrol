package com.example.surfingpatrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TemperatureScreen extends AppCompatActivity {
    Button windBtn;
    Button waveBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_screen);
        windBtn = (Button)findViewById(R.id.wind_btn_temp);
        waveBtn = (Button)findViewById(R.id.wave_btn_temp);

        windBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WindScreen.class);
                startActivity(intent);
            }
        });

        waveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WavesScreen.class);
                startActivity(intent);
            }
        });

    }
}