package com.anythink.basead.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/ScanningAnimButton.class */
public class ScanningAnimButton extends Button {

    /* renamed from: a  reason: collision with root package name */
    ValueAnimator f6168a;

    public ScanningAnimButton(Context context, AttributeSet attributeSet) {
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
        if (this.f6168a == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.95f);
            this.f6168a = ofFloat;
            ofFloat.setDuration(500L);
            this.f6168a.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.anythink.basead.ui.ScanningAnimButton.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    ScanningAnimButton.this.setScaleX(floatValue);
                    ScanningAnimButton.this.setScaleY(floatValue);
                }
            });
            this.f6168a.setRepeatMode(2);
            this.f6168a.setRepeatCount(-1);
        }
        if (this.f6168a.isStarted()) {
            return;
        }
        this.f6168a.start();
    }

    public void stopAnimation() {
        ValueAnimator valueAnimator = this.f6168a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }
}
