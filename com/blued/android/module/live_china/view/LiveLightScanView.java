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

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveLightScanView.class */
public class LiveLightScanView extends FrameLayout {
    private ImageView a;
    private ValueAnimator b;
    private long c;

    /* renamed from: com.blued.android.module.live_china.view.LiveLightScanView$3  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveLightScanView$3.class */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ LiveLightScanView a;

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.b != null && this.a.b.isRunning()) {
                this.a.b.cancel();
            }
            this.a.b();
            this.a.b.start();
        }
    }

    public LiveLightScanView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = 1000L;
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.live_light_scan_view, this);
        ImageView imageView = (ImageView) findViewById(R.id.iv_light);
        this.a = imageView;
        imageView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        final int width = getWidth();
        final int i = -width;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.b = ofFloat;
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        this.b.setDuration(this.c);
        this.b.addListener(new Animator.AnimatorListener() { // from class: com.blued.android.module.live_china.view.LiveLightScanView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LiveLightScanView.this.a.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LiveLightScanView.this.a.setVisibility(0);
            }
        });
        this.b.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.LiveLightScanView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ImageView imageView = LiveLightScanView.this.a;
                int i2 = width;
                int i3 = i;
                imageView.setX(((i2 - i3) * floatValue) + i3);
            }
        });
    }

    public void setDuration(int i) {
        this.c = i;
    }

    public void setImage(int i) {
        this.a.setImageResource(i);
    }
}
