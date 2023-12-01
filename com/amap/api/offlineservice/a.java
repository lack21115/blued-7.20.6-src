package com.amap.api.offlineservice;

import android.view.View;
import android.widget.RelativeLayout;
import com.amap.api.maps.offlinemap.OfflineMapActivity;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/offlineservice/a.class */
public abstract class a {
    protected OfflineMapActivity a = null;

    public final int a(float f) {
        OfflineMapActivity offlineMapActivity = this.a;
        return offlineMapActivity != null ? (int) ((f * (offlineMapActivity.getResources().getDisplayMetrics().densityDpi / 160.0f)) + 0.5f) : (int) f;
    }

    public abstract void a();

    public abstract void a(View view);

    public final void a(OfflineMapActivity offlineMapActivity) {
        this.a = offlineMapActivity;
    }

    public abstract RelativeLayout b();

    public abstract void c();

    public boolean d() {
        return true;
    }

    public final void e() {
        this.a.showScr();
    }
}
