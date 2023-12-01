package com.huawei.hms.ads;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/eo.class */
public abstract class eo {
    private static final byte[] I = new byte[0];
    private static com.huawei.openalliance.ad.inter.data.i V;

    public static com.huawei.openalliance.ad.inter.data.i Code() {
        com.huawei.openalliance.ad.inter.data.i iVar;
        synchronized (I) {
            iVar = V;
        }
        return iVar;
    }

    public static void Code(com.huawei.openalliance.ad.inter.data.i iVar) {
        synchronized (I) {
            if (iVar == null) {
                ge.Code("GlobalDataShare", "set reward ad null");
                V = null;
            } else {
                V = iVar;
            }
        }
    }
}
