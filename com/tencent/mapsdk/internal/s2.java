package com.tencent.mapsdk.internal;

import java.io.Serializable;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/s2.class */
public final class s2 implements Serializable {
    public static final int e = 0;
    public static final int g = 1;
    public static final int i = 2;
    public static final int k = 3;
    public static final int m = 4;
    public static final int o = 5;
    public static final int q = 6;
    public static final int s = 7;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private String f37990c;
    public static final /* synthetic */ boolean u = !s2.class.desiredAssertionStatus();
    private static s2[] d = new s2[8];
    public static final s2 f = new s2(0, 0, "RST_SUCC");
    public static final s2 h = new s2(1, 1, "RST_DECODE_FAIL");
    public static final s2 j = new s2(2, 2, "RST_SYS_ERR");
    public static final s2 l = new s2(3, 3, "RST_INVALID_USER");
    public static final s2 n = new s2(4, 4, "RST_USE_INVALID_KEY");
    public static final s2 p = new s2(5, 5, "RST_INVALID_UIN");
    public static final s2 r = new s2(6, 6, "RST_INVALID_CMD");
    public static final s2 t = new s2(7, 7, "RST_PACKAGE_ERR");

    private s2(int i2, int i3, String str) {
        this.f37990c = new String();
        this.f37990c = str;
        this.b = i3;
        d[i2] = this;
    }

    public static s2 a(int i2) {
        int i3 = 0;
        while (true) {
            int i4 = i3;
            s2[] s2VarArr = d;
            if (i4 >= s2VarArr.length) {
                if (u) {
                    return null;
                }
                throw new AssertionError();
            } else if (s2VarArr[i4].a() == i2) {
                return d[i4];
            } else {
                i3 = i4 + 1;
            }
        }
    }

    public static s2 a(String str) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            s2[] s2VarArr = d;
            if (i3 >= s2VarArr.length) {
                if (u) {
                    return null;
                }
                throw new AssertionError();
            } else if (s2VarArr[i3].toString().equals(str)) {
                return d[i3];
            } else {
                i2 = i3 + 1;
            }
        }
    }

    public int a() {
        return this.b;
    }

    public String toString() {
        return this.f37990c;
    }
}
