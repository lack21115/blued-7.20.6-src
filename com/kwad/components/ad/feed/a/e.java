package com.kwad.components.ad.feed.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.sdk.R;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/feed/a/e.class */
public final class e extends FrameLayout {
    private View fo;
    private ImageView fp;
    private Animator fq;
    private com.kwad.sdk.widget.c fr;

    public e(Context context) {
        this(context, null);
    }

    private e(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
    }

    private e(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0);
        init(context);
    }

    private Animator a(View view, long j, float f) {
        if (view == null) {
            return null;
        }
        Interpolator create = PathInterpolatorCompat.create(0.22f, 0.59f, 0.36f, 1.0f);
        this.fp.setPivotX(view.getWidth());
        this.fp.setPivotY(view.getHeight());
        Animator a2 = com.kwad.components.core.r.m.a(view, create, 100L, 16.0f);
        Animator a3 = com.kwad.components.core.r.m.a(view, create, 100L, 16.0f);
        Animator a4 = com.kwad.components.core.r.m.a(view, create, 100L, 16.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(a2, a3, a4);
        return animatorSet;
    }

    private Animator b(final View view, int i) {
        if (view == null) {
            return null;
        }
        view.setPivotX(view.getWidth() / 2.0f);
        view.setPivotY(view.getHeight() / 2.0f);
        float min = i / Math.min(view.getHeight(), view.getWidth());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", min, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", min, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        animatorSet.setDuration(500L);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.a.e.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                view.setVisibility(0);
                view.setClickable(true);
                new com.kwad.sdk.widget.f(view, e.this.fr);
            }
        });
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator bx() {
        View view = this.fo;
        if (view == null || this.fp == null || view.getWidth() + this.fo.getHeight() == 0 || this.fp.getWidth() + this.fp.getHeight() == 0) {
            return null;
        }
        Animator by = by();
        Animator a2 = a(this.fp, 100L, 16.0f);
        Animator bz = bz();
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(by, a2, bz);
        return animatorSet;
    }

    private Animator by() {
        Animator b = b(this.fo, com.kwad.sdk.c.kwai.a.a(getContext(), 128.0f));
        Animator b2 = b(this.fp, com.kwad.sdk.c.kwai.a.a(getContext(), 71.11f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500L);
        animatorSet.playTogether(b, b2);
        return animatorSet;
    }

    private Animator bz() {
        Animator f = f(this.fo);
        Animator f2 = f(this.fp);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500L);
        animatorSet.playTogether(f, f2);
        return animatorSet;
    }

    private Animator f(final View view) {
        if (view == null) {
            return null;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat);
        animatorSet.setDuration(500L);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.a.e.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(8);
            }
        });
        return animatorSet;
    }

    private void init(Context context) {
        com.kwad.sdk.j.k.inflate(context, R.layout.ksad_feed_shake, this);
        setClickable(false);
        this.fo = findViewById(R.id.ksad_feed_shake_bg);
        this.fp = (ImageView) findViewById(R.id.ksad_feed_shake_icon);
    }

    public final void a(final AnimatorListenerAdapter animatorListenerAdapter) {
        Animator animator = this.fq;
        if (animator != null) {
            animator.cancel();
            this.fq = null;
        }
        this.fp.post(new Runnable() { // from class: com.kwad.components.ad.feed.a.e.1
            @Override // java.lang.Runnable
            public final void run() {
                e eVar = e.this;
                eVar.fq = eVar.bx();
                if (e.this.fq == null) {
                    animatorListenerAdapter.onAnimationEnd(null);
                    return;
                }
                e.this.fq.addListener(animatorListenerAdapter);
                e.this.fq.start();
            }
        });
    }

    public final void setOnViewEventListener(com.kwad.sdk.widget.c cVar) {
        this.fr = cVar;
    }
}
