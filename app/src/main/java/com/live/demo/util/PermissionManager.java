package com.live.demo.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.biz.util.DialogUtil;
import com.live.demo.R;

import static android.service.notification.Condition.SCHEME;

/**
 * Created by TingYu Zhu on 2017/10/30.
 */

public class PermissionManager {

    public static final int PERMISSION_CODE = 0X123;

    Activity context;

    public PermissionManager(Activity context){
        this.context = context;
    }

    public void requestPermissions(String... permissions){

        if(!checkPermissions(permissions)){
            createHintSetPermissionsDialog();
        }

    }

    private boolean checkPermissions(String... permissions) {
        for (String permission : permissions) {
            if(lacksPermission(permission)){
                return true;
            }
        }
        return false;
    }

    private boolean lacksPermission(String permission) {
        return ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_DENIED;
    }

    private void createHintSetPermissionsDialog(){
        DialogUtil.createDialogView(context,"请去设置相关权限，没有权限应用不能正常使用", (dialog, which) -> {
                    ActivityCompat.finishAffinity(context);
                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    intent.addCategory(Intent.CATEGORY_HOME);
                    context.startActivity(intent);
        }, R.string.btn_cancel
        ,(dialog, which) -> {
                    Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    Uri uri = Uri.fromParts(SCHEME, context.getPackageName(), null);
                    intent.setData(uri);
                    context.startActivityForResult(intent, PERMISSION_CODE);
                },R.string.string_set);
    }

}
