package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import model.RankAdapter;
import model.outputDataModel.UserFitnessOutput;
import repository.UserRepository;

public class RankActivity extends AppCompatActivity {

    private List<UserFitnessOutput> userFitness = new ArrayList<>();
    private UserRepository userRepository = new UserRepository();
    private ListView lvUsers;
    private RankAdapter rankAdapter;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);
        lvUsers = findViewById(R.id.list_users);
        context = this;

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