package model;

import android.os.SystemClock;

public class Chrono {

    private long tMilliSecond, tStart, tBuff, tUpdate = 0L;
    private int sec, min, milliSec;


    public void start(){
        tStart = SystemClock.uptimeMillis();
    }

    public void stop() {
        tMilliSecond = 0L;
        tStart = 0L;
        tBuff = 0L;
        tUpdate = 0L;
        sec = 0;
        min = 0;
        milliSec = 0;
    }

    public void addtime() {
        tBuff += tMilliSecond;
    }

    public void run() {
        tMilliSecond = SystemClock.uptimeMillis() - tStart;
        tUpdate = tBuff + tMilliSecond;
        sec = (int) (tUpdate / 1000);
        min = sec / 60;
        sec = sec % 100;
        milliSec = (int) (tUpdate % 60);
    }

    public long gettMilliSecond() {
        return tMilliSecond;
    }

    public void settMilliSecond(long tMilliSecond) {
        this.tMilliSecond = tMilliSecond;
    }

    public long gettStart() {
        return tStart;
    }

    public void settStart(long tStart) {
        this.tStart = tStart;
    }

    public long gettBuff() {
        return tBuff;
    }

    public void settBuff(long tBuff) {
        this.tBuff = tBuff;
    }

    public long gettUpdate() {
        return tUpdate;
    }

    public void settUpdate(long tUpdate) {
        this.tUpdate = tUpdate;
    }

    public int getSec() {
        return sec;
    }

    public void setSec(int sec) {
        this.sec = sec;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMilliSec() {
        return milliSec;
    }

    public void setMilliSec(int milliSec) {
        this.milliSec = milliSec;
    }
}
