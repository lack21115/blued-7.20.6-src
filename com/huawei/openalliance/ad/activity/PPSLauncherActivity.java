package com.huawei.openalliance.ad.activity;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import com.bytedance.applog.tracker.Tracker;
import com.huawei.hms.ads.ge;
import com.huawei.openalliance.ad.constant.t;
import com.huawei.openalliance.ad.download.app.c;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/activity/PPSLauncherActivity.class */
public class PPSLauncherActivity extends Activity {
    public static final String Code = "69";
    private static final String V = "PPSLauncherActivity";

    private void Code() {
        c.Code(this, Code, (AdContentData) null, (RemoteCallResultCallback) null, (Class) null);
    }

    public boolean Code(Context context) {
        for (ActivityManager.RunningTaskInfo runningTaskInfo : ((ActivityManager) context.getSystemService("activity")).getRunningTasks(10)) {
            if (runningTaskInfo.topActivity.getClassName().equalsIgnoreCase(PPSLauncherActivity.class.getName()) && runningTaskInfo.numActivities < 2) {
                return false;
            }
            if (runningTaskInfo.topActivity.getPackageName().equals(context.getPackageName())) {
                return true;
            }
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Tracker.dispatchTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        StringBuilder sb;
        Intent launchIntentForPackage;
        try {
            super.onCreate(bundle);
            if (Code(this)) {
                ge.V(V, "app is active.");
                launchIntentForPackage = new Intent();
                launchIntentForPackage.setComponent(new ComponentName(getPackageName(), PPSBridgeActivity.class.getName()));
                launchIntentForPackage.setFlags(268435456);
                launchIntentForPackage.setClipData(t.cF);
            } else {
                ge.V(V, " app is not active. start launch app");
                launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
                launchIntentForPackage.setClipData(t.cF);
            }
            startActivity(launchIntentForPackage);
            Code();
            try {
                finish();
            } catch (Throwable th) {
                th = th;
                sb = new StringBuilder();
                sb.append("finish activity error:");
                sb.append(th.getClass().getName());
                ge.V(V, sb.toString());
            }
        } catch (Throwable th2) {
            try {
                ge.V(V, "intent is not supported:" + th2.getClass().getName());
                try {
                    finish();
                } catch (Throwable th3) {
                    th = th3;
                    sb = new StringBuilder();
                    sb.append("finish activity error:");
                    sb.append(th.getClass().getName());
                    ge.V(V, sb.toString());
                }
            } catch (Throwable th4) {
                try {
                    finish();
                } catch (Throwable th5) {
                    ge.V(V, "finish activity error:" + th5.getClass().getName());
                }
                throw th4;
            }
        }
    }
}
