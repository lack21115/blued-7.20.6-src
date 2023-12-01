package com.anythink.expressad.splash.c;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.splash.js.SplashJsUtils;
import com.anythink.expressad.splash.view.ATSplashView;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/splash/c/e.class */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f8219a = "WebViewRenderManager";
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f8220c;

    /* renamed from: com.anythink.expressad.splash.c.e$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/splash/c/e$1.class */
    final class AnonymousClass1 extends com.anythink.expressad.atsignalcommon.a.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f8221a;
        final /* synthetic */ ATSplashView b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.anythink.expressad.foundation.d.c f8222c;

        AnonymousClass1(b bVar, ATSplashView aTSplashView, com.anythink.expressad.foundation.d.c cVar) {
            this.f8221a = bVar;
            this.b = aTSplashView;
            this.f8222c = cVar;
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            b bVar = this.f8221a;
            if (bVar != null) {
                bVar.a();
            }
            e.a(e.this);
            if (!this.f8222c.s()) {
                this.b.setH5Ready(true);
                o.a("WindVaneWebView", "======渲染成功：finish");
            }
            SplashJsUtils.fireOnJSBridgeConnected(webView);
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            b bVar = this.f8221a;
            if (bVar != null) {
                bVar.a(str);
            }
            e.this.a();
            this.b.setH5Ready(false);
            o.a("WindVaneWebView", "======渲染失败");
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            b bVar = this.f8221a;
            if (bVar != null) {
                bVar.a(sslError.toString());
            }
            e.this.a();
            this.b.setH5Ready(false);
            o.a("WindVaneWebView", "======渲染失败");
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void readyState(WebView webView, int i) {
            super.readyState(webView, i);
            b bVar = this.f8221a;
            if (bVar != null) {
                bVar.a(i);
            }
            if (i == 1) {
                e.this.b = true;
                this.b.setH5Ready(true);
                o.a("WindVaneWebView", "======渲染成功：ready");
                return;
            }
            e.this.b = false;
            this.b.setH5Ready(false);
            o.a("WindVaneWebView", "======渲染失败");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/splash/c/e$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final e f8223a = new e((byte) 0);

        a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ e a() {
            return f8223a;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/splash/c/e$b.class */
    public interface b {
        void a();

        void a(int i);

        void a(String str);
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/splash/c/e$c.class */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private String f8224a;
        private String b;

        /* renamed from: c  reason: collision with root package name */
        private com.anythink.expressad.foundation.d.c f8225c;
        private String d;
        private boolean e;
        private int f;
        private boolean g;

        private boolean g() {
            return this.g;
        }

        public final String a() {
            return this.d;
        }

        public final void a(int i) {
            this.f = i;
        }

        public final void a(com.anythink.expressad.foundation.d.c cVar) {
            this.f8225c = cVar;
        }

        public final void a(String str) {
            this.d = str;
        }

        public final void a(boolean z) {
            this.g = z;
        }

        public final String b() {
            return this.f8224a;
        }

        public final void b(String str) {
            this.f8224a = str;
        }

        public final void b(boolean z) {
            this.e = z;
        }

        public final String c() {
            return this.b;
        }

        public final void c(String str) {
            this.b = str;
        }

        public final com.anythink.expressad.foundation.d.c d() {
            return this.f8225c;
        }

        public final boolean e() {
            return this.e;
        }

        public final int f() {
            return this.f;
        }
    }

    private e() {
        this.b = false;
        this.f8220c = false;
    }

    /* synthetic */ e(byte b2) {
        this();
    }

    static /* synthetic */ boolean a(e eVar) {
        eVar.f8220c = true;
        return true;
    }

    private static e b() {
        return a.f8223a;
    }

    public final void a() {
        this.b = false;
        this.f8220c = false;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public final void a(ATSplashView aTSplashView, c cVar, b bVar) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
}
