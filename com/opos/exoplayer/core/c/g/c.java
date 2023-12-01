package com.opos.exoplayer.core.c.g;

import com.opos.exoplayer.core.c.f;
import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.i.u;
import com.opos.exoplayer.core.o;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/g/c.class */
final class c {

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/g/c$a.class */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f25244a;
        public final long b;

        private a(int i, long j) {
            this.f25244a = i;
            this.b = j;
        }

        public static a a(f fVar, m mVar) {
            fVar.c(mVar.f25496a, 0, 8);
            mVar.c(0);
            return new a(mVar.o(), mVar.n());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0151  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.opos.exoplayer.core.c.g.b a(com.opos.exoplayer.core.c.f r9) {
        /*
            Method dump skipped, instructions count: 417
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.c.g.c.a(com.opos.exoplayer.core.c.f):com.opos.exoplayer.core.c.g.b");
    }

    public static void a(f fVar, b bVar) {
        com.opos.exoplayer.core.i.a.a(fVar);
        com.opos.exoplayer.core.i.a.a(bVar);
        fVar.a();
        m mVar = new m(8);
        while (true) {
            a a2 = a.a(fVar, mVar);
            if (a2.f25244a == u.f("data")) {
                fVar.b(8);
                bVar.a(fVar.c(), a2.b);
                return;
            }
            com.opos.cmn.an.f.a.c("WavHeaderReader", "Ignoring unknown WAV chunk: " + a2.f25244a);
            long j = a2.b + 8;
            if (a2.f25244a == u.f("RIFF")) {
                j = 12;
            }
            if (j > 2147483647L) {
                throw new o("Chunk is too large (~2GB+) to skip; id: " + a2.f25244a);
            }
            fVar.b((int) j);
        }
    }
}
