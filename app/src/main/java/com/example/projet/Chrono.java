package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;


import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;

import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

import viewModel.ChronoModel;

public class Chrono extends AppCompatActivity {
    Chronometer chronometer;
    ImageButton btnStart,btnStop;
    private Handler handler;
    private boolean isResume;
    private SlidrInterface slidr;
    private ChronoModel  chronoModel ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chrono);
        slidr = Slidr.attach(this);
        initView();
        chronoModel = new ViewModelProvider(this).get(ChronoModel.class);
        //chronometer.setText(String.format("%02d",chronoModel.getMin())+":"+String.format("%02d",chronoModel.getSec())+":"+String.format("%02d",chronoModel.getMilliSec()));
        handler = chronoModel.getHandler();

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isResume) {
                  chronoModel.start();
                    handler.postDelayed(runnable, 0);
                    chronometer.start();
                    isResume = true;
                    btnStop.setVisibility(View.GONE);
                   btnStart.setImageDrawable(getResources().getDrawable(
                            R.drawable.ic_baseline_pause_24
                    ));
                } else {
                   chronoModel.addtime();
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


        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isResume) {
                    btnStart.setImageDrawable(getResources().getDrawable(
                            R.drawable.ic_baseline_play_arrow_24
                    ));
                    chronoModel.stop();
                    chronometer.setText("00:00:00");
                }
            }
        });
    }
    public Runnable runnable = new Runnable() {
        @Override
        public void run() {
           chronoModel.run();
             chronometer.setText(String.format("%02d",chronoModel.getMin())+":"+String.format("%02d",chronoModel.getSec())+":"+String.format("%02d",chronoModel.getMilliSec()));
             handler.postDelayed(this,60);
        }
    };

    public void initView(){
        chronometer = findViewById(R.id.chronometer);
        btnStart = findViewById(R.id.btn_start);
        btnStop = findViewById(R.id.btn_stop);
    }
}