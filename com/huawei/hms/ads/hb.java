package com.huawei.hms.ads;

import android.view.View;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/hb.class */
public class hb extends he {
    private static final String Code = "NativeViewMonitor";
    private boolean B;
    private long C;
    private long I;
    private int S;
    private ha V;
    private int Z;

    public hb(View view, ha haVar) {
        super(view);
        this.I = 500L;
        this.Z = 50;
        this.B = false;
        this.V = haVar;
        this.C = com.huawei.openalliance.ad.utils.v.Code();
    }

    private void B() {
        if (this.B) {
            return;
        }
        ge.V(Code, "viewShowStartRecord");
        this.B = true;
        this.C = System.currentTimeMillis();
        ha haVar = this.V;
        if (haVar != null) {
            haVar.a_();
        }
    }

    private void C() {
        if (this.B) {
            ge.V(Code, "viewShowEndRecord");
            this.B = false;
            long currentTimeMillis = System.currentTimeMillis() - this.C;
            if (ge.Code()) {
                ge.Code(Code, "max visible area percentage: %d duration: %d", Integer.valueOf(this.S), Long.valueOf(currentTimeMillis));
            }
            ha haVar = this.V;
            if (haVar != null) {
                haVar.Code(currentTimeMillis, this.S);
            }
            this.S = 0;
        }
    }

    @Override // com.huawei.hms.ads.he
    protected void Code() {
        ha haVar = this.V;
        if (haVar != null) {
            haVar.I();
        }
    }

    @Override // com.huawei.hms.ads.he
    protected void Code(int i) {
        if (i > this.S) {
            this.S = i;
        }
        if (i >= this.Z) {
            B();
        } else {
            C();
        }
    }

    @Override // com.huawei.hms.ads.he
    protected void Code(long j, int i) {
        C();
        ha haVar = this.V;
        if (haVar != null) {
            haVar.V(j, i);
        }
    }

    public boolean Code(long j) {
        return j >= this.I && this.S >= this.Z;
    }

    public int I() {
        return this.S;
    }

    public void V() {
        this.Z = 50;
        this.I = 500L;
    }

    public void V(long j, int i) {
        this.Z = i;
        this.I = j;
    }

    public long Z() {
        return this.C;
    }
}
