package com.blued.android.module.live_china.view.shimmer;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import com.blued.android.module.live_china.view.shimmer.ShimmerViewHelper;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/shimmer/Shimmer.class */
public class Shimmer {

    /* renamed from: a  reason: collision with root package name */
    private int f15452a = -1;
    private long b = 1000;

    /* renamed from: c  reason: collision with root package name */
    private long f15453c = 0;
    private int d = 0;
    private Animator.AnimatorListener e;
    private ObjectAnimator f;

    public void a() {
        ObjectAnimator objectAnimator = this.f;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    public <V extends View & ShimmerViewBase> void a(final V v) {
        if (b()) {
            return;
        }
        final Runnable runnable = new Runnable() { // from class: com.blued.android.module.live_china.view.shimmer.Shimmer.1
            @Override // java.lang.Runnable
            public void run() {
                ((ShimmerViewBase) v).setShimmering(true);
                float width = v.getWidth();
                float f = 0.0f;
                if (Shimmer.this.d == 1) {
                    f = v.getWidth();
                    width = 0.0f;
                }
                Shimmer.this.f = ObjectAnimator.ofFloat(v, "gradientX", f, width);
                Shimmer.this.f.setRepeatCount(Shimmer.this.f15452a);
                Shimmer.this.f.setDuration(Shimmer.this.b);
                Shimmer.this.f.setStartDelay(Shimmer.this.f15453c);
                Shimmer.this.f.addListener(new Animator.AnimatorListener() { // from class: com.blued.android.module.live_china.view.shimmer.Shimmer.1.1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        ((ShimmerViewBase) v).setShimmering(false);
                        v.postInvalidateOnAnimation();
                        Shimmer.this.f = null;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }
                });
                if (Shimmer.this.e != null) {
                    Shimmer.this.f.addListener(Shimmer.this.e);
                }
                Shimmer.this.f.start();
            }
        };
        V v2 = v;
        if (v2.a()) {
            runnable.run();
        } else {
            v2.setAnimationSetupCallback(new ShimmerViewHelper.AnimationSetupCallback() { // from class: com.blued.android.module.live_china.view.shimmer.Shimmer.2
                @Override // com.blued.android.module.live_china.view.shimmer.ShimmerViewHelper.AnimationSetupCallback
                public void a(View view) {
                    runnable.run();
                }
            });
        }
    }

    public boolean b() {
        ObjectAnimator objectAnimator = this.f;
        return objectAnimator != null && objectAnimator.isRunning();
    }
}
