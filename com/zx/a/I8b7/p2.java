package com.zx.a.I8b7;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.zx.module.annotation.Java2C;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/p2.class */
public class p2 {

    /* renamed from: a  reason: collision with root package name */
    public static int f28473a = Integer.MIN_VALUE;
    public static Object b;

    @Java2C.Method2C
    private static native int a();

    @Java2C.Method2C
    public static native PackageInfo a(String str, int i) throws PackageManager.NameNotFoundException;

    @Java2C.Method2C
    private static native PackageInfo a(String str, int i, int i2);
}
