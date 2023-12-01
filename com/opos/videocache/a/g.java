package com.opos.videocache.a;

import java.io.File;

/* loaded from: source-8303388-dex2jar.jar:com/opos/videocache/a/g.class */
public class g extends d {

    /* renamed from: a  reason: collision with root package name */
    private final long f13746a;

    public g(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("Max size must be positive number!");
        }
        this.f13746a = j;
    }

    @Override // com.opos.videocache.a.d
    protected boolean a(File file, long j, int i) {
        return j <= this.f13746a;
    }
}
