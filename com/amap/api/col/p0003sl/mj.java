package com.amap.api.col.p0003sl;

import java.io.Serializable;

/* renamed from: com.amap.api.col.3sl.mj  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/mj.class */
public abstract class mj implements Serializable {
    public String a;
    public String b;
    public int c;
    public int d;
    public long e;
    public long f;
    public int g;
    public boolean h;
    public boolean i;

    public mj() {
        this.a = "";
        this.b = "";
        this.c = 99;
        this.d = Integer.MAX_VALUE;
        this.e = 0L;
        this.f = 0L;
        this.g = 0;
        this.i = true;
    }

    public mj(boolean z, boolean z2) {
        this.a = "";
        this.b = "";
        this.c = 99;
        this.d = Integer.MAX_VALUE;
        this.e = 0L;
        this.f = 0L;
        this.g = 0;
        this.i = true;
        this.h = z;
        this.i = z2;
    }

    private static int a(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            mt.a(e);
            return 0;
        }
    }

    @Override // 
    /* renamed from: a */
    public abstract mj clone();

    public final void a(mj mjVar) {
        this.a = mjVar.a;
        this.b = mjVar.b;
        this.c = mjVar.c;
        this.d = mjVar.d;
        this.e = mjVar.e;
        this.f = mjVar.f;
        this.g = mjVar.g;
        this.h = mjVar.h;
        this.i = mjVar.i;
    }

    public final int b() {
        return a(this.a);
    }

    public final int c() {
        return a(this.b);
    }

    public String toString() {
        return "AmapCell{mcc=" + this.a + ", mnc=" + this.b + ", signalStrength=" + this.c + ", asulevel=" + this.d + ", lastUpdateSystemMills=" + this.e + ", lastUpdateUtcMills=" + this.f + ", age=" + this.g + ", main=" + this.h + ", newapi=" + this.i + '}';
    }
}
