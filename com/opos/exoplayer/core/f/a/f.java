package com.opos.exoplayer.core.f.a;

import java.util.Collections;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f/a/f.class */
final class f implements com.opos.exoplayer.core.f.d {

    /* renamed from: a  reason: collision with root package name */
    private final List<com.opos.exoplayer.core.f.b> f25343a;

    public f(List<com.opos.exoplayer.core.f.b> list) {
        this.f25343a = list;
    }

    @Override // com.opos.exoplayer.core.f.d
    public int a(long j) {
        return j < 0 ? 0 : -1;
    }

    @Override // com.opos.exoplayer.core.f.d
    public long a(int i) {
        com.opos.exoplayer.core.i.a.a(i == 0);
        return 0L;
    }

    @Override // com.opos.exoplayer.core.f.d
    public int b() {
        return 1;
    }

    @Override // com.opos.exoplayer.core.f.d
    public List<com.opos.exoplayer.core.f.b> b(long j) {
        return j >= 0 ? this.f25343a : Collections.emptyList();
    }
}
