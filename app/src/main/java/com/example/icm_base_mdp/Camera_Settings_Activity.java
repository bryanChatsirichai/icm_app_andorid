package com.example.icm_base_mdp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Camera_Settings_Activity extends AppCompatActivity {
    Button shutter_time_button;
    Button motor_time_button;
    Button excess_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_settings);
        init();

        shutter_time_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Camera_Settings_Activity.this, Shutter_Time_Activity.class);
                startActivity(i);
            }
        });
        motor_time_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Camera_Settings_Activity.this, Motor_Time_Activity.class);
                startActivity(i);
            }
        });
    }
    private void init () {
        shutter_time_button = findViewById(R.id.shutter_time_button);
        motor_time_button = findViewById(R.id.motor_time_button);
        excess_button = findViewById(R.id.excess_button);
    }
}