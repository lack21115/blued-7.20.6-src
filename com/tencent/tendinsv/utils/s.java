package com.tencent.tendinsv.utils;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/utils/s.class */
public class s {
    static {
        try {
            System.loadLibrary("ShanYCore");
        } catch (Throwable th) {
            l.d(com.tencent.tendinsv.b.F, "loadLibrary failed=", th.getMessage());
        }
    }

    public static native boolean n(Object obj);
}
