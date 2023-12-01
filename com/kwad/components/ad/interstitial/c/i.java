package com.kwad.components.ad.interstitial.c;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Message;
import android.view.View;
import com.bytedance.applog.tracker.Tracker;
import com.kwad.components.ad.interstitial.c.c;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.bm;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.swipe.VerticalSwipeLayout;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/interstitial/c/i.class */
public final class i extends b implements bm.a {
    private bm gK;
    private KSFrameLayout jC;
    private View kC;
    private View kD;
    private View kE;
    private View kF;
    private View kG;
    private View kH;
    private View kI;
    private AnimatorSet kK;
    private ObjectAnimator kL;
    private ObjectAnimator kM;
    private ObjectAnimator kN;
    private ObjectAnimator kO;
    private ObjectAnimator kP;
    private ObjectAnimator kQ;
    private int kR;
    private VerticalSwipeLayout lk;
    protected AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    protected Context mContext;
    private com.kwad.components.core.page.c mLandingPageView;
    private String mPageUrl;
    private c.a jz = new c.a() { // from class: com.kwad.components.ad.interstitial.c.i.1
        @Override // com.kwad.components.ad.interstitial.c.c.a
        public final void cr() {
            i.this.jC.removeAllViews();
            i.this.dD();
            i.this.jC.setVisibility(8);
            i.this.lk.b(i.this.ll);
        }
    };
    private Runnable kS = new AnonymousClass3();
    private VerticalSwipeLayout.a ll = new VerticalSwipeLayout.a() { // from class: com.kwad.components.ad.interstitial.c.i.4
        @Override // com.kwad.sdk.widget.swipe.VerticalSwipeLayout.a
        public final void ee() {
            com.kwad.sdk.core.d.b.d("InterstitialVerticalSwipe", "onDownSwiped: ");
            i.this.jC.setTranslationY(com.kwad.sdk.c.kwai.a.aw(i.this.mContext));
            i.this.jt.cY();
            i.this.lk.b(i.this.ll);
        }

        @Override // com.kwad.sdk.widget.swipe.VerticalSwipeLayout.a
        public final void ef() {
            com.kwad.sdk.core.d.b.d("InterstitialVerticalSwipe", "onTopSwiped: ");
            i.this.dD();
            i.this.jC.setAllCorner(false);
            i.this.mLandingPageView.requestLayout();
            i.this.jC.requestLayout();
            com.kwad.sdk.core.report.a.a(i.this.mAdTemplate, 70, (ac.a) null);
            i.this.jt.cZ();
        }
    };
    private com.kwad.sdk.core.webview.c.kwai.b mWebCardCloseListener = new com.kwad.sdk.core.webview.c.kwai.b() { // from class: com.kwad.components.ad.interstitial.c.i.5
        @Override // com.kwad.sdk.core.webview.c.kwai.b
        public final void a(WebCloseStatus webCloseStatus) {
            i.this.jt.hU.dismiss();
        }
    };
    private com.kwad.components.core.page.kwai.a mLandPageViewListener = new com.kwad.components.core.page.kwai.a() { // from class: com.kwad.components.ad.interstitial.c.i.6
        @Override // com.kwad.components.core.page.kwai.a
        public final void dK() {
            i.this.jC.setTranslationY(com.kwad.sdk.c.kwai.a.aw(i.this.mContext));
            i.this.jt.cY();
            i.this.lk.b(i.this.ll);
        }

        @Override // com.kwad.components.core.page.kwai.a
        public final void dL() {
            i.this.jC.setTranslationY(com.kwad.sdk.c.kwai.a.aw(i.this.mContext));
            i.this.jt.cY();
            i.this.lk.b(i.this.ll);
        }
    };

    /* renamed from: com.kwad.components.ad.interstitial.c.i$3  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/interstitial/c/i$3.class */
    final class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            i.this.b(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.interstitial.c.i.3.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationCancel(Animator animator) {
                    super.onAnimationCancel(animator);
                    i.this.jC.setTranslationY(com.kwad.sdk.c.kwai.a.aw(i.this.mContext));
                    i.this.kC.setTranslationY(com.kwad.sdk.c.kwai.a.a(i.this.mContext, 500.0f));
                    i.this.kD.setTranslationY(com.kwad.sdk.c.kwai.a.a(i.this.mContext, 140.0f));
                    i.this.kC.setAlpha(1.0f);
                    i.this.kD.setAlpha(1.0f);
                    i.this.kE.setVisibility(8);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    i.this.a(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.interstitial.c.i.3.1.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public final void onAnimationCancel(Animator animator2) {
                            super.onAnimationCancel(animator2);
                            i.this.jC.setTranslationY(com.kwad.sdk.c.kwai.a.aw(i.this.mContext));
                            i.this.kC.setAlpha(1.0f);
                            i.this.kD.setAlpha(1.0f);
                            i.this.kE.setVisibility(8);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public final void onAnimationStart(Animator animator2) {
                            super.onAnimationStart(animator2);
                            i.this.dH();
                        }
                    });
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    i.this.jC.setTranslationY(com.kwad.sdk.c.kwai.a.aw(i.this.mContext));
                    i.this.kC.setTranslationY(com.kwad.sdk.c.kwai.a.a(i.this.mContext, 500.0f));
                    i.this.kD.setTranslationY(com.kwad.sdk.c.kwai.a.a(i.this.mContext, 140.0f));
                    i.this.kC.setAlpha(1.0f);
                    i.this.kD.setAlpha(1.0f);
                    i.this.kE.setVisibility(8);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Animator.AnimatorListener animatorListener) {
        ObjectAnimator objectAnimator = this.kO;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.kO.cancel();
            this.kO.removeAllListeners();
        }
        ObjectAnimator objectAnimator2 = this.kP;
        if (objectAnimator2 != null && objectAnimator2.isRunning()) {
            this.kP.cancel();
        }
        ObjectAnimator objectAnimator3 = this.kQ;
        if (objectAnimator3 != null && objectAnimator3.isRunning()) {
            this.kQ.cancel();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.jC, View.TRANSLATION_Y.getName(), com.kwad.sdk.c.kwai.a.aw(this.mContext) - com.kwad.sdk.c.kwai.a.a(this.mContext, 90.0f), com.kwad.sdk.c.kwai.a.aw(this.mContext) - com.kwad.sdk.c.kwai.a.a(this.mContext, 60.0f), com.kwad.sdk.c.kwai.a.aw(this.mContext) - com.kwad.sdk.c.kwai.a.a(this.mContext, 90.0f));
        this.kO = ofFloat;
        ofFloat.setDuration(1200L);
        this.kO.setRepeatMode(1);
        this.kO.setRepeatCount(-1);
        this.kO.addListener(animatorListener);
        this.kO.start();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.kC, View.TRANSLATION_Y.getName(), com.kwad.sdk.c.kwai.a.a(this.mContext, 322.0f), com.kwad.sdk.c.kwai.a.a(this.mContext, 500.0f), com.kwad.sdk.c.kwai.a.a(this.mContext, 322.0f));
        this.kP = ofFloat2;
        ofFloat2.setDuration(1200L);
        this.kP.setRepeatMode(1);
        this.kP.setRepeatCount(-1);
        this.kP.start();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.kC, View.ALPHA.getName(), 0.0f, 1.0f, 0.0f);
        this.kQ = ofFloat3;
        ofFloat3.setDuration(1200L);
        this.kQ.setRepeatMode(1);
        this.kQ.setRepeatCount(-1);
        this.kQ.start();
        this.kC.setVisibility(4);
        this.gK.sendEmptyMessageDelayed(6666, 600L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Animator.AnimatorListener animatorListener) {
        AnimatorSet animatorSet = this.kK;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.kK.removeAllListeners();
            this.kK.cancel();
        }
        y.a aVar = new y.a();
        aVar.akc = 7;
        com.kwad.sdk.core.report.a.d(this.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.report.i().a(aVar).bl(206));
        this.kK = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.jC, View.TRANSLATION_Y.getName(), com.kwad.sdk.c.kwai.a.aw(this.mContext), com.kwad.sdk.c.kwai.a.aw(this.mContext) - com.kwad.sdk.c.kwai.a.a(this.mContext, 90.0f));
        ofFloat.setDuration(300L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.kC, View.TRANSLATION_Y.getName(), com.kwad.sdk.c.kwai.a.a(this.mContext, 500.0f), com.kwad.sdk.c.kwai.a.a(this.mContext, 322.0f));
        ofFloat2.setDuration(300L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.kC, View.ALPHA.getName(), 1.0f, 0.0f);
        ofFloat3.setDuration(300L);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.kD, View.TRANSLATION_Y.getName(), com.kwad.sdk.c.kwai.a.a(this.mContext, 140.0f), com.kwad.sdk.c.kwai.a.a(this.mContext, 0.0f));
        ofFloat4.setDuration(300L);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.kD, View.ALPHA.getName(), 1.0f, 0.99f);
        ofFloat5.setDuration(300L);
        this.kK.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5);
        this.kK.removeAllListeners();
        this.kK.addListener(animatorListener);
        this.kK.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dD() {
        this.kC.removeCallbacks(this.kS);
        dF();
        dG();
        dE();
        this.jC.setTranslationY(0.0f);
        this.jC.setOnClickListener(null);
    }

    private void dE() {
        ObjectAnimator objectAnimator = this.kO;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.kO.cancel();
            this.kO.removeAllListeners();
        }
        ObjectAnimator objectAnimator2 = this.kP;
        if (objectAnimator2 != null && objectAnimator2.isRunning()) {
            this.kP.cancel();
        }
        ObjectAnimator objectAnimator3 = this.kQ;
        if (objectAnimator3 != null && objectAnimator3.isRunning()) {
            this.kQ.cancel();
        }
        this.kC.setTranslationY(com.kwad.sdk.c.kwai.a.a(this.mContext, 500.0f));
        this.kD.setTranslationY(com.kwad.sdk.c.kwai.a.a(this.mContext, 140.0f));
        this.kC.setAlpha(1.0f);
        this.kD.setAlpha(1.0f);
        this.gK.removeCallbacksAndMessages(null);
    }

    private void dF() {
        AnimatorSet animatorSet = this.kK;
        if (animatorSet == null || !animatorSet.isRunning()) {
            return;
        }
        this.kK.removeAllListeners();
        this.kK.cancel();
    }

    private void dG() {
        ObjectAnimator objectAnimator = this.kL;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.kL.cancel();
        }
        ObjectAnimator objectAnimator2 = this.kM;
        if (objectAnimator2 != null && objectAnimator2.isRunning()) {
            this.kM.cancel();
        }
        ObjectAnimator objectAnimator3 = this.kN;
        if (objectAnimator3 == null || !objectAnimator3.isRunning()) {
            return;
        }
        this.kN.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dH() {
        com.kwad.sdk.core.d.b.d("InterstitialVerticalSwipe", "showGuideButton: ");
        this.kE.setVisibility(0);
        ObjectAnimator objectAnimator = this.kL;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.kL.cancel();
        }
        ObjectAnimator objectAnimator2 = this.kM;
        if (objectAnimator2 != null && objectAnimator2.isRunning()) {
            this.kM.cancel();
        }
        ObjectAnimator objectAnimator3 = this.kN;
        if (objectAnimator3 != null && objectAnimator3.isRunning()) {
            this.kN.cancel();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.kI, View.ALPHA.getName(), 0.0f, 1.0f, 0.6f, 0.3f, 0.0f, 0.01f, 0.0f);
        this.kL = ofFloat;
        ofFloat.setDuration(600L);
        this.kL.setRepeatMode(1);
        this.kL.setRepeatCount(-1);
        this.kL.start();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.kH, View.ALPHA.getName(), 0.0f, 0.01f, 1.0f, 0.6f, 0.3f, 0.01f, 0.0f);
        this.kM = ofFloat2;
        ofFloat2.setDuration(600L);
        this.kM.setRepeatMode(1);
        this.kM.setRepeatCount(-1);
        this.kM.start();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.kG, View.ALPHA.getName(), 0.0f, 0.01f, 0.0f, 1.0f, 0.6f, 0.3f, 0.0f);
        this.kN = ofFloat3;
        ofFloat3.setDuration(600L);
        this.kN.setRepeatMode(1);
        this.kN.setRepeatCount(-1);
        this.kN.start();
    }

    private void initContentView() {
        this.mPageUrl = com.kwad.sdk.core.response.a.b.bg(this.mAdTemplate);
        this.mLandingPageView = com.kwad.components.core.page.c.b(this.mContext, new AdWebViewActivityProxy.a.C0529a().av(this.mPageUrl).L(this.mAdTemplate).oc());
        this.lk.a(this.ll);
        this.mLandingPageView.setLandPageViewListener(this.mLandPageViewListener);
        this.mLandingPageView.setWebCardCloseListener(this.mWebCardCloseListener);
        this.jC.addView(this.mLandingPageView);
        this.jC.setRadius(com.kwad.sdk.c.kwai.a.a(this.mContext, 20.0f));
        this.jC.setTranslationY(com.kwad.sdk.c.kwai.a.aw(this.mContext));
        this.kC.setTranslationY(com.kwad.sdk.c.kwai.a.a(this.mContext, 500.0f));
        this.kD.setTranslationY(com.kwad.sdk.c.kwai.a.a(this.mContext, 140.0f));
        this.kE.setVisibility(8);
        this.jC.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.interstitial.c.i.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                com.kwad.sdk.core.d.b.d("InterstitialVerticalSwipe", "mGuideButtonLayout click: ");
                i.this.dD();
                i.this.jC.setAllCorner(false);
                i.this.mLandingPageView.requestLayout();
                i.this.jC.requestLayout();
                i.this.jt.cZ();
                i.this.lk.b(i.this.ll);
                com.kwad.sdk.core.report.a.a(i.this.mAdTemplate, 110, (ac.a) null);
            }
        });
        this.kC.postDelayed(this.kS, this.kR * 1000);
    }

    @Override // com.kwad.sdk.utils.bm.a
    public final void a(Message message) {
        Runnable runnable;
        if (message.what == 6666) {
            View view = this.kC;
            if (view != null) {
                if (view.getVisibility() == 0) {
                    runnable = new Runnable() { // from class: com.kwad.components.ad.interstitial.c.i.7
                        @Override // java.lang.Runnable
                        public final void run() {
                            i.this.kC.setVisibility(4);
                            i.this.kF.setVisibility(4);
                        }
                    };
                } else if (this.kC.getVisibility() == 4) {
                    runnable = new Runnable() { // from class: com.kwad.components.ad.interstitial.c.i.8
                        @Override // java.lang.Runnable
                        public final void run() {
                            i.this.kC.setVisibility(0);
                            i.this.kF.setVisibility(0);
                        }
                    };
                }
                bi.runOnUiThread(runnable);
            }
            this.gK.sendEmptyMessageDelayed(6666, 600L);
        }
    }

    @Override // com.kwad.components.ad.interstitial.c.b, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.jt = (c) Bh();
        AdTemplate adTemplate = this.jt.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        this.mContext = getContext();
        this.jt.a(this.jz);
        this.kR = com.kwad.sdk.core.response.a.a.bW(this.mAdInfo);
        this.gK = com.kwad.sdk.core.threads.a.a(this);
        initContentView();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.jC = (KSFrameLayout) findViewById(R.id.ksad_land_page_root);
        this.lk = (VerticalSwipeLayout) findViewById(R.id.ksad_swipe);
        this.kC = findViewById(R.id.ksad_interstitial_guide_bg);
        this.kD = findViewById(R.id.ksad_interstitial_guide_bg_bg);
        this.kE = findViewById(R.id.ksad_interstitial_guide_button_layout);
        this.kF = findViewById(R.id.ksad_interstitial_guide_button);
        this.kG = findViewById(R.id.ksad_interstitial_guide_button_img_1);
        this.kH = findViewById(R.id.ksad_interstitial_guide_button_img_2);
        this.kI = findViewById(R.id.ksad_interstitial_guide_button_img_3);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.jC.removeAllViews();
        this.jt.b(this.jz);
        dD();
        this.gK.removeCallbacksAndMessages(null);
        this.lk.b(this.ll);
    }
}
