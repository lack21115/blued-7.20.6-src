package com.zego.zegoavkit2.appconfiguremonitor;

import android.app.ActivityManager;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.Looper;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/appconfiguremonitor/AppConfigureMonitorActivity.class */
class AppConfigureMonitorActivity {
    private DisplayManager.DisplayListener display_listener_;
    private Context mContext;
    private long mThis;
    private int task_delay_internal_ = 100;
    private Handler mUIHandler = new Handler(Looper.getMainLooper());

    static native void onAppOrientationChanged(long j, int i);

    public void StartDisplayListener() {
        this.display_listener_ = new DisplayManager.DisplayListener() { // from class: com.zego.zegoavkit2.appconfiguremonitor.AppConfigureMonitorActivity.1
            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayAdded(int i) {
            }

            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayChanged(int i) {
                AppConfigureMonitorActivity.this.mUIHandler.postDelayed(new Runnable() { // from class: com.zego.zegoavkit2.appconfiguremonitor.AppConfigureMonitorActivity.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AppConfigureMonitorActivity.this.UpdateOrientationManual();
                    }
                }, AppConfigureMonitorActivity.this.task_delay_internal_);
            }

            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayRemoved(int i) {
            }
        };
        ((DisplayManager) this.mContext.getSystemService("display")).registerDisplayListener(this.display_listener_, this.mUIHandler);
    }

    public void StopDisplayListener() {
        ((DisplayManager) this.mContext.getSystemService("display")).unregisterDisplayListener(this.display_listener_);
        this.display_listener_ = null;
    }

    public void UpdateOrientationManual() {
        synchronized (this) {
            if (this.mContext != null) {
                ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                ActivityManager activityManager = (ActivityManager) this.mContext.getSystemService("activity");
                ActivityManager.getMyMemoryState(runningAppProcessInfo);
                if (runningAppProcessInfo.importance == 100 || runningAppProcessInfo.importance == 200) {
                    onAppOrientationChanged(this.mThis, ((DisplayManager) this.mContext.getSystemService("display")).getDisplay(0).getRotation());
                }
            }
        }
    }

    public int init(Context context) {
        synchronized (this) {
            this.mContext = context;
            if (context == null) {
                return -1;
            }
            StartDisplayListener();
            return 0;
        }
    }

    public void setThis(long j) {
        this.mThis = j;
    }

    public int uninit() {
        synchronized (this) {
            if (this.mContext == null) {
                return -1;
            }
            StopDisplayListener();
            this.mContext = null;
            return 0;
        }
    }
}
