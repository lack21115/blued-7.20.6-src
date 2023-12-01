package com.anythink.expressad.exoplayer.h.a;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import com.anythink.expressad.exoplayer.ae;
import com.anythink.expressad.exoplayer.h.a.b;
import com.anythink.expressad.exoplayer.h.f;
import com.anythink.expressad.exoplayer.h.l;
import com.anythink.expressad.exoplayer.h.o;
import com.anythink.expressad.exoplayer.h.r;
import com.anythink.expressad.exoplayer.h.s;
import com.anythink.expressad.exoplayer.j.h;
import com.anythink.expressad.exoplayer.j.k;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/a/c.class */
public final class c extends f<s.a> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4546a = "AdsMediaSource";
    private final s b;

    /* renamed from: c  reason: collision with root package name */
    private final e f4547c;
    private final com.anythink.expressad.exoplayer.h.a.b d;
    private final ViewGroup e;
    private final Handler f;
    private final d g;
    private final Handler h;
    private final Map<s, List<l>> i;
    private final ae.a j;
    private C0061c k;
    private ae l;
    private Object m;
    private com.anythink.expressad.exoplayer.h.a.a n;
    private s[][] o;
    private long[][] p;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/a/c$a.class */
    public static final class a extends IOException {

        /* renamed from: a  reason: collision with root package name */
        public static final int f4551a = 0;
        public static final int b = 1;

        /* renamed from: c  reason: collision with root package name */
        public static final int f4552c = 2;
        public static final int d = 3;
        public final int e;

        @Retention(RetentionPolicy.SOURCE)
        /* renamed from: com.anythink.expressad.exoplayer.h.a.c$a$a  reason: collision with other inner class name */
        /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/a/c$a$a.class */
        public @interface InterfaceC0060a {
        }

        private a(int i, Exception exc) {
            super(exc);
            this.e = i;
        }

        public static a a(Exception exc) {
            return new a(0, exc);
        }

        private static a a(Exception exc, int i) {
            return new a(1, new IOException("Failed to load ad group ".concat(String.valueOf(i)), exc));
        }

        private static a a(RuntimeException runtimeException) {
            return new a(3, runtimeException);
        }

        private RuntimeException a() {
            com.anythink.expressad.exoplayer.k.a.b(this.e == 3);
            return (RuntimeException) getCause();
        }

        private static a b(Exception exc) {
            return new a(2, exc);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/a/c$b.class */
    final class b implements l.a {
        private final Uri b;

        /* renamed from: c  reason: collision with root package name */
        private final int f4554c;
        private final int d;

        public b(Uri uri, int i, int i2) {
            this.b = uri;
            this.f4554c = i;
            this.d = i2;
        }

        @Override // com.anythink.expressad.exoplayer.h.l.a
        public final void a(s.a aVar, final IOException iOException) {
            c.this.a(aVar).a(new k(this.b), a.a(iOException));
            c.this.h.post(new Runnable() { // from class: com.anythink.expressad.exoplayer.h.a.c.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    com.anythink.expressad.exoplayer.h.a.b unused = c.this.d;
                    int unused2 = b.this.f4554c;
                    int unused3 = b.this.d;
                }
            });
        }
    }

    /* renamed from: com.anythink.expressad.exoplayer.h.a.c$c  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/a/c$c.class */
    final class C0061c implements b.a {
        private final Handler b = new Handler();

        /* renamed from: c  reason: collision with root package name */
        private volatile boolean f4557c;

        public C0061c() {
        }

        @Override // com.anythink.expressad.exoplayer.h.a.b.a
        public final void a() {
            if (this.f4557c || c.this.f == null || c.this.g == null) {
                return;
            }
            c.this.f.post(new Runnable() { // from class: com.anythink.expressad.exoplayer.h.a.c.c.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (C0061c.this.f4557c) {
                        return;
                    }
                    d unused = c.this.g;
                }
            });
        }

        @Override // com.anythink.expressad.exoplayer.h.a.b.a
        public final void a(final com.anythink.expressad.exoplayer.h.a.a aVar) {
            if (this.f4557c) {
                return;
            }
            this.b.post(new Runnable() { // from class: com.anythink.expressad.exoplayer.h.a.c.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (C0061c.this.f4557c) {
                        return;
                    }
                    c.a(c.this, aVar);
                }
            });
        }

        @Override // com.anythink.expressad.exoplayer.h.a.b.a
        public final void a(final a aVar, k kVar) {
            if (this.f4557c) {
                return;
            }
            c.this.a((s.a) null).a(kVar, aVar);
            if (c.this.f == null || c.this.g == null) {
                return;
            }
            c.this.f.post(new Runnable() { // from class: com.anythink.expressad.exoplayer.h.a.c.c.4
                @Override // java.lang.Runnable
                public final void run() {
                    if (C0061c.this.f4557c) {
                        return;
                    }
                    if (aVar.e != 3) {
                        d unused = c.this.g;
                        return;
                    }
                    d unused2 = c.this.g;
                    a aVar2 = aVar;
                    com.anythink.expressad.exoplayer.k.a.b(aVar2.e == 3);
                    aVar2.getCause();
                }
            });
        }

        @Override // com.anythink.expressad.exoplayer.h.a.b.a
        public final void b() {
            if (this.f4557c || c.this.f == null || c.this.g == null) {
                return;
            }
            c.this.f.post(new Runnable() { // from class: com.anythink.expressad.exoplayer.h.a.c.c.3
                @Override // java.lang.Runnable
                public final void run() {
                    if (C0061c.this.f4557c) {
                        return;
                    }
                    d unused = c.this.g;
                }
            });
        }

        public final void c() {
            this.f4557c = true;
            this.b.removeCallbacksAndMessages(null);
        }
    }

    @Deprecated
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/a/c$d.class */
    public interface d {
        void a();

        void b();

        void c();

        void d();
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/a/c$e.class */
    public interface e {
        int[] a();

        s b(Uri uri);
    }

    private c(s sVar, e eVar, com.anythink.expressad.exoplayer.h.a.b bVar, ViewGroup viewGroup) {
        this(sVar, eVar, bVar, viewGroup, (Handler) null, (d) null);
    }

    /* JADX WARN: Type inference failed for: r1v10, types: [com.anythink.expressad.exoplayer.h.s[], com.anythink.expressad.exoplayer.h.s[][]] */
    /* JADX WARN: Type inference failed for: r1v12, types: [long[], long[][]] */
    @Deprecated
    private c(s sVar, e eVar, com.anythink.expressad.exoplayer.h.a.b bVar, ViewGroup viewGroup, Handler handler, d dVar) {
        this.b = sVar;
        this.f4547c = eVar;
        this.d = bVar;
        this.e = viewGroup;
        this.f = handler;
        this.g = dVar;
        this.h = new Handler(Looper.getMainLooper());
        this.i = new HashMap();
        this.j = new ae.a();
        this.o = new s[0];
        this.p = new long[0];
    }

    private c(s sVar, h.a aVar, com.anythink.expressad.exoplayer.h.a.b bVar, ViewGroup viewGroup) {
        this(sVar, new o.c(aVar), bVar, viewGroup, (Handler) null, (d) null);
    }

    @Deprecated
    private c(s sVar, h.a aVar, com.anythink.expressad.exoplayer.h.a.b bVar, ViewGroup viewGroup, Handler handler, d dVar) {
        this(sVar, new o.c(aVar), bVar, viewGroup, handler, dVar);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static s.a a2(s.a aVar, s.a aVar2) {
        return aVar.a() ? aVar : aVar2;
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [java.lang.Object[], long[], long[][]] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object[], com.anythink.expressad.exoplayer.h.s[], com.anythink.expressad.exoplayer.h.s[][]] */
    private void a(com.anythink.expressad.exoplayer.h.a.a aVar) {
        if (this.n == null) {
            ?? r0 = new s[aVar.g];
            this.o = r0;
            Arrays.fill((Object[]) r0, new s[0]);
            ?? r02 = new long[aVar.g];
            this.p = r02;
            Arrays.fill((Object[]) r02, new long[0]);
        }
        this.n = aVar;
        c();
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [java.lang.Object[], long[], long[][]] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object[], com.anythink.expressad.exoplayer.h.s[], com.anythink.expressad.exoplayer.h.s[][]] */
    static /* synthetic */ void a(c cVar, com.anythink.expressad.exoplayer.h.a.a aVar) {
        if (cVar.n == null) {
            ?? r0 = new s[aVar.g];
            cVar.o = r0;
            Arrays.fill((Object[]) r0, new s[0]);
            ?? r02 = new long[aVar.g];
            cVar.p = r02;
            Arrays.fill((Object[]) r02, new long[0]);
        }
        cVar.n = aVar;
        cVar.c();
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private void a2(s.a aVar, s sVar, ae aeVar, Object obj) {
        if (!aVar.a()) {
            this.l = aeVar;
            this.m = obj;
            c();
            return;
        }
        int i = aVar.b;
        int i2 = aVar.f4646c;
        com.anythink.expressad.exoplayer.k.a.a(aeVar.c() == 1);
        this.p[i][i2] = aeVar.a(0, this.j, false).d;
        if (this.i.containsKey(sVar)) {
            List<l> list = this.i.get(sVar);
            for (int i3 = 0; i3 < list.size(); i3++) {
                list.get(i3).f();
            }
            this.i.remove(sVar);
        }
        c();
    }

    private void a(s sVar, int i, int i2, ae aeVar) {
        boolean z = true;
        if (aeVar.c() != 1) {
            z = false;
        }
        com.anythink.expressad.exoplayer.k.a.a(z);
        this.p[i][i2] = aeVar.a(0, this.j, false).d;
        if (this.i.containsKey(sVar)) {
            List<l> list = this.i.get(sVar);
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= list.size()) {
                    break;
                }
                list.get(i4).f();
                i3 = i4 + 1;
            }
            this.i.remove(sVar);
        }
        c();
    }

    private void b(ae aeVar, Object obj) {
        this.l = aeVar;
        this.m = obj;
        c();
    }

    private void c() {
        com.anythink.expressad.exoplayer.h.a.a aVar = this.n;
        if (aVar == null || this.l == null) {
            return;
        }
        com.anythink.expressad.exoplayer.h.a.a a2 = aVar.a(this.p);
        this.n = a2;
        a(a2.g == 0 ? this.l : new com.anythink.expressad.exoplayer.h.a.d(this.l, this.n), this.m);
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final r a(s.a aVar, com.anythink.expressad.exoplayer.j.b bVar) {
        if (this.n.g <= 0 || !aVar.a()) {
            l lVar = new l(this.b, aVar, bVar);
            lVar.f();
            return lVar;
        }
        int i = aVar.b;
        int i2 = aVar.f4646c;
        Uri uri = this.n.i[i].b[i2];
        if (this.o[i].length <= i2) {
            s b2 = this.f4547c.b(uri);
            s[][] sVarArr = this.o;
            int length = sVarArr[i].length;
            if (i2 >= length) {
                int i3 = i2 + 1;
                sVarArr[i] = (s[]) Arrays.copyOf(sVarArr[i], i3);
                long[][] jArr = this.p;
                jArr[i] = Arrays.copyOf(jArr[i], i3);
                Arrays.fill(this.p[i], length, i3, (long) com.anythink.expressad.exoplayer.b.b);
            }
            this.o[i][i2] = b2;
            this.i.put(b2, new ArrayList());
            a((c) aVar, b2);
        }
        s sVar = this.o[i][i2];
        l lVar2 = new l(sVar, new s.a(0, aVar.d), bVar);
        lVar2.a(new b(uri, i, i2));
        List<l> list = this.i.get(sVar);
        if (list == null) {
            lVar2.f();
            return lVar2;
        }
        list.add(lVar2);
        return lVar2;
    }

    @Override // com.anythink.expressad.exoplayer.h.f
    public final /* bridge */ /* synthetic */ s.a a(s.a aVar, s.a aVar2) {
        s.a aVar3 = aVar;
        return aVar3.a() ? aVar3 : aVar2;
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [com.anythink.expressad.exoplayer.h.s[], com.anythink.expressad.exoplayer.h.s[][]] */
    /* JADX WARN: Type inference failed for: r1v7, types: [long[], long[][]] */
    @Override // com.anythink.expressad.exoplayer.h.f, com.anythink.expressad.exoplayer.h.c
    public final void a() {
        super.a();
        this.k.c();
        this.k = null;
        this.i.clear();
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = new s[0];
        this.p = new long[0];
        this.h.post(new Runnable() { // from class: com.anythink.expressad.exoplayer.h.a.c.2
            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.expressad.exoplayer.h.a.b unused = c.this.d;
            }
        });
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final void a(r rVar) {
        l lVar = (l) rVar;
        List<l> list = this.i.get(lVar.f4626a);
        if (list != null) {
            list.remove(lVar);
        }
        lVar.g();
    }

    @Override // com.anythink.expressad.exoplayer.h.f, com.anythink.expressad.exoplayer.h.c
    public final void a(final com.anythink.expressad.exoplayer.h hVar, boolean z) {
        super.a(hVar, z);
        com.anythink.expressad.exoplayer.k.a.a(z);
        final C0061c c0061c = new C0061c();
        this.k = c0061c;
        a((c) new s.a(0), this.b);
        this.h.post(new Runnable() { // from class: com.anythink.expressad.exoplayer.h.a.c.1
            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.expressad.exoplayer.h.a.b unused = c.this.d;
                ViewGroup unused2 = c.this.e;
            }
        });
    }

    @Override // com.anythink.expressad.exoplayer.h.f
    public final /* synthetic */ void a(s.a aVar, s sVar, ae aeVar, Object obj) {
        s.a aVar2 = aVar;
        if (!aVar2.a()) {
            this.l = aeVar;
            this.m = obj;
            c();
            return;
        }
        int i = aVar2.b;
        int i2 = aVar2.f4646c;
        com.anythink.expressad.exoplayer.k.a.a(aeVar.c() == 1);
        this.p[i][i2] = aeVar.a(0, this.j, false).d;
        if (this.i.containsKey(sVar)) {
            List<l> list = this.i.get(sVar);
            for (int i3 = 0; i3 < list.size(); i3++) {
                list.get(i3).f();
            }
            this.i.remove(sVar);
        }
        c();
    }
}
