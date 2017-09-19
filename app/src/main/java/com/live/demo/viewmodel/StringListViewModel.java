package com.live.demo.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.live.demo.livedata.LocationLiveData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TingYu Zhu on 2017/9/19.
 */

public class StringListViewModel extends ViewModel{

    private  MutableLiveData<List<String>> liveData;
    List<String> data;

    public LiveData<List<String>> getLiveData(){
        if(liveData == null){
            liveData = new MutableLiveData();
            loadData();
        }
        return liveData;
    }

    private void loadData() {
        data = new ArrayList<>();
        for(int i = 0; i < 7; i++){
            data.add(i+"");
        }
        liveData.setValue(data);
    }

    public void dateAdd(){
        data.add("32");
        liveData.setValue(data);
    }
}
