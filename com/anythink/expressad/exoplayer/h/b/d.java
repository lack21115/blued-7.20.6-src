package com.anythink.expressad.exoplayer.h.b;

import android.util.SparseArray;
import com.anythink.expressad.exoplayer.e.k;
import com.anythink.expressad.exoplayer.e.m;
import com.anythink.expressad.exoplayer.k.s;
import com.anythink.expressad.exoplayer.m;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/b/d.class */
public final class d implements com.anythink.expressad.exoplayer.e.g {

    /* renamed from: a  reason: collision with root package name */
    public final com.anythink.expressad.exoplayer.e.e f4587a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final m f4588c;
    private final SparseArray<a> d = new SparseArray<>();
    private boolean e;
    private b f;
    private k g;
    private m[] h;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/b/d$a.class */
    static final class a implements com.anythink.expressad.exoplayer.e.m {

        /* renamed from: a  reason: collision with root package name */
        public m f4589a;
        private final int b;

        /* renamed from: c  reason: collision with root package name */
        private final int f4590c;
        private final m d;
        private com.anythink.expressad.exoplayer.e.m e;

        public a(int i, int i2, m mVar) {
            this.b = i;
            this.f4590c = i2;
            this.d = mVar;
        }

        @Override // com.anythink.expressad.exoplayer.e.m
        public final int a(com.anythink.expressad.exoplayer.e.f fVar, int i, boolean z) {
            return this.e.a(fVar, i, z);
        }

        @Override // com.anythink.expressad.exoplayer.e.m
        public final void a(long j, int i, int i2, int i3, m.a aVar) {
            this.e.a(j, i, i2, i3, aVar);
        }

        public final void a(b bVar) {
            if (bVar == null) {
                this.e = new com.anythink.expressad.exoplayer.e.d();
                return;
            }
            com.anythink.expressad.exoplayer.e.m a2 = bVar.a(this.f4590c);
            this.e = a2;
            com.anythink.expressad.exoplayer.m mVar = this.f4589a;
            if (mVar != null) {
                a2.a(mVar);
            }
        }

        @Override // com.anythink.expressad.exoplayer.e.m
        public final void a(s sVar, int i) {
            this.e.a(sVar, i);
        }

        @Override // com.anythink.expressad.exoplayer.e.m
        public final void a(com.anythink.expressad.exoplayer.m mVar) {
            com.anythink.expressad.exoplayer.m mVar2 = this.d;
            com.anythink.expressad.exoplayer.m mVar3 = mVar;
            if (mVar2 != null) {
                mVar3 = mVar.a(mVar2);
            }
            this.f4589a = mVar3;
            this.e.a(mVar3);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/b/d$b.class */
    public interface b {
        com.anythink.expressad.exoplayer.e.m a(int i);
    }

    private d(com.anythink.expressad.exoplayer.e.e eVar, int i, com.anythink.expressad.exoplayer.m mVar) {
        this.f4587a = eVar;
        this.b = i;
        this.f4588c = mVar;
    }

    private k b() {
        return this.g;
    }

    private com.anythink.expressad.exoplayer.m[] c() {
        return this.h;
    }

    @Override // com.anythink.expressad.exoplayer.e.g
    public final com.anythink.expressad.exoplayer.e.m a(int i, int i2) {
        a aVar = this.d.get(i);
        a aVar2 = aVar;
        if (aVar == null) {
            com.anythink.expressad.exoplayer.k.a.b(this.h == null);
            aVar2 = new a(i, i2, i2 == this.b ? this.f4588c : null);
            aVar2.a(this.f);
            this.d.put(i, aVar2);
        }
        return aVar2;
    }

    @Override // com.anythink.expressad.exoplayer.e.g
    public final void a(k kVar) {
        this.g = kVar;
    }

    public final void a(b bVar, long j) {
        this.f = bVar;
        if (!this.e) {
            this.f4587a.a(this);
            if (j != com.anythink.expressad.exoplayer.b.b) {
                this.f4587a.a(0L, j);
            }
            this.e = true;
            return;
        }
        com.anythink.expressad.exoplayer.e.e eVar = this.f4587a;
        long j2 = j;
        if (j == com.anythink.expressad.exoplayer.b.b) {
            j2 = 0;
        }
        eVar.a(0L, j2);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.d.size()) {
                return;
            }
            this.d.valueAt(i2).a(bVar);
            i = i2 + 1;
        }
    }

    @Override // com.anythink.expressad.exoplayer.e.g
    public final void c_() {
        com.anythink.expressad.exoplayer.m[] mVarArr = new com.anythink.expressad.exoplayer.m[this.d.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.d.size()) {
                this.h = mVarArr;
                return;
            } else {
                mVarArr[i2] = this.d.valueAt(i2).f4589a;
                i = i2 + 1;
            }
        }
    }
}
