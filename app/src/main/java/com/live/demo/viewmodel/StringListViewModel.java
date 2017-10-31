
package com.live.demo.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;

import com.biz.base.BaseViewModel;
import com.live.demo.livedata.LocationLiveData;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by TingYu Zhu on 2017/9/19.
 */


public class StringListViewModel extends ViewModel{

    public  MutableLiveData<List<String>> liveData;
    List<String> data;
    public LiveData<List<String>> mapLiveData = Transformations.switchMap(liveData, input -> {
        MutableLiveData<List<String>> temp = new MutableLiveData<>();
        ArrayList<String> strings = new ArrayList<>();
        for(String s : input){
                strings.add(s + ":"+ s);
        }
        temp.setValue(strings);
        return temp;
    });


    public LiveData<List<String>> getLiveData(){
        if(liveData == null){
            liveData = new MutableLiveData();
            loadData();

        }
        return liveData;
    }

    public LiveData<List<String>> getStingLiveData(){
        if(liveData == null){
            liveData = new MutableLiveData();
            loadData();

        }
        return liveData;
    }

    private void loadData() {
        data = new ArrayList<>();
        for(int i = 0; i < 7; i++){
            data.add(String.valueOf(i));
        }
    }

    public void dateAdd(){
        data.add(String.valueOf(1));
        liveData.setValue(data);
    }
}

