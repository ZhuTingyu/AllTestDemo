package com.live.demo.util;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by TingYu Zhu on 2017/10/31.
 */

public class ScheduledExecutorServiceUtil {

    public static void rotatingTraining(Runnable runnable){
        ScheduledExecutorService scheduledExecutorService  = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(runnable,0,2, TimeUnit.SECONDS);
    }

}


