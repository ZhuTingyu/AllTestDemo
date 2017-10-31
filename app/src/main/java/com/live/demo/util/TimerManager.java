package com.live.demo.util;


import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by TingYu Zhu on 2017/10/31.
 */

public class TimerManager {

    Timer timer;
    TimerTask timerTask;

    public TimerManager(TimerTask timerTask){
        this.timerTask = timerTask;
        timer = new Timer();
    }


    public TimerManager start(){
        timer.schedule(timerTask,1000,2000);
        return this;
    }

    public void cancel(){
        timer.cancel();
    }

    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            return false;
        }
    });

}


