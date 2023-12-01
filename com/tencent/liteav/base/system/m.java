package com.tencent.liteav.base.system;

import android.os.Build;
import java.util.concurrent.Callable;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/system/m.class */
final /* synthetic */ class m implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private static final m f36317a = new m();

    private m() {
    }

    public static Callable a() {
        return f36317a;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        String str;
        str = Build.BOARD;
        return str;
    }
}
