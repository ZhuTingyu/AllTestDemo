package com.live.demo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.biz.base.BaseActivity;
import com.biz.widget.recyclerview.XRecyclerView;
import com.live.demo.R;
import com.live.demo.adapter.VideoListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TingYu Zhu on 2017/11/11.
 */

public class VideoActivity extends BaseActivity {

    XRecyclerView recyclerView;
    VideoListAdapter adapter;

    String[] videoAddress = {"http://www.jmzsjy.com/UploadFile/微课/地方风味小吃——宫廷香酥牛肉饼.mp4"
            ,"http://flashmedia.eastday.com/newdate/news/2016-11/shznews1125-19.mp4"
            ,"http://118.123.244.89:818/uploadfiles/GYTRace/4583554_153e03bfe62fc03e1ec129f12be95123.mp4"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        adapter = new VideoListAdapter();
        initView();
        bindData();
    }

    private void bindData() {

        List<String> data = new ArrayList<>();

        for (int i = 0; i < videoAddress.length; i++) {
            data.add(videoAddress[i]);
        }
        adapter.setNewData(data);
    }

    private void initView() {
        recyclerView = findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
