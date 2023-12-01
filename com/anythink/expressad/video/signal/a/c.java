package com.anythink.expressad.video.signal.a;

import android.app.Activity;
import android.content.Context;
import com.anythink.expressad.out.p;
import com.anythink.expressad.video.signal.c;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/signal/a/c.class */
public class c implements com.anythink.expressad.video.signal.c {
    protected static final String d = "DefaultJSCommon";
    protected String n;
    protected com.anythink.expressad.videocommon.e.d o;
    protected com.anythink.expressad.videocommon.c.c p;
    protected com.anythink.expressad.a.a q;
    protected boolean e = false;
    protected boolean f = false;
    protected int g = 0;
    protected int h = 0;
    protected int i = 0;
    protected int j = 0;
    protected int k = 0;
    protected int l = 1;
    protected int m = -1;
    public c.a r = new a();
    protected int s = 2;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/signal/a/c$a.class */
    public static class a implements c.a {
        @Override // com.anythink.expressad.out.p.c
        public final void a(int i) {
            com.anythink.expressad.foundation.h.o.a(c.d, "onDownloadProgress,progress:".concat(String.valueOf(i)));
        }

        @Override // com.anythink.expressad.video.signal.c.a
        public void a(int i, String str) {
            com.anythink.expressad.foundation.h.o.a(c.d, "onH5Error,code:" + i + "，msg:" + str);
        }

        @Override // com.anythink.expressad.out.p.c
        public void a(com.anythink.expressad.foundation.d.c cVar, String str) {
            com.anythink.expressad.foundation.h.o.a(c.d, "onStartRedirection,campaign:" + cVar + ",url:" + str);
        }

        @Override // com.anythink.expressad.video.signal.c.a
        public void a(com.anythink.expressad.foundation.d.c cVar, boolean z) {
            com.anythink.expressad.foundation.h.o.a(c.d, "onStartInstall");
        }

        @Override // com.anythink.expressad.out.p.c
        public final void a(com.anythink.expressad.out.j jVar) {
            com.anythink.expressad.foundation.h.o.a(c.d, "onShowLoading,campaign:".concat(String.valueOf(jVar)));
        }

        @Override // com.anythink.expressad.out.p.c
        public void a(com.anythink.expressad.out.j jVar, String str) {
            com.anythink.expressad.foundation.h.o.a(c.d, "onFinishRedirection,campaign:" + jVar + ",url:" + str);
        }

        @Override // com.anythink.expressad.out.p.c
        public final boolean a() {
            com.anythink.expressad.foundation.h.o.a(c.d, "onInterceptDefaultLoadingDialog");
            return false;
        }

        @Override // com.anythink.expressad.video.signal.c.a
        public void b() {
            com.anythink.expressad.foundation.h.o.a(c.d, "onInitSuccess");
        }

        @Override // com.anythink.expressad.out.p.c
        public final void b(com.anythink.expressad.out.j jVar) {
            com.anythink.expressad.foundation.h.o.a(c.d, "onDismissLoading,campaign:".concat(String.valueOf(jVar)));
        }

        @Override // com.anythink.expressad.out.p.c
        public void b(com.anythink.expressad.out.j jVar, String str) {
            com.anythink.expressad.foundation.h.o.a(c.d, "onFinishRedirection,campaign:" + jVar + ",url:" + str);
        }

        @Override // com.anythink.expressad.video.signal.c.a
        public void c() {
            com.anythink.expressad.foundation.h.o.a(c.d, "videoLocationReady");
        }

        @Override // com.anythink.expressad.out.p.c
        public final void c(com.anythink.expressad.out.j jVar) {
            com.anythink.expressad.foundation.h.o.a(c.d, "onDownloadStart,campaign:".concat(String.valueOf(jVar)));
        }

        @Override // com.anythink.expressad.out.p.c
        public final void d(com.anythink.expressad.out.j jVar) {
            com.anythink.expressad.foundation.h.o.a(c.d, "onDownloadFinish,campaign:".concat(String.valueOf(jVar)));
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/signal/a/c$b.class */
    public static final class b implements c.a {

        /* renamed from: a  reason: collision with root package name */
        private com.anythink.expressad.video.signal.c f5676a;
        private c.a b;

        public b(com.anythink.expressad.video.signal.c cVar, c.a aVar) {
            this.f5676a = cVar;
            this.b = aVar;
        }

        @Override // com.anythink.expressad.out.p.c
        public final void a(int i) {
            c.a aVar = this.b;
            if (aVar != null) {
                aVar.a(i);
            }
        }

        @Override // com.anythink.expressad.video.signal.c.a
        public final void a(int i, String str) {
            c.a aVar = this.b;
            if (aVar != null) {
                aVar.a(i, str);
            }
        }

        @Override // com.anythink.expressad.out.p.c
        public final void a(com.anythink.expressad.foundation.d.c cVar, String str) {
            c.a aVar = this.b;
            if (aVar != null) {
                aVar.a(cVar, str);
            }
        }

        @Override // com.anythink.expressad.video.signal.c.a
        public final void a(com.anythink.expressad.foundation.d.c cVar, boolean z) {
            c.a aVar = this.b;
            if (aVar != null) {
                aVar.a(cVar, z);
            }
        }

        @Override // com.anythink.expressad.out.p.c
        public final void a(com.anythink.expressad.out.j jVar) {
            c.a aVar = this.b;
            if (aVar != null) {
                aVar.a(jVar);
            }
        }

        @Override // com.anythink.expressad.out.p.c
        public final void a(com.anythink.expressad.out.j jVar, String str) {
            c.a aVar = this.b;
            if (aVar != null) {
                aVar.a(jVar, str);
            }
            com.anythink.expressad.video.signal.c cVar = this.f5676a;
            if (cVar != null) {
                cVar.j();
            }
        }

        @Override // com.anythink.expressad.out.p.c
        public final boolean a() {
            c.a aVar = this.b;
            return aVar != null && aVar.a();
        }

        @Override // com.anythink.expressad.video.signal.c.a
        public final void b() {
            c.a aVar = this.b;
            if (aVar != null) {
                aVar.b();
            }
        }

        @Override // com.anythink.expressad.out.p.c
        public final void b(com.anythink.expressad.out.j jVar) {
            c.a aVar = this.b;
            if (aVar != null) {
                aVar.b(jVar);
            }
        }

        @Override // com.anythink.expressad.out.p.c
        public final void b(com.anythink.expressad.out.j jVar, String str) {
            c.a aVar = this.b;
            if (aVar != null) {
                aVar.b(jVar, str);
            }
            com.anythink.expressad.video.signal.c cVar = this.f5676a;
            if (cVar != null) {
                cVar.j();
            }
        }

        @Override // com.anythink.expressad.video.signal.c.a
        public final void c() {
            c.a aVar = this.b;
            if (aVar != null) {
                aVar.c();
            }
        }

        @Override // com.anythink.expressad.out.p.c
        public final void c(com.anythink.expressad.out.j jVar) {
            c.a aVar = this.b;
            if (aVar != null) {
                aVar.c(jVar);
            }
        }

        @Override // com.anythink.expressad.out.p.c
        public final void d(com.anythink.expressad.out.j jVar) {
            c.a aVar = this.b;
            if (aVar != null) {
                aVar.d(jVar);
            }
        }
    }

    private void a(com.anythink.expressad.videocommon.c.c cVar) {
        this.p = cVar;
    }

    @Override // com.anythink.expressad.video.signal.c
    public final void a(int i) {
        this.s = i;
    }

    @Override // com.anythink.expressad.video.signal.c
    public void a(int i, String str) {
        com.anythink.expressad.foundation.h.o.a(d, "statistics,type:" + i + ",json:" + str);
    }

    @Override // com.anythink.expressad.video.signal.c
    public void a(Activity activity) {
        com.anythink.expressad.foundation.h.o.a(d, "setActivity ");
    }

    @Override // com.anythink.expressad.video.signal.c
    public void a(Context context) {
        com.anythink.expressad.foundation.h.o.a(d, "setViewContext ");
    }

    @Override // com.anythink.expressad.video.signal.c
    public final void a(c.a aVar) {
        com.anythink.expressad.foundation.h.o.a(d, "setTrackingListener:".concat(String.valueOf(aVar)));
        this.r = aVar;
    }

    @Override // com.anythink.expressad.video.signal.c
    public final void a(com.anythink.expressad.videocommon.e.d dVar) {
        com.anythink.expressad.foundation.h.o.a(d, "setSetting:".concat(String.valueOf(dVar)));
        this.o = dVar;
    }

    @Override // com.anythink.expressad.video.signal.c
    public final void a(String str) {
        com.anythink.expressad.foundation.h.o.a(d, "setUnitId:".concat(String.valueOf(str)));
        this.n = str;
    }

    @Override // com.anythink.expressad.video.signal.c
    public final void a(boolean z) {
        com.anythink.expressad.foundation.h.o.a(d, "setIsShowingTransparent:".concat(String.valueOf(z)));
        this.f = z;
    }

    @Override // com.anythink.expressad.video.signal.c
    public final boolean a() {
        return this.f;
    }

    @Override // com.anythink.expressad.video.signal.c
    public final int b() {
        if (this.h == 0 && this.f) {
            this.h = 1;
        }
        return this.h;
    }

    @Override // com.anythink.expressad.video.signal.c
    public final void b(int i) {
        this.h = i;
    }

    @Override // com.anythink.expressad.video.signal.c
    public void b(String str) {
        com.anythink.expressad.foundation.h.o.a(d, "setNotchArea");
    }

    @Override // com.anythink.expressad.video.signal.c
    public final int c() {
        if (this.g == 0 && this.f) {
            this.g = 1;
        }
        return this.g;
    }

    @Override // com.anythink.expressad.video.signal.c
    public final void c(int i) {
        this.g = i;
    }

    @Override // com.anythink.expressad.video.signal.d
    public void click(int i, String str) {
        com.anythink.expressad.foundation.h.o.a(d, "click:type" + i + ",pt:" + str);
    }

    @Override // com.anythink.expressad.video.signal.c
    public final int d() {
        if (this.i == 0 && this.f) {
            this.i = 1;
        }
        return this.i;
    }

    @Override // com.anythink.expressad.video.signal.c
    public final void d(int i) {
        this.i = i;
    }

    @Override // com.anythink.expressad.video.signal.c
    public final int e() {
        return this.j;
    }

    @Override // com.anythink.expressad.video.signal.c
    public final void e(int i) {
        this.j = i;
    }

    @Override // com.anythink.expressad.video.signal.c
    public final int f() {
        return this.k;
    }

    @Override // com.anythink.expressad.video.signal.c
    public final void f(int i) {
        this.k = i;
    }

    @Override // com.anythink.expressad.video.signal.c
    public final void g(int i) {
        this.m = i;
    }

    @Override // com.anythink.expressad.video.signal.c
    public final boolean g() {
        return this.e;
    }

    @Override // com.anythink.expressad.video.signal.c
    public String h(int i) {
        com.anythink.expressad.foundation.h.o.a(d, "getSDKInfo");
        return "{}";
    }

    @Override // com.anythink.expressad.video.signal.c
    public final void h() {
        this.e = true;
    }

    @Override // com.anythink.expressad.video.signal.d
    public void handlerH5Exception(int i, String str) {
        com.anythink.expressad.foundation.h.o.a(d, "handlerH5Exception,code=" + i + ",msg:" + str);
    }

    @Override // com.anythink.expressad.video.signal.c
    public String i() {
        com.anythink.expressad.foundation.h.o.a(d, "init");
        return "{}";
    }

    @Override // com.anythink.expressad.video.signal.c
    public final void i(int i) {
        com.anythink.expressad.foundation.h.o.a(d, "setAlertDialogRole ".concat(String.valueOf(i)));
        this.l = i;
    }

    @Override // com.anythink.expressad.video.signal.c
    public void j() {
        com.anythink.expressad.foundation.h.o.a(d, "finish");
    }

    @Override // com.anythink.expressad.video.signal.c
    public final void k() {
        com.anythink.expressad.foundation.h.o.a(d, "release");
        com.anythink.expressad.a.a aVar = this.q;
        if (aVar != null) {
            aVar.a();
            this.q.a((p.c) null);
            this.q.b();
        }
    }

    @Override // com.anythink.expressad.video.signal.c
    public void l() {
    }

    @Override // com.anythink.expressad.video.signal.c
    public final int m() {
        return this.m;
    }

    @Override // com.anythink.expressad.video.signal.c
    public final int n() {
        com.anythink.expressad.foundation.h.o.a(d, "getAlertDialogRole " + this.l);
        return this.l;
    }

    @Override // com.anythink.expressad.video.signal.c
    public String o() {
        com.anythink.expressad.foundation.h.o.a(d, "getNotchArea");
        return null;
    }
}
