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
import android.widget.ProgressBar;
import android.widget.TextView;

public class Shutter_Time_Activity extends AppCompatActivity {
    private static final String TAG = "Shutter_Time_Activity";
    // Bluetooth Connection
    BluetoothAdapter bluetoothAdapter;
    ProgressBar shutter_time_bar;
    Button shutter_time_decrease_button,shutter_time_increase_button,shutter_time_set_button;
    TextView current_shutter_time_textview,max_shutter_time_textview;
    MyGlobals myGlobals;
    private int temp_shutter_time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shutter_time);
        init();

        shutter_time_decrease_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(temp_shutter_time == 0){
                    //do nothing
                    return;
                }
                temp_shutter_time = temp_shutter_time - 1;
                String str = temp_shutter_time + " sec";
                shutter_time_bar.setProgress(temp_shutter_time);
                current_shutter_time_textview.setText(str);

            }
        });

        shutter_time_increase_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int max_shutter_time = myGlobals.max_shutter_time;
                if(temp_shutter_time == max_shutter_time){
                    //do nothing
                    return;
                }
                temp_shutter_time = temp_shutter_time + 1;
                String str = temp_shutter_time + " sec";
                shutter_time_bar.setProgress(temp_shutter_time);
                current_shutter_time_textview.setText(str);
            }
        });
        shutter_time_set_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //sending command to pico to sync the changes
                //String str = "";
                //BluetoothCommunication.writeMsg(str.getBytes(Charset.defaultCharset()));
                //to set update upon reply from pico?
                myGlobals.shutter_time = temp_shutter_time;
                shutter_time_bar.setProgress(temp_shutter_time);
            }
        });
    }

    private void init () {
        myGlobals = MyGlobals.getInstance();
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        shutter_time_bar = findViewById(R.id.shutter_time_bar);
        shutter_time_decrease_button = findViewById(R.id.shutter_time_decrease_button);
        shutter_time_increase_button = findViewById(R.id.shutter_time_increase_button);
        shutter_time_set_button = findViewById(R.id.shutter_time_set_button);
        current_shutter_time_textview = findViewById(R.id.current_shutter_time_textview);
        max_shutter_time_textview = findViewById(R.id.max_shutter_time_textview);
        //set up the page
        temp_shutter_time = myGlobals.shutter_time;
        int current_shutter_time = myGlobals.shutter_time;
        int max_shutter_time = myGlobals.max_shutter_time;
        String str1 = current_shutter_time + " sec";
        String str2 = "Max(sec): " + max_shutter_time;
        current_shutter_time_textview.setText(str1);
        max_shutter_time_textview.setText(str2);
        shutter_time_bar.setProgress(current_shutter_time);
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