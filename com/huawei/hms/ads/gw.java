package com.huawei.hms.ads;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/gw.class */
public class gw {
    private static final String Code = gw.class.getSimpleName();

    public static gv Code(int i, lh lhVar) {
        ge.V(Code, "create ad mediator: %s", Integer.valueOf(i));
        return (i == 2 || i == 3) ? new gy(lhVar) : new gx(lhVar);
    }
}
