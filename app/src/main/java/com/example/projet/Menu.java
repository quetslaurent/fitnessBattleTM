package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;

import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

public class Menu extends AppCompatActivity {

float x1,x2,y1,y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_menu);
    }
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
                Intent i = new Intent(Menu.this, Graphical.class);
                startActivity(i);
            }else if(x1 >  x2){
                Intent i = new Intent(Menu.this, Team.class);
                startActivity(i);
            }
            break;
        }
        return false;
    }
    public void goToChrono(View view) {
            Intent intent=new Intent(Menu.this,Chrono.class);
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
        Intent intent=new Intent(Menu.this,AddActivity.class);
        startActivity(intent);
    }
}