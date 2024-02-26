package com.example.icm_base_mdp;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Motor_Calibration_Activity extends AppCompatActivity {
    private static final String TAG = "Motor_Calibration_Activity";
    // Bluetooth Connection
    BluetoothAdapter bluetoothAdapter;
    Button motor_calibration_zoom_cali_button,motor_calibration_focus_cali_button,motor_calibration_pov_cali_button;
    MyGlobals myGlobals;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motor_calibration);
        init();
        motor_calibration_zoom_cali_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Motor_Calibration_Activity.this, Zoom_Calibration_Activity.class);
                startActivity(i);
            }
        });
        motor_calibration_focus_cali_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Motor_Calibration_Activity.this, Focus_Calibration_Activity.class);
                startActivity(i);

            }
        });
        motor_calibration_pov_cali_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    private void init () {
        myGlobals = MyGlobals.getInstance();
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        motor_calibration_zoom_cali_button = findViewById(R.id.motor_calibration_zoom_cali_button);
        motor_calibration_focus_cali_button = findViewById(R.id.motor_calibration_focus_cali_button);
        motor_calibration_pov_cali_button = findViewById(R.id.motor_calibration_pov_cali_button);
    }
}