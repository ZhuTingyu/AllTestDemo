package com.live.demo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.live.demo.livecycle.LifecycleObserve;
import com.live.demo.livedata.LocationLiveData;
import com.live.demo.R;

public class MainActivity extends AppCompatActivity {

    private LocationLiveData locationLiveData;

    @Override
    protected void onStart() {
        super.onStart();
        getLifecycle().addObserver(new LifecycleObserve());
        locationLiveData.observe(this, locationEntities -> {
            //updateUi
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
