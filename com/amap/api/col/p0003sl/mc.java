package com.amap.api.col.p0003sl;

/* renamed from: com.amap.api.col.3sl.mc  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/mc.class */
public final class mc extends nc {
    private static int a(nb nbVar) {
        return nbVar.b();
    }

    public static int a(nb nbVar, boolean z, long j, short s, int i, short s2, short s3) {
        nbVar.b(6);
        a(nbVar, j);
        a(nbVar, i);
        c(nbVar, s3);
        b(nbVar, s2);
        a(nbVar, s);
        a(nbVar, z);
        return a(nbVar);
    }

    private static void a(nb nbVar, int i) {
        nbVar.b(3, i);
    }

    private static void a(nb nbVar, long j) {
        nbVar.a(1, j);
    }

    private static void a(nb nbVar, short s) {
        nbVar.a(2, s);
    }

    private static void a(nb nbVar, boolean z) {
        nbVar.a(z);
    }

    private static void b(nb nbVar, short s) {
        nbVar.a(4, s);
    }

    private static void c(nb nbVar, short s) {
        nbVar.a(5, s);
    }
}
