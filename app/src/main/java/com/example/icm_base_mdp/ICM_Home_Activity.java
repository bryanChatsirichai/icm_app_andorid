package com.example.icm_base_mdp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.charset.Charset;
import java.util.Objects;

public class ICM_Home_Activity extends AppCompatActivity {
    private static final String TAG = "ICM_Home_Activity";

    // Bluetooth Connection
    BluetoothAdapter bluetoothAdapter;
    MyGlobals myGlobals;
    //View Components
    Button camera_config_button,sync_button;
    TextView action_textview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icm_home);
        init();
        camera_config_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ICM_Home_Activity.this, Configuration_Menu_Activity.class);
                startActivity(i);
            }
        });

        sync_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // to sync pico and app values, values fetch from pico.
                // to do ....
                String str = "sync!";
                BluetoothCommunication.writeMsg(str.getBytes(Charset.defaultCharset()));
            }
        });
    }
    //called during start up, initialize anything necessary
    private void init () {
        myGlobals = MyGlobals.getInstance();
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        action_textview = findViewById(R.id.action_textview);
        int initial_action_value = myGlobals.global_number;
        action_textview.setText(String.valueOf(initial_action_value));
        camera_config_button = findViewById(R.id.camera_config_button);
        sync_button = findViewById(R.id.sync_button);
        LocalBroadcastManager.getInstance(this).registerReceiver(messageReceiver, new IntentFilter("IncomingMsg"));
    }


    //BLUETOOTH SECTION,Receiving important command from RPI
    BroadcastReceiver messageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, "Receiving Msg...");
            String msg = intent.getStringExtra("receivingMsg");

            // dummy action to test message send and reply
            if(Objects.equals(msg, "Action1!")){
                int value = myGlobals.global_number + 1;
                myGlobals.global_number = value;
                action_textview.setText(String.valueOf(value));
                Toast.makeText(ICM_Home_Activity.this, "value " + value,
                        Toast.LENGTH_SHORT).show();
            }
            // dummy action to test message send and reply
            else if(Objects.equals(msg, "shutter_time=10")){
                //decode the message
                //now assume return shutter_time=value from pico
                // Split the string by "="
                String[] parts = msg.split("=");
                myGlobals.shutter_time = Integer.parseInt(parts[1]);
                Toast.makeText(ICM_Home_Activity.this, "synced!",
                        Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(ICM_Home_Activity.this, "try again...",
                        Toast.LENGTH_SHORT).show();
            }


        }
    };

    //dummy to be remove
    public void send_test_message(View v){
        String str = "action1";
        BluetoothCommunication.writeMsg(str.getBytes(Charset.defaultCharset()));
    }


}