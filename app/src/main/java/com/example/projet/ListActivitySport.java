package com.example.projet;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import java.util.ArrayList;
import java.util.List;
import model.ActivitiesAdapter;
import model.outputDataModel.ActivitySport;
import model.outputDataModel.ActivitiesByCategorieOutput;
import repository.CategoryRepository;

public class ListActivitySport extends AppCompatActivity{

    private List<ActivitySport> activitySports = new ArrayList<>();
    private CategoryRepository categoryRepository = new CategoryRepository();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ListView lvActivities = findViewById(R.id.list_activities);

        categoryRepository.queryCategoriesActivities().observe(this, new Observer<List<ActivitiesByCategorieOutput>>() {
            @Override
            public void onChanged(List<ActivitiesByCategorieOutput> activityByCategorieOutputs) {
                Log.i("test", activityByCategorieOutputs.toString());
            }
        });



        //activitySports.add(new ActivitySport("Abdo", 20));
        ActivitiesAdapter activitiesAdapter = new ActivitiesAdapter(
                this,
                R.id.list_activities,
                activitySports
        );

        lvActivities.setAdapter(activitiesAdapter);
    }


}
