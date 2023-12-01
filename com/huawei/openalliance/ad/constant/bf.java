package com.huawei.openalliance.ad.constant;

import com.huawei.hms.ads.ge;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/constant/bf.class */
public class bf {
    private static final String Code = "PlacementPlayState";
    private final byte[] I;
    private a V;

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/constant/bf$a.class */
    public enum a {
        SINGLE_INST,
        MAIN_VIEW,
        BACKUP_VIEW
    }

    public bf() {
        this.V = a.SINGLE_INST;
        this.I = new byte[0];
    }

    public bf(a aVar) {
        this.V = a.SINGLE_INST;
        this.I = new byte[0];
        this.V = aVar;
    }

    public a Code() {
        a aVar;
        synchronized (this.I) {
            aVar = this.V;
        }
        return aVar;
    }

    public void Code(a aVar) {
        if (aVar == null) {
            return;
        }
        synchronized (this.I) {
            ge.V(Code, "switch to state: %s", aVar);
            this.V = aVar;
        }
    }

    public boolean I(a aVar) {
        boolean z;
        synchronized (this.I) {
            z = !V(aVar);
        }
        return z;
    }

    public boolean V(a aVar) {
        boolean z;
        synchronized (this.I) {
            z = aVar == this.V;
        }
        return z;
    }
}
