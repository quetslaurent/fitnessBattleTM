package com.example.projet;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import java.util.List;
import model.CategoryAdapter;
import model.outputDataModel.ActivitiesByCategorieOutput;
import repository.CategoryRepository;

public class ListActivitySport extends AppCompatActivity{

    private CategoryRepository categoryRepository = new CategoryRepository();
    private Context context;
    private ListView lvCategory;
    private CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        lvCategory = findViewById(R.id.list_category);
        context = this;

        categoryRepository.queryCategoriesActivities().observe(this, new Observer<List<ActivitiesByCategorieOutput>>() {
            @Override
            public void onChanged(List<ActivitiesByCategorieOutput> activitiesByCategorieOutputs) {
                Log.i("test", activitiesByCategorieOutputs.toString());

                categoryAdapter = new CategoryAdapter(
                        context,
                        R.id.list_category,
                        activitiesByCategorieOutputs
                );
                lvCategory.setAdapter(categoryAdapter);
            }
        });




    }


}
