package com.tencent.liteav.sdkcommon;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/sdkcommon/e.class */
final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final DashboardManager f22740a;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final String f22741c;

    private e(DashboardManager dashboardManager, String str, String str2) {
        this.f22740a = dashboardManager;
        this.b = str;
        this.f22741c = str2;
    }

    public static Runnable a(DashboardManager dashboardManager, String str, String str2) {
        return new e(dashboardManager, str, str2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f22740a.setStatusInternal(this.b, this.f22741c);
    }
}
