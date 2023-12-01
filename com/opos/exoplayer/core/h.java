package com.opos.exoplayer.core;

import java.io.IOException;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/h.class */
public final class h extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public final int f25440a;
    public final int b;

    private h(int i, String str, Throwable th, int i2) {
        super(str, th);
        this.f25440a = i;
        this.b = i2;
    }

    public static h a(IOException iOException) {
        return new h(0, null, iOException, -1);
    }

    public static h a(Exception exc, int i) {
        return new h(1, null, exc, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static h a(RuntimeException runtimeException) {
        return new h(2, null, runtimeException, -1);
    }
}
