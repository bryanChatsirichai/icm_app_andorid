package com.example.icm_base_mdp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;
import java.util.Objects;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private List<String> data;

    public CustomAdapter(Context context, List<String> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.list_item_layout, parent, false);
        }

        // Get views and set data for each item
        Button button1 = convertView.findViewById(R.id.button1);

        // Set text based on the data
        String itemText = data.get(position);
        button1.setText(itemText + " - Button 1");

        // Set button click listeners or any other functionality
        // Set click listeners with different actions for each button
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform action A for button1
                /*
                * Maybe can use switch statement to do action depending on button itemText , button_name;
                *
                * */
                performActionA(itemText);
            }
        });

        return convertView;
    }

    // Define your actions
    private void performActionA(String itemText) {
        // Implement the action for button1
        if(Objects.equals(itemText, "Item 1")){
            Toast.makeText(context, "Action A for " + itemText, Toast.LENGTH_SHORT).show();

        }
        else if(Objects.equals(itemText, "Item 2")){
            Toast.makeText(context, "Action B for " + itemText, Toast.LENGTH_SHORT).show();

        }
        else{
            Toast.makeText(context, "Action C for " + itemText, Toast.LENGTH_SHORT).show();
        }


    }

    private void performActionB(String itemText) {
        // Implement the action for button2
        Toast.makeText(context, "Action B for " + itemText, Toast.LENGTH_SHORT).show();
    }
}
