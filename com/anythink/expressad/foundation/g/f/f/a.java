package com.anythink.expressad.foundation.g.f.f;

import com.anythink.expressad.foundation.g.f.g;
import com.anythink.expressad.foundation.g.f.i;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.video.module.a.a.m;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/f/f/a.class */
public class a implements g {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5055a = a.class.getSimpleName();
    private static final int b = 3000;

    /* renamed from: c  reason: collision with root package name */
    private com.anythink.expressad.foundation.g.f.e.a f5056c;
    private com.anythink.expressad.foundation.g.f.c d;

    public a(com.anythink.expressad.foundation.g.f.e.a aVar, com.anythink.expressad.foundation.g.f.c cVar) {
        this.f5056c = aVar;
        this.d = cVar;
    }

    private static void a(long j, i<?> iVar, byte[] bArr, int i) {
        if (com.anythink.expressad.a.f4103a) {
            Integer num = com.igexin.push.core.b.l;
            if (j > m.ag) {
                try {
                    String str = f5055a;
                    String d = iVar.d();
                    int a2 = iVar.a();
                    if (bArr != null) {
                        num = Integer.valueOf(bArr.length);
                    }
                    o.b(str, String.format("Slow HTTP response for request=<%s> [method=%s] [lifetime=%d], [size=%s], [statusCode=%d], [retryCount=%s]", d, Integer.valueOf(a2), Long.valueOf(j), num, Integer.valueOf(i), Integer.valueOf(iVar.l().c())));
                    return;
                } catch (Exception e) {
                    return;
                }
            }
            try {
                String str2 = f5055a;
                String d2 = iVar.d();
                int a3 = iVar.a();
                if (bArr != null) {
                    num = Integer.valueOf(bArr.length);
                }
                o.b(str2, String.format("Normal HTTP response for request=<%s> [method=%s] [lifetime=%d], [size=%s], [statusCode=%d], [retryCount=%s]", d2, Integer.valueOf(a3), Long.valueOf(j), num, Integer.valueOf(i), Integer.valueOf(iVar.l().c())));
            } catch (Exception e2) {
            }
        }
    }

    private void a(i<?> iVar, com.anythink.expressad.foundation.g.f.a.a aVar) {
        if (!iVar.l().d()) {
            throw aVar;
        }
        this.d.e(iVar);
    }

    private static void a(String str, long j, i<?> iVar) {
        if (com.anythink.expressad.a.f4103a) {
            try {
                String str2 = f5055a;
                String d = iVar.d();
                if (str == null) {
                    str = com.igexin.push.core.b.l;
                }
                o.b(str2, String.format("HTTP exception for request=<%s> [lifetime=%d], [size=%s], [retryCount=%s]", d, Long.valueOf(j), str, Integer.valueOf(iVar.l().c())));
            } catch (Exception e) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x03bd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x012f  */
    @Override // com.anythink.expressad.foundation.g.f.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.anythink.expressad.foundation.g.f.f.c a(com.anythink.expressad.foundation.g.f.i<?> r7) {
        /*
            Method dump skipped, instructions count: 1309
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.foundation.g.f.f.a.a(com.anythink.expressad.foundation.g.f.i):com.anythink.expressad.foundation.g.f.f.c");
    }
}
