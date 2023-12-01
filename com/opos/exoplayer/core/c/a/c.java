package com.opos.exoplayer.core.c.a;

import android.util.Pair;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.a.b;
import com.opos.exoplayer.core.c.n;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.i.m;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/a/c.class */
final class c extends b {
    private static final int[] b = {5512, 11025, 22050, 44100};

    /* renamed from: c  reason: collision with root package name */
    private boolean f11396c;
    private boolean d;
    private int e;

    public c(n nVar) {
        super(nVar);
    }

    @Override // com.opos.exoplayer.core.c.a.b
    protected boolean a(m mVar) {
        Format a2;
        if (this.f11396c) {
            mVar.d(1);
            return true;
        }
        int g = mVar.g();
        int i = (g >> 4) & 15;
        this.e = i;
        if (i == 2) {
            a2 = Format.a(null, "audio/mpeg", null, -1, -1, 1, b[(g >> 2) & 3], null, null, 0, null);
        } else if (i != 7 && i != 8) {
            if (i != 10) {
                throw new b.a("Audio format not supported: " + this.e);
            }
            this.f11396c = true;
            return true;
        } else {
            a2 = Format.a((String) null, this.e == 7 ? "audio/g711-alaw" : "audio/g711-mlaw", (String) null, -1, -1, 1, 8000, (g & 1) == 1 ? 2 : 3, (List<byte[]>) null, (DrmInitData) null, 0, (String) null);
        }
        this.f11395a.a(a2);
        this.d = true;
        this.f11396c = true;
        return true;
    }

    @Override // com.opos.exoplayer.core.c.a.b
    protected void b(m mVar, long j) {
        if (this.e == 2) {
            int b2 = mVar.b();
            this.f11395a.a(mVar, b2);
            this.f11395a.a(j, 1, b2, 0, null);
            return;
        }
        int g = mVar.g();
        if (g != 0 || this.d) {
            if (this.e != 10 || g == 1) {
                int b3 = mVar.b();
                this.f11395a.a(mVar, b3);
                this.f11395a.a(j, 1, b3, 0, null);
                return;
            }
            return;
        }
        int b4 = mVar.b();
        byte[] bArr = new byte[b4];
        mVar.a(bArr, 0, b4);
        Pair<Integer, Integer> a2 = com.opos.exoplayer.core.i.c.a(bArr);
        this.f11395a.a(Format.a(null, "audio/mp4a-latm", null, -1, -1, a2.second.intValue(), a2.first.intValue(), Collections.singletonList(bArr), null, 0, null));
        this.d = true;
    }
}
