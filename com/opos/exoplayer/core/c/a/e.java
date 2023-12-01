package com.opos.exoplayer.core.c.a;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.a.b;
import com.opos.exoplayer.core.c.n;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.i.k;
import com.opos.exoplayer.core.i.m;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/a/e.class */
final class e extends b {
    private final m b;

    /* renamed from: c  reason: collision with root package name */
    private final m f25085c;
    private int d;
    private boolean e;
    private int f;

    public e(n nVar) {
        super(nVar);
        this.b = new m(k.f25488a);
        this.f25085c = new m(4);
    }

    @Override // com.opos.exoplayer.core.c.a.b
    protected boolean a(m mVar) {
        int g = mVar.g();
        int i = (g >> 4) & 15;
        int i2 = g & 15;
        if (i2 == 7) {
            this.f = i;
            return i != 5;
        }
        throw new b.a("Video format not supported: " + i2);
    }

    @Override // com.opos.exoplayer.core.c.a.b
    protected void b(m mVar, long j) {
        int i;
        int g = mVar.g();
        long l = mVar.l();
        if (g == 0 && !this.e) {
            m mVar2 = new m(new byte[mVar.b()]);
            mVar.a(mVar2.f25496a, 0, mVar.b());
            com.opos.exoplayer.core.video.a a2 = com.opos.exoplayer.core.video.a.a(mVar2);
            this.d = a2.b;
            this.f25083a.a(Format.a((String) null, "video/avc", (String) null, -1, -1, a2.f25566c, a2.d, -1.0f, a2.f25565a, -1, a2.e, (DrmInitData) null));
            this.e = true;
        } else if (g == 1 && this.e) {
            byte[] bArr = this.f25085c.f25496a;
            byte b = (byte) 0;
            bArr[0] = b;
            bArr[1] = b;
            bArr[2] = b;
            int i2 = this.d;
            int i3 = 0;
            while (true) {
                i = i3;
                if (mVar.b() <= 0) {
                    break;
                }
                mVar.a(this.f25085c.f25496a, 4 - i2, this.d);
                this.f25085c.c(0);
                int u = this.f25085c.u();
                this.b.c(0);
                this.f25083a.a(this.b, 4);
                this.f25083a.a(mVar, u);
                i3 = i + 4 + u;
            }
            this.f25083a.a((l * 1000) + j, this.f == 1 ? 1 : 0, i, 0, null);
        }
    }
}
