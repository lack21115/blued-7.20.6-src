package com.tencent.liteav.base.system;

import java.util.concurrent.Callable;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/system/d.class */
final /* synthetic */ class d implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private static final d f36308a = new d();

    private d() {
    }

    public static Callable a() {
        return f36308a;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return a.b();
    }
}
