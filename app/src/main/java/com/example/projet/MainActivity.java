package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import java.util.List;

import model.UserFitness;
import repository.UserRepository;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        //creation du UserRepository

        UserRepository userRepository = new UserRepository();
        /**
         * life cycle owner -> this , notre classe
         * new observer , le flux d'info
         */
        userRepository.query().observe(this, new Observer<List<UserFitness>>() {
            @Override
            public void onChanged(List<UserFitness> users) {
                Log.i("UserSql", users.toString());
            }
        }); //renvoie un flux d'info ( liveData)

        userRepository.create(new UserFitness(0,"nico","helha","nicolasBoulette@gmail.com",false)).observe(this, new Observer<UserFitness>() {
            @Override
            public void onChanged(UserFitness userFitness) {
                Log.i("Todo", userFitness.toString());
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

    }


    public void goToMenu(View view) {
        Intent intent=new Intent(MainActivity.this,Menu.class);
        startActivity(intent);
    }

    public void goToRegister(View view) {
            Intent intent=new Intent(MainActivity.this,Register.class);
            startActivity(intent);
    }



}