package com.tencent.liteav.base.system;

import android.os.Build;
import java.util.concurrent.Callable;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/system/g.class */
final /* synthetic */ class g implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private static final g f36311a = new g();

    private g() {
    }

    public static Callable a() {
        return f36311a;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        String str;
        str = Build.MODEL;
        return str;
    }
}
