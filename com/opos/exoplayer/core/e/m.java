package com.opos.exoplayer.core.e;

import java.util.Arrays;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/e/m.class */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static final m f11623a = new m(new l[0]);
    public final int b;

    /* renamed from: c  reason: collision with root package name */
    private final l[] f11624c;
    private int d;

    public m(l... lVarArr) {
        this.f11624c = lVarArr;
        this.b = lVarArr.length;
    }

    public int a(l lVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b) {
                return -1;
            }
            if (this.f11624c[i2] == lVar) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    public l a(int i) {
        return this.f11624c[i];
    }

    public boolean equals(Object obj) {
        boolean z;
        if (this != obj) {
            z = false;
            if (obj != null) {
                if (getClass() != obj.getClass()) {
                    return false;
                }
                m mVar = (m) obj;
                z = false;
                if (this.b == mVar.b) {
                    if (!Arrays.equals(this.f11624c, mVar.f11624c)) {
                        return false;
                    }
                }
            }
            return z;
        }
        z = true;
        return z;
    }

    public int hashCode() {
        if (this.d == 0) {
            this.d = Arrays.hashCode(this.f11624c);
        }
        return this.d;
    }
}
