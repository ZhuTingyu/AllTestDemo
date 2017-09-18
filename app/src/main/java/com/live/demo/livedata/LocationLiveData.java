package com.live.demo.livedata;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.ArrayList;


/**
 * Created by TingYu Zhu on 2017/9/15.
 */

public class LocationLiveData extends MutableLiveData<ArrayList<String>> {



    @Override
    protected void onActive() {
        super.onActive();
    }

    @Override
    protected void onInactive() {
        super.onInactive();
    }
}
