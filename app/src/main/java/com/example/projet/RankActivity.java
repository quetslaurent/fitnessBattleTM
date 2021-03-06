package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import model.Adapter.RankAdapter;
import model.outputDataModel.UserFitnessOutput;
import repository.UserRepository;

public class RankActivity extends AppCompatActivity {

    //declaration
    private List<UserFitnessOutput> userFitness = new ArrayList<>();
    private UserRepository userRepository = new UserRepository();
    private ListView lvUsers;
    private RankAdapter rankAdapter;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);
        //init view
        lvUsers = findViewById(R.id.list_users);
        context = this;

        //mettre la liste des users dans un adapter
        userRepository.query().observe(this, new Observer<List<UserFitnessOutput>>() {
            @Override
            public void onChanged(List<UserFitnessOutput> users) {
                rankAdapter = new RankAdapter(
                        context,
                        R.id.list_users,
                        users
                );
                lvUsers.setAdapter(rankAdapter);
            }
        });


    }
}