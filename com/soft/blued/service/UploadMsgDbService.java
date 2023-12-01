package com.soft.blued.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.soft.blued.utils.Logger;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/service/UploadMsgDbService.class */
public class UploadMsgDbService extends Service {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        String stringExtra = intent.getStringExtra("FILE_PATH");
        String simpleName = UploadMsgDbService.class.getSimpleName();
        Logger.c(simpleName, "备份消息成功====" + stringExtra);
        if (!TextUtils.isEmpty(stringExtra)) {
            ToastUtils.a("备份成功");
        }
        return super.onStartCommand(intent, i, i2);
    }
}
