package com.tencent.liteav.base.system;

import android.os.Build;
import java.util.concurrent.Callable;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/system/h.class */
final /* synthetic */ class h implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private static final h f22621a = new h();

    private h() {
    }

    public static Callable a() {
        return f22621a;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        String str;
        str = Build.BRAND;
        return str;
    }
}
