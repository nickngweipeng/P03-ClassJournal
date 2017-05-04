package com.example.nickng.p03_classjournal;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class InfoActivity extends AppCompatActivity {

    ListView lv1;
    ArrayAdapter aa1;
    ArrayList<DailyCA> dailyCA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Button btnRP = (Button)findViewById(R.id.buttonInfo);
        Button btnAdd = (Button)findViewById(R.id.buttonAdd);
        lv1 = (ListView) this.findViewById(R.id.listViewInfo);

        Intent i = getIntent();
        String types = i.getStringExtra("class");
        dailyCA = new ArrayList<DailyCA>();

        // Link this Activity object, the row.xml layout for
        //  each row and the food String array together
        aa1 = new InfoAdapter(this, R.layout.row, dailyCA);
        lv1.setAdapter(aa1);

        btnRP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to display data
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                // Set the URL to be used.
                rpIntent.setData(Uri.parse("http://www.rp.edu.sg"));
                startActivity(rpIntent);

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rpIntent = new Intent(InfoActivity.this, addGrade.class);
                rpIntent.putExtra("pos", String.valueOf(dailyCA.size()+1));
                startActivity(rpIntent);
            }
        });
    }
}
