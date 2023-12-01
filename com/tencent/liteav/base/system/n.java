package com.tencent.liteav.base.system;

import java.util.concurrent.Callable;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/system/n.class */
final /* synthetic */ class n implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private static final n f22627a = new n();

    private n() {
    }

    public static Callable a() {
        return f22627a;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return a.a();
    }
}
