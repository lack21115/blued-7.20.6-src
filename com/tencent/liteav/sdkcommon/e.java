package com.tencent.liteav.sdkcommon;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/sdkcommon/e.class */
final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final DashboardManager f36431a;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final String f36432c;

    private e(DashboardManager dashboardManager, String str, String str2) {
        this.f36431a = dashboardManager;
        this.b = str;
        this.f36432c = str2;
    }

    public static Runnable a(DashboardManager dashboardManager, String str, String str2) {
        return new e(dashboardManager, str, str2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f36431a.setStatusInternal(this.b, this.f36432c);
    }
}
