package com.tencent.liteav.base.system;

import android.os.Build;
import java.util.concurrent.Callable;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/system/i.class */
final /* synthetic */ class i implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private static final i f36313a = new i();

    private i() {
    }

    public static Callable a() {
        return f36313a;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        String str;
        str = Build.MANUFACTURER;
        return str;
    }
}
