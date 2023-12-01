package com.tencent.mapsdk.internal;

import java.io.Serializable;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/r2.class */
public final class r2 implements Serializable {
    public static final int e = 29;
    public static final int f = 1;
    public static final int g = 8;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private String f37732c;
    public static final /* synthetic */ boolean i = !r2.class.desiredAssertionStatus();
    private static r2[] d = new r2[28];
    public static final r2 h = new r2(26, 29, "REQ_CONFIG");

    private r2(int i2, int i3, String str) {
        this.f37732c = new String();
        this.f37732c = str;
        this.b = i3;
        d[i2] = this;
    }

    public static r2 a(int i2) {
        int i3 = 0;
        while (true) {
            int i4 = i3;
            r2[] r2VarArr = d;
            if (i4 >= r2VarArr.length) {
                if (i) {
                    return null;
                }
                throw new AssertionError();
            } else if (r2VarArr[i4].a() == i2) {
                return d[i4];
            } else {
                i3 = i4 + 1;
            }
        }
    }

    public static r2 a(String str) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            r2[] r2VarArr = d;
            if (i3 >= r2VarArr.length) {
                if (i) {
                    return null;
                }
                throw new AssertionError();
            } else if (r2VarArr[i3].toString().equals(str)) {
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
        return this.f37732c;
    }
}
