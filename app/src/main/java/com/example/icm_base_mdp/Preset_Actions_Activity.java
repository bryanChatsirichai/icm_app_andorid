package com.example.icm_base_mdp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class Preset_Actions_Activity extends AppCompatActivity {
    TextView actions_header_layout_shutter_time_textview;
    TextView actions_header_layout_motor_time_textview;
    TextView actions_header_layout_excess_time_textview;
    TextView actions_header_layout_zoom_current_textview;
    TextView actions_header_layout_zoom_range_textview;
    TextView actions_header_layout_focus_current_textview;
    TextView actions_header_layout_focus_range_textview;

    MyGlobals myGlobals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preset_actions);
        ListView listView = findViewById(R.id.preset_actions_listviews);
        init();


        List<String> data = Arrays.asList(getResources().getString(R.string.Bokeh),getResources().getString(R.string.Firework_Focus),
                getResources().getString(R.string.Firework_Zoom_Focus),getResources().getString(R.string.Zoom_Blur_Min),
                getResources().getString(R.string.Zoom_Blur_Max),getResources().getString(R.string.SinWave_1),
                getResources().getString(R.string.SinWave_2)
                );

        CustomAdapter2 adapter = new CustomAdapter2(this, data,getResources());

        listView.setAdapter(adapter);
    }

//    protected void onResume() {
//        super.onResume();
//        //refreshHeader();
//    }

    private void init () {
        myGlobals = MyGlobals.getInstance();

        actions_header_layout_shutter_time_textview = findViewById(R.id.actions_header_layout_shutter_time_textview);
        actions_header_layout_motor_time_textview = findViewById(R.id.actions_header_layout_motor_time_textview);
        actions_header_layout_excess_time_textview = findViewById(R.id.actions_header_layout_excess_time_textview);
        actions_header_layout_zoom_current_textview = findViewById(R.id.actions_header_layout_zoom_current_textview);
        actions_header_layout_zoom_range_textview = findViewById(R.id.actions_header_layout_zoom_range_textview);
        actions_header_layout_focus_current_textview = findViewById(R.id.actions_header_layout_focus_current_textview);
        actions_header_layout_focus_range_textview = findViewById(R.id.actions_header_layout_focus_range_textview);
        refreshHeader();
    }
    private void refreshHeader(){
        // This code will be executed every time the activity becomes visible
        // This includes when navigating back to the activity
        //set the text_views whenever come back to this page
        String shutter_time_str = getResources().getString(R.string.shutter_time)+ ' ' + myGlobals.shutter_time;
        actions_header_layout_shutter_time_textview.setText(shutter_time_str);
        String motor_time_str = getResources().getString(R.string.motor_time) + ' ' + myGlobals.motor_time;
        actions_header_layout_motor_time_textview.setText(motor_time_str);
        String excess_option_set_str = "";
        switch (myGlobals.excess_option_set) {
            case 0:
                // code block
                excess_option_set_str = getResources().getString(R.string.excess_option_set) + ' ' + "Pre";
                actions_header_layout_excess_time_textview.setText(excess_option_set_str);

                break;
            case 1:
                // code block
                excess_option_set_str = getResources().getString(R.string.excess_option_set) + ' ' + "Split";
                actions_header_layout_excess_time_textview.setText(excess_option_set_str);
                break;
            case 2:
                // code block
                excess_option_set_str = getResources().getString(R.string.excess_option_set) + ' ' + "After";
                actions_header_layout_excess_time_textview.setText(excess_option_set_str);
                break;
            // more cases as needed
            default:
                // code block executed if expression doesn't match any case
        }

        String zoom_current_str = getResources().getString(R.string.zoom_current)+ ' ' + myGlobals.zoom_current;
        actions_header_layout_zoom_current_textview.setText(zoom_current_str);
        String zoom_range_str = getResources().getString(R.string.zoom_range)+ ' ' + myGlobals.zoom_range;
        actions_header_layout_zoom_range_textview.setText(zoom_range_str);
        String focus_current_str = getResources().getString(R.string.focus_current)+ ' ' + myGlobals.focus_current;
        actions_header_layout_focus_current_textview.setText(focus_current_str);
        String focus_range_str = getResources().getString(R.string.focus_range)+ ' ' + myGlobals.focus_range;
        actions_header_layout_focus_range_textview.setText(focus_range_str);

    }
}