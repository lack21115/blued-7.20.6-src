package com.kwad.components.ad.g;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bi;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/g/a.class */
public final class a {
    private View FY;
    private Runnable FZ;
    private boolean Ga = false;
    private Animator hl;
    private View xF;
    private Button xG;
    private Button xH;

    public a(View view) {
        this.FY = view;
        initView();
    }

    private static Animator a(final View view, float f, final float f2, long j) {
        final float f3 = f / f2;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, f2);
        ofFloat.setDuration(j);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        final float dimension = view.getResources().getDimension(R.dimen.ksad_reward_apk_info_card_actionbar_text_size);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.g.a.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                float f4 = f3;
                float f5 = f2;
                if (f5 != 0.0f) {
                    float f6 = floatValue / f5;
                    float f7 = dimension;
                    View view2 = view;
                    if (view2 instanceof TextView) {
                        ((TextView) view2).setTextSize(0, f6 * f7);
                    }
                }
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = (int) floatValue;
                    layoutParams.width = (int) (f4 * floatValue);
                    view.setLayoutParams(layoutParams);
                }
            }
        });
        return ofFloat;
    }

    private static Animator a(final View view, View view2, int i, int i2, long j, long j2) {
        Animator b = b(view, 200L);
        float f = i;
        float f2 = i2;
        Animator a2 = a(view2, f, f2, 200L);
        a2.addListener(new com.kwad.components.ad.widget.tailframe.appbar.b() { // from class: com.kwad.components.ad.g.a.2
            @Override // com.kwad.components.ad.widget.tailframe.appbar.b, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setAlpha(1.0f);
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = 0;
                    layoutParams.height = 0;
                    view.setLayoutParams(layoutParams);
                }
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, "scaleX", 1.0f, 1.0f);
        ofFloat.setDuration(1600L);
        Animator b2 = b(view2, 200L);
        Animator a3 = a(view, f, f2, 200L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(b, a2, ofFloat, b2, a3);
        return animatorSet;
    }

    private static Animator b(View view, long j) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        ofFloat.setDuration(j);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        return ofFloat;
    }

    private void initView() {
        this.xG = (Button) this.FY.findViewById(R.id.ksad_reward_apk_info_install_action);
        this.xH = (Button) this.FY.findViewById(R.id.ksad_reward_apk_info_install_start);
        this.xF = this.FY.findViewById(R.id.ksad_reward_apk_info_install_container);
    }

    public final void jI() {
        lC();
    }

    public final void lB() {
        com.kwad.sdk.core.d.b.d("ApkInstallAnimHelper", "startAnimation");
        int height = this.xF.getHeight();
        int width = this.xF.getWidth();
        if (height == 0 || width == 0) {
            return;
        }
        if (this.hl == null) {
            Animator a2 = a(this.xH, this.xG, width, height, 1600L, 200L);
            this.hl = a2;
            a2.addListener(new com.kwad.components.ad.widget.tailframe.appbar.b() { // from class: com.kwad.components.ad.g.a.1
                @Override // com.kwad.components.ad.widget.tailframe.appbar.b, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(final Animator animator) {
                    if (a.this.Ga) {
                        return;
                    }
                    if (a.this.FZ == null) {
                        a.this.FZ = new Runnable() { // from class: com.kwad.components.ad.g.a.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                animator.start();
                            }
                        };
                    }
                    bi.a(a.this.FZ, null, 1600L);
                }
            });
        }
        com.kwad.sdk.core.d.b.d("ApkInstallAnimHelper", "mAnimator isStarted: " + this.hl.isStarted());
        if (!this.hl.isStarted()) {
            com.kwad.sdk.core.d.b.d("ApkInstallAnimHelper", "mAnimator.start()");
            this.hl.start();
        }
        this.Ga = false;
    }

    public final void lC() {
        Animator animator = this.hl;
        if (animator != null) {
            animator.cancel();
            this.hl.removeAllListeners();
            this.Ga = true;
        }
        Runnable runnable = this.FZ;
        if (runnable != null) {
            bi.b(runnable);
            this.FZ = null;
        }
    }

    public final void lD() {
        this.Ga = true;
    }
}
