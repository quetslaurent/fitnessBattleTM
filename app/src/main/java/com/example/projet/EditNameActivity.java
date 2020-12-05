package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import model.inputDataModel.UserFitnessInput;
import repository.UserRepository;

public class EditNameActivity extends AppCompatActivity {

    private UserRepository userRepository = new UserRepository();

    UserFitnessInput u1 = new UserFitnessInput("test","helha","helha@gmail",false);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
    }


   /* public void updateUsername(View view) {

        userRepository.update(5,u1).observe(this, new Observer<UserFitnessInput>() {
            @Override
            public void onChanged(UserFitnessInput userFitnessInput) {

            }
        });

        Intent intent=new Intent(EditNameActivity.this, ProfileActivity.class);
        startActivity(intent);
    } */
}