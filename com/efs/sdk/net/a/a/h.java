package com.efs.sdk.net.a.a;

import java.io.ByteArrayOutputStream;

/* loaded from: source-8110460-dex2jar.jar:com/efs/sdk/net/a/a/h.class */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final f f21840a;
    public ByteArrayOutputStream b;

    /* renamed from: c  reason: collision with root package name */
    public a f21841c;
    private final String d;

    public h(f fVar, String str) {
        this.f21840a = fVar;
        this.d = str;
    }

    public final boolean a() {
        return this.b != null;
    }

    public final void b() {
        if (!a()) {
            throw new IllegalStateException("No body found; has createBodySink been called?");
        }
    }
}
