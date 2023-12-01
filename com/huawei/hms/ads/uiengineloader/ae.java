package com.huawei.hms.ads.uiengineloader;

import java.io.Closeable;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/uiengineloader/ae.class */
public abstract class ae {

    /* renamed from: a  reason: collision with root package name */
    public static final String f8934a = "StreamUtil";

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                aa.c(f8934a, "close exception");
            }
        }
    }
}
