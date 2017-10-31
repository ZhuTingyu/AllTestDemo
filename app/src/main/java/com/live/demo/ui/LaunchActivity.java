package com.live.demo.ui;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;
import android.widget.Space;

import com.biz.base.BaseActivity;
import com.live.demo.util.PermissionManager;

/**
 * Created by TingYu Zhu on 2017/10/27.
 */

public class LaunchActivity extends BaseActivity {

    PermissionManager permissionManager;
    String[] permission = {Manifest.permission.CAMERA
            ,Manifest.permission.READ_EXTERNAL_STORAGE};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Space(getActivity()));
        permissionManager = new PermissionManager(this);



        permissionManager.requestPermissions(permission);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        permissionManager.requestPermissions(permission);
    }
}
