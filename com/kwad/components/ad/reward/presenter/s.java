package com.kwad.components.ad.reward.presenter;

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
import com.bytedance.applog.tracker.Tracker;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.bi;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/presenter/s.class */
public final class s extends a implements View.OnClickListener, com.kwad.components.ad.reward.d.m, com.kwad.sdk.core.f.b {
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
    private com.kwad.components.ad.reward.d.f mPlayEndPageListener = new com.kwad.components.ad.reward.d.a() { // from class: com.kwad.components.ad.reward.presenter.s.1
        @Override // com.kwad.components.ad.reward.d.f
        public final void bM() {
            if (s.this.hd != null) {
                s.this.hd.setVisibility(8);
            }
            if (s.this.hj != null) {
                s.this.hj.setVisibility(8);
            }
            if (s.this.ef != null) {
                s.this.ef.aY(s.this.getContext());
            }
            if (s.this.hl != null) {
                s.this.hl.cancel();
                s.this.hl = null;
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
        a2.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.s.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                s.this.hg.setPivotX(s.this.hg.getWidth());
                s.this.hg.setPivotY(s.this.hg.getHeight());
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hd, "translationX", f - (this.hd.getLeft() + (this.hd.getWidth() / 2.0f)));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hd, "translationY", f2 - (this.hd.getTop() + (this.hd.getHeight() / 2.0f)));
        float dimension = resources.getDimension(R.dimen.ksad_reward_shake_tips_height);
        final float dimension2 = resources.getDimension(R.dimen.ksad_reward_shake_tips_icon_size);
        float width = this.hh.getWidth();
        float width2 = this.hg.getWidth();
        if (width == 0.0f || width2 == 0.0f) {
            return null;
        }
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(width, dimension);
        ofFloat3.addUpdateListener(new com.kwad.components.ad.widget.a(this.hi) { // from class: com.kwad.components.ad.reward.presenter.s.8
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
        ofFloat4.addUpdateListener(new com.kwad.components.ad.widget.a(this.hg) { // from class: com.kwad.components.ad.reward.presenter.s.9
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
        final int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ksad_reward_shake_tips_icon_stroke_size);
        ValueAnimator ofArgb = com.kwad.sdk.widget.a.ofArgb(color, color2);
        ofArgb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.s.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    GradientDrawable gradientDrawable = (GradientDrawable) s.this.hi.getBackground();
                    gradientDrawable.mutate();
                    gradientDrawable.setColor(intValue);
                    if (intValue == color2) {
                        gradientDrawable.setStroke(dimensionPixelSize, -1);
                    }
                    s.this.hi.setBackground(gradientDrawable);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTrace(th);
                }
            }
        });
        ValueAnimator ofFloat5 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat5.setDuration(200L);
        ofFloat5.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.s.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    s.this.he.setAlpha(floatValue);
                    s.this.hf.setAlpha(floatValue);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTrace(th);
                }
            }
        });
        ValueAnimator ofFloat6 = ValueAnimator.ofFloat(this.he.getHeight(), 0.0f);
        ofFloat6.addUpdateListener(new com.kwad.components.ad.widget.a(this.he) { // from class: com.kwad.components.ad.reward.presenter.s.12
            @Override // com.kwad.components.ad.widget.a
            public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                layoutParams.height = (int) ((Float) obj).floatValue();
            }
        });
        ValueAnimator ofFloat7 = ValueAnimator.ofFloat(this.hf.getHeight(), 0.0f);
        ofFloat7.addUpdateListener(new com.kwad.components.ad.widget.a(this.hf) { // from class: com.kwad.components.ad.reward.presenter.s.13
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
        mo53clone.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.s.2
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
                s.this.hg.setPivotX(dimension2);
                s.this.hg.setPivotY(dimension2);
            }
        });
        final ViewGroup.LayoutParams layoutParams = this.hj.getLayoutParams();
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, resources.getDimension(R.dimen.ksad_reward_shake_tips_width)).setDuration(500L);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.s.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    s.this.hj.setVisibility(0);
                    layoutParams.width = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    s.this.hj.setLayoutParams(layoutParams);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTrace(th);
                }
            }
        });
        animatorSet3.playTogether(mo53clone, duration, ObjectAnimator.ofFloat(this.hk, "alpha", 0.0f, 1.0f).setDuration(500L));
        animatorSet.playSequentially(a2, a2.mo53clone(), a2.mo53clone(), ofFloat5, animatorSet2, animatorSet3);
        return animatorSet;
    }

    private static String a(com.kwad.components.ad.reward.j jVar, AdInfo adInfo) {
        String dq = com.kwad.sdk.core.response.a.b.dq(adInfo);
        com.kwad.components.core.d.b.c cVar = jVar.mApkDownloadHelper;
        String str = dq;
        if (com.kwad.sdk.core.response.a.a.ax(adInfo)) {
            str = dq;
            if (cVar != null) {
                int nb = cVar.nb();
                AdMatrixInfo.DownloadTexts ds = com.kwad.sdk.core.response.a.b.ds(adInfo);
                if (nb != 8) {
                    return nb != 12 ? ds.adActionDescription : ds.openAppLabel;
                }
                str = ds.installAppLabel;
            }
        }
        return str;
    }

    private void a(AdInfo adInfo) {
        String m7799do = com.kwad.sdk.core.response.a.b.m7799do(adInfo);
        TextView textView = this.he;
        if (textView != null) {
            textView.setText(m7799do);
        }
        TextView textView2 = this.hk;
        if (textView2 != null) {
            textView2.setText(m7799do);
        }
        String a2 = a(this.qt, adInfo);
        TextView textView3 = this.hf;
        if (textView3 != null) {
            textView3.setText("或点击" + a2);
        }
    }

    private void ci() {
        final AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        ViewGroup viewGroup = (ViewGroup) com.kwad.sdk.j.k.a(getContext(), R.layout.ksad_shake_center, adBaseFrameLayout, false);
        this.hd = viewGroup;
        viewGroup.setVisibility(0);
        Resources resources = this.hd.getResources();
        final int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ksad_reward_shake_tips_icon_marginLeft);
        int dimensionPixelSize2 = this.qt.mScreenOrientation == 1 ? resources.getDimensionPixelSize(R.dimen.ksad_reward_shake_tips_icon_marginBottom) + com.kwad.sdk.c.kwai.a.a(getContext(), 50.0f) : resources.getDimensionPixelSize(R.dimen.ksad_reward_shake_tips_icon_marginBottom);
        int dimensionPixelSize3 = this.qt.mScreenOrientation == 1 ? resources.getDimensionPixelSize(R.dimen.ksad_reward_shake_tips_title_marginBottom) + com.kwad.sdk.c.kwai.a.a(getContext(), 50.0f) : resources.getDimensionPixelSize(R.dimen.ksad_reward_shake_tips_title_marginBottom);
        int dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.ksad_reward_shake_tips_height);
        FrameLayout frameLayout = (FrameLayout) com.kwad.sdk.j.k.a(getContext(), R.layout.ksad_shake_tips_title, adBaseFrameLayout, false);
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
        final int i = dimensionPixelSize2;
        this.hd.post(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.s.6
            @Override // java.lang.Runnable
            public final void run() {
                int height = adBaseFrameLayout.getHeight();
                s sVar = s.this;
                sVar.hl = sVar.a(dimensionPixelSize, height - i);
                if (s.this.hl != null) {
                    s.this.hl.start();
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
        this.he.setOnClickListener(this);
        this.hf.setOnClickListener(this);
        this.hh.setOnClickListener(this);
        this.hk.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.core.f.b
    public final void a(double d) {
        com.kwad.sdk.core.b.b.vS();
        Activity currentActivity = com.kwad.sdk.core.b.b.getCurrentActivity();
        Activity activity = getActivity();
        boolean z = activity != null && activity.equals(currentActivity);
        if (com.kwad.components.core.d.a.b.mF() || !z) {
            bi.a(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.s.4
                @Override // java.lang.Runnable
                public final void run() {
                    s.this.ef.xD();
                }
            }, null, 500L);
            return;
        }
        if (this.qt != null && !this.qt.fW()) {
            com.kwad.sdk.core.report.i iVar = new com.kwad.sdk.core.report.i();
            iVar.i(d);
            this.qt.a(1, getContext(), 157, 1, 0L, false, iVar);
        }
        bi.a(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.s.5
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.d.b.d("RewardShakePresenter", "onShakeEvent openGate2");
                s.this.ef.xD();
            }
        }, null, 500L);
        com.kwad.sdk.core.response.a.d.cb(this.qt.mAdTemplate);
        if (this.qt.fW()) {
            return;
        }
        bi.a(getContext(), this.eg);
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(this.qt.mAdTemplate);
        this.qt.a(this);
        this.qt.b(this.mPlayEndPageListener);
        ci();
        initView();
        a(cb);
        float dm = com.kwad.sdk.core.response.a.b.dm(cb);
        com.kwad.sdk.core.f.d dVar = this.ef;
        if (dVar == null) {
            com.kwad.sdk.core.f.d dVar2 = new com.kwad.sdk.core.f.d(dm);
            this.ef = dVar2;
            dVar2.a(this);
        } else {
            dVar.e(dm);
        }
        this.ef.aX(getContext());
        Context context = getContext();
        if (context != null) {
            this.eg = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        }
    }

    @Override // com.kwad.sdk.core.f.b
    public final void bd() {
    }

    @Override // com.kwad.components.ad.reward.d.m
    public final int ch() {
        return com.kwad.sdk.c.kwai.a.g(getContext(), R.dimen.ksad_reward_shake_tips_title_marginBottom) + com.kwad.sdk.c.kwai.a.g(getContext(), R.dimen.ksad_reward_shake_tips_height);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Tracker.onClick(view);
        if (com.kwad.sdk.core.response.a.b.dk(com.kwad.sdk.core.response.a.d.cb(this.qt.mAdTemplate))) {
            this.qt.a(1, getContext(), 158, 1);
        }
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
