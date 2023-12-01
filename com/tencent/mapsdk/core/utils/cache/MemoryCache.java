package com.tencent.mapsdk.core.utils.cache;

import com.tencent.mapsdk.internal.m9;
import com.tencent.mapsdk.internal.ma;
import com.tencent.mapsdk.internal.n9;
import com.tencent.mapsdk.internal.o9;
import com.tencent.mapsdk.internal.ra;
import com.tencent.mapsdk.internal.u9;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/core/utils/cache/MemoryCache.class */
public final class MemoryCache<D extends n9> extends u9<D> {
    private static final float d = 0.9f;
    private static final float e = 0.15f;
    private final a b;

    /* renamed from: c  reason: collision with root package name */
    private final o9.a<D> f23586c;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/core/utils/cache/MemoryCache$a.class */
    public static class a implements m9.a {
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private m9.b f23587c;

        @Override // com.tencent.mapsdk.internal.m9.a
        public int a() {
            return this.b;
        }

        public a a(int i) {
            this.b = i;
            return this;
        }

        public <D> a a(m9.b<D> bVar) {
            this.f23587c = bVar;
            return this;
        }

        public <D> m9.b<D> b() {
            return this.f23587c;
        }

        public String toString() {
            return "Options{mMaxCacheSize=" + this.b + '}';
        }
    }

    public MemoryCache(a aVar) {
        this.b = aVar;
        this.f23586c = new o9.a<>(h(), aVar.b());
    }

    private int h() {
        int i = (int) (((float) Runtime.getRuntime().totalMemory()) * 0.9f);
        int freeMemory = (int) (((float) Runtime.getRuntime().freeMemory()) * e);
        a aVar = this.b;
        int i2 = i;
        if (aVar != null) {
            i2 = Math.min(Math.max(aVar.a(), freeMemory), i);
        }
        return i2;
    }

    @Override // com.tencent.mapsdk.internal.m9, com.tencent.mapsdk.internal.t9
    public long a() {
        return this.f23586c.e();
    }

    @Override // com.tencent.mapsdk.internal.m9
    public D a(String str, Class<D> cls) {
        D d2 = (D) this.f23586c.b((o9.a<D>) str);
        ra.a(ma.q, str, "get data length", Integer.valueOf(d2 == null ? 0 : d2.a()));
        ra.f(ma.q, str);
        return d2;
    }

    @Override // com.tencent.mapsdk.internal.m9
    public void a(String str, D d2) {
        ra.a(ma.q, str, "put");
        this.f23586c.a((o9.a<D>) str, (String) d2);
        ra.a(ma.q, str, "put data length", Integer.valueOf(d2.a()));
    }

    @Override // com.tencent.mapsdk.internal.m9
    public void clear() {
        this.f23586c.b();
    }

    @Override // com.tencent.mapsdk.internal.m9
    public long f() {
        return this.f23586c.h();
    }

    @Override // com.tencent.mapsdk.internal.m9
    public long getCount() {
        return this.f23586c.i().size();
    }

    @Override // com.tencent.mapsdk.internal.m9
    public boolean remove(String str) {
        return this.f23586c.c(str) != 0;
    }
}
