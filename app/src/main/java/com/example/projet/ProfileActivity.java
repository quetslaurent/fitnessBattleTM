package com.example.projet;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

import model.inputDataModel.UserFitnessInput;
import model.outputDataModel.UserFitnessOutput;
import model.outputDataModel.UserFitnessOutputToken;
import repository.TokenRepository;
import repository.UserRepository;
import util.SlideR;
import viewModel.ProfileViewModel;


public class ProfileActivity extends AppCompatActivity {

    //declaration
    private Bitmap image;
    private String token =null;
    private ProfileViewModel profileViewModel;
    private TextView tv_mail, tv_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        //permet de revenir a la page precedente
        SlideR.swapBack(this);
        //initalise la view
        initView();

        //set les valeurs de l'utilisateurs connectés
            profileViewModel.getUserToken().observe(this, new Observer<UserFitnessOutputToken>() {
                @Override
                public void onChanged(UserFitnessOutputToken s) {
                    tv_name.setText(s.getName());
                    tv_mail.setText(s.getEmail());
                }
            });
    }

    //recupere l'image stocké dans un token et l'affiche
    @Override
    protected void onResume() {
        super.onResume();
        ImageView imgPhoto = (ImageView)findViewById(R.id.imge_profil);
        token = getSharedPreferences("myapp",MODE_PRIVATE).getString("photoToken",null);
        if(token !=null){
            image = BitmapFactory.decodeFile(token);
            imgPhoto.setImageBitmap(image);
        }
    }

    //initialiser les views
    public void initView(){
        tv_mail = (TextView) findViewById(R.id.tv_mail);
        tv_name = (TextView) findViewById(R.id.tv_name);
        profileViewModel =  new ViewModelProvider(this).get(ProfileViewModel.class);
    }


    /**
     *
     *====================================
     *       Changement de View
     *====================================
     */


    //Permet de supprimer un compte à l'aide de son id
    public void deleteAccount(View view) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Do you want to delete your account ? ");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();

                        profileViewModel.deleteUser().observe(ProfileActivity.this, new Observer<String>() {
                            @Override
                            public void onChanged(String s) {
                                Toast.makeText(getApplicationContext(),"Suppression du compte",Toast.LENGTH_LONG).show();
                            }
                        });

                        Intent intent=new Intent(ProfileActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                });

        builder1.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();


    }

    //nous renvoies dans camera pour modifier sa photo de profil
    public void goToCamera(View view) {
        Intent intent=new Intent(ProfileActivity.this, CameraActivity.class);
        startActivity(intent);
    }

    //nous renvoies dans le layout imc pour calculer l'imc
    public void goToImc(View view) {
        Intent intent=new Intent(ProfileActivity.this, IMCActivity.class);
        startActivity(intent);
    }

    public void goToLogin(View view) {
        Intent intent=new Intent(ProfileActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}