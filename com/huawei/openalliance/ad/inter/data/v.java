package com.huawei.openalliance.ad.inter.data;

import android.text.TextUtils;
import com.huawei.openalliance.ad.beans.metadata.VideoInfo;
import com.huawei.openalliance.ad.constant.bm;
import java.io.Serializable;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/inter/data/v.class */
public class v implements Serializable {
    private static final long Code = 30414300;
    private String B;
    private int C;
    private String D;
    private int F;
    private int I;
    private int L;
    private String S;
    private String V;
    private int Z;

    /* renamed from: a  reason: collision with root package name */
    private String f22978a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f22979c;
    private int d;
    private int e;
    private int f;
    private Float g;
    private boolean h;
    private boolean i;
    private float j;

    public v() {
        this.B = "y";
        this.S = "n";
        this.F = 200;
        this.L = 0;
        this.f22978a = "n";
        this.b = 1;
        this.d = 100;
        this.e = 90;
        this.f = 0;
        this.h = true;
        this.i = false;
    }

    public v(VideoInfo videoInfo) {
        this.B = "y";
        this.S = "n";
        this.F = 200;
        this.L = 0;
        this.f22978a = "n";
        this.b = 1;
        this.d = 100;
        this.e = 90;
        this.f = 0;
        this.h = true;
        this.i = false;
        if (videoInfo != null) {
            this.V = videoInfo.Code();
            this.I = videoInfo.I();
            this.Z = videoInfo.Z();
            if (TextUtils.equals(videoInfo.B(), "y") || TextUtils.equals(videoInfo.B(), "a")) {
                this.B = "y";
            } else {
                this.B = "n";
            }
            this.S = videoInfo.C();
            this.F = videoInfo.S();
            this.D = videoInfo.F();
            this.b = videoInfo.D();
            this.f22978a = this.S;
            this.f22979c = videoInfo.L() == 0;
            if (videoInfo.a() != null) {
                this.d = videoInfo.a().intValue();
            }
            if (videoInfo.b() != null) {
                this.e = videoInfo.b().intValue();
            }
            I(videoInfo.c());
            if (TextUtils.equals(videoInfo.B(), "a")) {
                this.C = 1;
            } else {
                this.C = 0;
            }
            this.h = "y".equalsIgnoreCase(videoInfo.e());
            Code(videoInfo.d());
            Code(videoInfo.f());
        }
    }

    private void Code(Float f) {
        if (f == null) {
            f = null;
        } else if (f.floatValue() <= 0.0f) {
            f = Float.valueOf(1.7777778f);
        }
        this.g = f;
    }

    private void I(int i) {
        if (i == 1) {
            this.f = 1;
        } else {
            this.f = 0;
        }
    }

    public String B() {
        return this.B;
    }

    public String C() {
        return this.S;
    }

    public void Code(float f) {
        float f2 = f;
        if (f <= 0.0f) {
            f2 = 3.5f;
        }
        this.j = f2;
    }

    public void Code(int i) {
        this.L = i;
    }

    public void Code(String str) {
        this.f22978a = str;
    }

    public void Code(boolean z) {
        this.i = z;
    }

    public boolean Code() {
        if (2 == this.b || this.i) {
            return true;
        }
        String str = this.V;
        return str != null && str.startsWith(bm.CONTENT.toString());
    }

    public int D() {
        return this.b;
    }

    public String F() {
        return this.D;
    }

    public int I() {
        return this.I;
    }

    public int L() {
        return this.L;
    }

    public int S() {
        return this.F;
    }

    public String V() {
        return this.V;
    }

    public void V(int i) {
        this.I = i;
    }

    public void V(String str) {
        this.V = str;
    }

    public int Z() {
        return this.Z;
    }

    public String a() {
        return this.f22978a;
    }

    public boolean b() {
        return this.f22979c;
    }

    public int c() {
        return this.d;
    }

    public int d() {
        return this.e;
    }

    public int e() {
        return this.f;
    }

    public int f() {
        return this.C;
    }

    public Float g() {
        return this.g;
    }

    public boolean h() {
        return this.i;
    }

    public boolean i() {
        return this.h;
    }

    public float j() {
        return this.j;
    }
}
