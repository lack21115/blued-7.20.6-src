package com.tencent.liteav.base;

import android.os.StrictMode;
import java.io.Closeable;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/b.class */
public final class b implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final StrictMode.ThreadPolicy f22590a;
    private final StrictMode.VmPolicy b;

    private b(StrictMode.ThreadPolicy threadPolicy) {
        this.f22590a = threadPolicy;
        this.b = null;
    }

    private b(StrictMode.ThreadPolicy threadPolicy, byte b) {
        this(threadPolicy);
    }

    public static b a() {
        return new b(StrictMode.allowThreadDiskWrites(), (byte) 0);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        StrictMode.ThreadPolicy threadPolicy = this.f22590a;
        if (threadPolicy != null) {
            StrictMode.setThreadPolicy(threadPolicy);
        }
        StrictMode.VmPolicy vmPolicy = this.b;
        if (vmPolicy != null) {
            StrictMode.setVmPolicy(vmPolicy);
        }
    }
}
