package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import model.inputDataModel.UserFitnessInput;
import repository.UserRepository;

public class EditMailActivity extends AppCompatActivity {

    private UserRepository userRepository = new UserRepository();
    UserFitnessInput u1 = new UserFitnessInput("test","helha","helha@gmail",false);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_mail);
    }

    //update l'adresse mail + renvoies dans profile
   /* public void updateMail(View view) {
        userRepository.update(5,u1).observe(this, new Observer<UserFitnessInput>() {
            @Override
            public void onChanged(UserFitnessInput userFitnessInput) {

            }
        });

        Intent intent=new Intent(EditMailActivity.this, ProfileActivity.class);
        startActivity(intent);
    }  */
}
