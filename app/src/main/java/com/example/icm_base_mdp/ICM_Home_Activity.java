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
    //State of our program
    boolean bluetoothIsOn = false;
    boolean tiltSensorOn = false;
    boolean automaticeUpdate = true;

    // Bluetooth Connection
    BluetoothAdapter bluetoothAdapter;
    MyGlobals myGlobals;
    //View Components
    Button camera_config_button;
    TextView action_textview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icm_home);
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        init();
        camera_config_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ICM_Home_Activity.this, Configuration_Menu_Activity.class);
                startActivity(i);
            }
        });
    }
    //called during start up, initialize anything necessary
    private void init () {
        myGlobals = MyGlobals.getInstance();
        action_textview = findViewById(R.id.action_textview);
        int initial_action_value = myGlobals.get_global_number();
        action_textview.setText(String.valueOf(initial_action_value));
        camera_config_button = findViewById(R.id.camera_config_button);
        LocalBroadcastManager.getInstance(this).registerReceiver(messageReceiver, new IntentFilter("IncomingMsg"));
    }


    /*
     * BLUETOOTH SECTION
     */
    // Receiving important command from RPI
    BroadcastReceiver messageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, "Receiving Msg...");
            String msg = intent.getStringExtra("receivingMsg");
            if(Objects.equals(msg, "Action1!")){
                int value = myGlobals.get_global_number() + 1;
                myGlobals.set_global_number(value);
                action_textview.setText(String.valueOf(value));
                Toast.makeText(ICM_Home_Activity.this, "value " + value,
                        Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(ICM_Home_Activity.this, msg,
                        Toast.LENGTH_LONG).show();
            }


        }
    };

    //dummy to be remove
    public void send_test_message(View v){
        String str = "action1";
        BluetoothCommunication.writeMsg(str.getBytes(Charset.defaultCharset()));
    }


}