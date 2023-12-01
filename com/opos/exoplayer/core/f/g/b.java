package com.opos.exoplayer.core.f.g;

import com.opos.exoplayer.core.f.d;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f/g/b.class */
final class b implements d {

    /* renamed from: a  reason: collision with root package name */
    public static final b f25390a = new b();
    private final List<com.opos.exoplayer.core.f.b> b;

    private b() {
        this.b = Collections.emptyList();
    }

    public b(com.opos.exoplayer.core.f.b bVar) {
        this.b = Collections.singletonList(bVar);
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
        return j >= 0 ? this.b : Collections.emptyList();
    }
}
