package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;


import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageButton;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

import util.SlideR;
import viewModel.ChronoViewModel;
public class ChronoActivity extends AppCompatActivity {

    //declaration
    Chronometer chronometer;
    ImageButton btnStart,btnStop;
    private Handler handler;
    private boolean isResume;
    private ChronoViewModel chronoViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chrono);
        //utilisation du slide
        SlideR.swapBack(this);
        //initialiser la view
        initView();
        //utilisation du ViewModel
        chronoViewModel = new ViewModelProvider(this).get(ChronoViewModel.class);
        handler = chronoViewModel.getHandler();

        //start le chrono quand on appuie sur le bouton start
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isResume) {
                  chronoViewModel.start();
                    handler.postDelayed(runnable, 0);
                    chronometer.start();
                    isResume = true;
                    btnStop.setVisibility(View.GONE);
                   btnStart.setImageDrawable(getResources().getDrawable(
                            R.drawable.ic_baseline_pause_24
                    ));
                } else {
                   chronoViewModel.addtime();
                    handler.removeCallbacks(runnable);
                    chronometer.stop();
                    isResume = false;
                    btnStop.setVisibility(View.VISIBLE);
                    btnStart.setImageDrawable(getResources().getDrawable(
                            R.drawable.ic_baseline_play_arrow_24
                    ));
                }
            }
        });

//stop le chrono quand on appuie sur le bouton stop
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isResume) {
                    btnStart.setImageDrawable(getResources().getDrawable(
                            R.drawable.ic_baseline_play_arrow_24
                    ));
                    chronoViewModel.stop();
                    chronometer.setText("00:00:00");
                }
            }
        });
    }
    //affiche le temps du chrono
    public Runnable runnable = new Runnable() {
        @Override
        public void run() {
           chronoViewModel.run();
             chronometer.setText(String.format("%02d", chronoViewModel.getMin())+":"+String.format("%02d", chronoViewModel.getSec())+":"+String.format("%02d", chronoViewModel.getMilliSec()));
             handler.postDelayed(this,60);
        }
    };


    /**
     *
     *====================================
     *       Init the view
     *====================================
     */

    public void initView(){
        chronometer = findViewById(R.id.chronometer);
        btnStart = findViewById(R.id.btn_start);
        btnStop = findViewById(R.id.btn_stop);
    }

}