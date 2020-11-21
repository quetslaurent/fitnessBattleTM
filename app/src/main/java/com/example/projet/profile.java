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

import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

import java.util.List;

import model.UserFitness;
import repository.UserRepository;

public class profile extends AppCompatActivity {
    private SlidrInterface slidr;
    private Bitmap image;
    private String token =null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        //permet de revenir a la page precedente
        slidr = Slidr.attach(this);


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
        Intent intent=new Intent(profile.this,Camera.class);
        startActivity(intent);
    }

    public void goToImc(View view) {
        Intent intent=new Intent(profile.this,IMC.class);
        startActivity(intent);
    }
}