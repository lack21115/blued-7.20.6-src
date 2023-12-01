package com.amap.api.col.p0003sl;

/* renamed from: com.amap.api.col.3sl.lp  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/lp.class */
public final class lp extends nc {
    private static int a(nb nbVar) {
        return nbVar.b();
    }

    public static int a(nb nbVar, int i, int i2, int i3) {
        nbVar.b(3);
        c(nbVar, i3);
        b(nbVar, i2);
        a(nbVar, i);
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

    public static int a(nb nbVar, int[] iArr) {
        nbVar.a(4, iArr.length, 4);
        int length = iArr.length;
        while (true) {
            int i = length - 1;
            if (i < 0) {
                return nbVar.a();
            }
            nbVar.a(iArr[i]);
            length = i;
        }
    }

    private static void a(nb nbVar, int i) {
        nbVar.b(0, i);
    }

    public static int b(nb nbVar, byte[] bArr) {
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

    private static void b(nb nbVar, int i) {
        nbVar.b(1, i);
    }

    private static void c(nb nbVar, int i) {
        nbVar.b(2, i);
    }
}
