package com.tencent.mapsdk.internal;

import java.io.InputStream;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ib.class */
public abstract class ib {

    /* renamed from: a  reason: collision with root package name */
    private boolean f23861a;

    public void a() {
    }

    public void a(boolean z) {
        synchronized (this) {
            this.f23861a = z;
        }
    }

    public byte[] a(byte[] bArr) {
        return null;
    }

    public boolean b() {
        boolean z;
        synchronized (this) {
            z = this.f23861a;
        }
        return z;
    }

    public byte[] e(String str) {
        return null;
    }

    public InputStream f(String str) {
        return null;
    }
}
