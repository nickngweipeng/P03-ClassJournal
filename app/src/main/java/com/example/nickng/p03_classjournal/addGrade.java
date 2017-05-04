package com.example.nickng.p03_classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.nickng.p03_classjournal.R.layout.activity_add_grade;

public class addGrade extends AppCompatActivity {
    TextView tvWeek;
    RadioGroup rg;
    Button btnSubmit;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_add_grade);
         iv = (ImageView)findViewById(R.id.iv);
        iv.setImageResource(R.drawable.dg);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        tvWeek = (TextView) findViewById(R.id.tvWeek);
        rg = (RadioGroup) findViewById(R.id.rgGrade);

        final String pos = getIntent().getStringExtra("pos");
        tvWeek.setText("Week " + pos);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selected = rg.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) findViewById(selected);
                String grade = rb.getText().toString();
                Intent i = new Intent();
                Toast.makeText(addGrade.this,grade,Toast.LENGTH_SHORT).show();
                i.putExtra("grade", grade);
                // Set result to RESULT_OK to indicate normal
                // response and pass in the intent containing the
                // like
                setResult(RESULT_OK, i);
                finish();

            }
        });
    }
}
