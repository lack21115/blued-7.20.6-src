package com.tencent.liteav.base.system;

import android.os.Build;
import java.util.concurrent.Callable;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/system/j.class */
final /* synthetic */ class j implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private static final j f36314a = new j();

    private j() {
    }

    public static Callable a() {
        return f36314a;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        String str;
        str = Build.HARDWARE;
        return str;
    }
}
