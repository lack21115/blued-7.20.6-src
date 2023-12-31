package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/za.class */
public final class za {

    /* renamed from: a  reason: collision with root package name */
    private static final String f24457a = "PoolUtil";
    private static final int b = 20;

    /* renamed from: c  reason: collision with root package name */
    private static final o<Object> f24458c = new a();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/za$a.class */
    public static final class a implements o<Object> {
        @Override // com.tencent.mapsdk.internal.za.o
        public void a(Object obj) {
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/za$b.class */
    public static final class b extends f<m<Bitmap>> {
        public b(e eVar) {
            super(eVar);
        }

        @Override // com.tencent.mapsdk.internal.za.i
        /* renamed from: b */
        public m<Bitmap> a() {
            e eVar = this.f24461a;
            return new m<>(Bitmap.createBitmap(eVar.f24459a, eVar.b, eVar.f24460c));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/za$c.class */
    public static final class c<T> implements i<List<T>> {
        @Override // com.tencent.mapsdk.internal.za.i
        /* renamed from: b */
        public List<T> a() {
            return new ArrayList();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/za$d.class */
    public static final class d<T> implements o<List<T>> {
        @Override // com.tencent.mapsdk.internal.za.o
        public /* bridge */ /* synthetic */ void a(Object obj) {
            a((List) ((List) obj));
        }

        public void a(List<T> list) {
            list.clear();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/za$e.class */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public int f24459a;
        public int b;

        /* renamed from: c  reason: collision with root package name */
        public Bitmap.Config f24460c;

        public e(int i, int i2, Bitmap.Config config) {
            this.f24459a = i;
            this.b = i2;
            this.f24460c = config;
        }

        public void a(e eVar) {
            if (eVar != null) {
                this.f24459a = eVar.f24459a;
                this.b = eVar.b;
                this.f24460c = eVar.f24460c;
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/za$f.class */
    public static abstract class f<T> implements i<T> {

        /* renamed from: a  reason: collision with root package name */
        public e f24461a;

        public f(e eVar) {
            this.f24461a = eVar;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/za$g.class */
    public static class g extends p {
        private volatile RuntimeException b;

        @Override // com.tencent.mapsdk.internal.za.p
        public void a(boolean z) {
            if (z) {
                this.b = new RuntimeException("Released");
            } else {
                this.b = null;
            }
        }

        @Override // com.tencent.mapsdk.internal.za.p
        public void b() {
            if (this.b != null) {
                throw new IllegalStateException("Already released", this.b);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/za$h.class */
    public static class h extends p {
        private volatile boolean b;

        @Override // com.tencent.mapsdk.internal.za.p
        public void a(boolean z) {
            this.b = z;
        }

        @Override // com.tencent.mapsdk.internal.za.p
        public void b() {
            if (this.b) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/za$i.class */
    public interface i<T> {
        T a();
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/za$j.class */
    public static final class j<T> implements k<T> {

        /* renamed from: a  reason: collision with root package name */
        private final i<T> f24462a;
        private final o<T> b;

        /* renamed from: c  reason: collision with root package name */
        private final k<T> f24463c;

        public j(k<T> kVar, i<T> iVar, o<T> oVar) {
            this.f24463c = kVar;
            this.f24462a = iVar;
            this.b = oVar;
        }

        @Override // com.tencent.mapsdk.internal.za.k
        public T a() {
            T a2 = this.f24463c.a();
            T t = a2;
            if (a2 == null) {
                t = this.f24462a.a();
                na.f(za.f24457a, "Created new " + t);
            }
            if (t instanceof l) {
                ((l) t).a().a(false);
            }
            return t;
        }

        @Override // com.tencent.mapsdk.internal.za.k
        public boolean a(T t) {
            if (t instanceof l) {
                ((l) t).a().a(true);
            }
            this.b.a(t);
            return this.f24463c.a(t);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/za$k.class */
    public interface k<T> {
        T a();

        boolean a(T t);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/za$l.class */
    public interface l {
        p a();
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/za$m.class */
    public static final class m<T> implements l {

        /* renamed from: a  reason: collision with root package name */
        private final T f24464a;
        private p b = p.a();

        public m(T t) {
            this.f24464a = t;
        }

        @Override // com.tencent.mapsdk.internal.za.l
        public p a() {
            return this.b;
        }

        public T b() {
            return this.f24464a;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/za$n.class */
    public static final class n {

        /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/za$n$a.class */
        public static class a<T> implements k<T> {

            /* renamed from: a  reason: collision with root package name */
            private final Object[] f24465a;
            private int b;

            public a(int i) {
                if (i <= 0) {
                    throw new IllegalArgumentException("The max pool size must be > 0");
                }
                this.f24465a = new Object[i];
            }

            private boolean b(T t) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.b) {
                        return false;
                    }
                    if (this.f24465a[i2] == t) {
                        return true;
                    }
                    i = i2 + 1;
                }
            }

            @Override // com.tencent.mapsdk.internal.za.k
            public T a() {
                int i = this.b;
                if (i > 0) {
                    int i2 = i - 1;
                    Object[] objArr = this.f24465a;
                    T t = (T) objArr[i2];
                    objArr[i2] = null;
                    this.b = i2;
                    return t;
                }
                return null;
            }

            @Override // com.tencent.mapsdk.internal.za.k
            public boolean a(T t) {
                if (b(t)) {
                    throw new IllegalStateException("Already in the pool!");
                }
                int i = this.b;
                Object[] objArr = this.f24465a;
                if (i < objArr.length) {
                    objArr[i] = t;
                    this.b = i + 1;
                    return true;
                }
                return false;
            }
        }

        /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/za$n$b.class */
        public static class b<T> extends a<T> {

            /* renamed from: c  reason: collision with root package name */
            private final Object f24466c;

            public b(int i) {
                super(i);
                this.f24466c = new Object();
            }

            @Override // com.tencent.mapsdk.internal.za.n.a, com.tencent.mapsdk.internal.za.k
            public T a() {
                T t;
                synchronized (this.f24466c) {
                    t = (T) super.a();
                }
                return t;
            }

            @Override // com.tencent.mapsdk.internal.za.n.a, com.tencent.mapsdk.internal.za.k
            public boolean a(T t) {
                boolean a2;
                synchronized (this.f24466c) {
                    a2 = super.a(t);
                }
                return a2;
            }
        }

        private n() {
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/za$o.class */
    public interface o<T> {
        void a(T t);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/za$p.class */
    public static abstract class p {

        /* renamed from: a  reason: collision with root package name */
        private static final boolean f24467a = false;

        public static p a() {
            return new h();
        }

        public abstract void a(boolean z);

        public abstract void b();
    }

    private za() {
    }

    public static <T> k<List<T>> a(int i2) {
        return a(new n.b(i2), new c(), new d());
    }

    public static k<m<Bitmap>> a(int i2, e eVar) {
        return b(i2, new b(eVar));
    }

    public static <T extends l> k<T> a(int i2, i<T> iVar) {
        return a(new n.a(i2), iVar);
    }

    public static <T extends l> k<T> a(int i2, i<T> iVar, o<T> oVar) {
        return a(new n.b(i2), iVar, oVar);
    }

    private static <T extends l> k<T> a(k<T> kVar, i<T> iVar) {
        return a(kVar, iVar, a());
    }

    private static <T> k<T> a(k<T> kVar, i<T> iVar, o<T> oVar) {
        return new j(kVar, iVar, oVar);
    }

    private static <T> o<T> a() {
        return (o<T>) f24458c;
    }

    public static <T> k<List<T>> b() {
        return a(20);
    }

    public static <T extends l> k<T> b(int i2, i<T> iVar) {
        return a(new n.b(i2), iVar);
    }
}
