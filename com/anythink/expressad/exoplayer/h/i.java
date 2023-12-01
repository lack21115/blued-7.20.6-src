package com.anythink.expressad.exoplayer.h;

import android.os.Handler;
import android.os.Looper;
import com.anythink.expressad.exoplayer.ae;
import com.anythink.expressad.exoplayer.h.aa;
import com.anythink.expressad.exoplayer.h.s;
import com.anythink.expressad.exoplayer.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/i.class */
public final class i extends com.anythink.expressad.exoplayer.h.f<e> implements x.b {

    /* renamed from: a  reason: collision with root package name */
    private static final int f4617a = 0;
    private static final int b = 1;

    /* renamed from: c  reason: collision with root package name */
    private static final int f4618c = 2;
    private static final int d = 3;
    private static final int e = 4;
    private static final int f = 5;
    private static final int g = 6;
    private final List<e> h;
    private final List<e> i;
    private final e j;
    private final Map<r, e> k;
    private final List<d> l;
    private final boolean m;
    private final ae.b n;
    private com.anythink.expressad.exoplayer.h o;
    private boolean p;
    private aa q;
    private int r;
    private int s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/i$a.class */
    public static final class a extends com.anythink.expressad.exoplayer.h.a {
        private final int b;

        /* renamed from: c  reason: collision with root package name */
        private final int f4619c;
        private final int[] d;
        private final int[] e;
        private final com.anythink.expressad.exoplayer.ae[] f;
        private final Object[] g;
        private final HashMap<Object, Integer> h;

        public a(Collection<e> collection, int i, int i2, aa aaVar, boolean z) {
            super(z, aaVar);
            this.b = i;
            this.f4619c = i2;
            int size = collection.size();
            this.d = new int[size];
            this.e = new int[size];
            this.f = new com.anythink.expressad.exoplayer.ae[size];
            this.g = new Object[size];
            this.h = new HashMap<>();
            Iterator<e> it = collection.iterator();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (!it.hasNext()) {
                    return;
                }
                e next = it.next();
                this.f[i4] = next.f4623c;
                this.d[i4] = next.f;
                this.e[i4] = next.e;
                this.g[i4] = next.b;
                this.h.put(this.g[i4], Integer.valueOf(i4));
                i3 = i4 + 1;
            }
        }

        @Override // com.anythink.expressad.exoplayer.h.a
        protected final int a(int i) {
            return com.anythink.expressad.exoplayer.k.af.a(this.d, i + 1);
        }

        @Override // com.anythink.expressad.exoplayer.ae
        public final int b() {
            return this.b;
        }

        @Override // com.anythink.expressad.exoplayer.h.a
        protected final int b(int i) {
            return com.anythink.expressad.exoplayer.k.af.a(this.e, i + 1);
        }

        @Override // com.anythink.expressad.exoplayer.h.a
        protected final int b(Object obj) {
            Integer num = this.h.get(obj);
            if (num == null) {
                return -1;
            }
            return num.intValue();
        }

        @Override // com.anythink.expressad.exoplayer.ae
        public final int c() {
            return this.f4619c;
        }

        @Override // com.anythink.expressad.exoplayer.h.a
        protected final com.anythink.expressad.exoplayer.ae c(int i) {
            return this.f[i];
        }

        @Override // com.anythink.expressad.exoplayer.h.a
        protected final int d(int i) {
            return this.d[i];
        }

        @Override // com.anythink.expressad.exoplayer.h.a
        protected final int e(int i) {
            return this.e[i];
        }

        @Override // com.anythink.expressad.exoplayer.h.a
        protected final Object f(int i) {
            return this.g[i];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/i$b.class */
    public static final class b extends p {

        /* renamed from: c  reason: collision with root package name */
        private static final Object f4620c = new Object();
        private static final ae.a d = new ae.a();
        private static final c e = new c((byte) 0);
        private final Object f;

        public b() {
            this(e, null);
        }

        private b(com.anythink.expressad.exoplayer.ae aeVar, Object obj) {
            super(aeVar);
            this.f = obj;
        }

        @Override // com.anythink.expressad.exoplayer.h.p, com.anythink.expressad.exoplayer.ae
        public final int a(Object obj) {
            com.anythink.expressad.exoplayer.ae aeVar = this.b;
            Object obj2 = obj;
            if (f4620c.equals(obj)) {
                obj2 = this.f;
            }
            return aeVar.a(obj2);
        }

        @Override // com.anythink.expressad.exoplayer.h.p, com.anythink.expressad.exoplayer.ae
        public final ae.a a(int i, ae.a aVar, boolean z) {
            this.b.a(i, aVar, z);
            if (com.anythink.expressad.exoplayer.k.af.a(aVar.b, this.f)) {
                aVar.b = f4620c;
            }
            return aVar;
        }

        public final b a(com.anythink.expressad.exoplayer.ae aeVar) {
            return new b(aeVar, (this.f != null || aeVar.c() <= 0) ? this.f : aeVar.a(0, d, true).b);
        }

        public final com.anythink.expressad.exoplayer.ae d() {
            return this.b;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/i$c.class */
    static final class c extends com.anythink.expressad.exoplayer.ae {
        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }

        @Override // com.anythink.expressad.exoplayer.ae
        public final int a(Object obj) {
            return obj == null ? 0 : -1;
        }

        @Override // com.anythink.expressad.exoplayer.ae
        public final ae.a a(int i, ae.a aVar, boolean z) {
            return aVar.a(null, null, com.anythink.expressad.exoplayer.b.b, 0L);
        }

        @Override // com.anythink.expressad.exoplayer.ae
        public final ae.b a(int i, ae.b bVar, boolean z, long j) {
            long j2 = 0;
            if (j > 0) {
                j2 = -9223372036854775807L;
            }
            return bVar.a(null, com.anythink.expressad.exoplayer.b.b, com.anythink.expressad.exoplayer.b.b, false, true, j2, com.anythink.expressad.exoplayer.b.b, 0L);
        }

        @Override // com.anythink.expressad.exoplayer.ae
        public final int b() {
            return 1;
        }

        @Override // com.anythink.expressad.exoplayer.ae
        public final int c() {
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/i$d.class */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final Handler f4621a;
        public final Runnable b;

        public d(Runnable runnable) {
            this.b = runnable;
            this.f4621a = new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
        }

        private void a() {
            this.f4621a.post(this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/i$e.class */
    public static final class e implements Comparable<e> {

        /* renamed from: a  reason: collision with root package name */
        public final s f4622a;
        public int d;
        public int e;
        public int f;
        public boolean g;
        public boolean h;

        /* renamed from: c  reason: collision with root package name */
        public b f4623c = new b();
        public List<l> i = new ArrayList();
        public final Object b = new Object();

        public e(s sVar) {
            this.f4622a = sVar;
        }

        private int a(e eVar) {
            return this.f - eVar.f;
        }

        public final void a(int i, int i2, int i3) {
            this.d = i;
            this.e = i2;
            this.f = i3;
            this.g = false;
            this.h = false;
            this.i.clear();
        }

        @Override // java.lang.Comparable
        public final /* bridge */ /* synthetic */ int compareTo(e eVar) {
            return this.f - eVar.f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/i$f.class */
    public static final class f<T> {

        /* renamed from: a  reason: collision with root package name */
        public final int f4624a;
        public final T b;

        /* renamed from: c  reason: collision with root package name */
        public final d f4625c;

        public f(int i, T t, Runnable runnable) {
            this.f4624a = i;
            this.f4625c = runnable != null ? new d(runnable) : null;
            this.b = t;
        }
    }

    public i() {
        this(false, (aa) new aa.a());
    }

    private i(boolean z) {
        this(z, new aa.a());
    }

    private i(boolean z, aa aaVar) {
        this(z, aaVar, new s[0]);
    }

    private i(boolean z, aa aaVar, s... sVarArr) {
        int length = sVarArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            com.anythink.expressad.exoplayer.k.a.a(sVarArr[i2]);
            i = i2 + 1;
        }
        this.q = aaVar.a() > 0 ? aaVar.d() : aaVar;
        this.k = new IdentityHashMap();
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.l = new ArrayList();
        this.j = new e(null);
        this.m = z;
        this.n = new ae.b();
        a(this.h.size(), Arrays.asList(sVarArr), (Runnable) null);
    }

    private i(s... sVarArr) {
        this(sVarArr, (byte) 0);
    }

    private i(s[] sVarArr, byte b2) {
        this(false, new aa.a(), sVarArr);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static int a2(e eVar, int i) {
        return i + eVar.e;
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static s.a a2(e eVar, s.a aVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= eVar.i.size()) {
                return null;
            }
            if (eVar.i.get(i2).b.d == aVar.d) {
                return aVar.a(aVar.f4645a + eVar.f);
            }
            i = i2 + 1;
        }
    }

    private void a(int i) {
        this.h.remove(i);
        com.anythink.expressad.exoplayer.h hVar = this.o;
        if (hVar != null) {
            hVar.a((x.b) this).a(2).a(new f(i, null, null)).i();
        }
    }

    private void a(int i, int i2) {
        if (i != i2) {
            List<e> list = this.h;
            list.add(i2, list.remove(i));
            com.anythink.expressad.exoplayer.h hVar = this.o;
            if (hVar != null) {
                hVar.a((x.b) this).a(3).a(new f(i, Integer.valueOf(i2), null)).i();
            }
        }
    }

    private void a(int i, int i2, int i3, int i4) {
        this.r += i3;
        this.s += i4;
        while (i < this.i.size()) {
            this.i.get(i).d += i2;
            this.i.get(i).e += i3;
            this.i.get(i).f += i4;
            i++;
        }
    }

    private void a(int i, int i2, Runnable runnable) {
        if (i == i2) {
            return;
        }
        List<e> list = this.h;
        list.add(i2, list.remove(i));
        com.anythink.expressad.exoplayer.h hVar = this.o;
        if (hVar != null) {
            hVar.a((x.b) this).a(3).a(new f(i, Integer.valueOf(i2), runnable)).i();
        } else if (runnable != null) {
            runnable.run();
        }
    }

    private void a(int i, e eVar) {
        if (i > 0) {
            e eVar2 = this.i.get(i - 1);
            eVar.a(i, eVar2.e + eVar2.f4623c.b(), eVar2.f + eVar2.f4623c.c());
        } else {
            eVar.a(i, 0, 0);
        }
        a(i, 1, eVar.f4623c.b(), eVar.f4623c.c());
        this.i.add(i, eVar);
        a((i) eVar, eVar.f4622a);
    }

    private void a(int i, s sVar) {
        a(i, sVar, (Runnable) null);
    }

    private void a(int i, s sVar, Runnable runnable) {
        com.anythink.expressad.exoplayer.k.a.a(sVar);
        e eVar = new e(sVar);
        this.h.add(i, eVar);
        com.anythink.expressad.exoplayer.h hVar = this.o;
        if (hVar != null) {
            hVar.a((x.b) this).a(0).a(new f(i, eVar, runnable)).i();
        } else if (runnable != null) {
            runnable.run();
        }
    }

    private void a(int i, Runnable runnable) {
        this.h.remove(i);
        com.anythink.expressad.exoplayer.h hVar = this.o;
        if (hVar != null) {
            hVar.a((x.b) this).a(2).a(new f(i, null, runnable)).i();
        } else if (runnable != null) {
            runnable.run();
        }
    }

    private void a(int i, Collection<s> collection) {
        a(i, collection, (Runnable) null);
    }

    private void a(int i, Collection<s> collection, Runnable runnable) {
        for (s sVar : collection) {
            com.anythink.expressad.exoplayer.k.a.a(sVar);
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (s sVar2 : collection) {
            arrayList.add(new e(sVar2));
        }
        this.h.addAll(i, arrayList);
        if (this.o != null && !collection.isEmpty()) {
            this.o.a((x.b) this).a(1).a(new f(i, arrayList, runnable)).i();
        } else if (runnable != null) {
            runnable.run();
        }
    }

    private void a(d dVar) {
        if (!this.p) {
            this.o.a((x.b) this).a(5).i();
            this.p = true;
        }
        if (dVar != null) {
            this.l.add(dVar);
        }
    }

    private void a(e eVar, com.anythink.expressad.exoplayer.ae aeVar) {
        if (eVar == null) {
            throw new IllegalArgumentException();
        }
        b bVar = eVar.f4623c;
        if (bVar.d() != aeVar) {
            int b2 = aeVar.b() - bVar.b();
            int c2 = aeVar.c() - bVar.c();
            if (b2 != 0 || c2 != 0) {
                a(eVar.d + 1, 0, b2, c2);
            }
            eVar.f4623c = bVar.a(aeVar);
            if (!eVar.g && !aeVar.a()) {
                aeVar.a(0, this.n, false);
                long j = this.n.j;
                long j2 = this.n.h;
                for (int i = 0; i < eVar.i.size(); i++) {
                    l lVar = eVar.i.get(i);
                    lVar.d(j + j2);
                    lVar.f();
                }
                eVar.g = true;
            }
            a((d) null);
        }
    }

    private void a(s sVar) {
        a(this.h.size(), sVar, (Runnable) null);
    }

    private void a(s sVar, Runnable runnable) {
        a(this.h.size(), sVar, runnable);
    }

    private void a(Runnable runnable) {
        this.h.clear();
        com.anythink.expressad.exoplayer.h hVar = this.o;
        if (hVar != null) {
            hVar.a((x.b) this).a(4).a(runnable != null ? new d(runnable) : null).i();
        } else if (runnable != null) {
            runnable.run();
        }
    }

    private void a(Collection<s> collection) {
        a(this.h.size(), collection, (Runnable) null);
    }

    private void a(Collection<s> collection, Runnable runnable) {
        a(this.h.size(), collection, runnable);
    }

    private s b(int i) {
        return this.h.get(i).f4622a;
    }

    private void b(int i, int i2) {
        int min = Math.min(i, i2);
        int max = Math.max(i, i2);
        int i3 = this.i.get(min).e;
        int i4 = this.i.get(min).f;
        List<e> list = this.i;
        list.add(i2, list.remove(i));
        int i5 = i4;
        int i6 = min;
        while (true) {
            int i7 = i6;
            if (i7 > max) {
                return;
            }
            e eVar = this.i.get(i7);
            eVar.e = i3;
            eVar.f = i5;
            i3 += eVar.f4623c.b();
            i5 += eVar.f4623c.c();
            i6 = i7 + 1;
        }
    }

    private void b(int i, Collection<e> collection) {
        for (e eVar : collection) {
            a(i, eVar);
            i++;
        }
    }

    private void b(e eVar, com.anythink.expressad.exoplayer.ae aeVar) {
        if (eVar == null) {
            throw new IllegalArgumentException();
        }
        b bVar = eVar.f4623c;
        if (bVar.d() == aeVar) {
            return;
        }
        int b2 = aeVar.b() - bVar.b();
        int c2 = aeVar.c() - bVar.c();
        if (b2 != 0 || c2 != 0) {
            a(eVar.d + 1, 0, b2, c2);
        }
        eVar.f4623c = bVar.a(aeVar);
        if (!eVar.g && !aeVar.a()) {
            aeVar.a(0, this.n, false);
            long j = this.n.j;
            long j2 = this.n.h;
            for (int i = 0; i < eVar.i.size(); i++) {
                l lVar = eVar.i.get(i);
                lVar.d(j + j2);
                lVar.f();
            }
            eVar.g = true;
        }
        a((d) null);
    }

    private void c() {
        this.h.clear();
        com.anythink.expressad.exoplayer.h hVar = this.o;
        if (hVar != null) {
            hVar.a((x.b) this).a(4).a((Object) null).i();
        }
    }

    private void c(int i) {
        e remove = this.i.remove(i);
        b bVar = remove.f4623c;
        a(i, -1, -bVar.b(), -bVar.c());
        remove.h = true;
        if (remove.i.isEmpty()) {
            a((i) remove);
        }
    }

    private int d() {
        return this.h.size();
    }

    private int d(int i) {
        this.j.f = i;
        int binarySearch = Collections.binarySearch(this.i, this.j);
        int i2 = binarySearch;
        if (binarySearch < 0) {
            return (-binarySearch) - 2;
        }
        while (i2 < this.i.size() - 1) {
            int i3 = i2 + 1;
            if (this.i.get(i3).f != i) {
                break;
            }
            i2 = i3;
        }
        return i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [java.util.List] */
    private void e() {
        this.p = false;
        ArrayList emptyList = this.l.isEmpty() ? Collections.emptyList() : new ArrayList(this.l);
        this.l.clear();
        a(new a(this.i, this.r, this.s, this.q, this.m), (Object) null);
        if (emptyList.isEmpty()) {
            return;
        }
        this.o.a((x.b) this).a(6).a(emptyList).i();
    }

    private void f() {
        int size = this.i.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return;
            }
            c(i);
            size = i;
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.f
    protected final /* bridge */ /* synthetic */ int a(e eVar, int i) {
        return i + eVar.e;
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final r a(s.a aVar, com.anythink.expressad.exoplayer.j.b bVar) {
        int i = aVar.f4645a;
        this.j.f = i;
        int binarySearch = Collections.binarySearch(this.i, this.j);
        int i2 = binarySearch;
        if (binarySearch >= 0) {
            while (i2 < this.i.size() - 1) {
                int i3 = i2 + 1;
                if (this.i.get(i3).f != i) {
                    break;
                }
                i2 = i3;
            }
        } else {
            i2 = (-binarySearch) - 2;
        }
        e eVar = this.i.get(i2);
        l lVar = new l(eVar.f4622a, aVar.a(aVar.f4645a - eVar.f), bVar);
        this.k.put(lVar, eVar);
        eVar.i.add(lVar);
        if (eVar.g) {
            lVar.f();
        }
        return lVar;
    }

    @Override // com.anythink.expressad.exoplayer.h.f
    protected final /* synthetic */ s.a a(e eVar, s.a aVar) {
        e eVar2 = eVar;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= eVar2.i.size()) {
                return null;
            }
            if (eVar2.i.get(i2).b.d == aVar.d) {
                return aVar.a(aVar.f4645a + eVar2.f);
            }
            i = i2 + 1;
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.f, com.anythink.expressad.exoplayer.h.c
    public final void a() {
        super.a();
        this.i.clear();
        this.o = null;
        this.q = this.q.d();
        this.r = 0;
        this.s = 0;
    }

    @Override // com.anythink.expressad.exoplayer.x.b
    public final void a(int i, Object obj) {
        switch (i) {
            case 0:
                f fVar = (f) obj;
                this.q = this.q.a(fVar.f4624a, 1);
                a(fVar.f4624a, (e) fVar.b);
                a(fVar.f4625c);
                return;
            case 1:
                f fVar2 = (f) obj;
                this.q = this.q.a(fVar2.f4624a, ((Collection) fVar2.b).size());
                b(fVar2.f4624a, (Collection) fVar2.b);
                a(fVar2.f4625c);
                return;
            case 2:
                f fVar3 = (f) obj;
                this.q = this.q.c(fVar3.f4624a);
                c(fVar3.f4624a);
                a(fVar3.f4625c);
                return;
            case 3:
                f fVar4 = (f) obj;
                aa c2 = this.q.c(fVar4.f4624a);
                this.q = c2;
                this.q = c2.a(((Integer) fVar4.b).intValue(), 1);
                int i2 = fVar4.f4624a;
                int intValue = ((Integer) fVar4.b).intValue();
                int min = Math.min(i2, intValue);
                int max = Math.max(i2, intValue);
                int i3 = this.i.get(min).e;
                int i4 = this.i.get(min).f;
                List<e> list = this.i;
                list.add(intValue, list.remove(i2));
                while (min <= max) {
                    e eVar = this.i.get(min);
                    eVar.e = i3;
                    eVar.f = i4;
                    i3 += eVar.f4623c.b();
                    i4 += eVar.f4623c.c();
                    min++;
                }
                a(fVar4.f4625c);
                return;
            case 4:
                int size = this.i.size();
                while (true) {
                    int i5 = size - 1;
                    if (i5 < 0) {
                        a((d) obj);
                        return;
                    } else {
                        c(i5);
                        size = i5;
                    }
                }
            case 5:
                e();
                return;
            case 6:
                List list2 = (List) obj;
                int i6 = 0;
                while (true) {
                    int i7 = i6;
                    if (i7 >= list2.size()) {
                        return;
                    }
                    d dVar = (d) list2.get(i7);
                    dVar.f4621a.post(dVar.b);
                    i6 = i7 + 1;
                }
            default:
                throw new IllegalStateException();
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final void a(r rVar) {
        e remove = this.k.remove(rVar);
        ((l) rVar).g();
        remove.i.remove(rVar);
        if (remove.i.isEmpty() && remove.h) {
            a((i) remove);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.f, com.anythink.expressad.exoplayer.h.c
    public final void a(com.anythink.expressad.exoplayer.h hVar, boolean z) {
        super.a(hVar, z);
        this.o = hVar;
        if (this.h.isEmpty()) {
            e();
            return;
        }
        this.q = this.q.a(0, this.h.size());
        b(0, this.h);
        a((d) null);
    }

    @Override // com.anythink.expressad.exoplayer.h.f
    protected final /* synthetic */ void a(e eVar, s sVar, com.anythink.expressad.exoplayer.ae aeVar, Object obj) {
        e eVar2 = eVar;
        if (eVar2 == null) {
            throw new IllegalArgumentException();
        }
        b bVar = eVar2.f4623c;
        if (bVar.d() != aeVar) {
            int b2 = aeVar.b() - bVar.b();
            int c2 = aeVar.c() - bVar.c();
            if (b2 != 0 || c2 != 0) {
                a(eVar2.d + 1, 0, b2, c2);
            }
            eVar2.f4623c = bVar.a(aeVar);
            if (!eVar2.g && !aeVar.a()) {
                aeVar.a(0, this.n, false);
                long j = this.n.j;
                long j2 = this.n.h;
                for (int i = 0; i < eVar2.i.size(); i++) {
                    l lVar = eVar2.i.get(i);
                    lVar.d(j + j2);
                    lVar.f();
                }
                eVar2.g = true;
            }
            a((d) null);
        }
    }
}
