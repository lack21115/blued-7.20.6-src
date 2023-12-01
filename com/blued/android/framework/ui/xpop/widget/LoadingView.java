package com.blued.android.framework.ui.xpop.widget;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.blued.android.framework.ui.xpop.util.XPopupUtils;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/widget/LoadingView.class */
public class LoadingView extends View {

    /* renamed from: a  reason: collision with root package name */
    int f10033a;
    float b;

    /* renamed from: c  reason: collision with root package name */
    int f10034c;
    float d;
    float e;
    float f;
    float g;
    private Paint h;
    private float i;
    private float j;
    private float k;
    private ArgbEvaluator l;
    private int m;
    private int n;
    private Runnable o;

    public LoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = 2.0f;
        this.l = new ArgbEvaluator();
        this.m = Color.parseColor("#DDDDDD");
        this.n = Color.parseColor("#333333");
        this.f10033a = 12;
        this.b = 360.0f / 12;
        this.f10034c = 0;
        this.o = new Runnable() { // from class: com.blued.android.framework.ui.xpop.widget.LoadingView.1
            @Override // java.lang.Runnable
            public void run() {
                LoadingView.this.f10034c++;
                LoadingView loadingView = LoadingView.this;
                loadingView.postInvalidate(0, 0, loadingView.getMeasuredWidth(), LoadingView.this.getMeasuredHeight());
            }
        };
        this.h = new Paint(1);
        float a2 = XPopupUtils.a(context, this.k);
        this.k = a2;
        this.h.setStrokeWidth(a2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.o);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = this.f10033a;
        while (true) {
            int i2 = i - 1;
            if (i2 < 0) {
                postDelayed(this.o, 60L);
                return;
            }
            int abs = Math.abs(this.f10034c + i2);
            int i3 = this.f10033a;
            this.h.setColor(((Integer) this.l.evaluate((((abs % i3) + 1) * 1.0f) / i3, Integer.valueOf(this.m), Integer.valueOf(this.n))).intValue());
            float f = this.f;
            float f2 = this.e;
            canvas.drawLine(f, f2, this.g, f2, this.h);
            canvas.drawCircle(this.f, this.e, this.k / 2.0f, this.h);
            canvas.drawCircle(this.g, this.e, this.k / 2.0f, this.h);
            canvas.rotate(this.b, this.d, this.e);
            i = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float measuredWidth = getMeasuredWidth() / 2;
        this.i = measuredWidth;
        this.j = measuredWidth / 2.5f;
        this.d = getMeasuredWidth() / 2;
        this.e = getMeasuredHeight() / 2;
        float measuredWidth2 = this.k * ((getMeasuredWidth() * 1.0f) / XPopupUtils.a(getContext(), 30.0f));
        this.k = measuredWidth2;
        this.h.setStrokeWidth(measuredWidth2);
        float f = this.d + this.j;
        this.f = f;
        this.g = f + (this.i / 3.0f);
        removeCallbacks(this.o);
    }
}
