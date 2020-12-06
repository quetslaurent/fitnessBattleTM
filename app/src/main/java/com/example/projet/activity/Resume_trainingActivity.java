package com.example.projet.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.widget.ListView;

import com.example.projet.R;
import com.example.projet.TrainingAdapter;
import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;
import java.util.List;

import model.outputDataModel.TrainingOutput;
import repository.TrainingRepository;

public class Resume_trainingActivity extends AppCompatActivity {

    private TrainingRepository trainingRepository = new TrainingRepository();
    private List<TrainingOutput> trainingOutputsArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume_training);


        final ListView lvTraining = findViewById(R.id.lv_movies);

        trainingRepository.getTrainingByuserId().observe(this, new Observer<List<TrainingOutput>>() {
            @Override
            public void onChanged(List<TrainingOutput> trainingOutputs) {

                TrainingAdapter trainingAdapter = new TrainingAdapter(Resume_trainingActivity.this, R.id.lv_movies, trainingOutputs);
                lvTraining.setAdapter(trainingAdapter);


            }
        });


    }
}