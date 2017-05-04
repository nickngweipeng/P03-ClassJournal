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
    int requestCode = 1;
    DailyCA newObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Button btnRP = (Button) findViewById(R.id.buttonInfo);
        Button btnAdd = (Button) findViewById(R.id.buttonAdd);
        Button btnEmail = (Button) findViewById(R.id.buttonEmail);
        lv1 = (ListView) this.findViewById(R.id.listViewInfo);
        Intent i = getIntent();
        final String types = i.getStringExtra("class");

        dailyCA = new ArrayList<DailyCA>();
        DailyCA obj1 = new DailyCA("A","C347",1);
        DailyCA obj2 = new DailyCA("B","C347",2);
        DailyCA obj3 = new DailyCA("C","C347",3);

        dailyCA.add(obj1);
        dailyCA.add(obj2);
        dailyCA.add(obj3);

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
                rpIntent.putExtra("module", types);
                rpIntent.putExtra("pos", String.valueOf(dailyCA.size() + 1));
                startActivityForResult(rpIntent, requestCode);
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String to = "jackielim8695@gmail.com";
                String subject = "C347";
                String message = "Hi Faci \n\n I am .....\n Please see my remarks so far, Thank You \n\n";
                for (int i = 0; i < dailyCA.size() + 1; i++) {
                    message += " Week : " + String.valueOf(dailyCA.size() + 1) + " DG:" + dailyCA.get(0).getDgGrade();
                }

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                //email.putExtra(Intent.EXTRA_CC, new String[]{ to});
                //email.putExtra(Intent.EXTRA_BCC, new String[]{to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);

                //need this to prompts email client only
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email client :"));

            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Only handle when 2nd activity closed normally
        //  and data contains something
        if(resultCode == RESULT_OK){
            if(newObject!=null){
                newObject = (DailyCA) data.getSerializableExtra("object");
                dailyCA.add(newObject);
            }


        }
    }

}
