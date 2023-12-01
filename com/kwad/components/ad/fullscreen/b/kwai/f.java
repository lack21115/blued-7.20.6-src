package com.kwad.components.ad.fullscreen.b.kwai;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Vibrator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.reward.d.m;
import com.kwad.components.ad.reward.j;
import com.kwad.sdk.R;
import com.kwad.sdk.core.report.i;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.j.k;
import com.kwad.sdk.utils.bi;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/fullscreen/b/kwai/f.class */
public final class f extends com.kwad.components.ad.reward.presenter.a implements m, com.kwad.sdk.core.f.b, com.kwad.sdk.widget.c {
    private com.kwad.sdk.core.f.d ef;
    private Vibrator eg;
    private ViewGroup hd;
    private TextView he;
    private TextView hf;
    private ImageView hg;
    private FrameLayout hh;
    private ImageView hi;
    private FrameLayout hj;
    private TextView hk;
    private Animator hl;
    private com.kwad.components.ad.reward.d.f mPlayEndPageListener = new com.kwad.components.ad.reward.d.a() { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.1
        @Override // com.kwad.components.ad.reward.d.f
        public final void bM() {
            if (f.this.hd != null) {
                f.this.hd.setVisibility(8);
            }
            if (f.this.hj != null) {
                f.this.hj.setVisibility(8);
            }
            if (f.this.ef != null) {
                f.this.ef.aY(f.this.getContext());
            }
            if (f.this.hl != null) {
                f.this.hl.cancel();
                f.this.hl = null;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public Animator a(float f, float f2) {
        if (this.hd == null) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        Resources resources = this.hd.getResources();
        Animator a2 = com.kwad.components.core.r.m.a((View) this.hg, (Interpolator) null, 100L, 16.0f);
        a2.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                f.this.hg.setPivotX(f.this.hg.getWidth());
                f.this.hg.setPivotY(f.this.hg.getHeight());
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hd, "translationX", f - (this.hd.getLeft() + (this.hd.getWidth() / 2.0f)));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hd, "translationY", f2 - (this.hd.getTop() + (this.hd.getHeight() / 2.0f)));
        float dimension = resources.getDimension(R.dimen.ksad_fullscreen_shake_tips_height);
        final float dimension2 = resources.getDimension(R.dimen.ksad_fullscreen_shake_tips_icon_size);
        float width = this.hh.getWidth();
        float width2 = this.hg.getWidth();
        if (width == 0.0f || width2 == 0.0f) {
            return null;
        }
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(width, dimension);
        ofFloat3.addUpdateListener(new com.kwad.components.ad.widget.a(this.hi) { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.8
            @Override // com.kwad.components.ad.widget.a
            public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                float floatValue = ((Float) obj).floatValue();
                if (layoutParams != null) {
                    int i = (int) floatValue;
                    layoutParams.height = i;
                    layoutParams.width = i;
                }
            }
        });
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(width2, dimension2);
        ofFloat4.addUpdateListener(new com.kwad.components.ad.widget.a(this.hg) { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.9
            @Override // com.kwad.components.ad.widget.a
            public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                float floatValue = ((Float) obj).floatValue();
                if (layoutParams != null) {
                    int i = (int) floatValue;
                    layoutParams.height = i;
                    layoutParams.width = i;
                }
            }
        });
        int color = resources.getColor(R.color.ksad_shake_icon_bg_start_color);
        final int color2 = resources.getColor(R.color.ksad_reward_main_color);
        final int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ksad_fullscreen_shake_tips_icon_stroke_size);
        ValueAnimator ofArgb = com.kwad.sdk.widget.a.ofArgb(color, color2);
        ofArgb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    GradientDrawable gradientDrawable = (GradientDrawable) f.this.hi.getBackground();
                    gradientDrawable.mutate();
                    gradientDrawable.setColor(intValue);
                    if (intValue == color2) {
                        gradientDrawable.setStroke(dimensionPixelSize, -1);
                    }
                    f.this.hi.setBackground(gradientDrawable);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTrace(th);
                }
            }
        });
        ValueAnimator ofFloat5 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat5.setDuration(200L);
        ofFloat5.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    f.this.he.setAlpha(floatValue);
                    f.this.hf.setAlpha(floatValue);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTrace(th);
                }
            }
        });
        ValueAnimator ofFloat6 = ValueAnimator.ofFloat(this.he.getHeight(), 0.0f);
        ofFloat6.addUpdateListener(new com.kwad.components.ad.widget.a(this.he) { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.12
            @Override // com.kwad.components.ad.widget.a
            public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                layoutParams.height = (int) ((Float) obj).floatValue();
            }
        });
        ValueAnimator ofFloat7 = ValueAnimator.ofFloat(this.hf.getHeight(), 0.0f);
        ofFloat7.addUpdateListener(new com.kwad.components.ad.widget.a(this.hf) { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.13
            @Override // com.kwad.components.ad.widget.a
            public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                layoutParams.height = (int) ((Float) obj).floatValue();
            }
        });
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setDuration(500L);
        animatorSet2.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4, ofArgb, ofFloat6, ofFloat7);
        AnimatorSet animatorSet3 = new AnimatorSet();
        final Animator mo53clone = a2.mo53clone();
        mo53clone.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.2
            private boolean hn = false;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                this.hn = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (this.hn) {
                    return;
                }
                mo53clone.start();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                f.this.hg.setPivotX(dimension2);
                f.this.hg.setPivotY(dimension2);
            }
        });
        final ViewGroup.LayoutParams layoutParams = this.hj.getLayoutParams();
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, resources.getDimension(R.dimen.ksad_fullscreen_shake_tips_width)).setDuration(500L);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    f.this.hj.setVisibility(0);
                    layoutParams.width = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    f.this.hj.setLayoutParams(layoutParams);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTrace(th);
                }
            }
        });
        animatorSet3.playTogether(mo53clone, duration, ObjectAnimator.ofFloat(this.hk, "alpha", 0.0f, 1.0f).setDuration(500L));
        animatorSet.playSequentially(a2, a2.mo53clone(), a2.mo53clone(), ofFloat5, animatorSet2, animatorSet3);
        return animatorSet;
    }

    private static String a(j jVar, AdInfo adInfo) {
        String dp = com.kwad.sdk.core.response.a.b.dp(adInfo);
        com.kwad.components.core.d.b.c cVar = jVar.mApkDownloadHelper;
        String str = dp;
        if (com.kwad.sdk.core.response.a.a.ax(adInfo)) {
            str = dp;
            if (cVar != null) {
                int nb = cVar.nb();
                AdMatrixInfo.DownloadTexts dr = com.kwad.sdk.core.response.a.b.dr(adInfo);
                if (nb != 8) {
                    return nb != 12 ? dr.adActionDescription : dr.openAppLabel;
                }
                str = dr.installAppLabel;
            }
        }
        return str;
    }

    private void a(AdInfo adInfo) {
        String dn = com.kwad.sdk.core.response.a.b.dn(adInfo);
        TextView textView = this.he;
        if (textView != null) {
            textView.setText(dn);
        }
        TextView textView2 = this.hk;
        if (textView2 != null) {
            textView2.setText(dn);
        }
        String a2 = a(this.qt, adInfo);
        TextView textView3 = this.hf;
        if (textView3 != null) {
            textView3.setText("或点击" + a2);
        }
    }

    private void ci() {
        final AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        ViewGroup viewGroup = (ViewGroup) k.a(getContext(), R.layout.ksad_shake_center, adBaseFrameLayout, false);
        this.hd = viewGroup;
        viewGroup.setVisibility(0);
        Resources resources = this.hd.getResources();
        final int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ksad_fullscreen_shake_tips_icon_marginLeft);
        final int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.ksad_fullscreen_shake_tips_icon_marginBottom);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.ksad_fullscreen_shake_tips_title_marginBottom);
        int dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.ksad_fullscreen_shake_tips_height);
        FrameLayout frameLayout = (FrameLayout) k.a(getContext(), R.layout.ksad_shake_tips_title, adBaseFrameLayout, false);
        this.hj = frameLayout;
        this.hk = (TextView) frameLayout.findViewById(R.id.ksad_shake_tips_label);
        this.hj.setVisibility(4);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, dimensionPixelSize4);
        layoutParams.leftMargin = dimensionPixelSize;
        layoutParams.bottomMargin = dimensionPixelSize3;
        layoutParams.gravity = 83;
        adBaseFrameLayout.addView(this.hj, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        adBaseFrameLayout.addView(this.hd, layoutParams2);
        com.kwad.sdk.core.report.a.b(this.qt.mAdTemplate, 185, (JSONObject) null);
        this.hd.post(new Runnable() { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.6
            @Override // java.lang.Runnable
            public final void run() {
                int height = adBaseFrameLayout.getHeight();
                f fVar = f.this;
                fVar.hl = fVar.a(dimensionPixelSize, height - dimensionPixelSize2);
                if (f.this.hl != null) {
                    f.this.hl.start();
                }
            }
        });
    }

    private void initView() {
        this.he = (TextView) this.hd.findViewById(R.id.ksad_shake_center_title);
        this.hf = (TextView) this.hd.findViewById(R.id.ksad_shake_center_sub_title);
        this.hg = (ImageView) this.hd.findViewById(R.id.ksad_shake_center_icon);
        this.hh = (FrameLayout) this.hd.findViewById(R.id.ksad_shake_center_circle_area);
        this.hi = (ImageView) this.hd.findViewById(R.id.ksad_shake_center_circle_area_bg);
        new com.kwad.sdk.widget.f(getContext(), this.hd, this);
    }

    @Override // com.kwad.sdk.core.f.b
    public final void a(double d) {
        com.kwad.sdk.core.b.b.vS();
        Activity currentActivity = com.kwad.sdk.core.b.b.getCurrentActivity();
        Activity activity = getActivity();
        boolean z = activity != null && activity.equals(currentActivity);
        if (com.kwad.components.core.d.a.b.mF() || !z) {
            bi.a(new Runnable() { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.4
                @Override // java.lang.Runnable
                public final void run() {
                    f.this.ef.xD();
                }
            }, null, 500L);
            return;
        }
        if (this.qt != null) {
            i iVar = new i();
            iVar.i(d);
            this.qt.a(1, getContext(), 157, 1, 0L, false, iVar);
        }
        bi.a(new Runnable() { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.5
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.d.b.d("ShakePresenter", "onShakeEvent openGate2");
                f.this.ef.xD();
            }
        }, null, 500L);
        bi.a(getContext(), this.eg);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        this.qt.a(1, getContext(), 158, 1);
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(this.qt.mAdTemplate);
        if (com.kwad.components.ad.fullscreen.a.a.a(getContext(), this.qt.mAdTemplate)) {
            this.qt.a(this);
            this.qt.b(this.mPlayEndPageListener);
            ci();
            initView();
            a(cb);
            float dl = com.kwad.sdk.core.response.a.b.dl(cb);
            com.kwad.sdk.core.f.d dVar = this.ef;
            if (dVar == null) {
                com.kwad.sdk.core.f.d dVar2 = new com.kwad.sdk.core.f.d(dl);
                this.ef = dVar2;
                dVar2.a(this);
            } else {
                dVar.e(dl);
            }
            this.ef.aX(getContext());
            Context context = getContext();
            if (context != null) {
                this.eg = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
            }
            com.kwad.components.ad.fullscreen.a.a.H(getContext());
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        this.qt.a(1, getContext(), 158, 1);
    }

    @Override // com.kwad.sdk.core.f.b
    public final void bd() {
    }

    @Override // com.kwad.components.ad.reward.d.m
    public final int ch() {
        return com.kwad.sdk.c.kwai.a.g(getContext(), R.dimen.ksad_fullscreen_shake_tips_title_marginBottom) + com.kwad.sdk.c.kwai.a.g(getContext(), R.dimen.ksad_fullscreen_shake_tips_height);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        ViewGroup viewGroup = this.hd;
        if (viewGroup != null) {
            if (viewGroup.getParent() != null) {
                ((ViewGroup) this.hd.getParent()).removeView(this.hd);
            }
            this.hd = null;
        }
        bi.b(getContext(), this.eg);
        this.eg = null;
        Animator animator = this.hl;
        if (animator != null) {
            animator.cancel();
            this.hl = null;
        }
        this.qt.c(this.mPlayEndPageListener);
    }
}
