package com.tencent.tinker.entry;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/entry/DefaultApplicationLike.class */
public class DefaultApplicationLike extends ApplicationLike {
    private static final String TAG = "Tinker.DefaultAppLike";

    public DefaultApplicationLike(Application application, int i, boolean z, long j, long j2, Intent intent) {
        super(application, i, z, j, j2, intent);
    }

    @Override // com.tencent.tinker.entry.ApplicationLike, com.tencent.tinker.entry.ApplicationLifeCycle
    public void onBaseContextAttached(Context context) {
        ShareTinkerLog.d(TAG, "onBaseContextAttached:", new Object[0]);
    }

    @Override // com.tencent.tinker.entry.ApplicationLike, com.tencent.tinker.entry.ApplicationLifeCycle
    public void onConfigurationChanged(Configuration configuration) {
        ShareTinkerLog.d(TAG, "onConfigurationChanged:" + configuration.toString(), new Object[0]);
    }

    @Override // com.tencent.tinker.entry.ApplicationLike, com.tencent.tinker.entry.ApplicationLifeCycle
    public void onCreate() {
        ShareTinkerLog.d(TAG, "onCreate", new Object[0]);
    }

    @Override // com.tencent.tinker.entry.ApplicationLike, com.tencent.tinker.entry.ApplicationLifeCycle
    public void onLowMemory() {
        ShareTinkerLog.d(TAG, "onLowMemory", new Object[0]);
    }

    @Override // com.tencent.tinker.entry.ApplicationLike, com.tencent.tinker.entry.ApplicationLifeCycle
    public void onTerminate() {
        ShareTinkerLog.d(TAG, "onTerminate", new Object[0]);
    }

    @Override // com.tencent.tinker.entry.ApplicationLike, com.tencent.tinker.entry.ApplicationLifeCycle
    public void onTrimMemory(int i) {
        ShareTinkerLog.d(TAG, "onTrimMemory level:" + i, new Object[0]);
    }
}
