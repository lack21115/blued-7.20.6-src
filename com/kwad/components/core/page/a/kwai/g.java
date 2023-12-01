package com.kwad.components.core.page.a.kwai;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import com.kwad.components.core.webview.b;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.al;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.at;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.bi;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/page/a/kwai/g.class */
public final class g extends a {
    private com.kwad.components.core.webview.b Mf;
    private an Mh;
    private al Mi;
    private KsAdWebView mAdWebView;
    private boolean Mg = false;
    private final com.kwad.sdk.core.b.c wK = new com.kwad.sdk.core.b.d() { // from class: com.kwad.components.core.page.a.kwai.g.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.kwad.sdk.core.b.d, com.kwad.sdk.core.b.c
        public final void onActivityDestroyed(Activity activity) {
            super.onActivityDestroyed(activity);
            if (g.this.mAdWebView == null || g.this.getActivity() == null || !g.this.getActivity().equals(activity)) {
                return;
            }
            g.this.mAdWebView.onActivityDestroy();
            g.a(g.this, (KsAdWebView) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.kwad.sdk.core.b.d, com.kwad.sdk.core.b.c
        public final void onActivityPaused(Activity activity) {
            super.onActivityPaused(activity);
            g.this.hide();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.kwad.sdk.core.b.d, com.kwad.sdk.core.b.c
        public final void onActivityResumed(Activity activity) {
            super.onActivityResumed(activity);
            g.this.show();
        }
    };
    private al.b LK = new al.b() { // from class: com.kwad.components.core.page.a.kwai.g.2
        @Override // com.kwad.components.core.webview.jshandler.al.b
        public final void ox() {
            if (g.this.Mi != null) {
                g.this.Mi.qY();
            }
        }
    };
    private com.kwad.components.core.webview.c Mj = new com.kwad.components.core.webview.c() { // from class: com.kwad.components.core.page.a.kwai.g.3

        /* renamed from: com.kwad.components.core.page.a.kwai.g$3$1  reason: invalid class name */
        /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/page/a/kwai/g$3$1.class */
        final class AnonymousClass1 implements at.b {
            AnonymousClass1() {
            }

            @Override // com.kwad.components.core.webview.jshandler.at.b
            public final void a(at.a aVar) {
                if (g.this.LG.LJ == null || aVar == null) {
                    return;
                }
                g.this.LG.LJ.az(aVar.visibility);
            }
        }

        /* renamed from: com.kwad.components.core.page.a.kwai.g$3$2  reason: invalid class name */
        /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/page/a/kwai/g$3$2.class */
        final class AnonymousClass2 implements al.c {
            AnonymousClass2() {
            }

            @Override // com.kwad.components.core.webview.jshandler.al.c
            public final void oB() {
                g.this.LG.a(g.this.LK);
            }
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
        @Override // com.kwad.components.core.webview.c
        public final void a(com.kwad.components.core.webview.a aVar, com.kwad.sdk.core.webview.b bVar) {
            throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(ai.a aVar) {
            g.this.LG.LL = aVar.isSuccess();
        }

        @Override // com.kwad.components.core.webview.c
        public final void oA() {
            g.this.Mg = false;
        }

        @Override // com.kwad.components.core.webview.c
        public final void onPageFinished() {
            g.this.Mg = true;
            if (g.this.LG.ol()) {
                g.this.show();
            }
        }

        @Override // com.kwad.components.core.webview.c
        public final void onRegisterLifecycleLisener(an anVar) {
            g.this.Mh = anVar;
        }

        @Override // com.kwad.components.core.webview.c
        public final boolean oy() {
            return true;
        }

        @Override // com.kwad.components.core.webview.c
        public final boolean oz() {
            return true;
        }

        @Override // com.kwad.components.core.webview.c
        public final void pageClose(WebCloseStatus webCloseStatus) {
            if (g.this.LG.mWebCardCloseListener != null) {
                g.this.LG.mWebCardCloseListener.a(webCloseStatus);
            }
        }
    };

    static /* synthetic */ KsAdWebView a(g gVar, KsAdWebView ksAdWebView) {
        gVar.mAdWebView = null;
        return null;
    }

    private void eP() {
        this.Mf = new com.kwad.components.core.webview.b();
        this.Mf.a(new b.a().Q(this.LG.mAdTemplate).aH(this.LG.mPageUrl).d(this.mAdWebView).j(this.LG.gv).a(this.Mj).b(this.LG.LI));
        ow();
        this.mAdWebView.loadUrl(this.LG.mPageUrl);
        this.mAdWebView.onActivityCreate();
    }

    private void ow() {
        KsAdWebView ksAdWebView;
        this.mAdWebView.setClientConfig(this.mAdWebView.getClientConfig().be(true).ct(this.LG.mAdTemplate).bc(false));
        if (com.kwad.sdk.core.response.a.a.bw(com.kwad.sdk.core.response.a.d.cb(this.LG.mAdTemplate)) > 0) {
            bi.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.core.page.a.kwai.g.4
                @Override // java.lang.Runnable
                public final void run() {
                    if (g.this.mAdWebView != null) {
                        g.this.mAdWebView.getClientConfig().bc(true);
                    }
                }
            }, com.kwad.sdk.core.response.a.a.bw(com.kwad.sdk.core.response.a.d.cb(this.LG.mAdTemplate)));
        } else if (com.kwad.sdk.core.response.a.a.bw(com.kwad.sdk.core.response.a.d.cb(this.LG.mAdTemplate)) == 0 && (ksAdWebView = this.mAdWebView) != null) {
            ksAdWebView.getClientConfig().bc(true);
        }
        this.mAdWebView.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.core.page.a.kwai.g.5
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    g.this.mAdWebView.getClientConfig().bc(true);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.kwad.components.core.page.a.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        eP();
        com.kwad.sdk.core.b.b.vS();
        com.kwad.sdk.core.b.b.a(this.wK);
    }

    public final void hide() {
        an anVar = this.Mh;
        if (anVar != null) {
            anVar.rb();
        }
        if (this.LG.gv != null) {
            this.LG.gv.setVisibility(8);
        }
        an anVar2 = this.Mh;
        if (anVar2 != null) {
            anVar2.rc();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mAdWebView = (KsAdWebView) findViewById(R.id.ksad_video_webview);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.Mf.unBind();
        com.kwad.sdk.core.b.b.vS();
        com.kwad.sdk.core.b.b.b(this.wK);
    }

    public final void show() {
        if (this.Mg) {
            an anVar = this.Mh;
            if (anVar != null) {
                anVar.qZ();
            }
            try {
                if (this.LG.gv != null) {
                    this.LG.gv.setVisibility(0);
                }
            } catch (Exception e) {
                com.kwad.components.core.c.a.b(e);
            }
            an anVar2 = this.Mh;
            if (anVar2 != null) {
                anVar2.ra();
            }
        }
    }
}
