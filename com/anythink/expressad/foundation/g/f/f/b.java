package com.anythink.expressad.foundation.g.f.f;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/f/f/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final int f5057a;
    private final List<com.anythink.expressad.foundation.g.f.c.c> b;

    /* renamed from: c  reason: collision with root package name */
    private final InputStream f5058c;

    public b(int i, List<com.anythink.expressad.foundation.g.f.c.c> list) {
        this(i, list, null);
    }

    public b(int i, List<com.anythink.expressad.foundation.g.f.c.c> list, InputStream inputStream) {
        this.f5057a = i;
        this.b = list;
        this.f5058c = inputStream;
    }

    public final int a() {
        return this.f5057a;
    }

    public final List<com.anythink.expressad.foundation.g.f.c.c> b() {
        return Collections.unmodifiableList(this.b);
    }

    public final InputStream c() {
        return this.f5058c;
    }
}
