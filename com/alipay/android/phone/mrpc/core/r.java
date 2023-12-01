package com.alipay.android.phone.mrpc.core;

import java.io.Closeable;
import java.io.IOException;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/android/phone/mrpc/core/r.class */
public final class r {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }
}
