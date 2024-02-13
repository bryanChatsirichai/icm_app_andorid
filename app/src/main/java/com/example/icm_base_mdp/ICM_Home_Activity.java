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
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class ICM_Home_Activity extends AppCompatActivity {
    //State of our program
    boolean bluetoothIsOn = false;
    boolean tiltSensorOn = false;
    boolean automaticeUpdate = true;

    // Bluetooth Connection
    BluetoothAdapter bluetoothAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icm_home);
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

    }
    public void send_test_message(View v){
        String str = "A";
        BluetoothCommunication.writeMsg(str.getBytes(Charset.defaultCharset()));
    }


}