package com.blued.android.module.live_china.manager;

import android.util.Log;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/LiveMakeLoverManager.class */
public class LiveMakeLoverManager {

    /* renamed from: a  reason: collision with root package name */
    private static int f13663a;

    public static int a() {
        return f13663a;
    }

    public static void a(int i) {
        f13663a = i;
        Log.i("==makelover", "setMode:" + i);
        if (f13663a == 1) {
            LiveRefreshUIObserver.a().c(true);
        } else {
            LiveRefreshUIObserver.a().c(false);
        }
    }

    public static boolean b() {
        return f13663a == 2;
    }
}
