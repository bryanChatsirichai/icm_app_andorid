package com.example.icm_base_mdp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class ICM_Home_Activity extends AppCompatActivity {
    private static final String TAG = "ICM_Home_Activity";
    //State of our program
    boolean bluetoothIsOn = false;
    boolean tiltSensorOn = false;
    boolean automaticeUpdate = true;

    // Bluetooth Connection
    BluetoothAdapter bluetoothAdapter;

    //View Components
    Button camera_config_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icm_home);
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        init();
        camera_config_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    //called during start up, initialize anything necessary
    private void init () {
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
            Toast.makeText(ICM_Home_Activity.this, msg,
                    Toast.LENGTH_LONG).show();

        }
    };

    public void click_camera_config(View v){

    }

    //dummy to be remove
    public void send_test_message(View v){
        String str = "action1";
        BluetoothCommunication.writeMsg(str.getBytes(Charset.defaultCharset()));
    }


}