package com.huawei.openalliance.ad.inter.data;

import com.huawei.openalliance.ad.beans.metadata.MediaFile;
import com.huawei.openalliance.ad.constant.bm;
import java.io.Serializable;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/inter/data/r.class */
public class r implements Serializable {
    private int B;
    private int C;
    private int D;
    private String F;
    private String I;
    private int L;
    private String S;
    private String V;
    private long Z;

    /* renamed from: a  reason: collision with root package name */
    private int f22975a;
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private String f22976c;

    public r() {
        this.B = 0;
        this.C = 0;
        this.F = "y";
        this.L = 0;
    }

    public r(MediaFile mediaFile, long j) {
        this.B = 0;
        this.C = 0;
        this.F = "y";
        this.L = 0;
        this.V = mediaFile.Code();
        this.I = mediaFile.B();
        this.Z = mediaFile.Z();
        this.D = mediaFile.S();
        this.L = mediaFile.F();
        this.B = mediaFile.V();
        this.C = mediaFile.I();
        this.S = mediaFile.C();
        this.f22975a = mediaFile.D();
        this.b = j;
    }

    public String C() {
        return this.S;
    }

    public void Code(String str) {
        this.F = str;
    }

    public boolean I() {
        String str = this.I;
        if (str == null || !str.startsWith(bm.CONTENT.toString())) {
            String str2 = this.f22976c;
            return str2 != null && str2.startsWith(bm.CONTENT.toString());
        }
        return true;
    }

    public int L() {
        return this.D;
    }

    public String S() {
        return this.F;
    }

    public void V(String str) {
        this.f22976c = str;
    }

    public boolean V() {
        return "video/mp4".equals(this.V);
    }

    public String Z() {
        return this.I;
    }

    public String b() {
        return this.V;
    }

    public int c() {
        return this.f22975a;
    }

    public long d() {
        return this.b;
    }

    public String e() {
        String str = this.I;
        return (str == null || !str.startsWith(bm.CONTENT.toString())) ? this.f22976c : this.I;
    }

    public Float f() {
        int i;
        int i2 = this.B;
        if (i2 <= 0 || (i = this.C) <= 0) {
            return null;
        }
        return Float.valueOf(i2 / i);
    }
}
