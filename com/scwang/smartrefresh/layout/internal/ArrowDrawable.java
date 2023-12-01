package com.scwang.smartrefresh.layout.internal;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;

/* loaded from: source-8303388-dex2jar.jar:com/scwang/smartrefresh/layout/internal/ArrowDrawable.class */
public class ArrowDrawable extends PaintDrawable {
    private int b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f27994c = 0;
    private Path d = new Path();

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        if (this.b != width || this.f27994c != height) {
            int i = (width * 30) / 225;
            this.d.reset();
            double d = i;
            float sin = (float) (Math.sin(0.7853981633974483d) * d);
            float sin2 = (float) (d / Math.sin(0.7853981633974483d));
            int i2 = width / 2;
            float f = i2;
            float f2 = height;
            this.d.moveTo(f, f2);
            float f3 = height / 2;
            this.d.lineTo(0.0f, f3);
            float f4 = f3 - sin;
            this.d.lineTo(sin, f4);
            int i3 = i / 2;
            float f5 = i2 - i3;
            float f6 = (f2 - sin2) - i3;
            this.d.lineTo(f5, f6);
            this.d.lineTo(f5, 0.0f);
            float f7 = i2 + i3;
            this.d.lineTo(f7, 0.0f);
            this.d.lineTo(f7, f6);
            float f8 = width;
            this.d.lineTo(f8 - sin, f4);
            this.d.lineTo(f8, f3);
            this.d.close();
            this.b = width;
            this.f27994c = height;
        }
        canvas.drawPath(this.d, this.f27995a);
    }
}
