
package com.live.demo.livedata;


import android.arch.lifecycle.MutableLiveData;

import com.live.demo.adapter.MainListAdapter;

import java.util.ArrayList;



/**
 * Created by TingYu Zhu on 2017/9/15.
 */


public class LocationLiveData extends MutableLiveData<ArrayList<String>> {


    public LocationLiveData() {
    }


    /**
     * LiveData的观察者数量从0到1
     */

    @Override
    protected void onActive() {
        super.onActive();

    }

     /**
     * LiveData的观察者数量变为0
     */

    @Override
    protected void onInactive() {
        super.onInactive();
    }
}

