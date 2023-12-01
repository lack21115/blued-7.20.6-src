package com.efs.sdk.memoryinfo;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.os.Process;
import com.cdo.oaps.ad.OapsKey;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8110460-dex2jar.jar:com/efs/sdk/memoryinfo/c.class */
public final class c {
    final String activity;
    final String bg;
    final long n;
    final long o;
    final long p;
    final long q;
    final float r;
    final long s;
    final long t;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        Debug.MemoryInfo memoryInfo;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            memoryInfo = null;
            if (activityManager != null) {
                Debug.MemoryInfo[] processMemoryInfo = activityManager.getProcessMemoryInfo(new int[]{Process.myPid()});
                memoryInfo = null;
                if (processMemoryInfo != null) {
                    memoryInfo = null;
                    if (processMemoryInfo.length > 0) {
                        memoryInfo = processMemoryInfo[0];
                    }
                }
            }
        } catch (Throwable th) {
            memoryInfo = null;
        }
        Debug.MemoryInfo memoryInfo2 = memoryInfo;
        if (memoryInfo == null) {
            memoryInfo2 = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo2);
        }
        this.bg = UMMemoryMonitor.get().isForeground() ? "fg" : OapsKey.KEY_BG;
        this.n = memoryInfo2.getTotalPss() * 1024;
        this.o = memoryInfo2.dalvikPss * 1024;
        this.p = memoryInfo2.nativePss * 1024;
        this.s = f.a(memoryInfo2) * 1024;
        this.q = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long maxMemory = Runtime.getRuntime().maxMemory();
        if (maxMemory != 0) {
            this.r = (((float) this.q) * 1.0f) / ((float) maxMemory);
        } else {
            this.r = 1.0f;
        }
        this.t = f.a() * 1024;
        this.activity = UMMemoryMonitor.get().getCurrentActivity();
    }
}
