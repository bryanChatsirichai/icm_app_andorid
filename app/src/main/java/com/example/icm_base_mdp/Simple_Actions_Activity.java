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

        List<String> data = Arrays.asList("Item 1", "Item 2", "Item 3","Item 4", "Item 5", "Item 6","Item 7", "Item 8", "Item 9");
        CustomAdapter adapter = new CustomAdapter(this, data);

        listView.setAdapter(adapter);
    }
}