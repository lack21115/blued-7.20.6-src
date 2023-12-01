package com.kwad.components.core.page.splitLandingPage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.kwad.components.core.d.b.c;
import com.kwad.components.core.l.f;
import com.kwad.components.core.page.a.b;
import com.kwad.components.core.page.recycle.e;
import com.kwad.components.core.page.splitLandingPage.view.SplitScrollWebView;
import com.kwad.components.core.page.splitLandingPage.view.a;
import com.kwad.components.core.r.m;
import com.kwad.components.core.widget.FeedVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/page/splitLandingPage/a.class */
public final class a extends f {
    private FeedVideoView Ld;
    private LinearLayout Le;
    private SplitScrollWebView MV;
    private Presenter MW;
    private com.kwad.components.core.page.splitLandingPage.view.a MX;
    private com.kwad.components.core.page.a.a MY;
    private boolean MZ;
    private AdTemplate mAdTemplate;
    private c mApkDownloadHelper;

    public static a M(AdTemplate adTemplate) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putString("key_photo", adTemplate.toJson().toString());
        bundle.putBoolean("key_report", adTemplate.mPvReported);
        aVar.setArguments(bundle);
        return aVar;
    }

    static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.MZ = false;
        return false;
    }

    private void i(ViewGroup viewGroup) {
        Presenter presenter = new Presenter();
        this.MW = presenter;
        presenter.E(viewGroup);
        b bVar = new b();
        bVar.E(this.MV);
        com.kwad.components.core.page.a.a aVar = new com.kwad.components.core.page.a.a();
        this.MY = aVar;
        aVar.E(this.Ld);
        this.MW.a(bVar);
        this.MW.a(this.MY);
    }

    private void initView() {
        e eVar = new e(this.mAdTemplate, this.mApkDownloadHelper, null);
        this.MW.f(eVar);
        com.kwad.components.core.page.splitLandingPage.view.a aVar = new com.kwad.components.core.page.splitLandingPage.view.a(getContext(), new com.kwad.components.core.page.splitLandingPage.kwai.a(eVar.adTemplate, eVar.IM));
        this.MX = aVar;
        aVar.a(new a.InterfaceC0531a() { // from class: com.kwad.components.core.page.splitLandingPage.a.3
            @Override // com.kwad.components.core.page.splitLandingPage.view.a.InterfaceC0531a
            public final boolean oQ() {
                return a.this.oN();
            }
        });
        this.Ld.post(new Runnable() { // from class: com.kwad.components.core.page.splitLandingPage.a.4
            @Override // java.lang.Runnable
            public final void run() {
                a.this.MV.setTranslationY(a.this.MV.getTranslationY() + a.this.Ld.getHeight());
            }
        });
        this.MV.setSplitScrollWebViewListener(new SplitScrollWebView.a() { // from class: com.kwad.components.core.page.splitLandingPage.a.5
            @Override // com.kwad.components.core.page.splitLandingPage.view.SplitScrollWebView.a
            public final void d(float f) {
                a.this.MV.setTranslationY(a.this.MV.getTranslationY() - f);
            }

            @Override // com.kwad.components.core.page.splitLandingPage.view.SplitScrollWebView.a
            public final boolean oR() {
                if (a.this.MX.oS() || d.tW() != 2) {
                    AnimatorSet animatorSet = new AnimatorSet();
                    Animator a2 = m.a((View) a.this.MV, (Interpolator) null, a.this.MV.getTranslationY(), 0.0f);
                    if (d.tW() == 2) {
                        if (a.this.Ld.isComplete()) {
                            animatorSet.playTogether(a2);
                        } else {
                            animatorSet.playSequentially(a2, a.this.MX.aE(true));
                        }
                    } else if (d.tW() == 1) {
                        animatorSet.playTogether(a2);
                    }
                    animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.core.page.splitLandingPage.a.5.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public final void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            a.this.Ld.oP();
                            if (d.tW() != 2 || a.this.Ld.isComplete()) {
                                return;
                            }
                            a.this.MX.oT();
                        }
                    });
                    animatorSet.start();
                    return true;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean oN() {
        SplitScrollWebView splitScrollWebView = this.MV;
        if (splitScrollWebView == null || splitScrollWebView.getTranslationY() != 0.0f || this.MZ) {
            return false;
        }
        this.MV.setDisableAnimation(false);
        this.MZ = true;
        SplitScrollWebView splitScrollWebView2 = this.MV;
        Animator a2 = m.a((View) splitScrollWebView2, (Interpolator) null, 0.0f, splitScrollWebView2.getTranslationY() + this.Ld.getHeight());
        AnimatorSet animatorSet = new AnimatorSet();
        if (d.tW() == 2 && this.MX.isVisible()) {
            this.MX.oP();
            animatorSet.playSequentially(this.MX.aE(false), a2);
        } else {
            animatorSet.play(a2);
        }
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.core.page.splitLandingPage.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.oO();
                a.this.Ld.oT();
                a.a(a.this, false);
            }
        });
        animatorSet.start();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oO() {
        this.MY.jW();
        this.MY.E(this.Ld);
        this.MY.f(new e(this.mAdTemplate, this.mApkDownloadHelper, null));
    }

    private void v(View view) {
        this.Le = (LinearLayout) view.findViewById(R.id.ksad_web_tip_bar);
        TextView textView = (TextView) view.findViewById(R.id.ksad_web_tip_bar_textview);
        ((ImageView) view.findViewById(R.id.ksad_web_tip_close_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.splitLandingPage.a.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Tracker.onClick(view2);
                a.this.Le.setVisibility(8);
            }
        });
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
        boolean bn = com.kwad.sdk.core.response.a.a.bn(cb);
        String bj = com.kwad.sdk.core.response.a.a.bj(cb);
        if (!bn) {
            this.Le.setVisibility(8);
            return;
        }
        this.Le.setVisibility(0);
        textView.setText(bj);
        textView.setSelected(true);
    }

    @Override // com.kwad.components.core.l.f, com.kwad.sdk.i.kwai.b
    public final boolean bX() {
        SplitScrollWebView splitScrollWebView = this.MV;
        if (splitScrollWebView != null && splitScrollWebView.canGoBack()) {
            this.MV.goBack();
            return true;
        } else if (oN()) {
            return true;
        } else {
            FeedVideoView feedVideoView = this.Ld;
            if (feedVideoView != null) {
                return feedVideoView.ry();
            }
            return false;
        }
    }

    public final void oP() {
        this.Ld.oP();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = getArguments().getString("key_photo");
        AdTemplate adTemplate = new AdTemplate();
        if (string != null) {
            try {
                adTemplate.parseJson(new JSONObject(string));
            } catch (JSONException e) {
                com.kwad.sdk.core.d.b.printStackTrace(e);
            }
        }
        this.mAdTemplate = adTemplate;
        adTemplate.mPvReported = getArguments().getBoolean("key_report", false);
        this.mAdTemplate.mAdWebVideoPageShowing = true;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.ksad_split_land_page, viewGroup, false);
        this.Ld = (FeedVideoView) inflate.findViewById(R.id.ksad_split_land_ad_feed_video);
        this.MV = (SplitScrollWebView) inflate.findViewById(R.id.ksad_video_webView);
        v(inflate);
        i(viewGroup);
        return inflate;
    }

    @Override // com.kwad.components.core.l.f, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onDestroy() {
        super.onDestroy();
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            adTemplate.mAdWebVideoPageShowing = false;
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initView();
    }

    public final void setApkDownloadHelper(c cVar) {
        this.mApkDownloadHelper = cVar;
    }
}
