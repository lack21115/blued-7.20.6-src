package com.blued.android.module.live_china.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveMultiPkCountDownView.class */
public class LiveMultiPkCountDownView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f14681a;
    private ValueAnimator b;

    /* renamed from: c  reason: collision with root package name */
    private long f14682c;
    private int d;

    public LiveMultiPkCountDownView(Context context) {
        this(context, null);
    }

    public LiveMultiPkCountDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14682c = 600L;
        this.d = 5;
        b();
    }

    private void b() {
        LayoutInflater.from(getContext()).inflate(R.layout.live_pk_round_count_down_view, this);
        this.f14681a = (ImageView) findViewById(R.id.iv_round_time);
        setVisibility(8);
    }

    static /* synthetic */ int c(LiveMultiPkCountDownView liveMultiPkCountDownView) {
        int i = liveMultiPkCountDownView.d;
        liveMultiPkCountDownView.d = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.3f, 1.2f, 1.0f);
        this.b = ofFloat;
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        this.b.setDuration(this.f14682c);
        this.b.addListener(new Animator.AnimatorListener() { // from class: com.blued.android.module.live_china.view.LiveMultiPkCountDownView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (LiveMultiPkCountDownView.this.d <= 1) {
                    LiveMultiPkCountDownView.this.setVisibility(8);
                    return;
                }
                LiveMultiPkCountDownView.c(LiveMultiPkCountDownView.this);
                LiveMultiPkCountDownView.this.postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.LiveMultiPkCountDownView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (LiveMultiPkCountDownView.this.d >= 1) {
                            LiveMultiPkCountDownView.this.b.start();
                        }
                    }
                }, 400L);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LiveMultiPkCountDownView.this.setVisibility(0);
                if (LiveMultiPkCountDownView.this.d == 1) {
                    LiveMultiPkCountDownView.this.f14681a.setImageResource(R.drawable.live_pk_multi_down1);
                } else if (LiveMultiPkCountDownView.this.d == 2) {
                    LiveMultiPkCountDownView.this.f14681a.setImageResource(R.drawable.live_pk_multi_down2);
                } else if (LiveMultiPkCountDownView.this.d == 3) {
                    LiveMultiPkCountDownView.this.f14681a.setImageResource(R.drawable.live_pk_multi_down3);
                } else if (LiveMultiPkCountDownView.this.d == 4) {
                    LiveMultiPkCountDownView.this.f14681a.setImageResource(R.drawable.live_pk_multi_down4);
                } else if (LiveMultiPkCountDownView.this.d == 5) {
                    LiveMultiPkCountDownView.this.f14681a.setImageResource(R.drawable.live_pk_multi_down5);
                }
            }
        });
        this.b.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.LiveMultiPkCountDownView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                LiveMultiPkCountDownView.this.f14681a.setScaleX(floatValue);
                LiveMultiPkCountDownView.this.f14681a.setScaleY(floatValue);
            }
        });
    }

    public void a() {
        post(new Runnable() { // from class: com.blued.android.module.live_china.view.LiveMultiPkCountDownView.3
            @Override // java.lang.Runnable
            public void run() {
                if (LiveMultiPkCountDownView.this.b != null && LiveMultiPkCountDownView.this.b.isRunning()) {
                    LiveMultiPkCountDownView.this.b.cancel();
                }
                LiveMultiPkCountDownView.this.d = 5;
                LiveMultiPkCountDownView.this.c();
                LiveMultiPkCountDownView.this.b.start();
            }
        });
    }
}
