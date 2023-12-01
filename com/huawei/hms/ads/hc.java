package com.huawei.hms.ads;

import android.view.View;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/hc.class */
public class hc extends he {
    private a C;
    private boolean D;
    private int F;
    boolean I;
    private long L;
    private long S;
    boolean V;
    protected com.huawei.openalliance.ad.inter.data.l Z;

    /* renamed from: a  reason: collision with root package name */
    private int f22490a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f22491c;

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/hc$a.class */
    public interface a {
        void B();

        void Code();

        void Code(long j, int i);

        void I();

        void V();

        void V(long j, int i);

        void Z();
    }

    public hc(View view, a aVar) {
        super(view);
        this.S = 500L;
        this.F = 50;
        this.D = false;
        this.b = 100;
        this.f22491c = 10;
        this.V = false;
        this.I = false;
        this.C = aVar;
        this.L = com.huawei.openalliance.ad.utils.v.Code();
    }

    private void f() {
        if (this.D) {
            return;
        }
        ge.V("PPSLinkedViewMonitor", "viewShowStartRecord");
        this.D = true;
        this.L = System.currentTimeMillis();
        a aVar = this.C;
        if (aVar != null) {
            aVar.Code();
        }
    }

    private void g() {
        if (this.D) {
            ge.V("PPSLinkedViewMonitor", "viewShowEndRecord");
            this.D = false;
            long currentTimeMillis = System.currentTimeMillis() - this.L;
            if (ge.Code()) {
                ge.Code("PPSLinkedViewMonitor", "max visible area percentage: %d duration: %d", Integer.valueOf(this.f22490a), Long.valueOf(currentTimeMillis));
            }
            a aVar = this.C;
            if (aVar != null) {
                aVar.Code(currentTimeMillis, this.f22490a);
            }
            this.f22490a = 0;
        }
    }

    public int B() {
        return this.f22490a;
    }

    @Override // com.huawei.hms.ads.he
    protected void Code() {
        a aVar = this.C;
        if (aVar != null) {
            aVar.V();
        }
    }

    @Override // com.huawei.hms.ads.he
    protected void Code(int i) {
        ge.V("PPSLinkedViewMonitor", "onUpdateViewShowArea, percentage: %s", Integer.valueOf(i));
        if (i > this.f22490a) {
            this.f22490a = i;
        }
        if (i >= this.F) {
            f();
        } else {
            g();
        }
        V(i);
    }

    @Override // com.huawei.hms.ads.he
    protected void Code(long j, int i) {
        g();
        a aVar = this.C;
        if (aVar != null) {
            aVar.V(j, i);
        }
        V(0);
    }

    public void Code(com.huawei.openalliance.ad.inter.data.l lVar) {
        this.Z = lVar;
        if (lVar == null || lVar.C() == null) {
            return;
        }
        com.huawei.openalliance.ad.inter.data.v C = lVar.C();
        this.b = C.c();
        this.f22491c = Math.max(100 - C.d(), 0);
    }

    public boolean Code(long j) {
        return j >= this.S && this.f22490a >= this.F;
    }

    public boolean F() {
        return e() >= V();
    }

    protected int I() {
        return this.f22491c;
    }

    protected int V() {
        return this.b;
    }

    void V(int i) {
        a aVar;
        if (i >= V()) {
            this.I = false;
            if (this.V) {
                return;
            }
            this.V = true;
            a aVar2 = this.C;
            if (aVar2 != null) {
                aVar2.I();
                return;
            }
            return;
        }
        this.V = false;
        if (i > 100 - I()) {
            if (this.I && (aVar = this.C) != null) {
                aVar.B();
            }
            this.I = false;
        } else if (this.I) {
        } else {
            this.I = true;
            a aVar3 = this.C;
            if (aVar3 != null) {
                aVar3.Z();
            }
        }
    }

    public void V(long j, int i) {
        this.F = i;
        this.S = j;
    }
}
