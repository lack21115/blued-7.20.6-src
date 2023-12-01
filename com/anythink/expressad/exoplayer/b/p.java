package com.anythink.expressad.exoplayer.b;

import com.anythink.expressad.exoplayer.b.f;
import java.nio.ByteBuffer;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/b/p.class */
final class p implements f {
    private int b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f7213c = -1;
    private int d = 0;
    private ByteBuffer e = f7181a;
    private ByteBuffer f = f7181a;
    private boolean g;

    /* JADX WARN: Removed duplicated region for block: B:15:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e8 A[LOOP:2: B:31:0x00e8->B:33:0x00ee, LOOP_START, PHI: r8 
      PHI: (r8v5 int) = (r8v4 int), (r8v6 int) binds: [B:18:0x0077, B:33:0x00ee] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.anythink.expressad.exoplayer.b.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.nio.ByteBuffer r6) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.b.p.a(java.nio.ByteBuffer):void");
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final boolean a() {
        int i = this.d;
        return (i == 0 || i == 2) ? false : true;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final boolean a(int i, int i2, int i3) {
        if (i3 == 3 || i3 == 2 || i3 == Integer.MIN_VALUE || i3 == 1073741824) {
            if (this.b == i && this.f7213c == i2 && this.d == i3) {
                return false;
            }
            this.b = i;
            this.f7213c = i2;
            this.d = i3;
            return true;
        }
        throw new f.a(i, i2, i3);
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final int b() {
        return this.f7213c;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final int c() {
        return 2;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final int d() {
        return this.b;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void e() {
        this.g = true;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final ByteBuffer f() {
        ByteBuffer byteBuffer = this.f;
        this.f = f7181a;
        return byteBuffer;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final boolean g() {
        return this.g && this.f == f7181a;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void h() {
        this.f = f7181a;
        this.g = false;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void i() {
        h();
        this.b = -1;
        this.f7213c = -1;
        this.d = 0;
        this.e = f7181a;
    }
}
