package com.opos.exoplayer.core.c;

import com.opos.exoplayer.core.Format;
import java.util.Arrays;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/n.class */
public interface n {

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/n$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f25254a;
        public final byte[] b;

        /* renamed from: c  reason: collision with root package name */
        public final int f25255c;
        public final int d;

        public a(int i, byte[] bArr, int i2, int i3) {
            this.f25254a = i;
            this.b = bArr;
            this.f25255c = i2;
            this.d = i3;
        }

        public boolean equals(Object obj) {
            boolean z;
            if (this != obj) {
                z = false;
                if (obj != null) {
                    if (getClass() != obj.getClass()) {
                        return false;
                    }
                    a aVar = (a) obj;
                    z = false;
                    if (this.f25254a == aVar.f25254a) {
                        z = false;
                        if (this.f25255c == aVar.f25255c) {
                            z = false;
                            if (this.d == aVar.d) {
                                if (!Arrays.equals(this.b, aVar.b)) {
                                    return false;
                                }
                            }
                        }
                    }
                }
                return z;
            }
            z = true;
            return z;
        }

        public int hashCode() {
            return (((((this.f25254a * 31) + Arrays.hashCode(this.b)) * 31) + this.f25255c) * 31) + this.d;
        }
    }

    int a(f fVar, int i, boolean z);

    void a(long j, int i, int i2, int i3, a aVar);

    void a(Format format);

    void a(com.opos.exoplayer.core.i.m mVar, int i);
}
