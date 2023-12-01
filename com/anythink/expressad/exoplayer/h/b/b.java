package com.anythink.expressad.exoplayer.h.b;

import android.util.Log;
import com.anythink.expressad.exoplayer.e.m;
import com.anythink.expressad.exoplayer.h.b.d;
import com.anythink.expressad.exoplayer.h.x;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/b/b.class */
public final class b implements d.b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4584a = "BaseMediaChunkOutput";
    private final int[] b;

    /* renamed from: c  reason: collision with root package name */
    private final x[] f4585c;

    public b(int[] iArr, x[] xVarArr) {
        this.b = iArr;
        this.f4585c = xVarArr;
    }

    @Override // com.anythink.expressad.exoplayer.h.b.d.b
    public final m a(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            int[] iArr = this.b;
            if (i3 >= iArr.length) {
                Log.e(f4584a, "Unmatched track of type: ".concat(String.valueOf(i)));
                return new com.anythink.expressad.exoplayer.e.d();
            } else if (i == iArr[i3]) {
                return this.f4585c[i3];
            } else {
                i2 = i3 + 1;
            }
        }
    }

    public final void a(long j) {
        x[] xVarArr = this.f4585c;
        int length = xVarArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            x xVar = xVarArr[i2];
            if (xVar != null) {
                xVar.a(j);
            }
            i = i2 + 1;
        }
    }

    public final int[] a() {
        int[] iArr = new int[this.f4585c.length];
        int i = 0;
        while (true) {
            int i2 = i;
            x[] xVarArr = this.f4585c;
            if (i2 >= xVarArr.length) {
                return iArr;
            }
            if (xVarArr[i2] != null) {
                iArr[i2] = xVarArr[i2].b();
            }
            i = i2 + 1;
        }
    }
}
