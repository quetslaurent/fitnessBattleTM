package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Intent;

import android.os.Bundle;


import android.util.Log;
import android.view.View;
import android.view.Window;
import model.inputDataModel.UserFitnessInput;
import okhttp3.ResponseBody;
import repository.UserRepository;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);


        UserRepository  userRepository = new UserRepository();
        UserFitnessInput u = new UserFitnessInput("admin","admin","admin@gmail.com",true);
        userRepository.login(u).observe(this, new Observer<ResponseBody>() {
            @Override
            public void onChanged(ResponseBody response) {
                Log.i("ccc",response.toString());
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