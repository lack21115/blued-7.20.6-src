package com.anythink.expressad.exoplayer.e;

import com.anythink.expressad.exoplayer.k.s;
import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/e/m.class */
public interface m {

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/e/m$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f4486a;
        public final byte[] b;

        /* renamed from: c  reason: collision with root package name */
        public final int f4487c;
        public final int d;

        public a(int i, byte[] bArr, int i2, int i3) {
            this.f4486a = i;
            this.b = bArr;
            this.f4487c = i2;
            this.d = i3;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f4486a == aVar.f4486a && this.f4487c == aVar.f4487c && this.d == aVar.d && Arrays.equals(this.b, aVar.b);
        }

        public final int hashCode() {
            return (((((this.f4486a * 31) + Arrays.hashCode(this.b)) * 31) + this.f4487c) * 31) + this.d;
        }
    }

    int a(f fVar, int i, boolean z);

    void a(long j, int i, int i2, int i3, a aVar);

    void a(s sVar, int i);

    void a(com.anythink.expressad.exoplayer.m mVar);
}
