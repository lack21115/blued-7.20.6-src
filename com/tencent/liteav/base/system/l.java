package com.tencent.liteav.base.system;

import android.os.Build;
import java.util.concurrent.Callable;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/system/l.class */
final /* synthetic */ class l implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private static final l f36316a = new l();

    private l() {
    }

    public static Callable a() {
        return f36316a;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        Integer valueOf;
        valueOf = Integer.valueOf(Build.VERSION.SDK_INT);
        return valueOf;
    }
}
