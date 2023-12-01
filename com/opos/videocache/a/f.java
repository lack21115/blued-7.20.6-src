package com.opos.videocache.a;

import java.io.File;

/* loaded from: source-8303388-dex2jar.jar:com/opos/videocache/a/f.class */
public class f extends d {

    /* renamed from: a  reason: collision with root package name */
    private final int f13745a;

    public f(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Max count must be positive number!");
        }
        this.f13745a = i;
    }

    @Override // com.opos.videocache.a.d
    protected boolean a(File file, long j, int i) {
        return i <= this.f13745a;
    }
}
