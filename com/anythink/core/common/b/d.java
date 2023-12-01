package com.anythink.core.common.b;

import android.app.Activity;
import android.os.Looper;
import com.anythink.core.common.e.ai;
import java.lang.ref.WeakReference;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/b/d.class */
public abstract class d {
    boolean isRefresh;
    protected WeakReference<Activity> mActivityRef;
    private com.anythink.core.common.e.e mTrackingInfo;
    private ai mUnitGroupInfo;

    public final com.anythink.core.common.e.e getTrackingInfo() {
        return this.mTrackingInfo;
    }

    public final ai getUnitGroupInfo() {
        return this.mUnitGroupInfo;
    }

    public final boolean isRefresh() {
        return this.isRefresh;
    }

    public final void postOnMainThread(Runnable runnable) {
        n.a().a(runnable);
    }

    public final void postOnMainThreadDelayed(Runnable runnable, long j) {
        n.a().a(runnable, j);
    }

    public final void refreshActivityContext(Activity activity) {
        this.mActivityRef = new WeakReference<>(activity);
    }

    public final void runOnNetworkRequestThread(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            com.anythink.core.common.k.b.a.a().b(runnable);
        } else {
            runnable.run();
        }
    }

    public final void setRefresh(boolean z) {
        this.isRefresh = z;
    }

    public final void setTrackingInfo(com.anythink.core.common.e.e eVar) {
        this.mTrackingInfo = eVar;
    }

    public final void setUnitGroupInfo(ai aiVar) {
        this.mUnitGroupInfo = aiVar;
    }
}
