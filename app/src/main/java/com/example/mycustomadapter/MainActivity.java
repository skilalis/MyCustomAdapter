package com.example.mycustomadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private String[] countryNames;
    private int[] flags = {R.drawable.afghanistan,R.drawable.armenia,R.drawable.azerbaijan,R.drawable.bahrain,R.drawable.bangladesh,R.drawable.china,R.drawable.bhutan,R.drawable.india,R.drawable.japan,R.drawable.nepal,R.drawable.pakistan,R.drawable.srilanka};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countryNames =getResources().getStringArray(R.array.country_names);

        listView = findViewById(R.id.listViewId);
        CustomAdapter adapter = new CustomAdapter(this,countryNames,flags);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = countryNames[position];
                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
            }
        });

    }
}