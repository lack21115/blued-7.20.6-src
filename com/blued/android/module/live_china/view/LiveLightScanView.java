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

    /* renamed from: a  reason: collision with root package name */
    private ImageView f14494a;
    private ValueAnimator b;

    /* renamed from: c  reason: collision with root package name */
    private long f14495c;

    /* renamed from: com.blued.android.module.live_china.view.LiveLightScanView$3  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveLightScanView$3.class */
    class AnonymousClass3 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LiveLightScanView f14499a;

        @Override // java.lang.Runnable
        public void run() {
            if (this.f14499a.b != null && this.f14499a.b.isRunning()) {
                this.f14499a.b.cancel();
            }
            this.f14499a.b();
            this.f14499a.b.start();
        }
    }

    public LiveLightScanView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14495c = 1000L;
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.live_light_scan_view, this);
        ImageView imageView = (ImageView) findViewById(R.id.iv_light);
        this.f14494a = imageView;
        imageView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        final int width = getWidth();
        final int i = -width;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.b = ofFloat;
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        this.b.setDuration(this.f14495c);
        this.b.addListener(new Animator.AnimatorListener() { // from class: com.blued.android.module.live_china.view.LiveLightScanView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LiveLightScanView.this.f14494a.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LiveLightScanView.this.f14494a.setVisibility(0);
            }
        });
        this.b.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.LiveLightScanView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ImageView imageView = LiveLightScanView.this.f14494a;
                int i2 = width;
                int i3 = i;
                imageView.setX(((i2 - i3) * floatValue) + i3);
            }
        });
    }

    public void setDuration(int i) {
        this.f14495c = i;
    }

    public void setImage(int i) {
        this.f14494a.setImageResource(i);
    }
}
