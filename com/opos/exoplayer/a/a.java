package com.opos.exoplayer.a;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/a/a.class */
public final class a extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private float f11299a;
    private int b;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 0;
    }

    public void a(float f) {
        if (this.f11299a != f) {
            this.f11299a = f;
            requestLayout();
        }
    }

    public void a(int i) {
        if (this.b != i) {
            this.b = i;
            requestLayout();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.b == 3 || this.f11299a <= 0.0f) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f = measuredWidth;
        float f2 = measuredHeight;
        float f3 = (this.f11299a / (f / f2)) - 1.0f;
        if (Math.abs(f3) > 0.01f) {
            int i3 = this.b;
            if (i3 != 1) {
                if (i3 != 2) {
                    int i4 = (f3 > 0.0f ? 1 : (f3 == 0.0f ? 0 : -1));
                    if (i3 == 4) {
                    }
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
                }
                measuredWidth = (int) (f2 * this.f11299a);
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
            }
            measuredHeight = (int) (f / this.f11299a);
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
        }
    }
}
