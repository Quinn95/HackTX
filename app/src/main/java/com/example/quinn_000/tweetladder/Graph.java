package com.example.quinn_000.tweetladder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import java.util.ArrayList;

import android.widget.TextView;


/**
 * Created by Hamza on 10/22/16.
 */



class Graph extends AppCompatActivity {

    BarChart barChart;
    /*
    public int root = 100;
    public int firstLayer = 50;
    public int secondLayer = 10;
    public int thirdLayer = 40;
    */
/*
    private void kill_activity()
    {

        finish();
    }
*/
    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphs);


        Bundle b = getIntent().getExtras();

        int val1 = b.getInt("D1");
        int val2 = b.getInt("D2");
        int val3 = b.getInt("D3");
        int val4 = b.getInt("D4");

        String usernameV = b.getString("username");
        String keywordV = b.getString("keyword");


        TextView sumBoxField = (TextView) findViewById(R.id.sumBox);
        sumBoxField.setText(usernameV + "-" + keywordV + " Relevance");



        barChart = (BarChart) findViewById(R.id.action_bargraph);
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(0f, val1));
        barEntries.add(new BarEntry(1f, val2));
      //  barEntries.add(new BarEntry(2f, val3));
        //barEntries.add(new BarEntry(3f, val4));

        /*Y axis*/
        YAxis yAxis = barChart.getAxisRight();
        YAxis leftAxis = barChart.getAxisLeft();
        leftAxis.setAxisMinimum(00f);
        leftAxis.setAxisMaximum(100f);

        barChart.getAxisRight().setEnabled(false);
        XAxis xAxis = barChart.getXAxis();
        barChart.getXAxis().setEnabled(false);
        barChart.getAxisRight().setEnabled(false);
        BarDataSet barDataSet = new BarDataSet(barEntries, "");
        /* sets color*/

        barDataSet.setColor(0xFF4500, 180);



        //disable excess stuff
        barChart.getLegend().setEnabled(false);
        barChart.getDescription().setEnabled(false);

        BarData theData = new BarData(barDataSet);



        //set width of bar
        theData.setBarWidth(0.7f);


        //aniamte in y and x direction
        barChart.animateY(2000, Easing.EasingOption.EaseInQuart);
        barChart.animateX(2000);
        //barChart.animateXY(450, 3500);
        barChart.setData(theData);

        //input stuff
        barChart.setTouchEnabled(true);
        barChart.setDragEnabled(true);
        barChart.setScaleEnabled(true);


    }






}
