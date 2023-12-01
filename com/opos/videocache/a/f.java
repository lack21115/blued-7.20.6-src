package com.opos.videocache.a;

import java.io.File;

/* loaded from: source-8303388-dex2jar.jar:com/opos/videocache/a/f.class */
public class f extends d {

    /* renamed from: a  reason: collision with root package name */
    private final int f27433a;

    public f(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Max count must be positive number!");
        }
        this.f27433a = i;
    }

    @Override // com.opos.videocache.a.d
    protected boolean a(File file, long j, int i) {
        return i <= this.f27433a;
    }
}
