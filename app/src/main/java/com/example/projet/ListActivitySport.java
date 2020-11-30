package com.example.projet;

import android.content.Context;
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

    private CategoryRepository categoryRepository = new CategoryRepository();
    private Context context;
    private ListView lvActivities;
    private ActivitiesAdapter activitiesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        lvActivities = findViewById(R.id.list_activities);
        context = this;

        categoryRepository.queryCategoriesActivities().observe(this, new Observer<List<ActivitiesByCategorieOutput>>() {
            @Override
            public void onChanged(List<ActivitiesByCategorieOutput> activityByCategorieOutputs) {
                Log.i("test", activityByCategorieOutputs.toString());
                activitiesAdapter = new ActivitiesAdapter(
                        context,
                        R.id.list_activities,
                        activityByCategorieOutputs
                );

                lvActivities.setAdapter(activitiesAdapter);
            }
        });




    }


}
