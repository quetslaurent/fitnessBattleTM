package com.example.projet.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.widget.ListView;

import com.example.projet.R;
import model.Adapter.TrainingAdapter;

import java.util.List;

import model.outputDataModel.TrainingOutput;
import repository.TrainingRepository;

public class Resume_trainingActivity extends AppCompatActivity {

    //declaration du repository

    private TrainingRepository trainingRepository = new TrainingRepository();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume_training);

        //recuperation de la listview
        final ListView lvTraining = findViewById(R.id.lv_trainings);

        //requete pour recuperer tout les trainings du user
        trainingRepository.getTrainingByuserId().observe(this, new Observer<List<TrainingOutput>>() {
            @Override
            public void onChanged(List<TrainingOutput> trainingOutputs) {

                TrainingAdapter trainingAdapter = new TrainingAdapter(Resume_trainingActivity.this, R.id.lv_trainings, trainingOutputs);
                lvTraining.setAdapter(trainingAdapter);

            }
        });


    }
}