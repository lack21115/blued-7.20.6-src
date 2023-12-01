package com.opos.exoplayer.core.g;

import com.opos.exoplayer.core.e.l;
import com.opos.exoplayer.core.g.f;
import com.sobot.chat.camera.StCameraView;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/g/a.class */
public class a extends b {
    private final com.opos.exoplayer.core.h.d d;
    private final int e;
    private final long f;
    private final long g;
    private final long h;
    private final float i;
    private final float j;
    private final long k;
    private final com.opos.exoplayer.core.i.b l;
    private float m;
    private int n;
    private int o;
    private long p;

    /* renamed from: com.opos.exoplayer.core.g.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/g/a$a.class */
    public static final class C0495a implements f.a {

        /* renamed from: a  reason: collision with root package name */
        private final com.opos.exoplayer.core.h.d f11729a;
        private final int b;

        /* renamed from: c  reason: collision with root package name */
        private final int f11730c;
        private final int d;
        private final int e;
        private final float f;
        private final float g;
        private final long h;
        private final com.opos.exoplayer.core.i.b i;

        public C0495a(com.opos.exoplayer.core.h.d dVar) {
            this(dVar, StCameraView.MEDIA_QUALITY_POOR, 10000, 25000, 25000, 0.75f, 0.75f, 2000L, com.opos.exoplayer.core.i.b.f11791a);
        }

        public C0495a(com.opos.exoplayer.core.h.d dVar, int i, int i2, int i3, int i4, float f, float f2, long j, com.opos.exoplayer.core.i.b bVar) {
            this.f11729a = dVar;
            this.b = i;
            this.f11730c = i2;
            this.d = i3;
            this.e = i4;
            this.f = f;
            this.g = f2;
            this.h = j;
            this.i = bVar;
        }

        @Override // com.opos.exoplayer.core.g.f.a
        /* renamed from: a */
        public a b(l lVar, int... iArr) {
            return new a(lVar, iArr, this.f11729a, this.b, this.f11730c, this.d, this.e, this.f, this.g, this.h, this.i);
        }
    }

    public a(l lVar, int[] iArr, com.opos.exoplayer.core.h.d dVar, int i, long j, long j2, long j3, float f, float f2, long j4, com.opos.exoplayer.core.i.b bVar) {
        super(lVar, iArr);
        this.d = dVar;
        this.e = i;
        this.f = j * 1000;
        this.g = j2 * 1000;
        this.h = j3 * 1000;
        this.i = f;
        this.j = f2;
        this.k = j4;
        this.l = bVar;
        this.m = 1.0f;
        this.n = a(Long.MIN_VALUE);
        this.o = 1;
        this.p = com.anythink.expressad.exoplayer.b.b;
    }

    private int a(long j) {
        long a2;
        long j2 = this.d.a() == -1 ? this.e : ((float) a2) * this.i;
        int i = 0;
        for (int i2 = 0; i2 < this.b; i2++) {
            if (j == Long.MIN_VALUE || !a(i2, j)) {
                if (Math.round(a(i2).b * this.m) <= j2) {
                    return i2;
                }
                i = i2;
            }
        }
        return i;
    }

    @Override // com.opos.exoplayer.core.g.b, com.opos.exoplayer.core.g.f
    public void a() {
        this.p = com.anythink.expressad.exoplayer.b.b;
    }

    @Override // com.opos.exoplayer.core.g.b, com.opos.exoplayer.core.g.f
    public void a(float f) {
        this.m = f;
    }

    @Override // com.opos.exoplayer.core.g.f
    public int b() {
        return this.n;
    }
}
