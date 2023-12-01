package com.kwad.sdk.ip.direct;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/ip/direct/c.class */
public final class c implements Comparable<c> {
    private String ip;
    private boolean success;
    private int weight;
    private float atU = -1.0f;
    private int atZ = 20;
    private int atY = 3;
    private StringBuffer aua = new StringBuffer();

    public c(String str) {
        this.ip = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(c cVar) {
        return (int) (this.atU - cVar.atU);
    }

    public final int AX() {
        return this.atY;
    }

    public final float AY() {
        return this.atU;
    }

    public final void bI(int i) {
        this.weight = i;
    }

    public final void bk(boolean z) {
        this.success = z;
    }

    public final String getIp() {
        return this.ip;
    }

    public final int getWeight() {
        return this.weight;
    }

    public final void i(float f) {
        this.atU = f;
    }

    public final boolean isSuccess() {
        return this.success;
    }

    public final String toString() {
        return "PingNetEntity{ip='" + this.ip + "', pingCount=" + this.atY + ", pingWaitTime=" + this.atZ + ", pingTime='" + this.atU + " ms', success=" + this.success + '}';
    }
}
