package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Intent;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.view.Window;


import java.util.List;

import modele.inputDataModel.TrainingInput;
import modele.outputDataModel.ActivitySport;

import modele.outputDataModel.TrainingDateOutput;
import modele.outputDataModel.TrainingOutput;
import modele.outputDataModel.UnitOutput;
import modele.outputDataModel.UserFitnessOutput;
import repository.ActivityRepository;
import repository.CategoryRepository;
import repository.TrainingDateRepository;
import repository.TrainingRepository;
import repository.UnitRepository;
import repository.UserRepository;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

    //creation des repositories
        UserRepository userRepository = new UserRepository();
        UnitRepository unitRepository = new UnitRepository();
        ActivityRepository activityRepository = new ActivityRepository();
        TrainingDateRepository trainingDateRepository = new TrainingDateRepository();
        CategoryRepository categoryRepository = new CategoryRepository();
        TrainingRepository trainingRepository = new TrainingRepository();






        final UserFitnessOutput u1=new UserFitnessOutput("Quets","helha","QuetsBoulette@gmail.com",false);
        ActivitySport act1 = new ActivitySport("pompes",25);
      // TrainingDate tra1 = new TrainingDate(date);
         UnitOutput unt1 = new UnitOutput(1,"Type5");
      /*   trainingDateRepository.create(new TrainingDate(TrainingDate.getTimeNow())).observe(this, new Observer<TrainingDate>() {
             @Override
             public void onChanged(TrainingDate trainingDate) {
                 Log.i("USSSSSSSSSSSER",trainingDate.toString());
             }
         });*/

         trainingDateRepository.query().observe(this, new Observer<List<TrainingDateOutput>>() {
             @Override
             public void onChanged(List<TrainingDateOutput> trainingDateOutputs) {
                 Log.i("USSSSSSSSSSSER", trainingDateOutputs.toString());
             }
         });


/**
         * life cycle owner -> this , notre classe
         * new observer , le flux d'info
         */
        userRepository.query().observe(this, new Observer<List<UserFitnessOutput>>() {
            @Override
            public void onChanged(List<UserFitnessOutput> users) {
                Log.i("UserSql", users.toString());
            }
        }); //renvoie un flux d'info ( liveData)


     /*   userRepository.create(u1).observe(this, new Observer<UserFitness>() {
            @Override
            public void onChanged(UserFitness userFitness) {
                Log.i("user", userFitness.toString());
            }
        }); */

     /*   unitRepository.create(unt1).observe(this, new Observer<Unit>() {
            @Override
            public void onChanged(Unit unit) {
                Log.i("unit", unit.toString());
            }
        });

        activityRepository.create(new ActivitySport("pompes",25)).observe(this, new Observer<ActivitySport>() {
            @Override
            public void onChanged(ActivitySport activitySport) {
                Log.i("activitysport", activitySport.toString());
            }
        });

        categoryRepository.create(new Category(1,"Cardio")).observe(this, new Observer<Category>() {
            @Override
            public void onChanged(Category category) {
                Log.i("categorie", category.toString());
            }
        });*/

    /*    trainingDateRepository.create(new TrainingDate(date)).observe(this, new Observer<TrainingDate>() {
            @Override
            public void onChanged(TrainingDate trainingDate) {
                Log.i("training", trainingDate.toString());
            }
        }); */

 TrainingInput tra = new TrainingInput(12,1,1,1);

    trainingRepository.create(tra).observe(this, new Observer<TrainingInput>() {
            @Override
            public void onChanged(TrainingInput trainingInput) {
                Log.i("traning", trainingInput.toString());
            }
        });


trainingRepository.getTrainingByuserId(1).observe(this, new Observer<List<TrainingOutput>>() {
    @Override
    public void onChanged(List<TrainingOutput> trainingOutputs) {
        Log.i("traning", trainingOutputs.toString());
    }
});
    }




    @Override
    protected void onResume() {
        super.onResume();

    }


    public void goToMenu(View view) {
        Intent intent=new Intent(LoginActivity.this, MenuActivity.class);
        startActivity(intent);
    }

    public void goToRegister(View view) {
            Intent intent=new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
    }



}