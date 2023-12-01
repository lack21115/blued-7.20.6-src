package com.tencent.liteav.base.system;

import android.os.Build;
import java.util.concurrent.Callable;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/system/k.class */
final /* synthetic */ class k implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private static final k f36315a = new k();

    private k() {
    }

    public static Callable a() {
        return f36315a;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        String str;
        str = Build.VERSION.RELEASE;
        return str;
    }
}
