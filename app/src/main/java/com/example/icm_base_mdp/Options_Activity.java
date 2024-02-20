package com.example.icm_base_mdp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Options_Activity extends AppCompatActivity {
    private static final String TAG = "Options_Time_Activity";
    // Bluetooth Connection
    BluetoothAdapter bluetoothAdapter;
    Button options_switch_zf_button,options_rotation_button,options_reset_camera_button,options_reset_motor_Calibration_button;
    MyGlobals myGlobals;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        init();

        options_switch_zf_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        options_rotation_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        options_reset_camera_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        options_reset_motor_Calibration_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    private void init () {
        myGlobals = MyGlobals.getInstance();
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        options_switch_zf_button = findViewById(R.id.options_switch_zf_button);
        options_rotation_button = findViewById(R.id.options_rotation_button);
        options_reset_camera_button = findViewById(R.id.options_reset_camera_button);
        options_reset_motor_Calibration_button = findViewById(R.id.options_reset_motor_Calibration_button);
        LocalBroadcastManager.getInstance(this).registerReceiver(messageReceiver, new IntentFilter("IncomingMsg"));

    }
    //BLUETOOTH SECTION, Receiving important command from RPI
    BroadcastReceiver messageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, "Receiving Msg...");
            String msg = intent.getStringExtra("receivingMsg");
            //depending on the message, decode action an values to do
            //...
        }
    };
}