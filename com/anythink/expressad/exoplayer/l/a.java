package com.anythink.expressad.exoplayer.l;

import com.anythink.expressad.exoplayer.k.p;
import com.anythink.expressad.exoplayer.k.s;
import com.anythink.expressad.exoplayer.t;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/l/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final List<byte[]> f7691a;
    public final int b;

    /* renamed from: c  reason: collision with root package name */
    public final int f7692c;
    public final int d;
    public final float e;

    private a(List<byte[]> list, int i, int i2, int i3, float f) {
        this.f7691a = list;
        this.b = i;
        this.f7692c = i2;
        this.d = i3;
        this.e = f;
    }

    public static a a(s sVar) {
        int i;
        int i2;
        float f;
        try {
            sVar.d(4);
            int d = (sVar.d() & 3) + 1;
            if (d != 3) {
                ArrayList arrayList = new ArrayList();
                int d2 = sVar.d() & 31;
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= d2) {
                        break;
                    }
                    arrayList.add(b(sVar));
                    i3 = i4 + 1;
                }
                int d3 = sVar.d();
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    if (i6 >= d3) {
                        break;
                    }
                    arrayList.add(b(sVar));
                    i5 = i6 + 1;
                }
                if (d2 > 0) {
                    p.b a2 = p.a((byte[]) arrayList.get(0), d, ((byte[]) arrayList.get(0)).length);
                    i = a2.b;
                    i2 = a2.f7669c;
                    f = a2.d;
                } else {
                    i = -1;
                    i2 = -1;
                    f = 1.0f;
                }
                return new a(arrayList, d, i, i2, f);
            }
            throw new IllegalStateException();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new t("Error parsing AVC config", e);
        }
    }

    private static byte[] b(s sVar) {
        int e = sVar.e();
        int c2 = sVar.c();
        sVar.d(e);
        return com.anythink.expressad.exoplayer.k.d.a(sVar.f7674a, c2, e);
    }
}
