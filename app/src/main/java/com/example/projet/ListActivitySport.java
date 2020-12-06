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

import java.util.ArrayList;
import java.util.List;

import model.Adapter.CategorySportAdapter;
import model.outputDataModel.ActivitiesByCategorieOutput;
import model.outputDataModel.ActivitySport;
import model.outputDataModel.CategoryOutput;
import repository.ActivityRepository;
import repository.CategoryRepository;

public class ListActivitySport extends AppCompatActivity{

    private CategoryRepository categoryRepository = new CategoryRepository();
    private CategorySportAdapter adapter;
    private RecyclerView recyclerView;
    private ActivityRepository activityRepository = new ActivityRepository();
    private List<ActivitiesByCategorieOutput> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_add);
        recyclerView = findViewById(R.id.recyclerView);


        categoryRepository.query().observe(this, new Observer<List<CategoryOutput>>() {
            @Override
            public void onChanged(final List<CategoryOutput> categoryOutputs) {

                for (int position = 0; position < categoryOutputs.size(); position++) {
                    //recuperation de l'id et du name
                    final int id = categoryOutputs.get(position).getId();
                    final String name = categoryOutputs.get(position).getName();

                    activityRepository.getById(id).observe(ListActivitySport.this, new Observer<List<ActivitySport>>() {
                        @Override
                        public void onChanged(List<ActivitySport> activitySports) {
                            //creation d'un activitiesbycategory
                            ActivitiesByCategorieOutput a = new ActivitiesByCategorieOutput(id,name,activitySports);
                            //ajout à la liste
                            list.add(a);

                            //mise en place du recyclerview
                            adapter = new CategorySportAdapter(list,ListActivitySport.this);
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

        });
    }

        /*categoryRepository.queryCategoriesActivities().observe(this, new Observer<List<ActivitiesByCategorieOutput>>() {
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
        });*/




    public void submit(View view) {
    }
}
