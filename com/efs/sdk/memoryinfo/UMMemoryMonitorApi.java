package com.efs.sdk.memoryinfo;

import android.app.Activity;
import android.content.Context;
import com.efs.sdk.base.EfsReporter;

/* loaded from: source-8110460-dex2jar.jar:com/efs/sdk/memoryinfo/UMMemoryMonitorApi.class */
public interface UMMemoryMonitorApi {
    String getCurrentActivity();

    boolean isEnable();

    boolean isForeground();

    void onActivityResumed(Activity activity);

    void onActivityStarted(Activity activity);

    void onActivityStopped(Activity activity);

    void setEnable(boolean z);

    void start(Context context, EfsReporter efsReporter);
}
