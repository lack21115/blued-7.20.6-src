package com.tencent.liteav.sdkcommon;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/sdkcommon/a.class */
final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final DashboardManager f36427a;
    private final boolean b;

    private a(DashboardManager dashboardManager, boolean z) {
        this.f36427a = dashboardManager;
        this.b = z;
    }

    public static Runnable a(DashboardManager dashboardManager, boolean z) {
        return new a(dashboardManager, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f36427a.showDashboardInternal(this.b);
    }
}
