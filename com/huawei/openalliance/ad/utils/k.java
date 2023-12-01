package com.huawei.openalliance.ad.utils;

import android.content.Context;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/k.class */
public class k {
    private static final String B = "com.huawei.software.features.mobiletv";
    private static final String C = "com.huawei.software.features.watch";
    private static final String Code = "DeviceTypeUtil";
    private static final String D = "com.hihonor.software.features.pad";
    private static final String F = "com.hihonor.software.features.handset";
    private static final String I = "com.huawei.software.features.pad";
    private static final String L = "com.hihonor.software.features.tv";
    private static final String S = "com.huawei.software.features.kidwatch";
    private static final String V = "com.huawei.software.features.handset";
    private static final String Z = "com.huawei.software.features.tv";

    /* renamed from: a  reason: collision with root package name */
    private static final String f22998a = "com.hihonor.software.features.mobiletv";
    private static final String b = "com.hihonor.software.features.watch";

    /* renamed from: c  reason: collision with root package name */
    private static final String f22999c = "com.hihonor.software.features.kidwatch";
    private static final String d = "default";
    private static final String e = "tablet";
    private static final String f = "tv";
    private static k g;
    private static final byte[] h = new byte[0];
    private Context i;
    private String j = "0";

    private k(Context context) {
        this.i = context.getApplicationContext();
        Z();
    }

    public static k Code(Context context) {
        return V(context);
    }

    private static k V(Context context) {
        k kVar;
        synchronized (h) {
            if (g == null) {
                g = new k(context);
            }
            kVar = g;
        }
        return kVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x015d, code lost:
        if (r0.equals(com.huawei.openalliance.ad.utils.k.f) != false) goto L59;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void Z() {
        /*
            Method dump skipped, instructions count: 479
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.utils.k.Z():void");
    }

    public String Code() {
        return this.j;
    }

    public int I() {
        if ("4".equalsIgnoreCase(this.j)) {
            return 8;
        }
        return "1".equalsIgnoreCase(this.j) ? 5 : 4;
    }

    public boolean V() {
        return "4".equalsIgnoreCase(Code(this.i).Code());
    }
}
