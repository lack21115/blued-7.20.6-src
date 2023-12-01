package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.internal.ca;
import com.tencent.mapsdk.internal.k9;
import com.tencent.mapsdk.internal.n9;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/l9.class */
public abstract class l9<D extends n9> extends u9<D> implements k9<D> {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/l9$a.class */
    public class a extends ca.i<Boolean> {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f23919c;
        public final /* synthetic */ n9 d;

        public a(String str, n9 n9Var) {
            this.f23919c = str;
            this.d = n9Var;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            l9.this.b(this.f23919c, (String) this.d);
            return Boolean.TRUE;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/l9$b.class */
    public class b extends ca.i<D> {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f23920c;
        public final /* synthetic */ Class d;

        public b(String str, Class cls) {
            this.f23920c = str;
            this.d = cls;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public D call() {
            return (D) l9.this.b(this.f23920c, this.d);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/l9$c.class */
    public class c extends ca.i<Boolean> {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f23921c;

        public c(String str) {
            this.f23921c = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            return Boolean.valueOf(l9.this.a(this.f23921c));
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/l9$d.class */
    public class d extends ca.i<Boolean> {
        public d() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            l9.this.b();
            return Boolean.TRUE;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/l9$e.class */
    public class e extends ca.i<Long> {
        public e() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Long call() {
            return Long.valueOf(l9.this.c());
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/l9$f.class */
    public class f extends ca.i<Long> {
        public f() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Long call() {
            return Long.valueOf(l9.this.e());
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/l9$g.class */
    public class g extends ca.i<Long> {
        public g() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Long call() {
            return Long.valueOf(l9.this.a());
        }
    }

    @Override // com.tencent.mapsdk.internal.k9
    public final void a(k9.a<Long> aVar) {
        ca.a((ca.i) new g()).a((ca.f) new ca.g(0L)).a((ca.c) aVar);
    }

    @Override // com.tencent.mapsdk.internal.k9
    public final void a(String str, k9.a<Boolean> aVar) {
        ca.a((ca.i) new c(str)).a((ca.f) new ca.g(Boolean.FALSE)).a((ca.c) aVar);
    }

    @Override // com.tencent.mapsdk.internal.k9
    public final void a(String str, D d2, k9.a<Boolean> aVar) {
        ca.a((ca.i) new a(str, d2)).a((ca.f) new ca.g(Boolean.FALSE)).a((ca.c) aVar);
    }

    @Override // com.tencent.mapsdk.internal.k9
    public final void a(String str, Class<D> cls, k9.a<D> aVar) {
        try {
            ca.a((ca.i) new b(str, cls)).a((ca.f) new ca.g(cls.newInstance())).a((ca.c) aVar);
        } catch (IllegalAccessException e2) {
            throw new Error("The " + cls.getSimpleName() + " must have a empty construct. #" + e2.getMessage(), e2);
        } catch (InstantiationException e3) {
            throw new Error("The " + cls.getSimpleName() + " must have a empty construct. #" + e3.getMessage(), e3);
        }
    }

    @Override // com.tencent.mapsdk.internal.k9
    public final void b(k9.a<Long> aVar) {
        ca.a((ca.i) new f()).a((ca.f) new ca.g(0L)).a((ca.c) aVar);
    }

    @Override // com.tencent.mapsdk.internal.k9
    public final void c(k9.a<Boolean> aVar) {
        ca.a((ca.i) new d()).a((ca.f) new ca.g(Boolean.FALSE)).a((ca.c) aVar);
    }

    @Override // com.tencent.mapsdk.internal.k9
    public k9<D> d() {
        return this;
    }

    @Override // com.tencent.mapsdk.internal.k9
    public final void d(k9.a<Long> aVar) {
        ca.a((ca.i) new e()).a((ca.f) new ca.g(0L)).a((ca.c) aVar);
    }
}
