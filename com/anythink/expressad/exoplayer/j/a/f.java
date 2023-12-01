package com.anythink.expressad.exoplayer.j.a;

import android.net.Uri;
import com.anythink.expressad.exoplayer.j.a.a;
import com.anythink.expressad.exoplayer.k.v;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/a/f.class */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final int f7559a = 131072;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/a/f$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public volatile long f7560a;
        public volatile long b;

        /* renamed from: c  reason: collision with root package name */
        public volatile long f7561c = -1;

        private long a() {
            return this.f7560a + this.b;
        }
    }

    private f() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00eb, code lost:
        com.anythink.expressad.exoplayer.k.af.a(r19);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00f0, code lost:
        return r24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static long a(com.anythink.expressad.exoplayer.j.k r14, long r15, long r17, com.anythink.expressad.exoplayer.j.h r19, byte[] r20, com.anythink.expressad.exoplayer.k.v r21, com.anythink.expressad.exoplayer.j.a.f.a r22) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.j.a.f.a(com.anythink.expressad.exoplayer.j.k, long, long, com.anythink.expressad.exoplayer.j.h, byte[], com.anythink.expressad.exoplayer.k.v, com.anythink.expressad.exoplayer.j.a.f$a):long");
    }

    private static String a(Uri uri) {
        return uri.toString();
    }

    public static String a(com.anythink.expressad.exoplayer.j.k kVar) {
        return kVar.h != null ? kVar.h : kVar.f7584c.toString();
    }

    private static void a(com.anythink.expressad.exoplayer.j.a.a aVar, String str) {
        for (e eVar : aVar.a(str)) {
            try {
                aVar.b(eVar);
            } catch (a.C0138a e) {
            }
        }
    }

    private static void a(com.anythink.expressad.exoplayer.j.k kVar, com.anythink.expressad.exoplayer.j.a.a aVar, c cVar, byte[] bArr, v vVar, a aVar2, AtomicBoolean atomicBoolean) {
        com.anythink.expressad.exoplayer.k.a.a(cVar);
        com.anythink.expressad.exoplayer.k.a.a(bArr);
        if (aVar2 != null) {
            String a2 = a(kVar);
            long j = kVar.e;
            long b = kVar.g != -1 ? kVar.g : aVar.b(a2);
            aVar2.f7561c = b;
            aVar2.f7560a = 0L;
            aVar2.b = 0L;
            while (b != 0) {
                int i = (b > (-1L) ? 1 : (b == (-1L) ? 0 : -1));
                long b2 = aVar.b(a2, j, i != 0 ? b : Long.MAX_VALUE);
                if (b2 <= 0) {
                    b2 = -b2;
                    if (b2 == Long.MAX_VALUE) {
                        break;
                    }
                } else {
                    aVar2.f7560a += b2;
                }
                j += b2;
                if (i == 0) {
                    b2 = 0;
                }
                b -= b2;
            }
        } else {
            aVar2 = new a();
        }
        String a3 = a(kVar);
        long j2 = kVar.e;
        long b3 = kVar.g != -1 ? kVar.g : aVar.b(a3);
        while (b3 != 0) {
            if (atomicBoolean != null && atomicBoolean.get()) {
                throw new InterruptedException();
            }
            int i2 = (b3 > (-1L) ? 1 : (b3 == (-1L) ? 0 : -1));
            long b4 = aVar.b(a3, j2, i2 != 0 ? b3 : Long.MAX_VALUE);
            if (b4 <= 0) {
                b4 = -b4;
                if (a(kVar, j2, b4, cVar, bArr, vVar, aVar2) < b4) {
                    return;
                }
            }
            j2 += b4;
            if (i2 == 0) {
                b4 = 0;
            }
            b3 -= b4;
        }
    }

    private static void a(com.anythink.expressad.exoplayer.j.k kVar, com.anythink.expressad.exoplayer.j.a.a aVar, a aVar2) {
        String a2 = a(kVar);
        long j = kVar.e;
        long b = kVar.g != -1 ? kVar.g : aVar.b(a2);
        aVar2.f7561c = b;
        aVar2.f7560a = 0L;
        aVar2.b = 0L;
        while (b != 0) {
            int i = (b > (-1L) ? 1 : (b == (-1L) ? 0 : -1));
            long b2 = aVar.b(a2, j, i != 0 ? b : Long.MAX_VALUE);
            if (b2 > 0) {
                aVar2.f7560a += b2;
            } else {
                long j2 = -b2;
                b2 = j2;
                if (j2 == Long.MAX_VALUE) {
                    return;
                }
            }
            j += b2;
            if (i == 0) {
                b2 = 0;
            }
            b -= b2;
        }
    }

    private static void a(com.anythink.expressad.exoplayer.j.k kVar, com.anythink.expressad.exoplayer.j.a.a aVar, com.anythink.expressad.exoplayer.j.h hVar, a aVar2, AtomicBoolean atomicBoolean) {
        a aVar3;
        c cVar = new c(aVar, hVar);
        byte[] bArr = new byte[131072];
        com.anythink.expressad.exoplayer.k.a.a(cVar);
        com.anythink.expressad.exoplayer.k.a.a(bArr);
        if (aVar2 != null) {
            String a2 = a(kVar);
            long j = kVar.e;
            long b = kVar.g != -1 ? kVar.g : aVar.b(a2);
            aVar2.f7561c = b;
            aVar2.f7560a = 0L;
            aVar2.b = 0L;
            while (b != 0) {
                int i = (b > (-1L) ? 1 : (b == (-1L) ? 0 : -1));
                long b2 = aVar.b(a2, j, i != 0 ? b : Long.MAX_VALUE);
                if (b2 <= 0) {
                    b2 = -b2;
                    if (b2 == Long.MAX_VALUE) {
                        break;
                    }
                } else {
                    aVar2.f7560a += b2;
                }
                j += b2;
                if (i == 0) {
                    b2 = 0;
                }
                b -= b2;
            }
            aVar3 = aVar2;
        } else {
            aVar3 = new a();
        }
        String a3 = a(kVar);
        long j2 = kVar.e;
        long b3 = kVar.g != -1 ? kVar.g : aVar.b(a3);
        while (b3 != 0) {
            if (atomicBoolean != null && atomicBoolean.get()) {
                throw new InterruptedException();
            }
            int i2 = (b3 > (-1L) ? 1 : (b3 == (-1L) ? 0 : -1));
            long b4 = aVar.b(a3, j2, i2 != 0 ? b3 : Long.MAX_VALUE);
            if (b4 <= 0) {
                b4 = -b4;
                if (a(kVar, j2, b4, cVar, bArr, (v) null, aVar3) < b4) {
                    return;
                }
            }
            j2 += b4;
            if (i2 == 0) {
                b4 = 0;
            }
            b3 -= b4;
        }
    }
}
