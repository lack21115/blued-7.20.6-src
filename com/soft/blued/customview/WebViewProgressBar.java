package com.soft.blued.customview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/WebViewProgressBar.class */
public class WebViewProgressBar extends ProgressBar {
    private static int b = 95;

    /* renamed from: c  reason: collision with root package name */
    private static int f14851c = 100;

    /* renamed from: a  reason: collision with root package name */
    private Context f14852a;
    private ValueAnimator d;

    public WebViewProgressBar(Context context) {
        super(context);
        a(context);
    }

    public WebViewProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public WebViewProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRealProgress(int i) {
        super.setProgress(i);
    }

    public void a(Context context) {
        this.f14852a = context;
        ValueAnimator ofInt = ValueAnimator.ofInt(0, b);
        this.d = ofInt;
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.customview.WebViewProgressBar.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                WebViewProgressBar.this.setRealProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        this.d.setDuration(10000L);
        this.d.setInterpolator(new DecelerateInterpolator());
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setMax(f14851c);
        try {
            setProgressDrawable(this.f14852a.getResources().getDrawable(R.drawable.color_progress_bar));
        } catch (Exception e) {
        }
        this.d.start();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.d.cancel();
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int i) {
        synchronized (this) {
            if (i >= b) {
                if (this.d.isRunning()) {
                    this.d.cancel();
                }
                int progress = getProgress();
                ValueAnimator ofInt = ValueAnimator.ofInt(progress, progress + (i - progress));
                this.d = ofInt;
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.customview.WebViewProgressBar.2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        WebViewProgressBar.this.setRealProgress(intValue);
                        if (intValue != WebViewProgressBar.f14851c) {
                            WebViewProgressBar.this.setVisibility(0);
                            return;
                        }
                        WebViewProgressBar.this.setVisibility(8);
                        WebViewProgressBar.this.d.cancel();
                    }
                });
                this.d.setDuration(200L);
                this.d.setInterpolator(new DecelerateInterpolator());
                this.d.start();
            } else {
                setVisibility(0);
            }
        }
    }
}
