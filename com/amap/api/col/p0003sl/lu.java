package com.amap.api.col.p0003sl;

/* renamed from: com.amap.api.col.3sl.lu  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/lu.class */
public final class lu extends nc {
    private static int a(nb nbVar) {
        return nbVar.b();
    }

    public static int a(nb nbVar, byte b, int i) {
        nbVar.b(2);
        a(nbVar, i);
        a(nbVar, b);
        return a(nbVar);
    }

    public static int a(nb nbVar, byte[] bArr) {
        nbVar.a(1, bArr.length, 1);
        int length = bArr.length;
        while (true) {
            int i = length - 1;
            if (i < 0) {
                return nbVar.a();
            }
            nbVar.a(bArr[i]);
            length = i;
        }
    }

    private static void a(nb nbVar, byte b) {
        nbVar.a(0, b);
    }

    private static void a(nb nbVar, int i) {
        nbVar.b(1, i);
    }
}
