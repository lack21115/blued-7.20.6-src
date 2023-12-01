package com.anythink.expressad.exoplayer.l;

import com.anythink.expressad.exoplayer.k.p;
import com.anythink.expressad.exoplayer.k.s;
import com.anythink.expressad.exoplayer.t;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/l/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final List<byte[]> f4860a;
    public final int b;

    private d(List<byte[]> list, int i) {
        this.f4860a = list;
        this.b = i;
    }

    public static d a(s sVar) {
        try {
            sVar.d(21);
            int d = sVar.d();
            int d2 = sVar.d();
            int c2 = sVar.c();
            int i = 0;
            for (int i2 = 0; i2 < d2; i2++) {
                sVar.d(1);
                int e = sVar.e();
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < e) {
                        int e2 = sVar.e();
                        i += e2 + 4;
                        sVar.d(e2);
                        i3 = i4 + 1;
                    }
                }
            }
            sVar.c(c2);
            byte[] bArr = new byte[i];
            int i5 = 0;
            for (int i6 = 0; i6 < d2; i6++) {
                sVar.d(1);
                int e3 = sVar.e();
                int i7 = 0;
                while (true) {
                    int i8 = i7;
                    if (i8 < e3) {
                        int e4 = sVar.e();
                        System.arraycopy(p.f4825a, 0, bArr, i5, p.f4825a.length);
                        int length = i5 + p.f4825a.length;
                        System.arraycopy(sVar.f4835a, sVar.c(), bArr, length, e4);
                        i5 = length + e4;
                        sVar.d(e4);
                        i7 = i8 + 1;
                    }
                }
            }
            return new d(i == 0 ? null : Collections.singletonList(bArr), (d & 3) + 1);
        } catch (ArrayIndexOutOfBoundsException e5) {
            throw new t("Error parsing HEVC config", e5);
        }
    }
}
