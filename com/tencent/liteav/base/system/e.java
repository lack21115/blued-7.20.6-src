package com.tencent.liteav.base.system;

import java.util.concurrent.Callable;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/system/e.class */
final /* synthetic */ class e implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private static final e f36309a = new e();

    private e() {
    }

    public static Callable a() {
        return f36309a;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return a.c();
    }
}
