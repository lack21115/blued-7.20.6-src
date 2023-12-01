package com.huawei.hms.ads;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/jv.class */
public abstract class jv {
    private final String B = "min_show_time_task" + hashCode();
    private final String C = "max_show_time_task" + hashCode();
    protected fk Code;
    private lu Z;

    public jv(fk fkVar, lu luVar) {
        this.Code = fkVar;
        this.Z = luVar;
    }

    protected void B() {
        com.huawei.openalliance.ad.utils.ba.Code(this.B);
    }

    public void Code() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Code(long j) {
        ge.V(getClass().getSimpleName(), "start max show time task duration: %d", Long.valueOf(j));
        com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.jv.1
            @Override // java.lang.Runnable
            public void run() {
                jv.this.B();
                jv.this.Z();
            }
        }, this.C, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I() {
        lu luVar = this.Z;
        if (luVar != null) {
            luVar.Code();
        }
    }

    public void V() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V(long j) {
        ge.V(getClass().getSimpleName(), "start min show time task duration: %d", Long.valueOf(j));
        com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.jv.2
            @Override // java.lang.Runnable
            public void run() {
                jv.this.I();
            }
        }, this.B, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Z() {
        lu luVar = this.Z;
        if (luVar != null) {
            luVar.V();
        }
    }
}
