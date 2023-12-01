package com.soft.blued.customview.rangebar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.TypedValue;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/rangebar/Bar.class */
class Bar {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f28618a;
    private final float b;

    /* renamed from: c  reason: collision with root package name */
    private final float f28619c;
    private final float d;
    private int e;
    private float f;
    private final float g;
    private final float h;
    private final float i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bar(Context context, float f, float f2, float f3, int i, float f4, float f5, int i2) {
        this.b = f;
        this.f28619c = f + f3;
        this.d = f2;
        int i3 = i - 1;
        this.e = i3;
        this.f = f3 / i3;
        float applyDimension = TypedValue.applyDimension(1, f4, context.getResources().getDisplayMetrics());
        this.g = applyDimension;
        float f6 = this.d;
        this.h = f6 - (applyDimension / 2.0f);
        this.i = f6 + (applyDimension / 2.0f);
        Paint paint = new Paint();
        this.f28618a = paint;
        paint.setColor(i2);
        this.f28618a.setStrokeWidth(f5);
        this.f28618a.setAntiAlias(true);
    }

    private void b(Canvas canvas) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.e) {
                float f = this.f28619c;
                canvas.drawLine(f, this.h, f, this.i, this.f28618a);
                return;
            }
            float f2 = (i2 * this.f) + this.b;
            canvas.drawLine(f2, this.h, f2, this.i, this.f28618a);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float a() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float a(Thumb thumb) {
        float b = this.b + (b(thumb) * this.f);
        if (b < a()) {
            return a();
        }
        float f = b;
        if (b > b()) {
            f = b();
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Canvas canvas) {
        float f = this.b;
        float f2 = this.d;
        canvas.drawLine(f, f2, this.f28619c, f2, this.f28618a);
        b(canvas);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float b() {
        return this.f28619c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(Thumb thumb) {
        float b = thumb.b();
        float f = this.b;
        float f2 = this.f;
        return (int) (((b - f) + (f2 / 2.0f)) / f2);
    }
}
