package com.anythink.expressad.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import com.anythink.expressad.a.c;
import com.anythink.expressad.a.f;
import com.anythink.expressad.a.g;
import com.anythink.expressad.foundation.g.g.a;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.s;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.util.concurrent.Semaphore;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/a/h.class */
public final class h extends d implements a.b {

    /* renamed from: a  reason: collision with root package name */
    public static final int f6978a = 1;
    public static final int i = 2;
    private static final String j = "302";
    private e m;
    private c.b n;
    private boolean p;
    private Context q;
    private com.anythink.expressad.foundation.g.g.c r;
    private f.a s;
    private boolean k = false;
    private long l = 0;
    private boolean o = true;
    private Handler t = new Handler(Looper.getMainLooper());
    private boolean u = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/a/h$a.class */
    public final class a extends com.anythink.expressad.foundation.g.g.a {
        private static final int h = 10;
        private final Context f;
        private String g;
        private String i;
        private String j;
        private String k;
        private com.anythink.expressad.c.b l;
        private com.anythink.expressad.foundation.d.c m;
        private boolean n;
        private boolean o;
        private int p;
        private final Semaphore e = new Semaphore(0);
        private g.a q = new g.a() { // from class: com.anythink.expressad.a.h.a.1
            private void b() {
                synchronized (h.this) {
                    h.this.n.a(true);
                    a.a(a.this);
                }
            }

            @Override // com.anythink.expressad.a.g.a
            public final void a(String str, String str2) {
                a.this.a(str);
                h.this.n.c(str2);
                a.a(a.this, true, false);
                b();
            }

            @Override // com.anythink.expressad.a.g.a
            public final void a(String str, String str2, String str3) {
                if (!TextUtils.isEmpty(str2)) {
                    h.this.n.b(str2);
                }
                if (!TextUtils.isEmpty(str3)) {
                    h.this.n.c(str3);
                }
                a.this.a(str);
                a.a(a.this, true, false);
                b();
            }

            @Override // com.anythink.expressad.a.g.a
            public final boolean a() {
                a.a(a.this, false, false);
                return false;
            }

            @Override // com.anythink.expressad.a.g.a
            public final boolean a(String str) {
                boolean a2 = a.this.a(str);
                a.a(a.this, false, true);
                if (a2) {
                    b();
                }
                return a2;
            }

            @Override // com.anythink.expressad.a.g.a
            public final boolean b(String str) {
                boolean a2 = a.this.a(str);
                a.a(a.this, false, true);
                if (a2) {
                    a.a(a.this, true, true);
                    b();
                }
                return a2;
            }
        };

        public a(Context context, String str, String str2, String str3, String str4, com.anythink.expressad.c.b bVar, com.anythink.expressad.foundation.d.c cVar, boolean z, boolean z2, int i) {
            this.f = context;
            this.g = str;
            this.i = str2;
            this.j = str3;
            this.k = str4;
            this.l = bVar;
            this.m = cVar;
            this.n = z;
            this.o = z2;
            this.p = i;
        }

        /* JADX WARN: Code restructure failed: missing block: B:70:0x0286, code lost:
            return r0;
         */
        /* JADX WARN: Removed duplicated region for block: B:125:0x03cb A[EDGE_INSN: B:125:0x03cb->B:108:0x03cb ?: BREAK  , SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00bb  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private com.anythink.expressad.a.c.b a(java.lang.String r10, boolean r11, boolean r12, com.anythink.expressad.foundation.d.c r13, int r14) {
            /*
                Method dump skipped, instructions count: 997
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.a.h.a.a(java.lang.String, boolean, boolean, com.anythink.expressad.foundation.d.c, int):com.anythink.expressad.a.c$b");
        }

        static /* synthetic */ void a(a aVar) {
            aVar.e.release();
        }

        static /* synthetic */ void a(a aVar, boolean z, boolean z2) {
            if (h.this.l == 0) {
                h.this.l = System.currentTimeMillis();
            } else {
                h.this.l = System.currentTimeMillis();
            }
            if (!z) {
                if (aVar.l != null) {
                    int i = com.anythink.expressad.c.a.b;
                }
            } else if (z2) {
                if (aVar.l == null || h.this.k) {
                    return;
                }
                h.f(h.this);
                int i2 = com.anythink.expressad.c.a.b;
            } else if (aVar.l == null || h.this.k) {
            } else {
                h.f(h.this);
                int i3 = com.anythink.expressad.c.a.b;
            }
        }

        private void a(boolean z, boolean z2) {
            if (h.this.l == 0) {
                h.this.l = System.currentTimeMillis();
            } else {
                h.this.l = System.currentTimeMillis();
            }
            if (!z) {
                if (this.l != null) {
                    int i = com.anythink.expressad.c.a.b;
                }
            } else if (z2) {
                if (this.l == null || h.this.k) {
                    return;
                }
                h.f(h.this);
                int i2 = com.anythink.expressad.c.a.b;
            } else if (this.l == null || h.this.k) {
            } else {
                h.f(h.this);
                int i3 = com.anythink.expressad.c.a.b;
            }
        }

        private static boolean a(int i) {
            return i == 200;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(String str) {
            com.anythink.expressad.foundation.d.c cVar = this.m;
            if (cVar != null) {
                cVar.Q();
            }
            if (s.a.a(str)) {
                h.this.n.c(1);
                h.this.n.e(str);
                h.this.n.b(true);
                return true;
            } else if (!e(str)) {
                h.this.n.c(2);
                h.this.n.e(str);
                return false;
            } else {
                h.this.n.c(3);
                h.this.n.e(str);
                h.this.n.b(true);
                return true;
            }
        }

        private static boolean b(int i) {
            return i == 301 || i == 302 || i == 307;
        }

        private static boolean b(String str) {
            return !URLUtil.isNetworkUrl(str);
        }

        private static boolean c(String str) {
            return str.startsWith(BridgeUtil.SPLIT_MARK);
        }

        private void d() {
            this.e.acquireUninterruptibly();
        }

        private static boolean d(String str) {
            return s.a.a(str);
        }

        private static boolean e(String str) {
            return !TextUtils.isEmpty(str) && str.toLowerCase().contains("apk");
        }

        private void h() {
            this.e.release();
        }

        @Override // com.anythink.expressad.foundation.g.g.a
        public final void a() {
            if (h.this.m != null) {
                e unused = h.this.m;
            }
            h.this.n = new c.b();
            h.this.n.e(this.g);
            h.this.n = a(this.g, this.n, this.o, this.m, this.p);
            if (!TextUtils.isEmpty(h.this.n.e())) {
                h.this.n.a(true);
            }
            if (h.this.o && h.this.n.g()) {
                if (h.this.s != null) {
                    h.this.n.a(h.this.s.f);
                }
                if (!e(h.this.n.j()) && !s.a.a(h.this.n.j()) && 200 == h.this.s.f && !TextUtils.isEmpty(h.this.n.f()) && !h.this.n.f().contains(com.anythink.expressad.foundation.g.a.bU)) {
                    h.this.n.b(2);
                    if (TextUtils.isEmpty(h.this.n.f())) {
                        o.a(h.j, "startWebViewSpider");
                        try {
                            new g(h.this.u).a(this.i, this.j, this.k, this.f, h.this.n.j(), this.q);
                        } catch (Exception e) {
                            o.d("TAG", "webview spider start error");
                        }
                    } else {
                        Log.e(h.j, "startWebViewHtmlParser");
                        new g(h.this.u).a(this.i, this.j, this.k, this.f, h.this.n.j(), h.this.n.f(), this.q);
                        o.d(h.j, "startWebViewHtmlParser");
                    }
                    this.e.acquireUninterruptibly();
                    return;
                }
                if (this.l != null) {
                    h.this.n.j();
                    int i = com.anythink.expressad.c.a.f7121a;
                }
                if (h.this.s != null) {
                    h.this.n.b(1);
                    h.this.n.b(h.this.s.h);
                    h.this.n.a(h.this.s.f);
                    h.this.n.a(h.this.s.a());
                    h.this.n.c(h.this.s.g);
                }
                a(h.this.n.j());
            }
        }

        @Override // com.anythink.expressad.foundation.g.g.a
        public final void b() {
        }

        @Override // com.anythink.expressad.foundation.g.g.a
        public final void c() {
        }
    }

    public h(Context context) {
        this.q = context;
        this.r = new com.anythink.expressad.foundation.g.g.c(context, 2);
    }

    private boolean a() {
        return this.o;
    }

    static /* synthetic */ boolean f(h hVar) {
        hVar.k = true;
        return true;
    }

    @Override // com.anythink.expressad.foundation.g.g.a.b
    public final void a(a.EnumC0147a enumC0147a) {
        if (enumC0147a == a.EnumC0147a.FINISH && this.o) {
            this.t.post(new Runnable() { // from class: com.anythink.expressad.a.h.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (h.this.m != null) {
                        if (h.this.n.g()) {
                            e unused = h.this.m;
                            c.b unused2 = h.this.n;
                            return;
                        }
                        e unused3 = h.this.m;
                        c.b unused4 = h.this.n;
                        h.this.n.h();
                    }
                }
            });
        }
    }

    public final void a(String str, e eVar, boolean z, String str2, String str3, String str4, com.anythink.expressad.c.b bVar, com.anythink.expressad.foundation.d.c cVar, boolean z2, boolean z3, int i2) {
        this.m = eVar;
        this.p = z;
        this.r.a(new a(this.q, str, str2, str3, str4, bVar, cVar, z2, z3, i2), this);
    }

    @Override // com.anythink.expressad.a.d
    public final void b() {
        this.o = false;
    }
}
