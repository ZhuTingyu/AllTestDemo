package com.live.demo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Space;

import com.biz.base.BaseActivity;

/**
 * Created by TingYu Zhu on 2017/10/27.
 */

public class LaunchActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(new Space(getActivity()));
    }


}
