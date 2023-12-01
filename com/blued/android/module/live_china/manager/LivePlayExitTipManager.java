package com.blued.android.module.live_china.manager;

import android.os.Handler;
import com.blued.android.core.AppInfo;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/LivePlayExitTipManager.class */
public class LivePlayExitTipManager {
    private boolean a = false;
    private Handler b = new Handler();
    private ExitTipTask c = new ExitTipTask();

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/LivePlayExitTipManager$ExitTipTask.class */
    class ExitTipTask implements Runnable {
        ExitTipTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LivePlayExitTipManager.this.a = true;
        }
    }

    public void a() {
        this.a = false;
        AppInfo.n().removeCallbacks(this.c);
    }

    public void b() {
        this.b.postDelayed(this.c, 180000L);
    }

    public void c() {
        this.b.removeCallbacksAndMessages(null);
    }
}
