package com.huawei.openalliance.ad.inter;

import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.r;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/inter/b.class */
public class b {
    private static final String Code = "AdATManager";
    private static b I;
    private static final byte[] V = new byte[0];
    private String B;
    private r Z;

    private b() {
    }

    public static b Code() {
        b bVar;
        synchronized (V) {
            if (I == null) {
                I = new b();
            }
            bVar = I;
        }
        return bVar;
    }

    public void Code(r rVar) {
        this.Z = rVar;
    }

    public void Code(String str) {
        this.B = str;
    }

    public String I() {
        return this.B;
    }

    public String V() {
        r rVar = this.Z;
        if (rVar == null) {
            ge.V(Code, "accessTokenProvider is null, return");
            return null;
        }
        return rVar.Code();
    }
}
