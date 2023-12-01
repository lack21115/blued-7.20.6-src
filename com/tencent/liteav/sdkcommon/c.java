package com.tencent.liteav.sdkcommon;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/sdkcommon/c.class */
final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final DashboardManager f36429a;
    private final String b;

    private c(DashboardManager dashboardManager, String str) {
        this.f36429a = dashboardManager;
        this.b = str;
    }

    public static Runnable a(DashboardManager dashboardManager, String str) {
        return new c(dashboardManager, str);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f36429a.removeDashboardInternal(this.b);
    }
}
