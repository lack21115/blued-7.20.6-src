package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.map.lib.models.GeoPoint;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/jg.class */
public class jg {
    public static final int A = 65536;
    public static final int t = 0;
    public static final int u = 1;
    public static final int v = 2;
    public static final int w = 1;
    public static final int x = 16;
    public static final int y = 256;
    public static final int z = 4096;

    /* renamed from: a  reason: collision with root package name */
    private GeoPoint f23887a;
    private Bitmap[] b;
    private int g;
    private boolean h;
    private int i;
    private int j;
    private Rect k;
    private int l;
    private boolean n;
    public String p;
    private boolean q;
    private boolean r;

    /* renamed from: c  reason: collision with root package name */
    private float f23888c = 0.5f;
    private float d = 0.5f;
    private float e = 1.0f;
    private boolean f = false;
    private int m = 2;
    private boolean o = true;
    private boolean s = true;

    public float a() {
        return this.e;
    }

    public int a(int i) {
        return b()[0];
    }

    public jg a(float f) {
        this.e = f;
        return this;
    }

    public jg a(float f, float f2) {
        this.f23888c = f;
        this.d = f2;
        return this;
    }

    public jg a(int i, int i2) {
        this.i = i;
        this.j = i2;
        return this;
    }

    public jg a(int i, int i2, int i3, int i4) {
        this.k = new Rect(i, i2, i3, i4);
        return this;
    }

    public jg a(GeoPoint geoPoint) {
        this.f23887a = geoPoint;
        return this;
    }

    public jg a(String str, Bitmap... bitmapArr) {
        this.p = str;
        this.b = bitmapArr;
        return this;
    }

    public jg a(boolean z2) {
        this.r = z2;
        return this;
    }

    public jg a(int... iArr) {
        if (iArr == null) {
            this.f23888c = 0.5f;
            this.d = 1.0f;
            return this;
        }
        this.f23888c = 0.5f;
        this.d = 0.5f;
        if (iArr.length != 1) {
            return this;
        }
        if ((iArr[0] & 256) == 256) {
            this.d = 0.0f;
        } else if ((iArr[0] & 16) == 16) {
            this.d = 1.0f;
        }
        if ((iArr[0] & 4096) == 4096) {
            this.f23888c = 0.0f;
            return this;
        }
        if ((iArr[0] & 65536) == 65536) {
            this.f23888c = 1.0f;
        }
        return this;
    }

    public jg b(int i) {
        this.m = i;
        return this;
    }

    public jg b(boolean z2) {
        this.q = z2;
        return this;
    }

    public int[] b() {
        float f = this.f23888c;
        int i = f == 0.0f ? 4096 : f == 1.0f ? 65536 : 1;
        float f2 = this.d;
        return new int[]{i | (f2 == 0.0f ? 256 : f2 == 1.0f ? 16 : 1)};
    }

    public float c() {
        return this.f23888c;
    }

    public jg c(int i) {
        this.g = i;
        return this;
    }

    public jg c(boolean z2) {
        this.s = z2;
        return this;
    }

    public float d() {
        return this.d;
    }

    public jg d(int i) {
        this.l = i;
        return this;
    }

    public jg d(boolean z2) {
        this.o = z2;
        return this;
    }

    public Rect e() {
        return this.k;
    }

    public jg e(boolean z2) {
        this.n = z2;
        return this;
    }

    public jg f(boolean z2) {
        this.f = z2;
        return this;
    }

    public Bitmap[] f() {
        return this.b;
    }

    public jg g(boolean z2) {
        this.h = z2;
        return this;
    }

    public String g() {
        return this.p;
    }

    public int h() {
        return this.m;
    }

    public int i() {
        return this.i;
    }

    public int j() {
        return this.j;
    }

    public GeoPoint k() {
        return this.f23887a;
    }

    public int l() {
        return this.g;
    }

    public int m() {
        return this.l;
    }

    public boolean n() {
        return this.r;
    }

    public boolean o() {
        return this.q;
    }

    public boolean p() {
        return this.s;
    }

    public boolean q() {
        return this.o;
    }

    public boolean r() {
        return this.n;
    }

    public boolean s() {
        return this.f;
    }

    public boolean t() {
        return this.h;
    }
}
