package com.scwang.smartrefresh.layout.internal;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.view.animation.LinearInterpolator;

/* loaded from: source-8303388-dex2jar.jar:com/scwang/smartrefresh/layout/internal/ProgressDrawable.class */
public class ProgressDrawable extends PaintDrawable implements ValueAnimator.AnimatorUpdateListener, Animatable {
    protected ValueAnimator e;
    protected int b = 0;

    /* renamed from: c  reason: collision with root package name */
    protected int f14308c = 0;
    protected int d = 0;
    protected Path f = new Path();

    public ProgressDrawable() {
        ValueAnimator ofInt = ValueAnimator.ofInt(30, 3600);
        this.e = ofInt;
        ofInt.setDuration(10000L);
        this.e.setInterpolator(new LinearInterpolator());
        this.e.setRepeatCount(-1);
        this.e.setRepeatMode(1);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int i;
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        int max = Math.max(1, width / 20);
        if (this.b != width || this.f14308c != height) {
            this.f.reset();
            float f = width - max;
            float f2 = height / 2;
            float f3 = max;
            this.f.addCircle(f, f2, f3, Path.Direction.CW);
            float f4 = width - (max * 5);
            this.f.addRect(f4, i - max, f, i + max, Path.Direction.CW);
            this.f.addCircle(f4, f2, f3, Path.Direction.CW);
            this.b = width;
            this.f14308c = height;
        }
        canvas.save();
        float f5 = width / 2;
        float f6 = height / 2;
        canvas.rotate(this.d, f5, f6);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 12) {
                canvas.restore();
                return;
            }
            this.f14307a.setAlpha((i3 + 5) * 17);
            canvas.rotate(30.0f, f5, f6);
            canvas.drawPath(this.f, this.f14307a);
            i2 = i3 + 1;
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.e.isRunning();
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.d = (((Integer) valueAnimator.getAnimatedValue()).intValue() / 30) * 30;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.e.isRunning()) {
            return;
        }
        this.e.addUpdateListener(this);
        this.e.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.e.isRunning()) {
            this.e.removeAllListeners();
            this.e.removeAllUpdateListeners();
            this.e.cancel();
        }
    }
}
