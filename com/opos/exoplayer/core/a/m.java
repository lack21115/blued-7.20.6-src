package com.opos.exoplayer.core.a;

import com.opos.exoplayer.core.a.d;
import java.nio.ByteBuffer;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/a/m.class */
final class m implements d {
    private int b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f25042c = -1;
    private int d = 0;
    private ByteBuffer e = f25014a;
    private ByteBuffer f = f25014a;
    private boolean g;

    /* JADX WARN: Removed duplicated region for block: B:15:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e8 A[LOOP:2: B:31:0x00e8->B:33:0x00ee, LOOP_START, PHI: r8 
      PHI: (r8v5 int) = (r8v4 int), (r8v6 int) binds: [B:18:0x0077, B:33:0x00ee] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.opos.exoplayer.core.a.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.nio.ByteBuffer r6) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.a.m.a(java.nio.ByteBuffer):void");
    }

    @Override // com.opos.exoplayer.core.a.d
    public boolean a() {
        int i = this.d;
        return (i == 0 || i == 2) ? false : true;
    }

    @Override // com.opos.exoplayer.core.a.d
    public boolean a(int i, int i2, int i3) {
        if (i3 == 3 || i3 == 2 || i3 == Integer.MIN_VALUE || i3 == 1073741824) {
            if (this.b == i && this.f25042c == i2 && this.d == i3) {
                return false;
            }
            this.b = i;
            this.f25042c = i2;
            this.d = i3;
            if (i3 == 2) {
                this.e = f25014a;
                return true;
            }
            return true;
        }
        throw new d.a(i, i2, i3);
    }

    @Override // com.opos.exoplayer.core.a.d
    public int b() {
        return this.f25042c;
    }

    @Override // com.opos.exoplayer.core.a.d
    public int c() {
        return 2;
    }

    @Override // com.opos.exoplayer.core.a.d
    public int d() {
        return this.b;
    }

    @Override // com.opos.exoplayer.core.a.d
    public void e() {
        this.g = true;
    }

    @Override // com.opos.exoplayer.core.a.d
    public ByteBuffer f() {
        ByteBuffer byteBuffer = this.f;
        this.f = f25014a;
        return byteBuffer;
    }

    @Override // com.opos.exoplayer.core.a.d
    public boolean g() {
        return this.g && this.f == f25014a;
    }

    @Override // com.opos.exoplayer.core.a.d
    public void h() {
        this.f = f25014a;
        this.g = false;
    }

    @Override // com.opos.exoplayer.core.a.d
    public void i() {
        h();
        this.e = f25014a;
        this.b = -1;
        this.f25042c = -1;
        this.d = 0;
    }
}
