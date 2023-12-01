package com.anythink.expressad.foundation.g.f.d;

import com.anythink.expressad.foundation.g.f.i;
import com.anythink.expressad.foundation.g.f.j;
import com.anythink.expressad.foundation.g.f.k;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/f/d/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private j f7880a;

    /* renamed from: c  reason: collision with root package name */
    private LinkedList<a> f7881c = new LinkedList<>();
    private int b = 3;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/f/d/b$a.class */
    public final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final int f7882a = 0;
        public static final int b = 1;

        /* renamed from: c  reason: collision with root package name */
        public static final int f7883c = 2;
        public static final int d = 3;
        public static final int e = 4;
        private String g;
        private File h;
        private com.anythink.expressad.foundation.g.f.e<Void> i;
        private com.anythink.expressad.foundation.g.f.d.a j;
        private int k;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.anythink.expressad.foundation.g.f.d.b$a$1  reason: invalid class name */
        /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/f/d/b$a$1.class */
        public final class AnonymousClass1 extends com.anythink.expressad.foundation.g.f.f<Void> {

            /* renamed from: a  reason: collision with root package name */
            boolean f7884a;

            AnonymousClass1() {
            }

            @Override // com.anythink.expressad.foundation.g.f.f, com.anythink.expressad.foundation.g.f.e
            public final void a() {
                if (this.f7884a) {
                    return;
                }
                a.c(a.this);
                a.this.i.a();
                b.a(b.this, a.this);
            }

            @Override // com.anythink.expressad.foundation.g.f.f, com.anythink.expressad.foundation.g.f.e
            public final void a(long j, long j2) {
                a.this.i.a(j, j2);
            }

            @Override // com.anythink.expressad.foundation.g.f.f, com.anythink.expressad.foundation.g.f.e
            public final void a(com.anythink.expressad.foundation.g.f.a.a aVar) {
                if (this.f7884a) {
                    return;
                }
                a.this.i.a(aVar);
            }

            @Override // com.anythink.expressad.foundation.g.f.f, com.anythink.expressad.foundation.g.f.e
            public final void a(k kVar) {
                if (this.f7884a) {
                    return;
                }
                a.this.i.a(kVar);
            }

            @Override // com.anythink.expressad.foundation.g.f.f, com.anythink.expressad.foundation.g.f.e
            public final void b() {
                a.this.i.b();
            }

            @Override // com.anythink.expressad.foundation.g.f.f, com.anythink.expressad.foundation.g.f.e
            public final void c() {
                a.this.i.c();
                this.f7884a = true;
            }
        }

        private a(File file, String str, com.anythink.expressad.foundation.g.f.e<Void> eVar) {
            this.h = file;
            this.i = eVar;
            this.g = str;
        }

        /* synthetic */ a(b bVar, File file, String str, com.anythink.expressad.foundation.g.f.e eVar, byte b2) {
            this(file, str, eVar);
        }

        private a(b bVar, String str, String str2, com.anythink.expressad.foundation.g.f.e<Void> eVar) {
            this(new File(str), str2, eVar);
        }

        static /* synthetic */ boolean a(a aVar) {
            if (aVar.k != 0) {
                return false;
            }
            com.anythink.expressad.foundation.g.f.d.a aVar2 = new com.anythink.expressad.foundation.g.f.d.a(aVar.h, aVar.g);
            aVar.j = aVar2;
            aVar2.a((com.anythink.expressad.foundation.g.f.e) new AnonymousClass1());
            aVar.k = 1;
            b.this.f7880a.a((i) aVar.j);
            return true;
        }

        static /* synthetic */ int c(a aVar) {
            aVar.k = 3;
            return 3;
        }

        private boolean c() {
            if (this.k != 0) {
                return false;
            }
            com.anythink.expressad.foundation.g.f.d.a aVar = new com.anythink.expressad.foundation.g.f.d.a(this.h, this.g);
            this.j = aVar;
            aVar.a((com.anythink.expressad.foundation.g.f.e) new AnonymousClass1());
            this.k = 1;
            b.this.f7880a.a((i) this.j);
            return true;
        }

        private int d() {
            return this.k;
        }

        private boolean e() {
            int i = this.k;
            if (i == 0) {
                this.k = 2;
                b.this.b();
                return true;
            } else if (i != 1) {
                return false;
            } else {
                this.j.e();
                this.k = 2;
                b.this.b();
                return true;
            }
        }

        private boolean f() {
            if (this.k == 2) {
                this.k = 0;
                b.this.b();
                return true;
            }
            return false;
        }

        public final boolean a() {
            return this.k == 1;
        }

        public final boolean b() {
            int i = this.k;
            if (i == 4 || i == 3) {
                return false;
            }
            if (i == 1) {
                this.j.e();
            }
            this.k = 4;
            b.a(b.this, this);
            return true;
        }
    }

    public b(j jVar) {
        this.f7880a = jVar;
    }

    private static com.anythink.expressad.foundation.g.f.d.a a(File file, String str) {
        return new com.anythink.expressad.foundation.g.f.d.a(file, str);
    }

    private a a(String str, String str2, com.anythink.expressad.foundation.g.f.e<Void> eVar) {
        return a(new File(str), str2, eVar);
    }

    private void a(a aVar) {
        synchronized (this) {
            this.f7881c.remove(aVar);
        }
        b();
    }

    static /* synthetic */ void a(b bVar, a aVar) {
        synchronized (bVar) {
            bVar.f7881c.remove(aVar);
        }
        bVar.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        synchronized (this) {
            int i = 0;
            Iterator<a> it = this.f7881c.iterator();
            while (it.hasNext()) {
                if (it.next().a()) {
                    i++;
                }
            }
            if (i >= this.b) {
                return;
            }
            Iterator<a> it2 = this.f7881c.iterator();
            while (it2.hasNext()) {
                if (a.a(it2.next())) {
                    int i2 = i + 1;
                    i = i2;
                    if (i2 == this.b) {
                        return;
                    }
                }
            }
        }
    }

    public final a a(File file, String str, com.anythink.expressad.foundation.g.f.e<Void> eVar) {
        a aVar = new a(this, file, str, eVar, (byte) 0);
        synchronized (this) {
            this.f7881c.add(aVar);
        }
        b();
        return aVar;
    }

    public final void a() {
        synchronized (this) {
            while (!this.f7881c.isEmpty()) {
                this.f7881c.get(0).b();
            }
        }
    }
}
