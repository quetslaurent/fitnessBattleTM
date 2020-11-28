package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.graphics.Color;
import android.os.Bundle;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.util.Log;

import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

import model.ActivitySport;
import model.Training;
import model.UserFitness;
import viewModel.GraphicalModelView;
import viewModel.ProfileViewModel;

public class GraphicalActivity extends AppCompatActivity {
    private SlidrInterface slidr;
    BarChart barChart;
    BarData barData;
    BarDataSet barDataSet;
    private GraphicalModelView graphicalModelView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //slide
        setContentView(R.layout.activity_graphical);
        slidr = Slidr.attach(this);

        graphicalModelView = new  ViewModelProvider(this).get(GraphicalModelView.class);

        graphicalModelView.getTrainingLiveData().observe(this, new Observer<List<Training>>() {
            @Override
            public void onChanged(List<Training> trainings) {
                Log.i("ccc",trainings.toString());
            }
        });

        //graphics
        barChart = findViewById(R.id.chart);
        ArrayList<BarEntry>barEntries=new ArrayList<>();
   /*     barEntries.add(new ActivitySport("pompes",25));
        barEntries.add(new ActivitySport("abdos",35));
        barEntries.add(new ActivitySport("course",15));
        barEntries.add(new ActivitySport("traction",5));
        barEntries.add(new ActivitySport("natation",45)); */

        barDataSet = new BarDataSet(barEntries, "Genre");
        barData = new BarData(barDataSet);
        barDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barChart.setData(barData);
        barChart.getDescription().setText("Nombre de répitions par sport");
        barChart.animateY(2000);
    }

    public void addEntries(ActivitySport activitySport){

    }


}