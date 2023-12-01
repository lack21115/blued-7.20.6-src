package com.opos.exoplayer.core.f.f;

import com.opos.exoplayer.core.i.u;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f/f/f.class */
final class f implements com.opos.exoplayer.core.f.d {

    /* renamed from: a  reason: collision with root package name */
    private final c f11697a;
    private final long[] b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, b> f11698c;
    private final Map<String, d> d;

    public f(c cVar, Map<String, b> map, Map<String, d> map2) {
        this.f11697a = cVar;
        this.d = map2;
        this.f11698c = map != null ? Collections.unmodifiableMap(map) : Collections.emptyMap();
        this.b = cVar.b();
    }

    @Override // com.opos.exoplayer.core.f.d
    public int a(long j) {
        int b = u.b(this.b, j, false, false);
        if (b < this.b.length) {
            return b;
        }
        return -1;
    }

    @Override // com.opos.exoplayer.core.f.d
    public long a(int i) {
        return this.b[i];
    }

    @Override // com.opos.exoplayer.core.f.d
    public int b() {
        return this.b.length;
    }

    @Override // com.opos.exoplayer.core.f.d
    public List<com.opos.exoplayer.core.f.b> b(long j) {
        return this.f11697a.a(j, this.f11698c, this.d);
    }
}
