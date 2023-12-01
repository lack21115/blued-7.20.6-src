package com.tencent.liteav.base.system;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/system/c.class */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static final c f36307a = new c();

    private c() {
    }

    public static Runnable a() {
        return f36307a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LiteavSystemInfo.lambda$getAppMemoryUsageFromSystem$8();
    }
}
