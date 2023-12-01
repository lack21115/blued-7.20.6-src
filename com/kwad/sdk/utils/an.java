package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/an.class */
public final class an {
    private static volatile an aAe = new an();
    private volatile boolean aAf;
    private volatile long aAg = 0;
    private volatile PowerManager aAh;

    public static an DN() {
        return aAe;
    }

    public final boolean ci(Context context) {
        if (this.aAg <= 0 || SystemClock.elapsedRealtime() - this.aAg >= 600) {
            boolean z = false;
            if (this.aAh == null && context != null) {
                synchronized (this) {
                    if (this.aAh == null) {
                        this.aAh = (PowerManager) context.getApplicationContext().getSystemService(Context.POWER_SERVICE);
                    }
                }
            }
            if (this.aAh != null) {
                z = Build.VERSION.SDK_INT >= 20 ? this.aAh.isInteractive() : this.aAh.isScreenOn();
            }
            this.aAf = z;
            this.aAg = SystemClock.elapsedRealtime();
            return this.aAf;
        }
        return this.aAf;
    }
}
