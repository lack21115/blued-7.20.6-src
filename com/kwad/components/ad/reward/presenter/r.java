package com.kwad.components.ad.reward.presenter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.ad.i.b;
import com.kwad.components.core.g.a;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/presenter/r.class */
public final class r extends a implements com.kwad.components.ad.reward.d.f, a.InterfaceC0353a, o.b {
    private AdTemplate mAdTemplate;
    private com.kwad.components.ad.reward.g oU;
    private ImageView rR;
    private View sR;
    private KsLogoView sS;
    private DetailVideoView sT;
    private int sU;
    private View sV;
    private FrameLayout sW;
    private Animator sX;
    private Animator sY;
    private Animator sZ;
    private AdTemplate ta;
    private List<com.kwad.components.core.g.c> tb;
    private boolean tk;
    private int sQ = 1;
    private long tc = 500;
    private long td = 50;
    private float te = 1.2254902f;
    private float tf = 0.80472106f;
    private float tg = 0.0f;
    private boolean th = false;
    private long ti = -1;
    private long tj = -1;
    private AdLivePlayStateListener mAdLivePlayStateListener = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.r.1
        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j) {
            super.onLivePlayProgress(j);
            r.this.f(j);
        }
    };
    private com.kwad.components.core.video.i mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.reward.presenter.r.2
        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j, long j2) {
            r.this.f(j2);
        }
    };
    private com.kwad.sdk.core.webview.c.kwai.a mWebCardClickListener = new com.kwad.sdk.core.webview.c.kwai.a() { // from class: com.kwad.components.ad.reward.presenter.r.6
        @Override // com.kwad.sdk.core.webview.c.kwai.a
        public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
            if (aVar == null || com.kwad.sdk.core.response.a.d.b(r.this.mAdTemplate, aVar.creativeId, aVar.adStyle)) {
                r.this.qt.mAdOpenInteractionListener.bN();
                return;
            }
            com.kwad.components.core.g.c a2 = com.kwad.components.ad.reward.j.a(r.this.tb, aVar.creativeId);
            if (a2 != null) {
                r.this.qt.a(a2);
            }
        }
    };

    private boolean N(boolean z) {
        int b = b(hI());
        P(b);
        com.kwad.components.ad.reward.g gVar = this.oU;
        boolean az = gVar != null ? gVar.az() : false;
        com.kwad.sdk.core.d.b.d("RewardPreEndCardPresenter", "webLoadSuccess: " + az);
        if (az) {
            int a2 = a(hI());
            float f = -b;
            this.tg = f;
            Animator a3 = a(true, f, a2, true, z);
            this.sX = a3;
            a3.start();
            Animator hH = hH();
            this.sZ = hH;
            hH.start();
            this.sQ = 2;
            return true;
        }
        return false;
    }

    private void O(boolean z) {
        Animator a2 = a(false, (hI() - hJ()) + this.tg, a(hJ()), false, z);
        this.sY = a2;
        a2.start();
        com.kwad.sdk.core.c.a.vU();
        com.kwad.sdk.core.c.a.am(this.ta);
        this.sQ = 3;
        com.kwad.components.ad.reward.g gVar = this.oU;
        if (gVar != null) {
            gVar.fs();
        }
    }

    private void P(int i) {
        ViewGroup.LayoutParams layoutParams = this.sR.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.height = i;
            layoutParams2.bottomMargin = -i;
            return;
        }
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i);
        layoutParams3.height = i;
        layoutParams3.bottomMargin = -i;
        this.sR.setLayoutParams(layoutParams3);
    }

    private int a(float f) {
        return (int) (com.kwad.sdk.c.kwai.a.d(getActivity()) - f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(com.kwad.components.ad.reward.d.f fVar) {
        return getPriority() - fVar.getPriority();
    }

    private Animator a(boolean z, float f, int i, boolean z2, boolean z3) {
        ObjectAnimator ofFloat;
        com.kwad.sdk.core.d.b.d("RewardPreEndCardPresenter", "getUpAnimator: translationY0: " + f + ", videoTargetHeight: " + i);
        if (z) {
            ofFloat = ObjectAnimator.ofFloat(this.sR, "translationY", f);
        } else {
            int height = this.sR.getHeight();
            final ViewGroup.LayoutParams layoutParams = this.sR.getLayoutParams();
            ofFloat = ValueAnimator.ofFloat(height, Math.abs(f));
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.r.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    layoutParams.height = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    r.this.sR.setLayoutParams(layoutParams);
                }
            });
        }
        ObjectAnimator objectAnimator = null;
        if (z2) {
            objectAnimator = ObjectAnimator.ofFloat(this.sS, "alpha", 0.0f, 255.0f);
        }
        final ViewGroup.LayoutParams layoutParams2 = this.rR.getLayoutParams();
        ValueAnimator a2 = this.sT.a(this.mAdTemplate, i, new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.r.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams3 = layoutParams2;
                if (layoutParams3 != null) {
                    layoutParams3.height = intValue;
                    r.this.rR.setLayoutParams(layoutParams2);
                }
            }
        });
        long j = z3 ? this.tc : this.td;
        Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(j);
        animatorSet.setInterpolator(create);
        if (objectAnimator != null) {
            if (z3) {
                animatorSet.playTogether(ofFloat, objectAnimator, a2);
                return animatorSet;
            }
            animatorSet.playTogether(ofFloat, objectAnimator);
            return animatorSet;
        } else if (z3) {
            animatorSet.playTogether(ofFloat, a2);
            return animatorSet;
        } else {
            animatorSet.playTogether(ofFloat);
            return animatorSet;
        }
    }

    private int b(float f) {
        return (int) (f + getContext().getResources().getDimensionPixelSize(R.dimen.ksad_reward_middle_end_card_logo_view_height) + getContext().getResources().getDimensionPixelSize(R.dimen.ksad_reward_middle_end_card_logo_view_margin_bottom));
    }

    private void c(List<AdTemplate> list) {
        this.oU = new com.kwad.components.ad.reward.g(list, this.qt.mReportExtData, this);
        this.qt.oU = this.oU;
        this.oU.z(com.kwad.sdk.core.response.a.b.aY(this.mAdTemplate));
        this.oU.a(this.mWebCardClickListener);
        this.oU.a(this.sW, this.qt.mRootContainer, this.mAdTemplate, this.qt.mApkDownloadHelper, this.qt.mScreenOrientation);
        com.kwad.sdk.core.d.b.d("RewardPreEndCardPresenter", "startPreloadWebView");
        this.oU.a(new b.InterfaceC0309b() { // from class: com.kwad.components.ad.reward.presenter.r.3
            @Override // com.kwad.components.ad.i.b.InterfaceC0309b
            public final void hK() {
                com.kwad.sdk.core.d.b.d("RewardPreEndCardPresenter", "onPreloadSuccess");
                r.this.qt.pv = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(long j) {
        AdTemplate adTemplate = this.ta;
        if (adTemplate == null || this.tk) {
            return;
        }
        if (this.ti <= 0) {
            this.ti = com.kwad.sdk.core.response.a.b.aV(adTemplate);
            this.tj = com.kwad.sdk.core.response.a.b.aU(this.ta) + this.ti;
        }
        long j2 = this.ti;
        if (j2 > 0 && !this.th && j > j2) {
            this.tk = !N(true);
            com.kwad.sdk.core.d.b.d("RewardPreEndCardPresenter", "showError: " + this.tk);
            if (this.tk) {
                return;
            }
            this.th = true;
        }
        boolean z = this.sQ == 3;
        long j3 = this.tj;
        if (j3 <= 0 || z || j <= j3) {
            return;
        }
        O(true);
    }

    private Animator hH() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.sV, "alpha", 255.0f, 0.0f);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f));
        ofFloat.setDuration(200L);
        return ofFloat;
    }

    private float hI() {
        return com.kwad.sdk.c.kwai.a.c(getActivity()) / this.te;
    }

    private float hJ() {
        return com.kwad.sdk.c.kwai.a.c(getActivity()) / this.tf;
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.qt.oN.a(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
        this.qt.b((com.kwad.components.ad.reward.d.f) this);
        this.mAdTemplate = this.qt.mAdTemplate;
        this.qt.a(this);
        this.sU = com.kwad.sdk.c.kwai.a.D(this.sT);
        com.kwad.sdk.c.kwai.a.n(this.sT, 49);
        this.sS.S(this.mAdTemplate);
    }

    @Override // com.kwad.components.ad.reward.d.f
    public final void bM() {
        int i;
        if (this.ta == null || (i = this.sQ) == 3) {
            return;
        }
        if (i == 1) {
            N(false);
            O(false);
        } else if (i == 2) {
            O(true);
        }
    }

    @Override // com.kwad.components.ad.reward.d.f
    public final int getPriority() {
        return 0;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.sR = findViewById(R.id.ksad_middle_end_card);
        this.sT = (DetailVideoView) findViewById(R.id.ksad_video_player);
        this.sS = (KsLogoView) findViewById(R.id.ksad_splash_logo_container);
        this.rR = (ImageView) findViewById(R.id.ksad_blur_video_cover);
        this.sV = findViewById(R.id.ksad_play_web_card_webView);
        this.sW = (FrameLayout) findViewById(R.id.ksad_middle_end_card_webview_container);
    }

    @Override // com.kwad.components.core.g.a.InterfaceC0353a
    public final void onError(int i, String str) {
        com.kwad.sdk.core.d.b.w("RewardPreEndCardPresenter", "onError : msg " + str);
    }

    @Override // com.kwad.components.core.g.a.InterfaceC0353a
    public final void onInnerAdLoad(List<com.kwad.components.core.g.c> list) {
        com.kwad.sdk.core.d.b.d("RewardPreEndCardPresenter", "onInnerAdLoad: " + list);
        if (list == null || list.size() == 0) {
            return;
        }
        this.ta = list.get(0).getAdTemplate();
        this.tb = list;
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.mAdTemplate);
        arrayList.addAll(com.kwad.components.core.g.c.i(list));
        c(arrayList);
    }

    @Override // com.kwad.components.core.g.a.InterfaceC0353a
    public final void onRequestResult(int i) {
        com.kwad.sdk.core.d.b.w("RewardPreEndCardPresenter", "onRequestResult : adNumber " + i);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qt.pv = false;
        this.qt.oN.b(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
        this.qt.c(this);
        this.qt.b((a.InterfaceC0353a) this);
        com.kwad.components.ad.reward.g gVar = this.oU;
        if (gVar != null) {
            gVar.jW();
        }
        Animator animator = this.sZ;
        if (animator != null) {
            animator.cancel();
        }
        DetailVideoView detailVideoView = this.sT;
        if (detailVideoView != null) {
            com.kwad.sdk.c.kwai.a.n(detailVideoView, this.sU);
        }
        Animator animator2 = this.sX;
        if (animator2 != null) {
            animator2.cancel();
        }
        this.sZ = null;
        this.sX = null;
    }

    @Override // com.kwad.components.core.webview.jshandler.o.b
    public final void x(AdTemplate adTemplate) {
        com.kwad.components.core.g.c cVar = new com.kwad.components.core.g.c(adTemplate, com.kwad.components.core.g.e.AGGREGATION);
        if (this.qt != null) {
            this.qt.b(cVar);
        }
    }
}
