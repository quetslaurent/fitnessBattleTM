package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.ImageView;
import android.widget.TextView;

import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

import model.inputDataModel.UserFitnessInput;
import model.outputDataModel.UserFitnessOutput;
import repository.UserRepository;
import viewModel.ProfileViewModel;


public class ProfileActivity extends AppCompatActivity {
    private SlidrInterface slidr;
    private Bitmap image;
    private String token =null;
    private ProfileViewModel profileViewModel;
    private TextView tv_mail, txt_name, tv_name;
    private UserRepository userRepository = new UserRepository();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        //permet de revenir a la page precedente
        slidr = Slidr.attach(this);
        //initalise la view
        initView();

        /*
        userRepository.getById(id).observe(this, new Observer<UserFitnessOutput>() {
            @Override
            public void onChanged(UserFitnessOutput userFitnessOutput) {
                Log.i("user",userFitnessOutput.toString());
                String name = userFitnessOutput.getName();
                String email = userFitnessOutput.getEmail();
                txt_name.setText(name);
                tv_mail.setText(email);
            }
        });*/

        //set les valeurs de l'utilisateurs connectés
   profileViewModel.getUserlive().observe(this, new Observer<UserFitnessOutput>() {
       @Override
       public void onChanged(UserFitnessOutput userFitness) {
           tv_name.setText(userFitness.getName());
           txt_name.setText(userFitness.getName());
           tv_mail.setText(userFitness.getEmail());
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

    //initialiser les views
    public void initView(){
        tv_mail = (TextView) findViewById(R.id.tv_mail);
        tv_name = (TextView) findViewById(R.id.tv_name);
        txt_name = (TextView) findViewById(R.id.txt_name);
        profileViewModel =  new ViewModelProvider(this).get(ProfileViewModel.class);
    }

    //Nous renvoies dans le layout editName pour modifier son name
    public void goToEditName(View view) {
        Intent intent=new Intent(ProfileActivity.this, EditNameActivity.class);
        startActivity(intent);
    }

    //Nous renvoies dans le layout editMail pour modifier son adresse mail
    public void goToEditMail(View view) {
        Intent intent=new Intent(ProfileActivity.this, EditMailActivity.class);
        startActivity(intent);
    }

    //Permet de supprimer un compte à l'aide de son id
    public void deleteAccount(View view) {

        //MODIFIER LE 5 AVEC LE ID DE L'UTILISATEUR QUI SE CONNECTE
       /* userRepository.deleteUser(5).observe(this, new Observer<UserFitnessInput>() {
            @Override
            public void onChanged(UserFitnessInput userFitnessInput) {

            }
        }); */


        Intent intent=new Intent(ProfileActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}