package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    private Bitmap image;
    private String token =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
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


    public void goToMenu(View view) {
        Intent intent=new Intent(MainActivity.this,Menu.class);
        startActivity(intent);
    }

    public void goToRegister(View view) {
            Intent intent=new Intent(MainActivity.this,Register.class);
            startActivity(intent);
    }



}