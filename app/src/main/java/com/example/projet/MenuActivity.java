package com.example.projet;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projet.activity.Resume_trainingActivity;

import repository.UserRepository;

public class MenuActivity extends AppCompatActivity {

    //declaration
    private float x1,x2,y1,y2;
    private Bitmap image;
    private String token =null;
    private UserRepository userRepository = new UserRepository();
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_menu);
        //init view
        textView = (TextView) findViewById(R.id.tv_point);

        //recuperer les points
        userRepository.getPointById().observe(this, new Observer<Double>() {
            @Override
            public void onChanged(Double points) {
                double d = (double) Math.round(points * 100) / 100;
                String pointUser = d+" Points";
                textView.setText(pointUser);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        //recuperer les points
        userRepository.getPointById().observe(this, new Observer<Double>() {
            @Override
            public void onChanged(Double points) {
                double d = (double) Math.round(points * 100) / 100;
                String pointUser = d+" Points";
                textView.setText(pointUser);
            }
        });

        //recuperer l'image et l'afficher
        ImageView imgPhoto = (ImageView)findViewById(R.id.imge_profil);
        token = getSharedPreferences("myapp",MODE_PRIVATE).getString("photoToken",null);
        if(token !=null){
            image = BitmapFactory.decodeFile(token);
            imgPhoto.setImageBitmap(image);
        }

    }

    /**
     *
     *====================================
     *       Changement de View
     *====================================
     */

    public boolean onTouchEvent(MotionEvent touchEvent){
        switch(touchEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = touchEvent.getX();
                y1 = touchEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchEvent.getX();
                y2 = touchEvent.getY();
                if(x1 <  x2){
                Intent i = new Intent(MenuActivity.this, GraphicalActivity.class);
                startActivity(i);
            }else if(x1 >  x2){
                Intent i = new Intent(MenuActivity.this, ProfileActivity.class);
                startActivity(i);
            }
            break;
        }
        return false;
    }
    public void goToChrono(View view) {
            Intent intent=new Intent(MenuActivity.this, ChronoActivity.class);
            startActivity(intent);
    }

    public void goToWebsite(View view) {
        Uri url = Uri.parse("https://www.helha.be");
                Intent intent = new Intent(Intent.ACTION_VIEW, url);

        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }

    public void goToAddActivity(View view) {
        Intent intent=new Intent(MenuActivity.this, AddSportActivity.class);
        startActivity(intent);
    }

    public void goToGraphics(View view) {
        Intent intent=new Intent(MenuActivity.this, GraphicalActivity.class);
        startActivity(intent);
    }

    public void goToTeam(View view) {
        Intent intent=new Intent(MenuActivity.this, ProfileActivity.class);
        startActivity(intent);
    }

    public void goToRank(View view) {
        Intent intent=new Intent(MenuActivity.this, RankActivity.class);
        startActivity(intent);
    }

    public void goToResumeActivity(View view) {
        Intent intent=new Intent(MenuActivity.this, Resume_trainingActivity.class);
        startActivity(intent);
    }

    public void goToActivity(View view) {
        Intent intent=new Intent(MenuActivity.this, ListSportActivity.class);

        startActivity(intent);
    }
}