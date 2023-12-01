package com.opos.cmn.an.g;

import com.opos.cmn.an.g.e;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/g/h.class */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static e f24557a;
    private static final byte[] b = new byte[0];

    /* renamed from: c  reason: collision with root package name */
    private static AtomicLong f24558c = new AtomicLong(0);

    public static long a() {
        return f24558c.getAndIncrement();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.opos.cmn.an.g.g a(android.content.Context r6, long r7, com.opos.cmn.an.g.f r9) {
        /*
            Method dump skipped, instructions count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.an.g.h.a(android.content.Context, long, com.opos.cmn.an.g.f):com.opos.cmn.an.g.g");
    }

    public static void a(long j) {
        com.opos.cmn.an.f.a.b("NetTool", "shutDown taskCode=" + j);
        try {
            f24557a.f24545a.a(j);
            f24557a.b.a(j);
            f24557a.f24546c.a(j);
            f24557a.d.a(j);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("NetTool", "shutDown", e);
        }
    }

    private static void b() {
        if (f24557a == null) {
            synchronized (b) {
                if (f24557a == null) {
                    f24557a = new e.a().a(new com.opos.cmn.an.g.a.c.a()).a(new com.opos.cmn.an.g.a.b.a()).a(new com.opos.cmn.an.g.a.d.a()).a(new com.opos.cmn.an.g.a.e.a()).a();
                }
            }
        }
    }
}
