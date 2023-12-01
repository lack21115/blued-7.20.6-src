package com.amap.api.col.p0003sl;

/* renamed from: com.amap.api.col.3sl.mb  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/mb.class */
public final class mb extends nc {
    private static int a(nb nbVar) {
        return nbVar.b();
    }

    public static int a(nb nbVar, int i) {
        nbVar.b(1);
        b(nbVar, i);
        return a(nbVar);
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

    private static void b(nb nbVar, int i) {
        nbVar.b(0, i);
    }
}
