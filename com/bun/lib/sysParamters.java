package com.bun.lib;

import android.content.Context;
import android.content.pm.PackageInfo;

/* loaded from: source-7206380-dex2jar.jar:com/bun/lib/sysParamters.class */
public class sysParamters {
    private static volatile sysParamters d;

    /* renamed from: a  reason: collision with root package name */
    private String f7514a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f7515c;
    private String sdk_version = "10012";
    private String sdk_vname = "1.0.12";

    private sysParamters() {
    }

    private static native PackageInfo a(Context context, String str);

    public static native String a(Context context);

    public static native String a(String str, String str2);

    public static native String e();

    public static native sysParamters f();

    public static native String g();

    private static native String h();

    public native String a();

    public native String b();

    public native String c();

    public native String d();
}
