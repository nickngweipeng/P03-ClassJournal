package com.example.nickng.p03_classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class addGrade extends AppCompatActivity {
    TextView tvWeek;
    RadioGroup rg;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_grade);
        final String pos = getIntent().getStringExtra("pos");
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        tvWeek = (TextView) findViewById(R.id.tvWeek);
        rg = (RadioGroup) findViewById(R.id.rgGrade);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selected = rg.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton)findViewById(selected);
                String grade = rb.getText().toString();
                Intent i = new Intent();
                i.putExtra("addgrade", grade);
                i.putExtra("pos", pos);
                // Set result to RESULT_OK to indicate normal
                // response and pass in the intent containing the
                // like
                setResult(RESULT_OK, i);
                finish();

            }
        });
    }
}