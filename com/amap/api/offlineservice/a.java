package com.amap.api.offlineservice;

import android.view.View;
import android.widget.RelativeLayout;
import com.amap.api.maps.offlinemap.OfflineMapActivity;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/offlineservice/a.class */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected OfflineMapActivity f5579a = null;

    public final int a(float f) {
        OfflineMapActivity offlineMapActivity = this.f5579a;
        return offlineMapActivity != null ? (int) ((f * (offlineMapActivity.getResources().getDisplayMetrics().densityDpi / 160.0f)) + 0.5f) : (int) f;
    }

    public abstract void a();

    public abstract void a(View view);

    public final void a(OfflineMapActivity offlineMapActivity) {
        this.f5579a = offlineMapActivity;
    }

    public abstract RelativeLayout b();

    public abstract void c();

    public boolean d() {
        return true;
    }

    public final void e() {
        this.f5579a.showScr();
    }
}
