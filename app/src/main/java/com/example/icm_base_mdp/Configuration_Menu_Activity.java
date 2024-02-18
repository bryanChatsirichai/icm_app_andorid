package com.example.icm_base_mdp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

public class Configuration_Menu_Activity extends AppCompatActivity {
    BluetoothAdapter bluetoothAdapter;
    MyGlobals myGlobals;
    //View Components
    Button camera_setting_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration_menu);
        init();

        camera_setting_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Configuration_Menu_Activity.this, Camera_Settings_Activity.class);
                startActivity(i);
            }
        });
    }
    //called during start up, initialize anything necessary
    private void init () {
        myGlobals = MyGlobals.getInstance();
        camera_setting_button = findViewById(R.id.camera_setting_button);
    }
}