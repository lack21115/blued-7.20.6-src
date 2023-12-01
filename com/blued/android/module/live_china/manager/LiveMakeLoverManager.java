package com.blued.android.module.live_china.manager;

import android.util.Log;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/LiveMakeLoverManager.class */
public class LiveMakeLoverManager {
    private static int a;

    public static int a() {
        return a;
    }

    public static void a(int i) {
        a = i;
        Log.i("==makelover", "setMode:" + i);
        if (a == 1) {
            LiveRefreshUIObserver.a().c(true);
        } else {
            LiveRefreshUIObserver.a().c(false);
        }
    }

    public static boolean b() {
        return a == 2;
    }
}
