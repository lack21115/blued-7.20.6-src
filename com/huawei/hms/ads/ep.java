package com.huawei.hms.ads;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/ep.class */
public abstract class ep {
    private static final byte[] I = new byte[0];
    private static com.huawei.openalliance.ad.inter.data.n V;

    public static com.huawei.openalliance.ad.inter.data.n Code() {
        com.huawei.openalliance.ad.inter.data.n nVar;
        synchronized (I) {
            nVar = V;
        }
        return nVar;
    }

    public static void Code(com.huawei.openalliance.ad.inter.data.n nVar) {
        synchronized (I) {
            if (nVar == null) {
                ge.Code("GlobalDataShare", "set native ad null");
                V = null;
            } else {
                V = nVar;
            }
        }
    }
}
