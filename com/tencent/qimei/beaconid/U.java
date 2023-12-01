package com.tencent.qimei.beaconid;

import android.content.Context;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/beaconid/U.class */
public class U {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f24624a = false;

    static {
        int i;
        int i2 = 0;
        do {
            try {
                System.loadLibrary("beaconid");
                f24624a = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
            i = i2 + 1;
            if (f24624a) {
                return;
            }
            i2 = i;
        } while (i < 2);
    }

    public static String a(String str) {
        if (f24624a) {
            try {
                return x(str);
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
                return "";
            }
        }
        return "";
    }

    public static native byte[] a(int i, byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static native String[] c(int i);

    public static native byte[] d(long j);

    public static native byte e(String str, long j);

    public static native void n(Context context, String str);

    public static native String o();

    public static native String p();

    public static native String r();

    public static native String s();

    public static native String u();

    public static native String x(String str);

    public static native String z(Context context);
}
