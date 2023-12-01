package com.huawei.hms.ads;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/km.class */
public abstract class km {
    public static boolean B(String str) {
        Integer Code = com.huawei.openalliance.ad.utils.av.Code(str, 14);
        return Code != null && 1 == Code.intValue();
    }

    public static int C(String str) {
        Integer Code = com.huawei.openalliance.ad.utils.av.Code(str, 15);
        if (Code != null) {
            return Code.intValue();
        }
        return 1;
    }

    public static boolean Code(String str) {
        Integer Code = com.huawei.openalliance.ad.utils.av.Code(str, 2);
        return (Code == null || Code.intValue() == 0) ? false : true;
    }

    public static int D(String str) {
        Integer Code = com.huawei.openalliance.ad.utils.av.Code(str, 1, 1);
        if (Code != null) {
            return Code.intValue();
        }
        return 0;
    }

    public static boolean F(String str) {
        Integer Code = com.huawei.openalliance.ad.utils.av.Code(str, 0, 1);
        boolean z = false;
        if (Code != null) {
            z = false;
            if (1 == Code.intValue()) {
                z = true;
            }
        }
        return z;
    }

    public static boolean I(String str) {
        Integer Code = com.huawei.openalliance.ad.utils.av.Code(str, 9);
        boolean z = true;
        if (Code != null) {
            if (1 == Code.intValue()) {
                return true;
            }
            z = false;
        }
        return z;
    }

    public static boolean L(String str) {
        Integer Code = com.huawei.openalliance.ad.utils.av.Code(str, 2, 1);
        return Code != null && Code.intValue() == 1;
    }

    public static int S(String str) {
        Integer Code = com.huawei.openalliance.ad.utils.av.Code(str, 20);
        if (Code != null) {
            return Code.intValue();
        }
        return 1;
    }

    public static boolean V(String str) {
        boolean z = false;
        Integer Code = com.huawei.openalliance.ad.utils.av.Code(str, 0);
        if (Code == null || 1 == Code.intValue()) {
            z = true;
        }
        return z;
    }

    public static boolean Z(String str) {
        Integer Code = com.huawei.openalliance.ad.utils.av.Code(str, 12);
        boolean z = false;
        if (Code == null) {
            return false;
        }
        if (1 == Code.intValue()) {
            z = true;
        }
        return z;
    }

    public static int a(String str) {
        Integer Code = com.huawei.openalliance.ad.utils.av.Code(str, 3, 1);
        if (Code == null) {
            return 0;
        }
        return Code.intValue();
    }

    public static boolean b(String str) {
        Integer Code = com.huawei.openalliance.ad.utils.av.Code(str, 4, 1);
        return Code != null && Code.intValue() == 1;
    }
}
