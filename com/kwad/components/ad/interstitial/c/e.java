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
import com.kwad.sdk.widget.swipe.HorizontalSwipeLayout;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/interstitial/c/e.class */
public final class e extends b implements bm.a {
    private bm gK;
    private KSFrameLayout jC;
    private HorizontalSwipeLayout kB;
    private View kC;
    private View kD;
    private View kE;
    private View kF;
    private View kG;
    private View kH;
    private View kI;
    private View kJ;
    private AnimatorSet kK;
    private ObjectAnimator kL;
    private ObjectAnimator kM;
    private ObjectAnimator kN;
    private ObjectAnimator kO;
    private ObjectAnimator kP;
    private ObjectAnimator kQ;
    private int kR;
    protected AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    protected Context mContext;
    private com.kwad.components.core.page.c mLandingPageView;
    private String mPageUrl;
    private c.a jz = new c.a() { // from class: com.kwad.components.ad.interstitial.c.e.1
        @Override // com.kwad.components.ad.interstitial.c.c.a
        public final void cr() {
            e.this.jC.removeAllViews();
            e.this.dD();
            e.this.jC.setVisibility(8);
            e.this.kB.b(e.this.kT);
        }
    };
    private Runnable kS = new AnonymousClass3();
    private HorizontalSwipeLayout.a kT = new HorizontalSwipeLayout.a() { // from class: com.kwad.components.ad.interstitial.c.e.4
        @Override // com.kwad.sdk.widget.swipe.HorizontalSwipeLayout.a
        public final void dI() {
            com.kwad.sdk.core.d.b.d("InterstitialHorizontalSwipe", "onRightSwiped: ");
            e.this.jC.setTranslationX(com.kwad.sdk.c.kwai.a.getScreenWidth(e.this.mContext));
            e.this.jt.cY();
            e.this.kB.b(e.this.kT);
        }

        @Override // com.kwad.sdk.widget.swipe.HorizontalSwipeLayout.a
        public final void dJ() {
            com.kwad.sdk.core.d.b.d("InterstitialHorizontalSwipe", "onLeftSwiped: ");
            e.this.dD();
            e.this.jC.setAllCorner(false);
            e.this.mLandingPageView.requestLayout();
            e.this.jC.requestLayout();
            com.kwad.sdk.core.report.a.a(e.this.mAdTemplate, 74, (ac.a) null);
            e.this.jt.cZ();
        }
    };
    private com.kwad.sdk.core.webview.c.kwai.b mWebCardCloseListener = new com.kwad.sdk.core.webview.c.kwai.b() { // from class: com.kwad.components.ad.interstitial.c.e.5
        @Override // com.kwad.sdk.core.webview.c.kwai.b
        public final void a(WebCloseStatus webCloseStatus) {
            e.this.jt.hU.dismiss();
        }
    };
    private com.kwad.components.core.page.kwai.a mLandPageViewListener = new com.kwad.components.core.page.kwai.a() { // from class: com.kwad.components.ad.interstitial.c.e.6
        @Override // com.kwad.components.core.page.kwai.a
        public final void dK() {
            e.this.jC.setTranslationX(com.kwad.sdk.c.kwai.a.getScreenWidth(e.this.mContext));
            e.this.jt.cY();
            e.this.kB.b(e.this.kT);
        }

        @Override // com.kwad.components.core.page.kwai.a
        public final void dL() {
            e.this.jC.setTranslationX(com.kwad.sdk.c.kwai.a.getScreenWidth(e.this.mContext));
            e.this.jt.cY();
            e.this.kB.b(e.this.kT);
        }
    };

    /* renamed from: com.kwad.components.ad.interstitial.c.e$3  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/interstitial/c/e$3.class */
    final class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            e.this.b(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.interstitial.c.e.3.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationCancel(Animator animator) {
                    super.onAnimationCancel(animator);
                    e.this.jC.setTranslationX(com.kwad.sdk.c.kwai.a.getScreenWidth(e.this.mContext));
                    e.this.kC.setTranslationX(com.kwad.sdk.c.kwai.a.a(e.this.mContext, 500.0f));
                    e.this.kD.setTranslationX(com.kwad.sdk.c.kwai.a.a(e.this.mContext, 140.0f));
                    e.this.kC.setAlpha(1.0f);
                    e.this.kD.setAlpha(1.0f);
                    e.this.kE.setVisibility(8);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    e.this.a(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.interstitial.c.e.3.1.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public final void onAnimationCancel(Animator animator2) {
                            super.onAnimationCancel(animator2);
                            e.this.jC.setTranslationX(com.kwad.sdk.c.kwai.a.getScreenWidth(e.this.mContext));
                            e.this.kC.setAlpha(1.0f);
                            e.this.kD.setAlpha(1.0f);
                            e.this.kE.setVisibility(8);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public final void onAnimationStart(Animator animator2) {
                            super.onAnimationStart(animator2);
                            e.this.dH();
                        }
                    });
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    e.this.jC.setTranslationX(com.kwad.sdk.c.kwai.a.getScreenWidth(e.this.mContext));
                    e.this.kC.setTranslationX(com.kwad.sdk.c.kwai.a.a(e.this.mContext, 500.0f));
                    e.this.kD.setTranslationX(com.kwad.sdk.c.kwai.a.a(e.this.mContext, 140.0f));
                    e.this.kC.setAlpha(1.0f);
                    e.this.kD.setAlpha(1.0f);
                    e.this.kE.setVisibility(8);
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
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.jC, View.TRANSLATION_X.getName(), com.kwad.sdk.c.kwai.a.getScreenWidth(this.mContext) - com.kwad.sdk.c.kwai.a.a(this.mContext, 45.0f), com.kwad.sdk.c.kwai.a.getScreenWidth(this.mContext) - com.kwad.sdk.c.kwai.a.a(this.mContext, 30.0f), com.kwad.sdk.c.kwai.a.getScreenWidth(this.mContext) - com.kwad.sdk.c.kwai.a.a(this.mContext, 45.0f));
        this.kO = ofFloat;
        ofFloat.setDuration(1200L);
        this.kO.setRepeatMode(1);
        this.kO.setRepeatCount(-1);
        this.kO.addListener(animatorListener);
        this.kO.start();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.kC, View.TRANSLATION_X.getName(), com.kwad.sdk.c.kwai.a.a(this.mContext, 322.0f), com.kwad.sdk.c.kwai.a.a(this.mContext, 500.0f), com.kwad.sdk.c.kwai.a.a(this.mContext, 322.0f));
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
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.jC, View.TRANSLATION_X.getName(), com.kwad.sdk.c.kwai.a.getScreenWidth(this.mContext), com.kwad.sdk.c.kwai.a.getScreenWidth(this.mContext) - com.kwad.sdk.c.kwai.a.a(this.mContext, 45.0f));
        ofFloat.setDuration(300L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.kC, View.TRANSLATION_X.getName(), com.kwad.sdk.c.kwai.a.a(this.mContext, 500.0f), com.kwad.sdk.c.kwai.a.a(this.mContext, 322.0f));
        ofFloat2.setDuration(300L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.kC, View.ALPHA.getName(), 1.0f, 0.0f);
        ofFloat3.setDuration(300L);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.kD, View.TRANSLATION_X.getName(), com.kwad.sdk.c.kwai.a.a(this.mContext, 140.0f), com.kwad.sdk.c.kwai.a.a(this.mContext, 0.0f));
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
        this.kJ.setVisibility(8);
        dF();
        dG();
        dE();
        this.jC.setTranslationX(0.0f);
        this.kE.setOnClickListener(null);
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
        this.kC.setTranslationX(com.kwad.sdk.c.kwai.a.a(this.mContext, 500.0f));
        this.kD.setTranslationX(com.kwad.sdk.c.kwai.a.a(this.mContext, 140.0f));
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
        com.kwad.sdk.core.d.b.d("InterstitialHorizontalSwipe", "showGuideButton: ");
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
        this.mLandingPageView = com.kwad.components.core.page.c.b(this.mContext, new AdWebViewActivityProxy.a.C0359a().av(this.mPageUrl).L(this.mAdTemplate).oc());
        this.kB.a(this.kT);
        this.mLandingPageView.setLandPageViewListener(this.mLandPageViewListener);
        this.mLandingPageView.setWebCardCloseListener(this.mWebCardCloseListener);
        this.jC.addView(this.mLandingPageView);
        this.jC.setRadius(com.kwad.sdk.c.kwai.a.a(this.mContext, 20.0f));
        this.jC.setTranslationX(com.kwad.sdk.c.kwai.a.getScreenWidth(this.mContext));
        this.kC.setTranslationX(com.kwad.sdk.c.kwai.a.a(this.mContext, 500.0f));
        this.kD.setTranslationX(com.kwad.sdk.c.kwai.a.a(this.mContext, 140.0f));
        this.kE.setVisibility(8);
        this.kJ.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.interstitial.c.e.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                com.kwad.sdk.core.d.b.d("InterstitialHorizontalSwipe", "mGuideButtonLayout click: ");
                e.this.dD();
                e.this.jC.setAllCorner(false);
                e.this.mLandingPageView.requestLayout();
                e.this.jC.requestLayout();
                e.this.jt.cZ();
                com.kwad.sdk.core.report.a.a(e.this.mAdTemplate, 110, (ac.a) null);
                e.this.kB.b(e.this.kT);
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
                    runnable = new Runnable() { // from class: com.kwad.components.ad.interstitial.c.e.7
                        @Override // java.lang.Runnable
                        public final void run() {
                            e.this.kC.setVisibility(4);
                            e.this.kF.setVisibility(4);
                        }
                    };
                } else if (this.kC.getVisibility() == 4) {
                    runnable = new Runnable() { // from class: com.kwad.components.ad.interstitial.c.e.8
                        @Override // java.lang.Runnable
                        public final void run() {
                            e.this.kC.setVisibility(0);
                            e.this.kF.setVisibility(0);
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
        this.kB = (HorizontalSwipeLayout) findViewById(R.id.ksad_swipe);
        this.kC = findViewById(R.id.ksad_interstitial_guide_bg);
        this.kD = findViewById(R.id.ksad_interstitial_guide_bg_bg);
        this.kE = findViewById(R.id.ksad_interstitial_guide_button_layout);
        this.kJ = findViewById(R.id.ksad_interstitial_guide_click_layout);
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
        this.kB.b(this.kT);
    }
}
