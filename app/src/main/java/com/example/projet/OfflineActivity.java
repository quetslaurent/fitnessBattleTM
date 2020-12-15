package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class OfflineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offline);
    }


    /**
     *
     *====================================
     *       Changement de View
     *====================================
     */


    public void goToChrono(View view) {
        Intent intent=new Intent(OfflineActivity.this, ChronoActivity.class);
        startActivity(intent);
    }

    public void goToWebsite(View view) {
        Uri url = Uri.parse("https://www.helha.be");
        Intent intent = new Intent(Intent.ACTION_VIEW, url);

        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }


    public void goToRank(View view) {
        Intent intent=new Intent(OfflineActivity.this, RankActivity.class);
        startActivity(intent);
    }

    public void goToImc(View view) {
        Intent intent=new Intent(OfflineActivity.this, IMCActivity.class);
        startActivity(intent);
    }

}