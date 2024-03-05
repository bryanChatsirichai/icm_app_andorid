package com.example.icm_base_mdp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class Simple_Actions_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_actions);
        ListView listView = findViewById(R.id.simple_actions_listviews);

        List<String> data = Arrays.asList(getResources().getString(R.string.zoom_to_min),getResources().getString(R.string.zoom_to_max),getResources().getString(R.string.zoom_to_min_and_back)
        ,getResources().getString(R.string.zoom_to_max_and_back),getResources().getString(R.string.zoom_to_value),getResources().getString(R.string.zoom_to_value_and_back),
                getResources().getString(R.string.focus_to_min),getResources().getString(R.string.focus_to_max),getResources().getString(R.string.focus_to_min_and_back)
                ,getResources().getString(R.string.focus_to_max_and_back),getResources().getString(R.string.focus_to_value),getResources().getString(R.string.focus_to_value_and_back),
                getResources().getString(R.string.Zoom_Min_Focus_Min),getResources().getString(R.string.Zoom_Max_Focus_Max),
                getResources().getString(R.string.Zoom_Min_Focus_Max),getResources().getString(R.string.Zoom_Max_Focus_Min),
                getResources().getString(R.string.Zoom_Min_Focus_Min_and_back),getResources().getString(R.string.Zoom_Max_Focus_Max_and_back),getResources().getString(R.string.Zoom_Min_Focus_Max_and_back),
                getResources().getString(R.string.Zoom_Max_Focus_Min_and_back),getResources().getString(R.string.Zoom_Focus_to_value),
                getResources().getString(R.string.Zoom_Focus_to_value_and_back));



        CustomAdapter adapter = new CustomAdapter(this, data,getResources());

        listView.setAdapter(adapter);
    }
}