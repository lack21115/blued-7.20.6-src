package com.anythink.basead.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/ScanningAnimTextView.class */
public class ScanningAnimTextView extends TextView {

    /* renamed from: a  reason: collision with root package name */
    ValueAnimator f6170a;

    public ScanningAnimTextView(Context context) {
        super(context);
    }

    public ScanningAnimTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private static void a() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        startAnimation();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnimation();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (isShown() && i == 0) {
            startAnimation();
        } else {
            stopAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (isShown() && i == 0) {
            startAnimation();
        } else {
            stopAnimation();
        }
    }

    public void startAnimation() {
        if (this.f6170a == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.95f);
            this.f6170a = ofFloat;
            ofFloat.setDuration(500L);
            this.f6170a.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.anythink.basead.ui.ScanningAnimTextView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    ScanningAnimTextView.this.setScaleX(floatValue);
                    ScanningAnimTextView.this.setScaleY(floatValue);
                }
            });
            this.f6170a.setRepeatMode(2);
            this.f6170a.setRepeatCount(-1);
        }
        if (this.f6170a.isStarted()) {
            return;
        }
        this.f6170a.start();
    }

    public void stopAnimation() {
        ValueAnimator valueAnimator = this.f6170a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }
}
