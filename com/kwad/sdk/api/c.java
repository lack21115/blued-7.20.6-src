package com.kwad.sdk.api;

import com.kwad.sdk.api.core.IKsAdSDK;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/c.class */
public final class c {
    private static IKsAdSDK Zj;

    public static <T> T a(String str, Object... objArr) {
        try {
            T t = (T) Zj.dM(str, objArr);
            if (t != null) {
                return t;
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    public static void a(IKsAdSDK iKsAdSDK) {
        Zj = iKsAdSDK;
    }

    public static String aZ(String str) {
        return (String) a("TRANSFORM_API_HOST", str);
    }

    public static IKsAdSDK ti() {
        return Zj;
    }

    public static boolean tj() {
        Boolean bool = (Boolean) a("enableDynamic", new Object[0]);
        boolean z = false;
        if (bool != null) {
            z = false;
            if (!bool.booleanValue()) {
                z = true;
            }
        }
        return z;
    }

    public static int tk() {
        Integer num = (Integer) a("getAutoRevertTime", new Object[0]);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }
}
