package com.anythink.basead.d;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.basead.a.c;
import com.anythink.basead.d.a.a;
import com.anythink.basead.d.b.a;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.aa;
import com.anythink.core.common.e.ab;
import com.anythink.core.common.e.j;
import com.anythink.core.common.e.z;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/d/b.class */
public abstract class b {
    private a a;
    protected Context b;
    protected j c;
    protected c d;
    protected aa e;
    protected com.anythink.core.common.a.g f;
    protected com.anythink.basead.a.c g;
    protected com.anythink.basead.e.a h;
    protected ConcurrentHashMap<String, com.anythink.basead.a.c> i;
    protected String j;
    private boolean k = false;

    /* renamed from: com.anythink.basead.d.b$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/d/b$1.class */
    final class AnonymousClass1 implements a.InterfaceC0032a {
        final /* synthetic */ com.anythink.basead.e.c a;

        AnonymousClass1(com.anythink.basead.e.c cVar) {
            this.a = cVar;
        }

        @Override // com.anythink.basead.d.a.a.InterfaceC0032a
        public final void a(com.anythink.core.common.e.g gVar) {
            b.this.a(gVar);
            com.anythink.basead.e.c cVar = this.a;
            if (cVar != null) {
                cVar.onAdDataLoaded();
            }
        }

        @Override // com.anythink.basead.d.a.a.InterfaceC0032a
        public final void a(com.anythink.core.common.e.g gVar, com.anythink.basead.c.e eVar) {
            b.a(b.this, gVar, eVar, this.a, true);
        }

        @Override // com.anythink.basead.d.a.a.InterfaceC0032a
        public final void a(com.anythink.core.common.e.g gVar, com.anythink.core.common.a.g gVar2) {
            b.this.e = gVar;
            b.this.f = gVar2;
            b bVar = b.this;
            bVar.g = new com.anythink.basead.a.c(bVar.b, b.this.c, b.this.e);
            b.this.g.a(new c.b() { // from class: com.anythink.basead.d.b.1.1
                @Override // com.anythink.basead.a.c.b
                public final void a() {
                    if (b.this.h != null) {
                        b.this.h.onAdClick(1);
                    }
                }

                @Override // com.anythink.basead.a.c.b
                public final void a(boolean z) {
                    if (b.this.h != null) {
                        b.this.h.onDeeplinkCallback(z);
                    }
                }

                @Override // com.anythink.basead.a.c.b
                public final void b() {
                }
            });
            com.anythink.basead.a.b.a(33, gVar, new com.anythink.basead.c.i(b.this.c.d, ""));
            b.a(b.this);
            com.anythink.basead.e.c cVar = this.a;
            if (cVar != null) {
                cVar.onAdCacheLoaded();
            }
        }
    }

    /* renamed from: com.anythink.basead.d.b$2  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/d/b$2.class */
    final class AnonymousClass2 implements a.InterfaceC0035a {
        final /* synthetic */ com.anythink.basead.e.c a;

        AnonymousClass2(com.anythink.basead.e.c cVar) {
            this.a = cVar;
        }

        @Override // com.anythink.basead.d.b.a.InterfaceC0035a
        public final void a() {
            com.anythink.basead.e.c cVar = this.a;
            if (cVar != null) {
                cVar.onAdDataLoaded();
            }
        }

        @Override // com.anythink.basead.d.b.a.InterfaceC0035a
        public final void a(z zVar) {
            b.this.e = zVar;
            com.anythink.basead.a.b.a(33, b.this.e, new com.anythink.basead.c.i(b.this.c.d, ""));
            b.a(b.this);
            com.anythink.basead.e.c cVar = this.a;
            if (cVar != null) {
                cVar.onAdCacheLoaded();
            }
        }

        @Override // com.anythink.basead.d.b.a.InterfaceC0035a
        public final void a(z zVar, com.anythink.basead.c.e eVar) {
            b.a(b.this, zVar, eVar, this.a, false);
        }
    }

    /* renamed from: com.anythink.basead.d.b$4  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/d/b$4.class */
    static final /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:7:0x0020 -> B:11:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[a.values().length];
            a = iArr;
            try {
                iArr[a.ADX_OFFER_REQUEST_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[a.ONLINE_API_OFFER_REQUEST_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/d/b$a.class */
    public enum a {
        ADX_OFFER_REQUEST_TYPE,
        ONLINE_API_OFFER_REQUEST_TYPE
    }

    public b(Context context, a aVar, j jVar) {
        this.b = context.getApplicationContext();
        this.a = aVar;
        this.c = jVar;
    }

    static /* synthetic */ void a(b bVar, com.anythink.core.common.e.i iVar, com.anythink.basead.c.e eVar, com.anythink.basead.e.c cVar, boolean z) {
        if (iVar != null) {
            com.anythink.basead.a.b.a(34, iVar, new com.anythink.basead.c.i(bVar.c.d, ""));
        }
        if (iVar instanceof z) {
            com.anythink.core.basead.b.a();
            Context g = n.a().g();
            com.anythink.core.basead.b.a();
            com.anythink.core.basead.b.b(g, com.anythink.core.basead.b.a(bVar.c));
        }
        if (z) {
            try {
                com.anythink.core.b.f.a().a(bVar.c.c);
                com.anythink.core.b.f.a();
                com.anythink.core.b.f.b(bVar.c.c);
                com.anythink.core.common.a.a.a().b(n.a().g(), bVar.c.a);
            } catch (Throwable th) {
            }
        }
        if (cVar != null) {
            cVar.onAdLoadFailed(eVar);
        }
    }

    private void a(com.anythink.core.common.e.i iVar, com.anythink.basead.c.e eVar, com.anythink.basead.e.c cVar, boolean z) {
        if (iVar != null) {
            com.anythink.basead.a.b.a(34, iVar, new com.anythink.basead.c.i(this.c.d, ""));
        }
        if (iVar instanceof z) {
            com.anythink.core.basead.b.a();
            Context g = n.a().g();
            com.anythink.core.basead.b.a();
            com.anythink.core.basead.b.b(g, com.anythink.core.basead.b.a(this.c));
        }
        if (z) {
            try {
                com.anythink.core.b.f.a().a(this.c.c);
                com.anythink.core.b.f.a();
                com.anythink.core.b.f.b(this.c.c);
                com.anythink.core.common.a.a.a().b(n.a().g(), this.c.a);
            } catch (Throwable th) {
            }
        }
        if (cVar != null) {
            cVar.onAdLoadFailed(eVar);
        }
    }

    static /* synthetic */ boolean a(b bVar) {
        bVar.k = true;
        return true;
    }

    private void b(com.anythink.basead.e.c cVar) {
        try {
            if (this.c != null && !TextUtils.isEmpty(this.c.b) && !TextUtils.isEmpty(this.c.a)) {
                com.anythink.basead.d.a.a.a(this.b).a(this.c, new AnonymousClass1(cVar));
                return;
            }
            if (cVar != null) {
                cVar.onAdLoadFailed(com.anythink.basead.c.f.a(com.anythink.basead.c.f.i, com.anythink.basead.c.f.v));
            }
        } catch (Throwable th) {
            th.printStackTrace();
            if (cVar != null) {
                cVar.onAdLoadFailed(com.anythink.basead.c.f.a("-9999", th.getMessage()));
            }
        }
    }

    private void c(com.anythink.basead.e.c cVar) {
        try {
            com.anythink.basead.d.b.a.a(this.b).a(this.c, this.j, new AnonymousClass2(cVar));
        } catch (Throwable th) {
            th.printStackTrace();
            if (cVar != null) {
                cVar.onAdLoadFailed(com.anythink.basead.c.f.a("-9999", th.getMessage()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String a(aa aaVar) {
        return this.c.b + this.c.c + this.c.f + aaVar.p() + System.currentTimeMillis();
    }

    public final void a(c cVar) {
        this.d = cVar;
        if (this.c.m instanceof ab) {
            ab abVar = (ab) this.c.m;
            c cVar2 = this.d;
            if (abVar == null || cVar2 == null) {
                return;
            }
            abVar.v(cVar2.a());
            abVar.w(cVar2.b());
            abVar.a(cVar2.d());
            abVar.p(cVar2.c());
            abVar.o(cVar2.e());
            abVar.b(cVar2.f());
            abVar.n(cVar2.g());
            abVar.a(cVar2.h());
            abVar.b(cVar2.i());
            abVar.b(cVar2.j());
        }
    }

    public final void a(com.anythink.basead.e.a aVar) {
        this.h = aVar;
    }

    public final void a(com.anythink.basead.e.c cVar) {
        int i = AnonymousClass4.a[this.a.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return;
            }
            try {
                com.anythink.basead.d.b.a.a(this.b).a(this.c, this.j, new AnonymousClass2(cVar));
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                cVar.onAdLoadFailed(com.anythink.basead.c.f.a("-9999", th.getMessage()));
                return;
            }
        }
        try {
            if (this.c != null && !TextUtils.isEmpty(this.c.b) && !TextUtils.isEmpty(this.c.a)) {
                com.anythink.basead.d.a.a.a(this.b).a(this.c, new AnonymousClass1(cVar));
                return;
            }
            cVar.onAdLoadFailed(com.anythink.basead.c.f.a(com.anythink.basead.c.f.i, com.anythink.basead.c.f.v));
        } catch (Throwable th2) {
            th2.printStackTrace();
            cVar.onAdLoadFailed(com.anythink.basead.c.f.a("-9999", th2.getMessage()));
        }
    }

    protected final void a(com.anythink.core.common.e.g gVar) {
        if (gVar.c() == 1) {
            com.anythink.core.common.a.b.a().b();
            if (com.anythink.core.common.k.h.a(this.b, gVar.B())) {
                StringBuilder sb = new StringBuilder("check offer installed(onAdDataLoaded):ture,dsp offerid:");
                sb.append(gVar.U());
                sb.append(",packagename:");
                sb.append(gVar.B());
                com.anythink.core.common.a.b.a().c(gVar);
                return;
            }
            StringBuilder sb2 = new StringBuilder("check offer installed(onAdDataLoaded):false,need record show,dsp offerid:");
            sb2.append(gVar.U());
            sb2.append(",packagename:");
            sb2.append(gVar.B());
            com.anythink.core.common.a.b.a().a(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(com.anythink.expressad.foundation.d.c cVar, String str) {
        synchronized (this) {
            try {
                if (this.g == null) {
                    return;
                }
                if (this.i == null) {
                    this.i = new ConcurrentHashMap<>(2);
                }
                com.anythink.basead.a.c cVar2 = this.i.get(cVar.aZ());
                com.anythink.basead.a.c cVar3 = cVar2;
                if (cVar2 == null) {
                    cVar3 = com.anythink.basead.d.a.b.a(this.g, cVar);
                    this.i.put(cVar.aZ(), cVar3);
                }
                if (cVar3 != null) {
                    com.anythink.basead.c.i iVar = new com.anythink.basead.c.i(this.c.d, str);
                    iVar.g = new com.anythink.basead.c.a();
                    cVar3.a(new c.b() { // from class: com.anythink.basead.d.b.3
                        @Override // com.anythink.basead.a.c.b
                        public final void a() {
                            if (b.this.h != null) {
                                b.this.h.onAdClick(1);
                            }
                        }

                        @Override // com.anythink.basead.a.c.b
                        public final void a(boolean z) {
                            if (b.this.h != null) {
                                b.this.h.onDeeplinkCallback(z);
                            }
                        }

                        @Override // com.anythink.basead.a.c.b
                        public final void b() {
                        }
                    });
                    cVar3.a(iVar);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void a(String str) {
        this.j = str;
    }

    public void b() {
        this.e = null;
    }

    public final boolean c() {
        int i = AnonymousClass4.a[this.a.ordinal()];
        if (i == 1) {
            if (this.e == null) {
                this.e = com.anythink.basead.d.a.a.a(this.b).a(this.c);
            }
            com.anythink.core.common.a.g gVar = this.f;
            if (gVar != null) {
                return gVar.isReady();
            }
            if (this.k) {
                return true;
            }
            aa aaVar = this.e;
            if (aaVar == null || !com.anythink.basead.a.b.c.a(aaVar, this.c)) {
                return false;
            }
            this.k = true;
            return true;
        } else if (i != 2) {
            return false;
        } else {
            if (this.e == null) {
                this.e = com.anythink.basead.d.b.a.a(this.b).a(this.c);
            }
            if (this.k) {
                return true;
            }
            aa aaVar2 = this.e;
            if (aaVar2 == null || !(aaVar2 instanceof z) || ((z) aaVar2).N() || !com.anythink.basead.a.b.c.a(this.e, this.c)) {
                return false;
            }
            this.k = true;
            return true;
        }
    }

    public final com.anythink.core.common.e.i d() {
        return this.e;
    }
}
