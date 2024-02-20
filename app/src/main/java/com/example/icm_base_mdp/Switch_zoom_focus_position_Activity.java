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

public class Switch_zoom_focus_position_Activity extends AppCompatActivity {
    private static final String TAG = "Switch_zoom_focus_position_Activity";
    // Bluetooth Connection
    BluetoothAdapter bluetoothAdapter;
    Button position_zoom_at_the_back_button,position_zoom_at_the_front_button;
    MyGlobals myGlobals;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_zoom_focus_position);
        init();

        position_zoom_at_the_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //sending command to pico to sync the changes
                //String str = "";
                //BluetoothCommunication.writeMsg(str.getBytes(Charset.defaultCharset()));
                //to set update upon reply from pico?
            }
        });
        position_zoom_at_the_front_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //sending command to pico to sync the changes
                //String str = "";
                //BluetoothCommunication.writeMsg(str.getBytes(Charset.defaultCharset()));
                //to set update upon reply from pico?
            }
        });
    }
    private void init () {
        myGlobals = MyGlobals.getInstance();
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        position_zoom_at_the_back_button = findViewById(R.id.position_zoom_at_the_back_button);
        position_zoom_at_the_front_button = findViewById(R.id.position_zoom_at_the_front_button);
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