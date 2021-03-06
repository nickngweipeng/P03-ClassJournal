package com.example.nickng.p03_classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nickng.p03_classjournal.DailyCA;

import java.util.ArrayList;

/**
 * Created by 15041867 on 4/5/2017.
 */

public class InfoAdapter extends ArrayAdapter<DailyCA> {
    private ArrayList<DailyCA> dailyCA;
    private Context context;
    private TextView tvGrade;
    private ImageView ivIcon;
    private  TextView tvWeek;

    public InfoAdapter(Context context, int resource, ArrayList<DailyCA> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        dailyCA = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvGrade = (TextView) rowView.findViewById(R.id.textViewGrade);
        tvWeek = (TextView) rowView.findViewById(R.id.textViewWeek);
        // Get the ImageView object
        ivIcon = (ImageView) rowView.findViewById(R.id.ivIcon);


        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        DailyCA currentWeek = dailyCA.get(position);
        // Set the TextView to show the food

        tvGrade.setText(currentWeek.getDgGrade());
        tvWeek.setText("Week " + currentWeek.getWeek());
        // Set the image to star or nostar accordingly
            ivIcon.setImageResource(R.drawable.dg);

        // Return the nicely done up View to the ListView
        return rowView;
    }
}
