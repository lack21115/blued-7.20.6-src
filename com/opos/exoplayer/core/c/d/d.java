package com.opos.exoplayer.core.c.d;

import java.util.UUID;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/d/d.class */
public final class d {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/d/d$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final UUID f25122a;
        private final int b;

        /* renamed from: c  reason: collision with root package name */
        private final byte[] f25123c;

        public a(UUID uuid, int i, byte[] bArr) {
            this.f25122a = uuid;
            this.b = i;
            this.f25123c = bArr;
        }
    }

    public static UUID a(byte[] bArr) {
        a b = b(bArr);
        if (b == null) {
            return null;
        }
        return b.f25122a;
    }

    private static a b(byte[] bArr) {
        com.opos.exoplayer.core.i.m mVar = new com.opos.exoplayer.core.i.m(bArr);
        if (mVar.c() < 32) {
            return null;
        }
        mVar.c(0);
        if (mVar.o() == mVar.b() + 4 && mVar.o() == g.U) {
            int a2 = g.a(mVar.o());
            if (a2 > 1) {
                com.opos.cmn.an.f.a.c("PsshAtomUtil", "Unsupported pssh version: " + a2);
                return null;
            }
            UUID uuid = new UUID(mVar.q(), mVar.q());
            if (a2 == 1) {
                mVar.d(mVar.u() * 16);
            }
            int u = mVar.u();
            if (u == mVar.b()) {
                byte[] bArr2 = new byte[u];
                mVar.a(bArr2, 0, u);
                return new a(uuid, a2, bArr2);
            }
            return null;
        }
        return null;
    }
}
