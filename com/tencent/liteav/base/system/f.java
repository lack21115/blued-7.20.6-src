package com.tencent.liteav.base.system;

import java.util.concurrent.Callable;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/system/f.class */
final /* synthetic */ class f implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private static final f f22619a = new f();

    private f() {
    }

    public static Callable a() {
        return f22619a;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        String a2;
        a2 = o.a(LiteavSystemInfo.sAppPackageName.a());
        return a2;
    }
}
