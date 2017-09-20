package com.live.demo.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.live.demo.adapter.MainListAdapter;
import com.live.demo.livecycle.LifecycleObserve;
import com.live.demo.livedata.LocationLiveData;
import com.live.demo.R;
import com.live.demo.viewmodel.StringListViewModel;


public class MainActivity extends AppCompatActivity {

    private LocationLiveData locationLiveData;
    private RecyclerView recyclerView;
    private MainListAdapter adapter;
    private StringListViewModel viewModel;

    @Override
    protected void onStart() {
        super.onStart();
        getLifecycle().addObserver(new LifecycleObserve());
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = ViewModelProviders.of(this).get(StringListViewModel.class);

        initView();

        viewModel.getLiveData().observe(this, locationEntities -> {
            adapter.setNewData(locationEntities);
        });

    }


    private void initView() {
        recyclerView = findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MainListAdapter(viewModel);
        recyclerView.setAdapter(adapter);
        locationLiveData = new LocationLiveData();

        findViewById(R.id.btn).setOnClickListener(view -> {
            viewModel.dateAdd();
            recyclerView.scrollToPosition(viewModel.getLiveData().getValue().size() - 1);
        });
    }
}
