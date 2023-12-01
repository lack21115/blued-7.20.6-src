package com.kwad.components.ad.reward.b;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/b/b.class */
public class b extends com.kwad.sdk.core.response.kwai.a {
    public static int STATUS_NONE = 2;
    public static int rq = 1;
    public static int rr = 3;
    public int rs;
    public int rt;

    public b() {
        this.rs = STATUS_NONE;
    }

    public b(int i) {
        this.rs = STATUS_NONE;
        this.rs = 1;
    }

    public final void O(int i) {
        this.rt = i;
    }

    public final int gT() {
        return this.rt;
    }

    public final int getType() {
        return this.rs;
    }
}
