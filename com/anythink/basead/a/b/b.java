package com.anythink.basead.a.b;

import android.text.TextUtils;
import com.anythink.basead.a.b.d;
import com.anythink.basead.mraid.MraidWebView;
import com.anythink.basead.mraid.d;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.anythink.core.common.e.k;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/a/b/b.class */
public class b implements d.a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5835a = b.class.getSimpleName();
    i b;

    /* renamed from: c  reason: collision with root package name */
    k f5836c;
    j d;
    Runnable e = new Runnable() { // from class: com.anythink.basead.a.b.b.1
        @Override // java.lang.Runnable
        public final void run() {
            b.this.a(com.anythink.basead.c.f.a("20001", com.anythink.basead.c.f.p));
        }
    };
    private String f;
    private boolean g;
    private int h;
    private String i;
    private List<String> j;
    private InterfaceC0067b k;
    private com.anythink.basead.a.a.c<Void, com.anythink.basead.c.e> l;
    private MraidWebView m;
    private volatile boolean n;

    /* renamed from: com.anythink.basead.a.b.b$2  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/a/b/b$2.class */
    final class AnonymousClass2 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f5838a;
        final /* synthetic */ String b;

        AnonymousClass2(String str, String str2) {
            this.f5838a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.this.m = new MraidWebView(n.a().g());
            com.anythink.basead.mraid.d.a(this.f5838a, this.b, b.this.m, new d.a() { // from class: com.anythink.basead.a.b.b.2.1
                @Override // com.anythink.basead.mraid.d.a
                public final void a() {
                    b.this.b();
                }

                @Override // com.anythink.basead.mraid.d.a
                public final void a(com.anythink.basead.c.e eVar) {
                    b.this.a(eVar);
                }
            });
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/a/b/b$a.class */
    final class a implements com.anythink.basead.a.a.b<Void, com.anythink.basead.c.e> {
        private a() {
        }

        /* synthetic */ a(b bVar, byte b) {
            this();
        }

        /* renamed from: a  reason: avoid collision after fix types in other method */
        private void a2(com.anythink.basead.c.e eVar) {
            if (b.this.k != null) {
                String str = b.f5835a;
                new StringBuilder("Offer load failed, OfferId -> ").append(b.this.i);
                b.this.k.a(eVar);
            }
            b.e(b.this);
        }

        private void b() {
            if (b.this.k != null) {
                String str = b.f5835a;
                new StringBuilder("Offer load success, OfferId -> ").append(b.this.i);
                b.this.k.a();
            }
            b.e(b.this);
        }

        @Override // com.anythink.basead.a.a.b
        public final /* synthetic */ void a() {
            if (b.this.k != null) {
                String str = b.f5835a;
                new StringBuilder("Offer load success, OfferId -> ").append(b.this.i);
                b.this.k.a();
            }
            b.e(b.this);
        }

        @Override // com.anythink.basead.a.a.b
        public final /* synthetic */ void a(com.anythink.basead.c.e eVar) {
            com.anythink.basead.c.e eVar2 = eVar;
            if (b.this.k != null) {
                String str = b.f5835a;
                new StringBuilder("Offer load failed, OfferId -> ").append(b.this.i);
                b.this.k.a(eVar2);
            }
            b.e(b.this);
        }
    }

    /* renamed from: com.anythink.basead.a.b.b$b  reason: collision with other inner class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/a/b/b$b.class */
    public interface InterfaceC0067b {
        void a();

        void a(com.anythink.basead.c.e eVar);
    }

    public b(String str, boolean z, i iVar, j jVar) {
        this.f = str;
        this.g = z;
        this.b = iVar;
        this.d = jVar;
        k kVar = jVar.m;
        this.f5836c = kVar;
        this.h = kVar.m();
        com.anythink.basead.a.b.a aVar = new com.anythink.basead.a.b.a();
        this.l = aVar;
        aVar.a((com.anythink.basead.a.a.b) new a(this, (byte) 0));
    }

    private void a() {
        List<String> b = this.b.b((i) this.f5836c);
        if (b == null) {
            a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.l, "Incomplete resource allocation! MissResource: ".concat(String.valueOf(this.b.m()))));
            return;
        }
        int size = b.size();
        if (size == 0) {
            b();
            return;
        }
        this.j = new ArrayList(size);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                break;
            }
            String str = b.get(i2);
            if (!TextUtils.isEmpty(str)) {
                if (this.b.D(str)) {
                    if (!c.b(str, this.f5836c.S()) && !this.j.contains(str)) {
                        StringBuilder sb = new StringBuilder("videoInfo:video file is not ready to play -> ");
                        sb.append(str);
                        sb.append(",need readyRate:");
                        sb.append(this.f5836c.S());
                        this.j.add(str);
                    }
                } else if (!c.c(str) && !this.j.contains(str)) {
                    this.j.add(str);
                }
            }
            i = i2 + 1;
        }
        int size2 = this.j.size();
        if (size2 == 0) {
            StringBuilder sb2 = new StringBuilder("Offer(");
            sb2.append(this.i);
            sb2.append("), all files have already exist");
            b();
            return;
        }
        d.a().a(this);
        synchronized (this) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < size2) {
                    String str2 = this.j.get(i4);
                    boolean D = this.b.D(str2);
                    int S = this.f5836c.S();
                    if (D) {
                        if (c.b(str2, S)) {
                            StringBuilder sb3 = new StringBuilder("Video file ready -> ");
                            sb3.append(str2);
                            sb3.append(",videoNeedReadyRate:");
                            sb3.append(S);
                            d.a().a(str2, S);
                        } else {
                            StringBuilder sb4 = new StringBuilder("Video file not exis -> ");
                            sb4.append(str2);
                            sb4.append(",videoNeedReadyRate:");
                            sb4.append(S);
                            new f(this.f, this.b, this.f5836c).a();
                        }
                    } else if (!c.a(str2)) {
                        if (c.c(str2)) {
                            c.a(str2, 100);
                            d.a().a(str2, 100);
                        } else {
                            c.a(str2, 0);
                            new e(this.f, this.g, this.b, str2).d();
                        }
                    }
                    i3 = i4 + 1;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.anythink.basead.c.e eVar) {
        this.n = true;
        com.anythink.basead.a.a.c<Void, com.anythink.basead.c.e> cVar = this.l;
        if (cVar != null) {
            cVar.a((com.anythink.basead.a.a.c<Void, com.anythink.basead.c.e>) eVar);
        }
    }

    private void a(boolean z) {
        String a2 = com.anythink.basead.mraid.d.a(this.d, this.b);
        if (TextUtils.isEmpty(a2)) {
            a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.F, com.anythink.basead.c.f.L));
        } else if (!z) {
            b();
        } else {
            n.a().a(new AnonymousClass2(c.a(this.d, this.b), a2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        com.anythink.basead.a.a.c<Void, com.anythink.basead.c.e> cVar = this.l;
        if (cVar != null) {
            cVar.a();
        }
    }

    private void c() {
        d.a().b(this);
        n.a().c(this.e);
    }

    private void d() {
        n.a().a(this.e, this.h);
    }

    static /* synthetic */ void e(b bVar) {
        d.a().b(bVar);
        n.a().c(bVar.e);
    }

    public final void a(InterfaceC0067b interfaceC0067b) {
        i iVar = this.b;
        if (iVar == null || this.l == null) {
            a(com.anythink.basead.c.f.a("-9999", com.anythink.basead.c.f.w));
            return;
        }
        this.i = iVar.p();
        this.k = interfaceC0067b;
        n.a().a(this.e, this.h);
        if (!this.b.g()) {
            this.l.a(1);
            a();
            return;
        }
        boolean z = false;
        this.n = false;
        k kVar = this.f5836c;
        if (kVar != null) {
            String valueOf = String.valueOf(kVar.t());
            if (valueOf.equals("1") || valueOf.equals("3")) {
                z = true;
            }
            this.l.a(1);
            if (z) {
                this.l.a(2);
                a();
            }
            if (this.n) {
                return;
            }
            boolean V = this.f5836c.V();
            String a2 = com.anythink.basead.mraid.d.a(this.d, this.b);
            if (TextUtils.isEmpty(a2)) {
                a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.F, com.anythink.basead.c.f.L));
            } else if (!V) {
                b();
            } else {
                n.a().a(new AnonymousClass2(c.a(this.d, this.b), a2));
            }
        }
    }

    @Override // com.anythink.basead.a.b.d.a
    public final void a(String str, int i) {
        synchronized (this) {
            c.a(str, i);
            if (this.j.contains(str) && ((!this.b.D(str) || this.f5836c.S() <= i) && this.j != null)) {
                this.j.remove(str);
                StringBuilder sb = new StringBuilder();
                sb.append(this.i);
                sb.append(" onResourceLoadSuccess -> resourceUrl:");
                sb.append(str);
                sb.append(",curmUrlList.size():");
                sb.append(this.j.size());
                if (this.j.size() == 0) {
                    b();
                }
            }
        }
    }

    @Override // com.anythink.basead.a.b.d.a
    public final void a(String str, com.anythink.basead.c.e eVar) {
        synchronized (this) {
            c.a(str, -1);
            a(eVar);
        }
    }
}
