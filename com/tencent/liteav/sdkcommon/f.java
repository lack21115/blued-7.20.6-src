package com.tencent.liteav.sdkcommon;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/sdkcommon/f.class */
final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final DashboardManager f36433a;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final String f36434c;

    private f(DashboardManager dashboardManager, String str, String str2) {
        this.f36433a = dashboardManager;
        this.b = str;
        this.f36434c = str2;
    }

    public static Runnable a(DashboardManager dashboardManager, String str, String str2) {
        return new f(dashboardManager, str, str2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f36433a.appendLogInternal(this.b, this.f36434c);
    }
}
