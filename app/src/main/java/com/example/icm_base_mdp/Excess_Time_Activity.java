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

public class Excess_Time_Activity extends AppCompatActivity {
    private static final String TAG = "Excess_Time_Activity";
    // Bluetooth Connection
    BluetoothAdapter bluetoothAdapter;
    Button excess_time_pre_button,excess_time_split_button,excess_time_After_button;
    MyGlobals myGlobals;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excess_time);
        init();
        excess_time_pre_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        excess_time_split_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        excess_time_After_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    private void init () {
        myGlobals = MyGlobals.getInstance();
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        excess_time_pre_button = findViewById(R.id.excess_time_pre_button);
        excess_time_split_button = findViewById(R.id.excess_time_split_button);
        excess_time_After_button = findViewById(R.id.excess_time_After_button);
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