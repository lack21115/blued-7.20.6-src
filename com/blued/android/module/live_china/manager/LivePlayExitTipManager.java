package com.blued.android.module.live_china.manager;

import android.os.Handler;
import com.blued.android.core.AppInfo;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/LivePlayExitTipManager.class */
public class LivePlayExitTipManager {

    /* renamed from: a  reason: collision with root package name */
    private boolean f13667a = false;
    private Handler b = new Handler();

    /* renamed from: c  reason: collision with root package name */
    private ExitTipTask f13668c = new ExitTipTask();

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/LivePlayExitTipManager$ExitTipTask.class */
    class ExitTipTask implements Runnable {
        ExitTipTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LivePlayExitTipManager.this.f13667a = true;
        }
    }

    public void a() {
        this.f13667a = false;
        AppInfo.n().removeCallbacks(this.f13668c);
    }

    public void b() {
        this.b.postDelayed(this.f13668c, 180000L);
    }

    public void c() {
        this.b.removeCallbacksAndMessages(null);
    }
}
