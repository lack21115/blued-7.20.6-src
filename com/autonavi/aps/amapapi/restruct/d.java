package com.autonavi.aps.amapapi.restruct;

import android.content.pm.PackageManager;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/aps/amapapi/restruct/d.class */
public final class d {
    public int l;
    public boolean n;

    /* renamed from: a  reason: collision with root package name */
    public int f9246a = 0;
    public int b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f9247c = 0;
    public int d = 0;
    public long e = 0;
    public int f = 0;
    public int g = 0;
    public int h = 0;
    public int i = 0;
    public int j = 0;
    public int k = PackageManager.INSTALL_FAILED_NO_MATCHING_ABIS;
    public short m = 0;
    public int o = Short.MAX_VALUE;
    public int p = Integer.MAX_VALUE;
    public int q = Integer.MAX_VALUE;
    public boolean r = true;
    public int s = 99;
    public long t = 0;

    public d(int i, boolean z) {
        this.l = 0;
        this.n = false;
        this.l = i;
        this.n = z;
    }

    private String e() {
        int i = this.l;
        return this.l + "#" + this.f9246a + "#" + this.b + "#0#" + a();
    }

    private String f() {
        return this.l + "#" + this.h + "#" + this.i + "#" + this.j;
    }

    public final long a() {
        return this.l == 5 ? this.e : this.d;
    }

    public final String b() {
        int i = this.l;
        if (i != 1) {
            if (i == 2) {
                return f();
            }
            if (i != 3 && i != 4 && i != 5) {
                return null;
            }
        }
        return e();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public final String c() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public final d clone() {
        d dVar = new d(this.l, this.n);
        dVar.f9246a = this.f9246a;
        dVar.b = this.b;
        dVar.f9247c = this.f9247c;
        dVar.d = this.d;
        dVar.e = this.e;
        dVar.f = this.f;
        dVar.g = this.g;
        dVar.h = this.h;
        dVar.i = this.i;
        dVar.j = this.j;
        dVar.k = this.k;
        dVar.m = this.m;
        dVar.o = this.o;
        dVar.p = this.p;
        dVar.q = this.q;
        dVar.r = this.r;
        dVar.s = this.s;
        dVar.t = this.t;
        return dVar;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof d)) {
            d dVar = (d) obj;
            int i = dVar.l;
            return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i == 5 && this.l == 5 && dVar.f9247c == this.f9247c && dVar.e == this.e && dVar.q == this.q : this.l == 4 && dVar.f9247c == this.f9247c && dVar.d == this.d && dVar.b == this.b : this.l == 3 && dVar.f9247c == this.f9247c && dVar.d == this.d && dVar.b == this.b : this.l == 2 && dVar.j == this.j && dVar.i == this.i && dVar.h == this.h : this.l == 1 && dVar.f9247c == this.f9247c && dVar.d == this.d && dVar.b == this.b;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3 = String.valueOf(this.l).hashCode();
        if (this.l == 2) {
            hashCode = String.valueOf(this.j).hashCode() + String.valueOf(this.i).hashCode();
            hashCode2 = String.valueOf(this.h).hashCode();
        } else {
            hashCode = String.valueOf(this.f9247c).hashCode() + String.valueOf(this.d).hashCode();
            hashCode2 = String.valueOf(this.b).hashCode();
        }
        return hashCode3 + hashCode + hashCode2;
    }
}
