package com.tencent.liteav.base.system;

import java.util.concurrent.Callable;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/system/b.class */
final /* synthetic */ class b implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private static final b f36306a = new b();

    private b() {
    }

    public static Callable a() {
        return f36306a;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return a.d();
    }
}
