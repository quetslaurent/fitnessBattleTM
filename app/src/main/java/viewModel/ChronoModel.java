package viewModel;

import android.os.Handler;
import android.os.SystemClock;
import android.widget.Chronometer;

import androidx.lifecycle.ViewModel;

public class ChronoModel extends ViewModel {

    private long tMilliSecond,tStart,tBuff,tUpdate=0L;
    private int sec,min,milliSec;
    private Chronometer chronometer;
    private Handler handler;
    public void stop(){
        tMilliSecond = 0L;
        tStart = 0L;
        tBuff = 0L;
        tUpdate = 0L;
        sec = 0;
        min = 0;
        milliSec = 0;
        chronometer.setText("00:00:00");
    }
    public void start(){
        tStart = SystemClock.uptimeMillis();
        handler.postDelayed(runnable, 0);
        chronometer.start();
    }

    public void addtime(){
        tBuff += tMilliSecond;
        handler.removeCallbacks(runnable);
        chronometer.stop();
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

}
