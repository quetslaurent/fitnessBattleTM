package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;

import android.widget.ImageView;
import android.widget.TextView;

import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

import model.outputDataModel.UserFitnessOutput;
import viewModel.ProfileViewModel;


public class ProfileActivity extends AppCompatActivity {
    private SlidrInterface slidr;
    private Bitmap image;
    private String token =null;
    private ProfileViewModel profileViewModel;
    private TextView txt_mail,txt_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        //permet de revenir a la page precedente
        slidr = Slidr.attach(this);
        //initalise la view
        initView();


   profileViewModel.getUserlive().observe(this, new Observer<UserFitnessOutput>() {
       @Override
       public void onChanged(UserFitnessOutput userFitness) {
           txt_name.setText(userFitness.getName());
           txt_mail.setText(userFitness.getEmail());
       }
   });

    }


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

    public void goToCamera(View view) {
        Intent intent=new Intent(ProfileActivity.this, CameraActivity.class);
        startActivity(intent);
    }

    public void goToImc(View view) {
        Intent intent=new Intent(ProfileActivity.this, IMCActivity.class);
        startActivity(intent);
    }

    public void initView(){
        txt_mail = (TextView) findViewById(R.id.tv_mail);
        txt_name = (TextView) findViewById(R.id.txt_name);
        profileViewModel =  new ViewModelProvider(this).get(ProfileViewModel.class);
    }
}