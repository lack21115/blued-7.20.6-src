package com.opos.exoplayer.core.c;

import com.opos.exoplayer.core.Format;
import java.util.Arrays;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/n.class */
public interface n {

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/n$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f11566a;
        public final byte[] b;

        /* renamed from: c  reason: collision with root package name */
        public final int f11567c;
        public final int d;

        public a(int i, byte[] bArr, int i2, int i3) {
            this.f11566a = i;
            this.b = bArr;
            this.f11567c = i2;
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
                    if (this.f11566a == aVar.f11566a) {
                        z = false;
                        if (this.f11567c == aVar.f11567c) {
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
            return (((((this.f11566a * 31) + Arrays.hashCode(this.b)) * 31) + this.f11567c) * 31) + this.d;
        }
    }

    int a(f fVar, int i, boolean z);

    void a(long j, int i, int i2, int i3, a aVar);

    void a(Format format);

    void a(com.opos.exoplayer.core.i.m mVar, int i);
}
