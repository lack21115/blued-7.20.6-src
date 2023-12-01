package com.blued.android.module.live_china.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/WaveView.class */
public class WaveView extends View {

    /* renamed from: a  reason: collision with root package name */
    private float f15308a;
    private float b;

    /* renamed from: c  reason: collision with root package name */
    private long f15309c;
    private int d;
    private float e;
    private boolean f;
    private boolean g;
    private long h;
    private List<Circle> i;
    private Runnable j;
    private Interpolator k;
    private Paint l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/WaveView$Circle.class */
    public class Circle {
        private long b = System.currentTimeMillis();

        Circle() {
        }

        int a() {
            return (int) (255.0f - (WaveView.this.k.getInterpolation((b() - WaveView.this.f15308a) / (WaveView.this.b - WaveView.this.f15308a)) * 255.0f));
        }

        float b() {
            return WaveView.this.f15308a + (WaveView.this.k.getInterpolation((((float) (System.currentTimeMillis() - this.b)) * 1.0f) / ((float) WaveView.this.f15309c)) * (WaveView.this.b - WaveView.this.f15308a));
        }
    }

    public WaveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15309c = 2000L;
        this.d = 500;
        this.e = 0.85f;
        this.i = new ArrayList();
        this.j = new Runnable() { // from class: com.blued.android.module.live_china.view.WaveView.1
            @Override // java.lang.Runnable
            public void run() {
                if (WaveView.this.g) {
                    WaveView.this.b();
                    WaveView waveView = WaveView.this;
                    waveView.postDelayed(waveView.j, WaveView.this.d);
                }
            }
        };
        this.k = new LinearInterpolator();
        this.l = new Paint(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.h < this.d) {
            return;
        }
        this.i.add(new Circle());
        invalidate();
        this.h = currentTimeMillis;
    }

    public void a() {
        this.g = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Iterator<Circle> it = this.i.iterator();
        while (it.hasNext()) {
            Circle next = it.next();
            float b = next.b();
            if (System.currentTimeMillis() - next.b < this.f15309c) {
                this.l.setAlpha(next.a());
                canvas.drawCircle(getWidth() / 2, getHeight() / 2, b, this.l);
            } else {
                it.remove();
            }
        }
        if (this.i.size() > 0) {
            postInvalidateDelayed(10L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        if (this.f) {
            return;
        }
        this.b = (Math.min(i, i2) * this.e) / 2.0f;
    }

    public void setColor(int i) {
        this.l.setColor(i);
    }

    public void setDuration(long j) {
        this.f15309c = j;
    }

    public void setInitialRadius(float f) {
        this.f15308a = f;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.k = interpolator;
        if (interpolator == null) {
            this.k = new LinearInterpolator();
        }
    }

    public void setMaxRadius(float f) {
        this.b = f;
        this.f = true;
    }

    public void setMaxRadiusRate(float f) {
        this.e = f;
    }

    public void setSpeed(int i) {
        this.d = i;
    }

    public void setStyle(Paint.Style style) {
        this.l.setStyle(style);
    }
}
