package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import model.inputDataModel.TrainingDateInput;
import model.inputDataModel.TrainingInput;
import model.outputDataModel.ActivitySport;
import model.outputDataModel.CategoryOutput;
import model.outputDataModel.UserFitnessOutputToken;
import repository.ActivityRepository;
import repository.CategoryRepository;
import repository.TokenRepository;
import repository.TrainingDateRepository;
import repository.TrainingRepository;
import util.SlideR;

public class AddSportActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    //delcaration de nos elements + repository
    private Spinner spin_categories,spin_activities;
    private Button btnSubmit;
    private EditText et_rep;
    private CategoryRepository categoryRepository = new CategoryRepository();
    private ActivityRepository activityRepository = new ActivityRepository();
    private TokenRepository tokenRepository = new TokenRepository();
    private TrainingDateRepository trainingDateRepository = new TrainingDateRepository();
    private TrainingRepository trainingRepository = new TrainingRepository();
    private int idCateg = 1;
    private List<String> categories;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sport);
        //utilisation du slide
        SlideR.swapBack(this);
        //recuperation des elements du layout

        spin_activities = findViewById(R.id.spin_activities);
        spin_categories = findViewById(R.id.spin_categories);
        btnSubmit = findViewById(R.id.btn_submit);
        et_rep = findViewById(R.id.et_rep);

        //remplir les listes déroulantes
        populateSpinnerCategory();
        populateSpinnerActivity(idCateg);

        //creation du training qunad on appuie sur le bouton submit
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivitySport selectedActivity = (ActivitySport) spin_activities.getSelectedItem();
                final int idAct = selectedActivity.getId();
                String repString = et_rep.getText().toString();
                if(!repString.matches("")) {

                    final int rep = Integer.parseInt(repString);
                    tokenRepository.getUserFromToken().observe(AddSportActivity.this, new Observer<UserFitnessOutputToken>() {
                        @Override
                        public void onChanged(UserFitnessOutputToken userFitnessOutputToken) {
                            final int idUser = userFitnessOutputToken.getId();

                            trainingDateRepository.createToday().observe(AddSportActivity.this, new Observer<TrainingDateInput>() {
                                @Override
                                public void onChanged(final TrainingDateInput trainingDateInput) {
                                    int idDate = trainingDateInput.getId();

                                    trainingRepository.create(new TrainingInput(rep, idUser, idAct, idDate)).observe(
                                            AddSportActivity.this, new Observer<TrainingInput>() {
                                                @Override
                                                public void onChanged(TrainingInput trainingInput) {
                                                    Log.i("training", trainingInput.toString());
                                                }
                                            });
                                }
                            });

                        }
                    });
                    Toast.makeText(getApplicationContext(),"Activity added",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(AddSportActivity.this, MenuActivity.class);
                    startActivity(intent);
                }
                return ;
            }
        });

        //recureper les item quand on selectionnes dans la liste déroulante
        spin_categories.setOnItemSelectedListener(this);
        spin_activities.setOnItemSelectedListener(this);

    }

    //remplir la liste déroulante d'activity
    private void populateSpinnerActivity(int idCateg) {
        activityRepository.getById(idCateg).observe(this, new Observer<List<ActivitySport>>() {
            @Override
            public void onChanged(List<ActivitySport> activitySports) {
                ArrayAdapter<ActivitySport> activitySportAdapter = new ArrayAdapter<>(AddSportActivity.this, android.R.layout.simple_spinner_item, activitySports);
                activitySportAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spin_activities.setAdapter(activitySportAdapter);
            }
        });
    }

    //remplir la liste déroulante de category
    private void populateSpinnerCategory() {
        categoryRepository.query().observe(this, new Observer<List<CategoryOutput>>() {
            @Override
            public void onChanged(List<CategoryOutput> categoryOutputs) {
                ArrayAdapter<CategoryOutput> categoryAdapter = new ArrayAdapter<>(
                        AddSportActivity.this,
                        android.R.layout.simple_spinner_dropdown_item,
                        categoryOutputs);
                categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spin_categories.setAdapter(categoryAdapter);

            }
        });

    }

    //recureper les item quand on selectionnes dans la liste déroulante
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(parent.getId() == R.id.spin_categories){
            CategoryOutput selectedCategories = (CategoryOutput) parent.getSelectedItem();
            idCateg = selectedCategories.getId();
            populateSpinnerActivity(idCateg);
        }
        else if(parent.getId() == R.id.spin_activities){
            String selectedActivities = parent.getSelectedItem().toString();
            Log.i("test",selectedActivities);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}