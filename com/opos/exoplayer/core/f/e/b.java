package com.opos.exoplayer.core.f.e;

import com.opos.exoplayer.core.f.d;
import com.opos.exoplayer.core.i.u;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f/e/b.class */
final class b implements d {

    /* renamed from: a  reason: collision with root package name */
    private final com.opos.exoplayer.core.f.b[] f11686a;
    private final long[] b;

    public b(com.opos.exoplayer.core.f.b[] bVarArr, long[] jArr) {
        this.f11686a = bVarArr;
        this.b = jArr;
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
        com.opos.exoplayer.core.i.a.a(i >= 0);
        boolean z = false;
        if (i < this.b.length) {
            z = true;
        }
        com.opos.exoplayer.core.i.a.a(z);
        return this.b[i];
    }

    @Override // com.opos.exoplayer.core.f.d
    public int b() {
        return this.b.length;
    }

    @Override // com.opos.exoplayer.core.f.d
    public List<com.opos.exoplayer.core.f.b> b(long j) {
        int a2 = u.a(this.b, j, true, false);
        if (a2 != -1) {
            com.opos.exoplayer.core.f.b[] bVarArr = this.f11686a;
            if (bVarArr[a2] != null) {
                return Collections.singletonList(bVarArr[a2]);
            }
        }
        return Collections.emptyList();
    }
}
