package com.huawei.hms.ads;

import android.content.Context;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/du.class */
public class du {
    private static volatile ef Code;
    private static final byte[] V = new byte[0];

    public static ef Code(Context context) {
        if (Code == null) {
            synchronized (V) {
                if (Code == null) {
                    Code = dt.Z(context) ? ea.Code(context) : ec.Code(context);
                }
            }
        }
        return Code;
    }
}
