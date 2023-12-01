package com.anythink.expressad.exoplayer.i;

import com.anythink.expressad.exoplayer.h.ae;
import com.anythink.expressad.exoplayer.i.f;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/i/d.class */
public final class d extends b {

    /* renamed from: a  reason: collision with root package name */
    private final int f4700a;
    private final Object b;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/i/d$a.class */
    public static final class a implements f.a {

        /* renamed from: a  reason: collision with root package name */
        private final int f4701a;
        private final Object b;

        public a() {
            this.f4701a = 0;
            this.b = null;
        }

        private a(int i, Object obj) {
            this.f4701a = i;
            this.b = obj;
        }

        private d b(ae aeVar, int... iArr) {
            boolean z = true;
            if (iArr.length != 1) {
                z = false;
            }
            com.anythink.expressad.exoplayer.k.a.a(z);
            return new d(aeVar, iArr[0], this.f4701a, this.b);
        }

        @Override // com.anythink.expressad.exoplayer.i.f.a
        public final /* synthetic */ f a(ae aeVar, int[] iArr) {
            boolean z = true;
            if (iArr.length != 1) {
                z = false;
            }
            com.anythink.expressad.exoplayer.k.a.a(z);
            return new d(aeVar, iArr[0], this.f4701a, this.b);
        }
    }

    public d(ae aeVar, int i) {
        this(aeVar, i, 0, null);
    }

    public d(ae aeVar, int i, int i2, Object obj) {
        super(aeVar, i);
        this.f4700a = i2;
        this.b = obj;
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public final void a(long j, long j2) {
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public final int b() {
        return 0;
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public final int c() {
        return this.f4700a;
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public final Object d() {
        return this.b;
    }
}
