package com.example.projet;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import model.ActivitySportAdapter;
import model.outputDataModel.ActivitiesByCategorieOutput;
import repository.CategoryRepository;

public class ListActivitySport extends AppCompatActivity{

    private CategoryRepository categoryRepository = new CategoryRepository();
    private ActivitySportAdapter adapter;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_add);
        recyclerView = findViewById(R.id.recyclerView);

        categoryRepository.queryCategoriesActivities().observe(this, new Observer<List<ActivitiesByCategorieOutput>>() {
            @Override
            public void onChanged(List<ActivitiesByCategorieOutput> activitiesByCategorieOutputs) {
                Log.i("test", activitiesByCategorieOutputs.toString());
                adapter = new ActivitySportAdapter(activitiesByCategorieOutputs);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.addItemDecoration(new
                        DividerItemDecoration(getApplicationContext(),LinearLayoutManager.VERTICAL));

                recyclerView.setAdapter(adapter);

            }
        });


    }

}
