package com.ut.mini.core.appstatus;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import com.alibaba.mtl.log.c;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/ut/mini/core/appstatus/UTMCAppBackgroundTimeoutDetector.class */
public class UTMCAppBackgroundTimeoutDetector implements UTMCAppStatusCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private static UTMCAppBackgroundTimeoutDetector f27331a;
    private long B = 0;

    private UTMCAppBackgroundTimeoutDetector() {
    }

    public static UTMCAppBackgroundTimeoutDetector getInstance() {
        UTMCAppBackgroundTimeoutDetector uTMCAppBackgroundTimeoutDetector;
        synchronized (UTMCAppBackgroundTimeoutDetector.class) {
            try {
                if (f27331a == null) {
                    f27331a = new UTMCAppBackgroundTimeoutDetector();
                }
                uTMCAppBackgroundTimeoutDetector = f27331a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return uTMCAppBackgroundTimeoutDetector;
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityStopped(Activity activity) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onSwitchBackground() {
        this.B = SystemClock.elapsedRealtime();
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onSwitchForeground() {
        if (0 != this.B && SystemClock.elapsedRealtime() - this.B > 30000) {
            c.a().c(new HashMap());
        }
        this.B = 0L;
    }
}
