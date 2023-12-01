package com.opos.exoplayer.core.video;

import com.opos.exoplayer.core.i.k;
import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.o;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/video/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final List<byte[]> f11877a;
    public final int b;

    /* renamed from: c  reason: collision with root package name */
    public final int f11878c;
    public final int d;
    public final float e;

    private a(List<byte[]> list, int i, int i2, int i3, float f) {
        this.f11877a = list;
        this.b = i;
        this.f11878c = i2;
        this.d = i3;
        this.e = f;
    }

    public static a a(m mVar) {
        int i;
        int i2;
        float f;
        try {
            mVar.d(4);
            int g = (mVar.g() & 3) + 1;
            if (g != 3) {
                ArrayList arrayList = new ArrayList();
                int g2 = mVar.g() & 31;
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= g2) {
                        break;
                    }
                    arrayList.add(b(mVar));
                    i3 = i4 + 1;
                }
                int g3 = mVar.g();
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    if (i6 >= g3) {
                        break;
                    }
                    arrayList.add(b(mVar));
                    i5 = i6 + 1;
                }
                if (g2 > 0) {
                    k.b a2 = k.a((byte[]) arrayList.get(0), g, ((byte[]) arrayList.get(0)).length);
                    i = a2.b;
                    i2 = a2.f11805c;
                    f = a2.d;
                } else {
                    i = -1;
                    i2 = -1;
                    f = 1.0f;
                }
                return new a(arrayList, g, i, i2, f);
            }
            throw new IllegalStateException();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new o("Error parsing AVC config", e);
        }
    }

    private static byte[] b(m mVar) {
        int h = mVar.h();
        int d = mVar.d();
        mVar.d(h);
        return com.opos.exoplayer.core.i.c.a(mVar.f11808a, d, h);
    }
}
