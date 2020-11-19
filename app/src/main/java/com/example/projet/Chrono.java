package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;

import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

public class Chrono extends AppCompatActivity {
    Chronometer chronometer;
    ImageButton btnStart,btnStop;

    private boolean isResume;
    private Handler handler;
    private long tMilliSecond,tStart,tBuff,tUpdate=0L;
    private int sec,min,milliSec;

    private SlidrInterface slidr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chrono);
        slidr = Slidr.attach(this);
        initView();

        handler = new Handler();
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isResume) {
                    tStart = SystemClock.uptimeMillis();
                    handler.postDelayed(runnable, 0);
                    chronometer.start();
                    isResume = true;
                    btnStop.setVisibility(View.GONE);
                   btnStart.setImageDrawable(getResources().getDrawable(
                            R.drawable.ic_baseline_pause_24
                    ));
                } else {
                    tBuff += tMilliSecond;
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
                    tMilliSecond = 0L;
                    tStart = 0L;
                    tBuff = 0L;
                    tUpdate = 0L;
                    sec = 0;
                    min = 0;
                    milliSec = 0;
                    chronometer.setText("00:00:00");
                }
            }
        });
    }
    public Runnable runnable = new Runnable() {
        @Override
        public void run() {
            tMilliSecond = SystemClock.uptimeMillis()-tStart;
            tUpdate = tBuff + tMilliSecond;
            sec = (int) (tUpdate/1000);
            min=sec/60;
            sec=sec%60;
            milliSec=(int)(tUpdate%100);
             chronometer.setText(String.format("%02d",min)+":"+String.format("%02d",sec)+":"+String.format("%02d",milliSec));
             handler.postDelayed(this,60);
        }
    };

    public void initView(){
        chronometer = findViewById(R.id.chronometer);
        btnStart = findViewById(R.id.btn_start);
        btnStop = findViewById(R.id.btn_stop);
    }
}