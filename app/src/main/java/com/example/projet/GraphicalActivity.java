package com.example.projet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.graphics.Color;
import android.os.Bundle;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

import model.outputDataModel.TrainingOutput;

import repository.TrainingRepository;
import viewModel.GraphicalModelView;

public class GraphicalActivity extends AppCompatActivity {
    private SlidrInterface slidr;
    LineChart lineChart;
    LineData lineData;
    LineDataSet lineDataSet;
    private ArrayList lineEntries;
    private GraphicalModelView graphicalModelView;
    private TrainingRepository trainingRepository = new TrainingRepository();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //slide
        setContentView(R.layout.activity_graphical);
        slidr = Slidr.attach(this);
       // graphicalModelView = new  ViewModelProvider(this).get(GraphicalModelView.class);
        //graphics
        lineChart = findViewById(R.id.lineChart);

     trainingRepository.getTrainingByuserId(1).observe(this, new Observer<List<TrainingOutput>>() {
         @Override
         public void onChanged(List<TrainingOutput> trainingOutputs) {
             lineEntries=new ArrayList<>();
             int   y=0;
             for(int i=0;i<trainingOutputs.size();i++){
                 double rep = trainingOutputs.get(y).getRepetitions();
                 lineEntries.add(new Entry((float) i, (float) rep));
                 y++;
             }
             lineDataSet = new LineDataSet(lineEntries, "");
             lineDataSet.setLineWidth(2.0f);
             lineDataSet.setCircleRadius(2f);
             lineDataSet.setDrawValues(true);
             lineDataSet.setColor(ContextCompat.getColor(GraphicalActivity.this, R.color.colorPrimaryDark));
             lineDataSet.setCircleColor(ContextCompat.getColor(GraphicalActivity.this, R.color.colorPrimaryDark));

             lineDataSet.setDrawValues(false);
             lineData = new LineData(lineDataSet);
             lineChart.setData(lineData);


             lineDataSet.setValueTextColor(Color.BLACK);
             lineDataSet.setValueTextSize(18f);
             lineChart.animateY(2000);
         }
     });


    }

}