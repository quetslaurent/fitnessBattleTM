package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import android.graphics.Color;
import android.os.Bundle;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import java.util.ArrayList;
import java.util.List;
import model.outputDataModel.TrainingOutput;
import repository.TrainingRepository;
import util.SlideR;
import viewModel.GraphicalModelView;

public class GraphicalActivity extends AppCompatActivity {
    LineChart lineChart;
    LineData lineData;
    LineDataSet lineDataSet;
    private ArrayList lineEntries;
    private TrainingRepository trainingRepository = new TrainingRepository();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //slide
        setContentView(R.layout.activity_graphical);
        SlideR.swapBack(this);
        //graphics
        lineChart = findViewById(R.id.lineChart);

     trainingRepository.getTrainingByuserId().observe(this, new Observer<List<TrainingOutput>>() {
         @Override
         public void onChanged(List<TrainingOutput> trainingOutputs) {
             lineEntries=new ArrayList<>();
             int   y=0;
             for(int i=0;i<trainingOutputs.size();i++){
                     double rep = trainingOutputs.get(y).getRepetitions();
                     lineEntries.add(new Entry((float) i, (float) rep));
                     y++;

             }
             
             lineDataSet = new LineDataSet(lineEntries, "Training");
             lineDataSet.setLineWidth(2.0f);
             lineDataSet.setCircleRadius(2f);
             lineDataSet.setDrawValues(true);
             lineDataSet.setColor(ContextCompat.getColor(GraphicalActivity.this, R.color.colorPrimaryDark));
             lineDataSet.setCircleColor(ContextCompat.getColor(GraphicalActivity.this, R.color.colorPrimaryDark));
             lineDataSet.setDrawValues(false);
             lineData = new LineData(lineDataSet);
             lineChart.setData(lineData);
             lineDataSet.getLabel();
             Legend legend = lineChart.getLegend();
             legend.setEnabled(true);
             legend.setTextColor(Color.RED);


             lineDataSet.setValueTextColor(Color.BLACK);
             lineDataSet.setValueTextSize(18f);
             lineChart.animateY(2000);
         }
     });


    }

}