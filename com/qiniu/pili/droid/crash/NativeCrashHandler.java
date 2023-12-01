package com.qiniu.pili.droid.crash;

import android.content.Context;
import android.os.Build;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/crash/NativeCrashHandler.class */
public class NativeCrashHandler {

    /* renamed from: a  reason: collision with root package name */
    private static NativeCrashHandler f13779a = new NativeCrashHandler();
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f13780c = false;

    private NativeCrashHandler() {
    }

    public static NativeCrashHandler a() {
        return f13779a;
    }

    private static native int nativeInit(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, boolean z, boolean z2, int i2, int i3, int i4, boolean z3, boolean z4, boolean z5, boolean z6, int i5, String[] strArr, boolean z7, boolean z8, int i6, int i7, int i8, boolean z9);

    private static native void nativeNotifyJavaCrashed();

    private static native void nativeTestCrash(int i);

    public void a(Context context) {
        try {
            System.loadLibrary("pldroid_crash");
            this.b = context;
            if (nativeInit(Build.VERSION.SDK_INT, Build.VERSION.RELEASE, k.b(), Build.MANUFACTURER, Build.BRAND, Build.MODEL, Build.FINGERPRINT, context.getPackageName(), k.e(context), context.getApplicationInfo().nativeLibraryDir, f.a().d().getAbsolutePath(), true, true, 50, 50, 200, true, true, true, true, 5, b.f13785a, true, true, 50, 50, 200, true) != 0) {
                return;
            }
            this.f13780c = true;
        } catch (Throwable th) {
        }
    }

    public void b() {
        if (this.f13780c) {
            nativeNotifyJavaCrashed();
        }
    }
}
