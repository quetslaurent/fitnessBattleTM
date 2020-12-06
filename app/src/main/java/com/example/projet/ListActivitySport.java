package com.example.projet;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import model.CategorySportAdapter;
import model.outputDataModel.ActivitiesByCategorieOutput;
import repository.CategoryRepository;

public class ListActivitySport extends AppCompatActivity{

    private CategoryRepository categoryRepository = new CategoryRepository();
    private CategorySportAdapter adapter;
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
                adapter = new CategorySportAdapter(activitiesByCategorieOutputs,ListActivitySport.this);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.addItemDecoration(new
                        DividerItemDecoration(getApplicationContext(),LinearLayoutManager.VERTICAL));

                recyclerView.setAdapter(adapter);

            }
        });


    }

    public void submit(View view) {
    }
}
