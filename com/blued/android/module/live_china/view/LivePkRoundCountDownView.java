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

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LivePkRoundCountDownView.class */
public class LivePkRoundCountDownView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f14852a;
    private ValueAnimator b;

    /* renamed from: c  reason: collision with root package name */
    private long f14853c;
    private int d;

    public LivePkRoundCountDownView(Context context) {
        this(context, null);
    }

    public LivePkRoundCountDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14853c = 600L;
        this.d = 5;
        c();
    }

    static /* synthetic */ int c(LivePkRoundCountDownView livePkRoundCountDownView) {
        int i = livePkRoundCountDownView.d;
        livePkRoundCountDownView.d = i - 1;
        return i;
    }

    private void c() {
        LayoutInflater.from(getContext()).inflate(R.layout.live_pk_round_count_down_view, this);
        this.f14852a = (ImageView) findViewById(R.id.iv_round_time);
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.3f, 1.2f, 1.0f);
        this.b = ofFloat;
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        this.b.setDuration(this.f14853c);
        this.b.addListener(new Animator.AnimatorListener() { // from class: com.blued.android.module.live_china.view.LivePkRoundCountDownView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (LivePkRoundCountDownView.this.d <= 1) {
                    LivePkRoundCountDownView.this.setVisibility(8);
                    return;
                }
                LivePkRoundCountDownView.c(LivePkRoundCountDownView.this);
                LivePkRoundCountDownView.this.postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.LivePkRoundCountDownView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (LivePkRoundCountDownView.this.d >= 1) {
                            LivePkRoundCountDownView.this.b.start();
                        }
                    }
                }, 400L);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LivePkRoundCountDownView.this.setVisibility(0);
                if (LivePkRoundCountDownView.this.d == 1) {
                    LivePkRoundCountDownView.this.f14852a.setImageResource(R.drawable.live_pk_round_down1);
                } else if (LivePkRoundCountDownView.this.d == 2) {
                    LivePkRoundCountDownView.this.f14852a.setImageResource(R.drawable.live_pk_round_down2);
                } else if (LivePkRoundCountDownView.this.d == 3) {
                    LivePkRoundCountDownView.this.f14852a.setImageResource(R.drawable.live_pk_round_down3);
                } else if (LivePkRoundCountDownView.this.d == 4) {
                    LivePkRoundCountDownView.this.f14852a.setImageResource(R.drawable.live_pk_round_down4);
                } else if (LivePkRoundCountDownView.this.d == 5) {
                    LivePkRoundCountDownView.this.f14852a.setImageResource(R.drawable.live_pk_round_down5);
                }
            }
        });
        this.b.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.LivePkRoundCountDownView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                LivePkRoundCountDownView.this.f14852a.setScaleX(floatValue);
                LivePkRoundCountDownView.this.f14852a.setScaleY(floatValue);
            }
        });
    }

    public void a() {
        post(new Runnable() { // from class: com.blued.android.module.live_china.view.LivePkRoundCountDownView.3
            @Override // java.lang.Runnable
            public void run() {
                if (LivePkRoundCountDownView.this.b != null && LivePkRoundCountDownView.this.b.isRunning()) {
                    LivePkRoundCountDownView.this.b.cancel();
                }
                LivePkRoundCountDownView.this.d = 5;
                LivePkRoundCountDownView.this.d();
                LivePkRoundCountDownView.this.b.start();
            }
        });
    }

    public void b() {
        this.d = 0;
        ValueAnimator valueAnimator = this.b;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.b.cancel();
        }
        setVisibility(8);
    }
}
