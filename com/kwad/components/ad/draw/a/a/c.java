package com.kwad.components.ad.draw.a.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import com.kwad.components.ad.draw.a.a.a;
import com.kwad.components.core.r.m;
import com.kwad.components.core.video.i;
import com.kwad.components.core.video.j;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ab;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.p;
import com.kwad.components.core.webview.jshandler.s;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.components.core.webview.jshandler.v;
import com.kwad.components.core.webview.jshandler.y;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/draw/a/a/c.class */
public final class c extends com.kwad.components.ad.draw.kwai.a {
    private KsAdWebView cS;
    private ab.a cT;
    private com.kwad.components.core.webview.a cU;
    private com.kwad.sdk.core.webview.b cV;
    private ViewGroup cv;
    private ValueAnimator da;
    private ValueAnimator db;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private an mCardLifecycleHandler;
    private int cW = -1;
    private i mVideoPlayStateListener = new j() { // from class: com.kwad.components.ad.draw.a.a.c.1
        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayCompleted() {
            super.onVideoPlayCompleted();
            c.this.release();
        }
    };
    private a.b cN = new a.b() { // from class: com.kwad.components.ad.draw.a.a.c.2
        @Override // com.kwad.components.ad.draw.a.a.a.b
        public final boolean az() {
            return c.this.aJ();
        }
    };
    private com.kwad.sdk.core.webview.c.kwai.a mWebCardClickListener = new com.kwad.sdk.core.webview.c.kwai.a() { // from class: com.kwad.components.ad.draw.a.a.c.3
        @Override // com.kwad.sdk.core.webview.c.kwai.a
        public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
            if (c.this.bW.bV != null) {
                c.this.bW.bV.onAdClicked();
            }
        }
    };
    private ab.b cX = new ab.b() { // from class: com.kwad.components.ad.draw.a.a.c.4
        @Override // com.kwad.components.core.webview.jshandler.ab.b
        public final void a(ab.a aVar) {
            c.this.cT = aVar;
            c.this.cS.setTranslationY(aVar.height + aVar.bottomMargin);
        }
    };
    private aa.b cY = new aa.b() { // from class: com.kwad.components.ad.draw.a.a.c.5
        @Override // com.kwad.components.core.webview.jshandler.aa.b
        public final void a(aa.a aVar) {
            c.this.aM();
        }
    };
    private ai.b cZ = new ai.b() { // from class: com.kwad.components.ad.draw.a.a.c.6
        @Override // com.kwad.components.core.webview.jshandler.ai.b
        public final void a(ai.a aVar) {
            c.this.cW = aVar.status;
            com.kwad.sdk.core.d.b.i("DrawPlayWebCard", "updatePageStatus mPageState: " + aVar);
        }
    };

    private void a(com.kwad.components.core.webview.a aVar) {
        aVar.a(new s(this.cV, this.mApkDownloadHelper, this.mWebCardClickListener));
        aVar.a(new p(this.cV, this.mApkDownloadHelper, this.mWebCardClickListener));
        aVar.a(new v(this.cV));
        aVar.a(new y(this.cV));
        aVar.a(new u(this.cV));
        aVar.a(new ab(this.cV, this.cX));
        aVar.a(new ai(this.cZ, com.kwad.sdk.core.response.a.b.aP(this.mAdTemplate)));
        an anVar = new an();
        this.mCardLifecycleHandler = anVar;
        aVar.a(anVar);
        aVar.a(new aq(this.cV, this.mApkDownloadHelper));
        aVar.a(new aa(this.cY));
        aVar.a(new ac(this.cV));
    }

    private void aF() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.cV = bVar;
        bVar.setAdTemplate(this.bW.mAdTemplate);
        this.cV.mScreenOrientation = 0;
        this.cV.app = this.bW.mRootContainer;
        this.cV.LD = this.bW.mRootContainer;
        this.cV.Lc = this.cS;
    }

    private void aG() {
        this.cW = -1;
        aH();
        this.cS.setBackgroundColor(0);
        this.cS.getBackground().setAlpha(0);
        this.cS.setVisibility(4);
        this.cS.loadUrl(com.kwad.sdk.core.response.a.b.aP(this.mAdTemplate));
    }

    private void aH() {
        aI();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.cS);
        this.cU = aVar;
        a(aVar);
        this.cS.addJavascriptInterface(this.cU, "KwaiAd");
    }

    private void aI() {
        com.kwad.components.core.webview.a aVar = this.cU;
        if (aVar != null) {
            aVar.destroy();
            this.cU = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aJ() {
        if (this.cW == 1) {
            aK();
            return true;
        }
        aP();
        return false;
    }

    private void aK() {
        if (this.cT == null) {
            aL();
            return;
        }
        aO();
        this.cv.setVisibility(8);
        this.cS.setVisibility(0);
        ValueAnimator c2 = m.c(this.cS, this.cT.height + this.cT.bottomMargin, 0);
        this.da = c2;
        c2.setInterpolator(new DecelerateInterpolator(2.0f));
        this.da.setDuration(300L);
        this.da.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.draw.a.a.c.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (c.this.mCardLifecycleHandler != null) {
                    c.this.mCardLifecycleHandler.ra();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (c.this.mCardLifecycleHandler != null) {
                    c.this.mCardLifecycleHandler.qZ();
                }
            }
        });
        this.da.start();
    }

    private void aL() {
        an anVar = this.mCardLifecycleHandler;
        if (anVar != null) {
            anVar.qZ();
        }
        this.cv.setVisibility(8);
        this.cS.setVisibility(0);
        an anVar2 = this.mCardLifecycleHandler;
        if (anVar2 != null) {
            anVar2.ra();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aM() {
        if (this.cS.getVisibility() != 0) {
            return;
        }
        if (this.cT == null) {
            aN();
            return;
        }
        aO();
        ValueAnimator c2 = m.c(this.cS, 0, this.cT.height + this.cT.bottomMargin);
        this.db = c2;
        c2.setInterpolator(new DecelerateInterpolator(2.0f));
        this.db.setDuration(300L);
        this.db.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.draw.a.a.c.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.cS.setVisibility(4);
                c.this.cv.setVisibility(0);
                if (c.this.mCardLifecycleHandler != null) {
                    c.this.mCardLifecycleHandler.rc();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (c.this.mCardLifecycleHandler != null) {
                    c.this.mCardLifecycleHandler.rb();
                }
            }
        });
        this.db.start();
    }

    private void aN() {
        if (this.cS.getVisibility() != 0) {
            return;
        }
        an anVar = this.mCardLifecycleHandler;
        if (anVar != null) {
            anVar.rb();
        }
        this.cS.setVisibility(4);
        this.cv.setVisibility(0);
        an anVar2 = this.mCardLifecycleHandler;
        if (anVar2 != null) {
            anVar2.rc();
        }
    }

    private void aO() {
        ValueAnimator valueAnimator = this.da;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.da.cancel();
        }
        ValueAnimator valueAnimator2 = this.db;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
            this.db.cancel();
        }
    }

    private void aP() {
        int i = this.cW;
        String str = i == -1 ? "timeout" : i != 1 ? "h5error" : "others";
        com.kwad.sdk.core.d.b.w("DrawPlayWebCard", "show webCard fail, reason: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        this.cW = -1;
        this.cS.setVisibility(8);
        aI();
    }

    @Override // com.kwad.components.ad.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.mAdTemplate = this.bW.mAdTemplate;
        this.bW.co.a(this.cN);
        this.mApkDownloadHelper = this.bW.mApkDownloadHelper;
        this.bW.bX.a(this.mVideoPlayStateListener);
        aF();
        aG();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.cv = (ViewGroup) findViewById(R.id.ksad_ad_normal_container);
        this.cS = (KsAdWebView) findViewById(R.id.ksad_play_web_card_webView);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.bW.co.a((a.b) null);
        this.bW.bX.b(this.mVideoPlayStateListener);
        aO();
        release();
    }
}
