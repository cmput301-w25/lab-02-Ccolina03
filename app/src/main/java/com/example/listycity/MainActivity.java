package com.example.listycity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.*;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {
    //Instance Variables to define
    ListView cityList;
    Button btn;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // EdgeToEdge.enable(this);

        //Accessing activity_main file
        setContentView(R.layout.activity_main);
//        //Handle top of screen make it different(optional)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        editText = (EditText) findViewById(R.id.editText1);
        btn = (Button) findViewById(R.id.button1);
        //Get id of component of list
        cityList = findViewById(R.id.city_list);
        //String[] cities = {"Edmonton", "Vancouver", "Calgary"};
        dataList = new ArrayList<>();
        //dataList.addAll(Arrays.asList(cities));
        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);
        cityList.setAdapter(cityAdapter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // this line adds the data of your EditText and puts in your array
                dataList.add(editText.getText().toString());
                // next thing you have to do is check if your adapter has changed
                cityAdapter.notifyDataSetChanged();
            }
        });

        // Set an item click listener for the ListView
        cityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                // Remove the clicked item from the dataList
                dataList.remove(position);
                // Notify the adapter of the change
                cityAdapter.notifyDataSetChanged();
            }
        });
    }
}