package com.kwad.components.ad.interstitial.aggregate;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import androidx.viewpager.widget.ViewPager;
import com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator;
import com.kwad.components.ad.interstitial.aggregate.a;
import com.kwad.components.ad.interstitial.aggregate.c;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.j.k;
import com.kwad.sdk.utils.ai;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/interstitial/aggregate/b.class */
public final class b extends com.kwad.components.ad.interstitial.e.a {
    private final com.kwad.sdk.core.g.c dk;
    protected KsInterstitialAd.AdInteractionListener hN;
    private boolean hV;
    private TransViewPager hZ;
    private a ia;
    private ViewPagerIndicator ib;
    private SlideTipsView ic;
    private SlideTipsView ie;

    /* renamed from: if  reason: not valid java name */
    private ValueAnimator f50if;
    private boolean ig;
    private InterstitialAggregateManualTipsView ih;
    private boolean ij;
    private boolean ik;
    private final ViewPager.OnPageChangeListener il;
    protected AdInfo mAdInfo;
    protected AdTemplate mAdTemplate;
    private final List<AdTemplate> mAdTemplateList;
    private final View mRootView;
    private com.kwad.components.core.widget.kwai.b mViewVisibleHelper;

    public b(Context context) {
        this(context, null);
    }

    private b(Context context, AttributeSet attributeSet) {
        super(context, null);
        this.mAdTemplateList = new ArrayList();
        this.dk = new com.kwad.sdk.core.g.d() { // from class: com.kwad.components.ad.interstitial.aggregate.b.2
            @Override // com.kwad.sdk.core.g.d, com.kwad.sdk.core.g.c
            public final void onPageInvisible() {
                super.onPageInvisible();
                if (Build.VERSION.SDK_INT >= 19 && !b.this.ig) {
                    if (b.this.ib != null) {
                        b.this.ib.cF();
                    }
                    if (b.this.f50if != null) {
                        b.this.f50if.pause();
                    }
                    b.this.ig = true;
                }
            }

            @Override // com.kwad.sdk.core.g.d, com.kwad.sdk.core.g.c
            public final void onPageVisible() {
                super.onPageVisible();
                if (Build.VERSION.SDK_INT >= 19 && b.this.ig) {
                    if (b.this.ib != null) {
                        b.this.ib.cG();
                    }
                    if (b.this.f50if != null) {
                        b.this.f50if.resume();
                    }
                    b.this.ig = false;
                }
            }
        };
        this.il = new ViewPager.SimpleOnPageChangeListener() { // from class: com.kwad.components.ad.interstitial.aggregate.b.3

            /* renamed from: io  reason: collision with root package name */
            private int f23915io = 0;

            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageScrolled(int i, float f, int i2) {
                if (f != 0.0f) {
                    if (b.this.ic.getVisibility() == 0) {
                        b.this.ic.clearAnimation();
                        b.this.ic.setVisibility(8);
                    }
                    if (b.this.ie.getVisibility() == 0) {
                        b.this.ie.clearAnimation();
                        b.this.ie.setVisibility(8);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageSelected(int i) {
                com.kwad.components.ad.interstitial.e.c B = b.this.hZ.B(i);
                if (B != null) {
                    B.ew();
                }
                if (this.f23915io != i) {
                    com.kwad.sdk.core.report.a.a((AdTemplate) b.this.mAdTemplateList.get(this.f23915io), -1L, (JSONObject) null);
                    com.kwad.components.ad.interstitial.e.c B2 = b.this.hZ.B(this.f23915io);
                    if (B2 != null) {
                        B2.ex();
                    }
                }
                this.f23915io = i;
            }
        };
        this.mContext = context;
        this.mRootView = k.inflate(context, R.layout.ksad_interstitial_multi_ad, this);
        initView();
    }

    static /* synthetic */ AnimationSet a(b bVar, float f, float f2) {
        return b(f, f2);
    }

    static /* synthetic */ boolean a(b bVar, boolean z) {
        bVar.ik = true;
        return true;
    }

    private static AnimationSet b(float f, float f2) {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, f, 1, f2, 1, 0.0f, 1, 0.0f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.8f);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setDuration(800L);
        animationSet.setFillAfter(true);
        return animationSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ct() {
        if (this.mAdTemplate.mAdScene != null) {
            c.cA().a(16, com.kwad.components.ad.interstitial.kwai.b.cM(), this.mAdTemplate.mAdScene, new c.b() { // from class: com.kwad.components.ad.interstitial.aggregate.b.6
                @Override // com.kwad.components.ad.interstitial.aggregate.c.b
                public final void onInterstitialAdLoad(List<AdTemplate> list) {
                    if (list == null || list.size() <= 0) {
                        return;
                    }
                    b.this.mAdTemplateList.addAll(list);
                    b.this.ia.setAdTemplateList(b.this.mAdTemplateList);
                    b.this.ia.notifyDataSetChanged();
                    b.this.hZ.setOffscreenPageLimit(b.this.mAdTemplateList.size() - 1);
                    b.this.hZ.addOnPageChangeListener(b.this.il);
                    b.this.cw();
                    b.this.ib.setViewPager(b.this.hZ);
                    b.this.ib.setVisibility(0);
                    b.this.mViewVisibleHelper.a(b.this.dk);
                    com.kwad.components.ad.interstitial.a.a.J(b.this.mContext);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cw() {
        this.ib.setPlayProgressListener(new ViewPagerIndicator.a() { // from class: com.kwad.components.ad.interstitial.aggregate.b.7
            @Override // com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator.a
            public final void cz() {
                b.a(b.this, true);
                if (b.this.hV) {
                    b.this.cy();
                } else {
                    b.this.cx();
                }
                b.this.hZ.setScrollable(true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cx() {
        if (this.ij) {
            this.ih.a(this.mAdTemplate, this.hZ);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 120, 0);
        this.f50if = ofInt;
        ofInt.setDuration(1200L);
        this.f50if.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.interstitial.aggregate.b.8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float f;
                b.this.hZ.scrollTo(com.kwad.sdk.c.kwai.a.a(b.this.mContext, ((Integer) valueAnimator.getAnimatedValue()).intValue()), 0);
                b.this.hZ.onPageScrolled(0, com.kwad.sdk.c.kwai.a.a(b.this.mContext, f) / b.this.getWidth(), 0);
            }
        });
        this.f50if.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.interstitial.aggregate.b.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                if (b.this.ij) {
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(200L);
                    alphaAnimation.setFillAfter(true);
                    b.this.ih.startAnimation(alphaAnimation);
                    b.this.ih.setVisibility(0);
                }
                b.this.ic.setVisibility(0);
                b.this.ic.startAnimation(b.a(b.this, 0.5f, 0.1f));
            }
        });
        this.f50if.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cy() {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, getWidth());
        this.f50if = ofInt;
        ofInt.setDuration(800L);
        this.f50if.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.interstitial.aggregate.b.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                b.this.hZ.scrollTo(intValue, 0);
                b.this.hZ.onPageScrolled(0, intValue / b.this.getWidth(), 0);
            }
        });
        this.f50if.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.interstitial.aggregate.b.11
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                b.this.hZ.setCurrentItem(1);
                b.this.ie.setVisibility(0);
                b.this.ie.startAnimation(b.a(b.this, -0.5f, -0.1f));
            }
        });
        this.f50if.start();
    }

    private void initView() {
        this.hZ = (TransViewPager) this.mRootView.findViewById(R.id.ksad_multi_ad_container);
        this.ib = (ViewPagerIndicator) this.mRootView.findViewById(R.id.ksad_multi_ad_indicator);
        this.ic = (SlideTipsView) this.mRootView.findViewById(R.id.ksad_left_slide);
        this.ie = (SlideTipsView) this.mRootView.findViewById(R.id.ksad_right_slide);
        this.ih = (InterstitialAggregateManualTipsView) this.mRootView.findViewById(R.id.ksad_manual_tips_view);
        this.mViewVisibleHelper = new com.kwad.components.core.widget.kwai.b(this.mRootView, 100);
    }

    @Override // com.kwad.components.ad.interstitial.e.a
    public final void a(AdTemplate adTemplate, com.kwad.components.ad.interstitial.d dVar, KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        float f;
        this.mAdTemplate = adTemplate;
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        this.mAdInfo = cb;
        boolean z = true;
        if (com.kwad.sdk.core.response.a.a.bZ(cb) != 1) {
            z = false;
        }
        this.hV = z;
        this.mAdTemplateList.clear();
        this.mAdTemplateList.add(this.mAdTemplate);
        this.hN = adInteractionListener;
        a aVar = new a(adTemplate, dVar, ksAdVideoPlayConfig, adInteractionListener);
        this.ia = aVar;
        aVar.a(new a.b() { // from class: com.kwad.components.ad.interstitial.aggregate.b.1
            @Override // com.kwad.components.ad.interstitial.aggregate.a.b
            public final void a(com.kwad.components.ad.interstitial.e.c cVar, int i) {
                b.this.hZ.a(i, cVar);
            }
        });
        this.ia.a(new a.InterfaceC0480a() { // from class: com.kwad.components.ad.interstitial.aggregate.b.4
            @Override // com.kwad.components.ad.interstitial.aggregate.a.InterfaceC0480a
            public final void cs() {
                if (b.this.ik) {
                    return;
                }
                if (b.this.f50if != null) {
                    b.this.f50if.cancel();
                }
                b.this.ib.setPlayProgressListener(null);
                b.this.ib.setVisibility(8);
                b.this.hZ.setScrollable(false);
            }
        });
        this.hZ.setAdapter(this.ia);
        this.ia.setAdTemplateList(this.mAdTemplateList);
        this.ia.notifyDataSetChanged();
        this.mViewVisibleHelper.rD();
        ViewPagerIndicator viewPagerIndicator = this.ib;
        if (viewPagerIndicator == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewPagerIndicator.getLayoutParams();
        if (marginLayoutParams != null) {
            this.ij = ai.DL();
            Context context = this.mContext;
            if (this.ij) {
                f = this.hV ? 12 : 4;
            } else {
                f = 6.0f;
            }
            marginLayoutParams.bottomMargin = com.kwad.sdk.c.kwai.a.a(context, f);
            this.ib.setLayoutParams(marginLayoutParams);
        }
        this.ib.setFirstAdShowTime(com.kwad.sdk.core.response.a.a.ca(this.mAdInfo));
        post(new Runnable() { // from class: com.kwad.components.ad.interstitial.aggregate.b.5
            @Override // java.lang.Runnable
            public final void run() {
                b.this.ct();
            }
        });
    }

    @Override // com.kwad.components.ad.interstitial.e.a
    public final void cu() {
    }

    @Override // com.kwad.components.ad.interstitial.e.a
    public final void cv() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mViewVisibleHelper.b(this.dk);
        this.mViewVisibleHelper.rE();
        this.mAdTemplateList.clear();
        this.hZ.clearOnPageChangeListeners();
        c.cA().release();
    }

    @Override // com.kwad.components.ad.interstitial.e.a
    public final void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.hN = adInteractionListener;
    }
}
