package com.example.finalproj;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.util.Log;


import java.util.ArrayList;


import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import com.github.mikephil.charting.formatter.ValueFormatter;



public class graph extends AppCompatActivity {
    private LineChart linechart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graph);
        Bundle myBundle = getIntent().getExtras();
        int[] log = myBundle.getIntArray("logs");
        ArrayList<Integer> logs = new ArrayList<Integer>();

        linechart = (LineChart) findViewById(R.id.graphs);


        TinyDB tinydb = new TinyDB(this);
        ArrayList<LineDataSet> lines = new ArrayList<LineDataSet>();
        LineData chartData = new LineData();

        for (int i = 0; i < 20; i++) {
            log[i] = log[i] * 3;
            logs.add(log[i]);

        }
        if (tinydb.getString("it").isEmpty()) {
            tinydb.putListInt("first", logs);
            String it = new String("them");
            tinydb.putString("it", it);

        } else {

            ArrayList<Integer> list = tinydb.getListInt("first");
            ArrayList<Entry> first = new ArrayList<>();

            first.add(new Entry(scale(30), list.get(0)));
            first.add(new Entry(scale(45), list.get(1)));
            first.add(new Entry(scale(60), list.get(2)));
            first.add(new Entry(scale(90), list.get(3)));
            first.add(new Entry(scale(125), list.get(4)));
            first.add(new Entry(scale(187), list.get(5)));
            first.add(new Entry(scale(250), list.get(6)));
            first.add(new Entry(scale(375), list.get(7)));
            first.add(new Entry(scale(500), list.get(8)));
            first.add(new Entry(scale(750), list.get(9)));
            first.add(new Entry(scale(1000), list.get(10)));
            first.add(new Entry(scale(1500), list.get(11)));
            first.add(new Entry(scale(2000), list.get(12)));
            first.add(new Entry(scale(3000), list.get(13)));
            first.add(new Entry(scale(4000), list.get(14)));
            first.add(new Entry(scale(6000), list.get(15)));
            first.add(new Entry(scale(8000), list.get(16)));
            first.add(new Entry(scale(12000), list.get(17)));
            first.add(new Entry(scale(16000), list.get(18)));

            LineDataSet set2 = new LineDataSet(first, "Original Test");
            LineData data1 = new LineData(set2);

            set2.setColor(Color.RED);
            set2.setLineWidth(20f);
            chartData.addDataSet(set2);
            lines.add(set2);
        }


        ArrayList<Entry> values = new ArrayList<>();


        values.add(new Entry(scale(30), log[0]));
        values.add(new Entry(scale(45), log[1]));
        values.add(new Entry(scale(60), log[2]));
        values.add(new Entry(scale(90), log[3]));
        values.add(new Entry(scale(125), log[4]));
        values.add(new Entry(scale(187), log[5]));
        values.add(new Entry(scale(250), log[6]));
        values.add(new Entry(scale(375), log[7]));
        values.add(new Entry(scale(500), log[8]));
        values.add(new Entry(scale(750), log[9]));
        values.add(new Entry(scale(1000), log[10]));
        values.add(new Entry(scale(1500), log[11]));
        values.add(new Entry(scale(2000), log[12]));
        values.add(new Entry(scale(3000), log[13]));
        values.add(new Entry(scale(4000), log[14]));
        values.add(new Entry(scale(6000), log[15]));
        values.add(new Entry(scale(8000), log[16]));
        values.add(new Entry(scale(12000), log[17]));
        values.add(new Entry(scale(16000), log[18]));


        linechart.getAxisLeft().setAxisMaximum(65);
        linechart.getAxisLeft().setAxisMinimum(0);
        linechart.getAxisRight().setAxisMaximum(65);
        linechart.getAxisRight().setAxisMinimum(0);

        linechart.getXAxis().setAxisMinimum(scale(10));
        linechart.getXAxis().setAxisMaximum(scale(20000.0));
        linechart.getXAxis().setLabelCount(5, true);

        LineDataSet set1 = new LineDataSet(values, "Current Test");

        set1.setColor(Color.BLUE);
        set1.setLineWidth(5f);

        linechart.getXAxis().setAxisLineColor(Color.rgb(0, 0, 0));
        linechart.getAxisLeft().setAxisLineColor(Color.rgb(0, 0, 0));

        linechart.getAxisLeft().setTextColor(Color.rgb(0, 0, 0));
        linechart.getXAxis().setTextColor(Color.rgb(0, 0, 0));

        LineData data = new LineData(set1);
        chartData.addDataSet(set1);
        linechart.setData(chartData);


    }

    //Class From GitHub
    private float scale(double val) {
        return (float) (Math.log10(val));
    }

    //Class from GitHub
    private int unScale(double val) {
        double calcVal = Math.pow(10, val);
        return (int) (calcVal);
    }

    //Class from GitHub
    private class AxisFormatter extends ValueFormatter {
        @Override
        public String getFormattedValue(float value) {

            return unScale(value / 1) + " Hz";
        }
    }

    public void again(View v) {
        Intent intent = new Intent(graph.this, ProfileActivity.class);
        startActivity(intent);
    }

}