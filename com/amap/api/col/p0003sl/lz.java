package com.amap.api.col.p0003sl;

/* renamed from: com.amap.api.col.3sl.lz  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/lz.class */
public final class lz extends nc {
    public static int a(nb nbVar, int i, int i2, short s) {
        nbVar.b(4);
        b(nbVar, i2);
        a(nbVar, i);
        a(nbVar, s);
        a(nbVar);
        return b(nbVar);
    }

    private static void a(nb nbVar) {
        nbVar.a(0, (byte) 1);
    }

    private static void a(nb nbVar, int i) {
        nbVar.a(1, i);
    }

    private static void a(nb nbVar, short s) {
        nbVar.a(3, s);
    }

    private static int b(nb nbVar) {
        return nbVar.b();
    }

    private static void b(nb nbVar, int i) {
        nbVar.a(2, i);
    }
}
