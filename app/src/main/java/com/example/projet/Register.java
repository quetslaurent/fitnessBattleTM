package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Register extends AppCompatActivity {
Bitmap s ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
      ImageView   imgPhoto = (ImageView)findViewById(R.id.photolol);
        String token = getIntent().getStringExtra("EXTRA_CAMERA_IMAGE");

    //imgPhoto.setImageBitmap(token);
    }

    public void goToCamera(View view) {
        Intent intent=new Intent(Register.this,Camera.class);
        startActivity(intent);
    }

    }
