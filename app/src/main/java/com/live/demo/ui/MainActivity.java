package com.live.demo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.live.demo.adapter.MainListAdapter;
import com.live.demo.livecycle.LifecycleObserve;
import com.live.demo.livedata.LocationLiveData;
import com.live.demo.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private LocationLiveData locationLiveData;
    private RecyclerView recyclerView;
    private MainListAdapter adapter;
    private ArrayList<String> data;

    @Override
    protected void onStart() {
        super.onStart();
        getLifecycle().addObserver(new LifecycleObserve());

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();

        locationLiveData.observe(this, locationEntities -> {
            adapter.setNewData(locationEntities);
        });

    }

    private void initData() {
        data = new ArrayList<>();
        for(int i = 0; i < 7; i++){
            data.add(i+"");
        }
    }

    private void initView() {
        recyclerView = findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MainListAdapter();
        recyclerView.setAdapter(adapter);
        locationLiveData = new LocationLiveData(adapter);
        locationLiveData.setValue(data);

        findViewById(R.id.btn).setOnClickListener(view -> {
            data.add("32");
            locationLiveData.setValue(data);
        });
    }
}
