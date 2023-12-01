package com.anythink.expressad.exoplayer.k;

import java.io.BufferedOutputStream;
import java.io.OutputStream;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/k/x.class */
public final class x extends BufferedOutputStream {

    /* renamed from: a  reason: collision with root package name */
    private boolean f7682a;

    public x(OutputStream outputStream) {
        super(outputStream);
    }

    public x(OutputStream outputStream, int i) {
        super(outputStream, i);
    }

    public final void a(OutputStream outputStream) {
        a.b(this.f7682a);
        this.out = outputStream;
        this.count = 0;
        this.f7682a = false;
    }

    @Override // java.io.BufferedOutputStream, java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Throwable th;
        this.f7682a = true;
        try {
            flush();
            th = null;
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.out.close();
            th = th;
        } catch (Throwable th3) {
            th = th;
            if (th == null) {
                th = th3;
            }
        }
        if (th != null) {
            af.a(th);
        }
    }
}
