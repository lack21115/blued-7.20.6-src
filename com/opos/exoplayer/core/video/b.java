package com.opos.exoplayer.core.video;

import com.opos.exoplayer.core.i.k;
import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.o;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/video/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final List<byte[]> f11879a;
    public final int b;

    private b(List<byte[]> list, int i) {
        this.f11879a = list;
        this.b = i;
    }

    public static b a(m mVar) {
        try {
            mVar.d(21);
            int g = mVar.g();
            int g2 = mVar.g();
            int d = mVar.d();
            int i = 0;
            for (int i2 = 0; i2 < g2; i2++) {
                mVar.d(1);
                int h = mVar.h();
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < h) {
                        int h2 = mVar.h();
                        i += h2 + 4;
                        mVar.d(h2);
                        i3 = i4 + 1;
                    }
                }
            }
            mVar.c(d);
            byte[] bArr = new byte[i];
            int i5 = 0;
            for (int i6 = 0; i6 < g2; i6++) {
                mVar.d(1);
                int h3 = mVar.h();
                int i7 = 0;
                while (true) {
                    int i8 = i7;
                    if (i8 < h3) {
                        int h4 = mVar.h();
                        System.arraycopy(k.f11800a, 0, bArr, i5, k.f11800a.length);
                        int length = i5 + k.f11800a.length;
                        System.arraycopy(mVar.f11808a, mVar.d(), bArr, length, h4);
                        i5 = length + h4;
                        mVar.d(h4);
                        i7 = i8 + 1;
                    }
                }
            }
            return new b(i == 0 ? null : Collections.singletonList(bArr), (g & 3) + 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new o("Error parsing HEVC config", e);
        }
    }
}
