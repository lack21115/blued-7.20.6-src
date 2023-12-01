package com.meizu.cloud.pushsdk.c.g;

import java.io.IOException;

/* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/c/g/f.class */
public abstract class f implements l {

    /* renamed from: a  reason: collision with root package name */
    private final l f10453a;

    public f(l lVar) {
        if (lVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f10453a = lVar;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.l
    public void a(b bVar, long j) throws IOException {
        this.f10453a.a(bVar, j);
    }

    @Override // com.meizu.cloud.pushsdk.c.g.l, java.io.Closeable, java.lang.AutoCloseable, com.meizu.cloud.pushsdk.c.g.m
    public void close() throws IOException {
        this.f10453a.close();
    }

    @Override // com.meizu.cloud.pushsdk.c.g.l, java.io.Flushable
    public void flush() throws IOException {
        this.f10453a.flush();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f10453a.toString() + ")";
    }
}
