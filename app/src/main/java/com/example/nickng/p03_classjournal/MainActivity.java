package com.example.nickng.p03_classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tvClass;
    ListView lvClass;
    ArrayList<String> al;
    ArrayAdapter<String> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvClass = (TextView)findViewById(R.id.tvClass);
        lvClass = (ListView)findViewById(R.id.lvClass);

        al = new ArrayList<String>();
        al.add("C347");

        aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, al);
        lvClass.setAdapter(aa);

        lvClass.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String className = al.get(position).toString();
                Intent i = new Intent(MainActivity.this, InfoActivity.class);
                i.putExtra("class", className);
                startActivity(i);
            }
        });
    }
}
