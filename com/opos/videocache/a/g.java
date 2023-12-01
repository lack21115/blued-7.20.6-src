package com.opos.videocache.a;

import java.io.File;

/* loaded from: source-8303388-dex2jar.jar:com/opos/videocache/a/g.class */
public class g extends d {

    /* renamed from: a  reason: collision with root package name */
    private final long f27434a;

    public g(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("Max size must be positive number!");
        }
        this.f27434a = j;
    }

    @Override // com.opos.videocache.a.d
    protected boolean a(File file, long j, int i) {
        return j <= this.f27434a;
    }
}
