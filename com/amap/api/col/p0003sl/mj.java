package com.amap.api.col.p0003sl;

import java.io.Serializable;

/* renamed from: com.amap.api.col.3sl.mj  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/mj.class */
public abstract class mj implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public String f5383a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public int f5384c;
    public int d;
    public long e;
    public long f;
    public int g;
    public boolean h;
    public boolean i;

    public mj() {
        this.f5383a = "";
        this.b = "";
        this.f5384c = 99;
        this.d = Integer.MAX_VALUE;
        this.e = 0L;
        this.f = 0L;
        this.g = 0;
        this.i = true;
    }

    public mj(boolean z, boolean z2) {
        this.f5383a = "";
        this.b = "";
        this.f5384c = 99;
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
        this.f5383a = mjVar.f5383a;
        this.b = mjVar.b;
        this.f5384c = mjVar.f5384c;
        this.d = mjVar.d;
        this.e = mjVar.e;
        this.f = mjVar.f;
        this.g = mjVar.g;
        this.h = mjVar.h;
        this.i = mjVar.i;
    }

    public final int b() {
        return a(this.f5383a);
    }

    public final int c() {
        return a(this.b);
    }

    public String toString() {
        return "AmapCell{mcc=" + this.f5383a + ", mnc=" + this.b + ", signalStrength=" + this.f5384c + ", asulevel=" + this.d + ", lastUpdateSystemMills=" + this.e + ", lastUpdateUtcMills=" + this.f + ", age=" + this.g + ", main=" + this.h + ", newapi=" + this.i + '}';
    }
}
