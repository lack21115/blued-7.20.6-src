package com.tencent.liteav.sdkcommon;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/sdkcommon/d.class */
final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final DashboardManager f22739a;

    private d(DashboardManager dashboardManager) {
        this.f22739a = dashboardManager;
    }

    public static Runnable a(DashboardManager dashboardManager) {
        return new d(dashboardManager);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f22739a.removeAllDashboardInternal();
    }
}
